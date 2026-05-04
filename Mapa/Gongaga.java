package mapa;
import java.util.ArrayList;
import entidades.*;
import Componentes.*;
public class Gongaga extends Zona{
    private ArrayList<String> poolMaterias;
    public Gongaga(){
        this.nombre = "Gongaga";
        this.nivelRequerido = 10;
        this.poolMaterias = new ArrayList<Materia>();
        poolMaterias.add(new Materia("Fuego", Elemento.FUEGO);
        poolMaterias.add(new Materia("Hielo", Elemento.HIELO);
        poolMaterias.add(new Materia("Rayo", Elemento.RAYO));
        poolMaterias.add(new Materia("Cura", Elemento.CURA));
        enemigosDisponibles.add(new EnemigoSalvaje("Planta Carnivora",80, 15, 80, 50));
        enemigosDisponibles.add(new EnemigoSalvaje("Sapo de la Jungla",60, 12, 70, 55));
        enemigosDisponibles.add(new EnemigoSalvaje("Robot Centinela",100, 20, 100, 75));
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
    int evento =(int)(Math.random()*100)+1;
    System.out.println("\nEl jugador explora la Gongaga");
    if(evento <= 30){
        encontrarMateria(jugador);
    } else if(evento<= 50){
        System.out.println("Cloud esta siendo emboscado por enemigos");
        generarGrupoEnemigo();
    } else{
        System.out.println("Cloud se enfrenta a un grupo de enemigos salvajes");
        generarGrupoEnemigo();
    }
   }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: ArrayList<Enemigo>
    ***
    genera grupos aleatorios de los enemigos salvajes a los que se enfrenta cloud en la gongaga.
    */
   public ArrayList<Enemigo> generarGrupoEnemigo(){
    ArrayList<Enemigo> grupoEnemigos = new ArrayList<Enemigo>();
    int cantidadEnemigos = (int)(Math.random()*3)+1;
    for(int posicion=0; posicion < cantidadEnemigos; posicion++){
        int enemigoAleatorio = (int)(Math.random()*enemigosDisponibles.size());
        grupoEnemigos.add(enemigosDisponibles.get(enemigoAleatorio));
    }
    System.out.println("Aparecieron "+grupoEnemigos.size()+ "enemigo(s)");
    for(int posicion=0; posicion<grupoEnemigos.size();posicion++){
        System.out.println("- "+grupoEnemigos.get(posicion).getNombre());
    }
    return grupoEnemigos;
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
    int materiaAleatoria = (int)(Math.random()*poolMaterias.size());
    Materia materiaEncontrada = poolMaterias.get(materiaAleatoria);
    System.out.println("Cloud encontro una materia: "+materiaEncontrada.getNombre());
    jugador.agregarMateria(materiaEncontrada);
   }
}