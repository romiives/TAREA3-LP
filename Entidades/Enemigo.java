package entidades;
public abstract class Enemigo{
    protected String nombre;
    protected int puntosVida;
    protected int ataque;
    public Enemigo(String nombre, int puntosVida, int ataque){
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataque = ataque;
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
    System.out.println(nombre + "ataca a Cloud");
    jugador.danioRecibido(ataque);
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
    jugador.recibirXP(10);
   }
}