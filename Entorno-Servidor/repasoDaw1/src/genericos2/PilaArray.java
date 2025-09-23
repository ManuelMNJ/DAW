package genericos2;

import genericos1.ColeccionSimpleGenerica;
import java.util.Arrays;

public class PilaArray <T> implements ColeccionSimpleGenerica<T> {
    private T[] pila;
    private int numElementos;

    public PilaArray() {
        this.numElementos = 0;
        pila = (T[]) new Object[numElementos];
    }

    @Override
    public boolean estaVacia() {
        return this.numElementos == 0;
    }

    @Override
    public T extraer() {
        if (estaVacia()) {
            throw new IllegalArgumentException("La lista está vacía");
        }
        return pila[--numElementos];
    }

    @Override
    public T primero() {
        if (estaVacia()) {
            throw new IllegalArgumentException("La lista está vacía");
        }
        return pila[numElementos - 1];
    }

    @Override
    public void insertar(T e) {
        T[] nuevaLista = null;

        if (numElementos == pila.length) {
             nuevaLista = Arrays.copyOf(pila, pila.length + 1);
             pila = nuevaLista;
        }
        pila[numElementos] = e;
        numElementos++;
    }

    public int getNumElementos() {
        return numElementos;
    }

    @Override
    public String toString() {
        return "PilaArray{" +
                "lista=" + Arrays.toString(Arrays.copyOf(pila, numElementos)) +
                '}';
    }

}
