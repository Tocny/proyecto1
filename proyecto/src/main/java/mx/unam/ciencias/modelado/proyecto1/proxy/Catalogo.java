package mx.unam.ciencias.modelado.proyecto1.proxy;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import mx.unam.ciencias.modelado.proyecto1.clientes.Cliente;
import mx.unam.ciencias.modelado.proyecto1.observer.Observador;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes.ClienteIterable;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaproductos.ProductoIterable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


/**
 * Interfaz para el catalogo (proxy) de la tienda.
 */
public interface Catalogo extends Remote{

    /**
     * Getter del catalogo de productos.
     * @return un iterable de productos.
     * @throws RemoteException si ocurre un error durante la comunicación remota
     */
    public ProductoIterable getProductos() throws RemoteException;

    /**
     * Getter de un iterable de clientes.
     * @return una instancia de ClienteIterable.
     * @throws RemoteException si ocurre un error durante la comunicación remota
     */
    public ClienteIterable getClientes() throws RemoteException;

    /**
     * Método destinado a recibir cuando hay un nuevo usuario activo.
     * @param observador una implementación de la interfaz Observador.
     * @throws RemoteException si ocurre un error durante la comunicación remota
     */
    public void inicioSesion(Observador observador) throws RemoteException;

    /**
     * Método para cerrar la sesion cuando un usuario sale de su cuenta.
     * @param observador un usuario que acaba de salir del sitio.
     * @throws RemoteException si ocurre un error durante la comunicación remota
     */
    public void cierreSesion(Observador observador) throws RemoteException;

    /**
     * Método de solicitud de actualizaciones, esto se hizo para compatibilidades con obsever.
     * Especificamente para el aspecto de un sujeto que solicita información para un obsevador.
     * @param observador el observador que va a recibir la información.
     * @return una lista de descuentos aplicables para un observador.
     * @throws RemoteException si ocurre un error durante la comunicación remota.
     */
    public List<ProductoDecorator> solicitaActualizaciones(Observador observador) throws RemoteException;

}