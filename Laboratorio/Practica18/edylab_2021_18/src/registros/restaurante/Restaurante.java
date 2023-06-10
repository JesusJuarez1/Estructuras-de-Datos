package registros.restaurante;

import com.sun.org.apache.bcel.internal.generic.SALOAD;
import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ListaEncadenada;

/**
 * Clase que lleva todo el control de un restaurante
 * @author Jesus
 * @version 1.0
 */
public class Restaurante implements IRestaurante{
    protected ListaEncadenada comidas;

    public Restaurante(){
        comidas = new ListaEncadenada();
        iniciar();
    }

    /**
     * Metodo que agrega comidas por defecto
     */
    private void iniciar(){
        ListaEncadenada tacos = new ListaEncadenada();
        tacos.agregar(new Ingrediente("Tortilla","Tortilla de maiz",25,
                TipoIngrediente.SOLIDO));
        tacos.agregar(new Ingrediente("Carne al pastor","Carne tipo al pastor",
                50,TipoIngrediente.SOLIDO));
        comidas.agregar(new Comida("Tacos al pastor","Dorar carne",
                new Cocinero("Juan"),TipoComida.CARNIVORA,tacos));

        ListaEncadenada torta = new ListaEncadenada();
        torta.agregar(new Ingrediente("Pan","Pan tipo bolillo",75,
                TipoIngrediente.SOLIDO));
        torta.agregar(new Ingrediente("Carnitas","Carnitas de puerco doraditas",75,
                TipoIngrediente.SOLIDO));
        comidas.agregar(new Comida("Torta","Dorar carnitas",
                new Cocinero("Pedro"),TipoComida.CARNIVORA,torta));

        ListaEncadenada ham = new ListaEncadenada();
        ham.agregar(new Ingrediente("Pan","Pan para hamburguesa",50,
                TipoIngrediente.SOLIDO));
        ham.agregar(new Ingrediente("Carne de res","Carne de res",100,
                TipoIngrediente.SOLIDO));
        ham.agregar(new Ingrediente("Queso amarillo","Queso amarillo",50,
                TipoIngrediente.SOLIDO));
        ham.agregar(new Ingrediente("Lechuga","Lechuga fresca",30,
                TipoIngrediente.SOLIDO));
        comidas.agregar(new Comida("Hamburguesa","Cocinar hamburguesa",
                new Cocinero("Mariana"),TipoComida.CARNIVORA,ham));

        ListaEncadenada pizza = new ListaEncadenada();
        pizza.agregar(new Ingrediente("Masa","Masa para pizza",1200,
                TipoIngrediente.SOLIDO));
        pizza.agregar(new Ingrediente("Queso","Queso",100,
                TipoIngrediente.SOLIDO));
        pizza.agregar(new Ingrediente("Pepperoni","Pepperoni",50,
                TipoIngrediente.SOLIDO));
        comidas.agregar(new Comida("Pizza pepperoni","Hornear pizza",
                new Cocinero("Joel"),TipoComida.CARNIVORA,pizza));

        ListaEncadenada alitas = new ListaEncadenada();
        alitas.agregar(new Ingrediente("Alitas","Alitas de pollo",200,
                TipoIngrediente.SOLIDO));
        alitas.agregar(new Ingrediente("Salsa BBQ","Salsa BBQ",150,
                TipoIngrediente.LIQUIDO));
        comidas.agregar(new Comida("Alitas BBQ","Alitas con salsa BBQ",
                new Cocinero("Maria"),TipoComida.CARNIVORA,alitas));

        ListaEncadenada huevo = new ListaEncadenada();
        huevo.agregar(new Ingrediente("Huevo","Huevo de gallina",75,TipoIngrediente.SOLIDO));
        huevo.agregar(new Ingrediente("Aceite","Aceite vejetal",15,TipoIngrediente.LIQUIDO));
        comidas.agregar(new Comida("Huevo frito","Freir huevo",new Cocinero("Juan"),
                TipoComida.CARNIVORA,huevo));

        ListaEncadenada ensalada = new ListaEncadenada();
        ensalada.agregar(new Ingrediente("Lechuga","Lechuga fresca",50,TipoIngrediente.SOLIDO));
        ensalada.agregar(new Ingrediente("Tomate","Tomate fresco",50,TipoIngrediente.SOLIDO));
        comidas.agregar(new Comida("Ensalada","Revolver ingredientes",new Cocinero("Pedro"),
                TipoComida.VEGETARIANA,ensalada));
    }

    @Override
    public void agregarComida(){
        SalidaTerminal.consola("Ingresa el nombre de la comida: ");
        String nombre = EntradaTerminal.consolaCadena();
        SalidaTerminal.consola("Ingresa su preparacion: ");
        String preparacion = EntradaTerminal.consolaCadena();
        Cocinero cocinero = nuevoCocinero();
        int op = 0;
        while(op < 1 || op > 3){
            SalidaTerminal.consola("1.- Vegetariana\n2.- Carnivora\n3.- Vegana\n" +
                    "Escoge la opcion del tipo de comida que es: ");
            op = EntradaTerminal.consolaInteger();
        }
        TipoComida tipo = null;
        if(op == 1){
            tipo = TipoComida.VEGETARIANA;
        }else if(op == 2){
            tipo = TipoComida.CARNIVORA;
        }else if(op == 3){
            tipo = TipoComida.VEGANA;
        }
        comidas.agregar(new Comida(nombre,preparacion,cocinero,tipo));
    }

