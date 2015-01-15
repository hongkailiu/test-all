package com.hongkailiu.test.gs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * Hello world!
 * https://spring.io/guides/gs/rest-service/
 */
@ComponentScan
@EnableAutoConfiguration
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	SpringApplication.run(App.class, args);
    }
	
}
