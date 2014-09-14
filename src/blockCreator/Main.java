package blockCreator;

import java.io.IOException;

import javax.swing.SwingUtilities;
//import javax.swing.UIManager;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	UIManager.put("swing.boldMetal", Boolean.FALSE);
            	new ComboTabs();
            }
        });
        //new CodeWriter();
    }
	
}
