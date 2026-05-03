package entidades;
public class Sephiroth extends Enemigo{
    private int contadorSuperNova;
    public Sephiroth(){
        super("Sephiroth", 500, 40);
        this.contadorSuperNova = 0;
    }
    /*
    ***
    Parametro 1: None
    ***
    Tipo de Retorno: None
    ***
    ejecuta el contador de supernova y avisa los ataques de sephiroth.
    */
    public void lanzarSuperNova(){
        contadorSuperNova++;
        if(contadorSuperNova>=10){
            System.out.println("Sephiroth ha lanzado SuperNova");
            contadorSuperNova = 0;
        } else{
            System.out.println("Sephiroth va a lanzar SuperNova: "+contadorSuperNova + "/10");
        }
    }
}