package com.sujata.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sujata.producer.Greet;

public class GreetConsumer 
{
    public static void main( String[] args )
    {
    	//Responsible for running the life cycle of all the beans mentioned with <bean> tag in greet.xml file
        ApplicationContext springContainer=new ClassPathXmlApplicationContext("greetannot.xml");
        
        //Greet g1=new GoodMorning(); ====> (NO)
        
        Greet g1=(Greet)springContainer.getBean("eve");
        
        g1.wish("Sujata");
    }
}
