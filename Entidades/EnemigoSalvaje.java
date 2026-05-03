package entidades;
public class EnemigoSalvaje extends Enemigo{
    public EnemigoSalvaje(String nombre, int puntosVida, int ataque){
        super(nombre, puntosVida, ataque);
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
        jugador.recibirChatarra(5);
    }
}