package entidades;
public class Jugador{
    private String nombre;
    private int nivel;
    private int xpActual;
    private int chatarra;
    private int limiteActual;
    private int puntosVidaMaximo;
    private int puntosVidaActual;
    private int puntosMagiaMaximo;
    private int puntosMagiaActual;
    private int ATK;
    private int MP;
    public Jugador(String nombre){
        this.nombre = nombre;
        this.nivel = 1;
        this.xpActual = 0;
        this.chatarra = 0;
        this.limiteActual = 0;
        this.puntosVidaMaximo = 200;
        this.puntosVidaActual = 200;
        this.puntosMagiaMaximo = 50;
        this.puntosMagiaActual = 50;
        this.ATK = 15;
        this.MP = 15;
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
        System.out.println("Nombre: "+nombre);
        System.out.println("Nivel: "+nivel);
        System.out.println("XP actual: "+xpActuaL);
        System.out.println("Chatarra: "+chatarra);
        System.out.println("Limite actual: "+limiteActual);
        System.out.println("Vida: "+puntosVidaActual+"/"+puntosVidaMaximo);
        System.out.println("Puntos Magia: "+puntosMagiaActual+"/"+puntosMagiaMaximo);
        System.out.println("Fuerza(ATK): "+ ATK);
        System.out.println("(MP): "+ MP);
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
        this.puntosMagiaActual = puntosMagiaMaximo;
        
    }
    /*
    ***
    Parametro 1: int
    ***
    Tipo de Retorno: None
    ***
    quita puntos de vidas segun daño recibido-
    */
    public void danioRecibido(int cantidadDanio){
        this.puntosVidaActual-=cantidadDanio;
        if(this.puntosVidaActual<0){
            this.puntosVidaActual =0;
        }
    }
    /*
    ***
    Parametro 1: int
    ***
    Tipo de Retorno: None
    ***
    aumenta la experiencia.
    */
    public void recibirXP(int cantidadXP){
        this.xpActuaL += cantidadXP;
    }
     /*
    ***
    Parametro 1: int
    ***
    Tipo de Retorno: None
    ***
    aumenta la chatarra
    */
    public void recibirChatarra(int cantidadChatarra){
        this.chatarra += cantidadChatarra;
    }
    public int getNivel(){
        return nivel;
    }
    public int getPuntosVidaActual(){
        return puntosVidaActual;
    }
}