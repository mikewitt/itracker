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
	public byte [] generateSin(int sampleRate, int frequency, double length, double phase, char sampleResolution) {
		//calculate length of sinusoid
		int sLength = (int) (length * sampleRate);
		//calculate the magnitude of the sinusoid
		int magnitude = (int) Math.pow(2, 7)-1;
		
		//initialize the return array
		byte [] result = new byte[sLength];
		char [] data = new char[sLength];
		
		//populate the array
		for (int i = 0; i < sLength; i++) {
			data[i] = (char)(magnitude * Math.cos(frequency*2*Math.PI*((double)i/(double)sampleRate)+phase));
			result[i] = (byte)data[i];
		}
		/*
		for (char i : data) {
			System.out.print((int)i + " ");
		}
		System.out.println();
		//*/
		return result;
	}
	
	public void getMixerInfo() {
	
		
		
	}
	
	public void playSound(byte [] sound, int sampleRate) {
		
		new AudioPermission("play");
		Line.Info requestedLine = new Line.Info(Clip.class);
		Line.Info [] lines = AudioSystem.getMixer(null).getSourceLineInfo(requestedLine);
		
		for (Line.Info i : lines) {
			System.out.println(i.toString());
		}
		
		Clip sLine = null;
		try {
			sLine = AudioSystem.getClip();
			AudioFormat f = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, sampleRate, 8, 1, 1, sampleRate, true);
			sLine.open(f, sound, 0, sound.length);
			System.out.println(sLine.getMicrosecondLength());
			sLine.setMicrosecondPosition(0);
			sLine.start();
			int i = 0;
			while (sLine.isRunning()) {
				//do nothing
				i++;
			}
			sLine.flush();
			sLine.close();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
