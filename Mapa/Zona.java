package mapa;
import entidades.Jugador;
public abstract class Zona{
    protected String nombre;
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
}
