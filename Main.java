import java.util.Scanner;
import mapa.*;
import entidades.*;
public class Main {
    public static void main(String[] datos){
        Scanner consola = new Scanner(System.in);
        Jugador jugador = new Jugador("Cloud");
        Zona zonaActual = new Sector7();
        boolean juegoEjecucion = true;
        System.out.println("=== JUEGO - La Amenaza de Sephiroth ===");
        while(juegoEjecucion){
            System.out.println("\nTe encuentras en: " + zonaActual.getNombre());
            System.out.println("1. Explorar");
            System.out.println("2. Ver estado del jugador");
            System.out.println("3. Salir");
            System.out.println("Selecciona una opcion: ");
            int opcion = consola.nextInt();
            if(opcion ==1){
                zonaActual.explorar(jugador);
            } else if(opcion ==2){
                jugador.mostrarEstado();
            } else if(opcion ==3){
                juegoEjecucion = false;
                System.out.println("Ha salido del juego");
            } else{
                System.out.println("Opción invalida");
            }
            if(jugador.getPuntosVidaActual() <=0){
                System.out.println("\nHas sido derrotado");
                System.out.println("Regresando al Sector 7");
                jugador.restaurarPuntos();
                zonaActual = new Sector7();
            }

        }
        consola.close();
    }
}
