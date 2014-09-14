package blockCreator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RecipeMaker extends JPanel
						implements PropertyChangeListener {
	
	public int ID = 2258;
	private JFormattedTextField IDField;
	
	public RecipeMaker() {
		ArrayList<ItemChooser> slots = new ArrayList<ItemChooser>();
		for(int i=0;i<9;i++)
			slots.add(new ItemChooser());
		
		JPanel craftPane = new JPanel(new GridLayout(0,3));
		for(int i=0;i<9;i++)
			craftPane.add(slots.get(i));
		
		JPanel guiPane = new JPanel(new GridBagLayout());
		//guiPane.setPreferredSize(new Dimension(400,200));
		guiPane.add(craftPane);
		ImageIcon arrowIco = createImageIcon("img/pig.png");
		JLabel arrowLab = new JLabel(arrowIco);
		JPanel arrowPane = new JPanel(new GridLayout(0,1));
		arrowPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		arrowPane.add(arrowLab);
		guiPane.add(arrowPane);
		guiPane.add(new CraftResult());
		
		NumberFormat IDFormat = NumberFormat.getNumberInstance();
	    IDField = new JFormattedTextField(IDFormat);
	    IDField.setValue(ID);
	    IDField.setColumns(10);
	    IDField.addPropertyChangeListener("value", this);
	    
	    JLabel IDLabel = new JLabel("ID: ");
	    IDLabel.setOpaque(true);
	    IDLabel.setLabelFor(IDField);
	    
	    JPanel lowerPane =  new JPanel(new GridBagLayout());
	    IDField.setToolTipText("Enter a unique item ID.");
	    lowerPane.add(IDLabel);
	    lowerPane.add(IDField);
		
	    JPanel contentPane =  new JPanel(new GridLayout(0,1));
		contentPane.add(guiPane, BorderLayout.CENTER);
		contentPane.add(lowerPane, BorderLayout.SOUTH);
		
		add(contentPane);
		
	}

	public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == IDField) {
        	ID = ((Number)IDField.getValue()).intValue();
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
}
