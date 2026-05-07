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
            System.out.println("\n======================================");
            System.out.println("ZONA: "+zonaActual.getNombre()+" | NIVEL: "+jugador.getNivel());
            System.out.println("HP: "+jugador.getStats().getHpActual()+"/"+ jugador.getStats().getHpMaximo()+" | MP: "+jugador.getStats().getMpActual()+"/"+jugador.getStats().getMpMaximo());
            System.out.println("EXP: "+jugador.getXpActual()+"/"+(10*jugador.getNivel())+" | MATERIAS EQUIPADAS: "+jugador.getCantidadMateriasEquipadas()+"/5");
            System.out.println("======================================");
            System.out.println("1. Explorar zona actual");
            System.out.println("2. Ir a sector 7");
            System.out.println("3. Ir a Gongaga");
            System.out.println("4. Ir al Nucleo del Planeta");
            System.out.println("5. Ver estado del jugador");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opcion: ");
            int opcion = consola.nextInt();
            if(opcion ==1){
                zonaActual.accionZona(jugador);
            } else if(opcion ==2){
                zonaActual = new Sector7();
                System.out.println("Has llegado al Sector 7");
            } else if(opcion ==3){
                Zona nuevaZona = new Gongaga();
                if(nuevaZona.validarAcceso(jugador)){
                    zonaActual = nuevaZona;
                    System.out.println("Has llegado a Gongaga");
                } else{
                    System.out.println("No tienes el nivel necesario para entrar");
                }
            } else if(opcion ==4){
                Zona nuevaZona = new NucleoPlaneta();
                if(nuevaZona.validarAcceso(jugador)){
                    zonaActual = nuevaZona;
                    System.out.println("Has llegado al Nucleo del Planeta");
                } else{
                    System.out.println("No tienes el nivel necesario para entrar");
                }
            } else if(opcion ==5){
                jugador.mostrarEstado();
            } else if(opcion ==6){
                juegoEjecucion = false;
                System.out.println("Has salido del juego");
            } else{
                System.out.println("Opcion invalida");
            }
            if(jugador.getPuntosVidaActual() <=0){
                System.out.println("\nHas sido derrotado");
                System.out.println("Regresando al Sector 7");
                jugador.aplicarDerrota();
                zonaActual = new Sector7();
            }
        }
        consola.close();
    }
}
