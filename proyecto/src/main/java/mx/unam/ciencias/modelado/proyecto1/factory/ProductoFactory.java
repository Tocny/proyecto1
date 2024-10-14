package mx.unam.ciencias.modelado.proyecto1.factory;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import java.util.Arrays;

/**
 * Clase fabrica del patrón factory. Se encarga de implementar una forma de 
 * fabricar productos concretos a partir de sus datos.
 */
public class ProductoFactory extends ObjetoFactory{

    /**
     * Implementación del método para fabricar productos concretos a partir de 3 cadenas.
     * Hace las respectivas conversiones y regresa la instancia generada.
     * @param datos un arreglo de strings para abstraer los datos del objeto a fabricar.
     * @return una instancia de Producto con los datos dados.
     */
    @Override public ObjetoCheemsMart fabricaObjeto(String[] datos){
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
            throw new IllegalArgumentException("Formato erroneo: " + precioString);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Formato erroneo: " + departamentoString);
        }

        return new ProductoConcreto(nombre, precioBase, departamento);
    }
}