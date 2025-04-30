package com.practice.exercise.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.practice.exercise.domain.Product;

@Repository
public class ProductRepository {
    // Agrega 20 products con datos de ejemplo
  
    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1L, "Laptop Dell XPS", "Electrónica", 1200.00, 15));
        products.add(new Product(2L, "iPhone 14", "Electrónica", 999.99, 25));
        products.add(new Product(3L, "Samsung Galaxy S23", "Electrónica", 899.99, 30));
        products.add(new Product(4L, "Monitor LG UltraWide", "Electrónica", 399.99, 20));
        products.add(new Product(5L, "Teclado mecánico Logitech", "Accesorios", 129.99, 50));
        products.add(new Product(6L, "Mouse inalámbrico MX Master 3", "Accesorios", 99.99, 60));
        products.add(new Product(7L, "Tablet iPad Air", "Electrónica", 599.99, 18));
        products.add(new Product(8L, "Smartwatch Samsung Galaxy Watch", "Wearables", 249.99, 35));
        products.add(new Product(9L, "Auriculares Sony WH-1000XM5", "Audio", 349.99, 22));
        products.add(new Product(10L, "Disco SSD Samsung 1TB", "Almacenamiento", 139.99, 40));
        products.add(new Product(11L, "Impresora HP LaserJet", "Oficina", 199.99, 10));
        products.add(new Product(12L, "Cámara Canon EOS M50", "Fotografía", 749.99, 12));
        products.add(new Product(13L, "Router TP-Link WiFi 6", "Redes", 89.99, 25));
        products.add(new Product(14L, "Silla ergonómica de oficina", "Muebles", 299.99, 8));
        products.add(new Product(15L, "Disco duro externo Seagate 2TB", "Almacenamiento", 89.99, 45));
        products.add(new Product(16L, "Lámpara LED de escritorio", "Hogar", 39.99, 70));
        products.add(new Product(17L, "Cargador portátil Anker", "Accesorios", 49.99, 55));
        products.add(new Product(18L, "Altavoz Bluetooth JBL", "Audio", 119.99, 33));
        products.add(new Product(19L, "Soporte para laptop ajustable", "Accesorios", 34.99, 44));
        products.add(new Product(20L, "Micrófono USB Blue Yeti", "Audio", 129.99, 17));
    }

    public List<Product> findAll() {
        return products;
    }
}
