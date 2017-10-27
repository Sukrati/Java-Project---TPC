
public class DateCheck {

	//this method extracts sub strings and convert them to integer data type
	int dateCheck(String d1,String d2)       
	{
		int n=0;
		System.out.println(d1);
		System.out.println(d2);
		int y1,y2,m1,m2,t1,t2;
		y1=Integer.parseInt(d1.substring(0,4));
		//System.out.println(y1);
		y2=Integer.parseInt(d2.substring(0,4));
		m1=Integer.parseInt(d1.substring(5,7));
		m2=Integer.parseInt(d2.substring(5,7));
		t1=Integer.parseInt(d1.substring(8,10));
		t2=Integer.parseInt(d2.substring(8,10));
		if(y1<=y2){
			if(m1<=m2 && t1<=t2){
		int sdate=validDate(y1,m1,t1);
		int edate=validDate(y2,m2,t2);
		if(sdate==1 && edate==1)
		{
			n=1;
		}
		}
		}
		return n;
	}
	
	
	//this method checks whether a date is valid or not
	 int validDate(int y, int m, int d) 
	 {
		 int leap=0,correct=0;
		 if(y % 400 == 0 || (y % 100 != 0 && y % 4 == 0))
		 {
			 leap=1;
		 }
		 if(m<13)
		 {
			 if (m == 1 || m == 3 || m == 5 || m==7 || m==8 ||m==10 ||m==12)
			 {
				 if(d<=31)
					 correct=1;
			 }
			 else if(m==4 || m==6 || m==9 || m==11)
			 {
				 if(d<=30)
					 correct=1;
			 }
			 else
			 {
				 if(leap==1)
				 {
					 if(d<=29)
						 correct=1;
				 }
				 if(leap==0)
				 {
					 if(d<=28)
						 correct=1;
					 
				 }
			 }
		 }
		 return correct;
	 }
	

}
