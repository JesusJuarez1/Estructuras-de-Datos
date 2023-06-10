package herramientas.matematicas;

import entradasalida.Grafica;
import entradasalida.SalidaTerminal;
import estructuraslineales.ListaEncadenadaDoble;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Estadistica {

    /**
     * Saca el coeficiente r de pearson
     * @param x Lista de las x
     * @param y Lista de las y
     * @return El resultado de la operacion
     */
    public static Double coeficienteRPearson(ListaEncadenadaDoble x, ListaEncadenadaDoble y){
        if(y.vacia() || x.vacia()){
            return null;
        }
        x.inicializarIterador();
        y.inicializarIterador();
        int n = 0;
        while(x.hayElementos() && y.hayElementos()){
            n++;
            x.obtenerElemento();
            y.obtenerElemento();
        }
        double sumatoriaX = sumatoria(x);
        double sumatoriaY = sumatoria(y);

        double operacion = (n*sumatoriaXY(x,y)-sumatoriaX*sumatoriaY)/
                (Math.sqrt((n*sumatoriaPotencia(x,2)-Math.pow(sumatoriaX,2))*
                        (n*sumatoriaPotencia(y,2)-Math.pow(sumatoriaY,2))));

        if(operacion == 0.0){
            SalidaTerminal.consola("Ninguna correlacion, r = "+operacion);
        }else if(operacion == 1){
            SalidaTerminal.consola("Correlacion positiva perfecta, r = "+operacion);
        }else if(0<operacion && operacion<1){
            SalidaTerminal.consola("Correlacion positiva, r = "+operacion);
        }else if(operacion == -1){
            SalidaTerminal.consola("Correlacion negatica perfecta, r = "+operacion);
        }else if(-1 < operacion && operacion < 0){
            SalidaTerminal.consola("Correlacion negativa, r = "+operacion);
        }else{
            SalidaTerminal.consola("Operacion fallida");
        }
        return operacion;
    }

    /**
     * Hace la sumatoria de la lista encadenada doble
     * @param lista lista la cual contiene los datos a sumar
     * @return El resultado de la sumatoria
     */
    public static Double sumatoria(ListaEncadenadaDoble lista){
        if(!lista.vacia()){
            double sumatoria = 0.0d;
            lista.inicializarIterador();
            while(lista.hayElementos()){
                sumatoria += Double.parseDouble(lista.obtenerElemento()+"");
            }
            return sumatoria;
        }else {
            return null;
        }
    }

    /**
     * Hace una sumatoria multiplicando los datos de la lista x por los datos de la lista y
     * @param x Lista encadenada doble de las X
     * @param y Lista encadenada doble de las Y
     * @return El resultado de la sumatoria
     */
    public static double sumatoriaXY(ListaEncadenadaDoble x, ListaEncadenadaDoble y){
        double sumatoria = 0.0d;
        if(!x.vacia() && !y.vacia()){
            x.inicializarIterador();
            y.inicializarIterador();
            while(x.hayElementos() && y.hayElementos()){
                sumatoria += (Double.parseDouble(x.obtenerElemento()+"")*
                        Double.parseDouble(y.obtenerElemento()+""));
            }
        }
        return sumatoria;
    }

    /**
     * Hace una sumatoria donde eleva cada elemento de la lista y luego lo suma con lo demas
     * @param lista Lista que contiene los datos para la sumatoria
     * @param potencia potencia a la que se eleva los datos
     * @return El resultado de la sumatoria
     */
    public static double sumatoriaPotencia(ListaEncadenadaDoble lista, int potencia){
        double sumatoria = 0.0d;
        if(!lista.vacia()){
            lista.inicializarIterador();
            while(lista.hayElementos()){
                sumatoria += Math.pow(Double.parseDouble(lista.obtenerElemento()+""),potencia);
            }
        }
        return sumatoria;
    }

    /**
     * Saca el coeficiente muestral con la formula de pearson
     * @param x lista de las X
     * @param y lista de las Y
     * @return El resultado de la operacion, null en caso contrario
     */
    public static Double coeficienteCorrelacionPoblacional(ListaEncadenadaDoble x, ListaEncadenadaDoble y){
        double operacion = 0.0d;
        if(!x.vacia() && !y.vacia()){
            operacion = covarianza(x,y)/((desviasionEstandar(x))*(desviasionEstandar(y)));
        }else{
            return null;
        }
        return operacion;
    }

    /**
     * Calcula el coeficinete de pearson poblacional
     * @return El resultado de la operacion, null en caso de error
     * @param x Datos de x
     * @param y Dtos de y
     */
    public static Double coeficienteCorrelacionMuestral(ListaEncadenadaDoble x, ListaEncadenadaDoble y){
        double operacion = 0.0d;
        if(!x.vacia() && !y.vacia()){
            double mediaX = media(x);
            double mediaY = media(y);
            operacion = (sumatoria(x,mediaX,y,mediaY))/((sumatoria(x,mediaX,y,mediaY,2)));
        }else{
            return null;
        }
        return operacion;
    }

    /**
     * Hace una sumatoria restando la mediaX a cada elemento de la lista X y multiplicandolo
     * por la resta de la mediaY a cada elemento de la lista Y
     * @param x Lista de X
     * @param mediaX Media de X
     * @param y Lista de Y
     * @param mediaY media de Y
     * @return La sumatoria resultante, null en caso contrario
     */
    public static Double sumatoria(ListaEncadenadaDoble x,double mediaX, ListaEncadenadaDoble y,double mediaY){
        if(!x.vacia() && !y.vacia()){
            double sumatoria = 0.0d;
            x.inicializarIterador();
            y.inicializarIterador();
            while(x.hayElementos() && y.hayElementos()){
                sumatoria += (Double.parseDouble(x.obtenerElemento()+"")-mediaX)*
                        (Double.parseDouble(y.obtenerElemento()+"")-mediaY);
            }
            return sumatoria;
        }else {
            return null;
        }
    }

    /**
     * Hace una sumatoria restando la mediaX a cada elemento de la lista X y elevandolo a la potencia indicada, luego
     * multiplicandolo por la resta de la mediaY a cada elemento de la lista Y y elevandolo a la potencia indicada
     * @param x Lista de X
     * @param mediaX Media de X
     * @param y Lista de Y
     * @param mediaY media de Y
     * @param potencia Potencia a la que se va elevar
     * @return La sumatoria resultante, null en caso contrario
     */
    public static Double sumatoria(ListaEncadenadaDoble x,double mediaX,ListaEncadenadaDoble y,double mediaY,int potencia){
        if(!x.vacia() && !y.vacia()){
            double sumatoria = 0.0d;
            x.inicializarIterador();
            y.inicializarIterador();
            while(x.hayElementos() && y.hayElementos()){
                sumatoria += Math.sqrt(Math.pow(Double.parseDouble(x.obtenerElemento()+"")-mediaX,2)*
                        Math.pow(Double.parseDouble(y.obtenerElemento()+"")-mediaY,2));
            }
            return sumatoria;
        }else {
            return null;
        }
    }

    /**
     * Calcula la media de una lista
     * @param datos lista a la cual se va a sacar la media
     * @return El resultado de la media
     */
    public static double media(ListaEncadenadaDoble datos){
        double media = 0.0d;
        if(!datos.vacia()){
            datos.inicializarIterador();
            int cont = 0;
            while(datos.hayElementos()){
                media += Double.parseDouble(datos.obtenerElemento()+"");
                cont++;
            }
            media /= cont;
        }
        return media;
    }

    /**
     * Calcula la covarianza muestral de dos listas
     * @param x lista de las x
     * @param y lista de las y
     * @return el resultado de la operacion
     */
    public static double covarianza(ListaEncadenadaDoble x, ListaEncadenadaDoble y){
        double resultado = 0.0d;
        if(!x.vacia() && !y.vacia()){
            double mediaX = media(x);
            double mediaY = media(y);
            x.inicializarIterador();
            y.inicializarIterador();
            int cont = 0;
            while(x.hayElementos() && y.hayElementos()){
                resultado += ((Double.parseDouble(x.obtenerElemento()+""))-mediaX)*
                        ((Double.parseDouble(y.obtenerElemento()+""))-mediaY);
                cont++;
            }
            resultado /= (cont-1);
        }
        return resultado;
    }

    /**
     * Calcula la desviacion estandar de una lista
     * @param datos lista que contiene los datos
     * @return El resultado de la operacion
     */
    public static Double desviasionEstandar(ListaEncadenadaDoble datos){
        double resultado = 0.0d;
        if(!datos.vacia()){
            double media = media(datos);
            datos.inicializarIterador();
            int cont = 0;
            while(datos.hayElementos()){
                resultado += Math.pow((Double.parseDouble(datos.obtenerElemento()+"")-media),2);
                cont++;
            }
            resultado /= cont;
            resultado = Math.sqrt(resultado);
        }else{
            return null;
        }
        return resultado;
    }

    /**
     * Introduce los datos y crea una grafica
     * @param x datos de x
     * @param y datos de y
     */
    public static void graficarXY(ListaEncadenadaDoble x, ListaEncadenadaDoble y){
        JFreeChart grafica;
        if(!x.vacia() && !y.vacia()){
            XYSeriesCollection datos = new XYSeriesCollection();
            x.inicializarIterador();
            y.inicializarIterador();
            XYSeries s = new XYSeries("Habitaciones-precio");
            while(x.hayElementos() && y.hayElementos()){
                s.add(Double.parseDouble(x.obtenerElemento()+""),Double.parseDouble(y.obtenerElemento()+""));
            }
            datos.addSeries(s);
            grafica = ChartFactory.createScatterPlot("Grafica:",
                    "No. De habitaciones","Costo de casas en miles de dólares",datos);
            Grafica g = new Grafica(new ChartPanel(grafica));
        }
    }
}
