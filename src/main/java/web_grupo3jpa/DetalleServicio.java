package web_grupo3jpa;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the detalle_servicio database table.
 * 
 */
@Entity
@Table(name="detalle_servicio")
@NamedQuery(name="DetalleServicio.findAll", query="SELECT d FROM DetalleServicio d")
public class DetalleServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DETALLE_SERVICIO_IDDETALLE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETALLE_SERVICIO_IDDETALLE_GENERATOR")
	@Column(name="id_detalle")
	private Integer idDetalle;

	@Column(name="estado_servicio")
	private String estadoServicio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Column(name="inf_final")
	private String infFinal;

	@Column(name="inf_inicial")
	private String infInicial;

	private BigDecimal precio;

	@Column(name="repor_cliente")
	private String reporCliente;

	//bi-directional many-to-one association to EquipoServicio
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private EquipoServicio equipoServicio;

	public DetalleServicio() {
	}

	public Integer getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public String getEstadoServicio() {
		return this.estadoServicio;
	}

	public void setEstadoServicio(String estadoServicio) {
		this.estadoServicio = estadoServicio;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getInfFinal() {
		return this.infFinal;
	}

	public void setInfFinal(String infFinal) {
		this.infFinal = infFinal;
	}

	public String getInfInicial() {
		return this.infInicial;
	}

	public void setInfInicial(String infInicial) {
		this.infInicial = infInicial;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getReporCliente() {
		return this.reporCliente;
	}

	public void setReporCliente(String reporCliente) {
		this.reporCliente = reporCliente;
	}

	public EquipoServicio getEquipoServicio() {
		return this.equipoServicio;
	}

	public void setEquipoServicio(EquipoServicio equipoServicio) {
		this.equipoServicio = equipoServicio;
	}

}