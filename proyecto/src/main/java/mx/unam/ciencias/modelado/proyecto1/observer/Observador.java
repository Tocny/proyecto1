package mx.unam.ciencias.modelado.proyecto1.observer;

import mx.unam.ciencias.modelado.proyecto1.clientes.CuentaBancaria;
import mx.unam.ciencias.modelado.proyecto1.decorator.ProductoDecorator;
import mx.unam.ciencias.modelado.proyecto1.clientes.Pais;

/**
 * Interfaz que define los métodos observadores de un cliente.
 */
public interface Observador {

    /**
     * Método particular de los observadores, para mostrar datos de ellos.
     * @return una cadena con los datos del observador.
     */
    public String identificar();

    /**
     * Método para notificar al cliente sobre una oferta.
     * @param oferta la oferta que se notificará al cliente, consiste de un objeto concreto.
     */
    public void notificar(ProductoDecorator oferta);

    /**
     * Los observadores necesitan tener una region asociada.
     * @return un valor de la enumeración Pais asociado al obsevador.
     */
    public Pais getRegion();
}
