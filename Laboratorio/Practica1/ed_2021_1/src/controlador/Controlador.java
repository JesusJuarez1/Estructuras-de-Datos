package controlador;

import com.sun.org.apache.xpath.internal.operations.Or;
import modelo.*;

import java.util.ArrayList;

public class Controlador {
    static protected ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    static protected ArrayList<Chofer> choferes = new ArrayList<Chofer>();
    static protected ArrayList<Locacion> origenes = new ArrayList<Locacion>();
    static protected ArrayList<Locacion> destinos = new ArrayList<Locacion>();
    static protected ArrayList<Material> materiales = new ArrayList<Material>();
    static protected ArrayList<Transporte> regTrans = new ArrayList<Transporte>();

    public static void controlador(){
        ingValPred(); //Ingresa valores a las listas
        while(true) {
            menu();
        }
    }

    private static void ingValPred(){
        vehiculos.add(new Vehiculo(525372554,TipoVehiculo.CAM_FRIG));
        vehiculos.add(new Vehiculo(525372555,TipoVehiculo.MADRINA));
        vehiculos.add(new Vehiculo(525372556,TipoVehiculo.PLATA_ABI));

        choferes.add(new Chofer("Juan",28));
        choferes.add(new Chofer("Pedro",38));
        choferes.add(new Chofer("Antonio",41));

        origenes.add(new Locacion(23451,"Zacatecas","Jerez","Centro","San Pedro",152));
        origenes.add(new Locacion(63582,"Veracruz","Orizaba","Enrique estrada","Benito Juarez",253));
        origenes.add(new Locacion(92548,"Jalisco","Guadalajara","Lomas","Alameda",462));

        destinos.add(new Locacion(23451,"Zacatecas","Jerez","Centro","San Pedro",152));
        destinos.add(new Locacion(63582,"Veracruz","Orizaba","Enrique estrada","Benito Juarez",253));
        destinos.add(new Locacion(92548,"Jalisco","Guadalajara","Lomas","Alameda",462));

        materiales.add(new Material("Grava"));
        materiales.add(new Material("Vacunas"));
        materiales.add((new Material("Alimento")));
    }

    public static void menu(){
        switch (obtenerOpcion()){
            case 1:
                altaVehiculos();
                break;
            case 2:
                consVehTip();
                break;
            case 3:
                regTransporte();
                break;
            case 4:
                altaChofer();
                break;
            case 5:
                altaOrigen();
                break;
            case 6:
                altaDestino();
                break;
            case 7:
                consOrigenes();
                break;
            case 8:
                consDestinos();
                break;
            case 9:
                altaMateriales();
                break;
            case 10:
                consMateriales();
                break;
            case 11:
                consulPend();
                break;
            case 12:
                System.exit(0);
        }
    }

    private static int obtenerOpcion(){
        Integer opcion = 0;
        Menu[] menu = Menu.values();
        while(opcion == 0){
            System.out.println("ELIGE EL NUMERO DE LA OPCION:");
            for(int i=0;i<menu.length;i++){
                System.out.println(menu[i].getIndice()+".- "+menu[i].getNombre());
            }
            opcion = EntradaConsola.consolaInteger();
            if(opcion < 1 || opcion > 12 || opcion == null){
                opcion = 0;
            }
        }
        return (int)opcion;
    }

    private static void altaVehiculos(){
        System.out.print("Ingresa el numero de serie del vehiculo: ");
        int numSerie = EntradaConsola.consolaInteger();
        System.out.println("Elige el numero del tipo de vehiculo");
        vehiculos.add(new Vehiculo(numSerie,escTipVeh()));
    }

    private static TipoVehiculo escTipVeh(){
        Integer opcion = 0;
        TipoVehiculo[] tipos = TipoVehiculo.values();
        while(opcion == 0) {
            for (TipoVehiculo t : tipos) {
                System.out.println(t.getIndice() + ".- " + t.getNombre());
            }
            opcion = EntradaConsola.consolaInteger();
            if(opcion < 1 || opcion > 15 || opcion == null){
                opcion = 0;
            }
        }
        return tipos[opcion-1];
    }

    private static void consVehTip(){
        if(!vehiculos.isEmpty()){
            System.out.println("Elige que tipo de vehiculo quieres buscar");
            TipoVehiculo tp = escTipVeh();
            for(Vehiculo v:vehiculos){
                if(v.getTipo() == tp){
                    System.out.println(v.toString());
                }
            }
        }
    }

    private static void altaChofer(){
        System.out.print("Ingresa el nombre: ");
        String nombre = EntradaConsola.consolaCadena();
        System.out.print("Ingresa la edad: ");
        int edad = EntradaConsola.consolaInteger();
        choferes.add(new Chofer(nombre,edad));
    }

    private static void altaOrigen(){
        origenes.add(crearLocacion());
    }

