package genericos1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ColeccionSimple<T> implements ColeccionSimpleGenerica<T> {
    private List<T> lista = new ArrayList<>();

    @Override
    public boolean estaVacia() {
        return lista.isEmpty();
    }

    @Override
    public T extraer() {
        if (!estaVacia()) {;
            return lista.removeFirst();
        }
        return null;
    }

    @Override
    public T primero() {
        if (!estaVacia()) {
            return lista.getFirst();
        }
        return null;
    }

    @Override
    public void agregar(T elemento) {
        lista.add(elemento);


    }
}
