package com.examples;

import static com.examples.util.Print.print;

public class _08_ReplaceMethodWithMethodObject {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
            Account account = new Account();
            print(account.gamma(1234, 7, 2015));
        }
    }

    static class After {
        public void show() {
            Account2 account = new Account2();
            print(account.gamma(1234, 7, 2015));
        }
    }

    static class Account {

        public int gamma(int inputVal, int quantity, int yearToDate) {

            int importantValue1 = (inputVal * quantity) + delta();
            int importantValue2 = (inputVal * yearToDate) + 100;

            if ((yearToDate - importantValue1) > 100)
                importantValue2 -= 20;

            int importantValue3 = importantValue2 * 7;

            return importantValue3 - 2 * importantValue1;
        }

        public int delta() {
            return 25;
        }
    }

    static class Account2 {

        public int gamma(int inputVal, int quantity, int yearToDate) {
            return new Gamma(this, inputVal, quantity, yearToDate).compute();
        }

        public int delta() {
            return 25;
        }
    }

    static class Gamma {

        private final Account2 mAccount;
        private int mInputVal;
        private int mQuantity;
        private int mYearToDate;
        private int mImportantValue1;
        private int mImportantValue2;
        private int mImportantValue3;

        public Gamma(Account2 account, int inputVal, int quantity, int yarToDate) {
            mAccount = account;
            mInputVal = inputVal;
            mQuantity = quantity;
            mYearToDate = yarToDate;
        }

        public int compute() {

            mImportantValue1 = (mInputVal * mQuantity) + mAccount.delta();
            mImportantValue2 = (mInputVal * mYearToDate) + 100;

            importantThing();

            mImportantValue3 = mImportantValue2 * 7;

            return mImportantValue3 - 2 * mImportantValue1;
        }

        private void importantThing() {
            if ((mYearToDate - mImportantValue1) > 100)
                mImportantValue2 -= 20;
        }
    }
}
