package com.examples;

import static com.examples.util.Print.print;

public class _03_InlineTemp {

	public static void main(String[] args) {

        Before before = new Before();
        print(before.show());

        After after = new After();
        print(after.show());
	}

    static class Before {
        public boolean show() {

            Order order = new Order();
            order.setBasePrice(59.9);

            double basePrice = order.getBasePrice();
            return basePrice > 1000;
        }
    }

    static class After {
        public boolean show() {

            Order order = new Order();
            order.setBasePrice(59.9);

            return order.getBasePrice() > 1000;
        }
    }
}
