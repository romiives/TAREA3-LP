package entidades;
public class EnemigoSimulador extends Enemigo{
    public EnemigoSimulador(){
        super("Soldado Comun", 50, 15, generarXP(), 0);
    }
    private static int generarXP(){
        return 15+(int)(Math.random()*6);
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