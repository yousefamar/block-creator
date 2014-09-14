package blockCreator;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

public class ComboTabs extends JPanel {
    public ComboTabs() {
        super(new GridLayout(1, 1));
        
        //Create and set up the window.
        JFrame frame = new JFrame("Minecraft ModMaker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430,310);
	    frame.setLocationRelativeTo(null);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("img/pig.png");
        
        JPanel panel1 = new JPanel(false);
        panel1.setLayout(new GridLayout(1, 1));
        panel1.add(new BlockSetProperties());
        tabbedPane.addTab("Block", icon, panel1, "Create a Simple Block");
        
        JPanel panel2 = new JPanel(false);
        panel2.setLayout(new GridLayout(1, 1));
        panel2.add(new RecipeMaker());
        tabbedPane.addTab("Ore", icon, panel2, "Does twice as much nothing");
        
        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Tab 3", icon, panel3, "Still does nothing");
        
        JComponent panel4 = makeTextPanel("Panel #4 (has a preferred size of 410 x 50).");
        //panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Tab 4", icon, panel4, "Does nothing at all");
        
        //Add the tabbed pane to this panel.
        add(tabbedPane);
        
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        frame.add(this, BorderLayout.CENTER);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
    
    /** Returns an ImageIcon, or null if the path was invalid. */
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
