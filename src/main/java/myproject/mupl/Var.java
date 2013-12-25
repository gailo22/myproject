package myproject.mupl;

public class Var extends Exp {
	
	int i;
	
	Var(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return String.valueOf(i);
	}
	
	

}
