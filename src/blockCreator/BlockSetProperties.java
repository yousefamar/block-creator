package blockCreator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.io.IOException;

import java.text.*;

public class BlockSetProperties extends JPanel
								implements PropertyChangeListener, ActionListener {
	
	
	public int ID = 96;
	private JFormattedTextField IDField;
	
	public float hardness = 1.5F;
	private JFormattedTextField hardnessField;
	
	public float resistance = 10F;
	private JFormattedTextField resistanceField;
	
	public String name = "";
	private JTextField nameField;
	
	public PathChoser imageFile;
    public FileChoser saveFile;
    
    private JButton writeButton;
    private JFileChooser fc;
	
	public BlockSetProperties() {
		super(new BorderLayout());
		//Create and set up the window.
	    //JFrame frame = new JFrame("Minecraft Ore Creator");
	    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    // make the frame half the height and width
	    //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    //frame.setSize(430,310);
	    //frame.setLocationRelativeTo(null);

	    //Create a yellow label to put in the content pane.
	    //JLabel yellowLabel = new JLabel();
	    //yellowLabel.setOpaque(true);
	    //yellowLabel.setPreferredSize(new Dimension(800, 500));

	    //Add a label to the content pane.
	    //frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);
	    
	    //CreateFields
	    NumberFormat IDFormat = NumberFormat.getNumberInstance();
	    IDField = new JFormattedTextField(IDFormat);
	    IDField.setValue(ID);
	    IDField.setColumns(10);
	    IDField.addPropertyChangeListener("value", this);
	    
	    NumberFormat hardnessFormat = NumberFormat.getNumberInstance();
	    hardnessField = new JFormattedTextField(hardnessFormat);
	    hardnessField.setValue(hardness);
	    hardnessField.setColumns(10);
	    hardnessField.addPropertyChangeListener("value", this);
	    
	    NumberFormat resistanceFormat = NumberFormat.getNumberInstance();
	    resistanceField = new JFormattedTextField(resistanceFormat);
	    resistanceField.setValue(resistance);
	    resistanceField.setColumns(10);
	    resistanceField.addPropertyChangeListener("value", this);
	    
	    nameField = new JTextField(20);
        nameField.addActionListener(this);
        
	    
	    //Add labels to fields.
	    JLabel IDLabel = new JLabel("ID: ");
	    IDLabel.setOpaque(true);
	    IDLabel.setLabelFor(IDField);
	    
	    JLabel hardnessLabel = new JLabel("Hardness: ");
	    hardnessLabel.setOpaque(true);
	    hardnessLabel.setLabelFor(hardnessField);
	    
	    JLabel resistanceLabel = new JLabel("Resistance: ");
	    resistanceLabel.setOpaque(true);
	    resistanceLabel.setLabelFor(resistanceField);
	    
	    JLabel nameLabel = new JLabel("Name: ");
	    nameLabel.setOpaque(true);
	    nameLabel.setLabelFor(nameField);
	    
	    JLabel fileLabel = new JLabel("Texture: ");
	    nameLabel.setOpaque(true);
	    
	    JLabel saveLabel = new JLabel("Save Java to: ");
	    nameLabel.setOpaque(true);
	    
	    //Lay out the labels in a panel.
	    JPanel contentPane = new JPanel(new GridLayout(0,2));
	    contentPane.setPreferredSize(new Dimension(400,200));
	    contentPane.add(IDLabel);
	    contentPane.add(IDField);
	    IDField.setToolTipText("Enter a unique item ID.");
	    contentPane.add(hardnessLabel);
	    contentPane.add(hardnessField);
	    hardnessField.setToolTipText("Enter hardeness.\n0 = One click break.\n10 = Obsidian hardness etc.\n");
	    contentPane.add(resistanceLabel);
	    contentPane.add(resistanceField);
	    resistanceField.setToolTipText("Enter resistance to explosions.");
	    contentPane.add(nameLabel);
	    contentPane.add(nameField);
	    nameField.setToolTipText("Enter the name that appears on mouseover.");
	    contentPane.add(fileLabel);
	    contentPane.add(imageFile = new PathChoser());
	    contentPane.add(saveLabel);
	    contentPane.add(saveFile = new FileChoser());
        
		writeButton = new JButton("Write");
        writeButton.addActionListener(this);

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(writeButton);
        
        //Put the panels in the frame.
        //setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel propPanel = new JPanel();
        propPanel.setBorder(BorderFactory.createTitledBorder("Choose Block Properties."));
	    propPanel.add(contentPane, BorderLayout.CENTER);
        
        add(propPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
	    //Display the window.
	    //frame.pack();
        //frame.add(this);
	    //frame.setVisible(true);
	}

	public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == IDField) {
        	ID = ((Number)IDField.getValue()).intValue();
        } else if (source == hardnessField) {
        	hardness = ((Number)hardnessField.getValue()).floatValue();
        } else if (source == resistanceField) {
        	resistance = ((Number)resistanceField.getValue()).floatValue();
        }
    }
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		name = nameField.getText();
		JFrame frame = null;
		if (source == writeButton && !(saveFile.fileName.equals("")))
		{
			try {
				new CodeWriter(ID, hardness, resistance, name, imageFile.fileName, saveFile.fileName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(frame, "Files created successfully at " + saveFile.fileName + ".");
		} else if (source == writeButton && saveFile.fileName.equals("")) {
			JOptionPane.showMessageDialog(frame, "Please chose a directory to save to first.");
		}
    }
	
}