package mx.unam.ciencias.modelado.proyecto1.strategy.idioma;

import mx.unam.ciencias.modelado.proyecto1.builder.Carrito;
import java.io.Serializable;

/** 
 * Clase que implementa el idioma en portugués. 
 */
public class Portugues implements Idioma, Serializable {
    /**Para objetos serializables. */
    private static final long serialVersionUID = 1L;

    /**
     * Método que organiza una cadena completa en base a los demás métodos de opciones.
     * @return una cadena con el menú completo.
     */
    @Override public String menuCatalogo() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("=== MENU DO CATALOGO ===\n");
        sb.append("==========================\n");
        
        sb.append("Selecione uma opção:\n");
        sb.append("1. ").append(opcionVerCatalogo()).append("\n");
        sb.append("2. ").append(opcionAgregarAlCarrito()).append("\n");
        sb.append("3. ").append(opcionEliminarDelCarrito()).append("\n");
        sb.append("4. ").append(opcionVerCarrito()).append("\n");
        sb.append("5. ").append(opcionProcederAlPago()).append("\n");
        sb.append("6. ").append(opcionCerrarSesion()).append("\n");
        sb.append("7. ").append(opcionSalir()).append("\n");
        
        sb.append("==========================\n");
        sb.append("Por favor, insira sua escolha (1-7): ");
        
        return sb.toString();
    }


    /**
     * Método para un saludo.
     * @return Saludo en portugués.
     */
    @Override public String saludo() {
        return "Bem-vindo a CheemsMart!";
    }

    /**
     * Método para construir una cadena que funge como ticket de compra.
     * @param compra un carrito de compra.
     * @param dias los días que tardará en entregarse el pedido.
     * @return el ticket en portugues..
     */
    @Override public String ticket(int dias, Carrito compra) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n=== RECIBO DE COMPRA ===\n");
        sb.append("Data: ").append(java.time.LocalDate.now()).append("\n");
        sb.append("========================\n\n");

        sb.append("Cliente: ").append(compra.getCliente().getNombre()).append("\n\n");
        
        sb.append("Produtos:\n");
        sb.append(compra.recibo()).append("\n");
        
        sb.append("------------------------\n");
        sb.append("Total a pagar: ").append(String.format("%.2f", compra.calculaTotal())).append(" $").append("\n");
        
        sb.append("------------------------\n");
        sb.append("Tempo de chegada: ").append(dias).append(" dias\n");
        
        sb.append("========================\n");
        sb.append("Obrigado pela sua compra!\n");
        sb.append("Visite-nos novamente.\n");

        return sb.toString();
    }


    /**
     * Método para una despedida.
     * @return despedida en portugués.
     */
    @Override public String despedida() {
        return "Obrigado pela sua visita, até breve!";
    }

    /**
     * Método para la opción que corresponde a ver el catalogo de productos.
     * @return Mensaje en portugués.
     */
    @Override public String opcionVerCatalogo() {
        return "Ver catálogo de produtos.";
    }

    /**
     * Método para la opción de agregar productos al carro.
     * @return Mensaje en portugués.
     */
    @Override public String opcionAgregarAlCarrito() {
        return "Adicionar produto ao carrinho.";
    }

    /**
     * Método para la opcion de eliminar productos del carro.
     * @return Mensaje en portugués.
     */
    @Override public String opcionEliminarDelCarrito() {
        return "Remover produto do carrinho.";
    }

    /**
     * Método para la opción de proceder con el pago de los productos.
     * @return Mensaje en portugués.
     */
    @Override public String opcionProcederAlPago() {
        return "Prosseguir para o pagamento.";
    }

    /**
     * Método para la opción de ver los productos del carrito.
     * @return Mensaje en portugués.
     */
    @Override public String opcionVerCarrito() {
        return "Ver carrinho de compras.";
    }

    /**
     * Método para la opción de cerrar la sesión.
     * @return Mensaje en portugués.
     */
    @Override public String opcionCerrarSesion() {
        return "Sair da sessão.";
    }

    /**
     * Método para la opcion de salir de la tienda.
     * @return Mensaje en portugués
     */
    @Override public String opcionSalir() {
        return "Sair.";
    }
}
