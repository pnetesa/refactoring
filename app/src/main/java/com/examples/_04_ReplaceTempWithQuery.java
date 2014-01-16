package com.examples;

import static com.examples.util.Print.print;

public class _04_ReplaceTempWithQuery {

	public static void main(String[] args) {

        Before before = new Before();
        print(before.show());
        print(before.getPrice());

        print();

        After after = new After();
        print(after.show());
        print(after.getPrice());
	}

    static class Before {

        private int mQuantity = 2;
        private int mItemPrice = 1500;

        public double show() {

            double basePrice = mQuantity * mItemPrice;

            if (basePrice > 1000)
                return basePrice * 0.95;
            else
                return basePrice * 0.98;
        }

        public double getPrice() {

            int basePrice = mQuantity * mItemPrice;
            double discountFactor;

            if (basePrice > 1000)
                discountFactor = 0.95;
            else
                discountFactor = 0.98;

            return basePrice * discountFactor;
        }
    }

    static class After {

        private int mQuantity = 2;
        private int mItemPrice = 1500;

        public double show() {

            if (basePrice() > 1000)
                return basePrice() * 0.95;
            else
                return basePrice() * 0.98;
        }

        private int basePrice() {
            return mQuantity * mItemPrice;
        }

        public double getPrice() {
            return basePrice() * discountFactor();
        }

        private double discountFactor() {
            return basePrice() > 1000 ? 0.95 : 0.98;
        }
    }
}
