package com.cjmulcahy.accela.revised;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cjmulcahy.accela.revised.configuartion.Config;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        ConsoleUI consoleUi = applicationContext.getBean(ConsoleUI.class);
        consoleUi.startConsole();
        applicationContext.close();
    }
}
