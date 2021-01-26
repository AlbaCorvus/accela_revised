package com.cjmulcahy.accela.revised.configuartion;

import java.util.Scanner;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import com.cjmulcahy.accela.revised.CRUDMediator;
import com.cjmulcahy.accela.revised.ConsoleUI;
import com.cjmulcahy.accela.revised.UIMediator;
import com.cjmulcahy.accela.revised.command.CommandInput;
import com.cjmulcahy.accela.revised.command.CreateCommand;
import com.cjmulcahy.accela.revised.command.DeleteCommand;
import com.cjmulcahy.accela.revised.command.FindCommand;
import com.cjmulcahy.accela.revised.command.ListCommand;
import com.cjmulcahy.accela.revised.command.ReadCommand;
import com.cjmulcahy.accela.revised.command.UpdateCommand;
import com.cjmulcahy.accela.revised.dao.PersonDAO;
import com.cjmulcahy.accela.revised.dao.PersonDAOImpl;
import com.cjmulcahy.accela.revised.domain.Address;
import com.cjmulcahy.accela.revised.domain.Person;
import com.cjmulcahy.accela.revised.menu.CountPersonMenu;
import com.cjmulcahy.accela.revised.menu.CreatePersonMenu;
import com.cjmulcahy.accela.revised.menu.DeletePersonMenu;
import com.cjmulcahy.accela.revised.menu.ListPersonMenu;
import com.cjmulcahy.accela.revised.menu.MainMenu;
import com.cjmulcahy.accela.revised.menu.MenuFactory;
import com.cjmulcahy.accela.revised.menu.UpdatePersonMenu;
import com.cjmulcahy.accela.revised.service.PersonService;
import com.cjmulcahy.accela.revised.service.PersonServiceImpl;
import com.cjmulcahy.accela.revised.utils.ScannerUtils;
import com.cjmulcahy.accela.revised.utils.ScannerValidator;

@Configuration
@ComponentScan("com.cjmulcahy.accela.revised.comnmand")
public class Config {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CRUDMediator mediator(){
        return new UIMediator();
    }
    
    @Bean
    public MenuFactory menuFactory(){
        MenuFactory menuFactory = new MenuFactory();
        return menuFactory;
    }
    
    @Bean
    public MainMenu mainMenu(){
        MainMenu mainMenu = new MainMenu();
            return mainMenu;
        }
    @Bean
    public DeletePersonMenu deletePersonMenu(){
        DeletePersonMenu bean = new DeletePersonMenu();
        return bean;
    }
    @Bean
    public CreatePersonMenu createPersonMenu(){
        CreatePersonMenu bean = new CreatePersonMenu();
        return bean;
    }
    @Bean
    public ListPersonMenu listPersonMenu(){
        ListPersonMenu bean = new ListPersonMenu();
        return bean;
    }
    @Bean
    public CountPersonMenu findPersonMenu(){
        CountPersonMenu bean = new CountPersonMenu();
        return bean;
    }
    
    @Bean
    UpdatePersonMenu updatePersonMenu(){
        UpdatePersonMenu bean = new UpdatePersonMenu();
        return bean;
    }
    
    @Bean
    public ScannerUtils scannerUtils(){
        ScannerUtils bean = new ScannerUtils();
        return bean;
    }
    
    @Bean
    public Scanner scanner(){
        Scanner bean = new Scanner(System.in);
        return bean;
    }
    
    @Bean
    public ScannerValidator scannerValidator(){
        ScannerValidator bean = new ScannerValidator();
        return bean;
    }
    
    @Bean
    public Person person(){
        Person bean = new Person();
        return bean;
    }
    
    @Bean
    public Address address(){
        Address bean = new Address();
        return bean;
    }
    
    @Bean
    public PersonDAO personDAO(){
        PersonDAOImpl bean = new PersonDAOImpl();
        return bean;
    }
    
    @Bean
    public PersonService personService(){
        PersonServiceImpl bean = new PersonServiceImpl();
        return bean;
    }
    
    @Bean
    public CommandInput createCommand(){
        CommandInput bean = new CreateCommand(mediator());
        return bean;
    }
    @Bean
    public CommandInput deleteCommand(){
        CommandInput bean = new DeleteCommand(mediator());
        return bean;
    }
    @Bean
    public CommandInput updateCommand(){
        CommandInput bean = new UpdateCommand(mediator());
        return bean;
    }
    
    @Bean
    public CommandInput readCommand(){
        CommandInput bean = new ReadCommand(mediator());
        return bean;
    }
    @Bean
    public CommandInput listCommand(){
        CommandInput bean = new ListCommand(mediator());
        return bean;
    }
    @Bean
    public CommandInput findCommand(){
        CommandInput bean = new FindCommand(mediator());
        return bean;
    }
    
    
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory(){
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("test-jpa");
        return factoryBean;
    }
    
    @Bean
    public static PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        PersistenceExceptionTranslationPostProcessor bean = new PersistenceExceptionTranslationPostProcessor();
        return bean;
    }
    
    @Bean
    public ConsoleUI consoleUI(){
        ConsoleUI bean = new ConsoleUI();
        return bean;
    }
    
}
