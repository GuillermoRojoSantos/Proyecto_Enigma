import java.util.Scanner;

public class MáquinaEnigma {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        ImprimirMenu();

        int opcionMenu = sc.nextInt();
        switch (opcionMenu) {
            case 1:
                //aquí iria el encriptadoR





                break;
            case 2:
                //aquí iría el desencriptadoR
                break;

            case 3:
                //y aquí iría el código para romper la máquina enigmA
                break;

        }
    }
    public static void ImprimirMenu () {
        System.out.println("************************************************");
        System.out.println("                 Menú Enigma                    ");
        System.out.println("Elija una opción:");
        System.out.println("1. Encriptar: el programa codificara el texto");
        System.out.println("   que introduzca respecto al número de rotor");
        System.out.println("   especificado.");
        System.out.println();
        System.out.println("2. Desencriptar: el programa descifrara el texto");
        System.out.println("   que introduzca respecto al número de rotor");
        System.out.println("   especificado.");
        System.out.println("************************************************");
    }
    public static void Rotor1Encriptar(String cadena, int numRotor) {
        int c=0;
        String cadenaRotor1="";
        for (int i=0; i<cadena.length();i++) {
            int assciiValue = cadena.charAt(i);
            if (assciiValue>=32 && assciiValue<=126) {


                while (c < 3) {
                    cadenaRotor1 = cadenaRotor1 + Cifrardor(cadena.charAt(i), numRotor);
                    //System.out.println(nueva);
                    break;
                }
                while (c >= 3) {
                    cadenaRotor1 = cadenaRotor1 + cadena.charAt(i);
                    //System.out.println(nueva2);
                    break;
                }
            }else{
                cadenaRotor1 +=cadenaRotor1.charAt(i);
            }
            c++;
            if(c==6) {
                c=0;
            }
        }
        System.out.println("Das frasen encriptaren ist: ");
        System.out.println(cadenaRotor1);
    }
    public static void Rotor1Desencriptar(String cadena, int numRotor) {
        int c=0;
        String nueva="";
        for (int i=0; i<cadena.length();i++) {
            int assciiValue = cadena.charAt(i);
            if (assciiValue>=32 && assciiValue<=126) {
                while (c < 3) {
                    nueva = nueva + Descifrar(cadena.charAt(i), numRotor);
                    //System.out.println(nueva);
                    break;
                }
                while (c >= 3) {
                    nueva = nueva + cadena.charAt(i);
                    //System.out.println(nueva2);
                    break;
                }
            }else{
                nueva +=cadena.charAt(i);
            }
            c++;
            if(c==6) {
                c=0;

            }


        }
        System.out.println("Das frasen desencriptaren ist: ");
        System.out.println(nueva);
    }
    public static char Cifrardor (char letra, int valor) {

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
}
