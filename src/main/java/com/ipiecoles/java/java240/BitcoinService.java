package com.ipiecoles.java.java240;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BitcoinService {

    @Autowired
    private WebPageManager webPageManager;

    private Double rate = null;

    @Value("${bitcoinService.forceRefresh}")
    private Boolean forceRefresh;

    public Boolean getForceRefresh() {
        return forceRefresh;
    }

    public void setForceRefresh(Boolean forceRefresh) {
        this.forceRefresh = forceRefresh;
    }




    /**
     * Méthode qui renvoie le cours du Bitcoin
     * @return le cours du bitcoin
     * @throws IOException si impossible d'accéder à la bourse
     */
    public Double getBitcoinRate() throws IOException {
        if(rate != null && !forceRefresh){
            System.out.println("Récupération du cours du bitcoin en cache...");
            return rate;
        }

        System.out.println("Récupération du cours du bitcoin sur site distant");

        String apiResponse = webPageManager.getPageContents("file:/C:/Users/nicolas.grand-jean/Desktop/price.json");
        apiResponse = apiResponse.replace("{\"EUR\":","");
        apiResponse = apiResponse.replace("}","");
        rate = Double.parseDouble(apiResponse);
        return rate;
    }

    /**
     * Méthode qui renvoie l'équivalent en bitcoin du prix en euro passé en paramètre
     * @param prixEnEuro le prix à convertir
     * @return le prix en bitcoin au taux actuel
     * @throws IOException si impossible d'accéder à la bourse
     */
    public Double getBitcoinPrice(Double prixEnEuro) throws IOException {
//        if(rate == null){
            getBitcoinRate();
//        }
        return prixEnEuro / rate;
    }

}
