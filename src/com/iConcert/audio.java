package com.iConcert;



import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;


import javax.sound.sampled.TargetDataLine;

import com.googlecode.javacv.FFmpegFrameRecorder;



public class audio implements Runnable {
	    AudioFormat audioFormat;
	    TargetDataLine targetDataLine;
	    FFmpegFrameRecorder recorder;
	    boolean runAudioThread = true;
	    boolean recording = false;

	    public audio(FFmpegFrameRecorder fFmpegFrameRecorder) {
	        recorder = fFmpegFrameRecorder;
	        try {
	            audioFormat = getAudioFormat();
	            DataLine.Info dataLineInfo =
	                    new DataLine.Info(
	                    TargetDataLine.class,
	                    audioFormat);
	            targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void captureAudio() {
	        try {
	            recording = true;
	            Thread t = new Thread(this);
	            t.start();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private AudioFormat getAudioFormat() {
	        float sampleRate = 44100.0F;
	        //8000,11025,16000,22050,44100
	        int sampleSizeInBits = 16;
	        //8,16
	        int channels = 1;
	        //1,2
	        boolean signed = true;
	        boolean bigEndian = false;

	        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	    }//end getAudioFormat

	    public void stopaudio() {
	        recording = false;
	        targetDataLine.stop();
	        targetDataLine.close();
	        runAudioThread = false;
	    }

	    @Override
	    public void run() {
	    	 Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
	         int bufferSize;
	         byte[] audioData;
	         int bufferReadResult;
	         try {
	              
	             bufferSize = targetDataLine.getBufferSize();
	             targetDataLine.open(audioFormat); 
	             audioData = new byte[bufferSize];
	             short[] shortArray = new short[bufferSize];

	             targetDataLine.start();
	             while (runAudioThread) {
	                 bufferReadResult = targetDataLine.read(audioData, 0, audioData.length);
	                 
	                 for (int index = 0; index < bufferSize; index++)                {
	                     shortArray[index] = (short) audioData[index];

	                 }
	                 if (bufferReadResult > 0 && recording) {
	                     try {        
	                         recorder.record(ShortBuffer.wrap(audioData, 0, bufferReadResult));
	                        
	                     } catch (FFmpegFrameRecorder.Exception e) {
	                         e.printStackTrace();
	                     }
	                 }
	             }
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	     }
}


