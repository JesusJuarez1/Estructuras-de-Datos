package estructurasnolineales;

import entradasalida.SalidaTerminal;

public class Tabla3D {
    protected int filas;
    protected int columnas;
    protected int profundidad;
    protected Object lote[][][];

    public Tabla3D(int filas,int columnas,int profundidad){
        this.filas=filas;
        this.columnas=columnas;
        this.profundidad=profundidad;
        lote=new Object[filas][columnas][profundidad];
    }

    public Tabla3D(int filas,int columnas,int profundidad, Object contenido){
        this.filas=filas;
        this.columnas=columnas;
        this.profundidad=profundidad;
        lote=new Object[filas][columnas][profundidad];
        rellenar(contenido);
    }

    public Object obtenerCelda(int fila, int columna, int prof){
        if(enLimites(fila,filas)==true && enLimites(columna,columnas)==true &&
                enLimites(prof,profundidad)==true){
            return lote[fila][columna][prof];
        }else{
            return null;
        }
    }

    public boolean asignarCelda(int fila, int columna, int prof, Object contenido){
        if(enLimites(fila,filas)==true && enLimites(columna,columnas)==true &&
                enLimites(prof,profundidad)==true){
            lote[fila][columna][prof]=contenido;
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
                //asumir que hay una sola columna y haré un recorrido de las hileras
                for(int prof=0;prof<profundidad;prof++){
                    lote[fila][columna][prof]=contenido;
                }
            }
        }
    }

    public void imprimirxColumnas(){
        //Rebanar por cada columa
        for(int columna=0;columna<columnas;columna++){
            //ahora, tenemos una tabla 2D, se imprime primero su renglón
            for(int fila=0;fila<filas;fila++){
                //ahora sigue las columnas de la tabla 2d, es decir la profundidad original
                for(int prof=0;prof<profundidad;prof++){
                    SalidaTerminal.consola(lote[fila][columna][prof]+ " ");
                }
                //cuando acaba todas las columnas de la tabla 2d (profundidad)
                SalidaTerminal.consola("\n");
            }
            //cuando acabe todas las filas de la tabla 2d
            SalidaTerminal.consola("\n");
        }
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getProfundidad() {
        return profundidad;
    }

}
