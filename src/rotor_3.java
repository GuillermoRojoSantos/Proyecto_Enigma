import java.util.*;

public class rotor_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al Rotor 3");
		System.out.println("Introduzca una frase:");
		String cadena = sc.nextLine();

		System.out.println("Pulse E para encriptar o D para desencriptar ");
		String boton = sc.nextLine().toLowerCase();

		if (boton.charAt(0) == 'e') {
			String fraseEncriptada = Rotor3Encriptar(cadena, 85);
			System.out.println("La frase encriptada es:");
			System.out.println(fraseEncriptada);
		} else if (boton.charAt(0) == 'd') {
			String fraseDesencriptada = Rotor3Desencriptar(cadena, 85);
			System.out.println("La frase desencriptada es:");
			System.out.println(fraseDesencriptada);

		}
	}

	public static String Rotor3Encriptar(String cadena, int numRotor) {
		String fraseEncriptada = "";
		for (int i = cadena.length() - 1; i >= 0; i--) {
			int asciiValue = cadena.charAt(i);
			if (i % 2 != 0 && asciiValue >= 32 && asciiValue <= 126) {
				fraseEncriptada += Cifrardor(cadena.charAt(i), numRotor);
				numRotor += 23;
			} else {
				fraseEncriptada += cadena.charAt(i);
			}

		}
		return fraseEncriptada;

	}

	public static String Rotor3Desencriptar(String cadena, int numRotor) {
		String frasenueva = InvertirCadena(cadena);
		String frasedes = "";

		String fraseDef = "";
		for (int i = frasenueva.length() - 1; i >= 0; i--) {
			int asciiValue = frasenueva.charAt(i);

			if (asciiValue >= 32 && asciiValue <= 126 && i % 2 != 0) {

				frasedes += Descifrar(frasenueva.charAt(i), numRotor);
				numRotor += 23;

			} else {
				frasedes += frasenueva.charAt(i);
			}

		}

		for (int j = frasedes.length() - 1; j >= 0; j--) {
			fraseDef += frasedes.charAt(j);

		}

		return fraseDef;

	}

	public static String InvertirCadena(String cadena) {
		String frasealreves = "";
		for (int h = cadena.length() - 1; h >= 0; h--) {
			frasealreves += cadena.charAt(h);
		}
		return frasealreves;
	}

	public static char Cifrardor(char letra, int valor) {

		int codigo = (int) letra;
		int desplazamiento = codigo + valor % 95;
		int resultado;
		if (desplazamiento > 126)
			resultado = desplazamiento - 95;
		else
			resultado = desplazamiento;
		return (char) resultado;

	}

	public static char Descifrar(char letra, int valor) {

		int codigo = (int) letra;
		int desplazamiento = codigo - valor % 95;
		int resultado;
		if (desplazamiento < 32)
			resultado = desplazamiento + 95;
		else
			resultado = desplazamiento;
		return (char) resultado;

	}
}