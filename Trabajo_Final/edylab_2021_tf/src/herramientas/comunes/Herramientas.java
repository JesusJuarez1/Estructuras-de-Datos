package herramientas.comunes;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;

/**
 * Esta clase tendra varios tipos de herramientas
 * @author Jesus
 * @version 1.0
 */
public class Herramientas {

    /**
     * Este método compara dos objetos sean del tipo que sean.
     * @param objeto1 Es el operando 1 a comparar.
     * @param objeto2 Es el operando 2 a comparar.
     * @return Regresa un valor positivo si el objeto 1 es mayor que el objeto 2, un valor negativo
     * si el objeto 1 es menor que el objeto 2, y regesa 0 en caso que sean iguales.
     */
    public static int compararObjetos(Object objeto1, Object objeto2){
        if(objeto1 instanceof Number && objeto2 instanceof Number){ //son números
            Double numero1=Double.parseDouble(objeto1.toString());
            //Number numero1Number=(Number)objeto1;
            //double numero1=numero1Number.doubleValue();
            Double numero2=Double.parseDouble(objeto2.toString());

            if(numero1.doubleValue()>numero2.doubleValue()){ //obj1>obj2
                return 1;
            }else if(numero1.doubleValue()<numero2.doubleValue()){ //obj1<obj2
                return -1;
            }else{ //ibj1=obj2
                return 0;
            }
        }else{ // cuando no sean números, es decir, Personas, Muebles, Cadenas, en otros.
            //me voy a apoyar en el método toString()
            return objeto1.toString().compareToIgnoreCase(objeto2.toString());
        }
    }

    /**
     * Obtiene un numero aleatorio entre el numero1 y numero2
     * @param numero1 Determina el rango
     * @param numero2 Determina el rango
     * @return El numero entero que obtuvo
     */
    public static int numeroAleaotorio(int numero1, int numero2){
        return (int)(Math.random()*(numero2-numero1)+numero1);
    }

    /**
     * Obtiene una elemento del arreglo de datos aleatoriamente dada una probabilidad
     * @param datos Arreglo de datos
     * @param probabilidades Arreglo paralelo al de datos el cual contiene las probabilidades de cada elemento,
     *                       las probabilidades deben ser menores a 1 y sumadaas deben dar 1 para que funcione
     * @return El dato resultante dada la probabilidad
     */
    public static Object obtenerAleatorioProbabildad(ArregloDatos datos, ArregloDatos probabilidades){
        double random = Math.random();//Obtenemos un numero random de 0 a 1
        ArregloDatos tmp = (ArregloDatos)probabilidades.clonar();// Clonamos el arreglo de probabilidades para ordenanrlo
        Ordenamiento.quickSort(tmp);//Se ordena el arreglo
        Double probabilidadAcomulada = 0.0; //Se inicia la probabilidad acomulada
        for(int prob=0;prob<tmp.capacidad();prob++){//Se recorre tmp
            probabilidadAcomulada += (Double)tmp.obtener(prob);//Se obtiene cada probabilidad
            //Se verifica que el numero random sea menor o igual a la probabilidad acomulada
            if(random < probabilidadAcomulada){
                //Se obtiene la posicin de la probabilidad resultante en el arreglo original
                //para extrar el dato del arreglo de datos
                return datos.obtener((Integer)probabilidades.buscar((Double)tmp.obtener(prob)));
            }
        }
        return null;
    }
}
