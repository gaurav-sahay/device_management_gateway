/**
 * 
 */
package org.device.management.gateway.gpio.raspberrypi;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;
import org.apache.log4j.Logger;
import org.bosch.device.management.gateway.gpio.api.GPIOService;
import org.osgi.service.component.ComponentContext;

import com.pi4j.io.gpio.impl.GpioControllerImpl;

/**
 * @author GAH6KOR
 * 
 * GPIO service implementation for the raspberrypi.
 */
@Component(immediate=true)
@Service(value=GPIOService.class)
public class GPIOServiceImpl extends GpioControllerImpl implements GPIOService{
	private static final Logger LOG = Logger.getLogger(GPIOServiceImpl.class);

	public GPIOServiceImpl() {
		super();
	}
	
	@Activate
	public void activate(ComponentContext componentContext){
		LOG.info("The GPIO service is active !");
	}
	
	@Deactivate
	public void deactivate(ComponentContext componentContext){
		LOG.info("Closing GPIO service !");
	}
	

}
