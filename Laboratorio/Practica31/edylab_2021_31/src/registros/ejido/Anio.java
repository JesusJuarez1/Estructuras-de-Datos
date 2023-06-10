package registros.ejido;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;

/**
 * Esta clase sumula ser un año el cual almacena un arreglo de cosechas del mismo año
 */
public class Anio implements IAnio{
    protected int anio;
    protected ArregloDatos cosechas;

    public Anio(int anio){
        this.anio = anio;
        cosechas = new ArregloDatos(6);
        agregarCosechas();
    }

    @Override
    public int getAnio() {
        return anio;
    }

    @Override
    public void setAnio(int anio) {
        this.anio = anio;
    }

    public ArregloDatos getCosechas() {
        return cosechas;
    }

    public void setCosechas(ArregloDatos cosechas) {
        this.cosechas = cosechas;
    }

    @Override
    public void agregarCosechas(){//Crea las cosechas pedidas y llama al metodo agregarCosecha
        SalidaTerminal.consola("Ingresa las toneladas para el Frijol: ");
        agregarCosecha(new Cosecha("Frijol",EntradaTerminal.consolaDouble()));
        SalidaTerminal.consola("Ingresa las toneladas para el Maiz: ");
        agregarCosecha(new Cosecha("Maiz",EntradaTerminal.consolaDouble()));
        SalidaTerminal.consola("Ingresa las toneladas para el Chile: ");
        agregarCosecha(new Cosecha("Chile",EntradaTerminal.consolaDouble()));
        SalidaTerminal.consola("Ingresa las toneladas para el Zanahoria: ");
        agregarCosecha(new Cosecha("Zanahoria",EntradaTerminal.consolaDouble()));
        SalidaTerminal.consola("Ingresa las toneladas para el Ajo: ");
        agregarCosecha(new Cosecha("Ajo",EntradaTerminal.consolaDouble()));
        SalidaTerminal.consola("Ingresa las toneladas para el Cebolla: ");
        agregarCosecha(new Cosecha("Cebolla",EntradaTerminal.consolaDouble()));
    }

    @Override
    public boolean agregarCosecha(Cosecha cosecha){ //agrega una sola cosecha
        int pos = cosechas.agregar(cosecha);
        if(pos != -1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return anio+"";
    }
}
