package mx.unam.ciencias.modelado.proyecto1.proxy;

import mx.unam.ciencias.modelado.proyecto1.decorator.Producto;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaproductos.ProductoIterable;
import java.util.Map;

/**
 * Interfaz para el catalogo (proxy) de la tienda.
 */
public interface Catalogo{

    /**
     * Getter del catalogo de productos.
     * @return una lista de productos.
     */
    public ProductoIterable getProductos();

    /**
     * Getter de un producto, dado su codigo.
     * @param codigo un codigo asociado al producto.
     * @return una instancia de producto, que deberá estar contenida en el catalogo.
     */
    public Producto getProducto(String codigo);

}