package mx.unam.ciencias.modelado.proyecto1.decorator;

import mx.unam.ciencias.modelado.proyecto1.strategy.moneda.Moneda;

/** Interfaz para los productos de la tienda. */
public interface Producto {

    /**
     * Getter del precio base del producto, todos los productos tienen un precio sin ofertas y en dolares.
     * @return el precio original del producto.
     */
    public double getPrecioBase();

    /**
     * Setter para establecer el precio base del producto.
     * @param precio el nuevo precio del producto.
     */
    public void setPrecioBase(double precio);

    /**
     * Getter del código de barras de un producto.
     * @return una cadena que representa un identificador para un producto.
     */
    public String getCodigo();

    /**
     * Setter para establecer el código de barras de un producto.
     * @param codigo el nuevo código de barras del producto.
     */
    public void setCodigo(String codigo);

    /**
     * Getter del nombre del producto.
     * @return una cadena que representa el nombre del producto.
     */
    public String getNombre();

    /**
     * Setter para establecer el nombre del producto.
     * @param nombre el nuevo nombre del producto.
     */
    public void setNombre(String nombre);

    /**
     * Getter del precio del producto.
     * @param moneda la divisa para calcular el precio.
     * @return el precio del producto.
     */
    public double getPrecio(Moneda moneda);

    /**
     * Getter del departamento del producto.
     * @return una instancia de Departamento.
     */
    public Departamento getDepartamento();

    /**
     * Setter para establecer el departamento del producto.
     * @param departamento el nuevo departamento del producto.
     */
    public void setDepartamento(Departamento departamento);

    /**
     * Método para construir una descripción del producto.
     * @param moneda la divisa para brindar información del producto.
     * @return una cadena con los datos del producto.
     */
    public String descripcion(Moneda moneda);
}
