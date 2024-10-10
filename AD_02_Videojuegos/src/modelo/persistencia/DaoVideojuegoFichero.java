package modelo.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import modelo.entidad.Usuario;
import modelo.entidad.Videojuego;

public class DaoVideojuegoFichero {
	private static final String NOMBRE_FICHERO = "videojuegos.txt";
	
	/**
	 *  Método que te devuelve una lista de todos los videojuegos que hay
	 *  en el fichero
	 * @return listadoVJ, es un listado 
	 * @throws Exception
	 */
	public ArrayList<String> getListaVideojuegosdao() throws Exception{
		ArrayList<String> listadoVJ = new ArrayList<String>();
		
		try(FileReader fr = new FileReader(NOMBRE_FICHERO);
			BufferedReader br = new BufferedReader(fr)){
			String cadena = br.readLine();
			while(cadena != null) {
				listadoVJ.add(cadena);
				cadena = br.readLine();
			}
			return listadoVJ;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
	public Videojuego getByNameVideojuego(String nombre) throws Exception{
		Videojuego videojuego = null;
		
		try(FileReader fr = new FileReader(NOMBRE_FICHERO);
			BufferedReader br = new BufferedReader(fr)){
			String cadena = br.readLine();//USUARIO/PASSWORD
			while(cadena != null) {
				String[] cadenaPartida = cadena.split("_");
				String nombreVideojuego = cadenaPartida[0];
				String compañiaVideojuego = cadenaPartida[1];
				String notaVideojuego = cadenaPartida[2];
				if(nombre.equals(nombreVideojuego)){
					videojuego = new Videojuego();
					videojuego.setNombre(nombreVideojuego);
					videojuego.setCompañia(compañiaVideojuego);
					videojuego.setNombre(notaVideojuego);
					return videojuego;
				}
				cadena = br.readLine();
			}
			return null;
		}catch(Exception e) {
			throw e;
		}
	}
	
	
	public void registrarVideojuego(Videojuego v) throws Exception{
		File f = new File(NOMBRE_FICHERO);
		if(!f.exists()) {
			throw new Exception("Fichero NO existe! :(");
		}
		
		try(FileWriter fw = new FileWriter(NOMBRE_FICHERO,true);
			BufferedWriter bw = new BufferedWriter(fw)){
			bw.newLine();
			bw.write(v.toString());
		}catch(Exception e) {
			throw e;
		}
	}
}
