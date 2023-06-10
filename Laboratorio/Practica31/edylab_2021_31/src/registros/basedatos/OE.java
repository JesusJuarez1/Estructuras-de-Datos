package registros.basedatos;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ListaEncadenada;
import estructurasnolineales.ABB;
import herramientas.texto.Separador;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class OE {
    protected ABB customers;
    protected ABB orders;
    protected ABB orderItems;
    protected ABB productInformation;
    protected ABB productDescription;
    protected ABB categoriesTab;

    public OE(){
        customers = new ABB();
        leerDatos("datos/customers.csv");
        orders = new ABB();
        leerDatos("datos/orders.csv");
        orderItems = new ABB();
        leerDatos("datos/order_items.csv");
        productInformation = new ABB();
        leerDatos("datos/product_information.csv");
        productDescription = new ABB();
        leerDatos("datos/product_description.csv");
        categoriesTab = new ABB();
        leerDatos("datos/categories_tab.csv");
    }

    /**
     * Agrega los objetos NodoBusquedaBinaria al espesificada por el nombre
     * El indice se saca de los 5 primeros caracteres de la linea y la direccion con la posicion de la linea
     * @param nombre Nombre del archivo donde se sacaran los datos a extraer los datos de interes
     */
    private void leerDatos(String nombre){
        RandomAccessFile archivo = null;
        try {
            archivo = new RandomAccessFile(nombre, "r");
            String cad="";
            while(true) {
                if(archivo.getFilePointer() != 0){
                    long direccion = archivo.getFilePointer();
                    cad = archivo.readLine();
                    if (cad==null){
                        break;
                    }
                    if(nombre.equalsIgnoreCase("datos/customers.csv")){
                        customers.agregar(new NodoBusquedaBinaria(Long.parseLong(cad.substring(0,3)),direccion));
                    }else if(nombre.equalsIgnoreCase("datos/orders.csv")){
                        orders.agregar(new NodoBusquedaBinaria(Long.parseLong(cad.substring(0,4)),direccion));
                    }else if(nombre.equalsIgnoreCase("datos/order_items.csv")){
                        orderItems.agregar(new NodoBusquedaBinaria(Long.parseLong(cad.substring(0,4)),direccion));
                    }else if(nombre.equalsIgnoreCase("datos/product_information.csv")){
                        productInformation.agregar(new NodoBusquedaBinaria(Long.parseLong(cad.substring(0,4)),direccion));
                    }else if(nombre.equalsIgnoreCase("datos/product_description.csv")){
                        productDescription.agregar(new NodoBusquedaBinaria(Long.parseLong(cad.substring(0,4)),direccion));
                    }else if(nombre.equalsIgnoreCase("datos/categories_tab.csv")){
                        ListaEncadenada elementos = Separador.separarCadena(cad,",");//Separa los datos por comas
                        Long indice = Long.parseLong(elementos.obtener(2).toString());
                        categoriesTab.agregar(new NodoBusquedaBinaria(indice,direccion));
                    }
                }else{
                    cad = archivo.readLine();
                }
            }
            archivo.close();
        } catch (FileNotFoundException fe) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permite escoger una tabla y regresa el nombre de esta, ademas de su direccion
     * @return El nombre y direccion de la tabla en una cadena
     */
    private String escogerTabla(){
        Integer opcion = 0;
        while(opcion <= 0 || opcion > 6) {
            SalidaTerminal.consola("1.- Customers\n" +
                    "2.- Orders\n" +
                    "3.- Order Items\n" +
                    "4.- Product Information\n" +
                    "5.- Product Description\n" +
                    "6.- Categories Tab\n" +
                    "Ingresa el numero de la tabla: ");
            opcion = EntradaTerminal.consolaInteger();
        }
        String tabla = "";
        switch (opcion){
            case 1://Customers
                tabla = "datos/customers.csv";
                break;
            case 2://Orders
                tabla = "datos/orders.csv";
                break;
            case 3://Order Items
                tabla = "datos/order_items.csv";
                break;
            case 4://Product Information
                tabla = "datos/product_information.csv";
                break;
            case 5://Product Description
                tabla = "datos/product_description.csv";
                break;
            case 6://Categories Tab
                tabla = "datos/categories_tab.csv";
                break;
            default:
                return null;
        }
        return tabla;
    }

    /**
     * Obtiene un dato del arbol espesificado y con un indice espesifico
     * @param tabla Nombre con el que se identifica el arbol de donde se va a extraer el dato
     * @param indice Indice del dato
     * @return El dato encontrado en el arbol, null en caso contrario
     */
    private NodoBusquedaBinaria buscarDatoArbol(String tabla,Long indice){
        NodoBusquedaBinaria dato = null;
        if(tabla.equalsIgnoreCase("datos/customers.csv")){
            dato = (NodoBusquedaBinaria)customers.buscar(indice);
        }else if(tabla.equalsIgnoreCase("datos/orders.csv")){
            dato = (NodoBusquedaBinaria)orders.buscar(indice);
        }else if(tabla.equalsIgnoreCase("datos/order_items.csv")){
            dato = (NodoBusquedaBinaria)orderItems.buscar(indice);
        }else if(tabla.equalsIgnoreCase("datos/product_information.csv")){
            dato = (NodoBusquedaBinaria)productInformation.buscar(indice);
        }else if(tabla.equalsIgnoreCase("datos/product_description.csv")) {
            dato = (NodoBusquedaBinaria)productDescription.buscar(indice);
        }else if(tabla.equalsIgnoreCase("datos/categories_tab.csv")){
            dato = (NodoBusquedaBinaria)categoriesTab.buscar(indice);
        }else{
            return null;
        }
        return dato;
    }

    /**
     * Permite consultar un dato de alguna tabla en particular
     * @return Una cadena con la linea del archivo encontrada, null en caso contrario
     */
    public String consultarDato(){
        String tabla = escogerTabla();
        SalidaTerminal.consola("Ingresa el indice a consultar: ");
        Long indice = Long.parseLong(EntradaTerminal.consolaCadena());
        NodoBusquedaBinaria dato = buscarDatoArbol(tabla,indice);
        String elemento = "";
        if(dato != null){
            RandomAccessFile archivo = null;
            try{
                archivo = new RandomAccessFile(tabla, "r");
                archivo.seek(dato.getDireccion());
                elemento = archivo.readLine();
                archivo.close();
            }catch(FileNotFoundException fe) {
                System.out.println("No se encontro el archivo");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                return elemento;
            }
        }else{
            return null;
        }
    }

    /**
     * Agrega un nuevo registro al archivo y al arbol escogidos
     * @return true si lo hace, false en caso contrario
     */
    public boolean insertarRegistro(){
        String tabla = escogerTabla();
        SalidaTerminal.consola("Ingresa el registro a agregar:\n");
        String cadena = EntradaTerminal.consolaCadena();
        long direccion = 0;
        try {
            FileWriter fstream = new FileWriter("./"+tabla, true);
            BufferedWriter out = new BufferedWriter(fstream);
            //out.newLine();
            out.write(cadena);
            out.close();
            fstream.close();

            RandomAccessFile archivo = new RandomAccessFile(tabla, "r");
            archivo.seek(archivo.length()-cadena.length());
            direccion = archivo.getFilePointer();
            archivo.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        ListaEncadenada elementos = Separador.separarCadena(cadena,",");//Separa los datos por comas
        if(tabla.equalsIgnoreCase("datos/customers.csv")){
            Long indice = Long.parseLong(elementos.obtener(0).toString());
            customers.agregar(new NodoBusquedaBinaria(indice,direccion));
        }else if(tabla.equalsIgnoreCase("datos/orders.csv")){
            Long indice = Long.parseLong(elementos.obtener(0).toString());
            orders.agregar(new NodoBusquedaBinaria(indice,direccion));
        }else if(tabla.equalsIgnoreCase("datos/order_items.csv")){
            Long indice = Long.parseLong(elementos.obtener(0).toString());
            orderItems.agregar(new NodoBusquedaBinaria(indice,direccion));
        }else if(tabla.equalsIgnoreCase("datos/product_information.csv")){
            Long indice = Long.parseLong(elementos.obtener(0).toString());
            productInformation.agregar(new NodoBusquedaBinaria(indice,direccion));
        }else if(tabla.equalsIgnoreCase("datos/product_description.csv")){
            Long indice = Long.parseLong(elementos.obtener(0).toString());
            productDescription.agregar(new NodoBusquedaBinaria(indice,direccion));
        }else if(tabla.equalsIgnoreCase("datos/categories_tab.csv")){
            Long indice = Long.parseLong(elementos.obtener(2).toString());
            categoriesTab.agregar(new NodoBusquedaBinaria(indice,direccion));
        }else{
            return false;
        }
        return true;
    }

    /**
     * Elimina un registro del archivo y del arbol
     * @return El elemento eliminado, null en caso contrario
     */
    public String eliminar(){
        String tabla = escogerTabla();
        SalidaTerminal.consola("Ingresa el indice del elemento a eliminar: ");
        Long indice = Long.parseLong(EntradaTerminal.consolaCadena());
        NodoBusquedaBinaria dato = buscarDatoArbol(tabla,indice);
        if(dato != null){
            String registroBorrar = modificarArchivo(dato,tabla);
            switch (tabla){
                case "datos/customers.csv"://Customers
                    customers = new ABB();
                    break;
                case "datos/orders.csv"://Orders
                    orders = new ABB();
                    break;
                case "datos/order_items.csv"://Order Items
                    orderItems = new ABB();
                    break;
                case "datos/product_information.csv"://Product Information
                    productInformation = new ABB();
                    break;
                case "datos/product_description.csv"://Product Description
                    productDescription = new ABB();
                    break;
                case "datos/categories_tab.csv"://Categories Tab
                    categoriesTab = new ABB();
                    break;
                default:
                    return null;
            }
            leerDatos(tabla);
            return registroBorrar;
        }else{
            return null;
        }
    }

    /**
     * Modifica el archivo para eliminar el registro
     * @param dato Nodo a eliminar en el archivo
     * @param tabla Tabla de la cual se va a eliminar el registro
     * @return El elemento eliminado
     */
    private String modificarArchivo(NodoBusquedaBinaria dato,String tabla){
        try {
            RandomAccessFile archivo = new RandomAccessFile(tabla, "r");
            archivo.seek(dato.getDireccion());
            if(archivo.getFilePointer() == 0){
                return null;
            }
            String registroBorrar = archivo.readLine();
            archivo.close();
            eliminarRegistro(registroBorrar,tabla);
            return registroBorrar;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Elimina la linea que se le pase como parametro del archivo
     * @param tabla Nombre del archivo
     * @param registroBorrar linea a eliminar
     */
    private void eliminarRegistro(String registroBorrar,String tabla){
        try {
            File tmp = new File(tabla);
            BufferedReader br = new BufferedReader(new FileReader(tmp));
            BufferedWriter pw = new BufferedWriter(new FileWriter(new File("./"+tmp.getName())));
            String linea = br.readLine();
            pw.write(linea);
            while((linea = br.readLine()) != null){
                if(!linea.equalsIgnoreCase(registroBorrar)){
                    pw.newLine();
                    pw.write(linea);
                }
            }
            Path path = Paths.get(tabla);
            Path path2 = Paths.get(tmp.getName());
            pw.close();
            br.close();
            Files.move(path2,path, StandardCopyOption.REPLACE_EXISTING);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
