import java.util.Scanner;

public class Rotor3 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce la frase del rotor C");

        String frase=sc.nextLine();
        String fraseEncriptada="";
        int rotorC=85;
        for( int i=frase.length()-1;i>=0;i--) {
            if(i%2!=0) {
                fraseEncriptada+=cifrar(frase.charAt(i),rotorC);
                rotorC+=23;
            }else {
                fraseEncriptada+=frase.charAt(i);
            }


        }
        System.out.println(fraseEncriptada);



    }

    public static char cifrar (char letra, int valor) {

        int codigo=(int)letra;
        int desplazamiento = codigo+valor%95;
        int resultado;
        if (desplazamiento>126) resultado=desplazamiento-95;
        else resultado=desplazamiento;
        return (char)resultado;
    }

    }

