package springs_hibernate_xml4.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	private int id;
	private String name;
	private long phone;
	private String address;
	@ManyToMany
	private List<Language> lang;

}
