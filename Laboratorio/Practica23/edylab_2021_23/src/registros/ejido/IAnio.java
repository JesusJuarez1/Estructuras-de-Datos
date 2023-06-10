package registros.ejido;

import estructuraslineales.ArregloDatos;

/**
 * Esta es una interface que contiene los metodos de la clase Anio
 * @author Jesus
 * @version 1.0
 */
public interface IAnio {
    /**
     * Obtiene el año
     * @return el año
     */
    public int getAnio();

    /**
     * Cambia el valor de año
     * @param anio Nuevo valor que tendra anio
     */
    public void setAnio(int anio);

    /**
     * Obtiene las cosechas del año
     * @return El arreglo que contiene las cosechas
     */
    public ArregloDatos getCosechas();

    /**
     * Cambia las cosechas del año
     * @param cosechas Nuevo valor que tendra el arreglo cosechas
     */
    public void setCosechas(ArregloDatos cosechas);

    /**
     * Crea las cosechas solicitadas
     */
    public void agregarCosechas();

    /**
     * Agrega una cosecha al arreglo cosechas
     * @param cosecha La cosecha a agregar
     * @return true si lo hace, false en caso contrario
     */
    public boolean agregarCosecha(Cosecha cosecha);
}
