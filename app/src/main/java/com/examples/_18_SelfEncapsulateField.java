package com.examples;

import static com.examples.util.Print.print;

public class _18_SelfEncapsulateField {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {

            IntRange intRange = new IntRange(5, 10);
            print("Includes 11? : " + intRange.includes(11));
            print("Includes 6? : " + intRange.includes(6));

            intRange.grow(2);

            print("Includes 11? : " + intRange.includes(11));
            print("Includes 6? : " + intRange.includes(6));
        }

        class IntRange {

            private int mLow;
            private int mHigh;

            public IntRange(int low, int high) {
                mLow = low;
                mHigh = high;
            }

            public boolean includes(int value) {
                return value >= mLow && value <= mHigh;
            }

            public void grow(int factor) {
                mHigh *= factor;
            }
        }
    }

    static class After {
        public void show() {

            IntRange intRange = new IntRange(5, 10);
            print("Includes 11? : " + intRange.includes(11));
            print("Includes 6? : " + intRange.includes(6));

            intRange.grow(2);

            print("Includes 11? : " + intRange.includes(11));
            print("Includes 6? : " + intRange.includes(6));
        }

        class IntRange {

            private int mLow;
            private int mHigh;

            public IntRange(int low, int high) {
                initialize(low, high);
            }

            private void initialize(int low, int high) {
                mLow = low;
                mHigh = high;
            }

            public boolean includes(int value) {
                return value >= getLow() && value <= getHigh();
            }

            public void grow(int factor) {
                setHigh(getHigh() * factor);
            }

            public int getLow() {
                return mLow;
            }

            public void setLow(int value) {
                mLow = value;
            }

            public int getHigh() {
                return mHigh;
            }

            public void setHigh(int value) {
                mHigh = value;
            }
        }
    }
}
