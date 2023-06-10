package registros.ferreteria;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructuraslineales.ArregloOrden;
import herramientas.comunes.TipoOrden;
import herramientas.comunes.Herramientas;

public class Ferreteria implements IFerreteria{
    protected ArregloOrden catalogo;

    public Ferreteria(int tamanio){
        catalogo = new ArregloOrden(tamanio, TipoOrden.ASCENDENTE);
    }

    @Override
    public void menu(){
        Integer opcion = 0;
        while(opcion != MenuFerreteria.SALIR.getIndice()) {
            opcion = pedirOpcion();

            switch (opcion) {
                case 1:
                    SalidaTerminal.consola("Ingresa el nombre del prodcuto: ");
                    String nombre = EntradaTerminal.consolaCadena();
                    SalidaTerminal.consola("Ingresa la descripcion del producto: ");
                    String descripcion = EntradaTerminal.consolaCadena();
                    SalidaTerminal.consola("Ingresa el precio del producto: ");
                    Double precio = EntradaTerminal.consolaDouble();
                    SalidaTerminal.consola("Ingresa el numero de marcas del producto: ");
                    Integer marcas = EntradaTerminal.consolaInteger();
                    Producto p = new Producto(nombre,descripcion,precio,true,marcas);
                    while(marcas > 0){
                        SalidaTerminal.consola("Ingresa el nombre de la marca: ");
                        (p.marcas).agregar(EntradaTerminal.consolaCadena());
                        marcas--;
                    }
                    agregarProducto(p);
                    asignarPaginas();
                    break;

                case 2:
                    imprimirCatalogo();
                    break;

                case 3:
                    SalidaTerminal.consola("Ingresa el nombre de la marca: ");
                    String marca = EntradaTerminal.consolaCadena();
                    buscarProductoMarca(marca);
                    break;

                case 4:
                    SalidaTerminal.consola("Ingresa el texto a buscar en las definiciones: ");
                    String txt = EntradaTerminal.consolaCadena();
                    buscarProPalabraDescripcion(txt);
                    break;

                case 5:
                    int posicion = buscarProducto("eliminar");
                    if(posicion > 0){
                        eliminarProducto(posicion-1);
                    }
                    break;

                case 6:
                    int pos = buscarProducto("cambiar el precio");
                    if(pos > 0){
                        SalidaTerminal.consola("Ingresa el nuevo precio: ");
                        Double pre = EntradaTerminal.consolaDouble();
                        if(pre != null){
                            ((Producto)catalogo.obtener(pos-1)).setPrecio(pre);
                        }
                    }                    break;

                case 7:
                    int pr = buscarProducto("cambiar la descripcion");
                    if(pr > 0){
                        SalidaTerminal.consola("Ingresa la nueva descripcion: ");
                        String des = EntradaTerminal.consolaCadena();
                        ((Producto)catalogo.obtener(pr-1)).setDescripcion(des);
                    }
                    break;

                case 8:
                    SalidaTerminal.consola("Ingresa la pagina de inicio: ");
                    Integer p1 = EntradaTerminal.consolaInteger();
                    SalidaTerminal.consola("Ingresa la pagina de fin: ");
                    Integer p2 = EntradaTerminal.consolaInteger();
                    if(p1<p2){
                        productosEntrePaginas(p1,p2);
                    }
                    break;

                case 9:
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
        ArregloDatos menu = new ArregloDatos(9);
        menu.agregar(MenuFerreteria.AGREGAR);
        menu.agregar(MenuFerreteria.CONSULTAR);
        menu.agregar(MenuFerreteria.BUSCARMARCA);
        menu.agregar(MenuFerreteria.BUSPRODES);
        menu.agregar(MenuFerreteria.ELIMINAR);
        menu.agregar(MenuFerreteria.CAMBIARPRECIO);
        menu.agregar(MenuFerreteria.CAMBIARDES);
        menu.agregar(MenuFerreteria.BUSCARPAGINAS);
        menu.agregar(MenuFerreteria.SALIR);
        Integer opcion = 0;
        while(opcion<1 || opcion>menu.cantidadElementos()){
            SalidaTerminal.consola("Ingresa el numero de la opcion: \n");
            for(int pos=0;pos<menu.cantidadElementos();pos++){
                SalidaTerminal.consola(((MenuFerreteria)menu.obtener(pos)).getIndice()+".- "+
                        ((MenuFerreteria)menu.obtener(pos)).getNombre()+"\n");
            }
            opcion = EntradaTerminal.consolaInteger();
        }
        return opcion;
    }

    @Override
    public boolean agregarProducto(Producto p){
        if(catalogo.agregar(p)!=-1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void asignarPaginas(){
        for(int pos=0;pos<catalogo.cantidadElementos();pos++){
            int mul = 2;
            int pag = 1;
            while(mul<=(pos+1)){
                pag++;
                mul+=2;
            }
            ((Producto)catalogo.obtener(pos)).setPagina(pag);
        }
    }

    @Override
    public void imprimirCatalogo(){
        for(int pos=0;pos<catalogo.cantidadElementos();pos++){
            SalidaTerminal.consola(((Producto)catalogo.obtener(pos)).toStringObjeto()+"\n");
        }
    }

    @Override
    public void buscarProductoMarca(String marca){
        for(int pos=0;pos<catalogo.cantidadElementos();pos++){
            Producto p = (Producto)catalogo.obtener(pos);
            for(int posi=0;posi<p.marcas.cantidadElementos();posi++){
                if(Herramientas.compararObjetos(p.marcas.obtener(posi),marca) == 0){
                    SalidaTerminal.consola(p.toStringObjeto()+"\n");
                    break;
                }
            }
        }
    }

    @Override
    public void buscarProPalabraDescripcion(String txt){
        for(int pos=0;pos< catalogo.cantidadElementos();pos++){
            Producto producto = (Producto) catalogo.obtener(pos);
            if(producto.getDescripcion().toLowerCase().contains(txt.toLowerCase())){
                SalidaTerminal.consola(producto.toStringObjeto()+"\n");
            }
        }
    }

    @Override
    public int buscarProducto(String accion){
        while(true){
            SalidaTerminal.consola("Ingresa el nombre del producto a "+accion+" (\"S\" para cancelar): ");
            String pro = EntradaTerminal.consolaCadena();
            Integer bus = (Integer) catalogo.buscar(pro);
            if(pro.equalsIgnoreCase("S")){
                return 0;
            }
            if(bus != null){
                if(bus > 0){
                    return bus;
                }else{
                    SalidaTerminal.consola("No encontrado\n");
                }
            }else{
                return 0;
            }
        }
    }

    @Override
    public void eliminarProducto(int posicion){
        catalogo.eliminar(posicion);
        asignarPaginas();
    }

    @Override
    public void productosEntrePaginas(int pag1,int pag2){
        for(int pos=0;pos<catalogo.cantidadElementos();pos++){
            Producto p = (Producto) catalogo.obtener(pos);
            if(p.pagina >= pag1 && p.pagina <= pag2){
                SalidaTerminal.consola(p.toStringObjeto());
            }
        }
    }
}
