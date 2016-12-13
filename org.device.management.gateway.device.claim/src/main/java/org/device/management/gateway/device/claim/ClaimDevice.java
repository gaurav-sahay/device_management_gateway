/**
 * 
 */
package org.device.management.gateway.device.claim;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.felix.scr.annotations.Component;
import org.apache.log4j.Logger;
import org.device.management.gateway.device.claim.to.DeviceDetailsTO;
import org.device.management.gateway.util.JSONConverter;

/**
 * @author GAH6KOR
 *
 */
@Component(name="Claim Device")
@Path("/deviceManagement")
public class ClaimDevice {
	private static final Logger LOG = Logger.getLogger(ClaimDevice.class);
	
	@Path("/claimDevice")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String claimDevice(String deviceDetails) throws UnknownHostException, SocketException{
		System.out.println("device details string value ="+deviceDetails);
		DeviceDetailsTO deviceDetailsTO = (DeviceDetailsTO) JSONConverter.convertToObject(deviceDetails, DeviceDetailsTO.class);
		System.out.println("device details dto device id value ="+deviceDetailsTO.getDeviceId());
		if(authenticateDevice(deviceDetailsTO.getDeviceId())){
			System.out.println("inside if connected ");
			deviceDetailsTO.setDeviceStatus("Connected");
			return JSONConverter.convertToJson(deviceDetailsTO);
		} 
			throw new RuntimeException("The device id doesn't match with the device !");
	}
	
	
	
	
	private boolean authenticateDevice(String deviceId) throws UnknownHostException, SocketException {
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println("inet address value  ="+inetAddress);
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
		byte[] macAddress = networkInterface.getHardwareAddress();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < macAddress.length; i++) {
			sb.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
		}
		LOG.info("mac address value "+sb);
		return ((""+sb).equals(deviceId));
	}

}
