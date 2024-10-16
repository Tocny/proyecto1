package mx.unam.ciencias.modelado.proyecto1.clientes;

import mx.unam.ciencias.modelado.proyecto1.strategy.moneda.*;
import java.io.Serializable;

/**Clase para cuentas bancarias, cada cliente cuenta con una instancia de esta clase. */
public class CuentaBancaria implements Serializable{

    /**Para objetos serializables. */
    private static final long serialVersionUID = 1L;
    /**Usuario de la cuenta bancaria. */
    private String usuario;
    /**Contraseña de la cuenta bancaria. */
    private String contrasena;
    /**Saldo o dinero de la cuenta bancaria. */
    private double saldo;
    /**Tipo de moneda. */
    private Moneda moneda;

    /**
     * Constructor de la clase, asigna atributos.
     * @param usuario el usuario de la cuenta bancaria.
     * @param contrasena la contraseña d ele cuenta bancaria.
     * @param saldo el saldo de la cuenta bancaria.
     * @param moneda el tipo de divisa que usa la cuenta.
     */
    public CuentaBancaria(String usuario, String contrasena, double saldo, Pais pais) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.saldo = saldo;
        this.moneda = determinaMoneda(pais);
    }

    /**
     * Método privado para determinar la moneda dada una instancia de Pais.
     * @param pais una instancia de pais.
     * @return una instancia de Moneda. La moneda correspondiente al pais.
     */
    private Moneda determinaMoneda(Pais pais){
        if(pais == Pais.MEXICO){
            return new Peso();

        } else if (pais == Pais.ESTADOS_UNIDOS){
            return new Dolar();

        } else if(pais == Pais.BRASIL){
            return new Real();

        } else{
            return new Dolar();
        }
    }

    /**
     * Método que valida la contraseña de la cuenta.
     * @param contrasena una cadena que corresponde a la contraseña
     * @return si el parametro recibido y el atributo contraseña coinciden.
     */
    public boolean validaContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    /**
     * Getter del usuario.
     * @return usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Setter del usuario.
     * @param usuario el nuevo usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Getter de la contraseña de la cuenta.
     * @return contrasena.
     */
    public String getContrasena(){
        return contrasena;
    }

    /**
     * Setter de la contraseña.
     * @param contrasena la nueva contraseña para la cuenta.
     */
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }

    /**
     * Getter del saldo de la cuenta.
     * @return saldo.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Getter de la moneda de la cuenta
     * @return moneda.
     */
    public Moneda getMoneda(){
        return moneda;
    }

    /**
     * Setter de la moneda.
     * @param moneda la nueva moneda.
     */
    public void setMoneda(Moneda moneda){
        this.moneda = moneda;
    }

    /**
     * Método para depositar una cantidad a la cuenta.
     * @param cantidad la cantidad que se va a depositar.
     */
    public void depositar(double cantidad) {
        this.saldo += Math.abs(cantidad);
    }

    /**
     * Método para retirar una cantidad de dinero.
     * @param cantidad la cantidad que se va a retirar.
     */
    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            this.saldo -= Math.abs(cantidad);
        } else {
            System.out.println("Fondos insuficientes");
        }
    }
}
