package oldFashionPound2;

//class used for entry verification and conversion to Integer data type

public class VerifyString {
		
	//verify PSD String
	public Boolean isVerified(String s){
		char[] charArr = new char[s.length()];
		int length = s.length();
		if (length<7){return false;}
		charArr = s.toCharArray();
		int[] intArr = new int[s.length()];
		boolean poundsval = true;
		for (int i = 0; i < (length - 7); i++){
	        intArr[i] = Character.getNumericValue(charArr[i]);
	        
	        if ((intArr[i]>=0)&&(intArr[i]<=9)){}//do nothing
	        else{poundsval = false;
	        	break;        		        	
	        }
		}
		
		if (
				(charArr[length-1]=='d')&&
				(charArr[length-4]=='s')&&
				(charArr[length-7]=='p')&&
				((intArr[length-2]>=0)&&(intArr[length-2]<=9))&&
				((intArr[length-3]>=0)&&(intArr[length-3]<=9))&&
				((intArr[length-5]>=0)&&(intArr[length-5]<=9))&&
				((intArr[length-6]>=0)&&(intArr[length-6]<=9))&&
				(poundsval))
				{return true;}else{return false;}		
		}
	
	// verify operation String
	public Boolean opIsVerified(String s){
		
		switch (s) {
		case "PLUS":
			return true;		
		case "MINUS":
			return true;
		case "DIV":
			return true;		
		case "SUM":
			return true;
		}
		return false;
	}

	//return an Integer value of the tested input
	public int getRealval(String s) {		
			int length = s.length();
			int[] intArr = new int[s.length()]; // local arrays
			char[] charArr = new char[s.length()];
			charArr = s.toCharArray();
			
			for (int i = 0; i < (length - 7); i++){
		        intArr[i] = Character.getNumericValue(charArr[i]);	        	        	       
			}
			
			int poundnum=0;
			int place = 1;
								//	math and loops to convert the parts of the string (char array) to numbers
			for (int i = (length - 8); i > 0; --i){			
				try{
				poundnum = poundnum + (intArr[i]*place);
		        place = place * 10; // increment of decimal place value for larger numbers  
			    		        
			    }catch(NumberFormatException nfe){
			        System.err.println("Invalid Format!");// large number check
			    }
			}
			poundnum = poundnum + (intArr[0]*place);
			
			int schVal = (Character.getNumericValue(charArr[length-6])*10)+(Character.getNumericValue(charArr[length-5]));
			int penVal = (Character.getNumericValue(charArr[length-3])*10)+(Character.getNumericValue(charArr[length-2]));
			
			return poundnum*240+schVal*12+penVal; 
			
		}
		
	
	

}
