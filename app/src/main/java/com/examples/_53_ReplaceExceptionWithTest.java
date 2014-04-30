package com.examples;

import static com.examples.util.Print.print;

public class _53_ReplaceExceptionWithTest {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        private double[] mValues = { 10, 20, 30, 40 };

        public void show() {
            print("Index 1: " + getValueForPeriod(1));
            print("Index 5: " + getValueForPeriod(5));
        }

        private double getValueForPeriod(int index) {
            try {
                return mValues[index];
            } catch(ArrayIndexOutOfBoundsException e) {
                return 0;
            }
        }
    }

    static class After {

        private double[] mValues = { 10, 20, 30, 40 };

        public void show() {
            print("Index 1: " + getValueForPeriod(1));
            print("Index 5: " + getValueForPeriod(5));
        }

        private double getValueForPeriod(int index) {

            if (index >= mValues.length) {
                return 0;
            }

            return mValues[index];
        }
    }
}
