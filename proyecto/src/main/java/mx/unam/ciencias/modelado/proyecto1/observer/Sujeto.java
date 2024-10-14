package mx.unam.ciencias.modelado.proyecto1.observer;

import mx.unam.ciencias.modelado.proyecto1.clientes.Pais;

/**
 * Interfaz sujeto del patrón observer.
 * Será implementada por todas las clases que puedan mandar notificaciones a los observadores.
 */
public interface Sujeto{

    /**
     * Método para agregar clientes para mandar notificaciones
     * @param cliente el cliente a agregar.
     */
    public void agregarCliente(ClienteObservador cliente);

    /**
     * Método para eliminar clientes para que dejen de recibir notificaciones.
     * @param cliente el cliente a eliminar.
     */
    public void eliminarCliente(ClienteObservador cliente);

    /**
     * Método para enviar una notificacion a todos los clientes.
     * @param oferta una oferta para los clientes del sitio.
     * @param pais un pais sobre el cual se notificará a los usuarios de dicho pais.
     */
    public void notificaClientes(String oferta, Pais pais);

}