package mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes;

import mx.unam.ciencias.modelado.proyecto1.clientes.*;
import java.util.Arrays;

/**
 * Clase ClienteFactory que se encarga de fabricar y descomponer instancias de la clase Cliente,
 * forma parte del patrón factory.
 */
public class ClienteFabricante extends ClienteFactory{

    /**
     * Método para fabricar las instancias de cliente a partir de un arreglo de cadenas.
     * @param datos el arreglo de cadenas de donde se van a obtener los datos.
     * @return una instancia de Cliente a partir de los datos dados.
     */
    @Override public Cliente fabricaObjeto(String[] datos){
        if(datos.length != 5){
                throw new IllegalArgumentException("Formato de producto erroneo: " +  Arrays.toString(datos));
        }

        String nombre = datos[0].trim();
        String paisString = datos[1].trim();
        String usuario = datos[2].trim();
        String contrasena = datos[3].trim();
        String saldoString = datos[4].trim();

        Pais pais;
        double saldo;

        try{
            pais = Pais.fromString(paisString);
            saldo = Double.parseDouble(saldoString);

        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Formato erroneo, id o saldo incorrectos: " + saldoString);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Formato erroneo: " + paisString);
        }

        CuentaBancaria cuentaBancaria = new CuentaBancaria(usuario, contrasena, saldo, pais);

        return new Cliente(nombre, cuentaBancaria, pais);

    }

    /**
     * Método que descompone un objeto ProductoConcreto en una cadena de texto separada por comas.
     * @param objeto el objeto a descomponer.
     * @return una cadena que contiene los datos del objeto separados por comas.
     */
    @Override public String descomponeObjeto(Cliente cliente) {
    
        //Procedemos a extraer todos los datos del cliente.
        String nombre = cliente.getNombre();
        CuentaBancaria cuenta = cliente.getCuentaBancaria();
        String usuario = cuenta.getUsuario();
        String contrasena = cuenta.getContrasena();
        String saldo = String.valueOf(cuenta.getSaldo());
        String pais = cliente.getPais().name();

        return String.join(",", nombre, pais, usuario, contrasena, saldo);

    }
}