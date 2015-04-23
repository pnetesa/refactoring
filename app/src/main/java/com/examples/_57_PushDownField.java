package com.examples;

import static com.examples.util.Print.print;

public class _57_PushDownField {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
            Employee sm = new Salesman(1234.56);
            print("In superclass | Quota: " + sm.getQuota());
        }

        static class Employee {
            protected double mQuota;
            public double getQuota() {
                return mQuota;
            }
        }

        static class Salesman extends Employee {
            public Salesman(double quota) {
                mQuota = quota;
            }
        }

        static class Engineer extends Employee {
        }
    }

    static class After {
        public void show() {
            Salesman sm = new Salesman(1234.56);
            print("In subclass | Quota: " + sm.getQuota());
        }

        static class Employee {
        }

        static class Salesman extends Employee {
            protected double mQuota;

            public Salesman(double quota) {
                mQuota = quota;
            }

            public double getQuota() {
                return mQuota;
            }
        }

        static class Engineer extends Employee {
            protected double mQuota;
        }
    }
}
