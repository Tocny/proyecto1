package mx.unam.ciencias.modelado.proyecto1.decorator;

import mx.unam.ciencias.modelado.proyecto1.strategy.moneda.Moneda;
import java.io.Serializable;

public class ProductoConcreto implements Producto, Serializable{

    /**Para objetos serializables. */
    private static final long serialVersionUID = 1L;
    /**Codigo asociado al producto. */
    private String codigo;
    /**Nombre del producto. */
    private String nombre;
    /**Precio del producto. */
    private double precioBase;
    /**Departamento al que pertenece el producto. */
    private Departamento departamento;
    
    /**
     * Constructor de la clase. Asigna atributos.
     * @param codigo una cadena asociado al producto (aka codigo de barras).
     * @param nombre el nombre del producto.
     * @param precioBase el precio del producto (base, en dolares)
     * @param departamento el departamento al que pertenece el producto.
     */
    public ProductoConcreto(String codigo, String nombre, double precioBase, Departamento departamento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.departamento = departamento;
    }

    /**
     * Getter del codigo del producto.
     * @return codigo.
     */
    @Override public String getCodigo(){
        return codigo;
    }

    /**
     * Setter del codigo del producto.
     * @param codigo el nuevo codigo del producto.
     */
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    /**
     * Getter del nombre.
     * @return nombre.
     */
    @Override public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre.
     * @param nombre el nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del precio base del producto.
     * @return precioBase.
     */
    @Override public double getPrecioBase(){
        return precioBase;
    }

    /**
     * Setter del precio base del producto.
     * @param precioBase el nuevo precio base.
     */
    public void setPrecioBase(double precioBase){
        this.precioBase = precioBase;
    }

    /**
     * Getter del precio del producto
     * @return el precio del producto.
     */
    @Override public double getPrecio(Moneda moneda) {
        return moneda.calculaPrecio(precioBase);
    }

    /**
     * Setter del precio del producto
     * @param precio el nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precioBase = precio; // Almacena el precio base
    }

    /**
     * Getter del departamento del producto.
     * @return departamento.
     */
    @Override public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * Setter del departamento.
     * @param departamento el nuevo departamento del producto.
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * Método que devuelve una descripción del producto.
     * @return una cadena similar a "Laptop - $1000.00 (USD, Electrónica)"
     */
    @Override public String descripcion(Moneda moneda) {
        return String.format("%s - $%.2f (%s ,%s)", nombre, getPrecio(moneda), moneda.getNombre(),  departamento);
    }

}
