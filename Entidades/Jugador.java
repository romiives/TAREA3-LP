package Entidades;
import java.util.ArrayList;
import java.util.Scanner;
import Componentes.*;
public class Jugador{
    private String nombre;
    private int nivel;
    private int xpActual;
    private int chatarra;
    private int limiteActual;
    private Estadisticas stats;
    private ArrayList<Materia> mochila;
    private Arma busterSword;
    public Jugador(String nombre){
        this.nombre = nombre;
        this.nivel = 1;
        this.xpActual = 0;
        this.chatarra = 0;
        this.limiteActual = 0;
        this.stats = new Estadisticas(200, 50, 15, 15);
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
        System.out.println("\n======================================");
        System.out.println("ZONA ACTUAL");
        System.out.println("======================================");
        System.out.println("Nombre: " +nombre);
        System.out.println("Nivel: " +nivel);
        System.out.println("HP: "+stats.getHpActual()+"/"+stats.getHpMaximo()+" | MP: "+stats.getMpActual()+"/"+stats.getMpMaximo());
        System.out.println("EXP: "+xpActual+"/"+(10 * nivel)+" | MATERIAS EQUIPADAS: "+busterSword.getCantidadMaterias()+"/5");
        System.out.println("--------------------------------------");
        System.out.println("Fuerza: "+stats.getFuerza()+" | Magia: "+stats.getMagia());
        System.out.println("Arma equipada: Buster Sword");
        System.out.println("--------------------------------------");
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
        stats.restaurarTodo();
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
        stats.recibirDanio(cantidadDanio);
        this.limiteActual += cantidadDanio / 2;
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
    aumenta la barra del limite en base al daño que cloud hace.
    */
    public void cargarLimitePorDanio(int cantidadDanio){
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
    aumenta la experiencia y el nivel.
    */
    public void recibirXP(int cantidadXP){
        this.xpActual += cantidadXP;
        int xpNecesaria = 10*nivel;
        if(this.xpActual >= xpNecesaria){
            this.xpActual = 0;
            this.nivel++;
            stats.aumentarStat(TipoStat.HP_MAX, 10);
            stats.aumentarStat(TipoStat.MP_MAX, 5);
            stats.aumentarStat(TipoStat.FUERZA, 4);
            stats.aumentarMagia(6);
            stats.restaurarTodo();
            System.out.println("\n¡NIVEL AUMENTADO!");
            System.out.println("Cloud ha alcanzado el Nivel " +nivel);
            System.out.println("Tus estadisticas han aumentado");
            
        }
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
    Parametro 1: int
    ***
    Tipo de Retorno: boolean
    ***
    quita chatarra si el jugador tiene mucho.
    */
    public boolean gastarChatarra(int costo){
        if(this.chatarra >=costo){
            this.chatarra -=costo;
            return true;
        }
        return false;
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
    /*
    ***
    Parametro 1: int
    ***
    Tipo de Retorno: None
    ***
    Cura al jugador sin superar la vida maxima de este.
    */
    public void curarVida(int cantidadCura){
        stats.curarVida(cantidadCura);
    }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: None
    ***
    Aplica el reinicio por derrota en la zona peligrosa.
    */
    public void aplicarDerrota(){
        this.chatarra =0;
        this.mochila.clear();
        this.restaurarPuntos();
        System.out.println("Se perdio la chatarra y las materias de la mochila.");
        System.out.println("Se mantiene las materias equipadas en el arma");
    }
    public int getNivel(){
        return nivel;
    }
    public int getPuntosVidaActual(){
        return stats.getHpActual();
    }
    public int getLimiteActual(){
        return limiteActual;
    }
    public Estadisticas getStats(){
        return stats;
    }
    public ArrayList<Materia> getMochila(){
        return mochila;
    }
    public Arma getBusterSword(){
        return busterSword;
    }
    public int getCantidadMateriasEquipadas(){
        return busterSword.getCantidadMaterias();
    }
    public int getXpActual(){
        return xpActual;
    }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: None
    ***
    muestra la mochila con las materias y equipa una en el arma.
    */
    public void mostrarMochila(){
        Scanner consola = new Scanner(System.in);
        if(mochila.size()==0){
            System.out.println("\nLa mochila esta vacia");
            return;
        }
        System.out.println("\n=== MOCHILA ===");
        for(int i=0;i<mochila.size();i++){
            System.out.println((i+1)+". "+mochila.get(i).getNombre());
        }
        System.out.println("0. Volver");
        System.out.println("Seleccione una materia para equipar: ");
        int opcion = consola.nextInt();
        if(opcion >0 && opcion <=mochila.size()){
            Materia materia = mochila.get(opcion -1);
            equiparMateria(materia);
        } 
    }



















    /*
    Clase Arma anidada
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
            return (int)(stats.getFuerza()* 1.25);
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
            if(cantidad ==0){
                System.out.println("No hay una materia de este elemento");
                return 0;
            }
            int costoMP = 10+(5*cantidad);
            if(stats.gastarMagia(costoMP)){
                return (int)(stats.getMagia()*(1.0+(0.5*cantidad)));
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
        public int calcularDanioLimite(){
            if(limiteActual == 100){
                limiteActual = 0;
                return stats.getFuerza()*5;
            }
            System.out.println("Limite no disponible para efectuar el ataque");
            return 0;
        }
        public int getCantidadMaterias(){
            return materiasEquipadas.size();
        }
   }
}