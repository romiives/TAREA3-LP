package Componentes;
public interface Vulnerable{
    /*
    ***
    Parametro 1: elemento
    ***
    Tipo de Retorno: double
    ***
    multiplicador de daño segun la debilidad, resistencia o inmunidad.
    */
    double evaluarDebilidad(Elemento elemento);
}