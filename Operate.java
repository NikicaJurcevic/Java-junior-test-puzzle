package oldFashionPound2;

import java.io.IOException;

public class Operate {
	
	protected String s;
	protected int intval1, intval2;
	
	public void go () throws IOException{
		
		ConsoleReader read1 = new ConsoleReader();
		VerifyString ver = new VerifyString();
		
		//FIRST VALUE
		s = read1.readString("Enter pounds/schillings/pennies in this format\n 3p02s03d, 123p03s33d ...\n Two digits for schilling and penny: ");		
		if(ver.isVerified(s)){/*all ok*/;}else{System.out.println("error");System.exit(0);}
		intval1 = ver.getRealval(s);		
				
		//OPERATION
		s = read1.readString("Choose a mathematical operation like this: PLUS, MINUS, SUM or DIV: ");			
		if(ver.opIsVerified(s)){/*all ok*/;}else{System.out.println("error. Input a math operation in capital letters");System.exit(0);}
		
		//SECOND ENTRY AND MAIN OPERATION
		IntToPSD convert = new IntToPSD();// Converting an Integer value to the pounds-schilling-penny format I selected. Has final method inttoold
		switch (s) {
		case "PLUS":			
			s = read1.readString("Enter the second value in this format\n 3p02s03d, 123p03s33d ...\n Two digits for schilling and penny: ");
			if(ver.isVerified(s)){/*all ok*/;}else{System.out.println("error");System.exit(0);}
			intval2 = ver.getRealval(s);
			
			try{
				int plusint = intval1 + intval2;
				System.out.println("The result is: " + convert.inttoold(plusint));
			    		        
			    }catch(NumberFormatException nfe){
			        System.err.println("Invalid Format!");// large number check
			    }			
				
			break;
		
		case "MINUS":			
			s = read1.readString("Enter the second value in this format\n 3p02s03d, 123p03s33d ...\n Two digits for schilling and penny: ");
			if(ver.isVerified(s)){/*all ok*/;}else{System.out.println("error");System.exit(0);}
			intval2 = ver.getRealval(s);
			
			try{
				int minusint = intval1 - intval2;
				if (minusint<0){System.out.println("returns negative!");System.exit(0);}
				System.out.println("The result is: " + convert.inttoold(minusint));
			    		        
			    }catch(NumberFormatException nfe){
			        System.err.println("Invalid Format!");// large number check
			    }			
				
			break;
			
			
		case "SUM":			
			s = read1.readString("Enter an positive Integer value: ");
			
			try{
				int sumint = intval1 * Integer.parseInt(s);
				if (sumint<0){System.out.println("error");System.exit(0);}
				System.out.println("The result is: " + convert.inttoold(sumint));
			    		        
			    }catch(NumberFormatException nfe){
			        System.err.println("Invalid Format!");// large number check
			    }			
				
			break;
			
		case "DIV":			
			s = read1.readString("Enter an positive Integer value: ");
			if (Integer.parseInt(s)<1){System.out.println("error");System.exit(0);}
			
			try{
				int divint = intval1 / Integer.parseInt(s);				
				System.out.println("The result is: " + convert.inttoold(divint));
			    		        
			    }catch(NumberFormatException nfe){
			        System.err.println("Invalid Format!");// large number check
			    }			
				
			break;	
			
		} // end switchbox
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

}
