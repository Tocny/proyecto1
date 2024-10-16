package mx.unam.ciencias.modelado.proyecto1.menus;

import mx.unam.ciencias.modelado.proyecto1.observer.ClienteObservador;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes.ClienteIterable;
import mx.unam.ciencias.modelado.proyecto1.common.MetodosGet;

public class MenuCliente {

    private ClienteIterable clientes;

    /**
     * Constructor de la clase, asigna el iterable.
     * @param clientes un iterable de clientes.
     */
    public MenuCliente(ClienteIterable clientes) {
        this.clientes = clientes;
    }

    /**
     * Método para mostrar el menú
     */
    public ClienteObservador iniciar() {
        ClienteObservador cliente = null;

        while (true) {
            System.out.println("----- Login Menu -----");
            System.out.println("1. Log In.");
            System.out.println("2. Exit.");

            int opcion = MetodosGet.getInt("Pick an option (1 or 2): ", "Invalid action. Please try again.", 1, 2);

            switch (opcion) {
                case 1:
                    cliente = iniciarSesion();
                    // Si el cliente es nulo, significa que el inicio de sesión falló.
                    if (cliente != null) {
                        return cliente; // Regresa el cliente si la sesión fue exitosa.
                    }
                    break;
                case 2:
                    System.out.println("Exiting the system...");
                    return null; // Regresa null para indicar que se ha salido.
            }
        }
    }

    /**
     * Método para iniciar sesión, regresa un cliente.
     * @return una instancia de ClienteObservador, sobre la cual se va a proceder al menu.
     */
    private ClienteObservador iniciarSesion() {
        while (true) { // Bucle infinito hasta que el usuario inicie sesión o decida salir
            String usuario = MetodosGet.getString("Enter your username (or type 'exit' to go back): ", "Username cannot be empty.");

            // Opción de salir del inicio de sesión
            if (usuario.equalsIgnoreCase("exit")) {
                System.out.println("Returning to main menu...");
                return null;  // Regresa null para indicar que se ha salido
            }

            try {
                ClienteObservador cliente = clientes.getCliente(usuario);
                return cliente;  // Regresa la instancia del cliente
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
