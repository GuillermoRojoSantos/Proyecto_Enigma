import java.util.Collections;
import java.util.Scanner;
public class Rotor_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduzquen eine frasen paren encriptaren or desencriptaren: ");
		String cadena= sc.nextLine();//la cadena introducida
		System.out.println("Escojen valoren das rotoren: ");
		int valor=sc.nextInt();
		System.out.println("Elija si quieren Encriptaren (E) o Desencriptaren (D)");
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
		for (int i=0; i<cadena.length();i++) {
			while(c<3) {
				nueva=nueva+Cifrardor(cadena.charAt(i), valor);
				//System.out.println(nueva);
				break;
			}
			while(c>=3) {
				nueva=nueva+cadena.charAt(i);
				//System.out.println(nueva2);
				break;
			}
			c++;
			if(c==6) {
				c=0;
			}
		}
		System.out.println("Das frasen encriptaren ist: ");
		System.out.println(nueva);
	}
	public static void Desencriptar(String cadena, int valor) {
		int c=0;
		String nueva="";
		for (int i=0; i<cadena.length();i++) {
			while(c<3) {
				nueva=nueva+Descifrar(cadena.charAt(i), valor);
				//System.out.println(nueva);
				break;
			}
			while(c>=3) {
				nueva=nueva+cadena.charAt(i);
				//System.out.println(nueva2);
				break;
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
