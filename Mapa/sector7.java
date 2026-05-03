package mapa;
import entidades.Jugador;
public class Sector7 extends Zona{
    public Sector7(){
        super();
        this.nombre = "Sector 7";
        this.nivelRequerido = 1;
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    el jugador puede explorar el sector 7 y recuperar sus puntos de vida y magia.
     */
    @Override
    public void accionZona(Jugador jugador){
        System.out.println("\nEstas en la zona segura del Sector 7");
        System.out.println("Recuperaras energia");
        jugador.restaurarPuntos();
        System.out.println("Puntos de vida y magia restaurados");
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    ejecuta el simulador del combate en el sector 7.
    */
   public void iniciarSimulador(Jugador jugador){
    System.out.println("Combate simulador iniciado");
   }
   /*
   ***
   Parametro 1: jugador
   ***
   Tipo de Retorno: None
   ***
   manipula la tienda del sector 7
   */
  public void abrirTienda(Jugador jugador){
    System.out.println("Tienda del Sector 7");
  }
}