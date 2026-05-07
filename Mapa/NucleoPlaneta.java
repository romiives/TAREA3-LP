package mapa;
import entidades.*;
public class NucleoPlaneta extends Zona{
    private int materiasMinimasRequeridas;
    public NucleoPlaneta(){
        super();
        this.nombre = "Nucleo del Planeta";
        this.nivelRequerido = 20; 
        this.materiasMinimasRequeridas = 2;
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: boolean
    ***
    validacion para estar en esta zona
    */
    @Override
    public boolean validarAcceso(Jugador jugador){
        if(jugador.getNivel()>= nivelRequerido && jugador.getCantidadMateriasEquipadas() >= materiasMinimasRequeridas){
            return true;
        }
        return false;
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    genera la accion y llama el combate final contra sephiroth
    */
    @Override
    public void accionZona(Jugador jugador){
        Sephiroth sephiroth =new Sephiroth();
        boolean resultado=Enemigo.iniciarCombate(jugador, sephiroth, false);
        if(resultado && jugador.getPuntosVidaActual()>0){
            System.out.println("\nCloud ha salvado el planeta, HAZ GANADO.");
            System.out.println("Sephiroth fue derrotado.");
            System.out.println("Nivel final de Cloud: " +jugador.getNivel());
            System.out.println("Fin del juego.");
            System.exit(0);
        }
    }
}