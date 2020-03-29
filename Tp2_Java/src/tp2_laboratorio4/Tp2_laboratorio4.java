
package tp2_laboratorio4;

import entities.Pais;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Tp2_laboratorio4 {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2PU");
        EntityManager em = emf.createEntityManager();
        JSONParser parser = new JSONParser();
        String _url = "https://restcountries.eu/rest/v2/callingcode/";
        Pais pais = new Pais();
        for (int codigo = 1; codigo <= 300; codigo++) {
            try {
                URL Json = new URL(_url + codigo);
                URLConnection uc = Json.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                JSONArray ja = (JSONArray) parser.parse(br.readLine());
                if (ja != null) {
                    for (Object object : ja) {
                        em.getTransaction().begin();
                        JSONObject paisJson = (JSONObject) object;
                        if (paisJson.get("name").toString().length() <= 50) {
                            pais.setNombredePais((String) paisJson.get("name"));
                        } else {
                            pais.setNombredePais((String) paisJson.get("name").toString().substring(50));
                        }
                        pais.setCapitalPais((String) paisJson.get("capital"));
                        pais.setPoblacion((Long) paisJson.get("population"));
                        pais.setRegion((String) paisJson.get("region"));
                        List coorGeo = (List) paisJson.get("latlng");
                        pais.setLatitud((double) coorGeo.get(0));
                        pais.setLongitud((double) coorGeo.get(1));
                        pais.setCodigodePais(codigo);
                        em.merge(pais);
                        em.flush();
                        em.getTransaction().commit();
                    }
                    System.out.println("País encontrado con el codigo: " + codigo);
                } else {
                    continue;
                }
                br.close();
            } catch (Exception e) {
                System.out.println("No existe el país con el código: " + codigo);
            }
        }
        em.close();
        emf.close();
        System.gc();
    }
    
}
