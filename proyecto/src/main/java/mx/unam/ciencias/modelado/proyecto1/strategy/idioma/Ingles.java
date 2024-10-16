package mx.unam.ciencias.modelado.proyecto1.strategy.idioma;

import mx.unam.ciencias.modelado.proyecto1.builder.Carrito;

/** Clase que implementa el idioma en ingles. 
* 
*/

public class Ingles implements Idioma {

    /**
     * Muestra el catalogo de productos en ingles.
     * @return Una cadena con la frase "Product catalog:".
     */

    @Override
    public String menuCatalogo() {
        return "Product catalog:";
    }

    /**
     * Muestra un saludo en ingles que se muestra despues de iniciar sesion.
     * @return Una cadena con la frase "Welcome!".
     */

    @Override
    public String saludo() {
        return "Welcome!";
    }

    /**
     * Muestra el contenido del ticket en ingles, dando los dias de espera antes de llegaday el contenido del carrito de compra.
     * @param dias El numero de dias que tardaran en llegar los productos.
     * @param compra El carrito de compras con los productos adquiridos.
     * @return Una cadena con los detalles del ticket, incluyendo dias de garantia y productos en el carrito.
     */

    @Override
    public String ticket(int dias, Carrito compra) {
        return "Items in your ticket:\n" +compra+ "\nArrival time: " + dias;
    }

    /**
     * Muestra un mensaje de despedida en ingles que se muestra despues de cerrar sesion.
     * @return Una cadena con la frase "Thank you for your visit, see you soon!".
     */

    @Override
    public String despedida() {
        return "Thank you for your visit, see you soon!";
    }
    
}