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
        mostrarMenu();
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
    private void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println(idioma.menuCatalogo());
            int opcion = MetodosGet.getInt("Seleccione una opción:", "Opción inválida, intente nuevamente.", 1, 5);

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
                    cerrarSesion();
                    salir = true;
                    break;
                case 5:
                    System.out.println(idioma.despedida());
                    salir = true;
                    break;
            }
        }
    }

    /**
     * Método para mostrar el catálogo de productos.
     */
    private void mostrarCatalogo() {
        catalogo.mostrar();
    }

    /**
     * Método para agregar un producto al carrito.
     */
    private void agregarProductoAlCarrito() {
        String codigoProducto = MetodosGet.getString("Ingrese el ID del producto a agregar:", "ID inválido, intente nuevamente."); // Asumiendo que existe un método para obtener el ID máximo
        Producto producto = catalogo.getProducto(codigoProducto); // Suponiendo que hay un método buscarPorId en ProductoIterable
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
        String codigoProducto = MetodosGet.getString("Ingrese el ID del producto a eliminar:", "ID inválido, intente nuevamente."); // Suponiendo que existe un método para obtener el ID máximo
        Producto eliminado = catalogo.getProducto(codigoProducto);
        armadorCarro.eliminarProducto(eliminado); // Suponiendo que hay un método eliminarProducto en CarritoBuilder
        System.out.println("Producto eliminado del carrito.");
    }

    /**
     * Método para cerrar sesión del cliente.
     */
    private void cerrarSesion() {
        System.out.println("Cerrando sesión de " + cliente.getNombre() + "...");
        // Aquí se pueden realizar otras acciones necesarias al cerrar sesión
    }
}
