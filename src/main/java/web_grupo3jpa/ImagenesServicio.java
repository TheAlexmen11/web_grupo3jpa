package web_grupo3jpa;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the imagenes_servicio database table.
 * 
 */
@Entity
@Table(name="imagenes_servicio")
@NamedQuery(name="ImagenesServicio.findAll", query="SELECT i FROM ImagenesServicio i")
public class ImagenesServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="imagenes_servicio_id_imagen_seq") 
	@SequenceGenerator(name="imagenes_servicio_id_imagen_seq",sequenceName="imagenes_servicio_id_imagen_seq", allocationSize=1)
	@Column(name="id_imagen")
	private Integer idImagen;

	@Column(name="ruta_imagen")
	private String rutaImagen;

	//bi-directional many-to-one association to EquipoServicio
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private EquipoServicio equipoServicio;

	public ImagenesServicio() {
	}

	public Integer getIdImagen() {
		return this.idImagen;
	}

	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}

	public String getRutaImagen() {
		return this.rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public EquipoServicio getEquipoServicio() {
		return this.equipoServicio;
	}

	public void setEquipoServicio(EquipoServicio equipoServicio) {
		this.equipoServicio = equipoServicio;
	}

}