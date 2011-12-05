package myproject;

public abstract class ErrorCondition {

	public abstract boolean isMet();
	
	public ErrorCondition and(final ErrorCondition otherCondition) {
		final ErrorCondition condition = this;
		return new ErrorCondition() {
			@Override
			public boolean isMet() {
				return condition.isMet() && otherCondition.isMet();
			}
		};
	}
	
	public ErrorCondition or(final ErrorCondition otherCondition) {
		final ErrorCondition condition = this;
		return new ErrorCondition() {
			@Override
			public boolean isMet() {
				return condition.isMet() || otherCondition.isMet();
			}
		};
	}
}
