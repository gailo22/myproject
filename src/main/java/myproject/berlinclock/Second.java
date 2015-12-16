package myproject.berlinclock;



public class Second implements Lamp {

	@Override
	public int getSize() {
		return 1;
	}

	@Override
	public String getColors(Integer time) {
		return time % 2 == 0 ? getOnColor(0) : LampColor.getOffColor();
	}

	@Override
	public String getOnColor(int index) {
		return LampColor.SEC.getOnColor();
	}

}
