package registros.diccionario;

/**
 * Enumerado que contiene el menu principal del diccionario
 * @author Jesus
 * @version 1.0
 */
public enum MenuDiccionario {
    AGREGAR("Agregar Palabra",1),
    CONSULTAR("Consultar Palabra",2),
    LISTARPC("Listar palabras que contengan en su definicion el texto ingresado",3),
    LISTAR("Listar Coincidencias",4),
    LISTARTIPO("Listar por tipo de Palabra",5),
    SALIR("Salir",6);

    private String nombre;
    private int indice;
    private MenuDiccionario(String nombre, int indice){
        this.nombre = nombre;
        this.indice = indice;
    }

    /**
     * Obtiene el nombre de la opcion
     * @return El nombre de la opcoion
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Obtiene el indice de la opcion
     * @return El indice de la opcion
     */
    public int getIndice() {
        return indice;
    }
}
