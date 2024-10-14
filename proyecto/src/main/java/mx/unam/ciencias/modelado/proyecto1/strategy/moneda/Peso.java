package mx.unam.ciencias.modelado.proyecto1.strategy.moneda;

/**Clase concreta Peso que implementa la interfaz Moneda. */
public class Peso implements Moneda{

    /**
     * Implementación del método getNombre.
     * @return La cadena "MXN" el codigo ISO de la divisa del peso mexicano.
     */
    @Override public String getNombre(){
        return "MXN";
    }

    /**
     * Implementación del método calculaPrecio.
     * @return una conversión del dolar al peso mexicano.
     */
    @Override public double calculaPrecio(double precioBase){
        return precioBase * 19.31;
    }

}