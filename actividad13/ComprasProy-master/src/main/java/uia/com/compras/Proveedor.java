package uia.com.compras;

import java.util.ArrayList;
import java.util.HashMap;

public class Proveedor {
    protected HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>> Disponible = new HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>>();
    boolean vedade;

    public void setVedade(boolean vedade) {
        this.vedade = vedade;
    }

    public boolean isVedade() {
        return vedade;
    }
    public HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>> getDevulve() {
        return Disponible;
    }
    public void setDevuelve(HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>> vendedores) {
        this.Disponible = vendedores;
    }

    public void hazCotizacion(Comprador com){

    }

    private void provedor(){

    }
}
