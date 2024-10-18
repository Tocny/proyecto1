package mx.unam.ciencias.modelado.proyecto1.builder;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import mx.unam.ciencias.modelado.proyecto1.clientes.Pais;
import java.util.List;
import java.util.ArrayList;

/**
 * La interfaz CarritoBuilder define los métodos necesarios para construir un objeto Carrito
 * paso a paso. Esta interfaz sigue el patrón de diseño Builder, permitiendo agregar y eliminar productos, 
 * aplicar descuentos, y finalmente construir el carrito con los productos seleccionados y los descuentos aplicados.
 */
public interface CarritoBuilder {

    /**
     * Agrega un producto al carrito.
     *
     * @param producto el Producto que se desea agregar al carrito.
     */
    public void agregarProducto(Producto producto);

    /**
     * Elimina un producto del carrito.
     *
     * @param producto el Producto que se desea eliminar del carrito.
     */
    public void eliminarProducto(Producto producto);

    /**
     * Aplica descuentos a los productos del carrito en función del departamento al que pertenecen, el país
     * en el que se encuentra el cliente, y el descuento especificado.
     *
     * @param descuento el ProductoDecorator que encapsula las reglas del descuento a aplicar.
     */
    public void aplicarDescuentos(ProductoDecorator descuento);

    /**
     * Construye y retorna el objeto final del carrito con los productos agregados y los descuentos aplicados.
     *
     * @return el objeto Carrito con los productos y descuentos listos para su uso.
     */
    public Carrito buildCarrito();
}
