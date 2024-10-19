package mx.unam.ciencias.modelado.proyecto1.observer;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import mx.unam.ciencias.modelado.proyecto1.clientes.Pais;
import java.rmi.RemoteException;

/**
 * Interfaz sujeto del patrón observer.
 * Será implementada por todas las clases que puedan mandar notificaciones a los observadores.
 */
public interface Sujeto{

    /**
     * Método para agregar observadors para mandar notificaciones
     * @param observador el observador a agregar.
     * @throws RemoteException si ocurre un error durante la comunicación remota
     */
    public void agregar(Observador observador) throws RemoteException;

    /**
     * Método para eliminar observadors para que dejen de recibir notificaciones.
     * @param observador el observador a eliminar.
     * @throws RemoteException si ocurre un error durante la comunicación remota
     */
    public void eliminar(Observador observador) throws RemoteException;

    /**
     * Método para enviar una notificacion a todos los observadors.
     * @throws RemoteException si ocurre un error durante la comunicación remota
     */
    public void notificarObservadores() throws RemoteException;

}