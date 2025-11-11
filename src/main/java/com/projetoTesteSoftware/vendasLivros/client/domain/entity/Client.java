package com.projetoTesteSoftware.vendasLivros.client.domain.entity;

import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_client")
    private String name;

    @OneToMany(mappedBy = "client")
    private List<Sale> sales = new ArrayList<>();
}