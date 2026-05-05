package entidades;
public class Sephiroth extends Enemigo{
    private int contadorSuperNova;
    public Sephiroth(){
        super("Sephiroth", 500, 40, 0, 0);
        this.contadorSuperNova = 0;
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    aca sephiroth acata con un 90% a cloud.
    */
    @Override
    public void atacar(Jugador jugador){
        int probabilidad =(int)(Math.random()*100)+1;
        if(probabilidad<=90){
            int danio =(int)(stats.getFuerza()*1.25);
            System.out.println("Sephiroth ataca a Cloud");
            jugador.danioRecibido(danio);
            System.out.println("Cloud recibio " + danio + " de danio");
        } else{
            System.out.println("Sephiroth fallo el ataque");
        }
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
            jugador.danioRecibido(jugador.getPuntosVidaActual());
            contadorSuperNova = 0;
        } else{
            System.out.println("Sephiroth va a lanzar SuperNova: "+contadorSuperNova + "/10");
            atacar(jugador);
        }
    }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: None
    ***
    reiniciador del contador
    */
    public void reiniciarSuperNova(){
        contadorSuperNova = 0;
    }
}