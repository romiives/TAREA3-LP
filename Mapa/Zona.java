package mapa;
import java.util.ArrayList;
import entidades.Jugador;
import entidades.Enemigo;
public abstract class Zona{
    protected String nombre;
    protected int nivelRequerido;
    protected ArrayList<Enemigo> enemigosDisponibles;
    public Zona(){
        this.enemigosDisponibles = new ArrayList<Enemigos>();
    }
    public String getNombre(){
        return nombre;
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo Retorno: None
    ***
    ejecuta la accion de explorar en una zona del juego, donde cada zona tendra su propio comportamiento.
    */
    public abstract void accionZona(Jugador jugador);
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retonor: boolean
    ***
    Comprueba que el jugador tenga el nivel necesario para entrar a una zona.
    */
    public boolean validarAcceso(Jugador jugador){
        if(jugador.getNivel()>=nivelRequerido){
            return true;
        }
        return false;
    }
}
