import java.util.Scanner;
public class Rotor_4 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduzquen eine frasen paren encriptaren or desencriptaren: ");
        String cadena= sc.nextLine();
        System.out.println("Escojen valoren das rotoren: ");
        int valor=sc.nextInt();

        System.out.println("Elija si quieren Encriptaren (E) o Desencriptaren (D)");
        char encriptOption=sc.next().charAt(0);
        int c=0;
        if (encriptOption=='E'|| encriptOption=='e') {
            Rotor4Encriptar(cadena, valor);
        }
        if (encriptOption=='D' || encriptOption=='d') {
            Rotor4Desencriptar(cadena, valor);
        }
    }

    public static void Rotor4Encriptar(String cadena, int valor) {
        int c=0;
        String nueva="";
        String fraseReves = InvertirCadena(cadena);
        for (int i = 0; i < fraseReves.length(); i++) {
            int assciiValue = fraseReves.charAt(i);

            if (c < 5 && assciiValue >= 32 && assciiValue <= 126) {
                nueva = nueva + Cifrar(fraseReves.charAt(i), valor);
            }else{
                nueva = nueva + fraseReves.charAt(i);
            }
            if (c == 9) {
                c = 0;
            }else {
                c++;
            }
        }
        System.out.println("Das frasen encriptaren ist:");
        System.out.println(nueva);
    }
    public static void Rotor4Desencriptar(String cadena, int valor) {
        int c = 0;
        String nueva = "";
        for (int i = 0; i < cadena.length(); i++) {
            int assciiValue = cadena.charAt(i);
            if (c < 5 && assciiValue >= 32 && assciiValue <= 126) {
                nueva = nueva + Descifrar(cadena.charAt(i), valor);
            }else{
                nueva = nueva + cadena.charAt(i);
            }
            if (c == 9) {
                c = 0;
            }else {
                c++;
            }
        }
        String fraseReves = InvertirCadena(nueva);
        System.out.println("Das frasen desencriptaren ist:");
        System.out.println(fraseReves);
    }
    public static char Cifrar (char letra, int valor) {

        int codigo=(int)letra;
        int desplazamiento = codigo+valor%95;
        int resultado;
        if (desplazamiento>126) resultado=desplazamiento-95;
        else resultado=desplazamiento;
        return (char)resultado;


    }
    public static char Descifrar (char letra, int valor) {

        int codigo=(int)letra;
        int desplazamiento = codigo-valor%95;
        int resultado;
        if (desplazamiento<32) resultado=desplazamiento+95;
        else resultado=desplazamiento;
        return (char)resultado;

    }
    public static String InvertirCadena (String cadena){
        String frasealreves="";
        for(int h=cadena.length()-1;h>=0;h--) {
            frasealreves += cadena.charAt(h);
        }
        return frasealreves;
    }





}

