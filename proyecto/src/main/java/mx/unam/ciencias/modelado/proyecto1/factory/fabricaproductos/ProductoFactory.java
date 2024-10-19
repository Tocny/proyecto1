package mx.unam.ciencias.modelado.proyecto1.factory.fabricaproductos;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Fabrica del patrón factory. Se encarga principalmente de generar un diccionario
 * de objetos de tipo Producto a partir de líneas de datos.
 */
public abstract class ProductoFactory {

    /**
     * Método que genera un diccionario que contiene los productos fabricados.
     * @param lineas una lista de cadenas, se asume que está separada por ",".
     * @return un diccionario donde las claves son identificadores de producto
     *         y los valores son las instancias de Producto.
     */
    public ProductoIterable generaProductosDiccionario(List<String> lineas) {
        ProductoIterable productos = new ProductoIterable();
        
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            Producto producto = fabricaProducto(datos);
            productos.agregar(producto);
        }
        return productos;
    }

    /**
     * Método abstracto que creará un producto a partir de un arreglo de cadenas.
     * @param datos un arreglo de cadenas que pueda ser empleado para crear un objeto.
     * @return una instancia de Producto con los datos dados.
     */
    public abstract Producto fabricaProducto(String[] datos);

}
