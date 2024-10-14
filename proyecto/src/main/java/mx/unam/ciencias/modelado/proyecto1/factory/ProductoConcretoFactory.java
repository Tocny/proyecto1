package mx.unam.ciencias.modelado.proyecto1.factory;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;

/**
 * Clase fabrica del patrón factory. Se encarga de implementar una forma de 
 * fabricar productos concretos a partir de sus datos.
 */
public class ProductoConcretoFactory extends ProductoFactory{

    /**
     * Implementación del método para fabricar productos concretos a partir de 3 cadenas.
     * Hace las respectivas conversiones y regresa la instancia generada.
     * @param nombre el nombre del producto.
     * @param precioString el precio del producto en forma de cadena.
     * @param departamentoString el departamento del producto en forma de cadena.
     * @return una instancia de Producto con los datos dados.
     */
    @Override public Producto fabricaProducto(String nombre, String precioString, String departamentoString){
        double precioBase;
        Departamento departamento;

        try{
            precioBase = Double.parseDouble(precioString);
            departamento = Departamento.fromString(departamentoString);

        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Formato erroneo: " + precioString);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Formato erroneo: " + departamentoString);
        }

        return new ProductoConcreto(nombre, precioBase, departamento);
    }
}