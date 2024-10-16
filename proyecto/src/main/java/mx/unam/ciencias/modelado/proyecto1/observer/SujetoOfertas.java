package mx.unam.ciencias.modelado.proyecto1.observer;

import mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes.ClienteIterable;
import mx.unam.ciencias.modelado.proyecto1.clientes.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**Clase para la implementación del sujeto del patrón observer. */
public class SujetoOfertas implements Sujeto{

    /**Lista de clientes. */
    private ClienteIterable clientes;
    
    /**Constructor de la clase, inicializa la lista de clientes. */
    public SujetoOfertas(ClienteIterable clientes){
        this.clientes = clientes;
    }

    /**
     * Implementación del método agregarCliente()
     * @param cliente un cliente que recibirá notificaciones.
     */
    @Override public void agregarCliente(ClienteObservador cliente){
        clientes.agregar(cliente);
    }

    /**
     * Implementación del método eliminarCliente()
     * @param cliente el cliente que dejará de recibir notificaciones.
     */
    @Override public void eliminarCliente(ClienteObservador cliente){
        clientes.eliminar(cliente);
    }

    /**
     * Implementación del método notificaClientes()
     * @param oferta una cadena que representa una notificacion.
     * @param pais un pais, la notificación se enviará a los clientes de dicho pais.
     */
    @Override public void notificaClientes(String oferta, Pais pais){

        for (Map.Entry<String, ClienteObservador> entry : clientes) {
            String identificador = entry.getKey();
            ClienteObservador cliente = entry.getValue();

            if(cliente.getPais() == pais){
                cliente.notificar(oferta);
            }

        }

    }
    


}