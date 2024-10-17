package mx.unam.ciencias.modelado.proyecto1.menus;

import mx.unam.ciencias.modelado.proyecto1.observer.ClienteObservador;
import mx.unam.ciencias.modelado.proyecto1.factory.fabricaclientes.ClienteIterable;
import mx.unam.ciencias.modelado.proyecto1.common.MetodosGet;

public class MenuCliente {

    /**Un objeto iterable de los clientes. */
    private ClienteIterable clientes;

    /**
     * Constructor de la clase, asigna el iterable.
     * @param clientes un iterable de clientes.
     */
    public MenuCliente(ClienteIterable clientes) {
        this.clientes = clientes;
    }

    /**
     * Método para mostrar el menú.
     * @return el cliente que inicia sesión o null si se selecciona salir.
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
     * Método para iniciar sesión, regresa un cliente si las credenciales son válidas.
     * @return una instancia de ClienteObservador o null si no se encuentra el cliente o las credenciales no son válidas.
     */
    private ClienteObservador iniciarSesion() {
        while (true) { // Bucle infinito hasta que el usuario inicie sesión o decida salir
            String usuario = MetodosGet.getString("Enter your username (or type 'exit' to go back): ", "Username cannot be empty.");

            // Opción de salir del inicio de sesión
            if (usuario.equalsIgnoreCase("exit")) {
                System.out.println("Returning to main menu...");
                return null;  // Regresa null para indicar que se ha salido
            }

            String contrasena = MetodosGet.getString("Enter your password: ", "Password cannot be empty.");

            try {
                ClienteObservador cliente = clientes.getCliente(usuario);
                
                // Verificar las credenciales del cliente usando el método de la interfaz
                if (cliente.validarCredenciales(usuario, contrasena)) {
                    return cliente;  // Regresa la instancia del cliente si las credenciales son correctas
                } else {
                    System.out.println("Invalid credentials. Please try again.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
