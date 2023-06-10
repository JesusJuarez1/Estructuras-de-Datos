package estructurasnolineales;

import entradasalida.SalidaTerminal;

public class Tabla2D {
    protected int filas;
    protected int columnas;
    protected Object lote[][];

    public Tabla2D(int filas,int columnas){
        this.filas=filas;
        this.columnas=columnas;
        lote=new Object[filas][columnas];
    }

    public Tabla2D(int filas,int columnas, Object contenido){
        this.filas=filas;
        this.columnas=columnas;
        lote=new Object[filas][columnas];
        rellenar(contenido);
    }

    public Object obtenerCelda(int fila, int columna){
        if(enLimites(fila,filas)==true && enLimites(columna,columnas)==true ){
            return lote[fila][columna];
        }else{
            return null;
        }
    }

    public boolean asignarCelda(int fila, int columna, Object contenido){
        if(enLimites(fila,filas)==true && enLimites(columna,columnas)==true){
            lote[fila][columna]=contenido;
            return true;
        }else{
            return false;
        }
    }

    private boolean enLimites(int indice,int tamDimension){
        if(indice>=0 && indice<tamDimension){
            return true;
        }else{
            return false;
        }
    }

    public void rellenar(Object contenido){
        for(int fila=0;fila<filas;fila++){ //recorrer de una por una las filas
            //asumir que es un solo renglon (fila)
            for(int columna=0;columna<columnas;columna++){
                lote[fila][columna]=contenido;
            }
        }
    }

    public void imprimir(){
        //Rebanar por cada fila
        for(int fila=0;fila<filas;fila++){
            //ahora, tenemos una tabla 2D, se imprime primero su columna
            for(int columna=0;columna<columnas;columna++){
                SalidaTerminal.consola(lote[fila][columna]+ " ");
            }
            //cuando acabe todas las columnas de la tabla 2d
            SalidaTerminal.consola("\n");
        }
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

}
