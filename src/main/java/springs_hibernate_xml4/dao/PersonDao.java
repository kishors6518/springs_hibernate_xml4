package springs_hibernate_xml4.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import springs_hibernate_xml4.dto.Language;
import springs_hibernate_xml4.dto.Person;

public class PersonDao {
	
	public EntityManager getManager()
	{
		return Persistence.createEntityManagerFactory("kishor").createEntityManager();
	}
	public void savePerson(Person person) {
		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		
		transaction.begin();

		manager.persist(person);
		transaction.commit();

	}

	public void getPerson(int id) {

		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		
		Person person = manager.find(Person.class, id);
		if (person != null) {
			System.out.println(person);
		} else {
			System.out.println("error occ");

		}

	}

	public void deletePerson(int id) {

		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		
		Person person = manager.find(Person.class, id);
		if (person != null) {
			
			transaction.begin();
			manager.remove(person);
			transaction.commit();
		} else {
			System.out.println("Person not found");
		}
	}

	public void update(int id, Person person) {
		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();

		Person person2 = manager.find(Person.class, id);
		List<Language> list=person2.getLang();
		person.setLang(list);
		if (person2 != null) {
			
			

			transaction.begin();
//			manager.merge(person2.getLanguages());

			manager.merge(person);
			System.out.println("update successful");
			transaction.commit();

		} else {
			System.out.println("Person not found");
		}

	}

	public void saveLanguage(Language language) {
		EntityManager manager=getManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(language);
		transaction.commit();
		
	}

}
