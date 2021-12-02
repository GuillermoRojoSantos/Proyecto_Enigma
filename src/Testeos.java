import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Testeos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte cadena");
        String cadena =sc.nextLine();
        String resultado="";
        for (int i=0; i<cadena.length(); i++){
            int assciiValue = cadena.charAt(i);
            if (assciiValue>=32 && assciiValue<=126){
                resultado+=cadena.charAt(i);
            }
        }
        System.out.println(resultado);
    }
}
