package oldFashionPound2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
	
	public String readString (String textDisp) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print(textDisp);
    String s = br.readLine();
    return s;
	}		
	
}
