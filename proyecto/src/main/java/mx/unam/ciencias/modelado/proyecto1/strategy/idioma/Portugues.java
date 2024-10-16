package mx.unam.ciencias.modelado.proyecto1.strategy.idioma;

/** Clase que implementa el idioma en portugues. 
* 
*/
public class Portugues implements Idioma {

    /**
     * Muestra el catalogo de productos en portugues.
     * @return Una cadena con la frase "Catalogo de produtos:".
     */

    @Override
    public String menuCatalogo() {
        return "Catalogo de produtos:";
    }

    /**
     * Muestra un saludo en portugues que se muestra despues de iniciar sesion.
     * @return Una cadena con la frase "Bem-vindo!".
     */

    @Override
    public String saludo() {
        return "Bem-vindo!";
    }

    /**
     * Muestra el contenido del ticket en portugues, dando los dias de espera antes de llegaday el contenido del carrito de compra.
     * @param dias El numero de dias que tardaran en llegar los productos.
     * @param compra El carrito de compras con los productos adquiridos.
     * @return Una cadena con los detalles del ticket, incluyendo dias de garantia y productos en el carrito.
     */

    @Override
    public String ticket(int dias, Carrito compra) {
        return "Itens no seu ticket:\n" +compra+ "\nDias de chegada: " + dias;
    }

    /**
     * Muestra un mensaje de despedida en portugues que se muestra despues de cerrar sesion.
     * @return Una cadena con la frase "Obrigado pela sua visita, ate logo!".
     */

    @Override
    public String despedida() {
        return "Obrigado pela sua visita, ate logo!";
    }

}