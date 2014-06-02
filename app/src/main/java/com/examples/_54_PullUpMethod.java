package com.examples;

import java.util.Date;

import static com.examples.util.Print.print;

public class _54_PullUpMethod {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
        }

        static class Customer {

            protected Date mLastBillDate;

            public void addBill(Date date, double amount) {
            }

            protected double charge(Date lastBillDate, Date date) {
                return 0;
            }
        }

        static class RegularCustomer extends Customer {

            public RegularCustomer(Date lastBillDate) {
                mLastBillDate = lastBillDate;
            }

            public void createBill(Date date) {
                double chargeAmount = charge(mLastBillDate, date);
                addBill(date, chargeAmount);
            }

            public void chargeFor(Date start, Date end) {

            }
        }

        static class PreferredCustomer extends Customer {

            public PreferredCustomer(Date lastBillDate) {
                mLastBillDate = lastBillDate;
            }

            public void createBill(Date date) {
                double chargeAmount = charge(mLastBillDate, date);
                addBill(date, chargeAmount);
            }

            public void chargeFor(Date start, Date end) {

            }
        }

    }

    static class After {
        public void show() {
        }

        static abstract class Customer {

            protected Date mLastBillDate;

            public void addBill(Date date, double amount) {
            }

            protected double charge(Date lastBillDate, Date date) {
                return 0;
            }

            public abstract void chargeFor(Date start, Date end);
        }

        static class RegularCustomer extends Customer {

            public RegularCustomer(Date lastBillDate) {
                mLastBillDate = lastBillDate;
            }

            public void createBill(Date date) {
                double chargeAmount = charge(mLastBillDate, date);
                addBill(date, chargeAmount);
            }

            @Override
            public void chargeFor(Date start, Date end) {

            }
        }

        static class PreferredCustomer extends Customer {

            public PreferredCustomer(Date lastBillDate) {
                mLastBillDate = lastBillDate;
            }

            public void createBill(Date date) {
                double chargeAmount = charge(mLastBillDate, date);
                addBill(date, chargeAmount);
            }

            @Override
            public void chargeFor(Date start, Date end) {

            }
        }
    }
}
