package com.examples;

    import static com.examples.util.Print.print;

    public class _47_ReplaceParameterWithMethod {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        private int mQuantity;
        private int mItemPrice;

        public void show() {
            mQuantity = 100;
            mItemPrice = 10;
            print("Quantity: " + mQuantity + " Price: " + getPrice());

            mQuantity = 101;
            print("Quantity: " + mQuantity + " Price: " + getPrice());
        }

        public double getPrice() {
            int basePrice = mQuantity * mItemPrice;

            int discountLevel;
            if (mQuantity > 100) {
                discountLevel = 2;
            } else {
                discountLevel = 1;
            }
            double finalPrice = discountedPrice(basePrice, discountLevel);
            return finalPrice;
        }

        private double discountedPrice(int basePrice, int discountLevel) {
            if (discountLevel == 2) {
                return basePrice * 0.1;
            } else {
                return basePrice * 0.05;
            }
        }
    }

    static class After {

        private int mQuantity;
        private int mItemPrice;

        public void show() {
            mQuantity = 100;
            mItemPrice = 10;
            print("Quantity: " + mQuantity + " Price: " + getPrice());

            mQuantity = 101;
            print("Quantity: " + mQuantity + " Price: " + getPrice());
        }

        public double getPrice() {
            if (getDiscountLevel() == 2) {
                return getBasePrice() * 0.1;
            } else {
                return getBasePrice() * 0.05;
            }
        }

        private int getBasePrice() {
            return mQuantity * mItemPrice;
        }

        private int getDiscountLevel() {
            return mQuantity > 100 ? 2 : 1;
        }
    }
}
