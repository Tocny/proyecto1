package mx.unam.ciencias.modelado.proyecto1.builder;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import mx.unam.ciencias.modelado.proyecto1.observer.ClienteObservador;
import mx.unam.ciencias.modelado.proyecto1.clientes.Pais;
import java.util.List;
import java.util.ArrayList;

public interface CarritoBuilder{
    public void agregarProducto(Producto producto);
    public void eliminarProducto(Producto producto);
    public void aplicarDescuentos(Departamento departamento, Pais pais, ProductoDecorator descuento);
    public Carrito buildCarrito();
}