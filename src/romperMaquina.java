import java.util.*;

public class romperMaquina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String[] palabrasClave = { "Dubrowki","Opotschka"};

		System.out.println("Introduzca la frase a romper");
		String frase = sc.nextLine();
		String resultadoRotor="";
		String rotor1,rotor2,rotor3,rotor4;

		rotor1=descifrarRotor1(frase,59);
		rotor2=descifrarRotor2(rotor1,31);
		rotor3=descifrarRotor3(rotor2,92);
		rotor4=descifrarRotor4(rotor3,87);

		System.out.println(rotor4);
		sc.nextLine();
		for (int i = 59; i <= 99; i++) {
			System.out.println(i);
			for(int m=29;m<=99;m++) {
				System.out.print(m+" ");
				for(int n=0;n<=99;n++) {

					for(int l=0;l<=99;l++) {

						resultadoRotor=descifrarRotor4(descifrarRotor3(descifrarRotor2(descifrarRotor1(frase, i),m),n),l);

						for(String clave:palabrasClave)


						if(resultadoRotor.contains(clave)) {
							System.out.println("Palabra clave encontrada: "+clave+i+" "+m+" "+n+" "+l);
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
			if (c < 3 && assciiValue >= 32 && assciiValue <= 126) {
				nueva = nueva + descifrar(frase.charAt(i), rotor);
				// System.out.println(nueva);
			}else{
				nueva = nueva + frase.charAt(i);
				// System.out.println(nueva2);
			}

			if (c == 5) {
				c = 0;

			}else {
				c++;
			}
		}
		//System.out.println("Das frasen desencriptaren ist: ");
		//System.out.println(nueva);
		return nueva;
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

		if (frase.length()%2==0) {
			for (int i=0;i<frase.length();i++) {
				int asciiValue = frasenueva.charAt(i);

				if (asciiValue >= 32 && asciiValue <= 126 && i % 2 == 0) {

					frasedes += descifrar(frasenueva.charAt(i), rotor);
					rotor += 23;

				} else {
					frasedes += frasenueva.charAt(i);
				}

			}
		}else {
			for (int i=0;i<frase.length();i++) {
				int asciiValue = frasenueva.charAt(i);

				if (asciiValue >= 32 && asciiValue <= 126 && i % 2 != 0) {

					frasedes += descifrar(frasenueva.charAt(i), rotor);
					rotor += 23;

				} else {
					frasedes += frasenueva.charAt(i);
				}

			}
		}


		for (int j = frasedes.length() - 1; j >= 0; j--) {
			fraseDef += frasedes.charAt(j);
		}
		//System.out.println(fraseDef);

		return fraseDef;

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
			int assciiValue = frase.charAt(i);

			if (c < 5 && assciiValue >= 32 && assciiValue <= 126) {
				nueva = nueva + descifrar(frase.charAt(i), valor);
			}else{
				nueva = nueva + frase.charAt(i);

			}
			if (c == 9) {
				c = 0;

			}else {
				c++;
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
