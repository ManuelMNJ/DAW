package Tests;

import genericos2.Pila;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilaTest {
    Pila<Integer> pila;

    @BeforeEach
    void setUp() {
        pila = new Pila<>() {};

    }

    @Test
    void primero() {
        Pila<String> pila = new Pila<>() {};
        pila.insertar("Elemento1");
        assertEquals("Elemento1", pila.primero());
    }

    @Test
    void extraer() {
        Pila<String> pila = new Pila<>(){};
        pila.insertar("Elemento1");
        assertEquals("Elemento1", pila.extraer());
    }


    @Test
    void insertar() {
        Pila<Integer> pila = new Pila<>() {};
        pila.insertar(1);
        assertEquals(1, pila.primero());
    }

    @Test
    void estaVacia() {
        Pila<String> pila = new Pila<>() {};
        assertTrue(pila.estaVacia());
        pila.insertar("Elemento1");
        assertFalse(pila.estaVacia());
    }
}