package myproject.berlinclock2;

public class Minute extends AbstractRow implements Row {

	public Minute(int time, TypeEnum type) {
		setTime(time);
		setType(type);
	}

	@Override
	public String onColor(int index) {
		if (getType() == TypeEnum.TOP && (index + 1) % 3 == 0) {
			return "R";
		}

		return "Y";
	}

	@Override
	public int getRowSize() {
		return getType() == TypeEnum.TOP ? 11 : 4;
	}

}
