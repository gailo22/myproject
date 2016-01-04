package myproject.berlinclock2;

public class Hour extends AbstractRow implements Row {

	public Hour(int time, TypeEnum type) {
		setTime(time);
		setType(type);
	}

	@Override
	public String onColor(int index) {
		return "R";
	}

}
