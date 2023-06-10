package herramientas.comunes;

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
}
