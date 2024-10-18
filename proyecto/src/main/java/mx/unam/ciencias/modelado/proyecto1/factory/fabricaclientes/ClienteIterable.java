package mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes;

import mx.unam.ciencias.modelado.proyecto1.clientes.Cliente;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.lang.Iterable;
import java.io.Serializable;

/**
 * Clase iterable para asociar identificadores de clientes con objetos Cliente.
 * Sobrecarga los métodos de un HashMap del JDK.
 */
public class ClienteIterable implements Iterable<Cliente>, Serializable {

    /** Para objetos serializables. */
    private static final long serialVersionUID = 1L;
    
    /** Diccionario que asocia identificadores de clientes con objetos Cliente. */
    private Map<String, Cliente> diccionario;

    /** Constructor de la clase, inicializa el diccionario. */
    public ClienteIterable() {
        this.diccionario = new HashMap<>();
    }

    /**
     * Método que agrega un cliente al diccionario.
     * @param cliente el cliente a agregar.
     * @throws IllegalArgumentException si el cliente ya está registrado.
     */
    public void agregar(Cliente cliente) {
        String identificador = cliente.getCuentaBancaria().getUsuario();
        if (diccionario.containsKey(identificador)) {
            throw new IllegalArgumentException("El cliente con el usuario '" + identificador + "' ya está registrado.");
        }
        diccionario.put(identificador, cliente);
    }

    /**
     * Método eliminar que elimina un cliente del diccionario.
     * @param cliente el cliente a eliminar.
     * @throws IllegalArgumentException si el cliente no existe en el diccionario.
     */
    public void eliminar(Cliente cliente) {
        String identificador = cliente.getCuentaBancaria().getUsuario();
        if (!diccionario.containsKey(identificador)) {
            throw new IllegalArgumentException("El cliente con el usuario '" + identificador + "' no existe.");
        }
        diccionario.remove(identificador);
    }

    /**
     * Método para obtener un cliente a partir de su identificador.
     * @param identificador el identificador del cliente.
     * @return el cliente asociado al identificador.
     * @throws IllegalArgumentException si el cliente no existe.
     */
    public Cliente getCliente(String identificador) {
        if (!diccionario.containsKey(identificador)) {
            throw new IllegalArgumentException("El cliente con el usuario '" + identificador + "' no está registrado.");
        }
        return diccionario.get(identificador);
    }

    /**
     * Método para verificar si un cliente está en el diccionario.
     * @param identificador el identificador del cliente a verificar.
     * @return true si el cliente está en el diccionario, false de lo contrario.
     */
    public boolean contieneCliente(String identificador) {
        return diccionario.containsKey(identificador);
    }

    /**
     * Implementación concreta del método de la interfaz Iterable.
     * @return una instancia de ClienteIterator sobre el diccionario local.
     */
    @Override
    public Iterator<Cliente> iterator() {
        return new ClienteIterator(diccionario);
    }

    /**
     * Método para mostrar los nombres de todos los clientes.
     */
    public void mostrar() {
        for (Cliente cliente : diccionario.values()) {
            System.out.println(cliente.getNombre());
        }
    }
}
