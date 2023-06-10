package pruebas;

import entradasalida.SalidaTerminal;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ListaEncadenadaDoble;
import herramientas.matematicas.Estadistica;

public class PruebaEstadistica {
    public static void main(String[] args) {
        SalidaTerminal.consola("Coeficiente r de Pearson: \n");
        ListaEncadenadaDoble x = new ListaEncadenadaDoble();
        x.agregarLista(ArchivoTexto.leer("x.txt"));
        ListaEncadenadaDoble y = new ListaEncadenadaDoble();
        y.agregarLista(ArchivoTexto.leer("y.txt"));
        Estadistica.coeficienteRPearson(x,y);

        SalidaTerminal.consola("\n\n");
        SalidaTerminal.consola("Coeficiente de correlacion: \n");
        SalidaTerminal.consola("Muestra: "+Estadistica.coeficienteCorrelacionMuestral(x,y)+"\n");
        SalidaTerminal.consola("Poblacion: "+Estadistica.coeficienteCorrelacionPoblacional(x,y)+"\n");
        SalidaTerminal.consola("Graficas: \n");
        Estadistica.graficarXY(x,y);
    }
}
