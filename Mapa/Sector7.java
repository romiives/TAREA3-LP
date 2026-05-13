package Mapa;
import java.util.Scanner;
import Entidades.*;
import Componentes.*;
public class Sector7 extends Zona{
    private Zona siguienteZona;
    public Sector7(){
        super();
        this.nombre = "Sector 7";
        this.nivelRequerido = 1;
        this.siguienteZona = this;
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    el jugador puede explorar el sector 7 y recuperar sus puntos de vida y magia. (consola de sector 7)
    */
    @Override
    public void accionZona(Jugador jugador){
        @SuppressWarnings("resource")
        Scanner consola = new Scanner(System.in);
        System.out.println("\n======================================");
        System.out.println("ZONA: Sector 7 | NIVEL: "+jugador.getNivel());
        System.out.println("HP: "+jugador.getStats().getHpActual()+"/"+jugador.getStats().getHpMaximo()+" | MP: "+jugador.getStats().getMpActual()+"/"+jugador.getStats().getMpMaximo());
        System.out.println("EXP: "+jugador.getXpActual()+"/"+(10*jugador.getNivel())+" | MATERIAS EQUIPADAS: "+jugador.getCantidadMateriasEquipadas()+"/5");
        System.out.println("CHATARRA: "+jugador.getChatarra());
        System.out.println("======================================");
        System.out.println("1. Entrar al simulador de combate");
        System.out.println("2. Descansar en la Posada (Recuperar HP/MP)");
        System.out.println("3. Ver estadisticas de Cloud");
        System.out.println("4. Ver Mochila / Equipar materia");
        System.out.println("5. Viajar a Gongaga");
        System.out.println("6. Viajar al Nucleo del Planeta");
        System.out.println("7. Abrir Tienda");
        System.out.println("8. Salir del juego");
        System.out.print("Opcion: ");
        int opcion =consola.nextInt();
        if(opcion ==1){
            iniciarSimulador(jugador);
        }else if(opcion ==2){
            jugador.restaurarPuntos();
            System.out.println("Cloud ha recuperado vida y magia");
        }else if(opcion ==3){
            jugador.mostrarEstado();
        }else if(opcion ==4){
            jugador.mostrarMochila();
        }else if(opcion ==5){
            Zona gongaga = new Gongaga();
            if(gongaga.validarAcceso(jugador)){
                this.siguienteZona = gongaga;
                System.out.println("Estas viajando a Gongaga");
            }else{
                System.out.println("No tienes el nivel necesario");
            }
        }else if(opcion ==6){
            Zona nucleo = new NucleoPlaneta();
            if(nucleo.validarAcceso(jugador)){
                this.siguienteZona = nucleo;
                System.out.println("Estas viajando al Nucleo del Planeta");
            }else{
                System.out.println("No tienes el nivel necesario");
            }
        }else if(opcion ==7){
            abrirTienda(jugador);
        }else if(opcion ==8){
            System.out.println("Has salido del juego");
            System.exit(0);
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
        int probabilidad =(int)(Math.random()*100)+1;
        System.out.println("\n>>> INICIANDO SIMULADOR DE COMBATE <<<");
        if(probabilidad<=90){
            EnemigoSimulador soldado = new EnemigoSimulador();
            System.out.println("Aparece un Soldado Holografico (HP: 50)");
            Enemigo.iniciarCombate(jugador, soldado, false);
        }else{
            java.util.ArrayList<Enemigo> enemigos=new java.util.ArrayList<Enemigo>();
            enemigos.add(new EnemigoSimulador());
            enemigos.add(new EnemigoSimulador());
            System.out.println("Aparecen 2 Soldados Holograficos");
            Enemigo.iniciarCombateGrupo(jugador, enemigos);
        }
        if(jugador.getPuntosVidaActual()<=0){
            jugador.restaurarPuntos();
            System.out.println("Cloud ha sido restaurado");
        } else{
            System.out.println(">>> SIMULACION COMPLETADA <<<");
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
        @SuppressWarnings("resource")
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
            System.out.println("Mejora aplicada");
            System.out.println("Chatarra restante: "+jugador.getChatarra());
        }else{
            System.out.println("No hay chatarra disponible para la compra");
        }
    }
    public Zona getSiguienteZona(){
        return siguienteZona;
    }
}



