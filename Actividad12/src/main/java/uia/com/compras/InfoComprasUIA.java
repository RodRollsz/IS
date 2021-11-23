package uia.com.compras;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;


@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
	    @Type(value = ReporteNivelStock.class, name = "reporteNS"),
		@Type(value = ReporteNivelStock.class, name = "itemsPOC")
	    })

public class InfoComprasUIA {

	private int id;
	private String name="";
	private String type="";
	private String descripcion="";
	private int pedidoProveedor=0;
	private List<InfoComprasUIA> items;


	public int getPedidoProveedor() {
		return pedidoProveedor;
	}

	public void setPedidoProveedor(int pedidoProveedor) {
		this.pedidoProveedor = pedidoProveedor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public InfoComprasUIA()
	{		
	}
	
	public InfoComprasUIA(int id, String name)
	{
		this.id=id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<InfoComprasUIA> getItems() {
		return items;
	}

	public void setItems(List<InfoComprasUIA> items) {
		this.items =  items;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void print() {
		System.out.println(this);
		System.out.println("Id:\t" + this.getId());
		System.out.println("Name:\t" + this.getName());
		System.out.println("Descripciopn\t"+this.getDescripcion());
		System.out.println("provedor\t"+this.getPedidoProveedor());
	}

}
