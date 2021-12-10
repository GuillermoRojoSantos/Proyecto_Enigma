import java.util.*;

public class romperMaquina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		//String[] palabrasClave = {"Mancha"};

		System.out.println("Introduzca la frase a romper");
		String frase = sc.nextLine();
		String resultadoRotor="";

		for (int i = 0; i <= 99; i++) {
			
			for(int m=0;m<=99;m++) {
				for(int n=0;n<=99;n++) {
					for(int l=0;l<=99;l++) {
						resultadoRotor=descifrarRotor4(descifrarRotor3(descifrarRotor2(descifrarRotor1(frase, i),m),n),l);
						//for(String clave:palabrasClave)

					
						
						if(resultadoRotor.contains("Mancha")) {
							System.out.println("Palabra clave encontrada:  "+i+" "+m+" "+n+" "+l);
							System.out.println(resultadoRotor);
							
						}else {
							//System.out.println("Nada");
						}
						
					}
				}
				
			}
			
			
			
			
		}

	}

	public static char descifrar(char letra, int valor) {

		int codigo = (int) letra;
		int desplazamiento = codigo - valor % 95;
		int resultado;
		if (desplazamiento < 32)
			resultado = desplazamiento + 95;
		else
			resultado = desplazamiento;
		return (char) resultado;

	}

	public static String descifrarRotor1(String frase, int rotor) {
		int c = 0;
		String nueva = "";
		for (int i = 0; i < frase.length(); i++) {
			int assciiValue = frase.charAt(i);
			if (assciiValue >= 32 && assciiValue <= 126) {
				while (c < 3) {
					nueva = nueva + descifrar(frase.charAt(i), rotor);
					// System.out.println(nueva);
					break;
				}
				while (c >= 3) {
					nueva = nueva + frase.charAt(i);
					// System.out.println(nueva2);
					break;
				}
			} else {
				nueva += frase.charAt(i);
			}
			c++;
			if (c == 6) {
				c = 0;

			}

		}
		//System.out.println("Das frasen desencriptaren ist: ");
		//System.out.println(nueva);
		return (String) nueva;
	}

	public static String descifrarRotor2(String frase, int rotor) {
		String fraseEncriptada = "";

		for (int i = 0; i <= frase.length() - 1; i++) {
			int asciiValue = frase.charAt(i);

			if (asciiValue >= 32 && asciiValue <= 126 && i % 2 == 0) {
				fraseEncriptada += descifrar(frase.charAt(i), rotor);
				rotor += 11;
			} else {
				fraseEncriptada += frase.charAt(i);

			}

		}
		//System.out.println(fraseEncriptada);
		return (String) fraseEncriptada;
	}

	public static String descifrarRotor3(String frase, int rotor) {
		Scanner sc = new Scanner(System.in);
		//System.out.println("Intoduzca la frase a descifrar");

		String frasenueva = frasedesreves(frase);
		String frasedes = "";

		String fraseDef = "";

		for (int i = frasenueva.length() - 1; i >= 0; i--) {
			int asciiValue = frasenueva.charAt(i);

			if (asciiValue >= 32 && asciiValue <= 126 && i % 2 != 0) {

				frasedes += descifrar(frasenueva.charAt(i), rotor);
				rotor += 23;

			} else {
				frasedes += frasenueva.charAt(i);
			}

		}

		for (int j = frasedes.length() - 1; j >= 0; j--) {
			fraseDef += frasedes.charAt(j);

		}
		//System.out.println(fraseDef);

		return (String) fraseDef;

	}

	public static String frasedesreves(String frase) {
		String frasealreves = "";
		for (int h = frase.length() - 1; h >= 0; h--) {
			frasealreves += frase.charAt(h);

		}
		return frasealreves;
	}

	public static String descifrarRotor4(String frase, int valor) {
		int c = 0;
		String nueva = "";
		for (int i = 0; i < frase.length(); i++) {
			int asciiValue = frase.charAt(i);
			while (c < 5) {
				if (asciiValue>=32 && asciiValue<=126) {
					nueva = nueva + descifrar(frase.charAt(i), valor);
				}else{
					nueva = nueva + frase.charAt(i);
				}
				break;
			}
			while (c >= 5) {
				nueva = nueva + frase.charAt(i);

				break;
			}
			c++;
			if (c == 10) {
				c = 0;

			}

		}

		String fraseReves = FraseAlRevesPrograma(nueva);
		//System.out.println(fraseReves);
		return (String) fraseReves;
	}

	public static String FraseAlRevesPrograma(String frase) {
		String fraseReves = "";
		for (int i = frase.length() - 1; i >= 0; i--) {
			fraseReves = fraseReves + frase.charAt(i);
		}
		return fraseReves;
	}

}
