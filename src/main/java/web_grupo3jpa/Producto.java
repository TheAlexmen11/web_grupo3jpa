package web_grupo3jpa;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="productos_id_product_seq") 
	@SequenceGenerator(name="productos_id_product_seq",sequenceName="productos_id_product_seq", allocationSize=1)
	@Column(name="id_product")
	private Integer idProduct;

	private String descripcion;

	@Column(name="img_product")
	private String imgProduct;

	@Column(name="marca_product")
	private String marcaProduct;

	private BigDecimal precio;

	@Column(name="tipo_product")
	private String tipoProduct;

	//bi-directional many-to-one association to DetalleVenta
	@OneToMany(mappedBy="producto")
	private List<DetalleVenta> detalleVentas;

	public Producto() {
	}

	public Integer getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImgProduct() {
		return this.imgProduct;
	}

	public void setImgProduct(String imgProduct) {
		this.imgProduct = imgProduct;
	}

	public String getMarcaProduct() {
		return this.marcaProduct;
	}

	public void setMarcaProduct(String marcaProduct) {
		this.marcaProduct = marcaProduct;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getTipoProduct() {
		return this.tipoProduct;
	}

	public void setTipoProduct(String tipoProduct) {
		this.tipoProduct = tipoProduct;
	}

	public List<DetalleVenta> getDetalleVentas() {
		return this.detalleVentas;
	}

	public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
		this.detalleVentas = detalleVentas;
	}

	public DetalleVenta addDetalleVenta(DetalleVenta detalleVenta) {
		getDetalleVentas().add(detalleVenta);
		detalleVenta.setProducto(this);

		return detalleVenta;
	}

	public DetalleVenta removeDetalleVenta(DetalleVenta detalleVenta) {
		getDetalleVentas().remove(detalleVenta);
		detalleVenta.setProducto(null);

		return detalleVenta;
	}

}