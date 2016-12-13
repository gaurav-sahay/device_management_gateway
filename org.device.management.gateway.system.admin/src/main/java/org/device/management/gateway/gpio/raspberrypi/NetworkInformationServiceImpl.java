/**
 * 
 */
package org.device.management.gateway.gpio.raspberrypi;

import java.io.IOException;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;
import org.apache.log4j.Logger;
import org.device.management.gateway.system.api.NetworkInformationService;
import org.osgi.service.component.ComponentContext;

import com.pi4j.system.NetworkInfo;

/**
 * @author GAH6KOR
 * 
 *         Network information service implementation for the raspberrypi.
 *
 */
@Component(immediate = true)
@Service(value = NetworkInformationService.class)
public class NetworkInformationServiceImpl implements NetworkInformationService {

	private static final Logger LOG = Logger.getLogger(NetworkInformationServiceImpl.class);
	
	
	public NetworkInformationServiceImpl() {
	}

	@Activate
	public void activate(ComponentContext componentContext) {
		LOG.info("The Network information service is active !");
	}

	@Deactivate
	public void deactivate(ComponentContext componentContext) {
		LOG.info("Closing Network information service !");
	}

	public String getHostname() throws IOException, InterruptedException {
		return NetworkInfo.getHostname();
	}

	public String getFQDN() throws IOException, InterruptedException {
		return NetworkInfo.getFQDN();
	}

	public String[] getIPAddresses() throws IOException, InterruptedException {
		return NetworkInfo.getIPAddresses();
	}

	public String getIPAddress() throws IOException, InterruptedException {
		return NetworkInfo.getIPAddress();
	}

	public String[] getFQDNs() throws IOException, InterruptedException {
		return NetworkInfo.getFQDNs();
	}

	public String[] getNameservers() throws IOException, InterruptedException {
		return NetworkInfo.getNameservers();
	}
	
}
