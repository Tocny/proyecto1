package mx.unam.ciencias.modelado.proyecto1.factory.fabricaproductos;

import mx.unam.ciencias.modelado.proyecto1.decorator.Producto;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.lang.Iterable;
import java.io.Serializable;

/**
 * Clase iterable para asociar identificadores de productos con objetos Producto.
 * Sobrecarga los métodos de un HashMap del JDK.
 */
public class ProductoIterable implements Iterable<Map.Entry<String, Producto>>, Serializable{

    /**Para objetos serializables. */
    private static final long serialVersionUID = 1L;
    /** Diccionario que asocia identificadores de productos con objetos Producto. */
    private Map<String, Producto> diccionario;

    /** Constructor de la clase, inicializa el diccionario. */
    public ProductoIterable(){
        this.diccionario = new HashMap<>();
    }

    /**
     * Método que agrega un producto al diccionario.
     * @param producto el producto a agregar.
     */
    public void agregar(Producto producto){
        diccionario.put(producto.getCodigo(), producto);
    }

    /**
     * Método para obtener un producto a partir de su identificador.
     * @param identificador el identificador del producto.
     * @return el producto asociado al identificador.
     */
    public Producto getProducto(String identificador){
        return diccionario.get(identificador);
    }

    /**
     * Método para verificar si un producto está en el diccionario.
     * @param identificador el identificador del producto a verificar.
     * @return true si el producto está en el diccionario, false de lo contrario.
     */
    public boolean contieneProducto(String identificador){
        return diccionario.containsKey(identificador);
    }

    /**
     * Implementación concreta del método de la interfaz Iterable.
     * @return una instancia de ProductoIterator sobre el diccionario local.
     */
    @Override public Iterator<Map.Entry<String, Producto>> iterator(){
        return new ProductoIterator(diccionario);
    }

    /**
     * Método para mostrar los nombres de todos los productos.
     */
    public void mostrar() {
        for (Producto producto : diccionario.values()) {
            System.out.println(producto.getNombre());
        }
    }
}