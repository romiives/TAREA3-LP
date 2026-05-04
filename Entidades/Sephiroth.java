package entidades;
public class Sephiroth extends Enemigo{
    private int contadorSuperNova;
    public Sephiroth(){
        super("Sephiroth", 500, 40, 0, 0);
        this.contadorSuperNova = 0;
    }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: None
    ***
    ejecuta el contador de supernova y avisa los ataques de sephiroth cada 10 turnos, si no hace un ataque normal no especial.
    */
    public void lanzarSuperNova(){
        contadorSuperNova++;
        if(contadorSuperNova>=10){
            System.out.println("Sephiroth ha lanzado SuperNova");
            jugador.danioRecibido(80);
            contadorSuperNova = 0;
        } else{
            System.out.println("Sephiroth va a lanzar SuperNova: "+contadorSuperNova + "/10");
            atacar(jugador);
        }
    }
}