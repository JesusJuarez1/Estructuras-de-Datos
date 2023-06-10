package utilerias.comunes;

/**
 * Esta clase tendra varios tipos de herramientas
 * @author Jesus
 * @version 1.0
 */
public class Herramientas {

    /**
     * Compara objetos, dependiendo si son numeros o algun otro tipo de objetos
     * @param objeto1 objeto a comparar
     * @param objeto2 objeto a comparar
     * @return 1 si el objeto1 es mayor a objeto2, -1 si objeto2 es mayor y 0 si son iguales
     */
    public static int compararObjetos(Object objeto1, Object objeto2){
        if(objeto1 instanceof Number && objeto2 instanceof Number){
            Double numero1=Double.parseDouble(objeto1.toString());
            Double numero2=Double.parseDouble(objeto2.toString());
            if(numero1.doubleValue()>numero2.doubleValue()){
                return 1;
            }else if(numero1.doubleValue()<numero2.doubleValue()){
                return -1;
            }else{
                return 0;
            }
        }else{
            return objeto1.toString().compareToIgnoreCase(objeto2.toString());
        }
    }
}
