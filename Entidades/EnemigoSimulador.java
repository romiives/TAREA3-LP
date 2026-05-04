package entidades;
public class EnemigoSimulador extends Enemigo{
    public EnemigoSimulador(String nombre, int puntosVida, int ataque){
        super(nombre, puntosVida, ataque, 10 , 0);
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: boolean
    ***
    comprueba que el daño que recibe cloud no lo derrote altiro.
    */
    public boolean checkDanoSeguro(Jugador jugador){
        if(jugador.getPuntosVidaActual()>stats.getFuerza()){
            return true;
        }
        return false;
    }
}