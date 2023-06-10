package controlador;

import java.io.*;
public class EntradaConsola {
    public static String consolaCadena() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(isr);
        String cadenaEntrada="";
        try {
            cadenaEntrada = buffer.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            return cadenaEntrada;
        }
    }

    public static Integer consolaInteger() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(isr);
        int cadenaEntrada=0;
        try {
            cadenaEntrada = Integer.parseInt(buffer.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            return cadenaEntrada;
        }
    }
}
