package entidades;
public class Jugador{
    private String nombreJugador;
    private int puntosVidaMaximo;
    private int puntosVidaActual;
    private int puntosMagiaMaximos;
    private int puntosMagiaActual;
    private int ATK;
    private int MP;
    private int nivel;
    public Jugador(String nombreJugador){
        this.nombreJugador = nombreJugador;
        this.puntosVidaMaximo = 200;
        this.puntosVidaActual = 200;
        this.puntosMagiaMaximos = 50;
        this.puntosMagiaActual = 50;
        this.ATK = 15;
        this.MP = 15;
        this.nivel = 1;
    }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: None
    ***
    muestra el estado actual del jugador, su vida, magia y nivel.
     */
    public void mostrarEstado(){
        System.out.println("\n=== Estado del Jugador ===");
        System.out.println("Nombre: "+nombreJugador);
        System.out.println("Nivel: "+nivel);
        System.out.println("Vida: "+puntosVidaActual+"/"+puntosVidaMaximo);
        System.out.println("Magia: "+puntosMagiaActual+"/"+puntosMagiaMaximos);
        System.out.println("Fuerza: "+ ATK);
        System.out.println("Magia: "+MP);
    }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: None
    ***
    restaura los puntos de vida y magia
     */
    public void restaurarPuntos(){
        this.puntosVidaActual = puntosVidaMaximo;
        this.puntosMagiaActual = puntosMagiaMaximos;
    }
    public int getPuntosVidaActual(){
        return puntosMagiaActual;
    }
    /*
    ***
    Parametro 1: int
    ***
    Tipo de Retorno: None
    ***
    quita puntos de vida del jugador segun el daño que recibio
     */
    public void dañoRecibido(int cantidadDaño){
        this.puntosVidaActual -= cantidadDaño;
        if(this.puntosVidaActual <0){
            this.puntosMagiaActual = 0;
        }
    }
}