package mx.unam.ciencias.modelado.proyecto1.observer;

import mx.unam.ciencias.modelado.proyecto1.clientes.*;
import java.util.ArrayList;
import java.util.List;

/**Clase para la implementación del sujeto del patrón observer. */
public class SujetoOfertas implements Sujeto{

    /**Lista de clientes. */
    private List<ClienteObservador> clientes;
    
    /**Constructor de la clase, inicializa la lista de clientes. */
    public SujetoOfertas(){
        this.clientes = new ArrayList<>();
    }

    /**
     * Implementación del método agregarCliente()
     * @param cliente un cliente que recibirá notificaciones.
     */
    @Override public void agregarCliente(ClienteObservador cliente){
        clientes.add(cliente);
    }

    /**
     * Implementación del método eliminarCliente()
     * @param cliente el cliente que dejará de recibir notificaciones.
     */
    @Override public void eliminarCliente(ClienteObservador cliente){
        clientes.remove(cliente);
    }

    /**
     * Implementación del método notificaClientes()
     * @param oferta una cadena que representa una notificacion.
     * @param pais un pais, la notificación se enviará a los clientes de dicho pais.
     */
    @Override public void notificaClientes(String oferta, Pais pais){
        for(ClienteObservador cliente: clientes){

            if(cliente instanceof Cliente){
                Cliente clienteConcreto = (Cliente) cliente;

                if(clienteConcreto.getPais() == pais){
                    clienteConcreto.notificar(oferta);

                }
            }
        }

    }
    


}