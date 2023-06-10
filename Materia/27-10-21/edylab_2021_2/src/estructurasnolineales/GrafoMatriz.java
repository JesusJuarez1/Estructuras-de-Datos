package estructurasnolineales;

import estructuraslineales.ArregloDatos;

public class GrafoMatriz {
    //Dónde guardar los vértices
    protected ArregloDatos vertices;
    //Dónde guardar las aristas
    protected Tabla2D aristas;

    public GrafoMatriz(int cantidadVertices){
        vertices=new ArregloDatos(cantidadVertices);
        aristas=new Tabla2D(cantidadVertices,cantidadVertices,0.0)
    }
}
