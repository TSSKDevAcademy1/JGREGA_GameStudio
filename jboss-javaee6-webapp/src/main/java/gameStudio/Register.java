package gameStudio;

import javax.ejb.Local;
import gameStudio.Regdata;

@Local
public interface Register {

	/* (non-Javadoc)
	 * @see org.jboss.tools.examples.service.MemberRegistration#register(org.jboss.tools.examples.model.Member)
	 */
	void register(Regdata regdata) throws Exception;

}