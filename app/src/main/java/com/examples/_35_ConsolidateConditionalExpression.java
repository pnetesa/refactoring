package com.examples;

import static com.examples.util.Print.print;

public class _35_ConsolidateConditionalExpression {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        private int mSeniority;
        private int mMonthsDisabled;
        private boolean mIsPartTime;

        public void show() {
            mSeniority = 3;
            mMonthsDisabled = 7;
            mIsPartTime = false;

            print("ORs: " + testOrs());
            print("ANDs: " + testAnds());
        }

        private int testOrs() {

            if ((mSeniority < 2) || (mMonthsDisabled > 12) || (mIsPartTime)) return 0;

            return 1;
        }

        private double testAnds() {
            if (onVacation()) {
                if (lengthOfService() > 10) {
                    return 1;
                }
            }

            return 0.5;
        }

        private int lengthOfService() {
            return 12;
        }

        private boolean onVacation() {
            return true;
        }
    }

    static class After {

        private int mSeniority;
        private int mMonthsDisabled;
        private boolean mIsPartTime;

        public void show() {
            mSeniority = 3;
            mMonthsDisabled = 7;
            mIsPartTime = false;

            print("ORs: " + testOrs());
            print("ANDs: " + testAnds());
        }

        private int testOrs() {

            if (isNotEligableForDisability()) return 0;

            return 1;
        }

        private boolean isNotEligableForDisability() {
            return (mSeniority < 2) || (mMonthsDisabled > 12) || mIsPartTime;
        }

        private double testAnds() {
            return onVacation() && (lengthOfService() > 10) ? 1 : 0.5;
        }

        private int lengthOfService() {
            return 12;
        }

        private boolean onVacation() {
            return true;
        }
    }
}
