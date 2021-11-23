package uia.com.compras;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitudOrdenCompra extends PeticionOrdenCompra
{
    private int vendedor=-1;

    @JsonCreator
    public SolicitudOrdenCompra(@JsonProperty("id")int id, @JsonProperty("name")String name,
                               @JsonProperty("codigo")String codigo, @JsonProperty("unidad")String unidad,
                               @JsonProperty("cantidad")int cantidad, @JsonProperty("vendedor")int vendedor,@JsonProperty("clasificacionProveedor")int clasificacionVendedor)
    {
        super(id, name, codigo, unidad, cantidad);
        this.vendedor = vendedor;
    }

    public SolicitudOrdenCompra(PeticionOrdenCompra info)
    {
        super(info.getId(), info.getName(), info.getCodigo(), info.getUnidad(), info.getCantidad());
        this.setClasificacion(info.getClasificacion());
    }

    public SolicitudOrdenCompra() {

    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

}
