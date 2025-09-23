package genericos1;

import java.util.ArrayList;

public interface ColeccionSimpleGenerica <T> {
    boolean estaVacia();
    void insertar(T elemento);
    T extraer();
    T primero();
}
