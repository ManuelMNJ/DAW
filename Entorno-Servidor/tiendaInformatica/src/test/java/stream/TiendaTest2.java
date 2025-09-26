package stream;

import jakarta.persistence.EntityManager;
import org.iesbelen.tiendainformatica.dao.FabricanteDAO;
import org.iesbelen.tiendainformatica.dao.FabricanteDAOImpl;
import org.iesbelen.tiendainformatica.dao.ProductoDAO;
import org.iesbelen.tiendainformatica.dao.ProductoDAOImpl;
import org.iesbelen.tiendainformatica.entity.Fabricante;
import org.iesbelen.tiendainformatica.entity.Producto;
import org.iesbelen.tiendainformatica.util.JPAUtil;
import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TiendaTest2 {

    // Obtenemos un EntityManager de nuestra clase de utilidad JPA
    private static EntityManager em = JPAUtil.getEntityManager();

    // Los DAOs son estáticos para poder usarlos en @BeforeAll
    private static FabricanteDAO fabricantesDAO = new FabricanteDAOImpl(em);
    private static ProductoDAO productosDAO = new ProductoDAOImpl(em);

    @BeforeAll
    static void setUpAll() {
        System.out.println("Inicializando datos de la base de datos...");
        ((FabricanteDAOImpl) fabricantesDAO).beginTransaction();
        try {
            // Asus
            Fabricante asus = new Fabricante("Asus");
            fabricantesDAO.create(asus); // Guardamos primero el fabricante para que tenga un ID

            Producto monitor27 = new Producto(asus, "Monitor 27 LED Full HD", 199.25);
            asus.addProducto(monitor27);    // Sincronizamos
            productosDAO.create(monitor27); // Guardamos el producto
            Producto monitor24 = new Producto(asus, "Monitor 24 LED Full HD", 119.99);
            asus.addProducto(monitor24);    // Sincronizamos
            productosDAO.create(monitor24); // Guardamos el producto
            Producto monitor21 = new Producto(asus, "Monitor 21 LED Full HD", 109.99);
            asus.addProducto(monitor21);    // Sincronizamos
            productosDAO.create(monitor21); // Guardamos el producto


            // Lenovo
            Fabricante lenovo = new Fabricante("Lenovo");
            fabricantesDAO.create(lenovo);

            Producto portatil1 = new Producto(lenovo, "Portátil IdeaPad 320", 359.65);
            lenovo.addProducto(portatil1);
            productosDAO.create(portatil1);
            Producto portatil2 = new Producto(lenovo, "Portátil Yoga 520", 452.79);
            lenovo.addProducto(portatil2);
            productosDAO.create(portatil2);


            // Hewlett-Packard
            Fabricante hewlettPackard = new Fabricante("Hewlett-Packard");
            fabricantesDAO.create(hewlettPackard);

            Producto impresora1 = new Producto(hewlettPackard, "Impresora HP Deskjet 3720", 59.99);
            hewlettPackard.addProducto(impresora1);
            productosDAO.create(impresora1);
            Producto impresora2 = new Producto(hewlettPackard, "Impresora HP Laserjet Pro M26nw", 111.86);
            hewlettPackard.addProducto(impresora2);
            productosDAO.create(impresora2);


            // Samsung
            Fabricante samsung = new Fabricante("Samsung");
            fabricantesDAO.create(samsung);

            Producto disco1 = new Producto(samsung, "Disco SSD 1 TB", 72.99);
            samsung.addProducto(disco1);
            productosDAO.create(disco1);


            // Seagate
            Fabricante seagate = new Fabricante("Seagate");
            fabricantesDAO.create(seagate);

            Producto disco2 = new Producto(seagate, "Disco SSD SATA3 1TB", 38.49);
            seagate.addProducto(disco2);
            productosDAO.create(disco2);


            // Crucial
            Fabricante crucial = new Fabricante("Crucial");
            fabricantesDAO.create(crucial);

            Producto memoria1 = new Producto(crucial, "GeForce GTX 1080 Xtreme", 611.55);
            crucial.addProducto(memoria1);
            productosDAO.create(memoria1);
            Producto memoria2 = new Producto(crucial, "Memoria RAM DDR4 8GB", 24.19);
            crucial.addProducto(memoria2);
            productosDAO.create(memoria2);


            // Gigabyte
            Fabricante gigabyte = new Fabricante("Gigabyte");
            fabricantesDAO.create(gigabyte);

            Producto tarjeta1 = new Producto(gigabyte, "GeForce GTX 1050Ti", 319.19);
            gigabyte.addProducto(tarjeta1);
            productosDAO.create(tarjeta1);


            //Huawei
            fabricantesDAO.create(new Fabricante("Huawei"));


            // Xiaomi
            fabricantesDAO.create(new Fabricante("Xiaomi"));


            ((FabricanteDAOImpl) fabricantesDAO).commitTransaction();

        } catch (Exception e) {
            ((FabricanteDAOImpl) fabricantesDAO).rollbackTransaction();
            throw e;
        }
    }

    @BeforeEach
    void setUp() {
        ((FabricanteDAOImpl) fabricantesDAO).beginTransaction();
    }

    @AfterEach
    void tearDown() {
        ((FabricanteDAOImpl) fabricantesDAO).rollbackTransaction();
    }

    @AfterAll
    static void tearDownAll() {
        if (em != null) {
            em.close();
            System.out.println("\nEntityManager cerrado.");
        }
    }

    @Test
    @Order(0)
    void testAllFabricante() {

        List<Fabricante> listFab = fabricantesDAO.findAll();
        assertEquals(9, listFab.size());
    }

    @Test
    @Order(0)
    void testAllProducto() {

        List<Producto> listProd = productosDAO.findAll();
        assertEquals(11, listProd.size());
    }


    /**
     * 1. Lista los nombres y los precios de todos los productos de la tabla producto
     */
    @Test
    @Order(1)
    void test1() {

        List<Producto> listProd = productosDAO.findAll();

        listProd.stream()
                .map(prod -> prod.getNombre() + " - " + prod.getPrecio())
                .forEach(System.out::println);
    }

    /**
     * 2. Devuelve una lista de Producto completa con el precio de euros convertido a dólares.
     */
    @Test
    @Order(2)
    void test2() {

        List<Producto> listProd = productosDAO.findAll();
        final double TASA_CAMBIO_EUR_USD = 1.1;

        List<Producto> productosEnDolares = listProd.stream()
                .map(p -> new Producto(p.getFabricante(), p.getNombre(), p.getPrecio() * TASA_CAMBIO_EUR_USD))
                .toList();

        productosEnDolares.forEach(p -> System.out.printf("Producto: %s, Precio: $%.2f%n", p.getNombre(), p.getPrecio()));

    }

    /**
     * 3. Lista los nombres y los precios de todos los productos, convirtiendo los nombres a mayúscula.
     */
    @Test
    @Order(3)
    void test3() {

        List<Producto> listProd = productosDAO.findAll();

        listProd.stream()
                .map(prod -> prod.getNombre().toUpperCase() + " - Precio: " + prod.getPrecio())
                .forEach(System.out::println);

    }

    /**
     * 4. Lista el nombre de todos los fabricantes y a continuación en mayúsculas los dos primeros caracteres del nombre del fabricante.
     */
    @Test
    @Order(4)
    void test4() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        listFab.stream()
                .map(f -> f.getNombre() + " -> " + f.getNombre().substring(0, 2).toUpperCase())
                .forEach(System.out::println);

    }

    /**
     * 5. Lista el código de los fabricantes que tienen productos.
     */
    @Test
    @Order(5)
    void test5() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        listFab.stream()
                .filter(f -> f.getProductos() != null && !f.getProductos().isEmpty())
                .map(Fabricante::getIdFabricante)
                .forEach(System.out::println);
    }

    /**
     * 6. Lista los nombres de los fabricantes ordenados de forma descendente.
     */
    @Test
    @Order(6)
    void test6() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        listFab.stream()
                .map(Fabricante::getNombre)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    /**
     * 7. Lista los nombres de los productos ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar por el precio de forma descendente.
     */
    @Test
    @Order(7)
    void test7() {

        List<Producto> listProd = productosDAO.findAll();
        listProd.stream()
                .sorted(comparing(Producto::getNombre).thenComparing(Producto::getPrecio, Comparator.reverseOrder()))
                .map(Producto::getNombre)
                .forEach(System.out::println);
    }

    /**
     * 8. Devuelve una lista con los 5 primeros fabricantes.
     */
    @Test
    @Order(8)
    void test8() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        List<Fabricante> primeros5 = listFab.stream()
                .limit(5)
                .toList();

        System.out.println("5 primeros fabricantes: " + primeros5.stream().map(Fabricante::getNombre).toList());
    }

    /**
     * 9. Devuelve una lista con 2 fabricantes a partir del cuarto fabricante. El cuarto fabricante también se debe incluir en la respuesta.
     */
    @Test
    @Order(9)
    void test9() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        List<String> fabricantes = listFab.stream()
                .skip(3) // Salta los 3 primeros (1, 2, 3) para empezar en el 4º
                .limit(2)
                .map(Fabricante::getNombre)
                .toList();

        System.out.println("Fabricantes 4º y 5º: " + fabricantes);
    }

    /**
     * 10. Lista el nombre y el precio del producto más barato
     */
    @Test
    @Order(10)
    void test10() {

        List<Producto> listProd = productosDAO.findAll();

        Producto masBarato = listProd.stream()
                .min(comparing(Producto::getPrecio))
                .orElse(null);

        if (masBarato != null) {
            System.out.printf("Producto más barato: %s, Precio: %.2f€%n", masBarato.getNombre(), masBarato.getPrecio());
        } else {
            System.out.println("No se han encontrado el producto mas barato");
        }

    }

    /**
     * 11. Lista el nombre y el precio del producto más caro
     */
    @Test
    @Order(11)
    void test11() {

        List<Producto> listProd = productosDAO.findAll();
        Producto masCaro = listProd.stream()
                .max(comparing(Producto::getPrecio))
                .orElse(null);

        if (masCaro != null) {
            System.out.printf("Producto más caro: %s, Precio: %.2f€%n", masCaro.getNombre(), masCaro.getPrecio());
        } else {
            System.out.println("No se han encontrado el producto mas  caro");
        }
    }

    /**
     * 12. Lista el nombre de todos los productos del fabricante cuyo código de fabricante es igual a 2.
     */
    @Test
    @Order(12)
    void test12() {

        List<Producto> listProd = productosDAO.findAll();

        listProd.stream()
                .filter(p -> p.getFabricante().getIdFabricante() == 2) // Lenovo
                .map(Producto::getNombre)
                .forEach(System.out::println);
    }

    /**
     * 13. Lista el nombre de los productos que tienen un precio menor o igual a 120 €.
     */
    @Test
    @Order(13)
    void test13() {

        List<Producto> listProd = productosDAO.findAll();

        listProd.stream()
                .filter(p -> p.getPrecio() <= 120)
                .map(Producto::getNombre)
                .forEach(System.out::println);

    }

    /**
     * 14. Lista los productos que tienen un precio mayor o igual a 400 €.
     */
    @Test
    @Order(14)
    void test14() {

        List<Producto> listProd = productosDAO.findAll();

        listProd.stream()
                .filter(p -> p.getPrecio() >= 400)
                .forEach(System.out::println);
    }

    /**
     * 15. Lista todos los productos que tengan un precio entre 80 € y 300 €.
     */
    @Test
    @Order(15)
    void test15() {

        List<Producto> listProd = productosDAO.findAll();

        listProd.stream()
                .filter(p -> p.getPrecio() >= 80 && p.getPrecio() <= 300)
                .forEach(System.out::println);

    }

    /**
     * 16. Lista todos los productos que tengan un precio mayor que 200 € y que el código de fabricante sea igual a 6.
     */
    @Test
    @Order(16)
    void test16() {

        List<Producto> listProd = productosDAO.findAll();

        listProd.stream()
                .filter(p -> p.getPrecio() > 200 && p.getFabricante().getIdFabricante() == 6) // Crucial
                .forEach(System.out::println);

    }

    /**
     * 17. Lista todos los productos donde el código de fabricante sea 1, 3 o 5 utilizando un Set de codigos de fabricantes para filtrar.
     */
    @Test
    @Order(17)
    void test17() {

        List<Producto> listProd = productosDAO.findAll();

        Set<Integer> codigosFabricantes = Set.of(1, 3, 5); // Asus, HP, Seagate

        listProd.stream()
                .filter(p -> codigosFabricantes.contains(p.getFabricante().getIdFabricante()))
                .forEach(System.out::println);
    }

    /**
     * 18. Lista el nombre y el precio de los productos en céntimos.
     */
    @Test
    @Order(18)
    void test18() {

        List<Producto> listProd = productosDAO.findAll();

        listProd.stream()
                .map(p -> p.getNombre() + " - Precio en centimos: " + (int)(p.getPrecio() * 100))
                .forEach(System.out::println);
    }

    /**
     * 19. Lista los nombres de los fabricantes cuyo nombre empiece por la letra S
     */
    @Test
    @Order(19)
    void test19() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        listFab.stream()
                .map(Fabricante::getNombre)
                .filter(nombre -> nombre.startsWith("S"))
                .forEach(System.out::println);
    }

    /**
     * 20. Devuelve una lista con los productos que contienen la cadena Portátil en el nombre.
     */
    @Test
    @Order(20)
    void test20() {

        List<Producto> listProd = productosDAO.findAll();

        List<Producto> portatiles = listProd.stream()
                .filter(p -> p.getNombre().contains("Portátil"))
                .toList();

        portatiles.forEach(System.out::println);
    }

    /**
     * 21. Devuelve una lista con el nombre de todos los productos que contienen la cadena Monitor en el nombre y tienen un precio inferior a 150 €.
     */
    @Test
    @Order(21)
    void test21() {

        List<Producto> listProd = productosDAO.findAll();

        List<String> monitores = listProd.stream()
                .filter(p -> p.getNombre().contains("Monitor") && p.getPrecio() < 150)
                .map(Producto::getNombre)
                .toList();

        monitores.forEach(System.out::println);
    }

    /**
     * 22. Lista el nombre y el precio de todos los productos que tengan un precio mayor o igual a 180 €.
     * Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente).
     */
    @Test
    @Order(22)
    void test22() {

        List<Producto> listProd = productosDAO.findAll();

        listProd.stream()
                .filter(p -> p.getPrecio() >= 180)
                .sorted(comparing(Producto::getPrecio).reversed().thenComparing(Producto::getNombre))
                .forEach(System.out::println);
    }

    /**
     * 23. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos.
     * Ordene el resultado por el nombre del fabricante, por orden alfabético.
     */
    @Test
    @Order(23)
    void test23() {

        List<Producto> listProd = productosDAO.findAll();

        List<String> resultado = listProd.stream()
                .sorted(comparing(p -> p.getFabricante().getNombre()))
                .map(p -> String.format("%s - %.2f€ - %s", p.getNombre(), p.getPrecio(), p.getFabricante().getNombre()))
                .toList();

        resultado.forEach(System.out::println);
    }

    /**
     * 24. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.
     */
    @Test
    @Order(24)
    void test24() {

        List<Producto> listProd = productosDAO.findAll();

        String resultado = listProd.stream()
                .max(comparing(Producto::getPrecio))
                .map(p -> String.format("%s - %.2f€ - %s", p.getNombre(), p.getPrecio(), p.getFabricante().getNombre()))
                .orElse("No se encontró el producto más caro.");

        System.out.println("Producto más caro: " + resultado);
    }

    /**
     * 25. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200 €.
     */
    @Test
    @Order(25)
    void test25() {

        List<Producto> listProd = productosDAO.findAll();

        List<Producto> productos = listProd.stream()
                .filter(p -> p.getFabricante().getNombre().equals("Crucial") && p.getPrecio() > 200)
                .toList();

        productos.forEach(System.out::println);
    }

    /**
     * 26. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard y Seagate
     */
    @Test
    @Order(26)
    void test26() {

        List<Producto> listProd = productosDAO.findAll();

        Set<String> fabricantesBuscados = Set.of("Asus", "Hewlett-Packard", "Seagate");

        List<Producto> productos = listProd.stream()
                .filter(p -> fabricantesBuscados.contains(p.getFabricante().getNombre()))
                .toList();

        productos.forEach(p -> System.out.printf("%s (Fabricante: %s)%n", p.getNombre(), p.getFabricante().getNombre()));
    }

    /**
     * 27. Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos
     * que tengan un precio mayor o igual a 180 €. Ordene el resultado en primer lugar por el precio (en orden descendente)
     * y en segundo lugar por el nombre.
     *
     * La salida debe quedar tabulada como sigue:
     * <p>
     * Producto                   Precio      Fabricante
     * -----------------------------------------------------
     * GeForce GTX 1080 Xtreme   |611.55      |Crucial
     * Portátil Yoga 520         |452.79      |Lenovo
     * Portátil Ideapd 320       |359.65      |Lenovo
     * GeForce GTX 1050Ti        |319,19      |Gigabyte
     * Monitor 27 LED Full HD    |199.25      |Asus
     */
    @Test
    @Order(27)
    void test27() {

        List<Producto> listProd = productosDAO.findAll();

        List<Producto> productosFiltrados = listProd.stream()
                .filter(p -> p.getPrecio() >= 180)
                .sorted(comparing(Producto::getPrecio).reversed().thenComparing(Producto::getNombre))
                .toList();

        // Calcular longitudes máximas para el formato
        int maxNombre = productosFiltrados.stream().mapToInt(p -> p.getNombre().length()).max().orElse(0);
        int maxPrecio = productosFiltrados.stream().mapToInt(p -> String.format("%.2f", p.getPrecio()).length()).max().orElse(0);
        int maxFabricante = productosFiltrados.stream().mapToInt(p -> p.getFabricante().getNombre().length()).max().orElse(0);

        String formato = "%-" + (maxNombre + 2) + "s|%-" + (maxPrecio + 2) + "s|%s%n";
        System.out.printf(formato, "Producto", "Precio", "Fabricante");
        System.out.println("-".repeat(maxNombre + maxPrecio + maxFabricante + 6));

        productosFiltrados.forEach(p -> System.out.printf(formato, p.getNombre(), String.format("%.2f", p.getPrecio()), p.getFabricante().getNombre()));
    }

    /**
     * 28. Devuelve un listado de los nombres fabricantes que existen en la base de datos, junto con los nombres productos que tiene cada uno de ellos.
     * El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.
     * SOLO SE PUEDEN UTILIZAR STREAM, NO PUEDE HABER BUCLES
     */
    @Test
    @Order(28)
    void test28() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        listFab.stream()
                .sorted(comparing(Fabricante::getNombre))
                .forEach(f -> {
                    System.out.printf("Fabricante: %s%n", f.getNombre());
                    System.out.println("\tProductos:");
                    if (f.getProductos() != null && !f.getProductos().isEmpty()) {
                        f.getProductos().forEach(p -> System.out.println("\t\t" + p.getNombre()));
                    }
                    System.out.println();
                });
    }

    /**
     * 29. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
     */
    @Test
    @Order(29)
    void test29() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        List<String> sinProductos = listFab.stream()
                .filter(f -> f.getProductos() == null || f.getProductos().isEmpty())
                .map(Fabricante::getNombre)
                .toList();

        System.out.println("Fabricantes sin productos: " + sinProductos);
    }

    /**
     * 30. Calcula el número total de productos que hay en la tabla productos. Utiliza la api de stream
     */
    @Test
    @Order(30)
    void test30() {

        List<Producto> listProd = productosDAO.findAll();

        long totalProductos = listProd.stream().count();

        System.out.println("Número total de productos: " + totalProductos);
    }

    /**
     * 31. Calcula el número de fabricantes con productos, utilizando un stream de Productos.
     */
    @Test
    @Order(31)
    void test31() {

        List<Producto> listProd = productosDAO.findAll();

        long totalFabricantesConProductos = listProd.stream()
                .map(Producto::getFabricante)
                .distinct()
                .count();

        System.out.println("Número de fabricantes con productos: " + totalFabricantesConProductos);
    }

    /**
     * 32. Calcula la media del precio de todos los productos
     */
    @Test
    @Order(32)
    void test32() {

        List<Producto> listProd = productosDAO.findAll();

        double media = listProd.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);

        System.out.printf("La media de precios es: %.2f€%n", media);
    }

    /**
     * 33. Calcula el precio más barato de todos los productos. No se puede utilizar ordenación de stream.
     */
    @Test
    @Order(33)
    void test33() {

        List<Producto> listProd = productosDAO.findAll();

        double masBarato = listProd.stream()
                .mapToDouble(Producto::getPrecio)
                .min()
                .orElse(0.0);

        System.out.println("El precio más barato es: " + masBarato);
    }

    /**
     * 34. Calcula la suma de los precios de todos los productos.
     */
    @Test
    @Order(34)
    void test34() {

        List<Producto> listProd = productosDAO.findAll();

        double suma = listProd.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();

        System.out.printf("La suma de todos los precios es: %.2f€%n", suma);
    }

    /**
     * 35. Calcula el número de productos que tiene el fabricante Asus.
     */
    @Test
    @Order(35)
    void test35() {

        List<Producto> listProd = productosDAO.findAll();

        long numProductosAsus = listProd.stream()
                .filter(p -> p.getFabricante().getNombre().equals("Asus"))
                .count();

        System.out.println("Asus tiene " + numProductosAsus + " productos.");
    }

    /**
     * 36. Calcula la media del precio de todos los productos del fabricante Asus.
     */
    @Test
    @Order(36)
    void test36() {

        List<Producto> listProd = productosDAO.findAll();

        double mediaAsus = listProd.stream()
                .filter(p -> p.getFabricante().getNombre().equals("Asus"))
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);

        System.out.printf("La media de precios de Asus es: %.2f€%n", mediaAsus);
    }

    /**
     * 37. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el fabricante Crucial.
     * Realízalo en 1 solo stream principal. Utiliza reduce con Double[] como "acumulador".
     */
    @Test
    @Order(37)
    void test37() {

        List<Producto> listProd = productosDAO.findAll();

        // Acumulador: [0] = count, [1] = sum, [2] = min, [3] = max
        Double[] stats = listProd.stream()
                .filter(p -> p.getFabricante().getNombre().equals("Crucial"))
                .map(Producto::getPrecio)
                .reduce(new Double[]{0.0, 0.0, Double.MAX_VALUE, Double.MIN_VALUE},
                        (acc, precio) -> {
                            acc[0]++; // count
                            acc[1] += precio; // sum
                            acc[2] = Math.min(acc[2], precio); // min
                            acc[3] = Math.max(acc[3], precio); // max
                            return acc;
                        },
                        (acc1, acc2) -> acc1 // Combiner no es necesario en secuencial
                );

        double count = stats[0];
        double sum = stats[1];
        double min = stats[2];
        double max = stats[3];
        double avg = (count > 0) ? sum / count : 0.0;

        System.out.printf("Stats para Crucial: Total=%d, Mín=%.2f, Máx=%.2f, Media=%.2f%n",
                                            (int) count, min, max, avg);
    }

    /**
     * 38. Muestra el número total de productos que tiene cada uno de los fabricantes.
     * El listado también debe incluir los fabricantes que no tienen ningún producto.
     * El resultado mostrará dos columnas, una con el nombre del fabricante y otra con el número de productos que tiene.
     * Ordene el resultado descendentemente por el número de productos. Utiliza String.format para la alineación
     * de los nombres y las cantidades.
     */
    @Test
    @Order(38)
    void test38() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        Map<String, Integer> conteoPorFabricante = listFab.stream()
                .collect(Collectors.toMap(
                        Fabricante::getNombre,
                        f -> f.getProductos() != null ? f.getProductos().size() : 0
                ));

        int maxNombre = conteoPorFabricante.keySet().stream().mapToInt(String::length).max().orElse(0);
        String formato = "%-" + (maxNombre + 2) + "s| %s%n";

        System.out.printf(formato, "Fabricante", "#Productos");
        System.out.println("-".repeat(maxNombre + 14));

        conteoPorFabricante.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.printf(formato, entry.getKey(), entry.getValue()));
    }

    /**
     * 39. Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes.
     * El resultado mostrará el nombre del fabricante junto con los datos que se solicitan. Deben aparecer los fabricantes que no tienen productos.
     */
    @Test
    @Order(39)
    void test39() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        listFab.forEach(f -> {
            System.out.printf("Fabricante: %s%n", f.getNombre());
            if (f.getProductos() != null && !f.getProductos().isEmpty()) {
                DoubleSummaryStatistics stats = f.getProductos().stream()
                        .mapToDouble(Producto::getPrecio)
                        .summaryStatistics();
                System.out.printf("\tMín: %.2f€, Máx: %.2f€, Media: %.2f€%n",
                        stats.getMin(), stats.getMax(), stats.getAverage());
            } else {
                System.out.println("\tSin productos.");
            }
        });
    }

    /**
     * 40. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes
     * que tienen un precio medio superior a 200 €. No es necesario mostrar el nombre del fabricante,
     * con el código del fabricante es suficiente.
     */
    @Test
    @Order(40)
    void test40() {

        List<Producto> listProd = productosDAO.findAll();

        Map<Fabricante, DoubleSummaryStatistics> statsPorFabricante = listProd.stream()
                .collect(Collectors.groupingBy(
                        Producto::getFabricante,
                        Collectors.summarizingDouble(Producto::getPrecio)
                ));

        statsPorFabricante.entrySet().stream()
                .filter(entry -> entry.getValue().getAverage() > 200)
                .peek(entry -> {
                    System.out.printf("Fabricante ID: %d%n", entry.getKey().getIdFabricante());
                    DoubleSummaryStatistics stats = entry.getValue();
                    System.out.printf("\tTotal: %d, Mín: %.2f, Máx: %.2f, Media: %.2f%n",
                            stats.getCount(), stats.getMin(), stats.getMax(), stats.getAverage());
                })
                .collect(Collectors.toMap(entry -> entry.getKey().getIdFabricante(), Map.Entry::getValue));
    }

    /**
     * 41. Devuelve un listado con los nombres de los fabricantes que tienen 2 o más productos.
     */
    @Test
    @Order(41)
    void test41() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        List<String> nombres = listFab.stream()
                .filter(f -> f.getProductos() != null && f.getProductos().size() >= 2)
                .map(Fabricante::getNombre)
                .toList();

        System.out.println("Fabricantes con 2 o más productos: " + nombres);
    }

    /**
     * 42. Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €.
     */
    @Test
    @Order(42)
    void test42() {

        List<Producto> listProd = productosDAO.findAll();

        Map<String, Long> conteo = listProd.stream()
                .filter(p -> p.getPrecio() >= 220)
                .collect(Collectors.groupingBy(
                        p -> p.getFabricante().getNombre(),
                        Collectors.counting()
                ));

        conteo.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.printf("Fabricante: %s, #Productos >= 220€: %d%n", entry.getKey(), entry.getValue()));
    }

    /**
     * 43. Devuelve un listado con los nombres de los fabricantes donde la suma del precio de todos sus productos es superior a 500 €
     */
    @Test
    @Order(43)
    void test43() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        List<String> nombres = listFab.stream()
                .filter(f -> f.getProductos() != null && f.getProductos().stream().mapToDouble(Producto::getPrecio).sum() > 500)
                .map(Fabricante::getNombre)
                .toList();

        System.out.println("Fabricantes con suma de precios > 500€: " + nombres);
    }

    /**
     * 44. Devuelve un listado con los nombres de los fabricantes donde la suma del precio de todos sus productos es superior a 600 €
     * Ordenado de menor a mayor por cuantía de precio de los productos.
     */
    @Test
    @Order(44)
    void test44() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        List<String> nombres = listFab.stream()
                .filter(f -> f.getProductos() != null && !f.getProductos().isEmpty())
                .map(f -> new AbstractMap.SimpleEntry<>(
                        f.getNombre(),
                        f.getProductos().stream().mapToDouble(Producto::getPrecio).sum()
                ))
                .filter(entry -> entry.getValue() > 600)
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("Fabricantes con suma de precios > 600€ (ordenado): " + nombres);
    }

    /**
     * 45. Devuelve un listado con el nombre del producto más caro que tiene cada fabricante.
     * El resultado debe tener tres columnas: nombre del producto, precio y nombre del fabricante.
     * El resultado tiene que estar ordenado alfabéticamente de menor a mayor por el nombre del fabricante.
     */
    @Test
    @Order(45)
    void test45() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        List<String> resultado = listFab.stream()
                .filter(f -> f.getProductos() != null && !f.getProductos().isEmpty())
                .sorted(comparing(Fabricante::getNombre))
                .map(f -> {
                    Producto masCaro = f.getProductos().stream()
                            .max(comparing(Producto::getPrecio))
                            .get();
                    return String.format("%s - %.2f€ - %s", masCaro.getNombre(), masCaro.getPrecio(), f.getNombre());
                })
                .toList();

        resultado.forEach(System.out::println);
    }
}