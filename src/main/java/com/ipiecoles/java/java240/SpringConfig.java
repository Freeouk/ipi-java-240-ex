package com.ipiecoles.java.java240;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan(basePackages ="com.ipiecoles.java.java240")
public class SpringConfig {
//
    @Bean
    public BitcoinService bitcoinServiceWithoutCache(){
        BitcoinService bs = new BitcoinService();
        bs.setForceRefresh(true);
        return bs;
    }
//
//    @Bean
//    @Scope
//    public ProduitManager produitManager(){
//        ProduitManager pm = new ProduitManager();
//        pm.setWebPageManager(webPageManager());
//        pm.setBitcoinService(bitcoinService());
//        return pm;
//    }
//
//    @Bean
//    @Scope
//    public WebPageManager webPageManager(){
//        return new WebPageManager();
//    }
//
//

}
