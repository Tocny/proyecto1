public class Carrito {
    /**Lista de productos del carrito */
    List<Producto> productos;

    /**Cliente al que pertenece el carrito */
    Cliente cliente;

    /**
     * Constructor del objeto final carrito, sus parametros fueron antes manejados con el builder
     * @param productos
     * @param cliente
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
        return this.productos();
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
        StringBuilder recibo = new StringBuilder("RECIBO DE COMPRA:\n");
        double totalBase = 0;
        double total = 0;
        for (Producto producto : productos) {
            recibo.append(producto.getNombre()).append(" - Precio Base: ").append(producto.getPrecioBase()).append(" - Precio c/ descuento: ").append(producto.getPrecio()).append("\n");
            total += producto.getPrecio();
            total += producto.getPrecioBase();
        }
        double ahorro = totalBase - total;
        recibo.append("Total: ").append(totalBase).append(" - Total con descuento: ").append(total).append("\n");
        recibo.append("Ahorraste ").append(ahorro).append("!!!");
    }
}
