package mapa;
import entidades.Jugador;
public abstract class Zona{
    protected String nombreZona;
    public String getNombre(){
        return nombreZona;
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo Retorno: None
    ***
    ejecuta la accion de explorar en una zona del juego, donde cada zona tendra su propio comportamiento.
     */
    public abstract void explorar(Jugador jugador);
}
