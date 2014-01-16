package com.examples;

import static com.examples.util.Print.print;

public class _02_InlineMethod {

	public static void main(String[] args) {

        Before before = new Before();
        print(before.getRating());

        After after = new After();
        print(after.getRating());
	}

    static class Before {

        private int mNumberOfLateDeliveries = 6;

        public int getRating() {
            return moreThanFiveLateDevliveries() ? 2 : 1;
        }

        private boolean moreThanFiveLateDevliveries() {
            return mNumberOfLateDeliveries > 5;
        }
    }

    static class After {

        private int mNumberOfLateDeliveries = 6;

        public int getRating() {
            return mNumberOfLateDeliveries > 5 ? 2 : 1;
        }
    }
}