    private static Locacion crearLocacion(){
        System.out.print("Ingresa el codigo postal: ");
        int cp = EntradaConsola.consolaInteger();
        System.out.println("Ingresa el estado: ");
        String est = EntradaConsola.consolaCadena();
        System.out.println("Ingresa el municipio: ");
        String mun = EntradaConsola.consolaCadena();
        System.out.println("Ingresa el colonia: ");
        String col = EntradaConsola.consolaCadena();
        System.out.println("Ingresa la calle: ");
        String call = EntradaConsola.consolaCadena();
        System.out.print("Ingresa el numero: ");
        int num = EntradaConsola.consolaInteger();
        return new Locacion(cp,est,mun,col,call,num);
    }

    private static void altaDestino(){
        destinos.add(crearLocacion());
    }

    private static void consOrigenes(){
        for(Locacion l:origenes){
            System.out.println(l.toString());
        }
    }

    private static void consDestinos(){
        for(Locacion l:destinos){
            System.out.println(l.toString());
        }
    }

    private static void altaMateriales(){
        System.out.println("Ingresa el nombre del material");
        String nombre = EntradaConsola.consolaCadena();
        materiales.add(new Material(nombre));
    }

    private static void consMateriales(){
        for(Material m:materiales){
            System.out.println(m.toString());
        }
    }

    private static void regTransporte() {
        Vehiculo vehiculo = elegirVehiculo();
        Locacion origen = elegirOrigen();
        Locacion destino = elegirDestino();
        Chofer chofer = elegirChofer();
        Material material = elegirMaterial();
        if (vehiculo == null || origen == null || destino == null || chofer == null || material==null) {
            System.out.println("ERROR");
            return;
        }
        boolean entregado = false;
        String r = "";
        while (r == "") {
            System.out.println("¿Entregado? (S/N)");
            r = EntradaConsola.consolaCadena();

            if(r.equals("S") || r.equals("SI") || r.equals("s") || r.equals("si")){
                entregado = true;
                break;
            }else if(r.equals("N")||r.equals("NO")||r.equals("n")||r.equals("no")){
                entregado = false;
                break;
            }else{
                r = "";
            }
        }
        regTrans.add(new Transporte(vehiculo,origen,destino,chofer,material,entregado));
    }

    private static Vehiculo elegirVehiculo(){
        if(!vehiculos.isEmpty()){
            int op = 0;
            while(op==0){
                System.out.println("Elige el numero del vehiculo que deseas: ");
                int i = 0;
                for(Vehiculo v:vehiculos){
                    i++;
                    System.out.println(i+". "+v.toString());
                }
                op = EntradaConsola.consolaInteger();
                if(op<1 || op > (vehiculos.size()+1)){
                    op = 0;
                }
            }
            return vehiculos.get(op);
        }else{
            return null;
        }
    }

    private static Locacion elegirOrigen(){
        if(!origenes.isEmpty()) {
            int op = 0;
            while (op == 0) {
                System.out.println("Elige el numero del origen deseado: ");
                int i = 0;
                for (Locacion l : origenes) {
                    i++;
                    System.out.println(i+". "+l.toString());
                }
                op = EntradaConsola.consolaInteger();
                if (op < 1 || op > (origenes.size() + 1)) {
                    op = 0;
                }
            }
            return origenes.get(op-1);

        }else{
            return null;
        }
    }

    private static Locacion elegirDestino(){
        if(!destinos.isEmpty()) {
            int op = 0;
            while (op == 0) {
                System.out.println("Elige el numero del origen deseado: ");
                int i = 0;
                for (Locacion l : destinos) {
                    i++;
                    System.out.println(i+". "+l.toString());
                }
                op = EntradaConsola.consolaInteger();
                if (op < 1 || op > (destinos.size() + 1)) {
                    op = 0;
                }
            }
            return destinos.get(op-1);

        }else{
            return null;
        }
    }

    private static Chofer elegirChofer(){
        if(!choferes.isEmpty()){
            int op = 0;
            while (op == 0) {
                System.out.println("Elige el numero del chofer deseado: ");
                int i = 0;
                for (Chofer c : choferes) {
                    i++;
                    System.out.println(i+". "+c.toString());
                }
                op = EntradaConsola.consolaInteger();
                if (op < 1 || op > (choferes.size() + 1)) {
                    op = 0;
                }
            }
            return choferes.get(op-1);
        }else{
            return null;
        }
    }

    private static Material elegirMaterial(){
        if(!materiales.isEmpty()){
            int op = 0;
            while (op == 0) {
                System.out.println("Elige el numero del material deseado: ");
                int i = 0;
                for (Material m : materiales) {
                    i++;
                    System.out.println(i+". "+m.toString());
                }
                op = EntradaConsola.consolaInteger();
                if (op < 1 || op > (materiales.size() + 1)) {
                    op = 0;
                }
            }
            return materiales.get(op-1);
        }else{
            return null;
        }
    }

    private static void consulPend(){
        for(Transporte t:regTrans){
            if(t.isEntregado() == false){
                System.out.println(t.toString());
            }
        }
    }
}
