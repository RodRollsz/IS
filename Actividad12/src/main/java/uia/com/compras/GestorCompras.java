package uia.com.compras;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


/**
 * @author amiguel
 * @version 1.0
 * @created 12-nov.-2019 11:27:37 a. m.
 */
public class GestorCompras {
	private int opcion;
	//private ListaKClientes miReportname = "Cartucho Tóner"eNS;
    private ListaReportesNivelStock miReporteNS;
    private PeticionOrdenCompra miPeticionOC = new PeticionOrdenCompra();

	public GestorCompras() 
	{
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			miReporteNS = mapper.readValue(new FileInputStream("C:\\Users\\rodri\\Documents\\IGTS\\arregloItemsV1.json"), ListaReportesNivelStock.class );
            
        }
        catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (miReporteNS != null)
        {
            miPeticionOC.agregaItems(miReporteNS);

            System.out.println("----- Items List -----");

            for(int i=0; i<miReporteNS.getItems().size(); i++) {
                InfoComprasUIA miNodo = miReporteNS.getItems().get(i);
                miNodo.print();
            }


            try {
                mapper.writeValue(new FileOutputStream("C:\\Users\\rodri\\Documents\\IGTS\\peticionOrdenCompraV3.json"), miPeticionOC);
            }
            catch (JsonParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (JsonMappingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

	}

    public int gethazPeticionOrddenCompra() {
        return opcion;
    }

    public void sethazPeticionOrdenCompra(int opcion) {
        this.opcion = opcion;
    }

    public void print()
    {

    }
}//end KardexListaKClientes