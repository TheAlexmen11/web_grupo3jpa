package web_grupo3jpa;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the equipo_servicio database table.
 * 
 */
@Entity
@Table(name="equipo_servicio")
@NamedQuery(name="EquipoServicio.findAll", query="SELECT e FROM EquipoServicio e")
public class EquipoServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="equipo_servicio_id_equipo_seq") 
	@SequenceGenerator(name="equipo_servicio_id_equipo_seq",sequenceName="equipo_servicio_id_equipo_seq", allocationSize=1)
	@Column(name="id_equipo")
	private Integer idEquipo;

	private String bateria;

	private String cargador;

	private String disco;

	private String fuente;

	private String mainboard;

	private String marca;

	private String memoria;

	private String modelo;

	private String otros;

	private String procesador;

	private String serie;

	@Column(name="t_video")
	private String tVideo;

	//bi-directional many-to-one association to DetalleServicio
	@OneToMany(mappedBy="equipoServicio")
	private List<DetalleServicio> detalleServicios;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_user")
	private Usuario usuario;

	//bi-directional many-to-one association to ImagenesServicio
	@OneToMany(mappedBy="equipoServicio")
	private List<ImagenesServicio> imagenesServicios;

	public EquipoServicio() {
	}

	public Integer getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getBateria() {
		return this.bateria;
	}

	public void setBateria(String bateria) {
		this.bateria = bateria;
	}

	public String getCargador() {
		return this.cargador;
	}

	public void setCargador(String cargador) {
		this.cargador = cargador;
	}

	public String getDisco() {
		return this.disco;
	}

	public void setDisco(String disco) {
		this.disco = disco;
	}

	public String getFuente() {
		return this.fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getMainboard() {
		return this.mainboard;
	}

	public void setMainboard(String mainboard) {
		this.mainboard = mainboard;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMemoria() {
		return this.memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getOtros() {
		return this.otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public String getProcesador() {
		return this.procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTVideo() {
		return this.tVideo;
	}

	public void setTVideo(String tVideo) {
		this.tVideo = tVideo;
	}

	public List<DetalleServicio> getDetalleServicios() {
		return this.detalleServicios;
	}

	public void setDetalleServicios(List<DetalleServicio> detalleServicios) {
		this.detalleServicios = detalleServicios;
	}

	public DetalleServicio addDetalleServicio(DetalleServicio detalleServicio) {
		getDetalleServicios().add(detalleServicio);
		detalleServicio.setEquipoServicio(this);

		return detalleServicio;
	}

	public DetalleServicio removeDetalleServicio(DetalleServicio detalleServicio) {
		getDetalleServicios().remove(detalleServicio);
		detalleServicio.setEquipoServicio(null);

		return detalleServicio;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ImagenesServicio> getImagenesServicios() {
		return this.imagenesServicios;
	}

	public void setImagenesServicios(List<ImagenesServicio> imagenesServicios) {
		this.imagenesServicios = imagenesServicios;
	}

	public ImagenesServicio addImagenesServicio(ImagenesServicio imagenesServicio) {
		getImagenesServicios().add(imagenesServicio);
		imagenesServicio.setEquipoServicio(this);

		return imagenesServicio;
	}

	public ImagenesServicio removeImagenesServicio(ImagenesServicio imagenesServicio) {
		getImagenesServicios().remove(imagenesServicio);
		imagenesServicio.setEquipoServicio(null);

		return imagenesServicio;
	}

}