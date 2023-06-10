package registros.diccionario;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;

public class Palabra implements IPalabra{
    protected String nombre;
    protected String definicion;
    protected TipoPalabra tipo;

    public Palabra(String nombre, String definicion,TipoPalabra tipo){
        this.nombre = nombre;
        this.definicion = definicion;
        this.tipo = tipo;
    }

    @Override
    public String getDefinicion() {
        return definicion;
    }

    @Override
    public String toString(){
        return nombre;
    }

    @Override
    public String toStringObjeto(){
        return nombre+": \""+tipo.getNombre()+"\", "+definicion;
    }
}
