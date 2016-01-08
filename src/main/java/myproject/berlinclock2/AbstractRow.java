package myproject.berlinclock2;

public abstract class AbstractRow implements OnColor {

	private static final int DEFAULT_ROW_SIZE = 4;

	private int time;
	
	private TypeEnum type;

	protected String offColor() {
		return "O";
	}

	public int getRowSize() {
		return DEFAULT_ROW_SIZE;
	}

	public String showColors() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < type.getNumberOfOnLamps(time); i++) {
			builder.append(onColor(i));
		}
		for (int i = type.getNumberOfOnLamps(time); i < getRowSize(); i++) {
			builder.append(offColor());
		}
		return builder.toString();
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}
}
