package registros.ejido;

public interface ICosecha {
    /**
     * Obtiene el nombre de la cosecha
     * @return el nombre de la cosecha
     */
    public String getNombre();

    /**
     * Cambia el nombre de la cosecha
     * @param nombre nuevo nombre que tendra la cosecha
     */
    public void setNombre(String nombre);

    /**
     * Obtiene las toneladas de la cosecha
     * @return las toneladas de la cosecha
     */
    public double getToneladas();

    /**
     * Cambia las toneladas de la cosecha
     * @param toneladas nuevo valor que tendra las toneladas de cosecha
     */
    public void setToneladas(double toneladas);
}
