package refractor;


	class Account {
	     float principal;
	     float rate;
	     int daysActive;
	     int accountType;
	    
	     public static final int STANDARD = 0;
	     public static final int BUDGET = 1;
	   
	     public static final int PREMIUM = 2;
	     public static final int PREMIUM_PLUS = 3;
	     
	     /*Since this calculation only uses data that is available in the Account class,  i moved it into that class, adding a new method called interestEarned (in lines 14 to 18 below)*/
	    //Introduce Explaining Variable was used to introduce two intermediate variables, years on  and compoundInterest , to clarify the code
	     float interestEarned() {
	    	 float years = daysActive / (float) 365.25;
	    	 float compoundInterest = principal * (float) Math.exp( rate * years );
	    	 return ( compoundInterest - principal );

	     }
	     //the Decompose Conditional refactoring, i am able to clarify the purpose of this code. Adding the isPremium function to the Account class
	     	    public boolean isPremium() {
	    	 	        if (accountType == Account.PREMIUM || accountType == Account.PREMIUM_PLUS)
	    	 	            return true;
	    	 	        else
	    		            return false;
	    	 	    }

	   	     float calculateFee(Account accounts[]) {
	   	        
	   	     float totalFee = 0;
	   	     Account account;
	   	     for (int i = 0; i < accounts.length; i++) {
	   	     account = accounts[i];
	   	     //the Replace Magic Number with Symbolic Constant refactoring, replacing it with the constant BROKER_FEE_PERCENT 
	   	       if ( account.isPremium() )
	   	    	 totalFee += BROKER_FEE_PERCENT * account.interestEarned();
	   	          
	   	        }
	   	        return totalFee;
	   	     }
	   	     static final double BROKER_FEE_PERCENT = 0.0125;
	     
	}
	    
