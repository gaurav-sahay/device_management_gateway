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
import org.device.management.gateway.system.api.SystemInformationService;
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

	private static final Logger LOG = Logger.getLogger(SystemInformationServiceImpl.class);
	public SystemInformationServiceImpl() {

	}

	@Activate
	public void activate(ComponentContext componentContext) {
		LOG.info("The System information service is active !");
	}

	@Deactivate
	public void deactivate(ComponentContext componentContext) {
		LOG.info("Closing System information service !");
	}

	@Override
	public String getProcessor() throws IOException, InterruptedException {
		return SystemInfo.getProcessor();
	}
	@Override
	public String getBogoMIPS() throws IOException, InterruptedException {
		return SystemInfo.getBogoMIPS();
	}
	@Override
	public String[] getCpuFeatures() throws IOException, InterruptedException {
		return SystemInfo.getCpuFeatures();
	}
	@Override
	public String getCpuImplementer() throws IOException, InterruptedException {
		return SystemInfo.getCpuImplementer();
	}
	@Override
	public String getCpuArchitecture() throws IOException, InterruptedException {
		return SystemInfo.getCpuArchitecture();
	}
	@Override
	public String getCpuVariant() throws IOException, InterruptedException {
		return SystemInfo.getCpuVariant();
	}
	@Override
	public String getCpuPart() throws IOException, InterruptedException {
		return SystemInfo.getCpuPart();
	}
	@Override
	public String getCpuRevision() throws IOException, InterruptedException {
		return SystemInfo.getCpuRevision();
	}
	@Override
	public String getHardware() throws IOException, InterruptedException {
		return SystemInfo.getHardware();
	}
	@Override
	public String getRevision() throws IOException, InterruptedException {
		return SystemInfo.getRevision();
	}
	@Override
	public String getSerial() throws IOException, InterruptedException {
		return SystemInfo.getSerial();
	}

}
