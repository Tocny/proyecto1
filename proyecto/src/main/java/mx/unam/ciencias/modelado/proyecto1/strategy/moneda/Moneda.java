package mx.unam.ciencias.modelado.proyecto1.strategy.moneda;

/**Interfaz para las divisas (monedas). */
public interface Moneda{

    /**
     * Para obtener el nombre de la divisa.
     */
    public String getNombre();

    /**
     * Para calcular la conversión.
     */
    public double calculaPrecio(double precioBase);
}