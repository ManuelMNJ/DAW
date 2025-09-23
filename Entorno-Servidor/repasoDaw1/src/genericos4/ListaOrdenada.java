package genericos4;

import java.util.ArrayList;
import java.util.List;

public class ListaOrdenada<E extends Comparable<E>{
    private List<E> listaOrdneada;

    public ListaOrdenada<E>(){
        this.listaOrdneada = new ArrayList<E>();
    }
    void add (E elemento){
        listaOrdneada.add(elemento);
    }
    E get (int indice){
        return listaOrdneada.get(indice);
    }


}
