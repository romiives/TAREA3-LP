package mapa;
import entidades.*;
public class NucleoPlaneta extends Zona{
    private int materiasMinimasRequeridas;
    public NucleoPlaneta(){
        super()
        this.nombre = "Nucleo Planeta";
        this.nivelRequerido = 20; 
        this.materiasMinimasRequeridas = 2;
        enemigosDisponibles.add(new Sephiroth());
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
        System.out.println("\nTe encuentras en el Nucleo Planeta");
        iniciarCombate(jugador);
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    inicia el combate final contra sephiroth
    */
   public void iniciarCombate(Jugador jugador){
    System.out.println("Ha iniciado el combate");
    
   }
}