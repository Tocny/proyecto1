package mx.unam.ciencias.modelado.proyecto1.strategy.idioma;

import mx.unam.ciencias.modelado.proyecto1.builder.Carrito;

/** 
 * Interfaz para representar diferentes idiomas en el sistema.
 * Esta interfaz define los métodos que las clases concretas de idiomas
 * deben implementar para mostrar textos en diferentes lenguajes.
 */
public interface Idioma {

    /**
     * Muestra el catálogo de productos en el idioma específico.
     * @return Una cadena con el catálogo de productos en el idioma implementado.
     */
    public String menuCatalogo();

    /**
     * Muestra un mensaje de saludo personalizado después de iniciar sesión.
     * @return Una cadena con el mensaje de saludo en el idioma implementado.
     */
    public String saludo();

    /**
     * Muestra los detalles del ticket de compra en el idioma específico.
     * Incluye los productos comprados y el tiempo que tardará en llegar.
     * @param dias Los días de espera antes de la llegada.
     * @param compra El objeto Carrito que contiene los productos comprados.
     * @return Una cadena con los detalles del ticket en el idioma implementado.
     */
    public String ticket(int dias, Carrito compra);

    /**
     * Muestra un mensaje de despedida que se muestra después de cerrar sesión.
     * @return Una cadena con el mensaje de despedida en el idioma implementado.
     */
    public String despedida();

    /**
     * Muestra la opción para ver el catálogo de productos.
     * @return Una cadena con la opción correspondiente.
     */
    public String opcionVerCatalogo();

    /**
     * Muestra la opción para agregar un producto al carrito.
     * @return Una cadena con la opción correspondiente.
     */
    public String opcionAgregarAlCarrito();

    /**
     * Muestra la opción para eliminar un producto del carrito.
     * @return Una cadena con la opción correspondiente.
     */
    public String opcionEliminarDelCarrito();

    /**
     * Muestra la opcion para proceder con el pago de los productos.
     * @return Una cadena con la opción correspondiente.
     */
    public String opcionProcederAlPago();

    /**
     * Muestra la opcion para ver los productos del carrito.
     * @return Una cadena con la opción correspondiente.
     */
    public String opcionVerCarrito();

    /**
     * Muestra la opción para cerrar sesión.
     * @return Una cadena con la opción correspondiente.
     */
    public String opcionCerrarSesion();

    /**
     * Muestra la opción para salir.
     * @return Una cadena con la opción correspondiente.
     */
    public String opcionSalir();
}
