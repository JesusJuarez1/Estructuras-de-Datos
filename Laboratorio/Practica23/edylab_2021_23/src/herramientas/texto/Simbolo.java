package herramientas.texto;

/**
 * Clase que almacena los simbolos de apertura y la linea en la que se encuentran
 */
public class Simbolo {
    protected String simbolo;
    protected int linea;
    protected int caracter;

    public Simbolo(String simbolo,int linea,int caracter){
        this.simbolo = simbolo;
        this.linea = linea;
        this.caracter = caracter;
    }
}
