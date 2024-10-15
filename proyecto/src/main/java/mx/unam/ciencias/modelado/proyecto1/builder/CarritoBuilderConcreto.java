public class CarritoBuilderConcreto implements CarritoBuilder{
    List<Producto> productos;
    Cliente cliente;

    /**
     * Constructor del CarritoConcreto
     * @param cliente
     */
    public CarritoBuilderConcreto(Cliente cliente){
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    /**
     * Metodo que agrega un producto a la lista del carrito
     */
    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    /**
     * Metodo que elimina el producto indicado de la lista del carrito
     * @param producto
     */
    public void eliminarProducto(Producto producto){
        productos.remove(producto);
    }

    /**
     * Metodo que aplica los descuentos a la lista de productos del cliente
     * Entra en un ciclo con todos los productos de la lista y revisa si el producto pertenece al departamento deseado, asi como si el cliente es del pais deseado
     * Si las condiciones se cumplen el descuento indicado se le aplica al producto
     * @param departamento
     * @param descuento
     */
    public void aplicarDescuentos(Departamento departamento, Pais pais, ProductoDecorator descuento){
        for (Producto producto : productos) {
            if(producto.getDepartamento() == departamento && cliente.getPais() == pais){
                descuento.envolver(producto);
            }
        }
    }

    /**
     * Metodo que mediante el constructor de la clase Carrito, le pasa los parametros creados en el builder y crea un carrito
     * @return Carrito
     */
    public Carrito buildCarrito(){
        return new Carrito(productos, cliente);
    }
}