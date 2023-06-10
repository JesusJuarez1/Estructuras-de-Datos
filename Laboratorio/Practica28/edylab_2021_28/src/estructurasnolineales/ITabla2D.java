package estructurasnolineales;

import estructuraslineales.ArregloDatos;
import estructurasnolineales.Tabla2D;

/**
 * Interface de Matriz2D, contiene todas las operaciones de Matriz2D
 * @author Jesus
 * @version 1.0
 */
public interface ITabla2D {

    /**
     * Obtiene el elemento en la posicion indicada
     * @param fila indice de fila
     * @param columna indice de columna
     * @return Obtiene el elemento que esta en la posicion indicada
     */
    public Object obtenerCelda(int fila, int columna);

    /**
     * Le asigna un valor a la posicion indicada
     * @param fila Indice de fila
     * @param columna Indice de columna
     * @param contenido Contenido a ingresar
     * @return True si lo hace, false en caso contrario
     */
    public boolean asignarCelda(int fila, int columna, Object contenido);

    /**
     * Obtiene el numero de filas
     * @return Numero de filas
     */
    public int getFilas();

    /**
     * Obtiene el numero de columnas
     * @return Numero de columnas
     */
    public int getColumnas();

    /**
     * Imprime renglon por renglon la matriz
     */
    public void imprimirR();

    /**
     * Imprime columna por columna la matriz
     */
    public void imprimirC();

    /**
     * Le aplica la transpuesta a la matriz2D
     */
    public void transpuesta();

    /**
     * Rellena la tabla con el contenido indicado
     * @param contenido Contenido que tendra toda la tabla
     */
    public void rellenar(Object contenido);

    /**
     * Generar y regresar una copia de la matriz
     * @return La copia de la matriz
     */
    public Tabla2D clonar();

    /**
     * Compara los elementos de las matrices
     * @param matriz2 La matriz que se comparara con la matriz actual
     * @return true si son indenticas y false en caso contrario
     */
    public boolean esIgual(Tabla2D matriz2);

    /**
     * Genera un vector en forma de columnas con los datos espesificados
     * @param numFilas Longitud del vector
     * @param contenido Dato que se ingresara al vector
     * @return true si el vector fue creado, false en caso contrario
     */
    public boolean vectorColumna(int numFilas, Object contenido);

    /**
     * Genera un vector en forma de renglones con los datos espesificados
     * @param numColumnas Longitud del vector
     * @param contenido Dato que se ingresara al vector
     * @return true si el vector fue creado, false en caso contrario
     */
    public boolean vectorRenglon(int numColumnas,Object contenido);

    /**
     * Crea/redimensiona/substituye la matriz actual por una pasada como argumento
     * @param tabla2 Matriz por la que se va a cambiar la actual
     * @return true si lo cambio, false en caso contrario
     */
    public boolean redefinirTabla(Tabla2D tabla2);

    /**
     * Agrega el arreglo como renglon a la matriz
     * @param arreglo renglon que se va agregar
     * @return true si se agrego, false en caso contrario
     */
    public boolean agregarFila(ArregloDatos arreglo);

    /**
     * Agrega un arreglo como columna a la matriz
     * @param arreglo Renglon que se va agregar
     * @return true si se agrego, false en caso contrario
     */
    public boolean agregarColumna(ArregloDatos arreglo);

    /**
     * Agrega una matriz a la derecha de la matriz actual
     * @param tabla2 Matriz que se va agregar
     * @return true si se agrego, false en caso contrario
     */
    public boolean agregarTablaxColumna(Tabla2D tabla2);

    /**
     * Agrega una matriz abajo de la matriz actual
     * @param tabla2 Matriz que se va agregar
     * @return true si se agrego, false en caso contrario
     */
    public boolean agregarTablaxRenglon(Tabla2D tabla2);

    /**
     * Hace una matriz 3D a partir de la matriz 2D actual
     * @param tablas Es un arreglo que contiene matrices 2D
     * @return La matriz 3D
     */
    public Tabla3D tabla2DaTabla3D(ArregloDatos tablas);

    /**
     * Agrega los elementos de la matriz a un vector de una sola columna
     * @return Regresa el vector matriz2D
     */
    public Tabla2D aVectorColumna();

    /**
     * Agrega los elementos de una matriz a un vector de un solo renglon
     * @return Regresa el vector matriz2D
     */
    public Tabla2D aVectorRenglon();

    /**
     * Elimina una columna de la matriz, dependiendo de tipoCol(izquierda/derecha)
     * @param tipoCol Es un enumerado para columna izquierda o derecha
     * @return true si se elimino, false en caso contrario
     */
    public boolean quitarColumna(TipoColumna tipoCol);

    /**
     * Elimina un renglon de la matriz, dependiendo de tipoReng (superior/inferior)
     * @param tipoReng Define el renglon que se va a eliminar (superior/inferior)
     * @return true si lo elimina, false en caso contrario
     */
    public boolean quitarFila(TipoRenglon tipoReng);

    /**
     *Elimina un renglon de la matriz
     * @param indice El indice del renglon a eliminar
     * @return true en caso de que se haya eliminado, flase en caso contario
     */
    public boolean quitarFila(int indice);

    /**
     * Elimina una columna de la matriz
     * @param indice El indice de la columna a eliminar
     * @return true en caso de que haya eliminado, false en caso contrario
     */
    public boolean quitarColumna(int indice);
}

