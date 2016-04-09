/**
 * 
 */
package test;

import help.Util_Numerical;

/**
 * @author harinder
 *
 */
public class TestMain {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Util_Numerical.init();

		String line = "Stalin was responsible for the death of 4.4 million people within the borders of the Soviet Union";

		//System.out.println("I end with a number 4.".matches(("^.+?\\d.?$")));
		
		String sentences[] = Util_Numerical.sentenceSplitter(line);
		boolean flag = false;
		for (String sentence : sentences) {
			if(!Util_Numerical.isReqNumber(sentence)) continue;
			//if(!Util_Numerical.isContainsMentionedEntities(sentence)) continue; 
			flag = true; 
		}
		
		System.out.println(flag);
	}
}
