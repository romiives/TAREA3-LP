package Componentes;
public class Estadisticas{
    private int hpActual;
    private int hpMaximo;
    private int mpActual;
    private int mpMaximo;
    private int fuerza;
    private int magia;
    public Estadisticas(int hpMaximo, int mpMaximo, int fuerza, int magia){
        this.hpMaximo = hpMaximo;
        this.hpActual = hpMaximo:
        this.mpMaximo = mpMaximo;
        this.mpActual = mpMaximo;
        this.fuerza = fuerza;
        this.magia = magia;
    }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: None
    ***
    restaura vida y magia
    */
    public void restaurarTodo(){
        this.hpActual = hpMaximo;
        this.mpActual = mpMaximo;
    }
    /*
    ***
    Parametro 1: int
    ***
    Tipo de Retorno: None
    ***
    quita vida segun el daño qure recibe.
    */
    public void recibirDanio(int cantidadDanio){
        this.hpActual -= cantidadDanio;
        if(this.hpActual <0){
            this.hpActual =0;
        }
    }
    /*
    ***
    Parametro 1: int
    ***
    Tipo de Retorno: None
    ***
    aumenta vida sin superar el maximo.
    */
    public void curarVida(int cantidadCura){
        this.hpActual += cantidadCura;
        if(this.hpActual > hpMaximo){
            this.hpActual = hpMaximo;
        }
    }
    /*
    ***
    Parametro 1: int
    ***
    Tipo de Retorno: boolean
    ***
    resta magia si supera el maximo y retorna un boolean si el jugador pudo gastar magia o no.
    */
    public boolean gastarMagia(int costoMagia){
        if(this.mpActual >= costoMagia){
            this.mpActual -= costoMagia;
            return true;
        }
        return false;
    }
    /*
    ***
    Parametro 1: tipoStat
    Parametro 2: int
    ***
    Tipo de Retorno: None
    ***
    aumenta estadistica segun el tipo de mejora.
    */
    public void aumentarStat(TipoStat tipoStat, int cantidad){
        if(tipoStat == TipoStat.HP_MAX){
            this.hpMaximo +=cantidad;
            this.hpActual +=cantidad;
        } else if(tipoStat == TipoStat.MP_MAX){
            this.mpMaximo +=cantidad;
            this.mpActual +=cantidad;
        } else if(tipoStat == TipoStat.FUERZA){
            this.fuerza += cantidad;
        }
    }
    /*
    ***
    Parametro 1: int
    ***
    Tipo de Retorno: None
    ***
    aumenta la magia del jugador.
    */
    public void aumentarMagia(int cantidad){
        this.magia += cantidad;
    }
    public int getHpActual(){
        return hpActual;
    }
    public int getHpMaximo(){
        return hpMaximo;
    }
    public int getMpActual(){
        return mpActual;
    }
    public int getMpMaximo(){
        return mpMaximo;
    }
    public int getFuerza(){
        return fuerza;
    }
    public int getMagia(){
        return magia;
    }
}