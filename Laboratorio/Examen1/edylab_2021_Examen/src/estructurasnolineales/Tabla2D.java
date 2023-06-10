package estructurasnolineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import herramientas.comunes.Herramientas;

/**
 * Clase que controla una matriz de dos dimensiones
 * @author Jesus
 * @version 1.0
 */
public class Tabla2D implements ITabla2D{
    protected int filas;
    protected int columnas;
    protected Object lote[][];

    public Tabla2D(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        lote = new Object[filas][columnas];
    }

    public Tabla2D(int filas, int columnas, Object contenido) {
        this.filas = filas;
        this.columnas = columnas;
        lote = new Object[filas][columnas];
        rellenar(contenido);
    }

    @Override
    public Object obtenerCelda(int fila, int columna){
        if(enLimites(fila, filas) && enLimites(columna, columnas)) {
            if(lote[fila][columna] != null){
                return lote[fila][columna];
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    /**
     * Evalua si la indice esta entre el limite 0 hasta tamDimension
     * @param indice Indice a evaluar
     * @param tamDimension Dimension superior
     * @return True si esta entre los limites, false en caso contrario
     */
    private boolean enLimites(int indice, int tamDimension){
        if(indice>=0 && indice<tamDimension){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean asignarCelda(int fila, int columna, Object contenido){
        if(enLimites(fila, filas)==true && enLimites(columna, columnas)==true){
            lote[fila][columna]=contenido;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int getFilas() {
        return filas;
    }

    @Override
    public int getColumnas() {
        return columnas;
    }

    @Override
    public void imprimirR(){
        for(int fila=0;fila<filas;fila++) {
            for(int columna=0;columna<columnas;columna++){
                SalidaTerminal.consola(lote[fila][columna] + " ");
            }
            SalidaTerminal.consola("\n");
        }
    }

    @Override
    public void imprimirC(){
        for(int columna=0;columna<columnas;columna++) {
            for(int fila=0;fila<filas;fila++){
                SalidaTerminal.consola(lote[fila][columna] + "\n");
            }
            SalidaTerminal.consola("\n");
        }
    }

    @Override
    public void transpuesta(){
        Tabla2D traspuesta = new Tabla2D(columnas,filas);
        for(int columna=0;columna<columnas;columna++) {
            for(int fila=0;fila<filas;fila++){
                traspuesta.lote[columna][fila] = lote[fila][columna];
            }
        }
        redefinirTabla(traspuesta);
    }

    @Override
    public void rellenar(Object contenido){
        for(int fila=0;fila<filas;fila++){
            for(int columna=0; columna<columnas;columna++){
                lote[fila][columna]=contenido;
            }
        }
    }

    @Override
    public Tabla2D clonar(){
        Tabla2D t2d = new Tabla2D(filas,columnas);
        for(int columna=0;columna<columnas;columna++){
            for(int fila=0;fila<filas;fila++){
                t2d.asignarCelda(fila,columna,obtenerCelda(fila,columna));
            }
        }
        return t2d;
    }

    @Override
    public boolean esIgual(Tabla2D matriz2){
        if(columnas == matriz2.columnas && filas == matriz2.filas){
            for(int columna=0;columna< matriz2.columnas;columna++){
                for(int fila=0;fila<matriz2.filas;fila++){
                    if(Herramientas.compararObjetos(obtenerCelda(fila,columna),matriz2.obtenerCelda(fila,columna))!=0){
                        return false;
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean vectorColumna(int numFilas, Object contenido){
        if(enLimites(numFilas,filas+1)){
            for(int fila=0;fila<numFilas;fila++){
                asignarCelda(fila,0,contenido);
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean vectorRenglon(int numColumnas,Object contenido) {
        if (enLimites(numColumnas, columnas+1)) {
            for (int columna = 0; columna < numColumnas; columna++) {
                asignarCelda(0, columna, contenido);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean redefinirTabla(Tabla2D tabla2){
        this.columnas = tabla2.columnas;
        this.filas = tabla2.filas;
        this.lote = new Object[filas][columnas];
        for(int columna=0;columna<tabla2.columnas;columna++){
            for(int fila=0;fila< tabla2.filas;fila++){
                lote[fila][columna] = tabla2.lote[fila][columna];
            }
        }
        return true;
    }

    @Override
    public boolean agregarFila(ArregloDatos arreglo){
        if(arreglo.cantidadElementos() <= columnas){
            for(int columna=0;columna<arreglo.cantidadElementos();columna++){
                lote[0][columna] = arreglo.obtener(columna);
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean agregarColumna(ArregloDatos arreglo){
        if(arreglo.cantidadElementos() <= filas){
            for(int fila=0;fila<arreglo.cantidadElementos();fila++){
                lote[fila][0] = arreglo.obtener(fila);
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean agregarTablaxColumna(Tabla2D tabla2){
        if(filas == tabla2.filas && columnas <= tabla2.columnas){
            Tabla2D m2d = new Tabla2D(filas,(columnas+tabla2.columnas));
            for(int columna=0;columna<columnas;columna++){
                for(int fila=0;fila<filas;fila++){
                    m2d.lote[fila][columna] = lote[fila][columna];
                }
            }
            for(int columna=columnas,col=0;columna<m2d.columnas;columna++,col++){
                for(int fila=0;fila<m2d.filas;fila++){
                    m2d.lote[fila][columna] = tabla2.obtenerCelda(fila,col);
                }
            }
            return redefinirTabla(m2d);
        }else{
            return false;
        }
    }

    @Override
    public boolean agregarTablaxRenglon(Tabla2D tabla2){
        if(columnas == tabla2.columnas && filas <= tabla2.filas){
            Tabla2D m2d = new Tabla2D((filas+tabla2.filas),columnas);
            for(int columna=0;columna<columnas;columna++){
                for(int fila=0;fila<filas;fila++){
                    m2d.lote[fila][columna] = lote[fila][columna];
                }
            }
            for(int columna=0;columna< m2d.columnas;columna++){
                for(int fila=filas,fil=0;fila<m2d.filas;fila++,fil++){
                    m2d.lote[fila][columna] = tabla2.obtenerCelda(fil,columna);
                }
            }

            return redefinirTabla(m2d);
        }else{
            return false;
        }
    }

    @Override
    public Tabla3D tabla2DaTabla3D(ArregloDatos tablas){
        Tabla3D m3d = new Tabla3D(filas,columnas,tablas.cantidadElementos()+1);
        for(int columna=0;columna<columnas;columna++){
            for(int fila = 0; fila< filas; fila++){
                m3d.asignarCelda(fila,columna,0,lote[fila][columna]);
            }
        }
        for(int prof=1,profun=0;prof<m3d.profundidad;prof++,profun++){
            for(int columna=0;columna<columnas;columna++){
                for(int fila=0;fila<filas;fila++){
                    m3d.asignarCelda(fila,columna,prof,((Tabla2D)tablas.obtener(profun)).lote[fila][columna]);
                }
            }
        }
        return m3d;
    }

    @Override
    public Tabla2D aVectorColumna(){
        Tabla2D vector = new Tabla2D(filas*columnas,1);
        int posicion = 0;
        for(int columna=0;columna<columnas;columna++){
            for(int fila=0;fila<filas;fila++){
                vector.lote[posicion][0] = lote[fila][columna];
                posicion++;
            }
        }
        return vector;
    }

    @Override
    public Tabla2D aVectorRenglon(){
        Tabla2D vector = new Tabla2D(1,filas*columnas);
        int posicion = 0;
        for(int columna=0;columna<columnas;columna++){
            for(int fila=0;fila<filas;fila++){
                vector.lote[0][posicion] = lote[fila][columna];
                posicion++;
            }
        }
        return vector;
    }

    @Override
    public boolean quitarColumna(TipoColumna tipoCol){
        Tabla2D t2d = new Tabla2D(filas,columnas-1);
        if(tipoCol == TipoColumna.DERECHA){
            for(int columna=0;columna< t2d.columnas;columna++){
                for(int fila=0;fila< t2d.filas;fila++){
                    t2d.lote[fila][columna] = lote[fila][columna];
                }
            }
        }else if(tipoCol == TipoColumna.IZQUIERDA){
            for(int columna=1,col=0;columna< t2d.columnas;columna++,col++){
                for(int renglon=0;renglon< t2d.filas;renglon++){
                    t2d.lote[renglon][col] = lote[renglon][columna];
                }
            }
        }
        return redefinirTabla(t2d);
    }

    @Override
    public boolean quitarFila(TipoRenglon tipoReng){
        Tabla2D t2d = new Tabla2D(filas-1,columnas);
        if(tipoReng == TipoRenglon.INFERIOR){
            for(int columna=0;columna< t2d.columnas;columna++){
                for(int fila=0;fila< t2d.filas;fila++){
                    t2d.lote[fila][columna] = lote[fila][columna];
                }
            }
        }else if(tipoReng == TipoRenglon.SUPERIOR){
            for(int columna=0;columna< t2d.columnas;columna++){
                for(int fila=1,fil=0;fila<t2d.filas+1;fila++,fil++){
                    t2d.lote[fil][columna] = lote[fila][columna];
                }
            }
        }
        return redefinirTabla(t2d);
    }

    @Override
    public boolean quitarFila(int indice){
        Tabla2D t2d = new Tabla2D(filas-1,columnas);
        for(int columna=0;columna< t2d.columnas;columna++){
            for(int fila=0,fil=0;fila< t2d.filas+1;fila++){
                if(fila != indice){
                    t2d.lote[fil][columna] = lote[fila][columna];
                    fil++;
                }
            }
        }
        return redefinirTabla(t2d);
    }

    @Override
    public boolean quitarColumna(int indice){
        Tabla2D t2d = new Tabla2D(filas,columnas-1);
        for(int columna=0,col=0;columna< t2d.columnas+1;columna++){
            if(columna != indice){
                for(int fila=0;fila< t2d.filas;fila++){
                    t2d.lote[fila][col] = lote[fila][columna];
                }
                col++;
            }
        }
        return redefinirTabla(t2d);
    }
}
