package com.sujata.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sujata.producer.Greet;

public class GreetConsumer 
{
    public static void main( String[] args )
    {
    	//IOC : Inversion of control = Seperating the dependency logic from the bussiness logic of your application
    	//we achieve IOC with either constructor injection or setter injection
    	ApplicationContext springContainer=new ClassPathXmlApplicationContext("greetannot.xml");
        
        //Greet g1=new GoodMorning(); ====> (NO)
        
        Greet g1=(Greet)springContainer.getBean("mrng");
        
        g1.wish();
    }
}
