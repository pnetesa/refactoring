package com.examples;

import static com.examples.util.Print.print;

public class _10_MoveMethod {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        public void show() {
            Account acc1 = new Account(new AccountType(true), 9);
            Account acc2 = new Account(new AccountType(false), 11);

            print(acc1.bankCharge());
            print(acc2.bankCharge());
        }

        private static class AccountType {

            private boolean mIsPremium;

            public AccountType(boolean isPremium) {
                mIsPremium = isPremium;
            }

            public boolean isPremium() {
                return mIsPremium;
            }
        }

        private static class Account {

            public Account(AccountType accountType, int daysOverdrawn) {
                mType = accountType;
                mDaysOverdrawn = daysOverdrawn;
            }

            private AccountType mType;
            private int mDaysOverdrawn;

            private double overdraftCharge() {

                if (!mType.isPremium()) {
                    return mDaysOverdrawn * 1.75;
                }

                double result = 10;

                if (mDaysOverdrawn > 7) {
                    result += (mDaysOverdrawn - 7) * 0.85;
                }

                return result;
            }

            public double bankCharge() {
                double result = 4.5;

                if (mDaysOverdrawn > 0) {
                    result += overdraftCharge();
                }

                return result;
            }
        }
    }

    static class After {

        public void show() {
            Account acc1 = new Account(new AccountType(true), 9);
            Account acc2 = new Account(new AccountType(false), 11);

            print(acc1.bankCharge());
            print(acc2.bankCharge());
        }

        private static class AccountType {

            private boolean mIsPremium;

            public AccountType(boolean isPremium) {
                mIsPremium = isPremium;
            }

            public boolean isPremium() {
                return mIsPremium;
            }

            private double overdraftCharge(int daysOverdrawn) {

                if (!isPremium()) {
                    return daysOverdrawn * 1.75;
                }

                double result = 10;

                if (daysOverdrawn > 7) {
                    result += (daysOverdrawn - 7) * 0.85;
                }

                return result;
            }
        }

        private static class Account {

            public Account(AccountType accountType, int daysOverdrawn) {
                mType = accountType;
                mDaysOverdrawn = daysOverdrawn;
            }

            private AccountType mType;
            private int mDaysOverdrawn;

            public double bankCharge() {
                double result = 4.5;

                if (mDaysOverdrawn > 0) {
                    result += mType.overdraftCharge(mDaysOverdrawn);
                }

                return result;
            }
        }
    }

}
