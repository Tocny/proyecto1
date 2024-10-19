package mx.unam.ciencias.modelado.proyecto1.factory.fabricaproductos;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import java.util.Arrays;

/**
 * Clase fabrica del patrón factory. Se encarga de implementar una forma de 
 * fabricar y descomponer productos concretos a partir de sus datos.
 */
public class ProductoFabricante extends ProductoFactory{

    /**
     * Implementación del método para fabricar productos concretos a partir de 3 cadenas.
     * Hace las respectivas conversiones y regresa la instancia generada.
     * @param datos un arreglo de strings para abstraer los datos del objeto a fabricar.
     * @return una instancia de Producto con los datos dados.
     */
    public ProductoConcreto fabricaProducto(String[] datos){
        if(datos.length != 4){
                throw new IllegalArgumentException("Formato de producto erroneo: " +  Arrays.toString(datos));
        }

        String codigo = datos[0].trim();
        String nombre = datos[1].trim();
        String precioString = datos[2].trim();
        String departamentoString = datos[3].trim();

        double precioBase;
        Departamento departamento;

        try{
            precioBase = Double.parseDouble(precioString);
            departamento = Departamento.fromString(departamentoString);

        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Formato erroneo: " + Arrays.toString(datos));
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Formato erroneo: " + departamentoString);
        }

        return new ProductoConcreto(codigo, nombre, precioBase, departamento);
    }
}