package mx.unam.ciencias.modelado.proyecto1.decorator;

import mx.unam.ciencias.modelado.proyecto1.strategy.moneda.Moneda;

public class ProductoConcreto implements Producto{
    
    /**Nombre del producto. */
    private String nombre;
    /**Precio del producto. */
    private double precioBase;
    /**Departamento al que pertenece el producto. */
    private Departamento departamento;

    /**
     * Constructor de la clase. Asigna atributos.
     * @param nombre el nombre del producto.
     * @param precioBase el precio del producto (base, en dolares)
     * @param departamento el departamento al que pertenece el producto.
     */
    public ProductoConcreto(String nombre, double precioBase, Departamento departamento) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.departamento = departamento;
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
    public double getPrecioBase(){
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
