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
    @Override public Cliente fabricaCliente(String[] datos){
        if(datos.length != 6){
                throw new IllegalArgumentException("Formato de producto erroneo: " +  Arrays.toString(datos));
        }

        String id = datos[0].trim();
        String nombre = datos[1].trim();
        String paisString = datos[2].trim();
        String usuario = datos[3].trim();
        String contrasena = datos[4].trim();
        String saldoString = datos[5].trim();

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

        return new ClienteConcreto(id, nombre, cuentaBancaria, pais);

    }
}