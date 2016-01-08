package myproject.berlinclock2;

public class Second implements Row {

	private int time;

	public Second(Integer time) {
		this.time = time;
	}

	@Override
	public String showColors() {
		return time % 2 == 0 ? "Y" : "O";
	}

}
