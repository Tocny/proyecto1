package mx.unam.ciencias.modelado.proyecto1.strategy.idioma;

import mx.unam.ciencias.modelado.proyecto1.builder.Carrito;

/** 
 * Clase que implementa el idioma en español. 
 */
public class Espanol implements Idioma {

    /**
     * Método que organiza una cadena completa en base a los demás métodos de opciones.
     * @return una cadena con el menú completo.
     */
    @Override public String menuCatalogo() {
        StringBuilder sb = new StringBuilder();
        sb.append("----- Menú del Catálogo -----\n");
        sb.append("1. ").append(opcionVerCatalogo()).append("\n");
        sb.append("2. ").append(opcionAgregarAlCarrito()).append("\n");
        sb.append("3. ").append(opcionEliminarDelCarrito()).append("\n");
        sb.append("4. ").append(opcionCerrarSesion()).append("\n");
        sb.append("5. ").append(opcionSalir()).append("\n");
        return sb.toString();
    }

    /**
     * Método para un saludo.
     * @return Saludo en español.
     */
    @Override public String saludo() {
        return "¡Bienvenido!";
    }

    /**
     * Método para construir una cadena que funje como ticket de compra.
     * @param compra un carrito de compra.
     * @param dias los días que tardará en entregarse el pedido.
     * @return el ticket en español.
     */
    @Override public String ticket(int dias, Carrito compra) {
        StringBuilder sb = new StringBuilder();
        sb.append("Productos en tu ticket:\n");
        sb.append(compra.recibo());
        sb.append("Total a pagar: ").append(compra.calculaTotal()).append(" $").append("\n");
        sb.append("Tiempo de llegada: ").append(dias).append(" días.");
        return sb.toString();
    }

    /**
     * Método para una despedida.
     * @return despedida en español.
     */
    @Override public String despedida() {
        return "Gracias por su visita, ¡hasta pronto!";
    }

    /**
     * Método para la opción que corresponde a ver el catalogo de productos.
     * @return Mensaje en español.
     */
    @Override public String opcionVerCatalogo() {
        return "Ver catálogo de productos.";
    }

    /**
     * Método para la opción de agregar productos al carro.
     * @return Mensaje en español.
     */
    @Override public String opcionAgregarAlCarrito() {
        return "Agregar producto al carrito.";
    }

    /**
     * Método para la opcion de eliminar productos del carro.
     * @return Mensaje en español.
     */
    @Override public String opcionEliminarDelCarrito() {
        return "Eliminar producto del carrito.";
    }

    /**
     * Método para la opción de cerrar la sesión.
     * @return Mensaje en español.
     */
    @Override public String opcionCerrarSesion() {
        return "Cerrar sesión.";
    }

    /**
     * Método para la opcion de salir de la tienda.
     * @return Mensaje en español
     */
    @Override public String opcionSalir() {
        return "Salir.";
    }
}
