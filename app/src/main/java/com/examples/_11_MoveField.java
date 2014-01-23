package com.examples;

import static com.examples.util.Print.print;

public class _11_MoveField {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();

        print();

        SelfEncapsulationBefore before1 = new SelfEncapsulationBefore();
        before1.show();

        print();

        SelfEncapsulationAfter after1 = new SelfEncapsulationAfter();
        after1.show();
	}

    static class Before {

        public void show() {
            Account acc1 = new Account(new AccountType(), 49.99);
            print(acc1.interestForAmountDays(99.9, 32));
        }

        private static class AccountType {

            public AccountType() {
            }
        }

        private static class Account {

            public Account(AccountType accountType, double interestRate) {
                mType = accountType;
                mInterestRate = interestRate;
            }

            private AccountType mType;
            private double mInterestRate;

            public double interestForAmountDays(double amount, int days) {
                return mInterestRate * amount * days / 365;
            }
        }
    }

    static class After {

        public void show() {
            Account acc1 = new Account(new AccountType(49.99));
            print(acc1.interestForAmountDays(99.9, 32));
        }

        private static class AccountType {

            public AccountType(double interestRate) {
                mInterestRate = interestRate;
            }

            private double mInterestRate;

            public double getInterestRate() {
                return mInterestRate;
            }

            public void setInterestRate(double interestRate) {
                mInterestRate = interestRate;
            }
        }

        private static class Account {

            public Account(AccountType accountType) {
                mType = accountType;
            }

            private AccountType mType;

            public double interestForAmountDays(double amount, int days) {
                return mType.getInterestRate() * amount * days / 365;
            }
        }
    }

    static class SelfEncapsulationBefore {

        public void show() {
            Account acc1 = new Account(new AccountType(), 49.99);
            print(acc1.interestForAmountDays(99.9, 32));
        }

        private static class AccountType {

            public AccountType() {
            }
        }

        private static class Account {

            public Account(AccountType accountType, double interestRate) {
                mType = accountType;
                mInterestRate = interestRate;
            }

            private AccountType mType;
            private double mInterestRate;

            public double interestForAmountDays(double amount, int days) {
                return mInterestRate * amount * days / 365;
            }
        }
    }

    static class SelfEncapsulationAfter {

        public void show() {
            Account acc1 = new Account(new AccountType(49.99));
            print(acc1.interestForAmountDays(99.9, 32));
        }

        private static class AccountType {

            public AccountType(double interestRate) {
                mInterestRate = interestRate;
            }

            private double mInterestRate;

            public double getInterestRate() {
                return mInterestRate;
            }

            public void setInterestRate(double value) {
                mInterestRate = value;
            }
        }

        private static class Account {

            public Account(AccountType accountType) {
                mType = accountType;
            }

            private AccountType mType;

            public void setInterestRate(double value) {
                mType.setInterestRate(value);
            }

            public double getInterestRate() {
                return mType.getInterestRate();
            }

            public double interestForAmountDays(double amount, int days) {
                return getInterestRate() * amount * days / 365;
            }
        }
    }
}
