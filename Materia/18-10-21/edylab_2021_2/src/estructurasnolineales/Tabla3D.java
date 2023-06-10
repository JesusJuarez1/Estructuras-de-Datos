package estructurasnolineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;

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

    public ArregloDatos pasarATabla2DxColumnas(){
        ArregloDatos tablas2d=new ArregloDatos(columnas);

        //Primero se ocupa recorrer todas las rebanadas (columnas de la tabla3d)
        for(int columna=0;columna<columnas;columna++){
            //Ahora con cada rebanada, lo que tenemos que hacer es ir creando una tabla2d
            //para guardar la rebanada (filasxcolumnas)
            Tabla2D tabla2dRebanada=new Tabla2D(filas,profundidad);
            //Hay que llenar esta rebanada creada con datos
            //Recorrer todas las filas de la rebanada original
            for(int fila=0;fila<filas;fila++){
                //Recorrer todas las columnas (profundidad) de la rebanada original
                for(int prof=0;prof<profundidad;prof++){
                    tabla2dRebanada.asignarCelda(fila,prof,lote[fila][columna][prof]);
                }
            }
            //Ya teniendo una rebanada llena (tabla2d) hay que ingresarla a nuestroa rreglo que
            //guarda toda las tablas2d
            tablas2d.agregar(tabla2dRebanada);
        }
        return tablas2d;
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
