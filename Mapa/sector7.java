package mapa;
import entidades.Jugador;
public class Sector7 extends Zona{
    public Sector7(){
        this.nombreZona = "Sector 7";
    }
    /*
    **
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    el jugador puede explorar el sector 7 y recuperar sus puntos de vida y magia.
     */
    @Override
    public void explorar(Jugador jugador){
        System.out.println("\nEstas en la zona segura (Sector 7)");
        System.out.println("Recuperaras energia");
        jugador.restaurarPuntos();
        System.out.println("Puntos de vida restaurados");
    }
}