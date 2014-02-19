package com.examples;

import static com.examples.util.Print.print;

public class _38_ReplaceNestedConditionalWithGuardClauses {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        private static final double ADJ_FACTOR = 2.4;
        private boolean mIsDead;
        private boolean mIsSeparated;
        private boolean mIsRetired;
        private double mCapital = 0.12;
        private double mIntRate = 3.14159;
        private double mDuration = 7.8;
        private double mIncome = 2250.59;

        public void show() {
            mIsDead = true;
            print("Dead: " + getPayAmount());

            mIsDead = false;
            mIsSeparated = true;
            print("Separated: " + getPayAmount());

            mIsSeparated = false;
            mIsRetired = true;
            print("Retired: " + getPayAmount());

            mIsRetired = false;
            print("Normal: " + getPayAmount());

            print("Example 2: " + getAdjustedCapital());
        }
        
        public double getPayAmount() {
            double result = 0;
            
            if (mIsDead) {
                result = deadAmount();
            } else {
                if (mIsSeparated) {
                    result = separatedAmount();
                } else {
                    if (mIsRetired) {
                        result = retiredAmount();
                    } else {
                        result = normalPayAmount();
                    }
                }
            }
            
            return result;
        }

        private double deadAmount() {
            return 0;
        }

        private double separatedAmount() {
            return 25;
        }

        private double retiredAmount() {
            return 49.99;
        }

        private double normalPayAmount() {
            return 100.99;
        }

        /* Example 2 */
        public double getAdjustedCapital() {
            double result = 0.0;
            if (mCapital > 0.0) {
                if (mIntRate > 0.0 && mDuration > 0.0) {
                    result = mIncome / mDuration * ADJ_FACTOR;
                }
            }
            return result;
        }
    }

    static class After {

        private static final double ADJ_FACTOR = 2.4;
        private boolean mIsDead;
        private boolean mIsSeparated;
        private boolean mIsRetired;
        private double mCapital = 0.12;
        private double mIntRate = 3.14159;
        private double mDuration = 7.8;
        private double mIncome = 2250.59;

        public void show() {
            mIsDead = true;
            print("Dead: " + getPayAmount());

            mIsDead = false;
            mIsSeparated = true;
            print("Separated: " + getPayAmount());

            mIsSeparated = false;
            mIsRetired = true;
            print("Retired: " + getPayAmount());

            mIsRetired = false;
            print("Normal: " + getPayAmount());

            print("Example 2: " + getAdjustedCapital());
        }

        public double getPayAmount() {

            if (mIsDead)
                return deadAmount();

            if (mIsSeparated)
                return separatedAmount();

            if (mIsRetired)
                return retiredAmount();

            return normalPayAmount();
        }

        private double deadAmount() {
            return 0;
        }

        private double separatedAmount() {
            return 25;
        }

        private double retiredAmount() {
            return 49.99;
        }

        private double normalPayAmount() {
            return 100.99;
        }

        /* Example 2 */
        public double getAdjustedCapital() {

            if (mCapital <= 0.0)
                return 0.0;

            if (mIntRate <= 0.0 && mDuration <= 0.0)
                return 0.0;

            return mIncome / mDuration * ADJ_FACTOR;
        }
    }
}
