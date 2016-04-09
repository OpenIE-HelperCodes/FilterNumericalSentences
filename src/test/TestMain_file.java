/**
 * 
 */
package test;

import help.Util_Numerical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author harinder
 *
 */
public class TestMain_file {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Util_Numerical.init();
		
		BufferedReader br = new BufferedReader(new FileReader(new File("/home/harinder/Documents/IITD_MTP/iitd_mtp/NumericExtraction/extra_ws/MyProject/data/books/contemporary_world_politics/contemporary_world_politics.txt")));
		
		String line = br.readLine();
		
		List<String> filteredSentences = new ArrayList<String>();
		
		while(line != null) {
			String sentences[] = Util_Numerical.sentenceSplitter(line);
			for (String sentence : sentences) {
				try{
					if(!Util_Numerical.isReqNumber(sentence)) continue;
				} catch(Exception e) {
					System.err.println("------Continuing on Error: " + e);
				}
				//if(!Util_Numerical.isContainsMentionedEntities(sentence)) continue; //numberRuleSpecific
				
				filteredSentences.add(sentence);
			}
			line = br.readLine();
		}
		
		br.close();
		
		PrintWriter pw = new PrintWriter(new FileWriter("data/out_contemporary_world_politics.txt"));
		for (String filteredSentence : filteredSentences) {
			pw.println(filteredSentence);
		}
		
		pw.close();
	}
}
