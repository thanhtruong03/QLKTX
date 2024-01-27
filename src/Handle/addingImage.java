/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handle;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 *
 /* 
 *  Code example to add an image into JPanel
 */
public class addingImage{

	public static void main(String[] args) throws IOException {
		JFrame f= new JFrame("Panel with image");    
		JPanel panel=new JPanel();  
		panel.setLayout(new FlowLayout());      
		BufferedImage myPicture = ImageIO.read(new File("E:\\PTIT_Documents\\OOP\\Thuc_hanh\\Lab4\\QLKTX\\src\\img\\logoPtit.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		panel.add(picLabel);
		f.add(panel);
		f.setSize(500,500);            
		f.setVisible(true); 
	}
}

