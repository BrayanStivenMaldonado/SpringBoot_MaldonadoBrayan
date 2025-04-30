package com.practice.exercise.Controller;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.exercise.Repository.ProductRepository;
import com.practice.exercise.domain.Product;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductRepository repo;
    public ProductController(ProductRepository repo) { this.repo = repo; }

    @GetMapping("/products")
    public List<Product> getProducts(
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice,
        @RequestParam(required = false) String category,
        @RequestParam(defaultValue = "0") int page, //grupo que se va a mostrar
        @RequestParam(defaultValue = "10") int size //cantidad de elementos que van en cada grupo
    ) {

        int skip = page * size;
      	//Aplica los filtros de minPrice, maxPrice y category, recuerda que pueden aplicarse todos o ninguno
        List<Product> listadoFiltrado = repo.findAll().stream()
            .filter(p -> minPrice == null || p.getPrice() >= minPrice) //se filtran los productos cuyo precio sea mayor o igual al ingresado en el @RequestParam de minPrice (eso si el price no es nulo)
            .filter(p -> maxPrice == null || p.getPrice() <= maxPrice) //Aquí se filtran los productos cuyo precio sea mayot o igual al ingresado en el parametro de maxPrice (eso si el price no es nulo)
            .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category)) //se filtra por categoria (si category no es nulo) y se ignora entre mayúsculas y minúsculas
            .skip(skip) //se saltan los primeros page*size que son el tamaño de la pagina(por ejemplo si es 2*2 se saltan los primeros 4 elementos)
            .limit(size) //se limita el resultado a "size" elementos (número de productos por página)
            .toList(); //convertimos el stream filtrado y paginado en una lista 
        return listadoFiltrado; //se retorna la lista filtrada        
    }

    @GetMapping("/products/stats")
    public Map<String, Double> getStats(
        @RequestParam(required = false) String category
    ) {
    
    //Obtenga el listado de productos filtrados por categoría

    DoubleSummaryStatistics statistics = repo.findAll().stream() // Calculamos estadísticas sobre los precios de los productos, filtrando opcionalmente por categoría
            .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))// Si se proporciona un categoria solo se incluyec los productos que coinciden (ignorando mayuscuslas y minusculas)
            .mapToDouble(p -> p.getPrice())// Convertimos cada producto en su valor de precio, obteniendo un DoubleStream
            .summaryStatistics();// Generamos las estadisticas (count, sum, min, max, average)
        //Devolvemos un mapa con los resultados estadisticos
        return Map.of(
            "count", (double) statistics.getCount(), 
            "avgPrice", statistics.getAverage(), 
            "minPrice", statistics.getMin(), 
            "maxPrice", statistics.getMax(),
            "totalValue", statistics.getSum()
        );
    }
}
