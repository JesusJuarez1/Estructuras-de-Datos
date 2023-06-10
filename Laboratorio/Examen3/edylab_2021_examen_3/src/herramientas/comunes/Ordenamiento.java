package herramientas.comunes;

import estructuraslineales.ArregloDatos;

/**
 * Clase que contiene metods de ordenamiento
 * @author Jesus
 * @version 1.0
 */
public class Ordenamiento {

    /**
     * Llama al metodo quickSort para que ordene el arreglo
     * @param arreglo Arreglo a ordenar
     */
    public static void quickSort(ArregloDatos arreglo){
        //Se le pasa el arreglo, la primera posicion y la ultima
        quicksort(arreglo,0,arreglo.cantidadElementos()-1);
    }

    /**
     * Ordena los elementos del arreglo pasado como parametro
     * @param arreglo Arreglo a ordenar
     * @param izquierda Primera posicion de un elemento
     * @param derecha Ultima posicion de un elemento
     */
    private static void quicksort(ArregloDatos arreglo, int izquierda, int derecha) {
        Object pivote = arreglo.obtener(izquierda); // Tomamos el primer elemento como pivote
        int izquierdaDerecha = izquierda;           // izquierdaDerecha realiza la búsqueda de izquierda a derecha
        int derechaIzquierda = derecha;             // derechaIzquierda realiza la búsqueda de derecha a izquierda
        Object aux; //aux Es un auxiliar para intercambiar los elementos.

        while (izquierdaDerecha < derechaIzquierda) {// Mientras no se crucen las búsquedas
                                                     // Acomodara los elementos de acuerdo al pivote actual
            while (Herramientas.compararObjetos(arreglo.obtener(izquierdaDerecha), pivote) <= 0 && izquierdaDerecha < derechaIzquierda) {
                izquierdaDerecha++; // Buscamos el elemento mayor que el pivote
            }
            while (Herramientas.compararObjetos(arreglo.obtener(derechaIzquierda), pivote) > 0) {
                derechaIzquierda--;// Buscamos el elemento menor que el pivote
            }
            if (izquierdaDerecha < derechaIzquierda) {                        // Si no se han cruzado
                aux = arreglo.obtener(izquierdaDerecha);                      // se intercambian
                arreglo.cambiar(izquierdaDerecha, arreglo.obtener(derechaIzquierda));
                arreglo.cambiar(derechaIzquierda, aux);
            }
        }

        arreglo.cambiar(izquierda, arreglo.obtener(derechaIzquierda));// Se coloca el pivote en su lugar de forma que tendremos
        arreglo.cambiar(derechaIzquierda, pivote);// los menores a su izquierda y los mayores a su derecha

        if (izquierda < derechaIzquierda - 1) {
            quicksort(arreglo, izquierda, derechaIzquierda - 1);  // Ordenamos subarreglo izquierdo
        }
        if (derechaIzquierda + 1 < derecha){
            quicksort(arreglo, derechaIzquierda + 1, derecha);   // Ordenamos subarreglo derecho
        }
    }
}
