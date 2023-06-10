package pruebas;

import entradasalida.SalidaTerminal;
import registros.galeria.*;

public class PruebaGaleria {
    public static void main(String[] args) {
        Pintor p1 = new Pintor("Pintor1",56,"15/01/1980","Zacatecas","54657687956","");
        Pintor p2 = new Pintor("Pintor2",55,"16/01/1980","Fresnillo","35342342553","");
        Pintor p3 = new Pintor("Pintor3",54,"17/01/1980","Valparaiso","24354157773","");
        Pintor p4 = new Pintor("Pintor4",53,"18/01/1980","Jerez","24335435255","");
        Pintor p5 = new Pintor("Pintor5",52,"19/01/1980","Zacatecas","43434242424","");

        Pintar a1 = new Pintar(p1,"Pintar Pintor1");
        Pintar a2 = new Pintar(p2,"Pintar Pintor2");
        Pintar a3 = new Pintar(p3,"Pintar Pintor3");
        Pintar a4 = new Pintar(p4,"Pintar Pintor4");
        Pintar a5 = new Pintar(p5,"Pintar Pintor5");

        Exponer e1 = new Exponer(p1,"Exponer1","Lugar1","11/11/11",4222);
        Exponer e2 = new Exponer(p2,"Exponer2","Lugar2","10/10/10",4223);
        Exponer e3 = new Exponer(p3,"Exponer3","Lugar3","11/10/11",4226);
        Exponer e4 = new Exponer(p4,"Exponer4","Lugar4","10/11/11",4224);
        Exponer e5 = new Exponer(p5,"Exponer5","Lugar5","11/11/10",4225);

        Firma_Autografo f1 = new Firma_Autografo(p1,"Lugar1","05/05/12");
        Firma_Autografo f2 = new Firma_Autografo(p2,"Lugar2","06/06/12");
        Firma_Autografo f3 = new Firma_Autografo(p3,"Lugar3","07/07/12");
        Firma_Autografo f4 = new Firma_Autografo(p4,"Lugar4","08/08/12");
        Firma_Autografo f5 = new Firma_Autografo(p5,"Lugar5","09/09/12");

        Viajar v1 = new Viajar(p1,"Lugar1");
        Viajar v2 = new Viajar(p2,"Lugar2");
        Viajar v3 = new Viajar(p3,"Lugar3");
        Viajar v4 = new Viajar(p4,"Lugar4");
        Viajar v5 = new Viajar(p5,"Lugar5");

        Galeria galeria = new Galeria(10);

        galeria.agregarPintor(p1);
        galeria.agregarPintor(p2);
        galeria.agregarPintor(p3);
        galeria.agregarPintor(p4);
        galeria.agregarPintor(p5);

        galeria.agregarActividad(a1,0,3,5);
        galeria.agregarActividad(a1,1,3,5);
        galeria.agregarActividad(a1,2,3,5);
        galeria.agregarActividad(a1,3,3,5);
        galeria.agregarActividad(a1,4,3,5);
        galeria.agregarActividad(a1,5,3,5);
        galeria.agregarActividad(a1,6,3,5);
        galeria.agregarActividad(a1,7,3,5);
        galeria.agregarActividad(a1,8,3,5);
        galeria.agregarActividad(a1,9,3,5);

        galeria.agregarActividad(a5,0,0,0);
        galeria.agregarActividad(a4,3,1,1);
        galeria.agregarActividad(a3,5,4,3);
        galeria.agregarActividad(a2,8,2,2);

        galeria.agregarActividad(e1,7,20,2);
        galeria.agregarActividad(e2,7,10,1);
        galeria.agregarActividad(e3,7,22,3);
        galeria.agregarActividad(e4,7,7,4);
        galeria.agregarActividad(e5,7,33,5);

        galeria.agregarActividad(f1,1,23,6);
        galeria.agregarActividad(f2,5,25,6);
        galeria.agregarActividad(f3,3,35,5);
        galeria.agregarActividad(f4,6,50,4);

        galeria.agregarActividad(f5,8,30,3);
        galeria.agregarActividad(f5,9,30,3);

        galeria.agregarActividad(v1,2,21,6);
        galeria.agregarActividad(v2,4,21,6);
        galeria.agregarActividad(v3,4,31,5);
        galeria.agregarActividad(v4,5,51,4);
        //galeria.agregarActividad(v5,9,31,3);

        SalidaTerminal.consola("Actividad mas popular en el año 4: "+galeria.actividadMasPopular(4)+"\n\n");
        SalidaTerminal.consola("Pintor que mas autografos hace: "+galeria.masAutografos().toString()+"\n\n");
        SalidaTerminal.consola("Pintores que hicieron (Viajar): \n");
        galeria.pintorDesarrollo("Viajar");
        SalidaTerminal.consola("\nPinto o expuso (Pintor2): \n");
        galeria.pintoOExpuso(p2);
        SalidaTerminal.consola("\nAño con menos actividad (Firma de Autografos): "+
                galeria.anioMenosActividad("Firma de Autografos")+"\n\n");
        SalidaTerminal.consola("Pintores que en todos los años hicieron (Pintar): \n");
        galeria.todosAniosHicieron("Pintar");
        SalidaTerminal.consola("\nMas aforo: "+galeria.masAforo().toString());
    }
}
