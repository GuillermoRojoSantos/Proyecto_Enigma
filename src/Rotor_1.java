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
			Rotor1Encriptar(cadena, valor);
		}
		if (encriptOption=='D' || encriptOption=='d') {
			Rotor1Desencriptar(cadena, valor);
		}
	}

	public static void Rotor1Encriptar(String cadena, int valor) {
		int c = 0;
		String nueva = "";
		for (int i = 0; i < cadena.length(); i++) {
			int assciiValue = cadena.charAt(i);
			if (c < 3 && assciiValue >= 32 && assciiValue <= 126) {
				nueva = nueva + Cifrador(cadena.charAt(i), valor);
			}else{
				nueva = nueva + cadena.charAt(i);
			}
			if (c == 5) {
				c = 0;
			}else {
				c++;
			}
		}
		System.out.println("Das frasen encriptaren ist:");
		System.out.println(nueva);
	}
	public static void Rotor1Desencriptar(String cadena, int valor) {
		int c = 0;
		String nueva = "";
		for (int i = 0; i < cadena.length(); i++) {
			int assciiValue = cadena.charAt(i);
			if (c < 3 && assciiValue >= 32 && assciiValue <= 126) {
				nueva = nueva + Descifrar(cadena.charAt(i), valor);
			}else{
				nueva = nueva + cadena.charAt(i);
			}
			if (c == 5) {
				c = 0;
			}else {
				c++;
			}
		}
		System.out.println("Das frasen desencriptaren ist:");
		System.out.println(nueva);
	}
	public static char Cifrador (char letra, int valor) {

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
