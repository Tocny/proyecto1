package mx.unam.ciencias.modelado.proyecto1.proxy;

import mx.unam.ciencias.modelado.proyecto1.decorator.Producto;
import mx.unam.ciencias.modelado.proyecto1.clientes.Cliente;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes.ClienteFabricante;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaproductos.ProductoFabricante;
import mx.unam.ciencias.modelado.proyecto1.common.ReaderWriter; 
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CatalogoServidor extends UnicastRemoteObject implements Catalogo{

    /**El serialVersionUID. */
    private static final long serialVersionUID = 1L;
    /**Instancia de la clase */
    private CatalogoServidor instancia;
    /**Productos del catalogo. */
    private Map<String, Producto> productos;
    /**Clientes de nuestra base de datos. */
    private Map<String, Cliente> clientes;
    /**Fabrica de clientes. */
    private ClienteFabricante fabricaClientes;
    /**Fabrica de productos */
    private ProductoFabricante fabricaProductos;

    /**
     * Constructor de la clase, inicializa el diccionario de productos.
     * @throws RemoteException en caso de errores con el servidor remoto.
     */
    private CatalogoServidor() throws RemoteException{
        List<String> lineasProductos = ReaderWriter.read("Productos.csv");
        List<String> lineasClientes = ReaderWriter.read("Clientes.csv");
        
        fabricaClientes = new ClienteFabricante();
        fabricaProductos = new ProductoFabricante();
        
        clientes = fabricaClientes.generaClientesDiccionario(lineasClientes);
        productos = fabricaProductos.generaProductosDiccionario(lineasProductos);

    }

    /**
     * Método para obtener la instancia de la clase.
     * @return la instancia de la clase.
     */
    public CatalogoServidor getInstancia(){
        if (instancia == null) {
            try {
                instancia = new CatalogoServidor();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return instancia;
    }

    /**
     * Getter del diccionario de productos.
     * @return productos.
     */
    @Override public Map<String, Producto> getProductos(){
        return productos;
    }

    /**
     * Getter de un producto del diccionario de productos.
     */
    @Override public Producto getProducto(String codigo){
        return (Producto) productos.get(codigo);
    }

}