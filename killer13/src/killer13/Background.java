package killer13;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
public class Background {
	private Image front;	
	private AffineTransform tx;
	int dir = 0; 					//0-forward, 1-backward, 2-left, 3-right
	public static int width, height;
	int x, y;						//position of the object					//movement variables
	double scaleWidth = 1.0;		//change to scale image
	double scaleHeight = 1.0; 
	public Background() {
		front 	= getImage("/killer13/"+"table.jpg"); //loading background image

		//alter these
		width = 600;
		height = 600;  
		x = 0;
		y = 0;
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		
		init(x, y); 				//initialize the location of the image
									
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		init(x,y);
		switch(dir) {
		case 0:
			g2.drawImage(front, tx, null);
			break;
		
		}
	}
	public Image getForward() {
		return front;
	}

	public void setForward(Image front) {
		this.front = front;
	}
	public  int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public static  int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public static  int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
