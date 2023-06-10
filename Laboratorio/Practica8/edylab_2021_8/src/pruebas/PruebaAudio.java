package pruebas;

import audio.AudioFileRecord;
import entradasalida.SalidaTerminal;

public class PruebaAudio {
    public static void main(String[] args) {
        AudioFileRecord audio = new AudioFileRecord("src/audios/audio.wav");
        audio.leerAudio();
        audio.preEnfasis();
        audio.EscribirAudio("Enfasis.wav");

        AudioFileRecord audio2 = new AudioFileRecord("src/audios/audio.wav");
        audio2.leerAudio();
        audio2.subirVolumen(3);
        audio2.EscribirAudio("volumen+.wav");

        AudioFileRecord audio3 = new AudioFileRecord("src/audios/audio.wav");
        audio3.leerAudio();
        audio3.bajarVolumen(3);
        audio3.EscribirAudio("volumen-.wav");

        AudioFileRecord audio4 = new AudioFileRecord("src/audios/audio.wav");
        audio4.leerAudio();
        audio4.acelerar(2);
        audio4.EscribirAudio("x2.wav");

        AudioFileRecord audio5 = new AudioFileRecord("src/audios/audio.wav");
        audio5.leerAudio();
        audio5.acelerar(3);
        audio5.EscribirAudio("x3.wav");

        AudioFileRecord audio6 = new AudioFileRecord("src/audios/audio.wav");
        audio6.leerAudio();
        audio6.relentizar(2);
        audio6.EscribirAudio("x-2.wav");

        AudioFileRecord audio7 = new AudioFileRecord("src/audios/audio.wav");
        audio7.leerAudio();
        audio7.relentizar(3);
        audio7.EscribirAudio("x-3.wav");

        AudioFileRecord audio8 = new AudioFileRecord("src/audios/audio.wav");
        audio8.leerAudio();
        audio8.invertirEjeX();
        audio8.EscribirAudio("inversoEjeX.wav");


    }
}
