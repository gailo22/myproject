package myproject;

class Ball extends Throwable {
}

public class P {
	P target;

	P(final P target) {
		this.target = target;
	}

	void aim(final Ball ball) {
		try {
			throw ball;
		} catch (final Ball b) {
			this.target.aim(b);
		}
	}

	public static void main(final String[] args) {
		final P parent = new P(null);
		final P child = new P(parent);
		parent.target = child;
		parent.aim(new Ball());

	}
}


