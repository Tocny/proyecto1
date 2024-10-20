package mx.unam.ciencias.modelado.proyecto1.proxy;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import mx.unam.ciencias.modelado.proyecto1.clientes.Cliente;
import mx.unam.ciencias.modelado.proyecto1.observer.Observador;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes.ClienteIterable;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaproductos.ProductoIterable;
import java.rmi.RemoteException;
import java.util.List;

/**Clase catalogo proxy. Se comunica con un servidor. */
public class CatalogoProxy implements Catalogo{

    /**Instancia de catalogo que será nuestro servidor. */
    private Catalogo servidor;

    /**
     * Constructor de la clase, asigna el servidor.
     * @param servidor una implementación de catalogo.
     */
    public CatalogoProxy(Catalogo servidor){
        this.servidor = servidor;
        System.out.println("Conexión establecida.");
    }

    /**
     * Implementación del getter de productos.
     * @return el método getProductos del servidor.
     */
    @Override public ProductoIterable getProductos() throws RemoteException{
        return servidor.getProductos();
    }

    /**
     * Implementación del método getClientes.
     * @return el método getClientes() del servidor.
     */
    @Override public ClienteIterable getClientes() throws RemoteException{
        return servidor.getClientes();
    }

    /**
     * Implementación del método inicioSesion.
     * @param observador el nuevo observador que se comunicó mediante el proxy.
     */
    @Override public void inicioSesion(Observador observador) throws RemoteException{
        servidor.inicioSesion(observador);
    }

    /**
     * Implementación del método cierreSesion
     * @param observador un observador que acaba de terminar su comunicación con el servidor.
     */
    @Override public void cierreSesion(Observador observador) throws RemoteException{
        servidor.cierreSesion(observador);
    }

    @Override public List<ProductoDecorator> solicitaActualizaciones(Observador observador) throws RemoteException{
        return servidor.solicitaActualizaciones(observador);
    }

}

