
package com.audition;

/**
 * @author Basheer
 *
 */
public class VendingMachine {

	public VendingMachine() {
		// TODO Auto-generated constructor stub

	}

	public double totalCurrency;
	public boolean buttonClicked;

	public enum Currency {
		PENNY(0.01, "1w", "1h"), NICKLE(0.05, "2w", "2h"), DIME(0.10, "3w", "3h"), QUARTER(0.25, "4w", "4h");
		private double value;
		private String weight;
		private String height;

		private Currency(double value, String weight, String height) {
			this.value = value;
			this.weight = weight;
			this.height = height;
		}

	};

	public enum Items {
		COLA(1.00), CHIPS(0.50), CANDY(0.65);
		private double value;

		private Items(double value) {
			this.value = value;
		}

	};

	/**
	 * Checking Dispaly
	 */
	public void checkDisplay() {

		if ((Items.CHIPS.value == totalCurrency || Items.COLA.value == totalCurrency
				|| Items.CANDY.value == totalCurrency) && buttonClicked) {
			totalCurrency = 0.0;
			System.out.println("INSERT COIN");

		} else if (totalCurrency == 0.0) {
			System.out.println("INSERT COIN");
		}
		System.out.println("Current Amoutn :" + this.totalCurrency);
	}

	/**
	 * Adds Currency
	 * 
	 * @param currency
	 */
	public void addCurrency(String weight, String height) {

		double currencyValue = getCurrency(weight, height);
		if (Currency.PENNY.value == currencyValue) {
			invalidCoin();
		} else
			totalCurrency = currencyValue + totalCurrency;
	}

	/**
	 * Method to return coin if invalid
	 */
	private void invalidCoin() {
		// TODO Auto-generated method stub
		System.out.println("Invalid Coin, has been returned");
	}

	/**
	 * Method to return coins
	 * 
	 * @param amount
	 */
	private void returnCoin(double amount) {
		System.out.println("Total cash of " + amount + " has been returned");

	}

	/**
	 * Method to cancel transaction
	 * 
	 */
	public void cancelTransaction() {
		returnCoin(totalCurrency);
		totalCurrency = 0.0;
	}

	/**
	 * Helper method to get currency
	 * 
	 * @param weight
	 * @param height
	 * @return
	 */
	public double getCurrency(String weight, String height) {

		if (Currency.PENNY.height.equals(height) && Currency.PENNY.weight.equals(weight)) {
			System.out.println("Penny Inserted");
			return Currency.PENNY.value;
		} else if (Currency.NICKLE.height.equals(height) && Currency.NICKLE.weight.equals(weight)) {
			System.out.println("Nickle Inserted");
			return Currency.NICKLE.value;
		} else if (Currency.DIME.height.equals(height) && Currency.DIME.weight.equals(weight)) {
			System.out.println("Dime Inserted");
			return Currency.DIME.value;
		} else {
			System.out.println("Quarter Inserted");
			return Currency.QUARTER.value;
		}

	}

	/**
	 * Button Pressed
	 * 
	 * @param buttonPressed
	 */
	public void buttonPressed(String buttonValue) {

		Items item = Items.valueOf(buttonValue);
		switch (item) {
		case COLA:
			System.out.println("Button Preesed COLA");
			if (Items.COLA.value <= totalCurrency) {
				System.out.println("Thanks You");
				buttonClicked = true;
				if (Items.COLA.value < totalCurrency)
					returnCoin(totalCurrency - Items.COLA.value);
			}
			break;
		case CHIPS:
			System.out.println("Button Pressed CHIPS");
			if (Items.CHIPS.value <= totalCurrency) {
				System.out.println("Thanks You");
				buttonClicked = true;
				if (Items.CHIPS.value < totalCurrency)
					returnCoin(totalCurrency - Items.CHIPS.value);

			}
			break;
		case CANDY:
			System.out.println("Button Pressed Candy");
			if (Items.CANDY.value <= totalCurrency) {
				System.out.println("Thanks You");
				buttonClicked = true;
				if (Items.CANDY.value < totalCurrency)
					returnCoin(totalCurrency - Items.CANDY.value);
			}
			break;

		}

	}

}
