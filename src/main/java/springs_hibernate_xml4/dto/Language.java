package springs_hibernate_xml4.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Language {
	@Id
	private int id;
	private String name;
	private String origin;

}
