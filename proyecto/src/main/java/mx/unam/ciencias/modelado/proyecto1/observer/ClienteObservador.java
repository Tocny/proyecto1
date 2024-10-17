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
    public String getID();

    /**
     * Método getter para obtener el nombre del cliente.
     * @return el nombre del cliente.
     */
    public String getNombre();

    /**
     * Método getter para obtener la cuenta bancaria del cliente.
     * @return la cuenta bancaria del cliente.
     */
    public CuentaBancaria getCuentaBancaria();

    /**
     * Método getter para obtener el país del cliente.
     * @return el país del cliente.
     */
    public Pais getPais();

    /**
     * Método para validar las credenciales del cliente.
     * @param usuario un usuario.
     * @param contrasena la contrasena de la cuenta.
     * @return si es que los parámetros nos dan el acceso a la cuenta.
     */
    public boolean validarCredenciales(String usuario, String contrasena);

    /**
     * Método para notificar al cliente sobre una oferta.
     * @param oferta la oferta que se notificará al cliente.
     */
    public void notificar(String oferta);

}
