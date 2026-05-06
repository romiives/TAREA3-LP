package entidades;
import java.util.Scanner;
import Componentes.*;
public abstract class Enemigo{
    protected String nombre;
    protected int xpRecompensa;
    protected int chatarraRecompensa;
    protected Estadisticas stats;
    public Enemigo(String nombre, int hp, int fuerza, int xpRecompensa, int chatarraRecompensa){
        this.nombre = nombre;
        this.stats = new Estadisticas(hp, 0, fuerza, 0);
        this.xpRecompensa = xpRecompensa;
        this.chatarraRecompensa = chatarraRecompensa; 
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    ejecuta el ataque del enemigo hacia el jugador con un 85% de acierto.
    */
    public void atacar(Jugador jugador){
        int probabilidad = (int)(Math.ramdon() *100)+1;
        if(probabilidad<=85){
            int danio = (int)(stats.getFuerza()*1.25);
            System.out.println(nombre + "ataca a Cloud");
            jugador.danioRecibido(danio);
            System.out.println("Cloud acaba de recibir " + danio + "de daño");
        }else{
            System.out.println(nombre + "ataque mal ejecutado");
        }
    }
    /*
    ***
    Parametro 1: jugador
    ***
    Tipo de Retorno: None
    ***
    entrega experencia al jugador cuando derrota a un enemigo
    */
    public void giveXpRecompensa(Jugador jugador){
        jugador.recibirXP(xpRecompensa);
    }
    /*
    ***
    Parametro 1: int
    ***
    Tipo de Retorno: None
    ***
    Reduce la vida del enemigo dependiendo del daño que recibe de parte del jugador.
    */
    public void recibirDanio(int cantidadDanio){
        stats.recibirDanio(cantidadDanio);
    }
    /*
    ***
    Parametro 1: jugador
    Parametro 2: enemigo
    Parametro 3: boolean
    ***
    Tipo de Retorno: boolean
    ***
    inicia el combate entre cloud y un enemigo, retornado un boolean segun el caso.
     */
    public static boolean iniciarCombate(Jugador jugador, Enemigo enemigo, boolean permitirHuir){
        Scanner consola = new Scanner(System.in);
        while(jugador.getPuntosVidaActual()>0 && enemigo.getHpActual()>0){
            System.out.println("\n=== Combate de Cloud con Enemigo ===");
            System.out.println("Cloud HP: " +jugador.getPuntosVidaActual());
            System.out.println(enemigo.getNombre() +" HP: "+enemigo.getHpActual());
            System.out.println("Limite: " +jugador.getLimiteActual() +"/100");
            System.out.println("1. Ataque Fisico");
            System.out.println("2. Magia FUEGO");
            System.out.println("3. Magia HIELO");
            System.out.println("4. Magia RAYO");
            System.out.println("5. Cura");
            System.out.println("6. Ataque Limite");
            if(permitirHuir){
                System.out.println("7. Huir");
            }
            System.out.print("Opcion: ");
            int opcion = consola.nextInt();
            if(opcion == 1){
                int danio = jugador.getBusterSword().calcularDanioFisico();
                enemigo.recibirDanio(danio);
                jugador.cargarLimitePorDanio(danio);
                System.out.println("Cloud ha hecho "+danio+"de daño.");
            } else if(opcion==2){
                usarMagia(jugador, enemigo, Elemento.FUEGO);
            } else if(opcion==3){
                usarMagia(jugador, enemigo, Elemento.HIELO);
            } else if(opcion==4){
                usarMagia(jugador, enemigo, Elemento.RAYO);
            } else if(opcion==5){
                int cura = jugador.getBusterSword().calcularDanioMagico(Elemento.CURA);
                if(cura>0){
                    jugador.curarVida(cura);
                    System.out.println("Cloud ha recuperado "+cura+"de HP");   
                }
            } else if(opcion==6){
                int danio = jugador.getBusterSword().calculaDanioLimite();
                if(danio>0){
                    enemigo.recibirDanio(danio);
                    System.out.println("Cloud ha hecho uso de un ataque limite e hizo "+danio+"de daño");
                    if(enemigo instanceof Sephiroth){
                        ((Sephiroth)enemigo).reiniciarSuperNova();
                    }
                }
            } else if(opcion==7 && permitirHuir){
                int probabilidad = (int)(Math.ramdon()*100)+1;
                if(probabilidad <=50){
                    System.out.println("Cloud ha logrado huir");
                    return true;
                } else{
                    System.out.println("Cloud no pudo huir");
                }
            } else{
                System.out.println("Opcion invalida");
            }
            if(enemigo.getHpActual()<=0){
                System.out.println(enemigo.getNombre()+"ha sido derrotado");
                enemigo.giveXpRecompensa(jugador);
                if(enemigo instanceof EnemigoSalvaje){
                    ((EnemigoSalvaje)enemigo).giveChatarraraRecomenpensa(jugador);
                }
                return true;
            }
            if(enemigo instanceof Sephiroth){
                ((Sephiroth)enemigo).lanzarSuperNova(jugador);
            }else{
                enemigo.atacar(jugador);
            }
        }
        return jugador.getPuntosVidaActual()>0;
    }
    /*
    ***
    Parametro 1: jugador
    Parametro 2: enemigo
    Parametro 3: elemento
    ***
    Tipo de Retorno: None
    ***
    efectua la magia y la debilidad, resistencia o la inmunidad.
     */
    public static void usarMagia(Jugador jugador, Enemigo enemigo, Elemento elemento){
        int danioBase = jugador.getBusterSword().calcularDanioMagico(elemento);
        if(danioBase<=0){
            return;
        }
        double multiplicador = 1.0;
        if(enemigo instanceof Vulnerable){
            multiplicador = ((Vulnerable)enemigo).evaluarDebilidad(elemento);
        }
        int danioFinal = (int)(danioBase*multiplicador);
        enemigo.recibirDanio(danioFinal);
        jugador.cargarLimitePorDanio(danioFinal);
        System.out.println("Daño base: "+danioBase);
        System.out.println("Elemental: "+multiplicador);
        System.out.println("Daño final: "+danioFinal);
    }
    public String getNombre(){
        return nombre;
    }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: int
    ***
    retorno la vida del enemigo actual.
    */
    public int getHpActual(){
        return stats.getHpActual();
    }
}