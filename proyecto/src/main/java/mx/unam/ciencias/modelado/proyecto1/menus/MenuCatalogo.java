package mx.unam.ciencias.modelado.proyecto1.menus;

import mx.unam.ciencias.modelado.proyecto1.decorator.Producto;
import mx.unam.ciencias.modelado.proyecto1.clientes.*;
import mx.unam.ciencias.modelado.proyecto1.observer.ClienteObservador;
import mx.unam.ciencias.modelado.proyecto1.strategy.idioma.*;
import mx.unam.ciencias.modelado.proyecto1.strategy.moneda.*;
import mx.unam.ciencias.modelado.proyecto1.builder.*;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaproductos.ProductoIterable;
import mx.unam.ciencias.modelado.proyecto1.common.MetodosGet;

/**
 * Clase que representa el menú del catálogo de productos.
 */
public class MenuCatalogo {

    /** Catálogo de productos. */
    private ProductoIterable catalogo;
    /** Cliente sobre el cual vamos a trabajar. */
    private ClienteObservador cliente;
    /** Idioma del menú. */
    private Idioma idioma;
    /** Builder del carro de compra. */
    private CarritoBuilder armadorCarro;
    /**divisa del menú, importante si necesitamos ver precios. */
    private Moneda divisa;

    /**
     * Constructor de la clase, asigna atributos.
     * @param catalogo un objeto iterable de productos.
     * @param cliente un cliente.
     */
    public MenuCatalogo(ProductoIterable catalogo, ClienteObservador cliente) {
        this.catalogo = catalogo;
        this.cliente = cliente;
        this.divisa = cliente.getCuentaBancaria().getMoneda();
        this.idioma = determinaIdioma(cliente.getPais());
        this.armadorCarro = new CarritoBuilderConcreto(cliente);
        System.out.println(idioma.saludo());
    }

    /**
     * Método que determina el idioma del menú en base a una instancia de Pais.
     * @param pais un pais, en especifico es el pais del cliente.
     * @return una implementación de la interfaz Idioma.
     */
    public Idioma determinaIdioma(Pais pais) {
        switch (pais) {
            case ESTADOS_UNIDOS:
                return new Ingles();
            case MEXICO:
                return new Espanol();
            case BRASIL:
                return new Portugues();
            default:
                return new Ingles();
        }
    }

    /**
     * Método para mostrar el menú del catálogo y gestionar las acciones del usuario.
     */
    public void mostrarMenu() {

        while (true) {
            System.out.println(idioma.menuCatalogo());
            int opcion = MetodosGet.getInt("Seleccione una opción:", "Opción inválida, intente nuevamente.", 1, 7);

            switch (opcion) {
                case 1:
                    mostrarCatalogo();
                    break;
                case 2:
                    agregarProductoAlCarrito();
                    break;
                case 3:
                    eliminarProductoDelCarrito();
                    break;
                case 4:
                    verCarrito();
                    break;
                case 5:
                    procederAlPago();
                    break;
                case 6:
                    cerrarSesion();
                    return;
                case 7:
                    System.out.println(idioma.despedida());
                    return;
            }
        }
    }

    /**
     * Método para mostrar el catálogo de productos.
     */
    private void mostrarCatalogo() {
        for(Producto producto: catalogo){
            System.out.println(producto.descripcion(divisa));
        }
    }

    /**
     * Método para agregar un producto al carrito.
     */
    private void agregarProductoAlCarrito() {
        String codigoProducto = MetodosGet.getString("Ingrese el ID del producto a agregar:", "ID inválido, intente nuevamente."); 
        Producto producto = catalogo.getProducto(codigoProducto);
        if (producto != null) {
            armadorCarro.agregarProducto(producto);
            System.out.println("Producto agregado al carrito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    /**
     * Método para eliminar un producto del carrito.
     */
    private void eliminarProductoDelCarrito() {
        String codigoProducto = MetodosGet.getString("Ingrese el ID del producto a eliminar:", "ID inválido, intente nuevamente."); 
        Producto eliminado = catalogo.getProducto(codigoProducto);
        try{
            armadorCarro.eliminarProducto(eliminado); 
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Producto eliminado del carrito.");
    }

    /**Método para ver los productos del carrito. */
    private void verCarrito(){
        Carrito carritoBuffer = armadorCarro.buildCarrito();

        System.out.println("\n" + carritoBuffer.recibo());
        System.out.println(carritoBuffer.calculaTotal());
    }

    private void procederAlPago(){
        Carrito carrito = armadorCarro.buildCarrito();

        double cobro = carrito.calculaTotal();
        int dias = (int) (Math.random() * 10);
        
        try{
            cliente.getCuentaBancaria().retirar(cobro);
        }catch(IllegalStateException e){
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(idioma.ticket(dias, carrito));

    }

    /**
     * Método para cerrar sesión del cliente.
     */
    private void cerrarSesion() {
        System.out.println("Cerrando sesión de " + cliente.getNombre() + "...");
    }

}
