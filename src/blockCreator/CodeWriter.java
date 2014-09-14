package blockCreator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CodeWriter {
	
	public CodeWriter(int ID, float hardness, float resistance, String name, String imageFile, String saveFile) throws IOException {
		
		String nameT = name.replaceAll(" ", "");
		String nameTLC = nameT.toLowerCase();
		String data[] = { nameT,
						nameTLC,
						nameT,
						Integer.toString(ID),
						Float.toString(hardness),
						Float.toString(resistance),
						nameTLC,
						nameT,
						nameTLC,
						nameTLC,
						imageFile,
						nameTLC,
						name,
						saveFile + "/mod_" + nameT + ".java",
						saveFile + "/Block" + nameT + ".java" };
		new File(saveFile).mkdirs();
		File inputFile = new File("res/mod_Example.java");
		File outputFile = new File(data[13]);
		File inputFile2 = new File("res/Example.java");
		File outputFile2 = new File(data[14]);
		FileReader in = new FileReader(inputFile);
		FileWriter out = new FileWriter(outputFile);
		FileReader in2 = new FileReader(inputFile2);
		FileWriter out2 = new FileWriter(outputFile2);
		int c, i = 0;

		while ((c = in.read()) != -1) {
	    	if(c == (int)'$'){
	    		out.write(data[i]);
	    		i++;
	    	}
	    	else
	    		out.write(c);
	    }
		
		while ((c = in2.read()) != -1) {
	    	if(c == (int)'$'){
	    		out2.write(nameT);
	    	}
	    	else
	    		out2.write(c);
	    }
	    
	    in.close();
	    out.close();
	    in2.close();
	    out2.close();
	  }
	
}
