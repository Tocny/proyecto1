package mx.unam.ciencias.modelado.proyecto1.strategy.idioma;

/** 
 * Clase que implementa el idioma en espaniol. 
 */

public class Espanol implements Idioma {

    /**
     * Muestra el catalogo de productos en espaniol.
     * @return Una cadena con la frase "Catalogo de productos:".
     */

    @Override
    public String menuCatalogo() {
        return "Catalogo de productos:";
    }

    /**
     * Muestra un saludo en espaniol que se muestra despues de iniciar sesion.
     * @return Una cadena con la frase "¡Bienvenido!".
     */

    @Override
    public String saludo() {
        return "¡Bienvenido!";
    }

    /**
     * Muestra el contenido del ticket en espaniol, dando los dias de espera antes de llegaday el contenido del carrito de compra.
     * @param dias El numero de dias que tardaran en llegar los productos.
     * @param compra El carrito de compras con los productos adquiridos.
     * @return Una cadena con los detalles del ticket, incluyendo dias de garantia y productos en el carrito.
     */
    @Override
    public String ticket(int dias, Carrito compra) {
        return "Productos en tu ticket:\n" +compra+ "\nTiempo de llegada: "+dias;
    }

    /**
     * Muestra un mensaje de despedida en espaniol que se muestra despues de cerrar sesion.
     * @return Una cadena con la frase "Gracias por su visita, ¡hasta pronto!".
     */
    @Override
    public String despedida() {
        return "Gracias por su visita, ¡hasta pronto!";
    }
    
}