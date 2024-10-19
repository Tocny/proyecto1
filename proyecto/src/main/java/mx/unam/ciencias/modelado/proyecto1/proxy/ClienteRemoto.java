package mx.unam.ciencias.modelado.proyecto1.proxy;

import mx.unam.ciencias.modelado.proyecto1.menus.*;
import mx.unam.ciencias.modelado.proyecto1.clientes.Cliente;
import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import mx.unam.ciencias.modelado.proyecto1.observer.Observador;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.util.List;
import java.util.ArrayList;

/**Clase intermedia entre el proxy y el servidor. */
public class ClienteRemoto{

    private static Cliente cliente;
    private static MenuCatalogo menuCatalogo;

    public void main(String[] args){
        try{

            Catalogo servidor = (Catalogo) Naming.lookup("rmi://127.0.0.1/CatalogoServidor");
            CatalogoProxy proxy = new CatalogoProxy(servidor);
            
            
            MenuCliente menuCliente = new MenuCliente(proxy.getClientes());

            while(true){
                cliente = menuCliente.iniciar();

                if(cliente == null){
                    break;
                }

                menuCatalogo = new MenuCatalogo(proxy.getProductos(), cliente);
                proxy.inicioSesion(menuCatalogo);
                notificarObservadores(proxy.solicitaActualizaciones(menuCatalogo));
                menuCatalogo.mostrarMenu();
                proxy.cierreSesion(menuCatalogo);
            }


            System.exit(0);


        }catch (RemoteException e){
            System.err.println("\nError de comunucación remota: Comunicación interrumpida.");
            System.err.println(e.getMessage());
            
        } catch (Exception e){
            System.err.println("\nError inesperado.");
            e.printStackTrace(); 
            System.err.println(e.getMessage());  
        }
    }

    private void notificarObservadores(List<ProductoDecorator> descuentos){
        for(ProductoDecorator descuento: descuentos){
            menuCatalogo.notificar(descuento);
        }
    }

}