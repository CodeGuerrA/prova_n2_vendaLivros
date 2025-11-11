package com.projetoTesteSoftware.vendasLivros.sale.application.usecase;


import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;
import com.projetoTesteSoftware.vendasLivros.sale.domain.port.SaleRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.book.domain.port.BookRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CreateSaleCase {

    private final SaleRepositoryPort saleRepositoryPort;
    private final BookRepositoryPort bookRepositoryPort;

    public Sale create(Sale sale) {

        sale.setSaleDate(LocalDateTime.now());

        BigDecimal total = BigDecimal.ZERO;

        for (var item : sale.getItems()) {

            var book = bookRepositoryPort.findbyID(item.getBook().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado!"));

            if (book.getQuantityInStock() < item.getQuantity()) {
                throw new EntityNotFoundException("Estoque insuficiente do livro: " + book.getTitle());
            }

            // Atualiza o estoque
            int novaQtde = book.getQuantityInStock() - item.getQuantity();
            book.setQuantityInStock(novaQtde);
            bookRepositoryPort.save(book);

            // Congela preço no item da venda
            item.setSale(sale);
            item.setPrice(book.getPrice());

            // Soma total
            total = total.add(
                    book.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
            );
        }

        sale.setTotalAmount(total);
        return saleRepositoryPort.save(sale);
    }
}

