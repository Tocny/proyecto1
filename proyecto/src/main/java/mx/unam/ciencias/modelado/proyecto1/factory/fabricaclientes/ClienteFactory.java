package mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes;

import mx.unam.ciencias.modelado.proyecto1.clientes.Cliente;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Fabrica del patrón factory. Se encarga principalmente de generar un diccionario
 * de objetos de tipo Cliente a partir de líneas de datos.
 */
public abstract class ClienteFactory {

    /**
     * Método que genera un diccionario que contiene los clientes fabricados.
     * @param lineas una lista de cadenas, se asume que está separada por ",".
     * @return un diccionario donde las claves son identificadores de cliente
     *         y los valores son las instancias de Cliente.
     */
    public ClienteIterable generaClientesDiccionario(List<String> lineas) {
        ClienteIterable clientes = new ClienteIterable();
        
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            Cliente cliente = fabricaCliente(datos);
            clientes.agregar(cliente);
        }
        return clientes;
    }

    /**
     * Método abstracto que creará un cliente a partir de un arreglo de cadenas.
     * @param datos un arreglo de cadenas que pueda ser empleado para crear un objeto.
     * @return una instancia de Cliente con los datos dados.
     */
    public abstract Cliente fabricaCliente(String[] datos);

}
