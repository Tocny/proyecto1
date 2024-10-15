package mx.unam.ciencias.modelado.proyecto1.factory;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import java.util.Arrays;

/**
 * Clase fabrica del patrón factory. Se encarga de implementar una forma de 
 * fabricar y descomponer productos concretos a partir de sus datos.
 */
public class ProductoFactory extends ObjetoFactory{

    /**
     * Implementación del método para fabricar productos concretos a partir de 3 cadenas.
     * Hace las respectivas conversiones y regresa la instancia generada.
     * @param datos un arreglo de strings para abstraer los datos del objeto a fabricar.
     * @return una instancia de Producto con los datos dados.
     */
    @Override public ProductoConcreto fabricaObjeto(String[] datos){
        if(datos.length != 3){
                throw new IllegalArgumentException("Formato de producto erroneo: " +  Arrays.toString(datos));
        }

        String nombre = datos[0].trim();
        String precioString = datos[1].trim();
        String departamentoString = datos[2].trim();

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

        return new ProductoConcreto(nombre, precioBase, departamento);
    }

    /**
     * Método que descompone un objeto ProductoConcreto en una cadena de texto separada por comas.
     * @param objeto el objeto a descomponer.
     * @return una cadena que contiene los datos del objeto separados por comas.
     */
    @Override public String descomponeObjeto(ObjetoCheemsMart objeto) {
        if (!(objeto instanceof ProductoConcreto)) {
            throw new IllegalArgumentException("El objeto no es un producto.");
        }

        ProductoConcreto producto = (ProductoConcreto) objeto;

        //Procedemos a extraer todos los datos del cliente.
        String nombre = producto.getNombre();
        String precio = String.valueOf(producto.getPrecioBase());
        String departamento = producto.getDepartamento().name();

        return String.join(",", nombre, precio, departamento);
    }
}