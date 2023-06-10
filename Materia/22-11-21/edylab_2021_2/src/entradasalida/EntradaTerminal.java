package entradasalida;

import java.io.*;
public class EntradaTerminal {
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
    public static Double consolaDouble() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(isr);
        double cadenaEntrada=0;
        try {
            cadenaEntrada = Double.parseDouble(buffer.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            return cadenaEntrada;
        }
    }
}
