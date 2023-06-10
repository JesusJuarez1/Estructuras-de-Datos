package registros.ejido;

import estructuraslineales.ArregloDatos;

/**
 * Esta es una interface que contiene los metodos de la clase Campesino
 * @author Jesus
 * @version 1.0
 */
public interface ICampesino {
    /**
     * Obtiene el nombre del campesino
     * @return el nombre del campesino
     */
    public String getNombre();

    /**
     * Cambia el nombre del campesino
     * @param nombre Nuevo nombre que tenra el campesino
     */
    public void setNombre(String nombre);

    /**
     * Obtiene el arreglo que contiene los a�os
     * @return el arreglo de a�os
     */
    public ArregloDatos getAnios();

    /**
     * Cambia el arreglo de a�os
     * @param anios nuevo arreglo de a�os
     */
    public void setAnios(ArregloDatos anios);

    /**
     * Agrega un a�o al arreglo a�os
     * @return true si lo hace, false en caso contrario
     */
    public boolean agregarAnio();

    /**
     * Obtiene el promedio de las cosechas en general del campesino
     * @param nombreCosecha nombre de la cosecha a obtener su promedio
     * @return El promedio de las toneladas de la cosecha elegida, null en caso contrario
     */
    public Double promedioCosecha(String nombreCosecha);

    /**
     * Obtiene el total de toneladas producidas de un solo producto
     * @param nomCosecha Nombre de la cosecha a evaluar
     * @return Total de toneladas producidas
     */
    public Double cantidadTonel(String nomCosecha);

    /**
     * Evalua si el promedio de toneladas de un producto son mayores a la cantidad indicada
     * @param cantidad Cantidad a superar
     * @return La cosecha que sobrepasa la cantidad, null en caso que ninguna logre hacerlo
     */
    public Cosecha produceMasQue(double cantidad);
}
