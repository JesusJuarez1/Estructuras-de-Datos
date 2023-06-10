package registros.imagen;


import estructurasnolineales.Tabla2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Clase que contiene los metodos para manipular una imagen
 * @author Jesus
 * @version 1.0
 */
public class Imagen{
    BufferedImage imagen;
    BufferedImage imagen2;
    Tabla2D datos;

    public Imagen(String img) throws IOException {
        imagen = ImageIO.read(new File("src/imagenes/"+img));
        int w = imagen.getWidth();
        int h = imagen.getHeight();
        datos = new Tabla2D(h,w);
        rellenarMatriz();
        imagen2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    }

    /**
     * Rellena la matriz con los datos de la imagen
     */
    private void rellenarMatriz(){
        for(int w=0;w<datos.getColumnas();w++){
            for(int h=0;h<datos.getFilas();h++){
                int pixel = imagen.getRGB(w,h);
                Color color = new Color(pixel);
                datos.asignarCelda(h,w,new Pixel(color.getRed(),color.getGreen(),color.getBlue(),color.getAlpha()));
            }
        }
    }

    /**
     * Introduce los datos de la tabla a la imagen vacia (imagen2)
     */
    private void grabarImagen(){
        for(int i=0;i<datos.getColumnas();i++){
            for(int h=0;h<datos.getFilas();h++){
                Pixel p = (Pixel) datos.obtenerCelda(h,i);
                Color c = new Color(p.getRojo(),p.getVerde(),p.getAzul(),p.getAlfa());
                imagen2.setRGB(i,h,c.getRGB());
            }
        }
    }

    /**
     * Guarda la imagen en el paquete imagenes, con el nombre pasado como parametro
     * @param nombre Nombre que tendra la imagen
     * @return True si guarda la imagen, false en caso contrario
     */
    public boolean guardarImagen(String nombre){
        grabarImagen();
        try {
            ImageIO.write(imagen2, "JPG", new File("src/imagenes/"+nombre+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Le aplica un filtro a la imagen
     */
    public void escalaGrises(){
        for( int w = 0; w < datos.getColumnas(); w++ ){
            for( int h = 0; h < datos.getFilas(); h++ ){
                Pixel p = (Pixel)datos.obtenerCelda(h,w);
                int promedio = (p.getRojo()+p.getVerde()+p.getAzul()+p.getAlfa())/4;
                datos.asignarCelda(h,w,new Pixel(promedio,promedio,promedio,promedio));
            }
        }
    }

    /**
     * Modifica el brillo, valores positivos aumenta el brillo, valores negativos lo disminuye
     * @param nivel Nivel de brillo a aumentar o decrementar
     */
    public void brillo(int nivel){
        for( int i = 0; i < imagen2.getWidth(); i++ ){
            for( int j = 0; j < imagen2.getHeight(); j++ ){
                Pixel p = (Pixel)datos.obtenerCelda(j,i);
                int r = p.getRojo()+nivel;
                int v = p.getVerde()+nivel;
                int a = p.getAzul()+nivel;
                int al = p.getAlfa()+nivel;
                if(r > 255){
                    r = 255;
                }else if(r<0){
                    r = 0;
                }
                if(v > 255){
                    v = 255;
                }else if(v<0){
                    v = 0;
                }
                if(a > 255){
                    a = 255;
                }else if(a<0){
                    a = 0;
                }
                if(al > 255){
                    al = 255;
                }else if(al<0){
                    al = 0;
                }
                datos.asignarCelda(j,i,new Pixel(r,v,a,al));
            }
        }
    }

    /**
     * Invierte la imagen horizontalmente
     */
    public void invertirH(){
        Tabla2D tmp = datos.clonar();
        for(int fila=0;fila< datos.getFilas();fila++){
            for(int col=datos.getColumnas()-1,colum=0;col>=0;col--,colum++){
                datos.asignarCelda(fila,colum,tmp.obtenerCelda(fila,col));
            }
        }
    }

    /**
     * Invierte la imagen verticalmente
     */
    public void invertirV(){
        Tabla2D tmp = datos.clonar();
        for(int fila=0,fil=datos.getFilas()-1;fil>=0;fila++,fil--){
            for(int colum=0;colum<datos.getColumnas();colum++){
                datos.asignarCelda(fil,colum,tmp.obtenerCelda(fila,colum));
            }
        }
    }

    /**
     * Gira la imagen 90, 180 o 270 grados, segun se indique con el argumento
     * @param giro Nivel de giro a establecer
     */
    public void girar(String giro){
        if(giro.equalsIgnoreCase("90")){
            imagen2 = new BufferedImage(imagen.getHeight(),imagen.getWidth(), BufferedImage.TYPE_INT_RGB);
            Tabla2D dat = new Tabla2D(imagen.getWidth(),imagen.getHeight());
            for(int fila=0;fila<datos.getFilas();fila++){
                for(int col=0;col<datos.getColumnas();col++){
                    dat.asignarCelda(col,fila,datos.obtenerCelda(fila,col));
                }
            }
            datos.redefinirTabla(dat);
        }else if(giro.equalsIgnoreCase("180")){
            invertirV();
        }else if(giro.equalsIgnoreCase("270")){
            imagen2 = new BufferedImage(imagen.getHeight(),imagen.getWidth(), BufferedImage.TYPE_INT_RGB);
            Tabla2D dat = new Tabla2D(imagen.getWidth(),imagen.getHeight());
            for(int fila=0;fila<datos.getFilas();fila++){
                for(int col=0;col<datos.getColumnas();col++){
                    dat.asignarCelda(col,fila,datos.obtenerCelda(fila,col));
                }
            }
            datos.redefinirTabla(dat);
            invertirH();
        }
    }

    /**
     * Aplica la traspuesta a la imagen
     */
    public void aplicarTraspuesta(){
        datos.transpuesta();
        imagen2 = new BufferedImage(imagen.getHeight(),imagen.getWidth(), BufferedImage.TYPE_INT_RGB);
    }

    /*public void marco(Color color,int grosor){
        Tabla2D tmp = new Tabla2D(datos.getFilas()+(grosor*2),datos.getColumnas()+(grosor*2));
        for(int fila=0,fil=0;fila<tmp.getFilas();fila++){
            for(int colum=0,col=0;colum<tmp.getColumnas();colum++){
                tmp.asignarCelda(fila,colum,new Pixel(11,45,89,23));
                if(fila < grosor || colum < grosor || fila >= datos.getFilas() || colum >= datos.getColumnas()){
                    for(int f=0;fila<grosor;fila++) {
                        for(int c=0;colum<grosor;colum++){
                            tmp.asignarCelda(fila, colum, new Pixel(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()));
                        }
                    }
                }else{
                    tmp.asignarCelda(fila,colum,datos.obtenerCelda(fil,col));
                    fil++;
                    col++;
                }
            }
        }
        imagen2 = new BufferedImage(tmp.getColumnas(),tmp.getFilas(), BufferedImage.TYPE_INT_RGB);
        datos.redefinirTabla(tmp);
    }*/
}
