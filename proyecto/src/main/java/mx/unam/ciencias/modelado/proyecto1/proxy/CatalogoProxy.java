package mx.unam.ciencias.modelado.proyecto1.proxy;

import mx.unam.ciencias.modelado.proyecto1.decorator.Producto;
import mx.unam.ciencias.modelado.proyecto1.clientes.Cliente;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes.ClienteIterable;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaproductos.ProductoIterable;
import java.rmi.RemoteException;


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
     * Implementación del getter de un producto.
     * @return el método getproducto del servidor.
     */
    @Override public Producto getProducto(String codigo) throws RemoteException{
        return servidor.getProducto(codigo);
    }

    /**
     * Implementación del método getClientes.
     * @return el método getClientes() del servidor.
     */
    @Override public ClienteIterable getClientes() throws RemoteException{
        return servidor.getClientes();
    }

    /**
     * Implementación del método getcliente.
     * @return el método getCliente() del servidor.
     */
    @Override public Cliente getCliente(String codigo) throws RemoteException{
        return servidor.getCliente(codigo);
    }


}

