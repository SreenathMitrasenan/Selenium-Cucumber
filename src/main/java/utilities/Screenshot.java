package utilities;


//Java Program to Capture full 
//Image of Screen 
import java.awt.AWTException; 
import java.awt.Rectangle; 
import java.awt.Toolkit; 
import java.awt.Robot; 
import java.awt.image.BufferedImage; 
import java.io.IOException; 
import java.io.File; 
import javax.imageio.ImageIO; 

public class Screenshot { 
 
	public String CaptureScreen(String imgFormat,String screenshotName) {
		//Add scripts to create screenshots file if not exists
		File file = new File(System.getProperty("user.dir") + "/target/screenshots/");
		if(!file.exists()) {
			file.mkdir();
		}
		 File destinationPath = new File(System.getProperty("user.dir") + "/target/screenshots/" + screenshotName +"Test."+ imgFormat);
	 try {
         Robot robot = new Robot();
         Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
         BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
         ImageIO.write(screenFullImage, imgFormat, destinationPath);     
         System.out.println("A full screenshot saved!");
        		 } catch (AWTException | IOException ex) {
         System.err.println(ex);
     }
	return destinationPath.toString();
	
}
}