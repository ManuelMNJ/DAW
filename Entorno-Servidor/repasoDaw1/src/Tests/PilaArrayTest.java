package Tests;

import genericos2.Pila;
import genericos2.PilaArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilaArrayTest {

    @Test
    void estaVacia() {
        PilaArray<Integer> pila = new PilaArray<>();
        assertTrue(pila.estaVacia());
        pila.insertar(1);
        assertFalse(pila.estaVacia());
    }

    @Test
    void extraer() {
        PilaArray<String> pila = new PilaArray<>(){};
        pila.insertar("Elemento1");
        assertEquals("Elemento1", pila.extraer());
    }

    @Test
    void primero() {
        PilaArray<String> pila = new PilaArray<>() {};
        pila.insertar("Elemento1");
        assertEquals("Elemento1", pila.primero());
    }

    @Test
    void insertar() {
        PilaArray<Integer> pila = new PilaArray<>() {};
        pila.insertar(1);
        assertEquals(1, pila.primero());
    }

    @Test
    void getNumElementos() {
        PilaArray<Integer> pila = new PilaArray<>() {};
        assertEquals(0, pila.getNumElementos());
        pila.insertar(1);
        assertEquals(1, pila.getNumElementos());
    }
}