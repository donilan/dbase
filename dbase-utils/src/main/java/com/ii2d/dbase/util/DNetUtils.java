//~ generate by eclipse
package com.ii2d.dbase.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @author Doni
 * @since 2012-11-29
 * @version $id$
 * 
 */
public class DNetUtils {
	
	public static final int TIMEOUT = 3000;

	/**
	 * 只有局域网有效
	 * @author Doni
	 * @since 2012-11-29
	 * @param host
	 */
	public static boolean ping(String host) throws IOException {
		InetAddress address = InetAddress.getByName(host);
		if(address.isReachable(TIMEOUT)) return true;
		
		Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
		while(netInterfaces.hasMoreElements()) {
			NetworkInterface ni = netInterfaces.nextElement();
			if(address.isReachable(ni, 0, TIMEOUT))
				return true;
		}
		
		return false;
	}
}
