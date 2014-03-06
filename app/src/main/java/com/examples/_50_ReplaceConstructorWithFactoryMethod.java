package com.examples;

import static com.examples.util.Print.print;

public class _50_ReplaceConstructorWithFactoryMethod {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();

        print();

        After2 after2 = new After2();
        after2.show();
	}

    static class Before {

        public void show() {

            Employee engineer = new Employee(Employee.ENGINEER);
            engineer.setMonthlySalary(1500);

            Employee salesman = new Employee(Employee.SALESMAN);
            salesman.setMonthlySalary(1200);
            salesman.setCommission(300);

            Employee manager = new Employee(Employee.MANAGER);
            manager.setMonthlySalary(2200);
            manager.setBonus(750);

            print("Engineer: " + engineer.payAmount());
            print("Salesman: " + salesman.payAmount());
            print("Manager: " + manager.payAmount());
        }

        static class Employee {

            private int mType;
            private int mMonthlySalary;
            private int mCommission;
            private int mBonus;

            public static final int ENGINEER = 0;
            public static final int SALESMAN = 1;
            public static final int MANAGER = 2;

            public Employee(int type) {
                mType = type;
            }

            public int payAmount() {
                switch (mType) {
                    case ENGINEER:
                        return mMonthlySalary;
                    case SALESMAN:
                        return mMonthlySalary + mCommission;
                    case MANAGER:
                        return mMonthlySalary + mBonus;
                    default:
                        throw new RuntimeException("Incorrect Employee");
                }
            }

            public void setMonthlySalary(int value) {
                mMonthlySalary = value;
            }

            public void setCommission(int value) {
                mCommission = value;
            }

            public void setBonus(int value) {
                mBonus = value;
            }
        }
    }

    static class After {

        public void show() {

            Employee engineer = Employee.create(Employee.ENGINEER);
            engineer.setMonthlySalary(1500);

            Employee salesman = Employee.create(Employee.SALESMAN);
            salesman.setMonthlySalary(1200);
            salesman.setCommission(300);

            Employee manager = Employee.create(Employee.MANAGER);
            manager.setMonthlySalary(2200);
            manager.setBonus(750);

            print("Engineer: " + engineer.payAmount());
            print("Salesman: " + salesman.payAmount());
            print("Manager: " + manager.payAmount());
        }

        static abstract class Employee {

            public static final int ENGINEER = 0;
            public static final int SALESMAN = 1;
            public static final int MANAGER = 2;

            protected int mMonthlySalary;
            protected int mCommission;
            protected int mBonus;

            public static Employee create(int type) {
                switch (type) {
                    case Employee.ENGINEER:
                        return new Engineer();
                    case Employee.SALESMAN:
                        return new Salesman();
                    case Employee.MANAGER:
                        return new Manager();
                    default:
                        throw new RuntimeException("Incorrect Employee code");
                }
            }

            public abstract int payAmount();

            public void setMonthlySalary(int value) {
                mMonthlySalary = value;
            }

            public void setCommission(int value) {
                mCommission = value;
            }

            public void setBonus(int value) {
                mBonus = value;
            }
        }

        static class Engineer extends Employee {
            @Override
            public int payAmount() {
                return mMonthlySalary;
            }
        }

        static class Salesman extends Employee {
            @Override
            public int payAmount() {
                return mMonthlySalary + mCommission;
            }
        }

        static class Manager extends Employee {
            @Override
            public int payAmount() {
                return mMonthlySalary + mBonus;
            }
        }
    }

    static class After2 {

        public void show() {

            Employee engineer = Employee.create("com.examples._50_ReplaceConstructorWithFactoryMethod$After2$Engineer");
            engineer.setMonthlySalary(1500);

            Employee salesman = Employee.create("com.examples._50_ReplaceConstructorWithFactoryMethod$After2$Salesman");
            salesman.setMonthlySalary(1200);
            salesman.setCommission(300);

            Employee manager = Employee.create("com.examples._50_ReplaceConstructorWithFactoryMethod$After2$Manager");
            manager.setMonthlySalary(2200);
            manager.setBonus(750);

            print("Engineer: " + engineer.payAmount());
            print("Salesman: " + salesman.payAmount());
            print("Manager: " + manager.payAmount());
        }

        static abstract class Employee {

            protected int mMonthlySalary;
            protected int mCommission;
            protected int mBonus;

            public static Employee create(String name) {
                try {
                    return (Employee) Class.forName(name).newInstance();
                } catch(Exception e) {
                    throw new IllegalArgumentException("Unable to instantiate");
                }
            }

            public abstract int payAmount();

            public void setMonthlySalary(int value) {
                mMonthlySalary = value;
            }

            public void setCommission(int value) {
                mCommission = value;
            }

            public void setBonus(int value) {
                mBonus = value;
            }
        }

        static class Engineer extends Employee {
            @Override
            public int payAmount() {
                return mMonthlySalary;
            }
        }

        static class Salesman extends Employee {
            @Override
            public int payAmount() {
                return mMonthlySalary + mCommission;
            }
        }

        static class Manager extends Employee {
            @Override
            public int payAmount() {
                return mMonthlySalary + mBonus;
            }
        }
    }
}
