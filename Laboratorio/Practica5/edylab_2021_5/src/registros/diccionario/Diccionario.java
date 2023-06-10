package registros.diccionario;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructuraslineales.ArregloOrden;
import estructuraslineales.TipoOrden;
import utilerias.comunes.Herramientas;

import java.util.Locale;

public class Diccionario implements IDiccionario{
    ArregloOrden diccionario;

    public Diccionario(int capacidad){
        diccionario = new ArregloOrden(capacidad, TipoOrden.ASCENDENTE);
    }

    public void menu(){
        Integer opcion = 0;
        while(opcion != MenuDiccionario.SALIR.getIndice()) {
            opcion = pedirOpcion();

            switch (opcion) {
                case 1:
                    SalidaTerminal.consola("Ingresa la palabra: ");
                    String nombre = EntradaTerminal.consolaCadena();
                    SalidaTerminal.consola("Ingresa la definicion: ");
                    String definicion = EntradaTerminal.consolaCadena();

                    agregarPalabra(nombre, definicion, escogerTipoPalabra());
                    break;

                case 2:
                    buscarPalabra();
                    break;

                case 3:
                    buscarPalabrasConDefinicion();
                    break;

                case 4:
                    SalidaTerminal.consola("Buscar palabras que comienzen con: ");
                    String consulta = EntradaTerminal.consolaCadena();
                    buscarCoincidencias(consulta);
                    break;

                case 5:
                    buscarTipo(escogerTipoPalabra());
                    break;

                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    /**
     * Pide que seleccione una opcion
     * @return el numero de la opcion deseada
     */
    private int pedirOpcion(){
        ArregloDatos menu = new ArregloDatos(6);
        menu.agregar(MenuDiccionario.AGREGAR);
        menu.agregar(MenuDiccionario.CONSULTAR);
        menu.agregar(MenuDiccionario.LISTARPC);
        menu.agregar(MenuDiccionario.LISTAR);
        menu.agregar(MenuDiccionario.LISTARTIPO);
        menu.agregar(MenuDiccionario.SALIR);
        Integer opcion = 0;
        while(opcion<1 || opcion>menu.cantidadElementos()){
            SalidaTerminal.consola("\nIngresa el numero de la opcion: \n");
            for(int pos=0;pos<menu.cantidadElementos();pos++){
                SalidaTerminal.consola(((MenuDiccionario)menu.obtener(pos)).getIndice()+".- "+
                        ((MenuDiccionario)menu.obtener(pos)).getNombre()+"\n");
            }
            opcion = EntradaTerminal.consolaInteger();
        }
        return opcion;
    }

    @Override
    public void buscarPalabrasConDefinicion(){
        SalidaTerminal.consola("Ingresa el texto a buscar en las definiciones: ");
        String txt = EntradaTerminal.consolaCadena();
        for(int pos=0;pos<diccionario.cantidadElementos();pos++){
            Palabra palabra = (Palabra) diccionario.obtener(pos);
            if(palabra.getDefinicion().toLowerCase().contains(txt.toLowerCase())){
                SalidaTerminal.consola(palabra.toStringObjeto()+"\n");
            }
        }
    }

    @Override
    public void buscarPalabra(){
        SalidaTerminal.consola("Ingrese la palabra a buscar: ");
        String palabra = EntradaTerminal.consolaCadena();
        Integer busqueda = (Integer)diccionario.buscar(palabra);
        if(busqueda > 0){
            busqueda--;
            SalidaTerminal.consola(((Palabra)diccionario.obtener(busqueda)).toStringObjeto());
        }else{
            SalidaTerminal.consola("No se encontro la palabra");
        }
    }

    @Override
    public boolean agregarPalabra(String nombre,String definicion,TipoPalabra tipo){
        if(diccionario.agregar(new Palabra(nombre,definicion,tipo))!=-1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public TipoPalabra escogerTipoPalabra(){
        ArregloDatos tipos = obtenerTiposPalabra();
        TipoPalabra tipo = null;
        Integer opcion = 0;
        while(opcion<1 || opcion>tipos.cantidadElementos()){
            SalidaTerminal.consola("\nIngresa el numero de la opcion: \n");
            for(int pos=0;pos< tipos.cantidadElementos();pos++){
                SalidaTerminal.consola(((TipoPalabra)tipos.obtener(pos)).getIndice()+".- "+
                        ((TipoPalabra)tipos.obtener(pos)).getNombre()+"\n");
            }
            opcion = EntradaTerminal.consolaInteger();
        }
        return (TipoPalabra) tipos.obtener(opcion-1);
    }

    /**
     * Regresa un ArregloDatos con los tipos de palabras
     * @return Un ArregloDatos
     */
    private ArregloDatos obtenerTiposPalabra(){
        ArregloDatos arr = new ArregloDatos(TipoPalabra.values().length);
        arr.agregar(TipoPalabra.VERBO);
        arr.agregar(TipoPalabra.ADJETIVO);
        arr.agregar(TipoPalabra.SUSTANTIVO);
        arr.agregar(TipoPalabra.ADVERBIO);
        arr.agregar(TipoPalabra.PREPOSICION);
        return arr;
    }

    @Override
    public void imprimirDiccionario(){
        for(int posicion=0;posicion<diccionario.cantidadElementos();posicion++){
            SalidaTerminal.consola(((Palabra)diccionario.obtener(posicion)).toStringObjeto()+ "\n");
        }
    }

    @Override
    public void buscarTipo(TipoPalabra opcionTipo){
        int contador = 0;
        while(contador < diccionario.cantidadElementos()){
            if(Herramientas.compararObjetos(((TipoPalabra)((Palabra)diccionario.obtener(contador)).tipo).getNombre(),
                    opcionTipo.getNombre()) == 0){
                SalidaTerminal.consola(((Palabra)diccionario.obtener(contador)).toStringObjeto()+"\n");
            }
            contador++;
        }
    }

    @Override
    public void buscarCoincidencias(String info){
        int terminos = info.length();
        for(int pos=0;pos<diccionario.cantidadElementos();pos++){
            int igual = 0;
            for(int posicion=0;posicion<terminos;posicion++){
                if(Herramientas.compararObjetos(((Palabra)diccionario.obtener(pos)).nombre.charAt(posicion),
                        info.charAt(posicion)) == 0){
                    igual++;
                }else{
                    break;
                }
            }
            if(igual == terminos){
                SalidaTerminal.consola(((Palabra)diccionario.obtener(pos)).toStringObjeto()+"\n");
            }
        }
    }
}
