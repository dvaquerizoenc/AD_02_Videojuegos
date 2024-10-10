package modelo.negocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import modelo.entidad.Videojuego;
import modelo.persistencia.DaoVideojuegoFichero;

public class GestorVideojuego {
	
	private DaoVideojuegoFichero duf;
	
	
	public int validarVideojuego(Videojuego v) {
		duf = new DaoVideojuegoFichero();
		try {
			Videojuego vFichero = duf.getByNameVideojuego(v.getNombre());
			if (vFichero == null) {
				return 0;
			}

			if (vFichero.equals(v)) {
				return 1;
			} else {
				return 2;
			}
		} catch (Exception e) {
			return 666;
		}
	}
	
	
	public ArrayList<String> getListaVideojuegos() throws Exception{
		duf = new DaoVideojuegoFichero();
		return duf.getListaVideojuegosdao();
	}
	
	public int guardarVideojuego(Videojuego v) {
		if (v == null) {
			return 0;
		}

		duf = new DaoVideojuegoFichero();
		try {
			if (v.getNombre().isBlank()) {
				return 1;
			} else if (v.getCompañia().isBlank()) {
				return 2;
			} else if (v.getNota().isBlank()) {
				return 3;
			} else {
				duf.registrarVideojuego(v);
				return 4;
			}
		} catch (Exception e) {
			return 333;
		}
	}
}
