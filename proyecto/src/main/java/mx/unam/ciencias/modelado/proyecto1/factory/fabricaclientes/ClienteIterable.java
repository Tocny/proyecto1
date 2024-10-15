package mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes;

import mx.unam.ciencias.modelado.proyecto1.clientes.Cliente;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.lang.Iterable;

/**
 * Clase iterable para asociar identificadores de clientes con objetos Cliente.
 * Sobrecarga los métodos de un HashMap del JDK.
 */
public class ClienteIterable implements Iterable<Map.Entry<String, Cliente>>{

    /** Diccionario que asocia identificadores de clientes con objetos Cliente. */
    private Map<String, Cliente> diccionario;

    /** Constructor de la clase, inicializa el diccionario. */
    public ClienteIterable(){
        this.diccionario = new HashMap<>();
    }

    /**
     * Método que agrega un cliente al diccionario.
     * @param identificador el identificador del cliente.
     * @param cliente el cliente a agregar.
     */
    public void agregar(String identificador, Cliente cliente){
        diccionario.put(identificador, cliente);
    }

    /**
     * Método para obtener un cliente a partir de su identificador.
     * @param identificador el identificador del cliente.
     * @return el cliente asociado al identificador.
     */
    public Cliente getCliente(String identificador){
        return diccionario.get(identificador);
    }

    /**
     * Método para verificar si un cliente está en el diccionario.
     * @param identificador el identificador del cliente a verificar.
     * @return true si el cliente está en el diccionario, false de lo contrario.
     */
    public boolean contieneCliente(String identificador){
        return diccionario.containsKey(identificador);
    }

    /**
     * Implementación concreta del método de la interfaz Iterable.
     * @return una instancia de ClienteIterator sobre el diccionario local.
     */
    @Override public Iterator<Map.Entry<String, Cliente>> iterator(){
        return new ClienteIterator(diccionario);
    }
}
