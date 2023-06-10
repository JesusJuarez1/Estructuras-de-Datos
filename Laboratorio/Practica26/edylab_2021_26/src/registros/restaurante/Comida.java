package registros.restaurante;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ListaEncadenada;

/**
 * Clase que simula ser una comida almacenando sus caracteristicas principales
 * @author Jesus
 * @version 1.0
 */
public class Comida implements IComida{
    protected String nombre;
    protected ListaEncadenada ingredientes;
    protected String preparacion;
    protected Cocinero cocinero;
    protected TipoComida tipo;

    public Comida(String nombre,String preparacion, Cocinero cocinero, TipoComida tipo, ListaEncadenada ingredientes){
        this.nombre = nombre;
        this.preparacion = preparacion;
        this.cocinero = cocinero;
        this.ingredientes = ingredientes;
        this.tipo = tipo;
    }

    public Comida(String nombre, String preparacion, Cocinero cocinero,TipoComida tipo) {
        this.nombre = nombre;
        this.preparacion = preparacion;
        this.cocinero = cocinero;
        ingredientes = new ListaEncadenada();
        this.tipo = tipo;
        agregarIngredientes();
    }

    @Override
    public void agregarIngredientes(){
        while(true){
            SalidaTerminal.consola("Ingresa el nombre del ingrediente: ");
            String nombre = EntradaTerminal.consolaCadena();
            SalidaTerminal.consola("Ingrese la descripcion del ingrediente: ");
            String descripcion = EntradaTerminal.consolaCadena();
            SalidaTerminal.consola("Ingrese la cantidad del ingrediente: ");
            int cantidad = EntradaTerminal.consolaInteger();
            int opcion = 0;
            while(opcion < 1 || opcion > 2){
                SalidaTerminal.consola("1.- Solido\n2.- Liquido\nEscoje el tipo de ingrediente que es: ");
                opcion = EntradaTerminal.consolaInteger();
            }
            TipoIngrediente tipo = null;
            if(opcion == 1){
                tipo = TipoIngrediente.SOLIDO;
            }else{
                tipo = TipoIngrediente.LIQUIDO;
            }
            ingredientes.agregar(new Ingrediente(nombre,descripcion,cantidad,tipo));

            SalidaTerminal.consola("Desea agregar otro ingrediente? ");
            String resp = EntradaTerminal.consolaCadena();
            if(resp.equalsIgnoreCase("No") || resp.equalsIgnoreCase("N")){
                return;
            }
        }
    }

    @Override
    public String comida(){
        String ing = "\tIngredientes:\n";
        ingredientes.inicializarIterador();
        while(ingredientes.hayElementos()){
            ing += "\t•"+((Ingrediente)ingredientes.obtenerElemento()).ingrediente()+"\n";
        }
        return nombre+"\n\t"+"Preparacion: "+preparacion+"\n\t"+"Cocinero: "+cocinero.toString()+"\n"+ing;
    }

    @Override
    public void eliminarIngredientes(){
        while(!ingredientes.vacia()){
            ingredientes.inicializarIterador();
            int cont = 1;
            while(ingredientes.hayElementos()){
                SalidaTerminal.consola(cont+".- "+ingredientes.obtenerElemento()+"\n");
                cont++;
            }
            SalidaTerminal.consola("Ingresa el numero del ingrediente a eliminar: ");
            int op = EntradaTerminal.consolaInteger();
            if(op > 0 && op <= cont){
                ingredientes.eliminar(op-1);
                SalidaTerminal.consola("Eliminar mas? ");
                String e = EntradaTerminal.consolaCadena();
                if(e.equalsIgnoreCase("N") || e.equalsIgnoreCase("No")){
                    return;
                }
            }
        }
    }

    @Override
    public void comidaConIngrediente(String nombre){
        if(!ingredientes.vacia()){
            ingredientes.inicializarIterador();
            while(ingredientes.hayElementos()){
                if(((Ingrediente)ingredientes.obtenerElemento()).toString().equalsIgnoreCase(nombre)){
                    SalidaTerminal.consola(comida());
                }
            }
        }
    }

    @Override
    public String toString(){
        return nombre;
    }
}
