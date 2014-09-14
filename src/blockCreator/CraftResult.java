package blockCreator;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CraftResult extends JPanel
						implements ActionListener {
	
	public FileChoser imageFile;
	public String imageName;
	public JLabel imgLab;
	
	public CraftResult() {
		
		JPanel contentPane = new JPanel(new GridLayout(0,1));
		ImageIcon imgIco = createImageIcon("img/pig.png");
		imgLab = new JLabel(imgIco);
		imgLab.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		JPanel topPane = new JPanel(new GridBagLayout());
		JButton updateButton = new JButton("Update");
	    updateButton.addActionListener(this);
	    topPane.add(imgLab);
	    topPane.add(updateButton);
		contentPane.add(topPane);
		contentPane.add(imageFile = new FileChoser());
		add(contentPane);
		setBorder(BorderFactory.createEmptyBorder(40,0,0,0));
		
	}
	
	public void actionPerformed(ActionEvent e) {
        File file = imageFile.fc.getSelectedFile();
        if(file != null) {
	        imageName = imageFile.fileName;
	        imgLab.setIcon(changeResult(imageName));
        }
    }
	
	protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ComboTabs.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
	protected static ImageIcon changeResult(String path) {
        if (path != null) {
            return new ImageIcon(path);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}
