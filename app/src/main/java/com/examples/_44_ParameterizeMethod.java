package com.examples;

import static com.examples.util.Print.print;

public class _44_ParameterizeMethod {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        public void show() {
            Employee manager = new Employee(1500);
            Employee engineer = new Employee(1000);

            manager.tenPercentRaise();
            print("Manager salary after rise: " + manager.getSalary());

            engineer.fivePercentRaise();
            print("Engineer salary after rise: " + engineer.getSalary());

            print("Base charge: " + manager.baseCharge().getAmount());
        }

        class Employee {

            private double mSalary;

            public Employee(double salary) {
                mSalary = salary;
            }

            public void tenPercentRaise() {
                mSalary *= 1.1;
            }

            public void fivePercentRaise() {
                mSalary *= 1.05;
            }

            public double getSalary() {
                return mSalary;
            }

            public Dollars baseCharge() {

                double result = Math.min(lastUsage(), 100) * 0.03;

                if (lastUsage() > 100) {
                    result += (Math.min(lastUsage(), 200) - 100) * 0.05;
                }

                if (lastUsage() > 200) {
                    result += (lastUsage() - 200) * 0.07;
                }

                return new Dollars(result);
            }

            private int lastUsage() {
                return 250;
            }
        }

        class Dollars {

            private double mAmount;

            public Dollars(double amount) {
                mAmount = amount;
            }

            public double getAmount() {
                return mAmount;
            }

            public void setAmount(double amount) {
                mAmount = amount;
            }
        }
    }

    static class After {

        public void show() {
            Employee manager = new Employee(1500);
            Employee engineer = new Employee(1000);

            manager.raise(1.1);
            print("Manager salary after rise: " + manager.getSalary());

            engineer.raise(1.05);
            print("Engineer salary after rise: " + engineer.getSalary());

            print("Base charge: " + manager.baseCharge().getAmount());
        }

        class Employee {

            private double mSalary;

            public Employee(double salary) {
                mSalary = salary;
            }

            public void raise(double factor) {
                mSalary *= factor;
            }

            public double getSalary() {
                return mSalary;
            }

            public Dollars baseCharge() {
                double result = usageInRange(0, 100) * 0.03;
                result += usageInRange(100, 200)  * 0.05;
                result += usageInRange(200, Integer.MAX_VALUE)  * 0.07;
                return new Dollars(result);
            }

            private double usageInRange(int start, int end) {
                
                if (lastUsage() > start) {
                    return Math.min(lastUsage(), end) - start;
                } else {
                    return 0;
                }
            }

            private int lastUsage() {
                return 250;
            }
        }

        class Dollars {

            private double mAmount;

            public Dollars(double amount) {
                mAmount = amount;
            }

            public double getAmount() {
                return mAmount;
            }

            public void setAmount(double amount) {
                mAmount = amount;
            }
        }
    }
}
