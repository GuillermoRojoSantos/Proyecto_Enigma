import java.util.Scanner;

public class Rotor2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la frase");
        String frase = sc.nextLine();
        String fraseNueva= "";
        int RotorB = 21;
        for (int i = 0;i<frase.length();i++){
            if (i %2==0){
                fraseNueva += Cifrar(frase.charAt(i),RotorB);
                RotorB +=11;
            }else{
                fraseNueva+=frase.charAt(i);
            }

        }
        System.out.println(fraseNueva);


    }
    public static char Cifrar(char letra, int valor) {

        int codigo = (int) letra;
        int desplazamiento = codigo + valor % 95;
        int resultado;
        if (desplazamiento > 126) resultado = desplazamiento - 95;
        else resultado = desplazamiento;
        return (char) resultado;


    }
}

