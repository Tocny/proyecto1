package mx.unam.ciencias.modelado.proyecto1.decorator;

import mx.unam.ciencias.modelado.proyecto1.strategy.moneda.Moneda;

/**Clase decoradora, para aplicar 15% de descuento. */
public class Descuento15 extends ProductoDecorator {

    /**
     * Constructor de la clase, asigna el producto.
     * @param producto el producto que se decorará.
     */
    public Descuento15(Producto producto) {
        super(producto);
    }

    /**
     * Calcula el precio del producto aplicando un descuento del 15%.
     * @param moneda la moneda en la que se calculará el precio.
     * @return el precio del producto con el descuento aplicado.
     */
    @Override public double getPrecio(Moneda moneda) {
        return super.producto.getPrecio(moneda) * 0.85;
    }

    /**
     * Devuelve una descripción del producto con el descuento aplicado.
     * @param moneda la moneda en la que se mostrará la descripción.
     * @return una cadena con la descripción del producto.
     */
    @Override public String descripcion(Moneda moneda) {
        return super.producto.descripcion(moneda) + "[-15%]";
    }
}
