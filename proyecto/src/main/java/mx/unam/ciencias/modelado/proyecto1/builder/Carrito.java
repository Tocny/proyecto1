package mx.unam.ciencias.modelado.proyecto1.builder;

import mx.unam.ciencias.modelado.proyecto1.decorator.Producto;
import mx.unam.ciencias.modelado.proyecto1.strategy.moneda.Moneda;
import mx.unam.ciencias.modelado.proyecto1.observer.ClienteObservador;
import mx.unam.ciencias.modelado.proyecto1.clientes.*;
import java.util.List;


public class Carrito {
    /**Lista de productos del carrito */
    List<Producto> productos;

    /**Cliente al que pertenece el carrito */
    ClienteObservador cliente;

    /**
     * Constructor del objeto final carrito, sus parametros fueron antes manejados con el builder
     * @param productos
     * @param cliente
     */
    public Carrito(List<Producto> productos, ClienteObservador cliente){
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
    public ClienteObservador getCliente(){
        return this.cliente;
    }

    /**
     * Método que crea una cadena de texto que sirve como recibo
     * @return recibo de compra
     */
    public String recibo(){

        Moneda divisa = cliente.getCuentaBancaria().getMoneda();

        StringBuilder recibo = new StringBuilder("RECIBO DE COMPRA:\n");
        double totalBase = 0;
        double total = 0;
        for (Producto producto : productos) {
            recibo.append(producto.getNombre()).append(" - Precio Base: ").append(producto.getPrecioBase()).append(" - Precio c/ descuento: ").append(producto.getPrecio(divisa)).append("\n");
            total += producto.getPrecio(divisa);
            total += producto.getPrecioBase();
        }
        double ahorro = totalBase - total;
        recibo.append("Total: ").append(totalBase).append(" - Total con descuento: ").append(total).append("\n");
        recibo.append("Ahorraste ").append(ahorro).append("!!!");

        return recibo.toString();
    }
}
