package mx.unam.ciencias.modelado.proyecto1.builder;

import mx.unam.ciencias.modelado.proyecto1.decorator.Producto;
import mx.unam.ciencias.modelado.proyecto1.strategy.moneda.Moneda;
import mx.unam.ciencias.modelado.proyecto1.clientes.Cliente;
import java.util.List;


public class Carrito {
    /**Lista de productos del carrito */
    List<Producto> productos;

    /**Cliente al que pertenece el carrito */
    Cliente cliente;

    /**
     * Constructor del objeto final carrito, sus parametros fueron antes manejados con el builder
     * @param productos la lista de productos.
     * @param cliente un cliente asociado al carrito.
     */
    public Carrito(List<Producto> productos, Cliente cliente){
        this.productos = productos;
        this.cliente = cliente;
    }

    /**
     * Getter de la lista de productos
     * @return lista de productos
     */
    public List<Producto> getProductos(){
        return productos;
    }

    /**
     * Getter del cliente dueño del carrito
     * @return cliente
     */
    public Cliente getCliente(){
        return this.cliente;
    }

    /**
     * Método que crea una cadena de texto que sirve como recibo
     * @return recibo de compra
     */
    public String recibo(){
        Moneda divisa = cliente.getCuentaBancaria().getMoneda();
        StringBuilder recibo = new StringBuilder();
        double totalBase = 0;
        double total = 0;
        for (Producto producto : productos) {
            recibo.append(producto.descripcion(divisa)).append("\n");
        }

        return recibo.toString();
    }

    /**
     * Método que calcula el total de precios de los productos en el carrito.
     * @return el total de los precios considerando la divisa del cliente
     */
    public double calculaTotal() {
        Moneda divisa = cliente.getCuentaBancaria().getMoneda();
        double total = 0;
        
        for (Producto producto : productos) {
            total += producto.getPrecio(divisa);  // Sumar el precio de cada producto ajustado a la divisa
        }
        
        return total;
    }
}
