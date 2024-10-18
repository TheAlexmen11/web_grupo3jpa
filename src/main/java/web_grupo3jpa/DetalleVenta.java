package web_grupo3jpa;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detalle_venta database table.
 * 
 */
@Entity
@Table(name="detalle_venta")
@NamedQuery(name="DetalleVenta.findAll", query="SELECT d FROM DetalleVenta d")
public class DetalleVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DETALLE_VENTA_IDDETALLEVENTA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETALLE_VENTA_IDDETALLEVENTA_GENERATOR")
	@Column(name="id_detalle_venta")
	private Integer idDetalleVenta;

	private BigDecimal cantidad;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	//bi-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumn(name="id_venta")
	private Venta venta;

	public DetalleVenta() {
	}

	public Integer getIdDetalleVenta() {
		return this.idDetalleVenta;
	}

	public void setIdDetalleVenta(Integer idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}