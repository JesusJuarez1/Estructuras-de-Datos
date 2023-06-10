package registros.diccionario;

/**
 * Clase que contiene todas las operaciones de Diccionario
 */
public interface IDiccionario {
    /**
     * Agrega una palabra al arreglo diccionario
     * @return True si lo agrego, false en caso contrario
     * @param nombre nombre de la palabra
     * @param definicion definicion de la palabra
     * @param tipo tipo de palabra
     */
    public boolean agregarPalabra(String nombre,String definicion,TipoPalabra tipo);

    /**
     * Imprime en pantalla todas las palabras agregadas
     */
    public void imprimirDiccionario();

    /**
     * Busca en la definicion de cada palabra si existe un texto pedido en el mismo metodo y si es asi la imprime
     */
    public void buscarPalabrasConDefinicion();

    /**
     * Busca palabras con el mismo tipo
     * @param opcionTipo Tipo de palabras a buscar
     */
    public void buscarTipo(TipoPalabra opcionTipo);

    /**
     * Busca una palabra que comienze con el texto ingresado
     * @param info texto a comparar con cada palabra
     */
    public void buscarCoincidencias(String info);

    /**
     * Pide la palabra a buscar, si la encuentra la imprime, si no no hace nada
     */
    public void buscarPalabra();

    /**
     * Permite escoger una opcion de las que se muestran
     * @return La opcion escogida
     */
    public TipoPalabra escogerTipoPalabra();
}
