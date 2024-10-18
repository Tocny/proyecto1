package mx.unam.ciencias.modelado.proyecto1.decorator;

/**
 * Esto consiste en el NullObjectPattern de nuestro proyecto.
 * Corresponde a un producto concreto de valor inocuo, para evitar NullPointerException.
 */
public class ProductoNulo extends ProductoConcreto{

    /**Constructor de la clase, llama al constructor del padre con argumentos nulos. */
    public ProductoNulo(){
        super("0000", "Nulo", 0.0, Departamento.NONE);
    }
}