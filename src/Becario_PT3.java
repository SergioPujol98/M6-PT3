import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Becario_PT3 {
	public static void main(String[] args) throws IOException {
		// Primero creamos el fichero binario.
		File f = new File("becadades.dat");
		RandomAccessFile rf = new RandomAccessFile(f, "rw");
		Scanner n1 = new Scanner(System.in);
		int eleccion = 0;

		System.out.println("1. Introducir datos de nuevo becario");
		System.out.println("2. Obtener lista  de datos");
		System.out.println("3. Backup");
		if (n1.hasNextInt()) {
			eleccion = n1.nextInt();
		} else {
			System.out.println("Introduzca un valor correcto");
		}

		switch (eleccion) {
		case 1:
			System.out.println(nombre());
			String sexo = null;
			sexo(sexo);
			int edad = 0;
			edad(edad);
			int suspensos = 0;
			suspensos(suspensos);
			String residencia = null;
			residencia(residencia);
			int ingresos = 0;
			ingresos(ingresos);
			
			break;

		case 2:
			
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + eleccion);
		}
	}

	public static String nombre() {
		Scanner n1 = new Scanner(System.in);
		boolean falso = false;
		while (!falso) {
			System.out.println("\nNombre y apellidos del becario");
			String nombre = n1.nextLine();

			for (int i = 0; i < nombre.length(); i++) {
				char caracter = nombre.toUpperCase().charAt(i);
				int valorASCII = (int) caracter;
				if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)) {
					System.out.println("El nombre no ha sido introducido correctamente");
					nombre = null;
				} else {
					System.out.println("Nombre introducido correctamente");
					falso = true;
					return nombre;
				}
			}
		}
		return nombre();
		

	}

	public static String sexo(String sexo) {
		Scanner n1 = new Scanner(System.in);
		boolean falso = false;
		while (!falso) {
			System.out.println("\nSexo del becario? H/M");
			sexo = n1.next();
			if (sexo.equalsIgnoreCase("H") || sexo.equalsIgnoreCase("M")) {
				System.out.println("Sexo introducido correctamente");
				falso = true;
				return sexo;
			} else {
				System.out.println("El sexo no ha sido introducido correctamente");
				sexo = null;
			}
		}
		return null;
	}

	public static int edad(int edad) {
		Scanner n1 = new Scanner(System.in);
		boolean falso = false;
		while (!falso) {
			System.out.println("\nEdad ");
			if (n1.hasNextInt()) {
				edad = n1.nextInt();
				if (edad >= 20 && edad <= 60) {
					System.out.println("Edad valida");
					falso = true;
					return edad;
				} else {
					System.out.println("Fuera del rango de edad permitido");
					break;
				}
			} else {
				System.out.println("El valor introducido no es correcto");
				n1.nextLine();
			}
		}
		return 0;
	}

	public static int suspensos(int susp) {
		Scanner n1 = new Scanner(System.in);
		boolean falso = false;
		while (!falso) {
			System.out.println("\nNumero de suspensos");
			susp = n1.nextInt();
			if (n1.hasNextInt()) {
				if (susp >= 0 && susp <= 4) {
					System.out.println("Introduccion de datos valida");
					falso = true;
					return susp;
				} else {
					System.out.println("Fuera del rango de edad permitido");
					break;
				}
			} else {
				System.out.println("El valor introducido no es correcto");
				n1.nextLine();
			}
		}
		return 0;
	}

	public static String residencia(String residencia) {
		Scanner n1 = new Scanner(System.in);
		boolean falso = false;
		while (!falso) {
			System.out.println("\nResidencia familiar? Y/N");
			residencia = n1.next();
			if (residencia.equalsIgnoreCase("Y") || residencia.equalsIgnoreCase("N")) {
				System.out.println("Dato introducido correctamente");
				falso = true;
			} else {
				System.out.println("Dato no introducido correctamente");
				residencia = null;
			}
		}
		return null;
	}

	public static int ingresos(int ingresos) {
		Scanner n1 = new Scanner(System.in);
		boolean falso = false;
		while (!falso) {
			System.out.println("\nIngresos familiares anuales");
			if (n1.hasNextInt()) {
				ingresos = n1.nextInt();
				falso = true;
				return ingresos;
			} else {
				System.out.println("Valor no introducido correctamente, vuelva a introducirlo");
				n1.nextLine();
			}
		}
		return 0;
	}

}
