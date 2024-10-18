package mx.unam.ciencias.modelado.proyecto1.observer;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import mx.unam.ciencias.modelado.proyecto1.clientes.Pais;


/**
 * Interfaz sujeto del patrón observer.
 * Será implementada por todas las clases que puedan mandar notificaciones a los observadores.
 */
public interface Sujeto{

    /**
     * Método para agregar observadors para mandar notificaciones
     * @param observador el observador a agregar.
     */
    public void agregar(Observador observador);

    /**
     * Método para eliminar observadors para que dejen de recibir notificaciones.
     * @param observador el observador a eliminar.
     */
    public void eliminar(Observador observador);

    /**
     * Método asociado a la parte de contabilizar los observadores.
     * @return un entero que representa el número de observadores.
     */
    public int getLongitud();

    /**
     * Método para enviar una notificacion a todos los observadors.
     * @param oferta una oferta para los observadors del sitio.
     * @param pais una región especifica a la cual se manda la notificación.
     */
    public void notificarObservadores(Pais pais, ProductoDecorator oferta);

}