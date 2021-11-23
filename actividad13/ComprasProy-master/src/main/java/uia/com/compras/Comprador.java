package uia.com.compras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comprador {

    private int clasificacion = 0;

    protected HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>> vendedores = new HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>>();

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>> getVendedores() {
        return vendedores;
    }

    public void setVendedores(HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>> vendedores) {
        this.vendedores = vendedores;
    }

    public void hazSolicitudOrdenCompra(PeticionOrdenCompra miPeticionOC) {
        validaExistencia(miPeticionOC);
    }

    private void validaExistencia(PeticionOrdenCompra miPeticionOC) {
        for (int i = 0; i < miPeticionOC.getItems().size(); i++) {
            validaUso((PeticionOrdenCompra) miPeticionOC.getItems().get(i), i);
        }
    }

    private void validaUso(PeticionOrdenCompra miPeticionOC, int i) {
        switch (i % 3) {
            case 0:
                miPeticionOC.setClasificacion(0);
                break;
            case 1:
                miPeticionOC.setClasificacion(1);
                break;
            case 2:
                miPeticionOC.setClasificacion(2);
                break;
        }
    }

    public SolicitudOrdenCompra buscaVendedor(PeticionOrdenCompra miPeticionOC) {
        //--Por downcasting se crea SolicituOrdenCompra para asignar las peticiones con proveedor
        SolicitudOrdenCompra miSolicitudOC = new SolicitudOrdenCompra();

        for (int i = 0; i < miPeticionOC.getItems().size(); i++) {
            SolicitudOrdenCompra item;
            item = new SolicitudOrdenCompra((PeticionOrdenCompra) miPeticionOC.getItems().get(i));
            if (buscaVendedor((SolicitudOrdenCompra) item, i) >= 0) {
                if (miSolicitudOC.getItems() == null)
                    miSolicitudOC.setItems(new ArrayList<InfoComprasUIA>());
                miSolicitudOC.getItems().add(item);
            }
        }
        if (miSolicitudOC != null)
            return miSolicitudOC;
        else
            return null;

    }

    private int buscaVendedor(SolicitudOrdenCompra solicitudOC, int i) {
        switch (i % 3) {
            case 0:
                solicitudOC.setVendedor(0);
                return i;
            case 1:
                solicitudOC.setVendedor(1);
                return i;
            case 2:
                solicitudOC.setVendedor(2);
                return i;
        }
        return -1;
    }

    public void agrupaVendedores(PeticionOrdenCompra peticionOC) {
        SolicitudOrdenCompra newItem = null;
        int key = 0;
        int keyLista = -1;

        if (vendedores == null)
            vendedores = new HashMap<Integer, HashMap<Integer, ArrayList<InfoComprasUIA>>>();

        for (int i = 0; i < peticionOC.getItems().size(); i++) {
            newItem = (SolicitudOrdenCompra) peticionOC.getItems().get(i);
            key = newItem.getVendedor();
            keyLista = i % 3;

            if (vendedores.containsKey(key)) {
                if (vendedores.get(key).containsKey(keyLista)) {
                    vendedores.get(key).get(keyLista).add(newItem);
                } else {
                    ArrayList<InfoComprasUIA> newLista = new ArrayList<InfoComprasUIA>();
                    newLista.add(newItem);
                    HashMap<Integer, ArrayList<InfoComprasUIA>> nodo = new HashMap<Integer, ArrayList<InfoComprasUIA>>();
                    nodo.put(i, newLista);
                    vendedores.put(key, nodo);
                }
            } else {
                ArrayList<InfoComprasUIA> newLista = new ArrayList<InfoComprasUIA>();
                newLista.add(newItem);
                HashMap<Integer, ArrayList<InfoComprasUIA>> nodo = new HashMap<Integer, ArrayList<InfoComprasUIA>>();
                nodo.put(keyLista, newLista);
                vendedores.put(key, nodo);
            }
        }
    }
}
