package mx.unam.ciencias.modelado.proyecto1.observer;

import mx.unam.ciencias.modelado.proyecto1.decorator.*;
import mx.unam.ciencias.modelado.proyecto1.clientes.Pais;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**Clase para la implementación del sujeto del patrón observer. */
public class SujetoOfertas implements Sujeto{

    /**Lista de Observadors. */
    private List<Observador> observadores;
    
    /**Constructor de la clase, inicializa la lista de Observadors. */
    public SujetoOfertas(){
        observadores = new ArrayList<>();
    }

    /**
     * Implementación del método agregarObservador()
     * @param Observador un Observador que recibirá notificaciones.
     */
    @Override public void agregar(Observador observador){
        observadores.add(observador);
    }

    /**
     * Implementación del método eliminarObservador()
     * @param Observador el Observador que dejará de recibir notificaciones.
     */
    @Override public void eliminar(Observador observador){
        observadores.remove(observador);
    }

    /**
     * Implementación del método notificaobservadores()
     * @param oferta una cadena que representa una notificacion.
     */
    @Override public void notificarObservadores(String oferta){
        for (Observador Observador : observadores) {
                Observador.notificar(oferta);
        }

    }
    


}