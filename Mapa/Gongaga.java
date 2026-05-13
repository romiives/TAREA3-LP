package Mapa;
import java.util.ArrayList;
import java.util.Scanner;

import Entidades.*;
import Componentes.*;
public class Gongaga extends Zona{
    private ArrayList<Materia> poolMaterias;
    private boolean jugadorHuir;
    public Gongaga(Scanner consola){
        super(consola);
        this.nombre = "Gongaga";
        this.nivelRequerido = 5;
        this.jugadorHuir = false;
        this.poolMaterias = new ArrayList<Materia>();
        poolMaterias.add(new Materia("Fuego", Elemento.FUEGO));
        poolMaterias.add(new Materia("Hielo", Elemento.HIELO));
        poolMaterias.add(new Materia("Rayo", Elemento.RAYO));
        poolMaterias.add(new Materia("Cura", Elemento.CURA));
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    ejecuta todas las acciones que puede hacer el jugador en gongaga, puede aparecer materia, emboscadas o grupos de enemigos.
    */
    @Override
    public void accionZona(Jugador jugador){
        jugadorHuir=false;
        System.out.println("\n========== GONGAGA ==========");
        System.out.println("1. Explorar Gongaga");
        System.out.println("2. Volver al Sector 7");
        System.out.print("Opcion: ");
        int opcion=consola.nextInt();
        if(opcion==2){
            this.jugadorHuir=true;
            System.out.println("Cloud regresa al Sector 7");
            return;
        }
        if(opcion!=1){
            System.out.println("Opcion invalida");
            return;
        }
        int evento=(int)(Math.random()*100)+1;
        System.out.println("\nEl jugador explora la Gongaga");
        if(evento <= 30){
            encontrarMateria(jugador);

        } else{
            System.out.println("Cloud esta siendo emboscado por enemigos");
            ArrayList<Enemigo> grupoEnemigos=generarGrupoEnemigo();
            boolean resultado=Enemigo.iniciarCombateGrupo(jugador, grupoEnemigos);
            if(Enemigo.getUltimoCombateHuida()){
                System.out.println("\nCloud ha logrado escapar de Gongaga");
                this.jugadorHuir=true;
                return;
            }
            if(!resultado){
                return;
            }
        }    
   }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: ArrayList<Enemigo>
    ***
    genera grupos de los enemigos salvajes a los que se enfrenta cloud en la gongaga, dependiendo de las probabilidades de ocurrecencia.
    */
    public ArrayList<Enemigo> generarGrupoEnemigo(){
        ArrayList<Enemigo> grupoEnemigos = new ArrayList<Enemigo>();
        int probabilidad = (int)(Math.random()*100)+1;
        int cantidadEnemigos;
        if(probabilidad <= 60){
            cantidadEnemigos = 1;
        }else if(probabilidad <=90){
            cantidadEnemigos = 2;
        } else{
            cantidadEnemigos = 3;
        }
        
        for(int posicion=0; posicion<cantidadEnemigos; posicion++){
            grupoEnemigos.add(crearEnemigoAleatorio());
        }
        System.out.println("Aparecieron "+grupoEnemigos.size()+ " enemigo(s)");
        for(int posicion=0; posicion<grupoEnemigos.size(); posicion++){
            System.out.println("- "+grupoEnemigos.get(posicion).getNombre());
        }
        return grupoEnemigos;
    }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: enemigo
    ***
    crea un enemigo salvaje aleatorio con sus especialidades de comabet
    */
    public Enemigo crearEnemigoAleatorio(){
        int opcion =(int)(Math.random()*3)+1;
        EnemigoSalvaje enemigo;
        if(opcion==1){
            enemigo =new EnemigoSalvaje("Planta Carnivora", 80, 15, generarXpSalvaje(), generarChatarraSalvaje());
            enemigo.agregarDebilidad(Elemento.FUEGO);
            enemigo.agregarDebilidad(Elemento.HIELO);
            enemigo.agregarInmunidad(Elemento.RAYO);
        } else if(opcion==2){
            enemigo =new EnemigoSalvaje("Sapo de la Jungla", 60, 12, generarXpSalvaje(), generarChatarraSalvaje());
            enemigo.agregarDebilidad(Elemento.RAYO);
            enemigo.agregarDebilidad(Elemento.HIELO);
            enemigo.agregarResistencia(Elemento.FUEGO);
        } else{
            enemigo =new EnemigoSalvaje("Robot Centinela", 100, 20, generarXpSalvaje(), generarChatarraSalvaje());
            enemigo.agregarDebilidad(Elemento.RAYO);
            enemigo.agregarResistencia(Elemento.FISICO);
            enemigo.agregarResistencia(Elemento.HIELO);
        }
        return enemigo;
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    genera materia aleatoria al jugador cuando esta explorando.
    */
    public void encontrarMateria(Jugador jugador){
        int posicion = (int)(Math.random()*poolMaterias.size());
        Materia materia = poolMaterias.get(posicion);
        System.out.println("\nCloud ha encontrado una materia mientras exploraba");
        System.out.println("Materia encontrada: "+materia.getNombre());
        jugador.agregarMateria(materia);
   }
   /*
   ***
   Parametro 1: None
   ***
   Tipo de Retorno: int
   ***
   genera la experiencia entre 80-100 para los enemigos.
   */
   public int generarXpSalvaje(){
    return 80 +(int)(Math.random()*21);
   }
   /*
   ***
   Parametro 1: None
   ***
   Tipo de Retorno: int
   ***
   genera la chatarra entre 50-75 para los enemigos.
   */
   public int generarChatarraSalvaje(){
    return 50+(int)(Math.random()*26);
   }
   public boolean getJugadorHuir(){
    return jugadorHuir;
   }
}