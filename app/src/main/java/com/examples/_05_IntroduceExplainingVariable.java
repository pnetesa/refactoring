package com.examples;

import static com.examples.util.Print.print;

public class _05_IntroduceExplainingVariable {

	public static void main(String[] args) {

        Before1 before1 = new Before1();
        before1.show();

        print();

        After1 after1 = new After1();
        after1.show();

        print();

        Before2 before2 = new Before2();
        print("Price: " + before2.price());

        print();

        After2 after2 = new After2();
        print("Price: " + after2.price());

        print();

        After2_1 after2_1 = new After2_1();
        print("Price: " + after2_1.price());
	}

    static class Before1 {

        public void show() {
            String platform = "Mac OS X Mavericks 10.9";
            String browser = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.3; Trident/7.0)";
            int resize = 1234;

            if (platform.toUpperCase().indexOf("MAC") > -1 &&
                    browser.toUpperCase().indexOf("IE") > -1 &&
                    wasInitialized() && resize > 0) {
                print("Yes!");
            }
        }

        private boolean wasInitialized() {
            return true;
        }
    }

    static class After1 {

        public void show() {
            String platform = "Mac OS X Mavericks 10.9";
            String browser = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.3; Trident/7.0)";
            int resize = 1234;

            final boolean isMacOs = platform.toUpperCase().indexOf("MAC") > -1;
            final boolean isIeBrowser = browser.toUpperCase().indexOf("IE") > -1;
            final boolean wasResized = resize > 0;
            if (isMacOs && isIeBrowser && wasInitialized() && wasResized) {
                print("Yes!");
            }
        }

        private boolean wasInitialized() {
            return true;
        }
    }

    static class Before2 {

        private int mQuantity = 700;
        private double mItemPrice = 59.99;

        public double price() {
            return mQuantity * mItemPrice -
                    Math.max(0, mQuantity - 500) * mItemPrice * 0.05 +
                    Math.min(mQuantity * mItemPrice * 0.1, 100.0);
        }
    }

    static class After2 {

        private int mQuantity = 700;
        private double mItemPrice = 59.99;

        public double price() {

            final double basePrice = mQuantity * mItemPrice;
            double quantityDiscount = Math.max(0, mQuantity - 500) * mItemPrice * 0.05;
            double shipping = Math.min(basePrice * 0.1, 100.0);

            return basePrice - quantityDiscount + shipping;
        }
    }

    static class After2_1 {

        private int mQuantity = 700;
        private double mItemPrice = 59.99;

        public double price() {
            return basePrice() - quantityDiscount() + shipping();
        }

        private double shipping() {
            return Math.min(basePrice() * 0.1, 100.0);
        }

        private double quantityDiscount() {
            return Math.max(0, mQuantity - 500) * mItemPrice * 0.05;
        }

        private double basePrice() {
            return mQuantity * mItemPrice;
        }
    }
}
