package mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes;

import mx.unam.ciencias.modelado.proyecto1.clientes.Cliente;
import java.util.Iterator;
import java.util.Map;

/**
 * Iterador para recorrer los objetos Cliente del diccionario.
 */
public class ClienteIterator implements Iterator<Cliente> {

    /** Iterador privado sobre los valores del diccionario. */
    private Iterator<Cliente> iterador;

    /**
     * Constructor de la clase que asigna el iterador sobre los valores del diccionario.
     * @param diccionario el diccionario de clientes a iterar.
     */
    public ClienteIterator(Map<String, Cliente> diccionario) {
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
     * @return el siguiente objeto Cliente en el diccionario.
     */
    @Override
    public Cliente next() {
        return iterador.next();
    }
}
