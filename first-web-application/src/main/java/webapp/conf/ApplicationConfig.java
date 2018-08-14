package webapp.conf;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import webapp.cd.CdRest;
import webapp.cd.CdServlet;
import webapp.login.ClientLoginServlet;

@ApplicationPath("rest")
public class ApplicationConfig extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
	    Set<Class<?>> set = new HashSet<>();
	    set.add(CdRest.class);
	    return set;
	}

}
