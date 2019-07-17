package com.kishore.spring;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.wildfly.naming.client.store.RelativeContext;

import com.kishore.ejb3.HelloBeanRemote;
import com.kishore.ejb3.SampleMavenBeanRemote;

@SpringBootApplication
public class SpringBootEjbIntegrationApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEjbIntegrationApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootEjbIntegrationApplication.class);
    }

	@Bean
	public Context context() throws NamingException {
		
		 Properties jndiProps = new Properties();
	        jndiProps.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
	        jndiProps.put("jboss.naming.client.ejb.context", true);
	        jndiProps.put("java.naming.provider.url", "http-remoting://localhost:8080");
	        return new InitialContext(jndiProps);
	   
	}
	
	@Bean
	public  HelloBeanRemote getLookUpObject(Context context) throws Exception
		
	{
		
		 return (HelloBeanRemote)context.lookup( "ejb:/HelloEJB3Project-0.0.1-SNAPSHOT/HelloBean!com.kishore.ejb3.HelloBeanRemote");
	
	}
	
	
//		}
}
