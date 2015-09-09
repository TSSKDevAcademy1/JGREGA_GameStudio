package gameStudio;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;

@Stateless
@WebService(name="Registration") // touto anotaciou spravim z toho webservice
public class RegistrationBean implements Register{

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    private Event<Regdata> regEvent;
    
    @Override
	public void register(Regdata regdata) throws Exception {
        log.info("Registering " + regdata.getLogin());
        log.info("Registering " + regdata.getAge());
        log.info("Registering " + regdata.getCountry());
        log.info("Registering " + regdata.getPasswd());
        em.persist(regdata);
        log.info("dojde");
//        regEvent.fire(regdata);
    }
}
