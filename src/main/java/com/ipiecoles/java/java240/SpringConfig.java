package com.ipiecoles.java.java240;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {

    @Bean
    @Scope
    public BitcoinService bitcoinService(){
        BitcoinService bs = new BitcoinService();
        bs.setWebPageManager(webPageManager());
        return bs;
    }

    @Bean
    @Scope
    public ProduitManager produitManager(){
        ProduitManager pm = new ProduitManager();
        pm.setWebPageManager(webPageManager());
        pm.setBitcoinService(bitcoinService());
        return pm;
    }

    @Bean
    @Scope
    public WebPageManager webPageManager(){
        return new WebPageManager();
    }



}
