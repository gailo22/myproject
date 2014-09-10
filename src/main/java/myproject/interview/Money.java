package myproject.interview;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Money implements Comparable<Money> {

	private static final NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
	private final BigDecimal amount;
	private final Currency currency;
	
	public Money(BigDecimal amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public Money add(Money that) {
		checkCurrencyMatch(that);
		return new Money(amount.add(that.amount), currency);
		
	}
	
	public Money minus(Money that) {
		checkCurrencyMatch(that);
		return new Money(amount.subtract(that.amount), currency);
		
	}

	private void checkCurrencyMatch(Money that) {
		// TODO Auto-generated method stub
		
	}
	
	public BigDecimal getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	@Override
	public int compareTo(Money o) {
		return o.getAmount().compareTo(amount);
	}
	
	@Override
	public String toString() {
		return format.format(amount);
	}
}
