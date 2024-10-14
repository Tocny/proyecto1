package mx.unam.ciencias.modelado.proyecto1.strategy.moneda;

/**Clase concreta Dolar que implementa la interfaz Moneda. */
public class Dolar implements Moneda{

    /**
     * Implementación del método getNombre.
     * @return La cadena "USD" El codigo ISO del dolar americano.
     */
    @Override public String getNombre(){
        return "USD";
    }

    /**
     * Implementación del método calcula precio.
     * @return una conversión de dolar a dolar :p.
     */
    @Override public double calculaPrecio(double precioBase){
        return precioBase * 1.00;
    }

}