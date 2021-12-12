import java.util.Scanner;
public class Rotor_4 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduzca una frase para encriptar: ");
        String cadena= sc.nextLine();
        System.out.println("Escoja valor del rotor: ");
        int valor=sc.nextInt();

        System.out.println("Elija si quiere Encriptar (E) o Desencriptar (D)");
        char encriptOption=sc.next().charAt(0);
        int c=0;
        if (encriptOption=='E'|| encriptOption=='e') {
            Encriptar(cadena, valor);
        }
        if (encriptOption=='D' || encriptOption=='d') {
            Desencriptar(cadena, valor);
        }
    }
    public static void Encriptar(String cadena, int valor) {
        int c=0;
        String nueva="";
        String fraseReves = InvertirCadena(cadena);
        for (int i = 0; i < fraseReves.length(); i++) {
            int assciiValue = fraseReves.charAt(i);

            if (c < 5 && assciiValue >= 32 && assciiValue <= 126) {
                nueva = nueva + Cifrardor(fraseReves.charAt(i), numRotor);
            }else{
                nueva = nueva + fraseReves.charAt(i);

            }
            if (c == 9) {
                c = 0;

            }else {
                c++;
            }


        }

        System.out.println(nueva);


    }
    public static void Desencriptar(String cadena, int valor) {
       int c = 0;
        String nueva = "";
        for (int i = 0; i < cadena.length(); i++) {
            int assciiValue = cadena.charAt(i);
            if (c < 5 && assciiValue >= 32 && assciiValue <= 126) {
                nueva = nueva + Descifrar(cadena.charAt(i), numRotor);
            }else{
                nueva = nueva + cadena.charAt(i);
            }
            if (c == 9) {
                c = 0;
            }else {
                c++;
            }
        }


        }


        String fraseReves = FraseAlRevesPrograma(nueva);
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

    public static String FraseAlRevesPrograma(String cadena) {
        String fraseReves = "";
        for(int i=cadena.length()-1;i>=0;i--) {
            fraseReves = fraseReves + cadena.charAt(i);
        } return fraseReves;
    }





}

