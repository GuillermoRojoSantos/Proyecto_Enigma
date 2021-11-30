import java.util.Scanner;

public class MáquinaEnigma {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la fraase que quiera codificar");
        String cadena= sc.nextLine();
        System.out.println("Introduzca número");;
        int valor = sc.nextInt();
        char resultado=' ';
        //Rotor A: Pasada uno : Codificación Directa 3
        for (int i=0; i<cadena.length();i++){


        }
        System.out.println(cadena);
    }
    public static char Cifrardor (char letra, int valor) {

        int codigo=(int)letra;
        int desplazamiento = codigo+valor%95;
        int resultado;
        if (desplazamiento>126) resultado=desplazamiento-95;
        else resultado=desplazamiento;
        return (char)resultado;


    }
}
