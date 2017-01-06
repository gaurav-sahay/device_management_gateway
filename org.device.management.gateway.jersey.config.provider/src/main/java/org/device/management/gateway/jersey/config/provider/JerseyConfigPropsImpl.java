package org.device.management.gateway.jersey.config.provider;

import java.util.Dictionary;
import java.util.Hashtable;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.log4j.Logger;
import org.device.management.gateway.webservices.config.JerseyConfigProps;
import org.glassfish.jersey.servlet.ServletContainer;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
@Component(immediate=true)
@Service(value=JerseyConfigProps.class)
public class JerseyConfigPropsImpl implements JerseyConfigProps {
	
	private static final Logger LOG = Logger.getLogger(JerseyConfigPropsImpl.class);
	private static Dictionary<String, String> DICTIONARY = null;
	private static final String JERSEY_CONFIG_SERVER_PROVIDER_PACKAGES = "jersey.config.server.provider.packages";
	
	@Property(name="Http service")
	@Reference(bind="setHttpService",unbind="unsetHttpService",referenceInterface=HttpService.class)
	private HttpService httpService;

	@Override
	public Dictionary<String, String> getJerseyConfigProviderPackagesProps() {
		return DICTIONARY;
	}
	
	@Activate
	public void activate(ComponentContext componentContext){
		DICTIONARY = new Hashtable<String, String>();
		DICTIONARY.put(JERSEY_CONFIG_SERVER_PROVIDER_PACKAGES, "");
		LOG.info("The Jersey config properties service is active !");
	}
	
	@Deactivate
	public void deactivate(ComponentContext componentContext){
		LOG.info("Closing Jersey config properties !");
	}
	
	
	protected void setHttpService(HttpService httpService) throws ServletException, NamespaceException{
		LOG.info("Setting the httpservice");
		this.httpService = httpService;
		
	}
	
	protected void unsetHttpService(HttpService httpService){
		LOG.info("Unsetting the httpservice");
		httpService.unregister("/rest/*");
		this.httpService =  null;
	}
	
	/**
	 * List of packages separated by semicolon
	 * e.g(org.test;org.test2;org.test3)
	 * 
	 * @param webServicePackage
	 * @throws NamespaceException 
	 * @throws ServletException 
	 */
	@Override
	public void putProps(String webServicePackages) throws ServletException, NamespaceException{
		String oldPackages = DICTIONARY.get(JERSEY_CONFIG_SERVER_PROVIDER_PACKAGES);
		if(!"".equals(oldPackages)){
			LOG.info(webServicePackages+" added to "+oldPackages);
			DICTIONARY.put(JERSEY_CONFIG_SERVER_PROVIDER_PACKAGES, oldPackages+";"+webServicePackages);
		} else {
			LOG.info(webServicePackages+" added .");
			DICTIONARY.put(JERSEY_CONFIG_SERVER_PROVIDER_PACKAGES, webServicePackages);
		}
		
		httpService.registerServlet("/rest/*", new ServletContainer(), DICTIONARY, null);
		
	}

}
