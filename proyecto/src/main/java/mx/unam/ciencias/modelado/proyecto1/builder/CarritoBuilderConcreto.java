package mx.unam.ciencias.modelado.proyecto1.builder;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import mx.unam.ciencias.modelado.proyecto1.clientes.*;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class CarritoBuilderConcreto implements CarritoBuilder, Serializable{

    /**Para objetos serializables. */
    private static final long serialVersionUID = 1L;
    /**Para guardar la lista de productos del carrito. */
    List<Producto> productos;
    /**Para asignar un cliente. */
    Cliente cliente;
    
    /**
     * Constructor del CarritoConcreto, asigna atributos
     * @param cliente el cliente al que está asocciado el carro.
     */
    public CarritoBuilderConcreto(Cliente cliente){
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    /**
     * Metodo que agrega un producto a la lista del carrito
     * @param producto el producto que va a agregarse.
     */
    @Override public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    /**
     * Metodo que elimina el producto indicado de la lista del carrito
     * @param producto el producto que va a eliminarse.
     */
    @Override public void eliminarProducto(Producto producto){
        boolean removed = productos.remove(producto);
    
        if (!removed) {
            throw new IllegalArgumentException("El producto '" + producto.getNombre() + "' no está en el carrito.");
        }
    }

    /**
     * Metodo que aplica los descuentos a la lista de productos del cliente
     * Entra en un ciclo con todos los productos de la lista y revisa si el producto pertenece al departamento deseado, asi como si el cliente es del pais deseado
     * Si las condiciones se cumplen el descuento indicado se le aplica al producto
     * @param descuento el descuento que va a aplicarse sobre los productos.
     */
    @Override public void aplicarDescuentos(ProductoDecorator descuento) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getDepartamento() == descuento.getDepartamento() && (cliente.getPais() == descuento.getRegion())) {
                productos.set(i, descuento.envolver(producto));
            } 
        }
    }


    /**
     * Metodo que mediante el constructor de la clase Carrito, le pasa los parametros creados en el builder y crea un carrito
     * @return Carrito
     */
    @Override public Carrito buildCarrito(){
        return new Carrito(productos, cliente);
    }
}