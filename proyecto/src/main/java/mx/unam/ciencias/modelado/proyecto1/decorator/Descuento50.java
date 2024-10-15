package mx.unam.ciencias.modelado.proyecto1.decorator;

import mx.unam.ciencias.modelado.proyecto1.strategy.moneda.Moneda;

/**Clase decoradora, para aplicar 50% de descuento. */
public class Descuento50 extends ProductoDecorator {

    /**
     * Constructor de la clase, asigna el producto.
     * @param producto el producto que se decorará.
     */
    public Descuento50(Producto producto) {
        super(producto);
    }

    /**
     * Calcula el precio del producto aplicando un descuento del 50%.
     * @param moneda la moneda en la que se calculará el precio.
     * @return el precio del producto con el descuento aplicado.
     */
    @Override public double getPrecio(Moneda moneda) {
        return super.producto.getPrecio(moneda) * 0.50;
    }

    /**
     * Devuelve una descripción del producto con el descuento aplicado.
     * @param moneda la moneda en la que se mostrará la descripción.
     * @return una cadena con la descripción del producto.
     */
    @Override public String descripcion(Moneda moneda) {
        return super.producto.descripcion(moneda) + "[-50%]";
    }

    /**
     * Método envolver que nos permite envolver objetos entrantes a partir de instancias concretas.
     * @param producto el producto que se desea envolver.
     * @return una instancia del producto recibido con el decorador especifico.
     */
    @Override public Producto envolver(Producto producto){
        return new Descuento50(producto);
    }
}
