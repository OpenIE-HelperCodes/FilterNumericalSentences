/**
 * 
 */
package test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


/**
 * @author harinder
 *
 */
public class temp {

	/**
	 * @param args
	 * @throws java.text.ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		   NumberFormat format = NumberFormat.getInstance(Locale.US);
		    Number number = format.parse("1,234,55.88");
		    double d = number.doubleValue();
		    System.out.println(d);
	}

}
