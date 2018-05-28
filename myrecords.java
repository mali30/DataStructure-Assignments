
	public class moesrecord implements Comparable<moesrecord> {
	    private String fname;
	    private String lname;
	    private String pnum;
	    
	
	    public moesrecord(){
	fname=" ";
	lname=" ";
	pnum=" ";
	}
	    public moesrecord(String firstName, String lastName, String phoneNumber){
	        fname = firstName;
	        lname = lastName;
	        pnum = phoneNumber;
	    }
	    
	    public moesrecord(String lastName, String phoneNumber){
	        fname = "";
	        lname = lastName;
	        pnum = phoneNumber;
	    }
	    
	    public moesrecord(String phoneNumber){
	        fname = "";
	        lname = "";                
	        pnum = phoneNumber;
	    }
	    
	    /**
	     * Purpose: The method will compare the last names and will order accordingly 
	     * Pre: This method will accept an instance of the object moesrecord
	     * Post: The method will take precedence of checking the last name and will then check
	     * the first name. 
	     * 
	     */
	    public int compareTo(moesrecord compar){
	    	if(lname.compareTo(compar.lname)!=0) {
	    	return lname.compareTo(compar.lname);}
	    	else if(fname.compareTo(compar.fname)!=0){
	    		return fname.compareTo(compar.fname);}
	    	else
	    	
	    	 return pnum.compareTo(compar.pnum);
	    }
	    
	
	    public String getFirstName(){
	        return fname;
	    }
	    public String getLastName(){
	        return lname;
	    }
	    public String getNumber(){
	        return pnum;   
	    }
	    public void setFirstName(String A){
	        fname=A;
	    }
	    public void setLastName(String B){
	        lname= B;
	    }
	    public void setNumber(String C){
	        pnum= C;   
	    }
	    public String toString(){
	            return fname+"                        "+lname+"                  "+pnum;}
	    
	    
	    
	    
	
	    }
	
