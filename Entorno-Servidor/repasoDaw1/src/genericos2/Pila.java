package genericos2;

import genericos1.ColeccionSimpleGenerica;

import java.util.LinkedList;

public abstract class Pila<T> implements ColeccionSimpleGenerica<T> {

    private final LinkedList<T> elementos;

    public Pila() {
        this.elementos = new LinkedList<>();
    }

    @Override
    public void insertar(T elemento) {
        elementos.addFirst(elemento);
    }

    @Override
    public T extraer() {
        if (estaVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        return elementos.removeFirst();
    }

    @Override
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public int tamanio() {
        return elementos.size();
    }

    public String toString() {
        if (estaVacia()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < elementos.size(); i++) {
            sb.append(elementos.get(i));
            if (i < elementos.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

