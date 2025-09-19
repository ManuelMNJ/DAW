package genericos1;

import java.util.ArrayList;

public interface ColeccionSimpleGenerica <T> {
    boolean estaVacia();
    T extraer();
    T primero();
    void agregar(T elemento);
}
