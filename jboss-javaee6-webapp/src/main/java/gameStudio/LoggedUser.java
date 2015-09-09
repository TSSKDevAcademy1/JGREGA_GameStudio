package gameStudio;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@SuppressWarnings("serial")
@Named
@SessionScoped
public class LoggedUser implements Serializable {
	
	private long id;	
	
	private String login;
	
	private String passwd;
	
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	
	
	
}
