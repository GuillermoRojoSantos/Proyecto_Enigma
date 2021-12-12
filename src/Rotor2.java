import java.util.Scanner;

public class Rotor2{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduzquen eine frasen paren encriptaren or desencriptaren: ");
        String cadena= sc.nextLine();//la cadena introducida
        System.out.println("Escojen valoren das rotoren: ");
        int valor=sc.nextInt();
        System.out.println("Elija si quieren Encriptaren (E) o Desencriptaren (D)");
        char encriptOption=sc.next().charAt(0);
        int c=0;
        if (encriptOption=='E'|| encriptOption=='e') {
            Rotor2Encriptar(cadena, valor);
        }
        if (encriptOption=='D' || encriptOption=='d') {
            Rotor2Desencriptar(cadena, valor);
        }
    }

    public static void Rotor2Encriptar(String cadena, int numRotor){
        String fraseEncriptada = "";

        for (int i = 0; i <= cadena.length()-1; i++) {
            int asciiValue = cadena.charAt(i);

            if (asciiValue >= 32 && asciiValue <= 126 && i % 2 == 0) {
                fraseEncriptada += Cifrador(cadena.charAt(i), numRotor);
                numRotor += 11;
            } else {
                fraseEncriptada += cadena.charAt(i);
            }
        }
        System.out.println("Das frasen encriptaren ist:");
        System.out.println(fraseEncriptada);
    }
    public static void Rotor2Desencriptar(String cadena, int numRotor){
        String fraseEncriptada = "";
        for (int i = 0; i <= cadena.length() - 1; i++) {
            int asciiValue = cadena.charAt(i);
            if (asciiValue >= 32 && asciiValue <= 126 && i % 2 == 0) {
                fraseEncriptada += Descifrar(cadena.charAt(i), numRotor);
                numRotor += 11;
            } else {
                fraseEncriptada += cadena.charAt(i);
            }
        }
        System.out.println("Das frasen desencriptaren ist:");
        System.out.println(fraseEncriptada);
    }
    public static char Cifrador(char letra, int valor) {

        int codigo = (int) letra;
        int desplazamiento = codigo + valor % 95;
        int resultado;
        if (desplazamiento > 126) resultado = desplazamiento - 95;
        else resultado = desplazamiento;
        return (char) resultado;


    }
    public static char Descifrar (char letra, int valor) {


        int codigo=(int)letra;
        int desplazamiento = codigo-valor%95;
        int resultado;
        if (desplazamiento<32) resultado=desplazamiento+95;
        else resultado=desplazamiento;
        return (char)resultado;

    }
}