    /**
     * Crea un nuevo cocinero y lo regresa
     * @return El nuevo cocinero
     */
    private Cocinero nuevoCocinero(){
        SalidaTerminal.consola("Ingresa el nombre del cocinero: ");
        String nombre = EntradaTerminal.consolaCadena();
        return new Cocinero(nombre);
    }

    @Override
    public void menuPlatillos(){
        comidas.inicializarIterador();
        while(comidas.hayElementos()){
            SalidaTerminal.consola("•"+comidas.obtenerElemento().toString()+"\n");
        }
    }

    @Override
    public void comidasIngredientes(){
        comidas.inicializarIterador();
        while(comidas.hayElementos()){
            SalidaTerminal.consola(">"+((Comida)comidas.obtenerElemento()).comida()+"\n");
        }
    }

    @Override
    public boolean ingredientesComida(String nombre){
        Comida c = (Comida)comidas.buscar(nombre);

        if(c != null){
            SalidaTerminal.consola(c.comida());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void agregarIngredientes(String nombre){
        comidas.inicializarIterador();
        while(comidas.hayElementos()){
            Comida c = (Comida)comidas.obtenerElemento();
            if(c.toString().equalsIgnoreCase(nombre)){
                c.agregarIngredientes();
                break;
            }
        }
    }

    @Override
    public void eliminarIngredientes(String nombre){
        comidas.inicializarIterador();
        while(comidas.hayElementos()) {
            Comida c = (Comida) comidas.obtenerElemento();
            if (c.toString().equalsIgnoreCase(nombre)) {
                c.eliminarIngredientes();
            }
        }
    }

    @Override
    public void eliminarComida(){
        while(!comidas.vacia()){
            comidas.inicializarIterador();
            int cont = 1;
            while(comidas.hayElementos()) {
                SalidaTerminal.consola(cont+".- "+comidas.obtenerElemento().toString()+"\n");
                cont++;
            }
            SalidaTerminal.consola("Ingresa el numero de la comida a eliminar: ");
            int pos = EntradaTerminal.consolaInteger();
            if(pos > 0 && pos <= cont){
                comidas.eliminar(pos-1);
                return;
            }
        }
    }

    @Override
    public void comidasConIngrediente(String nombre){
        if(!comidas.vacia()){
            comidas.inicializarIterador();
            while(comidas.hayElementos()){
                Comida c = (Comida) comidas.obtenerElemento();
                c.comidaConIngrediente(nombre);
            }
        }
    }

    @Override
    public void comidasDelChef(String nombre){
        if(!comidas.vacia()){
            comidas.inicializarIterador();
            while(comidas.hayElementos()){
                Comida c = (Comida)comidas.obtenerElemento();
                if(c.cocinero.toString().equalsIgnoreCase(nombre)){
                    SalidaTerminal.consola(c.comida()+"\n");
                }
            }
        }
    }

    @Override
    public void platillosConMas(int cantidad){
        if(!comidas.vacia()) {
            comidas.inicializarIterador();
            while (comidas.hayElementos()) {
                Comida c = (Comida) comidas.obtenerElemento();
                int can = 0;
                c.ingredientes.inicializarIterador();
                while (c.ingredientes.hayElementos()){
                    Ingrediente i = (Ingrediente)c.ingredientes.obtenerElemento();
                    if(i.tipo == TipoIngrediente.SOLIDO){
                        can += i.cantidad;
                    }
                }
                if(can > cantidad){
                    SalidaTerminal.consola(c.toString()+"\n");
                }
            }
        }
    }

    @Override
    public void comidaConIngTipo(TipoIngrediente tipo){
        if(!comidas.vacia()) {
            comidas.inicializarIterador();
            while (comidas.hayElementos()) {
                Comida c = (Comida) comidas.obtenerElemento();
                int can = 0;
                c.ingredientes.inicializarIterador();
                while (c.ingredientes.hayElementos()) {
                    Ingrediente i = (Ingrediente)c.ingredientes.obtenerElemento();
                    if(i.tipo == tipo){
                        SalidaTerminal.consola(c.toString()+"\n");
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void platillosTipo(TipoComida tipo){
        if(!comidas.vacia()) {
            comidas.inicializarIterador();
            while (comidas.hayElementos()) {
                Comida c = (Comida) comidas.obtenerElemento();
                if(c.tipo == tipo){
                    SalidaTerminal.consola(c.toString()+"\n");
                }
            }
        }
    }

    @Override
    public void eliminarPlatillosTipo(TipoComida tipo){
        if(!comidas.vacia()) {
            comidas.inicializarIterador();
            while (comidas.hayElementos()) {
                Comida c = (Comida) comidas.obtenerElemento();
                if(c.tipo == tipo){
                    comidas.eliminar(c);
                }
            }
        }
    }
}
