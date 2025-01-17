package interfaz;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.entidad.Usuario;
import modelo.entidad.Videojuego;
import modelo.negocio.GestorUsuario;
import modelo.negocio.GestorVideojuego;

public class InterfazPrograma {

	private GestorUsuario gu = null;
	private GestorVideojuego gv = null;
	private Scanner scString = new Scanner(System.in);
	private Scanner sc = new Scanner(System.in);

	public void mostrarInterfaz() {
		System.out.println("Bienvenidos a nuestra app :)");
		Usuario usuario = null;
		gu = new GestorUsuario();
		Videojuego videojuego = null;
		gv = new GestorVideojuego();
		int respuesta = 0;

		int contador = 0;
		boolean validado = false;

		while (contador < 3 && !validado) {
			usuario = pedirDatos();
			respuesta = gu.validar(usuario);
			switch (respuesta) {
			case 0:
				System.out.println("Usuario no existe");
				break;
			case 1:
				System.out.println("Usuario correcto, bienvenido a la app");
				validado = true;
				iniciarAplicacion(usuario);
				break;
			case 2:
				System.out.println("Usuario y/o password incorrectos");
				contador++;
				break;
			case 666:
				System.out.println("Error de acceso. Intentelo mas tarde");
				break;
			}

		}

		System.out.println("Fin de la aplicación");


	}

	private void iniciarAplicacion(Usuario u) {
		System.out.println("--------------------------");
		System.out.println("Perfil de " + u.getNombre());
		System.out.println("--------------------------");
		int opcion = 0;
		do {
			opcion = menu();
			switch (opcion) {
			case 1:
				darAltaUsuario();
				break;
				
			case 2:
				darAltaVideojuego();
				break;
			
			case 3:
				listarVideojuegos();
				break;
			}
			
		}while(opcion != 0);
	}

	private void darAltaUsuario() {
		Usuario usuario = pedirDatos();
		int respuesta = gu.guardar(usuario);
		switch (respuesta) {
		case 1:
			System.out.println("Usuario en blanco o con solo espacios en blanco");
			break;
		case 2:
			System.out.println("Password en blanco o con solo espacios en blanco");
			break;
		case 3:
			System.out.println("Usuario guardado con exito!! :) :)");
			break;
		case 666:
			System.out.println("Error de acceso. Intentelo mas tarde. Codigo 666");
			break;
		}
	}
	
	private void darAltaVideojuego() {
		Videojuego videojuego = pedirDatosVideojuego();
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
	
	private void listarVideojuegos() {
		GestorVideojuego gVideojuego = new GestorVideojuego();
		try {
			ArrayList<String> listaVJ = gVideojuego.getListaVideojuegos();
			
			for(String e : listaVJ) {
				System.out.println(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private int menu() {
		boolean correcto = false;
		int opcion = 0;
		while(!correcto) {
			System.out.println("Elija una opción: ");
			System.out.println("3 - Listar videojuegos");
			System.out.println("2 - Registrar videojuego");
			System.out.println("1 - Registrar usuario");
			System.out.println("0 - Salir del programa");
			opcion = sc.nextInt();
			if(opcion >= 0 && opcion <= 3) {
				correcto = true;
			}
		}		
		return opcion;
	}

	private Usuario pedirDatos() {
		System.out.println("Introduzca el nombre: ");
		String nombre = scString.nextLine();
		System.out.println("Introduzca el password: ");
		String pass = scString.nextLine();
		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setPassword(pass);
		return u;
	}
	
	private Videojuego pedirDatosVideojuego() {
		System.out.println("Introduzca el nombre del videojuego: ");
		String nombre = scString.nextLine();
		System.out.println("Introduzca la compañia: ");
		String compañia = scString.nextLine();
		System.out.println("Introduzca la nota: ");
		String nota = scString.nextLine();
		Videojuego v = new Videojuego();
		v.setNombre(nombre);
		v.setCompañia(compañia);
		v.setNota(nota);
		return v;
	}
}
