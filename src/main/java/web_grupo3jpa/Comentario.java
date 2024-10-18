package web_grupo3jpa;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the comentarios database table.
 * 
 */
@Entity
@Table(name="comentarios")
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(generator="comentarios_id_comentario_seq") 
	@SequenceGenerator(name="comentarios_id_comentario_seq",sequenceName="comentarios_id_comentario_seq", allocationSize=1)
	@Column(name="id_comentario")
	private Integer idComentario;

	private String comentario;

	private String correo;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String nombre;

	private String telefono;

	public Comentario() {
	}

	public Integer getIdComentario() {
		return this.idComentario;
	}

	public void setIdComentario(Integer idComentario) {
		this.idComentario = idComentario;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}