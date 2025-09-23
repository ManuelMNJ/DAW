package genericos3;

public class Matriz<T> {
    private T[][] matriz;
    private int numFilas;
    private int numColumnas;

    public Matriz(int numFilas , int numColumnas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        matriz = (T[][]) new Object[numFilas][numColumnas];
    }

    void set (int fila, int columna, T elemento) {
        matriz[fila][columna] = elemento;
    }

    T get (int fila, int columna) {
        return matriz[fila-1][columna-1];
    }
    int columnas(){
        return numColumnas;
    }
    int filas(){
        return numFilas;
    }

    public String toString(){
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        return "";
    }
}
