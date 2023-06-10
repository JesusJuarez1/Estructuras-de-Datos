package pruebas;

import estructuraslineales.ArregloDatos;
import herramientas.clasificadores.KNN;

public class PruebaKNN {
    public static void main(String[] args) {
        ArregloDatos nuevo = new ArregloDatos(2);
        nuevo.agregar(1.58);
        nuevo.agregar(60.0);
        KNN.knn(nuevo);

        ArregloDatos nuevo2 = new ArregloDatos(2);
        nuevo2.agregar(1.72);
        nuevo2.agregar(70.0);
        KNN.knn(nuevo2);

        ArregloDatos nuevo3 = new ArregloDatos(2);
        nuevo3.agregar(1.90);
        nuevo3.agregar(81.0);
        KNN.knn(nuevo3);

        ArregloDatos nuevo4 = new ArregloDatos(2);
        nuevo4.agregar(1.60);
        nuevo4.agregar(60.0);
        KNN.knn(nuevo4);


        ArregloDatos nuevo5 = new ArregloDatos(2);
        nuevo5.agregar(1.70);
        nuevo5.agregar(75.0);
        KNN.knn(nuevo5);
    }
}
