package mx.unam.ciencias.modelado.proyecto1.decorator;

import mx.unam.ciencias.modelado.proyecto1.strategy.moneda.Moneda;
import java.io.Serializable;

public abstract class ProductoDecorator implements Producto, Serializable {

    /** Para objetos serializables. */
    private static final long serialVersionUID = 1L;
    /** Producto asociado al decorador. */
    protected Producto producto;

    /**
     * Constructor de la clase, asigna el atributo producto.
     * @param producto un producto.
     */
    public ProductoDecorator(Producto producto) {
        this.producto = producto;
    }

    /**
     * Getter del precio base del producto. En caso de tener que acceder a él a pesar de haber sido decorado.
     * @return precio base de la instancia de producto.
     */
    @Override public double getPrecioBase() {
        return producto.getPrecioBase();
    }

    /**
     * Setter para establecer el precio base del producto.
     * @param precio el nuevo precio base del producto.
     */
    @Override 
    public void setPrecioBase(double precio) {
        producto.setPrecioBase(precio);
    }

    /**
     * Getter del código asociado al producto.
     * @return el método getCodigo() del producto local.
     */
    @Override public String getCodigo() {
        return producto.getCodigo();
    }

    /**
     * Setter para establecer el código de barras de un producto.
     * @param codigo el nuevo código de barras del producto.
     */
    @Override public void setCodigo(String codigo) {
        producto.setCodigo(codigo);
    }

    /**
     * Getter del nombre del producto.
     * @return el nombre del producto.
     */
    @Override public String getNombre() {
        return producto.getNombre();
    }

    /**
     * Setter para establecer el nombre del producto.
     * @param nombre el nuevo nombre del producto.
     */
    @Override public void setNombre(String nombre) {
        producto.setNombre(nombre);
    }

    /**
     * Getter del departamento al que pertenece el producto.
     * @return departamento del producto.
     */
    @Override public Departamento getDepartamento() {
        return producto.getDepartamento();
    }

    /**
     * Setter para establecer el departamento del producto.
     * @param departamento el nuevo departamento del producto.
     */
    @Override public void setDepartamento(Departamento departamento) {
        producto.setDepartamento(departamento);
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
     * @return una instancia del producto recibido con el decorador específico.
     */
    public abstract Producto envolver(Producto producto);

    /**
     * Método para lanzar un mensaje de oferta, es una breve descripción de la oferta.
     * @return cadena que describe la oferta.
     */
    public abstract String mensajeOferta();
}
