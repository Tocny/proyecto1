package mx.unam.ciencias.modelado.proyecto1.factory;

import mx.unam.ciencias.modelado.proyecto1.clientes.*;
import java.util.Arrays;

public class ClienteFactory extends ObjetoFactory{

    /**
     * Método para fabricar las instancias de cliente a partir de un arreglo de cadenas.
     * @param datos el arreglo de cadenas de donde se van a obtener los datos.
     * @return una instancia de Cliente a partir de los datos dados.
     */
    @Override public ObjetoCheemsMart fabricaObjeto(String[] datos){
        if(datos.length != 6){
                throw new IllegalArgumentException("Formato de producto erroneo: " +  Arrays.toString(datos));
        }

        String idString = datos[0].trim();
        String nombre = datos[1].trim();
        String paisString = datos[2].trim();
        String usuario = datos[3].trim();
        String contrasena = datos[4].trim();
        String saldoString = datos[5].trim();


        int id;
        Pais pais;
        double saldo;

        try{
            id = Integer.parseInt(idString);
            pais = Pais.fromString(paisString);
            saldo = Double.parseDouble(saldoString);

        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Formato erroneo, id o saldo incorrectos: " + idString + " | " + saldoString);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Formato erroneo: " + paisString);
        }

        CuentaBancaria cuentaBancaria = new CuentaBancaria(usuario, contrasena, saldo, pais);

        return new Cliente(id, nombre, cuentaBancaria, pais);

    }
}