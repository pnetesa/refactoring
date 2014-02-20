package com.examples;

import static com.examples.util.Print.print;

public class _39_ReplaceConditionalWithPolymorphism {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
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

            Employee engineer = new Employee(EmployeeType.ENGINEER);
            engineer.setMonthlySalary(1500);

            Employee salesman = new Employee(EmployeeType.SALESMAN);
            salesman.setMonthlySalary(1200);
            salesman.setCommission(300);

            Employee manager = new Employee(EmployeeType.MANAGER);
            manager.setMonthlySalary(2200);
            manager.setBonus(750);

            print("Engineer: " + engineer.payAmount());
            print("Salesman: " + salesman.payAmount());
            print("Manager: " + manager.payAmount());
        }

        static class Employee {

            private EmployeeType mType;

            protected int mMonthlySalary;
            protected int mCommission;
            protected int mBonus;

            public Employee(int type) {
                setType(type);
            }

            public int payAmount() {
                return mType.payAmount(this);
            }

            public void setType(int type) {
                mType = EmployeeType.create(type);
            }

            public int getMonthlySalary() {
                return mMonthlySalary;
            }

            public void setMonthlySalary(int value) {
                mMonthlySalary = value;
            }

            public int getCommission() {
                return mCommission;
            }

            public void setCommission(int value) {
                mCommission = value;
            }

            public int getBonus() {
                return mBonus;
            }

            public void setBonus(int value) {
                mBonus = value;
            }
        }

        static abstract class EmployeeType {

            public static final int ENGINEER = 0;
            public static final int SALESMAN = 1;
            public static final int MANAGER = 2;

            public static EmployeeType create(int type) {
                switch (type) {
                    case EmployeeType.ENGINEER:
                        return new Engineer();
                    case EmployeeType.SALESMAN:
                        return new Salesman();
                    case EmployeeType.MANAGER:
                        return new Manager();
                    default:
                        throw new RuntimeException("Incorrect Employee code");
                }
            }

            abstract public int payAmount(Employee employee);
        }

        static class Engineer extends EmployeeType {
            @Override
            public int payAmount(Employee employee) {
                return employee.getMonthlySalary();
            }
        }

        static class Salesman extends EmployeeType {
            @Override
            public int payAmount(Employee employee) {
                return employee.getMonthlySalary() + employee.getCommission();
            }
        }

        static class Manager extends EmployeeType {
            @Override
            public int payAmount(Employee employee) {
                return employee.getMonthlySalary() + employee.getBonus();
            }
        }
    }
}
