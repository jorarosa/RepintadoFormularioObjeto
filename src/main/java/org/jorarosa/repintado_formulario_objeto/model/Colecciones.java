package org.jorarosa.repintado_formulario_objeto.model;

import java.util.SortedMap;
import java.util.TreeMap;

public class Colecciones {
	
	public static SortedMap<String, String> listaGenerosOrdenada= new TreeMap<String, String>();
	public static SortedMap<String, String> listaPaisesOrdenada = new TreeMap<String, String>();
	public static SortedMap<String, String> listaAficionesOrdenada = new TreeMap<String, String>();
	public static SortedMap<String, String> listaMusicasOrdenada = new TreeMap<String, String>();

	static {

		listaGenerosOrdenada.put("H", "Hombre");
		listaGenerosOrdenada.put("M", "Mujer");
		listaGenerosOrdenada.put("O", "Otro");

		listaPaisesOrdenada.put("ES", "España");
		listaPaisesOrdenada.put("FR", "Francia");
		listaPaisesOrdenada.put("IT", "Italia");
		listaPaisesOrdenada.put("PT", "Portugal");

		listaAficionesOrdenada.put("C", "Cine");
		listaAficionesOrdenada.put("D", "Deporte");
		listaAficionesOrdenada.put("L", "Lectura");
		listaAficionesOrdenada.put("M", "Musica");

		listaMusicasOrdenada.put("E", "Electrónica");
		listaMusicasOrdenada.put("C", "Country");
		listaMusicasOrdenada.put("N", "New Age");
		listaMusicasOrdenada.put("P", "Pop");
		listaMusicasOrdenada.put("R", "Rock");

	}
}