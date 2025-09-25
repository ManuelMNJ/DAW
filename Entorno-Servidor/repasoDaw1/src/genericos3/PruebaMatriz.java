package genericos3;

public class PruebaMatriz {
    public static void main(String[] args) {
        Matriz<Integer> matrizEjemplo = new Matriz<>(4, 2);
        int num=1;
        for (int i = 0; i < matrizEjemplo.filas(); i++) {
            for (int j = 0; j < matrizEjemplo.columnas(); j++) {
                matrizEjemplo.set(i, j,num++);
            }
    }

        matrizEjemplo.toString();

        System.out.println(matrizEjemplo.get(0, 1));
    }

}
