package mx.unam.ciencias.modelado.proyecto1.proxy;

import java.rmi.RemoteException;
import java.rmi.Naming;

/**Clase intermedia entre el proxy y el servidor. */
public class ClienteRemoto{


    public static void main(String[] args){
        try{

            Catalogo servidor = (Catalogo) Naming.lookup("rmi://127.0.0.1/CatalogoServidor");
            CatalogoProxy proxy = new CatalogoProxy(servidor);
            
            proxy.getClientes().mostrar();
            proxy.getProductos().mostrar();

            System.exit(0);


        }catch (RemoteException e){
            System.err.println("\nError de comunucación remota: Comunicación interrumpida.");
            System.err.println(e.getMessage());
            
        } catch (Exception e){
            System.err.println("\nError inesperado.");
            System.err.println(e.getMessage());  
        }
    }
}