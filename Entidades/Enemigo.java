package entidades;
import Componentes.*;
public abstract class Enemigo{
    protected String nombre;
    protected int xpRecompensa;
    protected int chatarraRecompensa;
    protected Estadisticas stats;
    public Enemigo(String nombre, int hp, int fuerza, int xpRecompensa, int chatarraRecompensa){
        this.nombre = nombre;
        this.stats = new Estadisticas(hp, 0, fuerza, 0);
        this.xpRecompensa = xpRecompensa;
        this.chatarraRecompensa = chatarraRecompensa; 
    }
    public String getNombre(){
        return nombre;
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    ejecuta el ataque del enemigo hacia el jugador
    */
   public void atacar(Jugador jugador){
    int danio = stats.getFuerza();
    System.out.println(nombre + "ataca a Cloud");
    jugador.danioRecibido(danio);
    System.out.println("Cloud acaba de recibir " + danio + "de daño");
   }
   /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    entrega experencia al jugador cuando derrota a un enemigo
    */
   public void giveXpRecompensa(Jugador jugador){
    jugador.recibirXP(xpRecompensa);
   }
   /*
   ***
   Parametro 1: None
   ***
   Tipo de Retorno: int
   ***
   retorno la vida del enemigo actual.
   */
   public int getHpActual(){
    return stats.getHpActual;
   }
   /*
   ***
   Parametro 1: int
   ***
   Tipo de Retorno: None
   ***
   Reduce la vida del enemigo dependiendo del daño que recibe de parte del jugador.
   */
   public void recibirDanio(int cantidadDanio){
    stats.recibirDanio(cantidadDanio);
   }
}