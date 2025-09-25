package genericos4;

import java.util.ArrayList;
import java.util.List;

public class ListaOrdenada<E extends Comparable<E>>{
    private ArrayList<E> listaOrdneada;

    public ListaOrdenada(){
        listaOrdneada = new ArrayList<>();
    }
    public void add(E elemento) {
        if (listaOrdneada.isEmpty()) {
            listaOrdneada.add(elemento);
            return;
        }

        int i = 0;
        while (i < listaOrdneada.size() && listaOrdneada.get(i).compareTo(elemento) < 0) {
            i++;
        }
        listaOrdneada.add(i, elemento);
    }

    E get (int indice){
        return listaOrdneada.get(indice);
    }

    public int size() {
        return listaOrdneada.size();
    }
    public boolean isEmpty() {
        return listaOrdneada.isEmpty();
    }
    public boolean remove(E elemento) {
        return listaOrdneada.remove(elemento);
    }


    public int indexOf(E elemento) {
        return listaOrdneada.indexOf(elemento);
    }


    @Override
    public String toString() {
        return listaOrdneada.toString();
    }


    public static void main(String[] args) {
        ListaOrdenada<Integer> lista = new ListaOrdenada<>();

        lista.add(5);
        lista.add(2);
        lista.add(8);
        lista.add(1);

        System.out.println("Lista: " + lista);
        System.out.println("Elemento en índice 2: " + lista.get(2));
        System.out.println("Tamaño: " + lista.size());
        System.out.println("Índice del 5: " + lista.indexOf(5));
        lista.remove(2);
        System.out.println("Después de eliminar 2: " + lista);
        System.out.println("¿Está vacía? " + lista.isEmpty());
        System.out.println("Lista actualizada: "+lista);
    }

}
