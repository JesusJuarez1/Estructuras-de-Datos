package pruebas;

import estructuraslineales.ArregloOrden;
import estructuraslineales.TipoOrden;
import registros.ferreteria.Ferreteria;
import registros.ferreteria.Producto;

public class PruebaFerreteria {
    public static void main(String[] args) {
        Ferreteria ferr = new Ferreteria(30);//Tamaño definido de 30
        //--------------------------------------
        //Prodcutos por defecto para mejor facilidad de manejo

        ArregloOrden p1 = new ArregloOrden(2, TipoOrden.ASCENDENTE);
        p1.agregar("Marca1");
        p1.agregar("Marca2");
        ferr.agregarProducto(new Producto("Martillo","Martillo con mango",50.50,true,p1));
        ArregloOrden p2 = new ArregloOrden(1, TipoOrden.ASCENDENTE);
        p2.agregar("Marca3");
        ferr.agregarProducto(new Producto("Motosierra","Motosierra chica",2450.50,true,p2));
        ArregloOrden p3 = new ArregloOrden(3, TipoOrden.ASCENDENTE);
        p3.agregar("Marca3");
        p3.agregar("Marca2");
        p3.agregar("Marca4");
        ferr.agregarProducto(new Producto("Pala","Pala mediana",289.00,true,p3));
        ArregloOrden p4 = new ArregloOrden(2, TipoOrden.ASCENDENTE);
        p4.agregar("Marca5");
        p4.agregar("Marca1");
        ferr.agregarProducto(new Producto("Carretilla","Carretilla grande",245.50,true,p4));
        ArregloOrden p5 = new ArregloOrden(4, TipoOrden.ASCENDENTE);
        p5.agregar("Marca5");
        p5.agregar("Marca1");
        p5.agregar("Marca3");
        p5.agregar("Marca4");
        ferr.agregarProducto(new Producto("Taladro","Taladro",999.99,true,p5));
        //------------------------


        ferr.menu();
    }
}
