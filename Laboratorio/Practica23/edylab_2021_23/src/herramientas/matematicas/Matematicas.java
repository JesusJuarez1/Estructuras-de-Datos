package herramientas.matematicas;

/**
 * Clase que contiene metodos para realizar operaciones matematicas
 * @author Jesus
 * @version 1.0
 */
public class Matematicas {

    /**
     * Hace una multiplicacion del numero a por el numero b, utilizando recurcion
     * @param a Numero a multiplicar
     * @param b Numero por el cual se va multiplicar
     * @return El resultado de la operacion, null en caso de error
     */
    public static Double multiplicacion(double a, int b){
        if(b >= 0){
            if(b == 0){
                return 0.0;
            }else{
                return a+multiplicacion(a,b-1);
            }
        }else{
            return null;
        }
    }

    /**
     * Llama el metodo con el cual resolver la serie: 1-x^1/1!+x^3/3!-x^5/5!+x^7/7! … x^n/n! + n/m + n
     * @param x Valor que tomara X
     * @param n Maximo valor de n en la serie
     * @param m valor que tomara m en la serie
     * @return El valor que devuelva el metodo serieMas
     */
    public static Double serie(double x,int n,double m){
        if(n > 0){
            int cont = 1;
            return 1-serieMas(x,n,cont)+(n/m)+n;
        }else{
            return null;
        }
    }

    /**
     * Hace una operacion y le suma el sesultado del metodo serieMenos
     * @param x Valor de x en la serie
     * @param n Valor maximo de n en la sere
     * @param cont Contador para evaluar que sea menor a n
     * @return El valor de la operacion mas lo que regresa la serieMenos, una sola operacion si no es asi
     */
    private static Double serieMas(double x,int n,int cont){
        if(cont < n){
            return (Math.pow(x,cont)/factorial(cont))+serieMenos(x,n,cont+2);
        }else{
            return Math.pow(x,n)/factorial(n);
        }
    }

    /**
     * Hace una operacion y le resta el sesultado del metodo serieMas
     * @param x Valor de x en la serie
     * @param n Valor maximo de n en la sere
     * @param cont Contador para evaluar que sea menor a n
     * @return El valor de la operacion menos lo que regresa la serieMas, una sola operacion si no es asi
     */
    private static Double serieMenos(double x,int n,int cont){
        if(cont<=n){
            return (Math.pow(x,cont)/factorial(cont))-serieMas(x,n,cont+2);
        }else{
            return Math.pow(x,n)/factorial(n);
        }
    }

    /**
     * Saca el factorial de un numero dado
     * @param num numero a sacar el factorial
     * @return El resultado al sacar el factorial
     */
    public static int factorial(int num){
        if(num > 0){
            int resultado = 1;
            for(int i=2;i<=num;i++){
                resultado *= i;
            }
            return resultado;
        }else{
            return 0;
        }
    }

    /**
     * Convierte un numero a hexadecimal base 16
     * @param num numero a convertir
     * @return El numero en exadecimal
     */
    public static String aHexadecimal(int num) {
        String result = "";
        int residuo = num%16;
        if (num == 0) {
            return "";
        } else {
            switch (residuo) {
                case 10:
                    result = "A";
                    break;
                case 11:
                    result = "B";
                    break;
                case 12:
                    result = "C";
                    break;
                case 13:
                    result = "D";
                    break;
                case 14:
                    result = "E";
                    break;
                case 15:
                    result = "F";
                    break;
                default:
                    result = residuo + result;
                    break;
            }
            return aHexadecimal(num/16) + result;
        }
    }

    /**
     * Convierte un numero a hexadecimal base menor 10
     * @param num numero a convertir
     * @param base Base a la que se va a cambiar
     * @return El numero en exadecimal
     */
    public static String aHexadecimal(int num, int base) {
        String result = "";
        if(base<10 && base>1){
            int residuo = num%base;
            if (num == 0) {
                return "";
            } else {
                result = residuo + result;
                return aHexadecimal(num / base, base) + result;
            }
        }
        return "";
    }

    /**
     * Saca el maximo comun divisor de dos numeros
     * @param num1 numero 1
     * @param num2 numero 2
     * @return El maximo comun divisor, 0 en caso contrario
     */
    public static int euclides(int num1, int num2){
        if(num1 != num2 && num1>1 && num2>1){
            if(num1>num2){
                num1 -= num2;
            }else{
                num2 -= num1;
            }
            return euclides(num1,num2);
        }
        return num1;
    }

    /**
     * Convierte un numero a binario
     * @param num numero a convertir
     * @return El numero binario
     */
    public static String aBinario(int num){
        if(num>0){
            if(num%2 != 0){
                return aBinario(num/2)+1;
            }else{
                return aBinario(num/2)+0;
            }
        }
        return "";
    }
}
