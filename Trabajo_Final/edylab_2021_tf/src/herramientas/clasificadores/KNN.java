package herramientas.clasificadores;

import entradasalida.SalidaTerminal;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ArregloDatos;
import estructuraslineales.ListaEncadenada;
import herramientas.comunes.Ordenamiento;
import herramientas.texto.Separador;

/**
 * Clase que hace una clasificacion knn
 * @author Jesus
 * @version 1.0
 */
public class KNN {

    /**
     * Agrega un nuevo elemento al fichero obteniendo su clase que le corresponde de acuerdo a los demas elementos ya agregados
     * @param datos variables del nuevo elemento a agregar
     */
    public static void knn(ArregloDatos datos){
        if(!datos.vacia()){
            //Obtenemos el fichero de los datos ya clasificados
            ArregloDatos datosFichero = ArchivoTexto.leer("fichero.txt");
            //Arreglo que contendra las clases
            ArregloDatos clases = new ArregloDatos(datosFichero.cantidadElementos());
            //Arreglo que contendra las primeras variables de cada elemento
            ArregloDatos var1 = new ArregloDatos(datosFichero.cantidadElementos());
            //Arreglo que contendra las ponderaciones de las primeras variables
            ArregloDatos pond1 = new ArregloDatos(datosFichero.cantidadElementos());
            //Arreglo que contendra las seundas variables de cada elemento
            ArregloDatos var2 = new ArregloDatos(datosFichero.cantidadElementos());
            //Arreglo que contendra las ponderaciones de las segundas variables
            ArregloDatos pond2 = new ArregloDatos(datosFichero.cantidadElementos());

            //Se recorren las lineas del fichero
            for(int posicion=0;posicion<datosFichero.cantidadElementos();posicion++){
                //Se separan los elementos de cada linea del fichero
                ListaEncadenada elementos = Separador.separarCadena(datosFichero.obtener(posicion).toString(),";");
                //Se obtienen las clases u opciones
                clases.agregar(elementos.obtener(0));
                //Se obtiene las primeras variables de cada elemento
                var1.agregar(elementos.obtener(1));
                //Se obtienen las ponderaciones de las primeras variables
                pond1.agregar(Double.parseDouble(elementos.obtener(2).toString()));
                //Se obtienen las segundas variables de cada elemento
                var2.agregar(elementos.obtener(3));
                //Se obtienen las ponderaciones de las segundas variables
                pond2.agregar(Double.parseDouble(elementos.obtener(4).toString()));
            }
            //Se obtiene la ponderacion de la primera variable del nuevo elemento
            Double ponderacionVar1 = ((Double)datos.obtener(1))/(((Double)datos.obtener(0))*100);
            //Se obtiene la ponderacion de las segunda variable del nuevo elemento
            Double ponderacionVar2 = (((Double)datos.obtener(0))*100)/((Double)datos.obtener(1));

            //Se obtiene la clase que le correspoinde de acuerdo a las 3 opciones mas sercanas
            String clase = obtenerClase(clases,pond1,pond2,ponderacionVar1,ponderacionVar2);
            //Se imprimen los datos
            imprimirDatos(clases,clase);
            //Se hace un nuevo arreglo el cual se va a escribir
            ArregloDatos escribir = new ArregloDatos(datosFichero.cantidadElementos()+1);
            //Se ingresan los datos del fichero original
            for(int i=0;i<datosFichero.cantidadElementos();i++){
                escribir.agregar(datosFichero.obtener(i));
            }
            //Se le agrega el nuevo elemento
            escribir.agregar(clase+";"+datos.obtener(0)+";"+(ponderacionVar1+"").substring(0,4)+";"+
                    datos.obtener(1)+";"+(ponderacionVar2+"").substring(0,4));
            //Se escribe el fichero con el nuevo elemento y sus datos
            ArchivoTexto.escribir(escribir,"fichero.txt");
        }
    }

