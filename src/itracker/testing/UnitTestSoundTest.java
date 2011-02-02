/**
 * 
 */
package itracker.testing;

import itracker.sound.*;

/**
 * @author Michael Witt
 *
 */
public class UnitTestSoundTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SoundTest sTest = new SoundTest();
		/*
		
		sTest.getMixerInfo();
		//*/
		//*
		byte[] sinArray = null;
		sinArray = sTest.generateSin(48000, 440, 1, 0, (char) 1);
		//System.out.println(sinArray.length);
		/*
		System.out.print("[");
		for (byte i : sinArray) {
			System.out.print(" " + (int)i);
		}
		System.out.println(" ]");
		System.out.println((int)sinArray[0]);
		//*/
		
		sTest.playSound(sinArray, 48000);
	}

}
