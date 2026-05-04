package entidades;
import java.util.ArrayList;
import Componentes.*;
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
    private ArrayList<Materia> mochila;
    private Arma busterSword;
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
        this.mochila = new ArrayList<Materia>();
        this.busterSword = new Arma();
    }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: None
    ***
    muestra el estado actual del jugador, su vida, magia, nivel, experiencia, chatarra y el limite.
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
        System.out.println("Materias en mochila: " + mochila.size());
        System.out.println("Materias equipadas en Buster Sword: " + busterSword.getCantidadMaterias());
    }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: None
    ***
    restaura los puntos de vida y magia.
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
    quita puntos de vidas segun daño recibido.
    */
    public void danioRecibido(int cantidadDanio){
        this.puntosVidaActual-=cantidadDanio;
        if(this.puntosVidaActual<0){
            this.puntosVidaActual =0;
        }
        this.limiteActual += cantidadDanio/2;
        if(this.limiteActual>100){
            this.limiteActual = 100;
        }
    }
    /*
    ***
    Parametro 1: int
    ***
    Tipo de Retorno: None
    ***
    aumenta la barra del limite en base al daño que cloud hace.
    */
    public void cargarLimiteDanio(int cantidadDanio){
        this.limiteActual += cantidadDanio/5;
        if(this.limiteActual > 100){
            this.limiteActual = 100;
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
    aumenta la chatarra.
    */
    public void recibirChatarra(int cantidadChatarra){
        this.chatarra += cantidadChatarra;
    }
    /*
    ***
    Parametro 1: materia
    ***
    Tipo de Retorno: None
    ***
    añade materia en la mochila.
    */
    public void agregarMateria(Materia materia){
        mochila.add(materia);
        System.out.println("Se añadio materia a la mochila: "+materia.getNombre());
    }
    /*
    ***
    Parametro 1: materia
    ***
    Tipo de Retorno: None
    ***
    añade materua en la buster sword.
    */
    public void equiparMateria(Materia materia){
        busterSword.equiparMateria(materia);
    }
    public int getNivel(){
        return nivel;
    }
    public int getPuntosVidaActual(){
        return puntosVidaActual;
    }
    public int getATK(){
        return ATK;
    }
    public int getMP(){
        return MP;
    }
    public int getPuntosMagiaActual(){
        return puntosMagiaActual;
    }
    public ArrayList<Materia> getMochila(){
        return mochila;
    }
    public Arma getBusterSword(){
        return busterSword;
    }
    public int getLimiteActual(){
        return limiteActual
    }
    public void setLimiteActual(int limiteActual){
        this.limiteActual = limiteActual;
    }
    public int getPuntosMagiaMaximo(){
        return puntosMagiaMaximo;
    }
    public int getPuntosVidaMaximo(){
        return puntosVidaMaximo;
    }
    public int getChatarra(){
        return chatarra;
    }
    /*
    Clase Arma
    */
    public class Arma{
        private String nombre;
        private ArrayList<Materia> materiasEquipadas;
        public Arma(){
            this.nombre = "Buster Sword";
            this.materiasEquipadas = new ArrayList<Materia>();
        }
        /*
        ***
        Parametro 1: materia
        ***
        Tipo de Retorno: None
        ***
        añade materia en el arma si es que hay espacio.
        */
        public void equiparMateria(Materia materia){
            if(materiasEquipadas.size()<5){
                materiasEquipadas.add(materia);
                System.out.println("La materia equipada en " +nombre+":"+materia.getNombre());
            } else{
                System.out.println("No hay espacio disponible");
            }
        }
        /*
        Parametro 1: None
        ***
        Tipo de Retorno: int
        ***
        calcula el daño estandar fisico sin coste de MP y usando el AKT del jugador
        */
        public int calcularDanioFisico(){
            return (int)(ATK * 1.25);
        }
        /*
        Parametro 1: elemento
        ***
        Tipo de Retorno: int
        ***
        calcula el daño magico y se potencia sal equipar varias materias identicas e incrementa el consumo de MP.
        */
        public int calcularDanioMagico(Elemento elemento){
            int cantidad = 0;
            for(int i=0; i<materiasEquipadas.size();i++){
                if(materiasEquipadas.get(i).getElemento()==elemento){
                    cantidad++;
                }
            }
            int costoMP = 10+(5*cantidad);
            if(puntosMagiaActual >= costoMP){
                puntosMagiaActual -= costoMP;
                return (int)(MP*(1+(0.5*cantidad)));
            }
            System.out.println("No hay suficiente MP");
            return 0;
        }
        /*
        ***
        Parametro 1: None
        ***
        Tipo de Retorno: int
        ***
        ataque fisico devastador que no usa MP.
        */
        public int calculaDanioLimite(){
            if(limiteActual == 100){
                limiteActual = 0;
                return ATK*5;
            }
            System.out.println("Limite no disponible para efectuar el ataque");
            return 0;
        }
        public int getCantidadMaterias(){
            return materiasEquipadas.size();
        }
        public ArrayList<Materia> getMateriasEquipadas(){
            return materiasEquipadas;
        }
   }
}