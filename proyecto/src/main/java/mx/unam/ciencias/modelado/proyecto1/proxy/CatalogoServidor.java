package mx.unam.ciencias.modelado.proyecto1.proxy;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import mx.unam.ciencias.modelado.proyecto1.clientes.*;
import mx.unam.ciencias.modelado.proyecto1.observer.*;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes.*;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaproductos.*;
import mx.unam.ciencias.modelado.proyecto1.common.ReaderWriter; 
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.ArrayList;

public class CatalogoServidor extends UnicastRemoteObject implements Catalogo{

    /**El serialVersionUID. */
    private static final long serialVersionUID = 1L;
    /**Instancia de la clase */
    private static CatalogoServidor instancia;
    /**Productos del catalogo. */
    private static ProductoIterable productos;
    /**Clientes de nuestra base de datos. */
    private static ClienteIterable clientes;
    /**Ofertas. */
    private static SujetoOfertas ofertas;

    /**
     * Constructor de la clase, inicializa el diccionario de productos.
     * @throws RemoteException en caso de errores con el servidor remoto.
     */
    private CatalogoServidor() throws RemoteException{
        try {
            ofertas = new SujetoOfertas();
            List<String> lineasProductos = ReaderWriter.read("data/Productos.csv");
            List<String> lineasClientes = ReaderWriter.read("data/Clientes.csv");

            ClienteFabricante fabricaClientes = new ClienteFabricante();
            ProductoFabricante fabricaProductos = new ProductoFabricante();

            clientes = fabricaClientes.generaClientesDiccionario(lineasClientes);
            productos = fabricaProductos.generaProductosDiccionario(lineasProductos);

        } catch (Exception e) {
            System.out.println("Error al inicializar CatalogoServidor: " + e.getMessage());
        }

    }

    /**
     * Método para obtener la instancia de la clase.
     * @return la instancia de la clase.
     */
    public static CatalogoServidor getInstancia(){
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
    @Override public ProductoIterable getProductos(){
        return productos;
    }

    /**
     * Getter de un producto del diccionario de productos.
     * @param codigo un codigo asociado al producto.
     * @return un producto del iterable "productos".
     */
    @Override public Producto getProducto(String codigo){
        return productos.getProducto(codigo);
    }


    /**
     * Getter de un iterable de clientes.
     * @return una instancia de ClienteIterable.
     */
    public ClienteIterable getClientes(){
        return clientes;
    }

    /**
     * Getter de un cliente.
     * @param codigo una cadena codigo (usuario) asociado a un cliente en el iterable.
     * @return una instancia de Cliente contenida en el iterable de clientes.
     */
    public Cliente getCliente(String codigo){
        return clientes.getCliente(codigo);
    }

    /**
     * Implementación del método inicioSesion.
     * @param observador el nuevo observador que se comunicó mediante el proxy.
     */
    @Override public void inicioSesion(Observador observador) throws RemoteException {
        System.out.println("Nuevo Inicio de Sesión: " +  observador.identificar());
        ofertas.agregar(observador);
    }

    /**
     * Método que nos permite tener un registro de los clientees que cierran sesión. para cerrar la tienda.
     * @param observador un observador que eliminar de las ofertas.
     */
    @Override public void cierreSesion(Observador observador) throws RemoteException{
        System.out.println("Cierre de sesión: "  +  observador.identificar());
        ofertas.eliminar(observador);
        System.out.println("Clientes: " + ofertas.getLongitud());
        if(ofertas.getLongitud() <= 0){
            System.out.println("No hay más clientes. Cerrando servidor.");
            System.exit(0);
        }
    }

    /**
     * Método que constituye una simulación sobre la cual se mandan las ofertas a los usuarios.
     * @return una lista de instancias de ProductoDecorator con información para ofertas.
     */
    @Override public List<ProductoDecorator> getOfertas(){
        ProductoDecorator disc15 = new Descuento15(new ProductoNulo());
        disc15.setDepartamento(Departamento.ELECTRONICOS);
        disc15.setRegion(Pais.ESTADOS_UNIDOS);

        ProductoDecorator disc25 = new Descuento25(new ProductoNulo());
        disc25.setDepartamento(Departamento.ELECTRODOMESTICOS);
        disc25.setRegion(Pais.MEXICO);

        ProductoDecorator disc50 = new Descuento50(new ProductoNulo());
        disc50.setDepartamento(Departamento.ALIMENTOS);
        disc50.setRegion(Pais.BRASIL);

        // Creamos una lista para almacenar los descuentos
        List<ProductoDecorator> ofertas = new ArrayList<>();
        
        // Añadimos los descuentos a la lista
        ofertas.add(disc15);
        ofertas.add(disc25);
        ofertas.add(disc50);

        // Retornamos la lista de ofertas
        return ofertas;

    }

    /**
     * Método main de la clase, inicializa el servidor mediante rmi.
     * @param args un arreglo de argumentos.
     */
    public static void main(String[] args){
        try{
            System.setProperty("java.net.preferIPv4Stack", "true");
            System.setProperty("java.rmi.server.hostname", "localhost");
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost/CatalogoServidor", getInstancia());
            System.out.println("Servidor de CheemsMart registrado. Esperando clientes.");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}