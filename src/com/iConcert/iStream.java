package com.iConcert;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacv.FFmpegFrameRecorder;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.FrameGrabber.Exception;
import com.googlecode.javacv.cpp.avcodec;
import com.googlecode.javacv.cpp.avutil;
import com.googlecode.javacv.cpp.opencv_objdetect;
import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

public class iStream extends Thread {
	private IplImage img = new IplImage();
	private  JLabel label;
	private JFrame father;
	private int filmWidth = 640;
	private int filmHeight = 480;
	private ImageIcon icon;
	public boolean isRunning = false;

	//JFrame i_father
	public iStream() {
		super();
		//this.father = i_father;
		label = new JLabel();
	}
	public iStream(JLabel oldLabel) {
		super();
		//this.father = i_father;
		label = oldLabel;
	}
	
	public void start(){
		super.start();
		isRunning = true;
	}
	
	public JLabel getLabelObject(){
		return label;
	}
	//設定影像長寬
	public void setFilmSize(){
		icon.setImage(icon.getImage().getScaledInstance(filmWidth,filmHeight,0));
	}
	//取得影像長寬
	public void setFilmSize(int width,int height){
		filmWidth = width;
		filmHeight = height;
	}
	@Override
	public void run(){
		Loader.load(opencv_objdetect.class);
        FrameGrabber grabber = new OpenCVFrameGrabber(0);
        
        //grabber.setImageHeight(1024);
        //grabber.setImageWidth(1024);
        //grabber.setFormat("h264");
        try {
			grabber.start();
	        IplImage grabbedImage = grabber.grab();
	        CvMemStorage storage = CvMemStorage.create();
	     
	        
	        //FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("mmsh://127.0.0.1:5004", grabber.getImageWidth(), grabber.getImageHeight());
	        //recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
	        //recorder.setFormat("h264");
	        //recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
	        //recorder.setFrameRate(30);
	        //recorder.setVideoBitrate(716800);
	
	       // recorder.start();
	        
	        while (isRunning && (grabbedImage = grabber.grab()) != null) {
				
	        	//cvSmooth(grabbedImage,grabbedImage, CV_GAUSSIAN, 3);
	        	//cvThreshold(grabbedImage,grabbedImage, 128, 255, CV_THRESH_BINARY);
	        	//	recorder.record(grabbedImage);
	        	img = grabbedImage;
				icon = new ImageIcon(img.getBufferedImage());
				setFilmSize();
				label.setIcon(icon);
	        }
			cvClearMemStorage(storage);
			//recorder.stop();
			grabber.stop();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
	}
	
	private static void cvClearMemStorage(CvMemStorage storage) {}

}
