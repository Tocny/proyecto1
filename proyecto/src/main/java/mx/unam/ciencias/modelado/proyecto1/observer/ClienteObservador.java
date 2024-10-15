package mx.unam.ciencias.modelado.proyecto1.observer;


/**
 * Clase observadora del patrón observer.
 * Será implementada por los clientes que puedan recibir notificaciones del sitio.
 */
public interface ClienteObservador{

    /**
     * Método de notificacion para mandar mensajes a los usuarios.
     * @param oferta una cadena correspondiente a una oferta en el sitio.
     */
    public void notificar(String oferta);
}