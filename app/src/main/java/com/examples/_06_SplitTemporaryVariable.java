package com.examples;

import static com.examples.util.Print.print;

public class _06_SplitTemporaryVariable {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();

        print();

        Before1 before1 = new Before1();
        print(before1.getDistanceTravelled(15));

        print();

        After1 after1 = new After1();
        print(after1.getDistanceTravelled(15));
	}

    static class Before {

        private double mHeight = 123.45;
        private double mWidth = 678.91;

        public void show() {

            double temp = 2 * (mHeight + mWidth);
            print(temp);

            temp = mHeight * mWidth;
            print(temp);
        }
    }

    static class After {

        private double mHeight = 123.45;
        private double mWidth = 678.91;

        public void show() {

            final double perimeter = 2 * (mHeight + mWidth);
            print(perimeter);

            final double area = mHeight * mWidth;
            print(area);
        }
    }

    static class Before1 {

        private double mPrimaryForce = 70;
        private double mSecondaryForce = 50;
        private double mMass = 65;
        private int mDelay = 5;

        public double getDistanceTravelled(int time) {

            double acc = mPrimaryForce / mMass;
            int primaryTime = Math.min(time, mDelay);
            double result = 0.5 * acc * primaryTime * primaryTime;

            int secondaryTime = time - mDelay;
            if (secondaryTime > 0) {
                double primaryVel = acc * mDelay;
                acc = (mPrimaryForce + mSecondaryForce) / mMass;
                result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
            }

            return result;
        }
    }

    static class After1 {

        private double mPrimaryForce = 70;
        private double mSecondaryForce = 50;
        private double mMass = 65;
        private int mDelay = 5;

        public double getDistanceTravelled(int time) {

            final double primaryAcc = mPrimaryForce / mMass;
            int primaryTime = Math.min(time, mDelay);
            double result = 0.5 * primaryAcc * primaryTime * primaryTime;

            int secondaryTime = time - mDelay;
            if (secondaryTime > 0) {
                double primaryVel = primaryAcc * mDelay;
                final double secondaryAcc = (mPrimaryForce + mSecondaryForce) / mMass;
                result += primaryVel * secondaryTime + 0.5 * secondaryAcc * secondaryTime * secondaryTime;
            }

            return result;
        }
    }
}
