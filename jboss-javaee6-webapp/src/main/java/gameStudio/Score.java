package gameStudio;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;


@SuppressWarnings("serial")
@Named
@Entity
@SessionScoped
public class Score implements Serializable {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Named
	private String name;
	
	@Named
	private String game;
	
	@Named
	private long time;

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time; // = (endTime-startTime)/1000
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}
}
