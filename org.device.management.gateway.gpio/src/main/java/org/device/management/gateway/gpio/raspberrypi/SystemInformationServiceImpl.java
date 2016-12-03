/**
 * 
 */
package org.device.management.gateway.gpio.raspberrypi;

import java.io.IOException;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;
import org.bosch.device.management.gateway.system.api.SystemInformationService;
import org.osgi.service.component.ComponentContext;

import com.pi4j.system.SystemInfo;

/**
 * @author GAH6KOR
 * 
 *         System Information service implementation for the raspberrypi.
 *
 */
@Component(immediate = true)
@Service(value = SystemInformationService.class)
public class SystemInformationServiceImpl implements SystemInformationService {

	public SystemInformationServiceImpl() {

	}

	@Activate
	public void activate(ComponentContext componentContext) {
		System.out.println("The System information service is active !");
	}

	@Deactivate
	public void deactivate(ComponentContext componentContext) {
		System.out.println("Closing System information service !");
	}

	public String getProcessor() throws IOException, InterruptedException {
		return SystemInfo.getProcessor();
	}

	public String getBogoMIPS() throws IOException, InterruptedException {
		return SystemInfo.getBogoMIPS();
	}

	public String[] getCpuFeatures() throws IOException, InterruptedException {
		return SystemInfo.getCpuFeatures();
	}

	public String getCpuImplementer() throws IOException, InterruptedException {
		return SystemInfo.getCpuImplementer();
	}

	public String getCpuArchitecture() throws IOException, InterruptedException {
		return SystemInfo.getCpuArchitecture();
	}

	public String getCpuVariant() throws IOException, InterruptedException {
		return SystemInfo.getCpuVariant();
	}

	public String getCpuPart() throws IOException, InterruptedException {
		return SystemInfo.getCpuPart();
	}

	public String getCpuRevision() throws IOException, InterruptedException {
		return SystemInfo.getCpuRevision();
	}

	public String getHardware() throws IOException, InterruptedException {
		return SystemInfo.getHardware();
	}

	public String getRevision() throws IOException, InterruptedException {
		return SystemInfo.getRevision();
	}

	public String getSerial() throws IOException, InterruptedException {
		return SystemInfo.getSerial();
	}

}
