package estructurasnolineales;

import estructuraslineales.ArregloDatos;
import estructuraslineales.ArregloNumeros;

public class Tabla2DNumeros extends Tabla2D{

    public Tabla2DNumeros(int filas, int columnas) {
        super(filas, columnas);
    }

    public Tabla2DNumeros(int filas, int columnas, Object contenido) {
        super(filas, columnas);
        if(contenido instanceof Number){
            rellenar(contenido);
        }
    }

    @Override
    public boolean asignarCelda(int fila, int columna, Object contenido){
        if(contenido instanceof Number){
            return super.asignarCelda(fila,columna,(Double)contenido);
        }else{
            return false;
        }
    }

    @Override
    public void rellenar(Object contenido){
        if(contenido instanceof Number){
            super.rellenar((Double)contenido);
        }
    }

    @Override
    public boolean esIgual(Tabla2D matriz2){
        if(matriz2 instanceof Tabla2DNumeros){
            return super.esIgual(matriz2);
        }else{
            return false;
        }
    }

    @Override
    public boolean vectorColumna(int numFilas, Object contenido){
        if(contenido instanceof Number){
            return super.vectorColumna(numFilas,contenido);
        }else{
            return false;
        }
    }

    @Override
    public boolean vectorRenglon(int numColumnas,Object contenido){
        if(contenido instanceof Number){
            return super.vectorRenglon(numColumnas,contenido);
        }else{
            return false;
        }
    }

    @Override
    public boolean redefinirTabla(Tabla2D tabla2){
        if(tabla2 instanceof Tabla2DNumeros){
            return super.redefinirTabla(tabla2);
        }else{
            return false;
        }
    }

    @Override
    public boolean agregarFila(ArregloDatos arreglo){
        if(arreglo instanceof ArregloNumeros){
            return super.agregarFila(arreglo);
        }else{
            return false;
        }
    }

    @Override
    public boolean agregarColumna(ArregloDatos arreglo){
        if(arreglo instanceof ArregloNumeros){
            return super.agregarColumna(arreglo);
        }else{
            return false;
        }
    }

    @Override
    public boolean agregarTablaxColumna(Tabla2D tabla2){
        if(tabla2 instanceof Tabla2DNumeros){
            return super.agregarTablaxColumna(tabla2);
        }else{
            return false;
        }
    }

    @Override
    public boolean agregarTablaxRenglon(Tabla2D tabla2){
        if(tabla2 instanceof Tabla2DNumeros){
            return super.agregarTablaxRenglon(tabla2);
        }else{
            return false;
        }
    }

