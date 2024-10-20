package mx.unam.ciencias.modelado.proyecto1.proxy;

import mx.unam.ciencias.modelado.proyecto1.menus.*;
import mx.unam.ciencias.modelado.proyecto1.clientes.Cliente;
import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import mx.unam.ciencias.modelado.proyecto1.observer.*;
import java.rmi.RemoteException;
import java.rmi.Naming;

/**Clase intermedia entre el proxy y el servidor.
 * Tambien funge como sujeto de los observadores.
 */
public class ClienteRemoto implements Sujeto {

    /**Proxy de la clase. */
    private static CatalogoProxy proxy;
    /**Menu catalogo. */
    private static MenuCatalogo menuCatalogo;

    /**
     * Método main, ejecuta las funciones generales del programa.
     * @param args un arreglo de argumentos.
     */
    public void main(String[] args) {
        try {
            Catalogo servidor = (Catalogo) Naming.lookup("rmi://127.0.0.1/CatalogoServidor");
            proxy = new CatalogoProxy(servidor);
            
            MenuCliente menuCliente = new MenuCliente(proxy.getClientes());

            while (true) {
                Cliente cliente = menuCliente.iniciar();

                if (cliente == null) {
                    break;
                }

                menuCatalogo = new MenuCatalogo(proxy.getProductos(), cliente);
                agregar(menuCatalogo);
                notificarObservadores();
                menuCatalogo.mostrarMenu();
                eliminar(menuCatalogo);
            }

            System.exit(0);

        } catch (RemoteException e) {
            System.err.println("\nError de comunicación remota: Comunicación interrumpida.");
            System.err.println(e.getMessage());

        } catch (Exception e) {
            System.err.println("\nError inesperado.");
            e.printStackTrace(); 
            System.err.println(e.getMessage());  
        }
    }

    /**
     * Implementación del método agregar.
     * @param observador un observador.
     * @throws RemoteException en caso de errores de comunicación con el servidor.
     */
    @Override public void agregar(Observador observador) throws RemoteException {
        proxy.inicioSesion(observador);
    }

    /**
     * Implementación del método eliminar
     * @param observador un observador a eliminar.
     * @throws RemoteException en caso de errores de comunicación con el servidor.
     */
    @Override public void eliminar(Observador observador) throws RemoteException {
        proxy.cierreSesion(observador);
    }

    /**
     * Implementación del método notificarObservadores. Manda notificaciones a los observadores.
     * @throws RemoteException en caso de errores de comunicación con el servidor.
     */
    @Override public void notificarObservadores() throws RemoteException {
        for (ProductoDecorator descuento : proxy.solicitaActualizaciones(menuCatalogo)) {
            menuCatalogo.notificar(descuento);
        }
    }
}
