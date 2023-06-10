package registros.basedatos;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;

public class MenuOE {

    public MenuOE(){
        OE oe = new OE();
        Integer opcion = 0;
        while(opcion != 4){
            SalidaTerminal.consola("1.- Insertar un dato \n" +
                    "2.- Consultar un dato\n" +
                    "3.- Eliminar un dato\n" +
                    "4.- Salir\n" +
                    "Ingrese el numero de la opcion deseada: ");
            opcion = EntradaTerminal.consolaInteger();
            if(opcion != null){
                switch(opcion){
                    case 1:
                        oe.insertarRegistro();
                        break;
                    case 2:
                        String dato = oe.consultarDato();
                        if(dato == null){
                            SalidaTerminal.consola("Dato no encontrado\n");
                        }else{
                            SalidaTerminal.consola(dato+"\n");
                        }
                        break;
                    case 3:
                        SalidaTerminal.consola("Elemento eliminado: "+oe.eliminar()+"\n");
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
