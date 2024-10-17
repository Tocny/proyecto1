package mx.unam.ciencias.modelado.proyecto1.factory.fabricaproductos;

import mx.unam.ciencias.modelado.proyecto1.decorator.Producto;
import java.util.Iterator;
import java.util.Map;

/**
 * Iterador para recorrer los objetos Producto del diccionario.
 */
public class ProductoIterator implements Iterator<Producto> {

    /** Iterador interno del diccionario de productos. */
    private Iterator<Producto> iterador;

    /**
     * Constructor de la clase que inicializa el iterador con los valores del diccionario.
     * @param diccionario el diccionario de productos a iterar.
     */
    public ProductoIterator(Map<String, Producto> diccionario) {
        this.iterador = diccionario.values().iterator();
    }

    /**
     * Método que verifica si hay más productos en el diccionario.
     * @return true si hay más productos, false en caso contrario.
     */
    @Override 
    public boolean hasNext() {
        return iterador.hasNext();
    }

    /**
     * Método que obtiene el siguiente producto del diccionario.
     * @return el siguiente producto en el diccionario.
     */
    @Override 
    public Producto next() {
        return iterador.next();
    }
}
