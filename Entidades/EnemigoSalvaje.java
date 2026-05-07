package Entidades;
import java.util.ArrayList;
import Componentes.*;
public class EnemigoSalvaje extends Enemigo implements Vulnerable{
    private ArrayList<Elemento> debilidades;
    private ArrayList<Elemento> resistencias;
    private ArrayList<Elemento> inmunidades;
    public EnemigoSalvaje(String nombre, int puntosVida, int ataque, int xpRecompensa, int chatarraRecompensa){
        super(nombre, puntosVida, ataque, xpRecompensa, chatarraRecompensa);
        this.debilidades= new ArrayList<Elemento>();
        this.resistencias= new ArrayList<Elemento>();
        this.inmunidades= new ArrayList<Elemento>();
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    le da chatarra al jugador cuando derrota a un enemigo salvaje.
    */
    public void giveChatarraRecompensa(Jugador jugador){
        jugador.recibirChatarra(chatarraRecompensa);
    }
    /*
    ***
    Parametro 1: elemento
    ***
    Tipo de Retorno: double
    ***
    evalua al enemigo.
    */
    public double evaluarDebilidad(Elemento elemento){
        if(inmunidades.contains(elemento)){
            return 0.0;
        }
        if(debilidades.contains(elemento)){
            return 2.0;
        }
        if(resistencias.contains(elemento)){
            return 0.5;
        }
        return 1.0;
    }
    /*
    ***
    Parametro 1: elemento
    ***
    Tipo de Retorno: None
    ***
    añade debilidad al enemigo.
    */
    public void agregarDebilidad(Elemento elemento){
        debilidades.add(elemento);
    }
    /*
    ***
    Parametro 1: elemento
    ***
    Tipo de Retorno: None
    ***
    agrega resistencia al enemigo.
    */ 
    public void agregarResistencia(Elemento elemento){
        resistencias.add(elemento);
    }
    /*
    ***
    Parametro 1: elemento
    ***
    Tipo de Retorno: None
    ***
    añade inmunidad al enemigo.
    */
    public void agregarInmunidad(Elemento elemento){
        inmunidades.add(elemento);
    }
}