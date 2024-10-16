package mx.unam.ciencias.modelado.proyecto1.decorator;

import mx.unam.ciencias.modelado.proyecto1.strategy.moneda.Moneda;

/**Clase decoradora, para aplicar 25% de descuento. */
public class Descuento25 extends ProductoDecorator {

    /**
     * Constructor de la clase, asigna el producto.
     * @param producto el producto que se decorará.
     */
    public Descuento25(Producto producto) {
        super(producto);
    }

    /**
     * Calcula el precio del producto aplicando un descuento del 25%.
     * @param moneda la moneda en la que se calculará el precio.
     * @return el precio del producto con el descuento aplicado.
     */
    @Override public double getPrecio(Moneda moneda) {
        return super.producto.getPrecio(moneda) * 0.75;
    }

    /**
     * Devuelve una descripción del producto con el descuento aplicado.
     * @param moneda la moneda en la que se mostrará la descripción.
     * @return una cadena con la descripción del producto.
     */
    @Override public String descripcion(Moneda moneda) {
        return super.producto.descripcion(moneda) + "[-25%]";
    }

    /**
     * Método envolver que nos permite envolver objetos entrantes a partir de instancias concretas.
     * @param producto el producto que se desea envolver.
     * @return una instancia del producto recibido con el decorador especifico.
     */
    @Override public Producto envolver(Producto producto){
        return new Descuento25(producto);
    }

    /**
     * Método para lanzar un mensaje de oferta, es una breve descripción de la oferta.
     * @param departamento el departamento de productos sobre los que se aplica la oferta.
     * @return cadena que describe la oferta.
     */
    @Override public String mensajeOferta(Departamento departamento){
        return "Oferta: 25% de descuento en productos: " + departamento.name();
    }
}
