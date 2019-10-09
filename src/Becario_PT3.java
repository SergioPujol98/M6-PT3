import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		
		//Aqui comprobamos si el arhcivo que contendra el becario esta creado o no, en caso de que lo este, lo borramos y creamos otro nuevo.
		if (f.exists()) {
			System.out.println("Se ha borrado el archivo");
			System.out.println();
			f.delete();
		}

		boolean falso = false;
		while (!falso) {
			System.out.println("Escoge una de las siguientes opciones: ");
			System.out.println();
			System.out.println("1. Introducir datos de nuevo becario");
			System.out.println("2. Obtener lista  de datos");
			System.out.println("3. Backup");
			System.out.println("4. Salir");
			System.out.println();

			//Comprobamos si ha introducido el valor pedido correctamente.
			if (n1.hasNextInt()) {
				eleccion = n1.nextInt();
			} else {
				System.out.println("Introduzca un valor correcto");
			}

			switch (eleccion) {
			case 1:
				//He creado un metodo para cada parametro que pedimos en el formulario, cada metodo contiene la comprobacion pertinente, estan situados en la parte baja del codigo.
				//A su vez, cuando ya hemos comprobado que el valor ha sido introducido correctamente, lo ponemos en el fichero binario y hacemos un salto de linea para que quede ordenado.
				rf.writeChars(nombre());
				rf.writeChars("\n");
				rf.writeChars(sexo());
				rf.writeChars("\n");
				rf.writeInt(edad());
				rf.writeChars("\n");
				rf.writeInt(suspensos());
				rf.writeChars("\n");
				rf.writeChars(residencia());
				rf.writeChars("\n");
				rf.writeInt(ingresos());
				break;

			case 2:
				rf.seek(0);
				int pos = 0;
				
				//Aqui voy leyendo linea por linea los datos  contenidos dentro del archivo binario y lo muestro.
				System.out.println("Nombre: " + rf.readLine());
				pos = (int) rf.getFilePointer();
				rf.seek(pos);
				System.out.println("Sexo: " + rf.readLine());
				pos = (int) rf.getFilePointer();
				rf.seek(pos);
				System.out.println("Edad: " + rf.readInt());
				rf.readLine();
				pos = (int) rf.getFilePointer();
				rf.seek(pos);
				System.out.println("Suspensos: " + rf.readInt());
				rf.readLine();
				pos = (int) rf.getFilePointer();
				rf.seek(pos);
				System.out.println("Residencia: " + rf.readLine());
				pos = (int) rf.getFilePointer();
				rf.seek(pos);
				System.out.println("Ingresos: " + rf.readInt());
				
				break;
				
			case 3:
				
				//Aqui hacemos el backup del archivo binario creando otro binario y pegando todo lo que hay en el primero. Lo hacemos reccoriendo el primero y pegandolo con saltos de linea en el segundo para que quede igual o similar.
				File f2 = new File("becadadesCopia.dat");
				RandomAccessFile rf2 = new RandomAccessFile(f2, "rw");
				String linea = null;
				pos = 0;
				while (rf.readLine() != null) {
					rf.seek(pos);
					linea = rf.readLine();
					pos = (int) rf.getFilePointer();
					rf2.writeChars("\n"+linea);
					
				}
				break;
			case 4:
				System.out.println("Has salido correctamente del programa");
				falso = true;
				System.exit(0);
				
			default:
				throw new IllegalArgumentException("Valor erroneo: " + eleccion);
			}
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

	public static String sexo() {
		Scanner n1 = new Scanner(System.in);
		boolean falso = false;
		while (!falso) {
			System.out.println("\nSexo del becario? H/M");
			String sexo = n1.next();
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

	public static int edad() {
		Scanner n1 = new Scanner(System.in);
		boolean falso = false;
		while (!falso) {
			System.out.println("\nEdad ");
			if (n1.hasNextInt()) {
				int edad = n1.nextInt();
				if (edad >= 20 && edad <= 60) {
					System.out.println("Edad valida");
					falso = true;
					return edad;
				} else {
					System.out.println("Fuera del rango de edad permitido");
					
				}
			} else {
				System.out.println("El valor introducido no es correcto");
				n1.nextLine();
			}
		}
		return 0;
	}

	public static int suspensos() {
		Scanner n1 = new Scanner(System.in);
		boolean falso = false;
		while (!falso) {
			System.out.println("\nNumero de suspensos");

			if (n1.hasNextInt()) {
				int susp = n1.nextInt();
				if (susp >= 0 && susp <= 4) {
					System.out.println("Introduccion de datos valida");
					falso = true;
					return susp;
				} else {
					System.out.println("Fuera del rango de edad permitido");
					
				}
			} else {
				System.out.println("El valor introducido no es correcto");
				n1.nextLine();
			}
		}
		return 0;
	}

	public static String residencia() {
		Scanner n1 = new Scanner(System.in);
		boolean falso = false;
		while (!falso) {
			System.out.println("\nResidencia familiar? Si/No");
			String residencia = n1.next();
			if (residencia.equalsIgnoreCase("si") || residencia.equalsIgnoreCase("no")) {
				System.out.println("Dato introducido correctamente");
				falso = true;
				return residencia;
			} else {
				System.out.println("Dato no introducido correctamente");
				residencia = null;
			}
		}
		return null;
	}

	public static int ingresos() {
		Scanner n1 = new Scanner(System.in);
		boolean falso = false;
		while (!falso) {
			System.out.println("\nIngresos familiares anuales");
			if (n1.hasNextInt()) {
				int ingresos = n1.nextInt();
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
