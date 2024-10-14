package mx.unam.ciencias.modelado.proyecto1.strategy.moneda;

/**Clase concreta Real que implementa la interfaz Moneda. */
public class Real implements Moneda{

    /**
     * Implementación del método getNombre.
     * @return La cadena "BRL" El codigo ISO del Real Brasileño.
     */
    @Override public String getNombre(){
        return "BRL";
    }

    /**
     * Implementación del método calcula precio.
     * @return una conversión de dolar a real :p.
     */
    @Override public double calculaPrecio(double precioBase){
        return precioBase * 5.61;
    }

}