package Componentes;
public class Mejora{
    private String nombre;
    private TipoStat stat;
    private int cantidad;
    private int costoChatarra;
    public Mejora(String nombre, TipoStat stat, int cantidad, int costoChatarra){
        this.nombre = nombre;
        this.stat = stat;
        this.cantidad = cantidad;
        this.costoChatarra = costoChatarra;
    }
    /*
    ***
    Parametro 1:estadisticas
    ***
    Tipo de Retorno: None
    ***
    ejecuta una mejora en las estadisticas del jugador.
    */
    public void aplicarMejora(Estadisticas estadisticas){
        estadisticas.aumentarStat(stat, cantidad);
    }
    public String getNombre(){
        return nombre;
    }
    public int getCostoChatarra(){
        return costoChatarra;
    }
}