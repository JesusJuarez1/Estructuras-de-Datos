package pruebas;

import registros.imagen.Imagen;

import java.io.IOException;

public class PruebaImagen {
    public static void main(String[] args) throws IOException {

        Imagen img = new Imagen("imagen.jpg");
        img.escalaGrises();
        img.guardarImagen("Escala_grises");

        // Para modificar el brillo los valores tienen que ir de -255 a 255
        img.brillo(40);
        img.guardarImagen("Mas_brillo");
        img.brillo(-80);
        img.guardarImagen("Menos_brillo");

        //Invertir
        img = new Imagen("imagen.jpg");
        img.invertirH();
        img.guardarImagen("Invertir_H");

        img = new Imagen("imagen.jpg");
        img.invertirV();
        img.guardarImagen("Invertir_V");

        //Giros
        img = new Imagen("imagen.jpg");
        img.girar("90");
        img.guardarImagen("90");

        img = new Imagen("imagen.jpg");
        img.girar("180");
        img.guardarImagen("180");

        img = new Imagen("imagen.jpg");
        img.girar("270");
        img.guardarImagen("270");

        //Traspuesta
        img = new Imagen("imagen.jpg");
        img.aplicarTraspuesta();
        img.guardarImagen("Traspuesta");

        //img = new Imagen("imagen.jpg");
        //img.marco(Color.CYAN,50);
        //img.guardarImagen("Marco_cyan");
    }
}
