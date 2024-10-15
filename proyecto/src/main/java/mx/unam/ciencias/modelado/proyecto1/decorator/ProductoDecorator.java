package mx.unam.ciencias.modelado.proyecto1.decorator;

import mx.unam.ciencias.modelado.proyecto1.strategy.moneda.Moneda;

public abstract class ProductoDecorator implements  Producto{

    /**Producto asociado al decorador. */
    protected Producto producto;

    /**
     * Constructor de la clase, asigna el atributo producto.
     * @param producto un producto.
     */
    public ProductoDecorator(Producto producto) {
        this.producto = producto;
    }

    /**
     * Getter del precio base del producto. En caso de tener que acceder a el a pesar de haber sido decorado.
     * @return precio base de la instancia de producto.
     */
    @Override public double getPrecioBase(){
        return producto.getPrecioBase();
    }

    /**
     * Getter del codigo asociado al producto.
     * @return el método getCodigo() del producto local.
     */
    @Override public String getCodigo(){
        return producto.getCodigo();
    }

    /**
     * Getter del nombre del producto
     * @return el nombre del producto.
     */
    @Override public String getNombre() {
        return producto.getNombre();
    }

    /**
     * Getter del departamento al que pertenece el producto.
     * @return departametno del producto.
     */
    @Override public Departamento getDepartamento() {
        return producto.getDepartamento();
    }

    /**
     * Descripción del producto.
     * @return una cadena con la descripción del producto.
     */
    @Override public abstract String descripcion(Moneda moneda);

    /**
     * Método abstracto para el precio del producto.
     */
    @Override public abstract double getPrecio(Moneda moneda);

    /**
     * Método envolver que nos permite envolver objetos entrantes a partir de instancias concretas.
     * @param producto el producto que se desea envolver.
     * @return una instancia del producto recibido con el decorador especifico.
     */
    public abstract Producto envolver(Producto producto);
}