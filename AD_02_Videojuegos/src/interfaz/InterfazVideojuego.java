package interfaz;

import java.util.Scanner;


import modelo.entidad.Videojuego;

import modelo.negocio.GestorVideojuego;

public class InterfazVideojuego {

	private GestorVideojuego gv = null;
	private Scanner scString = new Scanner(System.in);
	private Scanner sc = new Scanner(System.in);

	public void mostrarInterfaz() {
		System.out.println("Bienvenidos a nuestra app :)");
		Videojuego videojuego = null;
		gv = new GestorVideojuego();
		int respuesta = 0;

		int contador = 0;
		boolean validado = false;

		while (contador < 3 && !validado) {
			videojuego = pedirDatos();
			respuesta = gv.validarVideojuego(videojuego);
			switch (respuesta) {
			case 0:
				System.out.println("Videojuego no existe");
				break;
			case 1:
				System.out.println("Videojuego correcto, bienvenido a la app");
				validado = true;
				iniciarAplicacion(videojuego);
				break;
			case 2:
				System.out.println("Videojuego incorrectos");
				contador++;
				break;
			case 666:
				System.out.println("Error de acceso. Intentelo mas tarde");
				break;
			}

		}

		System.out.println("Fin de la aplicación");


	}

	private void iniciarAplicacion(Videojuego v) {
		System.out.println("--------------------------");
		System.out.println("Videojuego" + v.getNombre());
		System.out.println("--------------------------");
		int opcion = 0;
		do {
			opcion = menu();
			switch (opcion) {
			case 1:
				darAltaVideojuego();
				break;
			}
		}while(opcion != 0);
	}

	private void darAltaVideojuego() {
		Videojuego videojuego = pedirDatos();
		int respuesta = gv.guardarVideojuego(videojuego);
		switch (respuesta) {
		case 1:
			System.out.println("Nombre del Videojuego en blanco o con solo espacios en blanco");
			break;
		case 2:
			System.out.println("Compañia en blanco o con solo espacios en blanco");
			break;
		case 3:
			System.out.println("Nota en blanco o con solo espacios en blanco");
			break;
		case 4:
			System.out.println("Videojuego guardado con exito!! :) :)");
			break;
		case 0:
			System.out.println("Error de acceso. Intentelo mas tarde. Codigo 666");
			break;
		}
	}

	private int menu() {
		boolean correcto = false;
		int opcion = 0;
		while(!correcto) {
			System.out.println("Elija una opción: ");
			System.out.println("1 - Registrar Videojuego");
			System.out.println("0 - Salir del programa");
			opcion = sc.nextInt();
			if(opcion >= 0 && opcion <= 1) {
				correcto = true;
			}
		}		
		return opcion;
	}

	private Videojuego pedirDatos() {
		System.out.println("Introduzca el nombre: ");
		String nombre = scString.nextLine();
		System.out.println("Introduzca el password: ");
		String pass = scString.nextLine();
		Videojuego v = new Videojuego();
		v.setNombre("gta");
		v.setCompañia("Rockstar");
		v.setNota("6");
		return v;
	}
	}
