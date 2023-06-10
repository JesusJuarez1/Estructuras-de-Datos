package audio;

import java.io.*;

import audio.wavfile.*;
import estructuraslineales.ArregloNumeros;

public class AudioFileRecord {
    private long numFrames;  //numero de tramas, número de muestras totales del archivo por canal
    private long sampleRate; //numero de muestras por segundo a la que se discretiza la señal
    private int numChannels; //número de canales
    private double[] buffer; //audio original
    private double[] buffer2; //audio modificado
    private String archivo;   //nombre de archivo dado por el usuario
    private WavFile wavFileR; //apuntador de archivo leido
    private WavFile wavFileW;  //apuntador de archivo a escribir
    private String nomArchivo; //nombre archivo (uno.wav)
    private String nomRuta;    //ruta donde esta guardado el archivo (/home)
    private int validBits;     //bits usados para la discretización
    private ArregloNumeros buffer3;

    public AudioFileRecord(String archivo) {
        this.archivo = archivo;
        // Abre el archivo wav y asigna parámetros a las variables
        try {
            File file = new File(archivo);
            wavFileR = WavFile.openWavFile(file);
            nomArchivo = file.getName();
            nomRuta = file.getParent();
        } catch (Exception e) {

        }
        numChannels = wavFileR.getNumChannels();
        numFrames = wavFileR.getNumFrames();
        sampleRate = wavFileR.getSampleRate();
        validBits=wavFileR.getValidBits();
    }

    public void leerAudio() {
        try {

            // Muestra datos del archivo
            wavFileR.display();

            // Crea buffer de origen y de temporal
            buffer = new double[(int) numFrames * numChannels];
            buffer2 = new double[buffer.length];
            buffer3 = new ArregloNumeros(buffer.length);

            //tramas leidas
            int framesRead;

            // Lee tramas totales
            framesRead = wavFileR.readFrames(buffer, (int) numFrames);

            // Recorrer todas las tramas del archivo y guardarlas en el arreglo.
            for (int s = 0; s < framesRead * numChannels; s++) {
                buffer2[s] = buffer[s];
            }
            buffer3.ingresarAudio(buffer2);

            // Cierra archivo
            wavFileR.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void EscribirAudio(String nombre) {
        try {

            //Crear el apuntador al archivo para guardar datos del temporal
            File file = new File(nomRuta+"/" + nombre);

            // Creamos un nuevo archivo de audio con los mismos datos que el original
            wavFileW = WavFile.newWavFile(file, numChannels, numFrames, validBits, sampleRate);

            // Escribimos los frames o muestras totales del temporal
            wavFileW.writeFrames(buffer3.leerArreglo(), (int) numFrames);

            // Cerramos el archivo
            wavFileW.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Le aplica un filtro de altas frecuencias al audio original
     */
    public void preEnfasis(){
        for(int posicion=1;posicion<buffer3.cantidadElementos();posicion++){
            buffer3.cambiar(posicion,(double)buffer3.obtener(posicion)+(0.95*(double)buffer3.obtener(posicion-1)));
        }
    }

    /**
     * Aumneta el volumen del audio
     * @param intensidad Cantidad de volumen a aumentar
     */
    public void subirVolumen(int intensidad){
        for(int posicion=0;posicion<buffer3.cantidadElementos();posicion++){
            buffer3.cambiar(posicion,((double)buffer3.obtener(posicion))*intensidad);
        }
    }

    /**
     * Baja el volumen del audio
     * @param intensidad Cantidad de volumen a bajar
     */
    public void bajarVolumen(int intensidad){
        for(int posicion=0;posicion<buffer3.cantidadElementos();posicion++){
            buffer3.cambiar(posicion,((double)buffer3.obtener(posicion))/intensidad);
        }
    }

    /**
     * Acelera el audio a la velocidad indicada como parametro (se recomienda no sobrepasar 4)
     * @param velocidad Velocidad que tendra el audio
     */
    public void acelerar(int velocidad){
        ArregloNumeros tmp = new ArregloNumeros((Integer)buffer3.cantidadElementos()/velocidad);
        int posicion=0;
        while(posicion<buffer3.cantidadElementos()){
            double promedio = 0;
            for(int pos=1;pos<=velocidad;pos++){
                if(posicion <buffer3.cantidadElementos()){
                    promedio += (double)buffer3.obtener(posicion);
                }
                posicion++;
            }
            tmp.agregar(promedio/velocidad);
        }
        buffer3 = tmp;
    }

    /**
     * Realentiza el audio
     * @param decremento Velocidad que tendra el audio
     */
    public void relentizar(int decremento){
        ArregloNumeros tmp = new ArregloNumeros((Integer)buffer3.cantidadElementos()*decremento);
        for(int posicion=0;posicion<buffer3.cantidadElementos();posicion++){
            double promedio = 0;
            //tmp.agregar(buffer3.obtener(posicion));
            int pos = 1;
            while(pos <= decremento){
                if(pos+posicion < buffer3.cantidadElementos()){
                    tmp.agregar(((Double)buffer3.obtener(posicion)+(Double)buffer3.obtener(pos+posicion))/2);
                }
                pos++;
            }
        }
        buffer3 = tmp;
    }

    /**
     * Invierte el audio en el eje x
     */
    public void invertirEjeX(){
        buffer3.invertir();
    }
}
