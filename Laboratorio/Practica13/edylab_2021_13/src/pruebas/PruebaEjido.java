package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import registros.ejido.Campesino;
import registros.ejido.Ejido;

public class PruebaEjido {
    public static void main(String[] args) {

        Campesino campesino1 = new Campesino("Campesino1",2);
        Campesino campesino2 = new Campesino("Campesino2",2);
        Campesino campesino3 = new Campesino("Campesino3",2);
        Campesino campesino4 = new Campesino("Campesino4",2);
        Campesino campesino5 = new Campesino("Campesino5",2);
        Campesino campesino6 = new Campesino("Campesino6",2);
        Campesino campesino7 = new Campesino("Campesino7",2);
        Ejido ejido1 = new Ejido();
        ejido1.agregarCampesino(campesino1);
        ejido1.agregarCampesino(campesino2);
        ejido1.agregarCampesino(campesino3);
        ejido1.agregarCampesino(campesino4);
        ejido1.agregarCampesino(campesino5);
        ejido1.agregarCampesino(campesino6);
        ejido1.agregarCampesino(campesino7);

        SalidaTerminal.consola("A. El promedio de toneladas producidas por un campesino\nen particular de un producto en espec�fico.\n");
        SalidaTerminal.consola("Promedio: "+ejido1.promedioCosechaCampesino("Campesino3","Maiz")+"\n");

        SalidaTerminal.consola("B. El campesino produjo menos toneladas de frijol \nen un a�o en particular.9\n");
        SalidaTerminal.consola("Campesino: "+ejido1.menosCosecha("Frijol",2019).toString()+"\n");

        SalidaTerminal.consola("C. Indique cu�l campesino fue el m�s favorecido \nen sus siembras en un a�o en particular\n");
        SalidaTerminal.consola("Campesino favorecido: "+ejido1.favorecido(2020)+"\n");

        SalidaTerminal.consola("D. �Qu� producto convino m�s en la \nsiembra en un a�o en particular?\n");
        SalidaTerminal.consola("Cosecha: "+ ejido1.cosechaMasConvinoAnio(2020)+"\n");

        SalidaTerminal.consola("E. �Qu� a�o produjo mejores cantidades de producto \n\"Cebolla\" para el campesino \"Campesino5\"?");
        SalidaTerminal.consola("A�o: "+ejido1.anioMejorProdujo("Campesino5","Cebolla")+"\n");

        SalidaTerminal.consola("G. �Qu� persona es la que menos \nha cosechado en este a�o?\n");
        SalidaTerminal.consola("Campesino: "+ejido1.menosCosechaActual()+"\n");

        SalidaTerminal.consola("H. �Cu�ntas toneladas producen de ma�z \nCampesino1, Campesino4 y Campesino7?\n");
        ArregloDatos arr = new ArregloDatos(3);
        arr.agregar(campesino1);
        arr.agregar(campesino4);
        arr.agregar(campesino7);
        SalidaTerminal.consola("Toneladas: "+ejido1.cantidadTonelCampesinos(arr,"Zanahoria")+"\n");

        SalidaTerminal.consola("I. �Qu� producto produce m�s de \n50 toneladas en promedio por a�o?\n");
        SalidaTerminal.consola("Cosecha: "+ejido1.produceMasQue(50)+"\n");

        SalidaTerminal.consola("J. �Qu� campesino produce menos de \n40 toneladas de productos por a�o?\n");
        SalidaTerminal.consola("Campesino: "+ejido1.produceMenosQue(40)+"\n");
    }
}
