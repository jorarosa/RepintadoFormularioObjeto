package org.jorarosa.repintado_formulario_objeto.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.SortedMap;

import javax.validation.Valid;

import org.jorarosa.repintado_formulario_objeto.model.Colecciones;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import org.jorarosa.repintado_formulario_objeto.model.DatosFormulario;

@Controller
public class Controlador {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(LocalDateTime.class, new CustomDateEditor(formatoFecha, true));
	}
	
	// para pasar datos a las vistas, accesibles desde todos los métodos
	@ModelAttribute("listaGenerosOrdenada")
	public SortedMap<String, String> devuelveListaGeneros() {
		return Colecciones.listaGenerosOrdenada;
	}
	@ModelAttribute("listaPaisesOrdenada")
	public SortedMap<String, String> devuelveListaPaises() {
		return Colecciones.listaPaisesOrdenada;
	}
	@ModelAttribute("listaAficionesOrdenada")
	public SortedMap<String, String> devuelveListaAficiones() {
		return Colecciones.listaAficionesOrdenada;
	}
	@ModelAttribute("listaMusicasOrdenada")
	public SortedMap<String, String> devuelveListaMusicas() {
		return Colecciones.listaMusicasOrdenada;
	}	

	@GetMapping("repintadoFormulario")
	public ModelAndView enviarFormulario() {
		ModelAndView mAV = new ModelAndView();
		DatosFormulario datosFormulario = new DatosFormulario(); 
		
		/* con @ModelAttribute, se pasan a la vista las colecciones necesarias para repintarse
		 * mAV.addObject("listaGenerosOrdenada", Colecciones.listaGenerosOrdenada);
		 * mAV.addObject("listaPaisesOrdenada", Colecciones.listaPaisesOrdenada);
		 * mAV.addObject("listaAficionesOrdenada", Colecciones.listaAficionesOrdenada);
		 * mAV.addObject("listaMusicasOrdenada", Colecciones.listaMusicasOrdenada);
		*/
		
		// pasar a la vista unos datos predefinidos para los diferentes controles
		datosFormulario.setNombre("Pepe");
		datosFormulario.setSiglasGenero("O");
		datosFormulario.setSiglasPais("IT");
		datosFormulario.setSiglasAficiones(List.of("D", "L"));
		datosFormulario.setSiglasMusicas(List.of("E", "R"));
		mAV.addObject("datosFormulario", datosFormulario);
		
		mAV.setViewName("formularioObjeto");
		return mAV;
	}

	@PostMapping("repintadoFormulario")
	public ModelAndView recibirParametros(
			@Valid DatosFormulario datosFormulario,
			BindingResult resultadoVinculacionParametros) {

		ModelAndView mAV = new ModelAndView();
		
		/* con @ModelAttribute, se pasan a la vista las colecciones necesarias para repintarse
		 * mAV.addObject("listaGenerosOrdenada", Colecciones.listaGenerosOrdenada);
		 * mAV.addObject("listaPaisesOrdenada", Colecciones.listaPaisesOrdenada);
		 * mAV.addObject("listaAficionesOrdenada", Colecciones.listaAficionesOrdenada);
		 * mAV.addObject("listaMusicasOrdenada", Colecciones.listaMusicasOrdenada);
		*/
		
		if (resultadoVinculacionParametros.hasErrors()) {
			mAV.setViewName("formularioObjeto");
		} else {
			mAV.setViewName("formularioRepintado");
		}
		return mAV;
	}
}