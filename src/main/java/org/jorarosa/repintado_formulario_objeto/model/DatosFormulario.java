package org.jorarosa.repintado_formulario_objeto.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Range;
import org.jorarosa.repintado_formulario_objeto.model.validation.FieldsValueMatch;
import org.jorarosa.repintado_formulario_objeto.model.validation.PasswordMatch;
import org.jorarosa.repintado_formulario_objeto.model.validation.ValidPassword;
import org.springframework.format.annotation.DateTimeFormat;

@PasswordMatch(message="{formulario.error.clavesNoCoincidentes}")
/*
@FieldsValueMatch.List({ 
    @FieldsValueMatch(
      field = "clave", 
      fieldMatch = "confirmarClave", 
      message = "{formulario.error.clavesNoCoincidentes}"
    )
})
*/
public class DatosFormulario {

	@NotNull(message="{formulario.error.nombre.notNull}")
	@NotBlank(message="{formulario.error.nombre.notBlank}")
	private String nombre;

	@NotNull(message="{formulario.error.clave.notNull}")
	@NotBlank(message="{formulario.error.clave.notBlank}")
	@ValidPassword
	private String clave;
	
	@NotNull(message="{formulario.error.confirmarClave.notNull}")
	@NotBlank(message="{formulario.error.confirmarClave.notBlank}")
	@ValidPassword
	private String confirmarClave;
	
	@NotNull(message="{formulario.error.edad.notNull}")
	// @NotBlank(message="{formulario.error.edad.notBlank}")	
	@PositiveOrZero(message="{formulario.error.edad.positive}")
	@Range(min=0, max=150, message="{formulario.error.edad.range}")
	private int edad;
	
	@NotNull(message="{formulario.error.fechaNacimiento.notNull}")
	// @NotBlank(message="{formulario.error.fechaNacimiento.notBlank}")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past(message="{formulario.error.fechaNacimiento.past}")
	// @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaNacimiento;
	
	@NotNull(message="{formulario.error.email.notNull}")
	@NotBlank(message="{formulario.error.email.notBlank}")
	@Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", 
			message="{formulario.error.email.pattern}")
	private String email;
	
	private String siglasGenero;
	private String siglasPais;
	private List<String> siglasAficiones;
	private List<String> siglasMusicas;
	
	@NotNull(message="{formulario.error.comentarios.notNull}")
	private String comentarios;
	
	public DatosFormulario() {
		super();
	}

	public DatosFormulario(
			@NotNull(message = "{formulario.error.nombre.notNull}") @NotBlank(message = "{formulario.error.nombre.notBlank}") String nombre,
			@NotNull(message = "{formulario.error.clave.notNull}") @NotBlank(message = "{formulario.error.clave.notBlank}") String clave,
			@NotNull(message = "{formulario.error.confirmarClave.notNull}") @NotBlank(message = "{formulario.error.confirmarClave.notBlank}") String confirmarClave,
			@NotNull(message = "{formulario.error.edad.notNull}") @PositiveOrZero(message = "{formulario.error.edad.positive}") @Range(min = 0, max = 150, message = "{formulario.error.edad.range}") int edad,
			@NotNull(message = "{formulario.error.fechaNacimiento.notNull}") LocalDate fechaNacimiento,
			@NotNull(message="{formulario.error.email.notNull}") @NotBlank(message="{formulario.error.email.notBlank}") 
			@Pattern(regexp="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message="{formulario.error.email.pattern}") String email,
			String siglasGenero, 
			String siglasPais,
			List<String> siglasAficiones,
			List<String> siglasMusicas,
			@NotNull(message = "{formulario.error.comentarios.notNull}") String comentarios) {
		super();
		this.nombre = nombre;
		this.clave = clave;
		this.confirmarClave = confirmarClave;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.siglasGenero = siglasGenero;
		this.siglasPais = siglasPais;
		this.siglasAficiones = siglasAficiones;
		this.siglasMusicas = siglasMusicas;
		this.comentarios = comentarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getConfirmarClave() {
		return confirmarClave;
	}

	public void setConfirmarClave(String confirmarClave) {
		this.confirmarClave = confirmarClave;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSiglasGenero() {
		return siglasGenero;
	}

	public void setSiglasGenero(String siglasGenero) {
		this.siglasGenero = siglasGenero;
	}

	public String getSiglasPais() {
		return siglasPais;
	}

	public void setSiglasPais(String siglasPais) {
		this.siglasPais = siglasPais;
	}

	public List<String> getSiglasAficiones() {
		return siglasAficiones;
	}

	public void setSiglasAficiones(List<String> siglasAficiones) {
		this.siglasAficiones = siglasAficiones;
	}

	public List<String> getSiglasMusicas() {
		return siglasMusicas;
	}

	public void setSiglasMusicas(List<String> siglasMusicas) {
		this.siglasMusicas = siglasMusicas;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}