package mx.unam.ciencias.modelado.proyecto1.strategy.moneda;

/**Interfaz para las divisas (monedas). */
public interface Moneda{

    /**
     * Para obtener el nombre de la divisa.
     * @return el codigo ISO de la divisa especifica.
     */
    public String getNombre();

    /**
     * Para calcular la conversión.
     * @param precioBase un precio base para el calculo del precio especifico (conversión USD a cualquier otra moneda).
     * @return el valor convertido según el precioBase.
     */
    public double calculaPrecio(double precioBase);
}