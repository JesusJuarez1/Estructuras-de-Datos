package registros.ejido;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;

/**
 * Clase que simula ser un campesino el cual tendra un nombre y un arreglo de años
 * @author Jesus
 * @version 1.0
 */
public class Campesino implements ICampesino{
    protected String nombre;
    protected ArregloDatos anios;

    public Campesino(String nombre,int numAnios){
        this.nombre=nombre;
        anios = new ArregloDatos(numAnios);
        while(numAnios>0){
            agregarAnio();
            numAnios-=1;
        }

    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public ArregloDatos getAnios() {
        return anios;
    }

    @Override
    public void setAnios(ArregloDatos anios) {
        this.anios = anios;
    }

    @Override
    public boolean agregarAnio(){
        SalidaTerminal.consola("Ingrese el año ("+nombre+"): ");
        Integer anio = EntradaTerminal.consolaInteger();
        int r = anios.agregar(new Anio(anio));
        if(r == -1){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Double promedioCosecha(String nombreCosecha){
        double promedio = 0.0;
        for(int pos=0;pos<anios.cantidadElementos();pos++){
            Anio anio = (Anio) anios.obtener(pos);
            ArregloDatos cosechas = anio.cosechas;
            Integer cos = (Integer) cosechas.buscar(nombreCosecha);
            if(cos != null){
                Cosecha cosecha = (Cosecha)cosechas.obtener(cos);
                promedio += cosecha.getToneladas();
            }else{
                return null;
            }
        }
        return (promedio/anios.cantidadElementos());
    }

    /**
     * Obtiene el total de toneladas producidas de un solo producto
     * @param nomCosecha Nombre de la cosecha a evaluar
     * @return Total de toneladas producidas
     */
    public Double cantidadTonel(String nomCosecha){
        double suma = 0.0;
        for(int pos=0;pos<anios.cantidadElementos();pos++){
            Anio anio = (Anio) anios.obtener(pos);
            ArregloDatos cosechas = anio.cosechas;
            Integer cos = (Integer) cosechas.buscar(nomCosecha);
            if(cos != null){
                Cosecha cosecha = (Cosecha)cosechas.obtener(cos);
                suma += cosecha.getToneladas();
            }else{
                return null;
            }
        }
        return suma;
    }

    @Override
    public Cosecha produceMasQue(double cantidad){
        ArregloDatos cosechas = (ArregloDatos) ((Anio)anios.obtener(0)).cosechas;
        for(int posicion=0;posicion<cosechas.cantidadElementos();posicion++){
            if(promedioCosecha(((Cosecha)cosechas.obtener(posicion)).getNombre()) > cantidad){
                return (Cosecha)cosechas.obtener(posicion);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
