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
     */
    public ProductoIterable getProductos() throws RemoteException;

    /**
     * Getter de un producto, dado su codigo.
     * @param codigo un codigo asociado al producto.
     * @return una instancia de producto, que deberá estar contenida en el catalogo.
     */
    public Producto getProducto(String codigo) throws RemoteException;

    /**
     * Getter de un iterable de clientes.
     * @return una instancia de ClienteIterable.
     */
    public ClienteIterable getClientes() throws RemoteException;

    /**
     * Getter de un cliente.
     * @param codigo una cadena codigo (usuario) asociado a un cliente en el iterable.
     * @return una instancia de Cliente contenida en el iterable de clientes.
     */
    public Cliente getCliente(String codigo) throws RemoteException;

    /**
     * Método destinado a recibir cuando hay un nuevo usuario activo.
     * @param observaro una implementación de la interfaz Observador.
     */
    public void inicioSesion(Observador observador) throws RemoteException;

    /**
     * Método para cerrar la sesion cuando un usuario sale de su cuenta.
     * @param observador un usuario que acaba de salir del sitio.
     */
    public void cierreSesion(Observador observador) throws RemoteException;

    /**Método simulación, para un evento que simula ofertas. */
    public List<ProductoDecorator> getOfertas() throws RemoteException;

}