    /**
     * Multiplica el escalar por cada posicion de la tabla
     * @param escalar Escalar por el cual se va multiplicar
     * @return True si lo hizo false en caso contrario
     */
    public boolean xEscalar(Number escalar){
        for(int columna=0;columna<columnas;columna++){
            for(int fila=0;fila<filas;fila++) {
                if(obtenerCelda(fila,columna) != null){
                    asignarCelda(fila,columna,((Double)obtenerCelda(fila,columna))*
                            (Double)escalar);
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Multiplica el escalar de cada posicion por cada posicion (columna) correspondiente en la tabla
     * @param escalares Arreglo que contiene los esclares
     * @return True si lo hizo false en caso contrario
     */
    public boolean xEscalares(ArregloNumeros escalares){
        if(columnas >= escalares.cantidadElementos()){
            for(int posicion=0;posicion<escalares.cantidadElementos();posicion++){
                asignarCelda(0,posicion,((Double)obtenerCelda(0,posicion)*
                        (Double)escalares.obtener(posicion)));
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Suma el escalar por cada posicion de la tabla
     * @param escalar Escalar que se va sumar
     * @return True si lo hizo false en caso contrario
     */
    public boolean sumarEscalar(Number escalar){
        for(int columna=0;columna<columnas;columna++){
            for(int fila=0;fila<filas;fila++) {
                if(obtenerCelda(fila,columna) != null){
                    asignarCelda(fila,columna,((Double)obtenerCelda(fila,columna))+
                            (Double)escalar);
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Suma el escalar de cada posicion por cada posicion (columna) correspondiente en la tabla
     * @param escalares Arreglo que contiene los escalares
     * @return True si lo hizo false en caso contrario
     */
    public boolean sumarEscalares(ArregloNumeros escalares){
        if(columnas >= escalares.cantidadElementos()){
            for(int posicion=0;posicion<escalares.cantidadElementos();posicion++){
                asignarCelda(0,posicion,((Double)obtenerCelda(0,posicion)+
                        (Double)escalares.obtener(posicion)));
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Multiplica la tabla por la tabla pasada como parametro
     * @param tabla2 Tabla por la cual se va multiplicar la tabla actual
     * @return True si lo hizo false en caso contrario
     */
    public boolean multiplicar(Tabla2DNumeros tabla2){
        if(columnas == tabla2.filas){
            Tabla2DNumeros m2dn = new Tabla2DNumeros(filas, tabla2.columnas);
            double producto;
            for(int renglon=0;renglon<this.filas;renglon++){
                for(int fila=0;fila<tabla2.columnas;fila++){
                    producto = 0;
                    for(int renglon2=0;renglon2< tabla2.filas;renglon2++){
                        producto += ((Double)obtenerCelda(renglon,renglon2)*
                                (Double)tabla2.obtenerCelda(renglon2,fila));
                    }
                    m2dn.asignarCelda(renglon,fila,producto);
                }
            }
            return redefinirTabla(m2dn);
        }else{
            return false;
        }
    }

    /**
     * Suma la tabla por la tabla pasada como parametro
     * @param tabla2 Tabla por la cual se va sumar la tabla actual
     * @return True si lo hizo false en caso contrario
     */
    public boolean sumar(Tabla2DNumeros tabla2){
        if(columnas == tabla2.columnas && filas == tabla2.filas){
            for(int columna=0;columna<columnas;columna++){
                for(int fila=0;fila<filas;fila++){
                    asignarCelda(fila,columna,((Double)obtenerCelda(fila,columna)+
                            (Double)tabla2.obtenerCelda(fila,columna)));
                }
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Eleva a la potencia cada indicada cada elemento de la tabla posicion por posicion
     * @param escalar Potencia a la cual se elevara cada elemento
     * @return True si lo hizo false en caso contrario
     */
    public boolean potenciaExE(Number escalar){
        if((Double)escalar == 0){
            this.rellenar(1);
            return true;
        }else{
            for(int columna=0;columna<columnas;columna++){
                for(int fila=0;fila<filas;fila++){
                    asignarCelda(fila,columna,(Math.pow((Double)obtenerCelda(fila,columna),
                            (Double)escalar)));
                }
            }
        }
        return true;
    }

    /**
     * Se aplica el logaritmo indicado a cada elemento de la tabla
     * @param tipoLogaritmo Tipo de logaritmo, el cual indica que logaritmo se aplicara
     * @return True si lo hizo false en caso contrario
     */
    public boolean logaritmo(TipoLogaritmo tipoLogaritmo){
        for(int columna=0;columna<columnas;columna++){
            for(int fila=0;fila<filas;fila++){
                if((Double)obtenerCelda(fila,columna) == 0.0){
                    return false;
                }
            }
        }
        for(int columna=0;columna<columnas;columna++){
            for(int fila=0;fila<filas;fila++){
                if(tipoLogaritmo == TipoLogaritmo.NATURAL){
                    asignarCelda(fila,columna,(Math.log((Double)obtenerCelda(fila,columna))));
                }else{
                    if(tipoLogaritmo == TipoLogaritmo.BASE2){
                        asignarCelda(fila,columna,(Math.log((Double)obtenerCelda(fila,columna))/Math.log(2)));
                    }else{
                        if(tipoLogaritmo == TipoLogaritmo.BASE10){
                            asignarCelda(fila,columna,(Math.log10((Double)obtenerCelda(fila,columna))));
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Agrega una diagonal con el elemento indicado
     * @param contenido Elemento con el cual se hara la diagonal
     * @return True si lo hizo false en caso contrario
     */
    public boolean matrizDiagonal(Number contenido){
        if(filas >= columnas){
            for(int posicion=0;posicion<columnas;posicion++){
                asignarCelda(posicion,posicion,contenido);
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Determina si la tabla es una matriz triangular superior
     * @return True si lo hizo false en caso contrario
     */
    public boolean esDiagonalSup(){
        if(columnas == filas){
            double sum = 0.0;
            for(int fila=1;fila<filas;fila++){
                for(int columna=0;columna<columnas;columna++){
                    if(columna<fila){
                        sum += (Double)obtenerCelda(fila,columna);
                    }
                }
            }
            if(sum == 0){
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * Determina si la tabla es una matriz triangular inferior
     * @return True si lo hizo false en caso contrario
     */
    public boolean esDiagonalInf(){
        if(columnas == filas){
            double sum = 0.0;
            for(int columna=1;columna<columnas;columna++){
                for(int fila=0;fila<filas;fila++){
                    if(fila<columna){
                        sum += (Double)obtenerCelda(fila,columna);
                    }
                }
            }
            if(sum == 0){
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * Aplica esta operación dado por A2=AA, A3=AAA, ... donde el numero de A es determinado por exponente
     * @param exponente Numero de veces que se va elevar la matriz
     * @return True si lo hizo false en caso contrario
     */
    public boolean potencia(int exponente){
        int contador = 0;
        for(int veces=0;veces<exponente;veces++){
            if(multiplicar(this)){
                contador++;
            }
        }
        if(contador == exponente){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Dobla la matriz por columnas a la mitad, de tal forma que los elementos que
     * sobrepasan la mitad queden sumados a los elementos que no lo hacen
     * @return True si lo hizo false en caso contrario
     */
    public boolean doblarColumnas(){
        Tabla2DNumeros m1,m2;
        if((columnas%2) == 0) {
            m1 = new Tabla2DNumeros(filas, columnas / 2,0.0);
            m2 = new Tabla2DNumeros(filas, columnas / 2,0.0);
        }else {
            m1 = new Tabla2DNumeros(filas, (columnas / 2) + 1,0.0);
            m2 = new Tabla2DNumeros(filas, (columnas / 2) + 1,0.0);
        }
        for(int columna=0;columna<columnas;columna++){
            for(int fila=0;fila<filas;fila++){
                if(columna <= columnas/2){
                    m1.asignarCelda(fila,columna,obtenerCelda(fila,columna));
                }else{
                    m2.asignarCelda(fila,columna,obtenerCelda(fila,columna));
                }
            }
        }
        if(m1.sumar(m2)){
            return redefinirTabla(m1);
        }else{
            return false;
        }
    }

    /**
     * Dobla la matriz por filas a la mitad, de tal forma que los elementos que
     * sobrepasan la mitad queden sumados a los elementos que no lo hacen
     * @return True si lo hizo false en caso contrario
     */
    public boolean doblarFilas(){
        Tabla2DNumeros m1,m2;
        if((filas%2) == 0) {
            m1 = new Tabla2DNumeros(filas / 2, columnas,0.0);
            m2 = new Tabla2DNumeros(filas / 2, columnas,0.0);
        }else {
            m1 = new Tabla2DNumeros((filas / 2) + 1, columnas,0.0);
            m2 = new Tabla2DNumeros((filas / 2)+1, columnas,0.0);
        }
        for(int columna=0;columna<columnas;columna++){
            for(int fila=0;fila<filas;fila++){
                if(fila <= filas/2){
                    m1.asignarCelda(fila,columna,obtenerCelda(fila,columna));
                }else{
                    m2.asignarCelda(fila,columna,obtenerCelda(fila,columna));
                }
            }
        }
        if(m1.sumar(m2)){
            if(redefinirTabla(m1)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
