/**
 * 
 */
package org.device.management.gateway.gpio.raspberrypi;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;
import org.bosch.device.management.gateway.gpio.api.GPIOService;
import org.osgi.service.component.ComponentContext;

import com.pi4j.io.gpio.impl.GpioControllerImpl;

/**
 * @author GAH6KOR
 *
 */
@Component(immediate=true)
@Service(value=GPIOService.class)
public class GPIOServiceImpl extends GpioControllerImpl implements GPIOService{

	public GPIOServiceImpl() {
		super();
	}
	
	@Activate
	public void activate(ComponentContext componentContext){
		System.out.println("The GPIO service is active !");
	}
	
	@Deactivate
	public void deactivate(ComponentContext componentContext){
		System.out.println("Closing GPIO service !");
	}
	

}
