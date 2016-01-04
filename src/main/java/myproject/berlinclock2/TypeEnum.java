package myproject.berlinclock2;

public enum TypeEnum {
	
	TOP {
	    @Override
	    public int getNumberOfOnLamps(int time) {
		    return time  / getDivisor();
	    }
    },
	BOTTOM {
	    @Override
	    public int getNumberOfOnLamps(int time) {
		    return time  % getDivisor();
	    }
    };
	
	
	public abstract int getNumberOfOnLamps(int time);
	
	public int getDivisor() {
		return 5;
	}

}
