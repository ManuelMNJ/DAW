package genericos2;

import genericos1.ColeccionSimpleGenerica;

import java.util.LinkedList;
import java.util.List;

public abstract class Pila<T> implements ColeccionSimpleGenerica<T> {

    private  List<T> elementos;

    public Pila() {
        this.elementos = new LinkedList<>();
    }

    @Override
    public T primero() {
       return elementos.getFirst();
    }

    @Override
    public T extraer() {
        return elementos.removeFirst();
    }

    @Override
    public void insertar(T e) {
        elementos.add(e);
    }

    @Override
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public String toString() {
        if (estaVacia()) {
            return "[]";
        }
        return elementos.toString();
    }
}

