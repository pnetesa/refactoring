package com.examples;

import static com.examples.util.Print.print;

public class _36_ConsolidateDuplicateConditionalFragments {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {

            double total = 0;
            double price = 5.99;

            if (isSpecialDeal()) {
                total = price * 0.95;
                send();
            } else {
                total = price * 0.98;
                send();
            }

            print("Total: " + Double.valueOf(total));
        }

        private void send() {
            print("Sending... sent.");
        }

        public boolean isSpecialDeal() {
            return true;
        }
    }

    static class After {
        public void show() {

            double total = 0;
            double price = 5.99;

            if (isSpecialDeal()) {
                total = price * 0.95;
            } else {
                total = price * 0.98;
            }

            send();

            print("Total: " + Double.valueOf(total));
        }

        private void send() {
            print("Sending... sent.");
        }

        public boolean isSpecialDeal() {
            return true;
        }
    }
}
