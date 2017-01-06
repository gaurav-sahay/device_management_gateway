package org.device.management.gateway.device.healthcheck;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.log4j.Logger;
import org.device.management.gateway.webservices.config.JerseyConfigProps;
import org.osgi.service.http.NamespaceException;

import com.pi4j.util.ExecUtil;


@Component(name="Device Health Check")
@Path("/deviceHealthCheck")
public class DeviceHealthCheck {

	private static final Logger LOG = Logger.getLogger(DeviceHealthCheck.class);
	
	@Property(name="consumer service")
	@Reference(bind="setJerseyConfigPropsService",unbind="unsetJerseyConfigPropsService",referenceInterface=JerseyConfigProps.class)
	private JerseyConfigProps jerseyConfigProps;
	
	@Path("/getDeviceHealth")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDeviceHealthCheck() throws IOException, InterruptedException{
		StringBuilder builder = new StringBuilder();
		for(String line : ExecUtil.execute("top")){
			builder.append(line);
			builder.append("\n");
		}
		return builder.toString();
	}
	
	protected void setJerseyConfigPropsService(JerseyConfigProps jerseyConfigProps) throws ServletException, NamespaceException {
		LOG.info("Setting jersey config properties service.");
		this.jerseyConfigProps = jerseyConfigProps;
		jerseyConfigProps.putProps(DeviceHealthCheck.class.getPackage().getName());
	}
	
	protected void unsetJerseyConfigPropsService(JerseyConfigProps jerseyConfigProps){
		LOG.info("Unsetting jersey config properties service.");
		this.jerseyConfigProps = null;
	}
	
	
	
}
