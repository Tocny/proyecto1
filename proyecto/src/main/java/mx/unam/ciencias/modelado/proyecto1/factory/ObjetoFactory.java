package mx.unam.ciencias.modelado.proyecto1.factory;

import mx.unam.ciencias.modelado.proyecto1.decorator.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * Fabrica del patrón factory. Se encarga principalmente de generar una lista
 * de objetos dada una forma de fabricar esos objetos.
 */
public abstract class ObjetoFactory{

    /**
     * Método que genera una lista de productos (catalogo) a partir de una lista de cadenas que
     * contienen los datos de cada producto.
     * @param lineas una lista de cadenas, se asume que está separada por ",".
     * @return una lista de implementaciones de la interfaz ObjetoCheemsMart.
     */
    public List<ObjetoCheemsMart> generaListaObjetos(List<String> lineas){
        List<ObjetoCheemsMart> productos = new ArrayList<>();

        for(String linea: lineas){
            String[] datos = linea.split(",");
            productos.add(fabricaObjeto(datos));
        }

        return productos;
    }

    /**
     * Método abstracto que creará un producto a partir de tres cadenas.
     * @param datos un arreglo de cadenas que pueda ser empleado para crear un objeto.
     * @return una instancia de Producto con los datos dados.
     */
    public abstract ObjetoCheemsMart fabricaObjeto(String[] datos);

}