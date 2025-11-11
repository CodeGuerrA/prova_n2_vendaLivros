package com.projetoTesteSoftware.vendasLivros.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookCreationFlowSeleniumTest {

    private static WebDriver driver;
    private static String baseUrl = "http://localhost:8082";
    private static String createdAuthorId;
    private static String createdStockId;
    private static String createdClientId;
    private static String createdBookId;
    private static String createdTempBookId; // ← Para o livro temporário

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Digita texto "como humano"
    private void humanType(By locator, String text, int delayMillis) throws InterruptedException {
        WebElement element = driver.findElement(locator);
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            Thread.sleep(delayMillis);
        }
    }

    @Test
    @Order(1)
    public void createAuthor() throws InterruptedException {
        driver.get(baseUrl + "/author_new.html");
        humanType(By.id("name"), "Machado de Assis", 150);
        driver.findElement(By.id("saveButton")).click();
        Thread.sleep(1000);

        createdAuthorId = driver.findElement(By.id("authorId")).getText();
        Assertions.assertNotNull(createdAuthorId);
        System.out.println("Autor criado com ID: " + createdAuthorId);
    }

    @Test
    @Order(2)
    public void createStock() throws InterruptedException {
        driver.get(baseUrl + "/stock_new.html");
        humanType(By.id("location"), "Depósito Central", 150);
        humanType(By.id("capacity"), "1000", 100);
        driver.findElement(By.id("saveButton")).click();
        Thread.sleep(1000);

        createdStockId = driver.findElement(By.id("stockId")).getText();
        Assertions.assertNotNull(createdStockId);
        System.out.println("Estoque criado com ID: " + createdStockId);
    }

    @Test
    @Order(3)
    public void createBook() throws InterruptedException {
        driver.get(baseUrl + "/book_new.html");
        humanType(By.id("title"), "Dom Casmurro", 150);
        humanType(By.id("isbn"), "1234567890123", 100);
        humanType(By.id("price"), "39.90", 100);
        humanType(By.id("quantityInStock"), "50", 100);
        humanType(By.id("authorId"), createdAuthorId, 100);
        humanType(By.id("stockId"), createdStockId, 100);
        driver.findElement(By.id("saveButton")).click();
        Thread.sleep(1000);

        createdBookId = driver.findElement(By.id("bookId")).getText();
        Assertions.assertNotNull(createdBookId);
        System.out.println("Livro criado com ID: " + createdBookId);
    }

    @Test
    @Order(4)
    public void createClient() throws InterruptedException {
        driver.get(baseUrl + "/client_new.html");
        humanType(By.id("name"), "João da Silva", 150);
        driver.findElement(By.id("saveButton")).click();
        Thread.sleep(1000);

        createdClientId = driver.findElement(By.id("clientId")).getText();
        Assertions.assertNotNull(createdClientId);
        System.out.println("Cliente criado com ID: " + createdClientId);
    }

    @Test
    @Order(5)
    public void createSale() throws InterruptedException {
        driver.get(baseUrl + "/sale_new.html");
        humanType(By.id("clientId"), createdClientId, 150);
        humanType(By.id("bookId"), createdBookId, 150);
        humanType(By.id("quantity"), "2", 100);
        driver.findElement(By.id("saveButton")).click();
        Thread.sleep(1000);

        String createdSaleId = driver.findElement(By.id("saleId")).getText();
        Assertions.assertNotNull(createdSaleId, "ID da venda não pode ser nulo");
        System.out.println("Venda criada com ID: " + createdSaleId);
    }

    @Test
    @Order(6)
    public void updateBook() throws InterruptedException {
        driver.get(baseUrl + "/book_update.html");
        humanType(By.id("bookId"), createdBookId, 150);
        humanType(By.id("authorId"), createdAuthorId, 150);
        humanType(By.id("stockId"), createdStockId, 150);
        humanType(By.id("title"), "Livro Atualizado", 150);
        humanType(By.id("isbn"), "1234567890", 150);
        humanType(By.id("price"), "49.99", 150);
        humanType(By.id("quantity"), "10", 150);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);

        String updatedTitle = driver.findElement(By.xpath("//div[@id='updateResult']/p[2]")).getText();
        Assertions.assertTrue(updatedTitle.contains("Livro Atualizado"));
        System.out.println("Livro atualizado com sucesso!");
    }

    @Test
    @Order(7)
    public void createTemporaryBook() throws InterruptedException {
        driver.get(baseUrl + "/book_new.html");
        humanType(By.id("title"), "Livro Temporário", 150);
        humanType(By.id("isbn"), "9999999999999", 100);
        humanType(By.id("price"), "29.99", 100);
        humanType(By.id("quantityInStock"), "20", 100);
        humanType(By.id("authorId"), createdAuthorId, 100);
        humanType(By.id("stockId"), createdStockId, 100);
        driver.findElement(By.id("saveButton")).click();
        Thread.sleep(1000);

        createdTempBookId = driver.findElement(By.id("bookId")).getText();
        Assertions.assertNotNull(createdTempBookId);
        System.out.println("Livro temporário criado com ID: " + createdTempBookId);
    }

    @Test
    @Order(8)
    public void deleteTemporaryBook() throws InterruptedException {
        Assertions.assertNotNull(createdTempBookId, "ID do livro temporário não foi criado");

        driver.get(baseUrl + "/book_delete.html");
        humanType(By.id("bookId"), createdTempBookId, 150);
        driver.findElement(By.id("deleteButton")).click();
        Thread.sleep(1000);

        String resultText = driver.findElement(By.id("deleteResult")).getText();
        Assertions.assertTrue(resultText.contains("deletado") || resultText.contains("sucesso"));
        System.out.println("Livro deletado com sucesso: ID " + createdTempBookId);
    }
}
