package mx.unam.ciencias.modelado.proyecto1.strategy.idioma;

import mx.unam.ciencias.modelado.proyecto1.builder.Carrito;
import java.io.Serializable;

/** 
 * Clase que implementa el idioma en inglés. 
 */
public class Ingles implements Idioma, Serializable{
    
    /**Para objetos serializables. */
    private static final long serialVersionUID = 1L;

    /**
     * Método que organiza una cadena completa en base a los demás métodos de opciones.
     * @return una cadena con el menú completo.
     */
    @Override public String menuCatalogo() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n=== CATALOG MENU ===\n");
        sb.append("====================\n");
        
        sb.append("Select an option:\n");
        sb.append("1. ").append(opcionVerCatalogo()).append("\n");
        sb.append("2. ").append(opcionAgregarAlCarrito()).append("\n");
        sb.append("3. ").append(opcionEliminarDelCarrito()).append("\n");
        sb.append("4. ").append(opcionVerCarrito()).append("\n");
        sb.append("5. ").append(opcionProcederAlPago()).append("\n");
        sb.append("6. ").append(opcionCerrarSesion()).append("\n");
        sb.append("7. ").append(opcionSalir()).append("\n");
        
        sb.append("====================\n");
        sb.append("Please enter your choice (1-7): ");
        
        return sb.toString();
    }


    /**
     * Método para un saludo.
     * @return Saludo en inglés.
     */
    @Override public String saludo() {
        return "Welcome to CheemsMart!";
    }

    /**
     * Método para construir una cadena que funge como ticket de compra.
     * @param compra un carrito de compra.
     * @param dias los días que tardará en entregarse el pedido.
     * @return el ticket en inglés.
     */
    @Override public String ticket(int dias, Carrito compra) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n=== PURCHASE RECEIPT ===\n");
        sb.append("Date: ").append(java.time.LocalDate.now()).append("\n");
        sb.append("========================\n\n");

        sb.append("Costumer: ").append(compra.getCliente().getNombre()).append("\n\n");
        
        sb.append("Products:\n");
        sb.append(compra.recibo()).append("\n");
        
        sb.append("------------------------\n");
        sb.append("Total to pay: $").append(String.format("%.2f", compra.calculaTotal())).append("\n");
        
        sb.append("------------------------\n");
        sb.append("Estimated delivery time: ").append(dias).append(" days\n");
        
        sb.append("========================\n");
        sb.append("Thank you for your purchase!\n");
        sb.append("Come back soon.\n");

        return sb.toString();
    }


    /**
     * Método para una despedida.
     * @return despedida en inglés.
     */
    @Override public String despedida() {
        return "Thank you for your visit, see you soon!";
    }

    /**
     * Método para la opción que corresponde a ver el catalogo de productos.
     * @return Mensaje en inglés.
     */
    @Override public String opcionVerCatalogo() {
        return "View product catalog.";
    }

    /**
     * Método para la opción de agregar productos al carro.
     * @return Mensaje en inglés.
     */
    @Override public String opcionAgregarAlCarrito() {
        return "Add product to cart.";
    }

     /**
     * Método para la opcion de eliminar productos del carro.
     * @return Mensaje en inglés.
     */
    @Override public String opcionEliminarDelCarrito() {
        return "Remove product from cart.";
    }

    /**
     * Método para la opción de proceder con el pago de los productos.
     * @return Mensaje en inglés.
     */
    @Override public String opcionProcederAlPago() {
        return "Proceed to payment.";
    }

    /**
     * Método para la opción de ver los productos del carrito.
     * @return Mensaje en inglés.
     */
    @Override public String opcionVerCarrito() {
        return "View shopping cart.";
    }

    /**
     * Método para la opción de cerrar la sesión.
     * @return Mensaje en inglés.
     */
    @Override public String opcionCerrarSesion() {
        return "Log out.";
    }

    /**
     * Método para la opcion de salir de la tienda.
     * @return Mensaje en inglés
     */
    @Override public String opcionSalir() {
        return "Exit.";
    }
}
