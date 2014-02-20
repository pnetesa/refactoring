package com.examples;

import static com.examples.util.Print.print;

public class _40_IntroduceNullObject {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {

            Site site;

            site = new Site();
            showSite(site);

            site = new Site(new Customer(
                    "Proctor & Gamble", BillingPlan.special(), new PaymentHistory()));
            showSite(site);
        }

        private void showSite(Site site) {

            Customer customer = site.getCustomer();

            BillingPlan plan;
            if (customer == null) {
                plan = BillingPlan.basic();
            } else {
                plan = customer.getPlan();
            }

            print("Billing plan: " + plan);

            String customerName;
            if (customer == null) {
                customerName = "occupant";
            } else {
                customerName = customer.getName();
            }

            print("Customer name: " + customerName);

            int weeksDelinquent;
            if (customer == null) {
                weeksDelinquent = 0;
            } else {
                weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();
            }

            print("Weeks delinquent: " + weeksDelinquent);
            print("----------------------");
        }

        class Site {
            private Customer mCustomer;

            public Site(Customer customer) {
                mCustomer = customer;
            }

            public Site() {
            }

            public Customer getCustomer() {
                return mCustomer;
            }
        }

        class Customer {
            private String mName;
            private BillingPlan mPlan;
            private PaymentHistory mHistory;

            public Customer(String name, BillingPlan plan, PaymentHistory history) {
                mName = name;
                mPlan = plan;
                mHistory = history;
            }

            public String getName() {
                return mName;
            }

            public BillingPlan getPlan() {
                return mPlan;
            }

            public PaymentHistory getHistory() {
                return mHistory;
            }
        }

        class PaymentHistory {
            public int getWeeksDelinquentInLastYear() {
                return 2;
            }
        }

        static class BillingPlan {

            private String mName;

            private BillingPlan(String name) {
                mName = name;
            }

            public static BillingPlan basic() {
                return new BillingPlan("Basic");
            }

            public static BillingPlan special() {
                return new BillingPlan("Special");
            }

            @Override
            public String toString() {
                return mName;
            }
        }
    }

    static class After {
        public void show() {

            Site site;

            site = new Site();
            showSite(site);

            site = new Site(new Customer(
                    "Proctor & Gamble", BillingPlan.special(), new PaymentHistory(2)));
            showSite(site);
        }

        private void showSite(Site site) {

            Customer customer = site.getCustomer();

            print("Billing plan: " + customer.getPlan());
            print("Customer name: " + customer.getName());
            print("Weeks delinquent: " + customer.getHistory().getWeeksDelinquentInLastYear());
            print("----------------------");
        }

        class Site {
            private Customer mCustomer;

            public Site(Customer customer) {
                mCustomer = customer;
            }

            public Site() {
            }

            public Customer getCustomer() {
                return mCustomer == null ? Customer.newNull() : mCustomer;
            }
        }

        interface Nullable {
            boolean isNull();
        }

        static class Customer implements Nullable {
            private String mName;
            private BillingPlan mPlan;
            private PaymentHistory mHistory;

            public Customer(String name, BillingPlan plan, PaymentHistory history) {
                mName = name;
                mPlan = plan;
                mHistory = history;
            }

            public String getName() {
                return mName;
            }

            public BillingPlan getPlan() {
                return mPlan;
            }

            public PaymentHistory getHistory() {
                return mHistory;
            }

            @Override
            public boolean isNull() {
                return false;
            }

            public static Customer newNull() {
                return new NullCustomer();
            }
        }

        static class NullCustomer extends Customer {

            @Override
            public boolean isNull() {
                return true;
            }

            public NullCustomer() {
                super("occupant", BillingPlan.basic(), PaymentHistory.newNull());
            }
        }

        static class PaymentHistory implements Nullable {

            private int mWeeksDelinquent;

            public PaymentHistory(int weeksDelinquent) {
                mWeeksDelinquent = weeksDelinquent;
            }

            public int getWeeksDelinquentInLastYear() {
                return mWeeksDelinquent;
            }

            @Override
            public boolean isNull() {
                return false;
            }

            public static PaymentHistory newNull() {
                return new NullPaymentHistory();
            }
        }

        static class NullPaymentHistory extends PaymentHistory {

            public NullPaymentHistory() {
                super(0);
            }

            @Override
            public boolean isNull() {
                return true;
            }
        }

        static class BillingPlan {

            private String mName;

            public BillingPlan(String name) {
                mName = name;
            }

            public static BillingPlan basic() {
                return new BillingPlan("Basic");
            }

            public static BillingPlan special() {
                return new BillingPlan("Special");
            }

            @Override
            public String toString() {
                return mName;
            }
        }
    }
}
