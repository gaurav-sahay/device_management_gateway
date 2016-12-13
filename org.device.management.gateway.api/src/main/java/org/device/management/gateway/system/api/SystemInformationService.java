/**
 * 
 */
package org.device.management.gateway.system.api;

import java.io.IOException;

/**
 * @author GAH6KOR
 *
 *         System Information for the device.
 */
public interface SystemInformationService {

	public String getProcessor() throws IOException, InterruptedException ;

	public String getBogoMIPS() throws IOException, InterruptedException ;
		
	public String[] getCpuFeatures() throws IOException, InterruptedException ;

	public String getCpuImplementer() throws IOException, InterruptedException ;

	public String getCpuArchitecture() throws IOException, InterruptedException ;

	public String getCpuVariant() throws IOException, InterruptedException ;

	public String getCpuPart() throws IOException, InterruptedException ;

	public String getCpuRevision() throws IOException, InterruptedException ;

	public String getHardware() throws IOException, InterruptedException ;

	public String getRevision() throws IOException, InterruptedException ;

	public String getSerial() throws IOException, InterruptedException;

}
