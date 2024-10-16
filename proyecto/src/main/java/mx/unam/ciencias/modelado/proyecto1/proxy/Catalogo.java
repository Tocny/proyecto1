package mx.unam.ciencias.modelado.proyecto1.proxy;

import mx.unam.ciencias.modelado.proyecto1.decorator.Producto;
import mx.unam.ciencias.modelado.proyecto1.observer.ClienteObservador;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes.ClienteIterable;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaproductos.ProductoIterable;

/**
 * Interfaz para el catalogo (proxy) de la tienda.
 */
public interface Catalogo{

    /**
     * Getter del catalogo de productos.
     * @return un iterable de productos.
     */
    public ProductoIterable getProductos();

    /**
     * Getter de un producto, dado su codigo.
     * @param codigo un codigo asociado al producto.
     * @return una instancia de producto, que deberá estar contenida en el catalogo.
     */
    public Producto getProducto(String codigo);

    /**
     * Getter de un iterable de clientes.
     * @return una instancia de ClienteIterable.
     */
    public ClienteIterable getClientes();

    /**
     * Getter de un cliente.
     * @param codigo una cadena codigo (usuario) asociado a un cliente en el iterable.
     * @return una instancia de Cliente contenida en el iterable de clientes.
     */
    public ClienteObservador getCliente(String codigo);

}