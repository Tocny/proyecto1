package mx.unam.ciencias.modelado.proyecto1.factory;

import mx.unam.ciencias.modelado.proyecto1.decorator.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * Fabrica del patrón factory. Se encarga principalmente de generar una lista
 * de productos dada una forma de fabricar esos productos.
 */
public abstract class ProductoFactory{

    /**
     * Método que genera una lista de productos (catalogo) a partir de una lista de cadenas que
     * contienen los datos de cada producto.
     * @param lineas una lista de cadenas, se asume que está separada por ",".
     * @return una lista de instancias de Producto.
     */
    public List<Producto> generaListaProductos(List<String> lineas){
        List<Producto> productos = new ArrayList<>();

        for(String linea: lineas){
            String[] partes = linea.split(",");

            if(partes.length != 3){
                throw new IllegalArgumentException("Formato de producto erroneo: " +  linea);
            }

            String nombre = partes[0].trim();
            String precioString = partes[1].trim();
            String departamentoString = partes[2].trim();

            Producto producto = fabricaProducto(nombre, precioString, departamentoString);

            productos.add(producto);
        }

        return productos;
    }

    /**
     * Método abstracto que creará un producto a partir de tres cadenas.
     * @param nombre el nombre del producto.
     * @param precioString el precio del producto en forma de cadena.
     * @param departamentoString el departamento del producto en forma de cadena.
     * @return una instancia de Producto con los datos dados.
     */
    public abstract Producto fabricaProducto(String nombre, String precioString, String departamentoString);

}