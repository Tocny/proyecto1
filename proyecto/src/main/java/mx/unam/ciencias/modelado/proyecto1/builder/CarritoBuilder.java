public interface CarritoBuilder{
    public void agregarProducto(Producto producto);
    public void eliminarProducto(Producto producto);
    public void aplicarDescuentos(Departamento departamento);
    public Carrito buildCarrito();
}