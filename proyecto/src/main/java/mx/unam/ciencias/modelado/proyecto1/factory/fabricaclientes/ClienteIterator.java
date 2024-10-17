package mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes;

import mx.unam.ciencias.modelado.proyecto1.observer.ClienteObservador;
import java.util.Iterator;
import java.util.Map;

/**
 * Iterador para recorrer los objetos ClienteObservador del diccionario.
 */
public class ClienteIterator implements Iterator<ClienteObservador> {

    /** Iterador privado sobre los valores del diccionario. */
    private Iterator<ClienteObservador> iterador;

    /**
     * Constructor de la clase que asigna el iterador sobre los valores del diccionario.
     * @param diccionario el diccionario de clientes a iterar.
     */
    public ClienteIterator(Map<String, ClienteObservador> diccionario) {
        this.iterador = diccionario.values().iterator();
    }

    /**
     * Implementación del método hasNext().
     * @return true si hay más clientes, false en caso contrario.
     */
    @Override
    public boolean hasNext() {
        return iterador.hasNext();
    }

    /**
     * Implementación del método next().
     * @return el siguiente objeto ClienteObservador en el diccionario.
     */
    @Override
    public ClienteObservador next() {
        return iterador.next();
    }
}
