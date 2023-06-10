package registros.ejido;

import estructuraslineales.ArregloDatos;

/**
 * Interface que contiene los metodos de la clase Ejido
 * @author Jesus
 * @version 1.0
 */
public interface IEjido {

    /**
     * Agrega un campesino al arreglo campesinos
     * @param campesino Campesino para agregar
     * @return true si lo agrego, false en caso contrario
     */
    public boolean agregarCampesino(Campesino campesino);

    /**
     * Obtiene el promedio de las cosechas de un campesino en particular
     * @param nombreCampesino Nombre del campesino a obtener los datos de sus cosechas
     * @param cosecha Nombre de la cosecha a sacar su promedio
     * @return El promedio de la cosecha elegida, null en caso que no lo haga
     */
    public Double promedioCosechaCampesino(String nombreCampesino,String cosecha);

    /**
     * Obtiene el campesino que obtuvo la menor cantidad de cosecha indicada en el año indicado
     * @param nombreCos Nombre de la cosecha a evaluar
     * @param year año a evaluar
     * @return El campesino que obtuvo la cosecha menor
     */
    public Campesino menosCosecha(String nombreCos,int year);

    /**
     * Indica el campesino que mas le favorecio las siembras en un año en particular
     * @param year Año a evaluar
     * @return Regresa el campesino
     */
    public Campesino favorecido(int year);

    /**
     * Evalua que cosecha convino mas a partir del año
     * @param year año a evaluar
     * @return La cosecha que mas convino, null en caso contrario
     */
    public Cosecha cosechaMasConvinoAnio(int year);

    /**
     * Obtiene el año en el que se produjo mas producto de sierto tipo, de un campesino en particular
     * @param nomCampesino nombre del campesino
     * @param producto producto a evaluar
     * @return El año
     */
    public Anio anioMejorProdujo(String nomCampesino,String producto);

    /**
     * Obtiene la persona que menos ha cosechado en el ultimo año
     * @return El campesino
     */
    public Campesino menosCosechaActual();

    /**
     * Recibe como argumento un arreglo con el cual obtendra los campesinos que se desean saber la suma de un producto
     * @param campes ArregloDato donde veienen los campesinos a evaluar
     * @param producto nombre del producto a evaluar
     * @return la cantidad resultante de todas las toneladas de los campesinos
     */
    public Double cantidadTonelCampesinos(ArregloDatos campes, String producto);

    /**
     * Obtiene el campesino que produce menos de la cantidad indicada de toneladas de productos en general
     * @param cantidad Cantidad para evaluar las toneladas
     * @return El campesino que esta por debajo de la cantidad indicada, null en caso que no halla campesino por debajo
     */
    public Campesino produceMenosQue(double cantidad);

    /**
     * Manda llamar el metodo produceMasQue de cada campesino
     * @param cantidad Cantidad a superar
     * @return La cosecha que sobrepasa la cantidad, null en caso que ninguna logre hacerlo
     */
    public Cosecha produceMasQue(double cantidad);
}
