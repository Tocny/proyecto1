package mx.unam.ciencias.modelado.proyecto1.decorator;

import mx.unam.ciencias.modelado.proyecto1.factory.ObjetoCheemsMart;
import mx.unam.ciencias.modelado.proyecto1.strategy.moneda.Moneda;

/**Interfaz para los productos de la tienda. */
public interface Producto extends ObjetoCheemsMart{

    /**
     * getter del nombre del producto.
     * @return una cadena que representa el nombre del producto.
     */
    public String getNombre();
    
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
     * Método para construir una descripcion del producto.
     * @param moneda la divisa para brindar información del producto.
     * @return una cadena con los datos del producto.
     */
    public String descripcion(Moneda moneda);
}