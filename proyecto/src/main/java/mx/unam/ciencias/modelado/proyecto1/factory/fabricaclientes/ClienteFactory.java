package mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes;

import mx.unam.ciencias.modelado.proyecto1.clientes.Cliente;
import mx.unam.ciencias.modelado.proyecto1.observer.ClienteObservador;
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
            ClienteObservador cliente = fabricaCliente(datos);
            clientes.agregar(cliente);
        }
        return clientes;
    }

    /**
     * Método que se encarga de generar una lista de cadenas con el formato
     * especificado para ser vaciado en un archivo (que funjirá como base de datos).
     * @param clientes el diccionario de clientes que queremos descomponer.
     * @return una lista de cadenas que corresponde a los clientes descompuestos.
     */
    public List<String> generaListaCadenas(Map<String, Cliente> clientes) {
        List<String> lineas = new ArrayList<>();

        for (Cliente cliente : clientes.values()) {
            lineas.add(descomponeCliente(cliente));
        }

        return lineas;
    }

    /**
     * Método abstracto que creará un cliente a partir de un arreglo de cadenas.
     * @param datos un arreglo de cadenas que pueda ser empleado para crear un objeto.
     * @return una instancia de Cliente con los datos dados.
     */
    public abstract ClienteObservador fabricaCliente(String[] datos);

    /**
     * Método que a partir de una instancia de Cliente se encarga de 
     * descomponerlo en las componentes requeridas para eventualmente vaciarlo en un archivo.
     * @param cliente la instancia de Cliente
     * @return los datos del cliente descompuestos en el formato de los archivos.
     */
    public abstract String descomponeCliente(ClienteObservador cliente);
}
