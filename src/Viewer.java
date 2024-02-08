
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Viewer extends JFrame {
	
	private final int FRAME_WIDTH = 1200;
	private final int FRAME_HEIGHT = 800;
	JPanel mainPanel;
	
	public void start(){
		
		setTitle("Mandelbrot Set Viewer");
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		mainPanel = new JPanel(new BorderLayout() );
		
		//drawFrame(100);
				for(int i =0; i<100; i++){
					drawFrame(i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
		
	}
	
	private void drawFrame(int i){
		try {
			MandelbrotColor mb = new MandelbrotColor();
			
			BufferedImage img = mb.generate(i);
			ImageIO.write(img, "png", new File(i + "mandelbrot.png"));
			//int scale  = i %100;
			JLabel s = new JLabel("i: " + i);
//			if(scale > 1){
//			 img = new BufferedImage(img.getWidth()* scale, img.getHeight()* scale, img.getType());
//			 Graphics2D grph = (Graphics2D) img.getGraphics();
//		     grph.scale(scale, scale);
//			}
			ImageIcon icon = new ImageIcon(img);
			JLabel label = new JLabel(icon);
			JScrollPane scroll = new JScrollPane(label);
			//scroll.add(label);
			mainPanel.add(scroll, BorderLayout.CENTER);
			mainPanel.add(s, BorderLayout.NORTH);
			add(mainPanel);
			setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
