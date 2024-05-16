package springs_hibernate_xml4.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springs_hibernate_xml4.dao.PersonDao;
import springs_hibernate_xml4.dto.Language;
import springs_hibernate_xml4.dto.Person;

public class Main {

	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("person.xml");
	        Person person = context.getBean("o", Person.class);
	        PersonDao dao = context.getBean("dao", PersonDao.class);
	        
	        // Get the Language beans using their IDs
//	        Language marathi = context.getBean("marathi", Language.class);
//	        Language hindi = context.getBean("hindi", Language.class);
//	        Language english = context.getBean("english", Language.class);
//	        Language french = context.getBean("french", Language.class);
	        
            dao.savePerson(person);

	}

}
