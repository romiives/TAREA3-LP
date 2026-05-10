import Mapa.*;
import Entidades.*;
public class Main {
    public static void main(String[] datos){
        Jugador jugador = new Jugador("Cloud");
        Zona zonaActual = new Sector7();
        boolean juegoEjecucion = true;
        System.out.println("=== JUEGO - La Amenaza de Sephiroth ===");
        while(juegoEjecucion){
            zonaActual.accionZona(jugador);
            if(zonaActual instanceof Gongaga){
                if(((Gongaga)zonaActual).getJugadorHuir()){
                    zonaActual = new Sector7();
                }
            }
            if(zonaActual instanceof Sector7){
                zonaActual =((Sector7) zonaActual).getSiguienteZona();
            }
            if(jugador.getPuntosVidaActual() <=0){
                System.out.println("\nHas sido derrotado");
                System.out.println("Regresando al Sector 7");
                jugador.aplicarDerrota();
                zonaActual = new Sector7();
            }
        }
    }
}
