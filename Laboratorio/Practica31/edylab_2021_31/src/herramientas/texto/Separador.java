package herramientas.texto;
import estructuraslineales.ListaEncadenada;

/**
 * Clase que contiene metodos para separar cadenas
 * @author Jesus
 * @version 1.0
 */
public class Separador {

    /**
     * Separa la cadena con forme al separador espesificado
     * @param cadena Cadena a separar
     * @param separador Separador que limita las partes de la cadena
     * @return Una lista encadenada con los datos resultantes
     */
    public static ListaEncadenada separarCadena(String cadena, String separador){
        ListaEncadenada lista = new ListaEncadenada();
        String elem = "";
        for(int posicion=0;posicion<cadena.length();posicion++){
            char token = cadena.charAt(posicion);
            if(separador.equalsIgnoreCase(""+token)){
                lista.agregar(elem);
                elem = "";
            }else{
                elem += token;
            }
        }
        lista.agregar(elem);
        return lista;
    }
}
