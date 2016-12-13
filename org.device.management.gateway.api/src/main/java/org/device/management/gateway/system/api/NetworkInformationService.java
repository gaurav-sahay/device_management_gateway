/**
 * 
 */
package org.device.management.gateway.system.api;

import java.io.IOException;

/**
 * @author GAH6KOR
 * 
 * Network information service for the device.
 */
public interface NetworkInformationService {
	public String getHostname() throws IOException, InterruptedException;

	public String getFQDN() throws IOException, InterruptedException ;

	public String[] getIPAddresses() throws IOException, InterruptedException ;

	public String getIPAddress() throws IOException, InterruptedException ;

	public String[] getFQDNs() throws IOException, InterruptedException ;

	public String[] getNameservers() throws IOException, InterruptedException ;

}
