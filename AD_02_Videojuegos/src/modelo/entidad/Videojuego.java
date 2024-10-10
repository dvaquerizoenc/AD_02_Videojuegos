package modelo.entidad;

import java.util.Objects;

public class Videojuego {
	private String nombre="";
	private String compañia="";
	private double nota=0.0;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCompañia() {
		return compañia;
	}
	
	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}
	
	public double getNota() {
		return nota;
	}
	
	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(compañia, nombre, nota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
}