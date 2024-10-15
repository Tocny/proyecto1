package mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes;

import mx.unam.ciencias.modelado.proyecto1.clientes.Cliente;
import java.util.Iterator;
import java.util.Map;

/**
 * Iterador para recorrer las entradas del diccionario que asocia
 * identificadores de clientes con objetos Cliente.
 */
public class ClienteIterator implements Iterator<Map.Entry<String, Cliente>> {

    /**Iterador privado. */
    private Iterator<Map.Entry<String, Cliente>> iterador;

    /**
     * Constructor de la clase, asigna el iterador.
     * @param diccionario un diccionaro del cual extraer el iterador.
     */
    public ClienteIterator(Map<String, Cliente> diccionario) {
        this.iterador = diccionario.entrySet().iterator();
    }

    /**
     * Implementacion del método hasnext
     * @return el método hasNext del iterador.
     */
    @Override public boolean hasNext() {
        return iterador.hasNext();
    }

    /**
     * Implementación del método next()
     * @return el método next del iterador.
     */
    @Override public Map.Entry<String, Cliente> next() {
        return iterador.next();
    }
}
