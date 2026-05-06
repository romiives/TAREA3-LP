package mapa;
import java.util.Scanner;
import entidades.*;
public class Sector7 extends Zona{
    public Sector7(){
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
        Scanner consola = new Scanner(System.in);
        System.out.println("\n=== Sector 7 ===");
        System.out.println("1. Descansar");
        System.out.println("2. Iniciar Simulado Combate");
        System.out.println("3. Abrir tienda");
        System.out.print("Opcion: ");
        int opcion =consola.nextInt();
        if(opcion ==1){
            jugador.restaurarPuntos();
            System.out.println("Cloud ha recuperado vida y magia");
        }else if(opcion ==2){
            iniciarSimulador(jugador);
        }else if(opcion ==3){
            abrirTienda(jugador);

        }else{
            System.out.println("Opcion invalida");
        }
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    ejecuta el simulador del combate en el sector 7, contra soldado común. 
    */
    public void iniciarSimulador(Jugador jugador){
        EnemigoSimulador soldado = new EnemigoSimulador();
        Enemigo.iniciarCombate(jugador, soldado, false);
        if(jugador.getPuntosVidaActual()<=0){
            jugador.restaurarPuntos();
            System.out.println("Cloud ha sido restaurado");
        }
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    manipula la tienda del sector 7 de la chatarra
    */
    public void abrirTienda(Jugador jugador){
        Scanner consola =new Scanner(System.in);
        Mejora mejoraVida =new Mejora("Mejora de Vitalidad", TipoStat.HP_MAX, 20, 100);
        Mejora mejoraMagia =new Mejora("Mejora de Eter", TipoStat.MP_MAX, 10, 120);
        Mejora mejoraFuerza =new Mejora("Mejora Fisica", TipoStat.FUERZA, 10, 150);
        System.out.println("\n=== Tienda de Chatarra ===");
        System.out.println("1. Mejora Vitalidad");
        System.out.println("2. Mejora Eter");
        System.out.println("3. Mejora Física");
        System.out.print("Opcion: ");
        int opcion =consola.nextInt();
        if(opcion==1){
            comprarMejora(jugador, mejoraVida);
        }else if(opcion==2){
            comprarMejora(jugador, mejoraMagia);
        }else if(opcion==3){
            comprarMejora(jugador, mejoraFuerza);
        }else{
            System.out.println("Opcion invalida");
        }
    }
    /*
    ***
    Parametro 1: jugador
    Parametro 2: mejora
    ***
    Tipo de Retorno: None
    ***
    compra mejora segun disponibilidad de chatarra.
    */
    public void comprarMejora(Jugador jugador, Mejora mejora){
        if(jugador.gastarChatarra(mejora.getCostoChatarra())){
            mejora.aplicarMejora(jugador.getStats());
            System.out.println("Mejora aplicada")
        }else{
            System.out.println("No hay chatarra disponible para la compra")
        }
    }
}