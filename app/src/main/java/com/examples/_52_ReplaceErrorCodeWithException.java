package com.examples;

import junit.framework.Assert;

import static com.examples.util.Print.print;

public class _52_ReplaceErrorCodeWithException {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
            Account account = new Account(2000);
            int val = 2500;

            if (account.withdraw(val) == -1) {
                print("error!");
            } else {
                print("ok.");
            }
        }

        class Account {
            private int mBalance;

            public Account(int balance) {
                mBalance = balance;
            }

            private int withdraw(int amount) {
                if (amount > mBalance) {
                    return -1;
                } else {
                    mBalance -= amount;
                    return 0;
                }
            }
        }
    }

    static class After {
        public void show() {
            Account account = new Account(2000);
            int val = 2500;

//            try {
//                account.withdraw(val);
//                print("ok.");
//            } catch(Exception e) {
//                print("error!");
//            }

            account.withdraw2(val);
        }

        class Account {
            private int mBalance;

            public Account(int balance) {
                mBalance = balance;
            }

            public boolean canWithdraw(int amount) {
                return mBalance >= amount;
            }

            public void withdraw(int amount) {
                if (amount > mBalance) {
                    throw new IllegalArgumentException("Amount too large");
                }
                mBalance -= amount;
            }

            public void withdraw2(int amount) {
                Assert.assertTrue("Amount too large", amount <= mBalance);
                mBalance -= amount;
            }
        }
    }
}
