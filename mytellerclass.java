public class mytellerclass {

		

	    private boolean myfreebank;
	    private int cust;
	    private int tel;
	    private long finish;
	     
	    public mytellerclass() {
	        myfreebank = true;
	        cust = 0;
	        tel = 0;
	        finish = 0;
	    }
	 
	    public int getCust() {
	        return cust;
	    }
	 
	    public void setCust(int cust) {
	        this.cust = cust;
	    }
	 
	    public int getTel() {
	        return tel;
	    }
	 
	    public void setTel(int tel) {
	        this.tel = tel;
	    }
	 
	    public boolean isbankfree() {
	        return myfreebank;
	    }
	 
	    public void isBankFree(boolean myfreebank) {
	        this.myfreebank = myfreebank;
	    }
	 
	    public long getFinish() {
	        return finish;
	    }
	 
	    public void setFinish(long finish) {
	        this.finish = finish;
	    }
	 
	    public String toString() {
	        return "Customers helped: " + cust + "\n" + " in seconds " + tel;
	    }
	}
