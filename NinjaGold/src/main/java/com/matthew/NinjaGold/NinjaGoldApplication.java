package com.matthew.NinjaGold;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NinjaGoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(NinjaGoldApplication.class, args);
	}
	
    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        Connector ajpConnector = new Connector("AJP/1.3");
        ajpConnector.setPort(9090);
        ajpConnector.setSecure(false);
        ajpConnector.setAllowTrace(false);
        ajpConnector.setScheme("http");
        tomcat.addAdditionalTomcatConnectors(ajpConnector);
        return tomcat;
    }
    
    final Connector connector = new Connector("AJP/1.3");
    connector.setScheme("http");
    connector.setPort(ajpPort);
    connector.setAllowTrace(false);

    final AbstractAjpProtocol protocol = (AbstractAjpProtocol) connector.getProtocolHandler();
    connector.setSecure(true);
    protocol.setSecret(ajpSecret);
}
