import java.util.Scanner;

public class MáquinaEnigma {
    public static void main(String[] args) {
       int opcionMenu = 1;
       while (opcionMenu!=4) {
           ImprimirMenu();
           opcionMenu = LeerEntada();
           switch (opcionMenu) {
               case 1:
                   //aquí iria el encriptadoR
                   ModuloEncriptarEnigma();
                   break;
               case 2:
                   //aquí iría el desencriptadoR
                   ModuloDesencriptarEnigma();
                   break;
               case 3:
                   //y aquí iría el código para romper la máquina enigma
                   ModuloRomperEnigma();
                   break;
               case 4:
                   System.out.println("Gracias por usar este programa!");
                   break;
               default:
                   System.out.println("Opción no valida, vuelva a intentarlo");
           }
           System.out.println();
           System.out.println("Pulse Enter para continuar.");
           esperarPulsacion();
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
        System.out.println();
        System.out.println("3. Romper la Máquina Enigma: A partir de unas   ");
        System.out.println("   palabras introducida, el programa buscará la ");
        System.out.println("   posición de cada rotor si encuentra una coin-");
        System.out.println("   cidencia con alguna palabra introducida.");
        System.out.println("   (¡ANTES DE USAR LA OPCIÓN 3 CAMBIE EL ARRAY  ");
        System.out.println("   Y PONGA LAS PALABRAS QUE QUIERA BUSCAR!)");
        System.out.println();
        System.out.println("4. Salir del menú.");
        System.out.println("************************************************");
    }
    public static int LeerEntada(){
        Scanner sc = new Scanner(System.in);
        int numero=sc.nextInt();
        return numero;
    }
    public static void esperarPulsacion() {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
    public static void ModuloEncriptarEnigma(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Cadena: ");
        String cadena = sc.nextLine();
        esperarPulsacion();
        System.out.println();
        System.out.println("Rotor1");
        int rt1 = sc.nextInt();
        //esperarPulsacion();
        System.out.println();
        System.out.println("Rotor2");
        int rt2 = sc.nextInt();
        //esperarPulsacion();
        System.out.println();
        System.out.println("Rotor3");
        int rt3 = sc.nextInt();
        // esperarPulsacion();
        System.out.println();
        System.out.println("Rotor4");
        int rt4 = sc.nextInt();
        // esperarPulsacion();
        System.out.println();
        String rotor1,rotor2,rotor3,rotor4;

        rotor1=Rotor1Encriptar(cadena,rt1);
        rotor2=Rotor2Encriptar(rotor1,rt2);
        rotor3=Rotor3Encriptar(rotor2,rt3);
        rotor4=Rotor4Encriptar(rotor3,rt4);

        System.out.println(rotor4);
    }
    public static void ModuloDesencriptarEnigma(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Cadena: ");
        String cadena = sc.nextLine();
        esperarPulsacion();
        System.out.println();
        System.out.println("Rotor1");
        int rt1 = sc.nextInt();
        //esperarPulsacion();
        System.out.println();
        System.out.println("Rotor2");
        int rt2 = sc.nextInt();
        //esperarPulsacion();
        System.out.println();
        System.out.println("Rotor3");
        int rt3 = sc.nextInt();
        // esperarPulsacion();
        System.out.println();
        System.out.println("Rotor4");
        int rt4 = sc.nextInt();
        // esperarPulsacion();
        System.out.println();
        String rotor1,rotor2,rotor3,rotor4;

        rotor1=Rotor1Desencriptar(cadena,rt1);
        rotor2=Rotor2Desencriptar(rotor1,rt2);
        rotor3=Rotor3Desencriptar(rotor2,rt3);
        rotor4=Rotor4Desencriptar(rotor3,rt4);

        System.out.println(rotor4);
    }
    public static void ModuloRomperEnigma(){
        Scanner sc = new Scanner(System.in);
        String[] palabrasClave = { "radiotelegrama"};
        System.out.println("Introduzca la frase a romper");
        String frase = sc.nextLine();
        String resultadoRotor="";
        for (int i = 0; i <= 99; i++) {
            for(int m=0;m<=99;m++) {
                for(int n=0;n<=99;n++) {
                    for(int l=0;l<=99;l++) {
                        resultadoRotor=Rotor4Desencriptar(Rotor3Desencriptar(Rotor2Desencriptar(Rotor1Desencriptar(frase, i),m),n),l);

                        for(String clave:palabrasClave)


                            if(resultadoRotor.contains(clave)) {
                                System.out.println("Palabra clave encontrada: "+clave+" "+i+" "+m+" "+n+" "+l);
                                System.out.println(resultadoRotor);

                            }
                        }
                    }
                }
            }
    }
    public static String Rotor1Encriptar(String cadena, int numRotor) {
        int c = 0;
        String nueva = "";
        for (int i = 0; i < cadena.length(); i++) {
            int assciiValue = cadena.charAt(i);
            if (c < 3 && assciiValue >= 32 && assciiValue <= 126) {
                nueva = nueva + Cifrardor(cadena.charAt(i), numRotor);
            }else{
                nueva = nueva + cadena.charAt(i);
            }
            if (c == 5) {
                c = 0;
            }else {
                c++;
            }
        }
        return nueva;
    }
    public static String Rotor1Desencriptar(String cadena, int numRotor) {
        int c = 0;
        String nueva = "";
        for (int i = 0; i < cadena.length(); i++) {
            int assciiValue = cadena.charAt(i);
            if (c < 3 && assciiValue >= 32 && assciiValue <= 126) {
                nueva = nueva + Descifrar(cadena.charAt(i), numRotor);
            }else{
                nueva = nueva + cadena.charAt(i);
            }
            if (c == 5) {
                c = 0;
            }else {
                c++;
            }
        }
        return nueva;
    }
    public static String Rotor2Encriptar(String cadena, int numRotor){
        String fraseEncriptada = "";

        for (int i = 0; i <= cadena.length() - 1; i++) {
            int asciiValue = cadena.charAt(i);

            if (asciiValue >= 32 && asciiValue <= 126 && i % 2 == 0) {
                fraseEncriptada += Cifrardor(cadena.charAt(i), numRotor);
                numRotor += 11;
            } else {
                fraseEncriptada += cadena.charAt(i);
            }
        }

        return fraseEncriptada;
    }
    public static String Rotor2Desencriptar(String cadena, int numRotor){
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
        return fraseEncriptada;
    }
    public static String Rotor3Encriptar(String cadena, int numRotor){
        String fraseEncriptada="";
        for( int i=cadena.length()-1;i>=0;i--) {
            int asciiValue = cadena.charAt(i);
            if(i%2!=0 && asciiValue >= 32 && asciiValue <= 126) {
                fraseEncriptada+=Cifrardor(cadena.charAt(i),numRotor);
                numRotor+=23;
            }else {
                fraseEncriptada+=cadena.charAt(i);
            }


        }
        return fraseEncriptada;
    }
    public static String Rotor3Desencriptar(String cadena, int numRotor){
        String frasenueva =InvertirCadena(cadena);
        String frasedes = "";
        String fraseDef = "";
        if (cadena.length()%2==0) {
            for (int i=0;i<cadena.length();i++) {
                int asciiValue = frasenueva.charAt(i);
                if (asciiValue >= 32 && asciiValue <= 126 && i % 2 == 0) {
                    frasedes += Descifrar(frasenueva.charAt(i), numRotor);
                    numRotor += 23;
                } else {
                    frasedes += frasenueva.charAt(i);
                }
            }
        }else {
            for (int i=0;i<cadena.length();i++) {
                int asciiValue = frasenueva.charAt(i);
                if (asciiValue >= 32 && asciiValue <= 126 && i % 2 != 0) {
                    frasedes += Descifrar(frasenueva.charAt(i), numRotor);
                    numRotor += 23;
                } else {
                    frasedes += frasenueva.charAt(i);
                }
            }
        }
        for (int j = frasedes.length() - 1; j >= 0; j--) {
            fraseDef += frasedes.charAt(j);
        }
        return fraseDef;
    }
    public static String Rotor4Encriptar(String cadena, int numRotor){
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
        return nueva;
    }
    public static String Rotor4Desencriptar(String cadena, int numRotor){
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
        return nueva;
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
    public static String InvertirCadena (String cadena){
        String frasealreves="";
        for(int h=cadena.length()-1;h>=0;h--) {
            frasealreves += cadena.charAt(h);
        }
        return frasealreves;
    }


}
