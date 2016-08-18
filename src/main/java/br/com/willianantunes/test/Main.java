package br.com.willianantunes.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main 
{
    public static void main( String[] args ) {
    	final ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
    	final Main main = context.getBean(Main.class);
    	main.doMytest();
    }
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    void doMytest() {

    }
}
