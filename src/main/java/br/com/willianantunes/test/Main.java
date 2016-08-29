package br.com.willianantunes.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @see <a href="http://wiki.aiwsolutions.net/2014/03/18/jpa-in-standalone-spring-application/">JPA in standalone spring application</a>
 */
@Component
public class Main {
    public static void main( String[] args ) {
    	final ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
    	
    	PlatformTransactionManager platformTransactionManager = context.getBean(PlatformTransactionManager.class);    	
    	final Main main = context.getBean(Main.class);
    	
    	// Programmatic transaction management
    	TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
            	main.doMytest();
            }
        }); 
    }    
    
    @PersistenceContext
    private EntityManager entityManager;

    void doMytest() {

    }
}
