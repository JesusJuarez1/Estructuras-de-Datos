package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import registros.productos.Campesino;
import registros.productos.ControlCosechas;

public class PruebaCosechas {
    public static void main(String []argumentos){
        ControlCosechas cosechas=new ControlCosechas(3,2,4);
        //datos vacios
        cosechas.imprimirDatosCosechas();
        SalidaTerminal.consola("\n");

        cosechas.agregarProducto("Frijol");
        cosechas.agregarProducto("Maíz");
        cosechas.agregarProducto("Ajo");

        Campesino campesino1=new Campesino("001","Pepe",29);
        Campesino campesino2=new Campesino("002","Miguel",39);

        cosechas.agregarCampesino(campesino1);
        cosechas.agregarCampesino(campesino2);

        cosechas.agregarAnio(2018);
        cosechas.agregarAnio(2019);
        cosechas.agregarAnio(2020);
        cosechas.agregarAnio(2021);

        //datos a medias
        cosechas.imprimirDatosCosechas();
        SalidaTerminal.consola("\n");

        cosechas.agregarCosecha("Frijol","001",2018,40.2);
        cosechas.agregarCosecha("Frijol","002",2018,20.0);
        cosechas.agregarCosecha("Frijol","001",2019,60.0);
        cosechas.agregarCosecha("Frijol","001",2020,10.5);
        cosechas.agregarCosecha("Maíz","001",2018,20.0);
        cosechas.agregarCosecha("Ajo","002",2021,15.0);
        cosechas.agregarCosecha("Ajo","001",2020,5.0);

        //datos con cosechas
        cosechas.imprimirDatosCosechas();
        SalidaTerminal.consola("\n");

        //Obtener las toneladas producidas por Pepe (001) de Frijol desde el 2018 hasta el 2020.
        ArregloDatos aniossolicitados=new ArregloDatos(3);
        aniossolicitados.agregar(2018);
        aniossolicitados.agregar(2019);
        aniossolicitados.agregar(2020);

        SalidaTerminal.consola("Las toneladas producidas por Pepe (001) de frijol en los años 2018, 2019 y 2020 son: "+
                cosechas.cosechaProductoCampesino("Frijol","001",aniossolicitados)+ "\n");

        //Obtener las toneladas producidas de Frijol en el año 2018
    }
}
