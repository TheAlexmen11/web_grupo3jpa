package web_grupo3jpa;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="usuario_id_user_seq") 
	@SequenceGenerator(name="usuario_id_user_seq",sequenceName="usuario_id_user_seq", allocationSize=1)
	@Column(name="id_user")
	private Integer idUser;

	@Column(name="nom_user")
	private String nomUser;

	@Column(name="password_hash")
	private String passwordHash;

	@Column(name="rol_user")
	private String rolUser;

	private String username;

	//bi-directional many-to-one association to EquipoServicio
	@OneToMany(mappedBy="usuario")
	private List<EquipoServicio> equipoServicios;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="usuario")
	private List<Venta> ventas;

	public Usuario() {
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNomUser() {
		return this.nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRolUser() {
		return this.rolUser;
	}

	public void setRolUser(String rolUser) {
		this.rolUser = rolUser;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<EquipoServicio> getEquipoServicios() {
		return this.equipoServicios;
	}

	public void setEquipoServicios(List<EquipoServicio> equipoServicios) {
		this.equipoServicios = equipoServicios;
	}

	public EquipoServicio addEquipoServicio(EquipoServicio equipoServicio) {
		getEquipoServicios().add(equipoServicio);
		equipoServicio.setUsuario(this);

		return equipoServicio;
	}

	public EquipoServicio removeEquipoServicio(EquipoServicio equipoServicio) {
		getEquipoServicios().remove(equipoServicio);
		equipoServicio.setUsuario(null);

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
		venta.setUsuario(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setUsuario(null);

		return venta;
	}

}