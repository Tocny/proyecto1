package mx.unam.ciencias.modelado.proyecto1.strategy.moneda;

import java.io.Serializable;

/**Clase concreta Dolar que implementa la interfaz Moneda. */
public class Dolar implements Moneda, Serializable{

    // serialVersionUID para mantener la compatibilidad de versiones
    private static final long serialVersionUID = 1L;

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