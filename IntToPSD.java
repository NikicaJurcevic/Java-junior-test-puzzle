package oldFashionPound2;

public class IntToPSD {
	
	public String inttoold (int val){
		String intold;
		int p,s,d;
		p=s=d=0;
		for (int i = 0; i < val; i++){
			d++;
			if (d>11){
				d=0;
				s++;
			}
			if (s>19){
				s=0;
				p++;
			}
			
		}
		intold = (Integer.toString(p)) + "p " + (Integer.toString(s)) + "s " + (Integer.toString(d)) + "d ";
		return intold;
	}

	

}
