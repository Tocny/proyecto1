package mx.unam.ciencias.modelado.proyecto1.clientes;

import java.io.Serializable;

/**Clase Cliente para los consumidores del mercado. */
public class ClienteConcreto implements Cliente, Serializable {

    /**Para objetos serializables. */
    private static final long serialVersionUID = 1L;
    /**Id del cliente. */
    private String id;
    /**Nombre del cliente. */
    private String nombre;
    /**Cuenta bancaria asociada. */
    private CuentaBancaria cuentaBancaria;
    /**Pais del cliente. */
    private Pais pais;

    /**
     * Constructor de la clase, asigna atributos.
     * @param id el id del cliente.
     * @param nombre el nombre del cliente.
     * @param cuentaBancaria la cuenta bancaria asociada.
     * @param pais el pais del cliente.
     */
    public ClienteConcreto(String id, String nombre, CuentaBancaria cuentaBancaria, Pais pais) {
        this.id = id;
        this.nombre = nombre;
        this.cuentaBancaria = cuentaBancaria;
        this.id = cuentaBancaria.getUsuario();
        this.pais = pais;
    }

    /**
     * Getter del id.
     * @return id.
     */
    @Override public String getID() {
        return id;
    }

    /**
     * Setter del id.
     * @param id un entero que será el nuevo id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter del nombre 
     * @return nombre.
     */
    @Override public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre.
     * @param nombre el nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la cuenta bancaria del cliente.
     * @return cuentaBancaria.
     */
    @Override public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     * Setter de la cuenta bancaria.
     * @param cuentaBancaria la nueva cuenta bancaria asociada.
     */
    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    /**
     * Getter del pais.
     * @return pais.
     */
    @Override public Pais getPais() {
        return pais;
    }

    /**
     * Setter del pais.
     * @param pais el nuevo pais del usuario.
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    /**
     * Método que valida las credenciales del usuario con respecto a la cuenta bancaria..
     * @param usuario el usuario de la cuenta bancaria.
     * @param contrasena la contraseña de la cuenta bancaria.
     * @return si los valores de los parametros coinciden con los de la cuenta bancaria asociada.
     */
    @Override public boolean validarCredenciales(String usuario, String contrasena) {
        return this.cuentaBancaria.getUsuario().equals(usuario) && cuentaBancaria.validaContrasena(contrasena);
    }

}
