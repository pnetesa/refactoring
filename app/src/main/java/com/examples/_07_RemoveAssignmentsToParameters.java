package com.examples;

import static com.examples.util.Print.print;

public class _07_RemoveAssignmentsToParameters {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        public void show() {
            print(discount(10001, 4, 2014));
        }

        private int discount(int inputVal, int quantity, int yearToDate) {

            if (inputVal > 50)
                inputVal -= 2;

            if (quantity > 100)
                inputVal -= 1;

            if (yearToDate > 10000)
                inputVal -= 4;

            return inputVal;
        }
    }

    static class After {

        public void show() {
            print(discount(10001, 4, 2014));
        }

        private int discount(int inputVal, int quantity, int yearToDate) {

            int result = inputVal;

            if (inputVal > 50)
                result -= 2;

            if (quantity > 100)
                result -= 1;

            if (yearToDate > 10000)
                result -= 4;

            return result;
        }
    }
}