    /**
     * Obtiene la clase que le corresponde al nuevo elemento de acuerdo a las opciones mas cercanas
     * @param clases Arreglo de clases de todos los elementos
     * @param pond1 Arreglo de ponderaciones de las primeras variables de todos los elementos
     * @param pond2 Arreglo de ponderaciones de las segundas variables de todos los elementos
     * @param pondActual1 Ponderacion de la primera variable del nuevo elemento
     * @param pondActual2 Ponderacion2 de la segunda variable del nuevo elemento
     * @return Rgresa la clase que le corresponde
     */
    private static String obtenerClase(ArregloDatos clases,ArregloDatos pond1,ArregloDatos pond2,
                                       double pondActual1,double pondActual2){
        //Arreglo donde se agregaran los 3 k casos mas cercanos
        ArregloDatos k = new ArregloDatos(3);
        //Se obtiene la ponderacion
        Double acercamiento = pondActual2/pondActual1;
        //inicializamos la variable la cual ira aumentando hasta que se encuentren los 3 casos mas cercanos
        double aumento = 0.5;
        //Se hace un ciclo hasta que el arreglo k se llene
        while(!k.lleno()){
            //Se recorren las ponderaciones para obtener las ponderaciones que mas se le acerquen
            for(int posicion=0;posicion<clases.cantidadElementos();posicion++){
                //se obtiene la ponderacion de cada elememto
                Double seAcerca = ((Double)pond2.obtener(posicion))/((Double)pond1.obtener(posicion));
                //Se compara de acuerdo a la ponderacion del elemento a agregar
                if(((acercamiento+aumento)>seAcerca && (acercamiento-aumento)<seAcerca) ||
                        ((acercamiento-aumento)<seAcerca && (acercamiento+aumento)>seAcerca)){
                    //Si la posicion ya se encuentra, no volver a agregarla
                    if(k.buscar(posicion) == null){
                        //si no se encuentra se agrega
                        k.agregar(posicion);
                    }
                }
            }
            //Se aumenta 0.5, si no se ha llenado el arreglo k, para que siga buscando
            aumento=aumento+.5;
        }
        //Se obtiene la clase de la primara posicion agregada
        String clase1 = clases.obtener((int)k.obtener(0)).toString();
        //Se compara con la segunda
        if(clase1.equalsIgnoreCase(clases.obtener((int)k.obtener(1)).toString())){
            //Si son iguales significa mayoria, por lo cual es la clase que le corresponde al elemento nuevo
            return clase1;
        //Si no es igual a la segunda se compara con la tercera y ultima
        }else if(clase1.equalsIgnoreCase(clases.obtener((int)k.obtener(2)).toString())){
            //Si son iguales significa mayoria, por lo tantoes la clase que le corresponde
            return clase1;
        //Si la clase 1 no es igual a la clase 2 y 3 significa que la clase 2 y 3 son iguales
        }else{
            //Se regresa la clase 2 la cual es la que le corresponde
            return clases.obtener((int)k.obtener(0)).toString();
        }
    }

    /**
     * Imprime las opciones disponibles y la clase que le correspondio
     * @param clases Arreglo que contiene todas las clases de todos los elementos
     * @param clase Clase que le correspondio al nuevo elemento
     */
    private static void imprimirDatos(ArregloDatos clases,String clase){
        SalidaTerminal.consola("Opciones disponibles:\n");
        ListaEncadenada opciones = new ListaEncadenada();
        //Se obtienen las opciones disponibles
        for(int i=0;i<clases.cantidadElementos();i++){
            //Si la opcion ya esta agregada no se vuelve agregar
            if(opciones.buscar(clases.obtener(i)) == null){
                opciones.agregar(clases.obtener(i));
            }
        }
        opciones.inicializarIterador();
        //Se imprimen las opciones disponibles
        while(opciones.hayElementos()){
            SalidaTerminal.consola(opciones.obtenerElemento().toString()+"\n");
        }
        //Se imprime la clase que le correspondio al nuevo elemento
        SalidaTerminal.consola("Opcion correspondida: \n"+clase+"\n\n");
    }
}
