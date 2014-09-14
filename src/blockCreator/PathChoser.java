package blockCreator;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PathChoser extends JPanel
                             implements ActionListener {
	
    JButton browseButton;
    JFileChooser fc;
    
    public String fileName = "";
    private JTextField fileField = new JTextField(20);

    public PathChoser() {
        super(new BorderLayout());

        //Create a file chooser
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        browseButton = new JButton("Browse");
        browseButton.addActionListener(this);
        fileField.setEditable(false);
        fileField.setColumns(8);

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(browseButton);
        JPanel fieldPanel = new JPanel(); //use FlowLayout
        fieldPanel.add(fileField);
        //fieldPanel.setPreferredSize(new Dimension(150,100));

        //Add the buttons and the log to this panel.
        
        add(fieldPanel, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.EAST);
    }

    public void actionPerformed(ActionEvent e) {
    	
    	//Handle browse button action.
        fc.showOpenDialog(PathChoser.this);
        File file = fc.getSelectedFile();
        if(file != null) {
	        fileName = file.getAbsolutePath();
	        fileField.setText(file.getName());
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = PathChoser.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
}