package entidades;
public class Jugador{
    private String nombre;
    private int nivel;
    private int xpActual;
    private int chatarra;
    private int limiteActual;
    private int ATK;
    private int MP;
    public Jugador(String nombre){
        this.nombre = nombre;
        this.nivel = 1;
        this.xpActual = 0;
        this.chatarra = 0;
        this.limiteActual = 0;
        this.ATK = 15;
        this.MP = 50;
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
        System.out.println("Fuerza(ATK): "+ ATK);
        System.out.println("Magia(MP): "+ MP);
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
        this.MP=50;
        
    }
    public int getPuntosVidaActual(){
        return ATK;
    }
    
}