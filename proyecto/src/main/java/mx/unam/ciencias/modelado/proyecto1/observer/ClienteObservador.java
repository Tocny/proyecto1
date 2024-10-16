package mx.unam.ciencias.modelado.proyecto1.observer;

import mx.unam.ciencias.modelado.proyecto1.clientes.CuentaBancaria;
import mx.unam.ciencias.modelado.proyecto1.clientes.Pais;

/**
 * Interfaz que define los métodos observadores de un cliente.
 */
public interface ClienteObservador {

    /**
     * Método getter para obtener el ID del cliente.
     * @return el ID del cliente.
     */
    String getID();

    /**
     * Método getter para obtener el nombre del cliente.
     * @return el nombre del cliente.
     */
    String getNombre();

    /**
     * Método getter para obtener la cuenta bancaria del cliente.
     * @return la cuenta bancaria del cliente.
     */
    CuentaBancaria getCuentaBancaria();

    /**
     * Método getter para obtener el país del cliente.
     * @return el país del cliente.
     */
    Pais getPais();

    /**
     * Método para notificar al cliente sobre una oferta.
     * @param oferta la oferta que se notificará al cliente.
     */
    void notificar(String oferta);
}
