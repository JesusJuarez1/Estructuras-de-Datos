package registros.imagen;

/**
 * Clase que almacena los colores de un pixel
 * @author Jesus
 * @version 1.0
 */
public class Pixel {
    protected int rojo;
    protected int verde;
    protected int azul;
    protected int alfa;

    public Pixel(int rojo, int verde, int azul, int alfa) {
        this.rojo = rojo;
        this.verde = verde;
        this.azul = azul;
        this.alfa = alfa;
    }

    /**
     * Obtiene el valor del color rojo del pixel
     * @return El valor del color rojo
     */
    public int getRojo() {
        return rojo;
    }

    /**
     * Obtiene el valor del color verde del pixel
     * @return El valor del color verde
     */
    public int getVerde() {
        return verde;
    }

    /**
     * Obtiene el valor del color azul del pixel
     * @return El valor del color azul
     */
    public int getAzul() {
        return azul;
    }

    /**
     * Obtiene el valor del color alfa del pixel
     * @return El valor del color alfa
     */
    public int getAlfa() {
        return alfa;
    }
}
