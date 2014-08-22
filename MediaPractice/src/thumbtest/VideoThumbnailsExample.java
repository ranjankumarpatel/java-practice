package thumbtest;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.MediaListenerAdapter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.mediatool.event.IVideoPictureEvent;
import com.xuggle.xuggler.Global;

public class VideoThumbnailsExample {
	
	

	public static final double SECONDS_BETWEEN_FRAMES = 10;

	private static String name;
	
	private static File videodir = new File("E:/mediatest");
    
    private static final File outputFilePrefix = new File("E:/mediatest");
    
    // The video stream index, used to ensure we display frames from one and
    // only one video stream from the media container.
    private static int mVideoStreamIndex = -1;
    
    // Time of last frame write
    private static long mLastPtsWrite = Global.NO_PTS;
    
    public static final long MICRO_SECONDS_BETWEEN_FRAMES = 
        (long)(Global.DEFAULT_PTS_PER_SECOND * SECONDS_BETWEEN_FRAMES);

    public static void main(String[] args) {
    	
    	name = "Ultimate Spider-Man_ Web Warriors - 308 [New Warriors]";
    	final String inputFilename = new File(videodir,name+".flv").getAbsolutePath();
    	

        IMediaReader mediaReader = ToolFactory.makeReader(inputFilename);
        

        // stipulate that we want BufferedImages created in BGR 24bit color space
        mediaReader.setBufferedImageTypeToGenerate(BufferedImage.TYPE_3BYTE_BGR);
        
        mediaReader.addListener(new ImageSnapListener());

        // read out the contents of the media file and
        // dispatch events to the attached listener
        while (mediaReader.readPacket() == null) ;

    }

    private static class ImageSnapListener extends MediaListenerAdapter {

    	private int counter;
    	
        public void onVideoPicture(IVideoPictureEvent event) {
        	
        	

            if (event.getStreamIndex() != mVideoStreamIndex) {
                // if the selected video stream id is not yet set, go ahead an
                // select this lucky video stream
                if (mVideoStreamIndex == -1)
                    mVideoStreamIndex = event.getStreamIndex();
                // no need to show frames from this video stream
                else
                    return;
            }

            // if uninitialized, back date mLastPtsWrite to get the very first frame
            if (mLastPtsWrite == Global.NO_PTS)
                mLastPtsWrite = event.getTimeStamp() - MICRO_SECONDS_BETWEEN_FRAMES;

            // if it's time to write the next frame
            if (event.getTimeStamp() - mLastPtsWrite >= 
                    MICRO_SECONDS_BETWEEN_FRAMES) {
                                
                String outputFilename = dumpImageToFile(event.getImage());

                // indicate file written
                double seconds = ((double) event.getTimeStamp()) / 
                    Global.DEFAULT_PTS_PER_SECOND;
                System.out.printf(
                        "at elapsed time of %6.3f seconds wrote: %s\n",
                        seconds, outputFilename);

                // update last write time
                mLastPtsWrite += MICRO_SECONDS_BETWEEN_FRAMES;
                System.out.println(MICRO_SECONDS_BETWEEN_FRAMES+" : "+mLastPtsWrite+" : "+event.getTimeStamp());
                System.out.println(event.getTimeStamp() - mLastPtsWrite);
                counter++;
                if(counter>1){
                	System.exit(0);
                }
            }

        }
        
        private String dumpImageToFile(BufferedImage image) {
            try {
            	
                File outputFilename = new File(outputFilePrefix,name + ".png");
                ImageIO.write(image, "png", outputFilename);
                
                resizeImage(outputFilename, 50);
                resizeImage(outputFilename, 25);
                
                return outputFilename.getAbsolutePath();
            } 
            catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        
        private void resizeImage(File rawfile,float percent) throws IOException{
        	BufferedImage img = ImageIO.read(rawfile);
        	float point = percent/100;      
        	File outputFilename = new File(outputFilePrefix,name +Float.toString(percent)+"%.png");
        	
        	
        	ImageIO.write(resizeImagePercentage(img, point), "png", outputFilename);
        }
        
        
        
        

    }
    
    private static BufferedImage resizeImagePercentage(BufferedImage originalImage,float point){
    	  	
    	int scaleX = (int) (originalImage.getWidth() * point);
    	int scaleY = (int) (originalImage.getHeight() * point);
    	BufferedImage resizedImage = new BufferedImage(scaleX, scaleY, Image.SCALE_SMOOTH);
    	Graphics2D g = resizedImage.createGraphics();
    	g.drawImage(originalImage, 0, 0, scaleX, scaleY, null);
    	g.dispose();
     
    	return resizedImage;
    }
}
