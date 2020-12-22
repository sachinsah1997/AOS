import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
import java.io.File; 
import java.io.IOException; 

// methods and data member are encapsulated in class.
class CompareImage 
{ 
	// program exeution start from here. this is the main method as driver method
	public static void main(String[] args) 
	{ 
		// This BufferedImage is the subclass of Image Class.
		// It is used to handle and manipulate the image data.
		BufferedImage imgA = null; 
		BufferedImage imgB = null; 

		try
		{ 
			// this file class is used to searh and excess file from directory/path specified.
			// both image file are excessed.
			File fileA = new File("/home/sachinsah/check/imagediff1.png"); 
			File fileB = new File("/home/sachinsah/check/imagediff2.png"); 

			//ImageIO is a utility class which provides lots of utility method related to images processing in Java. 
			//Most common of them is reading form image file and writing images to file in java.
			//here it it reading both the file and storing in the bufferedImage object.
			imgA = ImageIO.read(fileA); 
			imgB = ImageIO.read(fileB); 
		}
		// if any exception occurs while reading or accessing files then it will be
		// handled here in this catch block. 
		catch (IOException e) 
		{ 
			System.out.println(e); 
		}

		// this methods are in BufferImage class.
		//this will get us width of the image A.
		int width1 = imgA.getWidth(); 
		//this will get us width of the image B.
		int width2 = imgB.getWidth(); 
		//this will get us height of the image A.
		int height1 = imgA.getHeight(); 
		//this will get us height of the image B.
		int height2 = imgB.getHeight(); 

		//This will compare width and height of both the image. resolution comparing.
		if ((width1 != width2) || (height1 != height2))
		// if dimension not match it will return this and program terminates. 
			System.out.println("Image resolution is not match"); 
		else
		{ 
			long difference = 0; 
			// if dimension is same we will traverse from each pixel(x,y) and compare it.
			for (int y = 0; y < height1; y++) 
			{ 
				for (int x = 0; x < width1; x++) 
				{ 
					// getting rgb of x and y point in the image A.
					int rgbA = imgA.getRGB(x, y); 
					// getting rgb of x and y point in the image B.
					int rgbB = imgB.getRGB(x, y); 
					//getting red, blue and green value from that rgb value from Image A.
					int redA = (rgbA >> 16) & 0xff; 
					int greenA = (rgbA >> 8) & 0xff; 
					int blueA = (rgbA) & 0xff; 
					//getting red, blue and green value from that rgb value from Image B.	
					int redB = (rgbB >> 16) & 0xff; 
					int greenB = (rgbB >> 8) & 0xff; 
					int blueB = (rgbB) & 0xff; 
					
					//differencing rgb of same point(x,y) in both image and adding it.
					difference += Math.abs(redA - redB); 
					difference += Math.abs(greenA - greenB); 
					difference += Math.abs(blueA - blueB); 
				} 
			} 

			// Total number of red pixels = width * height 
			// Total number of blue pixels = width * height 
			// Total number of green pixels = width * height 
			// So total number of pixels = width * height * 3 
			double total_pixels = width1 * height1 * 3; 

			// Normalizing the value of different pixels 
			// for accuracy(average pixels per color 
			// component) 
			double avg_different_pixels = difference / 
										total_pixels; 

			// There are 255 values of pixels in total 
			double percentage = (avg_different_pixels / 
											255) * 100; 

			System.out.println("Difference Percentage-->" + 
												percentage); 
		} 
	} 
} 
