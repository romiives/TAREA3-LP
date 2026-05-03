package entidades;
public class EnemigoSimulador extends Enemigo{
    public EnemigoSimulador(String nombre, int puntosVida, int ataque){
        super(nombre, puntosVida, ataque);
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: boolean
    ***
    comprueba que el daño que recibe cloud es seguro
    */
    public boolean checkDanoSeguro(Jugador jugador){
        if(jugador.getPuntosVidaActual()>ataque){
            return true;
        }
        return false;
    }
}