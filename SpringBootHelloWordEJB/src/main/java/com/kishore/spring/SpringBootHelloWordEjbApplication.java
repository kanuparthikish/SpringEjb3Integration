package com.kishore.spring;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kishore.ejb3.HelloBeanRemote;



@SpringBootApplication
public class SpringBootHelloWordEjbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWordEjbApplication.class, args);
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
		
		 return (HelloBeanRemote)context.lookup( "ejb:/HelloEJB3Project-0.0.1-SNAPSHOT//HelloBean!com.kishore.ejb3.HelloBeanRemote");
	
	}
	
}
