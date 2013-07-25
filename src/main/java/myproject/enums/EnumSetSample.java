package myproject.enums;

import java.util.EnumSet;

public final class EnumSetSample {

	private enum Weekday {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

		public static final EnumSet<Weekday> WORKDAYS = EnumSet.range(MONDAY, FRIDAY);

		public final boolean isWorkday() {
			return WORKDAYS.contains(this);
		}

		public static final EnumSet<Weekday> THE_WHOLE_WEEK = EnumSet.allOf(Weekday.class);
	}

	public static final void main(final String... argumgents) {
		System.out.println("Work Schedule:");

		for (final Weekday weekday : Weekday.THE_WHOLE_WEEK)
			System.out.println(String.format("%d. On %s you " + (weekday.isWorkday() ? "have to work" : "can relax")
					+ ".", weekday.ordinal() + 1, weekday));

		System.out.println("Do I have to work the whole week?");

		System.out.println(Weekday.WORKDAYS.containsAll(Weekday.THE_WHOLE_WEEK) ? "Yes, unfortunately."
				: "Certainly not.");

		final EnumSet<Weekday> weekend = Weekday.THE_WHOLE_WEEK.clone();
		weekend.removeAll(Weekday.WORKDAYS);

		System.out.println(String.format("The weekend is %d days long.", weekend.size()));

	}
}
