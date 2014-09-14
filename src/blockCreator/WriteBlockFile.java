package blockCreator;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WriteBlockFile extends JPanel
                             implements ActionListener {
	
    JButton browseButton;
    JFileChooser fc;

    public WriteBlockFile(int ID, float hardness, float resistance, String name, String imageName, String saveName) {
        super(new BorderLayout());
        
        gID = ID;
        ghardness = hardness;
        gresistance = resistance;
        gname = name;
        gimageName = imageName;
        gsaveName = saveName;

        browseButton = new JButton("Write");
        browseButton.addActionListener(this);

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(browseButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.EAST);
    }

    public void actionPerformed(ActionEvent e) {
    	try {
			new CodeWriter(gID, ghardness, gresistance, gname, gimageName, gsaveName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    
    public int gID;
    public float ghardness;
    public float gresistance;
    public String gname;
    public String gimageName;
    public String gsaveName;
    
}