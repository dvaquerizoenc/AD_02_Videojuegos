package modelo.negocio;

import modelo.entidad.Videojuego;
import modelo.persistencia.DaoVideojuegoFichero;

public class GestorVideojuego {
	
	private DaoVideojuegoFichero duf;
	
	public int guardar(Videojuego v) {
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
