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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author harinder
 *
 */
public class Run_FileMode {
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Util_Numerical.init();
		
		//File folder = new File("/home/harinder/Documents/IITD_MTP/numericSentencesKiKhoj/CluewebSeUmeed/0004wb/");
		File folder = new File(args[0]);
		
		List<String> files = new ArrayList<>();
		Util_Numerical.listFilesForFolder(folder, files);
		
		for (String file : files) {
			System.out.println("Starting with file:" + file);
			int count = 0;
			BufferedReader br = new BufferedReader(new FileReader(new File(file)));
			
			String line = br.readLine();
			
			Set<String> filteredSentences = new HashSet<String>();
			
			while(line != null) {
				count++;
				if(count%1000==0) System.out.println(count);
				
				if(count >= 300000) break;
				
				String sentences[] = Util_Numerical.sentenceSplitter(line);
				for (String sentence : sentences) {
					try{
						if(Util_Numerical.containsUnwantedCharacter(sentence)) continue; //TODO: it shouldn't be here?
						if(!Util_Numerical.isReqNumber(sentence)) continue;
					} catch(Exception e) {
						//System.err.println("------Continuing on Error: " + e);
						continue;
					}
					//if(!Util_Numerical.isContainsMentionedEntities(sentence)) continue; //numberRuleSpecific
					
					filteredSentences.add(sentence);
				}
				line = br.readLine();
			}
			
			br.close();
			
			System.out.println("Printing sentences for file: " + file);
			PrintWriter pw = new PrintWriter(new FileWriter(file+"_filtered"));
			for (String filteredSentence : filteredSentences) {
				pw.println(filteredSentence);
			}
			
			pw.close();
		}
	}
	
}
