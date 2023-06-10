import java.io.*;

public class Funcion{
	public static void main(String[] args) {
		//int m = consolaInteger();
		//int n = consolaInteger();
		//System.out.println(A(m,n));

		System.out.println(f(6));
	}
	public static int A(int m, int n){
		if(m > 0 && n == 0){
			return A(m-1,1);
		}else if(m > 0 && n > 0){
			return A(m-1,A(m,n-1));
		}else{
			return n+1;
		}
	}

	public static Integer consolaInteger() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(isr);
        int cadenaEntrada=0;
        try {
            cadenaEntrada = Integer.parseInt(buffer.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            return cadenaEntrada;
        }
    }

    public static int f(int x){
    	if(x > 11){
    		return x;
    	}else{
    		int r = f(x+2);
    		return f(r+r);
    	}
    }
}