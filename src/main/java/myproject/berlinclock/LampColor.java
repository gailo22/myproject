package myproject.berlinclock;

public enum LampColor {
	
	HOUR {

		@Override
		public String getOnColor() {
			return "R";
		}
	},
	MIN {
		
		@Override
		public String getOnColor() {
			return "Y";
		}
	},
	SEC {
		
		@Override
		public String getOnColor() {
			return "Y";
		}
	};
	
	public abstract String getOnColor();
	
	public static String getOffColor() {
		return "O";
	}
}
