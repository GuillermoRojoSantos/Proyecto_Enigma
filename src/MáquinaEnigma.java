import java.util.Scanner;
import java.util.SplittableRandom;

public class MáquinaEnigma {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        ImprimirMenu();



       int opcionMenu = sc.nextInt();
        switch (opcionMenu) {
            case 1:
                //aquí iria el encriptadoR
                System.out.println("Cadena: ");
                String cadena = sc.nextLine();
                System.out.println();
                System.out.println("Rotor1");
                int rt1= sc.nextInt();
                System.out.println();
                System.out.println("Rotor2");
                int rt2= sc.nextInt();
                System.out.println();
                System.out.println("Rotor3");
                int rt3= sc.nextInt();
                System.out.println();
                System.out.println("Rotor4");
                int rt4= sc.nextInt();
                System.out.println();
                System.out.println(Rotor4Encriptar(Rotor3Encriptar(Rotor2Encriptar(Rotor1Encriptar(cadena,rt1),rt2),rt3),rt4));
                break;
            case 2:
                //aquí iría el desencriptadoR
                System.out.println("Cadena: ");
                String cadenad = sc.nextLine();
                System.out.println("Rotor1");
                int rt1d= sc.nextInt();
                System.out.println("Rotor2");
                int rt2d= sc.nextInt();
                System.out.println("Rotor3");
                int rt3d= sc.nextInt();
                System.out.println("Rotor4");
                int rt4d= sc.nextInt();
                System.out.println();
                System.out.println(Rotor4Desencriptar(Rotor3Desencriptar(Rotor2Desenciptar(Rotor1Desencriptar(cadenad,rt1d),rt2d),rt3d),rt4d));
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
        System.out.println();
        System.out.println("3. Romper la Máquina Enigma: A partir de unas   ");
        System.out.println("   palabras introducida, el programa buscará la ");
        System.out.println("   posición de cada rotor si encuentra una coin-");
        System.out.println("   cidencia con alguna palabra introducida.");
        System.out.println("************************************************");
    }
    public static String Rotor1Encriptar(String cadena, int numRotor) {
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
       return cadenaRotor1;
    }
    public static String Rotor1Desencriptar(String cadena, int numRotor) {
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

        return nueva;
    }
    public static String Rotor2Encriptar(String cadena, int numRotor){
        String frase = cadena;
        String fraseNueva= "";
        for (int i = 0;i<frase.length();i++){
            if (i %2==0){
                fraseNueva += Cifrardor(frase.charAt(i),numRotor);
                numRotor +=11;
            }else{
                fraseNueva+=frase.charAt(i);
            }
        }
       return fraseNueva;
    }
    public static String Rotor2Desenciptar (String cadena, int numRotor){
        String frase = cadena;
        String fraseNueva= "";
        for (int i = 0;i<frase.length();i++){
            if (i %2==0){
                fraseNueva += Descifrar(frase.charAt(i),numRotor);
                numRotor +=11;
            }else{
                fraseNueva+=frase.charAt(i);
            }
        }
       return fraseNueva;
    }
    public static String Rotor3Encriptar(String cadena, int numRotor){
        Scanner sc= new Scanner (System.in);
        System.out.println("Introduce la frase del rotor C");
        String fraseEncriptada="";
        int rotorC=85;
        for( int i=cadena.length()-1;i>=0;i--) {
            if(i%2!=0) {
                fraseEncriptada+=Cifrardor(cadena.charAt(i),numRotor);
                rotorC+=23;
            }else {
                fraseEncriptada+=cadena.charAt(i);
            }


        }
        return fraseEncriptada;
    }
    public static String Rotor3Desencriptar(String cadena, int numRotor){
        String frasenueva = InvertirCadena(cadena);
        String frasedes="";
        String fraseDef="";
        int rotorC=85;
        for(int i=frasenueva.length()-1; i>=0;i--) {
            if(i%2!=0) {
                frasedes+=Descifrar(frasenueva.charAt(i),rotorC);
                rotorC+=23;


            }else {
                frasedes+=frasenueva.charAt(i);
            }

        }
        System.out.println(frasedes);

        for(int j=frasedes.length()-1;j>=0; j--) {
            fraseDef+=frasedes.charAt(j);

        }
        return fraseDef;




    }
    public static String Rotor4Encriptar(String cadena, int numRotor){
        int c=0;
        String nueva="";
        String fraseReves = InvertirCadena(cadena);
        for (int i=0; i<fraseReves.length();i++) {
            while(c<5) {
                nueva=nueva+Cifrardor(fraseReves.charAt(i), numRotor);
                break;
            }
            while(c>=5) {
                nueva=nueva+fraseReves.charAt(i);
                break;
            }
            c++;
            if(c==10) {
                c=0;

            }
        }
        return nueva;
    }
    public static String Rotor4Desencriptar(String cadena, int numRotor){
        int c=0;
        String nueva="";
        for (int i=0; i<cadena.length();i++) {
            while(c<5) {
                nueva=nueva+Descifrar(cadena.charAt(i), numRotor);
                break;
            }
            while(c>=5) {
                nueva=nueva+cadena.charAt(i);
                break;
            }
            c++;
            if(c==10) {
                c=0;

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
