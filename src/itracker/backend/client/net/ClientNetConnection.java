/**
 * 
 */
package itracker.backend.client.net;

import java.net.*;

/**
 * Client network connection wrapper.
 * 
 * All calls to and from external resources should be handled
 * in this class.
 * 
 * Only one connection can be handled at a time.
 * 
 * Not threaded. (No reason?)
 * 
 * @author Michael Witt
 *
 */
public class ClientNetConnection {
	//private references needed later
	private Socket clientConnection = new Socket();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
