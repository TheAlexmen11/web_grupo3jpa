package web_grupo3jpa;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cliente")
	private Integer idCliente;

	@Column(name="dni_cliente")
	private Integer dniCliente;

	@Column(name="email_cliente")
	private String emailCliente;

	@Column(name="nom_cliente")
	private String nomCliente;

	@Column(name="telefono_cliente")
	private Integer telefonoCliente;

	//bi-directional many-to-one association to EquipoServicio
	@OneToMany(mappedBy="cliente")
	private List<EquipoServicio> equipoServicios;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="cliente")
	private List<Venta> ventas;

	public Cliente() {
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getDniCliente() {
		return this.dniCliente;
	}

	public void setDniCliente(Integer dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getEmailCliente() {
		return this.emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getNomCliente() {
		return this.nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public Integer getTelefonoCliente() {
		return this.telefonoCliente;
	}

	public void setTelefonoCliente(Integer telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public List<EquipoServicio> getEquipoServicios() {
		return this.equipoServicios;
	}

	public void setEquipoServicios(List<EquipoServicio> equipoServicios) {
		this.equipoServicios = equipoServicios;
	}

	public EquipoServicio addEquipoServicio(EquipoServicio equipoServicio) {
		getEquipoServicios().add(equipoServicio);
		equipoServicio.setCliente(this);

		return equipoServicio;
	}

	public EquipoServicio removeEquipoServicio(EquipoServicio equipoServicio) {
		getEquipoServicios().remove(equipoServicio);
		equipoServicio.setCliente(null);

		return equipoServicio;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setCliente(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setCliente(null);

		return venta;
	}

}