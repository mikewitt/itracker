/**
 * 
 */
package itracker.sound;

import javax.sound.sampled.*;
/**
 * Class for generating test sounds using the javax.sound.sampled package
 * 
 * NOT INTENDED AS A FINAL CLASS
 * 
 * @author Michael Witt
 *
 */
//Depreciated
public class SoundTest {
	
	/**
	 * Generate a sinusiod for use in sound; sinusoid generated is a cosine
	 * therefore, with no phase offset, return[0] will always be 1.
	 * @param sampleRate Desired sample rate, in Hz
	 * @param frequency Frequency of the sinusoid
	 * @param length Length, in s, of the sinusoid
	 * @param phase Phase offset of the sinusoid in radians
	 * @param sampleResolution Size (in bits) of the resulting output waveform; bits per sample
	 * @return
	 */
	public int [] generateSin(int sampleRate, int frequency, double length, double phase, char sampleResolution) {
		//calculate length of sinusoid
		int sLength = (int) (length * sampleRate);
		//calculate the magnitude of the sinusoid
		int magnitude = (int) Math.pow(2, sampleResolution+1);
		
		//initialize the return array
		int [] result = new int[sLength];
		
		//populate the array
		for (int i = 0; i < sLength; i++) {
			result[i] = (int) (magnitude * Math.cos(frequency*(double)(i/sampleRate)+phase));
		}
		return result;
	}
}
