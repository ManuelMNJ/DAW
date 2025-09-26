package stream;

import java.util.*;

import jakarta.persistence.EntityManager;
import org.iesbelen.tiendainformatica.dao.FabricanteDAO;
import org.iesbelen.tiendainformatica.dao.ProductoDAO;
import org.iesbelen.tiendainformatica.entity.Fabricante;
import org.iesbelen.tiendainformatica.dao.FabricanteDAOImpl;
import org.iesbelen.tiendainformatica.entity.Producto;
import org.iesbelen.tiendainformatica.dao.ProductoDAOImpl;
import org.iesbelen.tiendainformatica.util.JPAUtil;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TiendaTest {

    // Obtenemos un EntityManager de nuestra clase de utilidad JPA
    private static EntityManager em = JPAUtil.getEntityManager();

    // Los DAOs son estáticos para poder usarlos en @BeforeAll
    private static FabricanteDAO fabricantesDAO = new FabricanteDAOImpl(em);
    private static ProductoDAO productosDAO = new ProductoDAOImpl(em);

    @BeforeAll
    static void setUpAll() {
        // ✅ ESTO SE EJECUTA UNA SOLA VEZ ANTES DE TODOS LOS TESTS
        System.out.println("Inicializando datos de la base de datos...");
        ((FabricanteDAOImpl) fabricantesDAO).beginTransaction();
        try {
            // Creación de fabricantes y productos
            Fabricante asus = new Fabricante("Asus");
            fabricantesDAO.create(asus);
            productosDAO.create(new Producto(asus, "Monitor 27 LED Full HD", 199.25));
            productosDAO.create(new Producto(asus, "Monitor 24 LED Full HD", 119.99));

            Fabricante lenovo = new Fabricante("Lenovo");
            fabricantesDAO.create(lenovo);
            productosDAO.create(new Producto(lenovo, "Portátil IdeaPad 320", 359.65));
            productosDAO.create(new Producto(lenovo, "Portátil Yoga 520", 452.79));

            Fabricante hp = new Fabricante("Hewlett-Packard");
            fabricantesDAO.create(hp);
            productosDAO.create(new Producto(hp, "Impresora HP Deskjet 3720", 59.99));
            productosDAO.create(new Producto(hp, "Impresora HP Laserjet Pro M26nw", 111.86));

            Fabricante samsung = new Fabricante("Samsung");
            fabricantesDAO.create(samsung);
            productosDAO.create(new Producto(samsung, "Disco SSD 1 TB", 72.99));

            Fabricante seagate = new Fabricante("Seagate");
            fabricantesDAO.create(seagate);
            productosDAO.create(new Producto(seagate, "Disco duro SATA3 1TB", 38.49));

            Fabricante crucial = new Fabricante("Crucial");
            fabricantesDAO.create(crucial);
            productosDAO.create(new Producto(crucial, "GeForce GTX 1080 Xtreme", 611.55));
            productosDAO.create(new Producto(crucial, "Memoria RAM DDR4 8GB", 24.19));

            Fabricante gigabyte = new Fabricante("Gigabyte");
            fabricantesDAO.create(gigabyte);
            productosDAO.create(new Producto(gigabyte, "GeForce GTX 1050Ti", 319.19));

            fabricantesDAO.create(new Fabricante("Huawei"));
            fabricantesDAO.create(new Fabricante("Xiaomi"));

            ((FabricanteDAOImpl) fabricantesDAO).commitTransaction();
        } catch (Exception e) {
            ((FabricanteDAOImpl) fabricantesDAO).rollbackTransaction();
            throw e;
        }
    }

    @BeforeEach
    void setUp() {
        // ✅ Se ejecuta antes de CADA test
        // Ideal para iniciar una transacción que se revertirá después
        ((FabricanteDAOImpl) fabricantesDAO).beginTransaction();
        // Inicia la transacción UNA SOLA VEZ
        // No importa a través de qué DAO lo hagas, ya que ambos comparten la transacción.
        // ((ProductoDAOImpl) productosDAO).beginTransaction();
    }

    @AfterEach
    void tearDown() {
        // ✅ Se ejecuta después de CADA test
        // Revertimos la transacción para que cada test sea independiente
        ((FabricanteDAOImpl) fabricantesDAO).rollbackTransaction();
    }

    @AfterAll
    static void tearDownAll() {
        // ✅ Se ejecuta UNA SOLA VEZ al final de todos los tests
        // Ideal para limpiar la base de datos si es necesario.
        System.out.println("Limpiando datos...");
        if (em != null) {
            em.close();
            System.out.println("EntityManager cerrado.");
        }
    }

    @Test
    void testAllFabricante() {
        List<Fabricante> listFab = fabricantesDAO.findAll();
        assertEquals(9, listFab.size());
    }

    @Test
    void testAllProducto() {

        List<Producto> listProd = productosDAO.findAll();
        assertEquals(11, listProd.size());

    }

    @Test
    void testSkeletonFrabricante() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }

    @Test
    void testSkeletonProducto() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }
    

    @Test
    void test1() {

        List<Producto> listProd = productosDAO.findAll();

        // TODO STREAM

    }


    @Test
    void test2() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test3() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test4() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test5() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test6() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test7() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test8() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test9() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS
    }


    @Test
    void test10() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test11() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test12() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test13() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test14() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test15() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test16() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test17() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test18() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }



    @Test
    void test19() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test20() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test21() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test22() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test23() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test24() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test25() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test26() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test27() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test28() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test29() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test30() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }



    @Test
    void test31() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test32() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test33() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test34() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test35() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test36() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test37() {

        List<Producto> listProd = productosDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test38() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test39() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test40() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test41() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test42() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test43() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test44() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }


    @Test
    void test45() {

        List<Fabricante> listFab = fabricantesDAO.findAll();

        //TODO STREAMS

    }
}