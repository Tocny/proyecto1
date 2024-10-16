package mx.unam.ciencias.modelado.proyecto1.factory.fabricaproductos;

import mx.unam.ciencias.modelado.proyecto1.decorator.Producto;
import java.util.Iterator;
import java.util.Map;

/**
 * Iterador para recorrer las entradas del diccionario que asocia
 * identificadores de productos con objetos Producto.
 */
public class ProductoIterator implements Iterator<Map.Entry<String, Producto>> {

    /** Iterador interno del diccionario de productos. */
    private Iterator<Map.Entry<String, Producto>> iterador;

    /**
     * Constructor de la clase que inicializa el iterador con el diccionario.
     * @param diccionario el diccionario de productos a iterar.
     */
    public ProductoIterator(Map<String, Producto> diccionario) {
        this.iterador = diccionario.entrySet().iterator();
    }

    /**
     * Método que verifica si hay más elementos en el diccionario.
     * @return true si hay más elementos, false en caso contrario.
     */
    @Override public boolean hasNext() {
        return iterador.hasNext();
    }

    /**
     * Método que obtiene el siguiente elemento del diccionario.
     * @return la siguiente entrada clave-valor del diccionario.
     */
    @Override public Map.Entry<String, Producto> next() {
        return iterador.next();
    }
}
