package com.examples;

import static com.examples.util.Print.print;

public class _31_ReplaceTypeCodeWithSubclasses {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        public void show() {

            Employee e = new Employee(Employee.ENGINEER);
            Employee s = new Employee(Employee.SALESMAN);
            Employee m = new Employee(Employee.MANAGER);

            who(m);
            who(e);
            who(s);
        }

        public void who(Employee employee) {

            int type = employee.getType();

            switch (type) {
                case Employee.ENGINEER:
                    print("Engineer");
                    break;
                case Employee.SALESMAN:
                    print("Salesman");
                    break;
                case Employee.MANAGER:
                    print("Manager");
                    break;
            }
        }

        class Employee {

            private int mType;
            public static final int ENGINEER = 0;
            public static final int SALESMAN = 1;
            public static final int MANAGER = 2;

            public Employee(int type) {
                mType = type;
            }

            public int getType() {
                return mType;
            }
        }
    }

    static class After {

        public void show() {

            Employee e = Employee.create(Employee.ENGINEER);
            Employee s = Employee.create(Employee.SALESMAN);
            Employee m = Employee.create(Employee.MANAGER);

            who(m);
            who(e);
            who(s);
        }

        public void who(Employee employee) {
            print(employee.who());
        }

        static class Employee {

            private int mType;
            public static final int ENGINEER = 0;
            public static final int SALESMAN = 1;
            public static final int MANAGER = 2;

            public static Employee create(int type) {
                switch (type) {
                    case ENGINEER:
                        return new Engineer();
                    case SALESMAN:
                        return new Salesman();
                    case MANAGER:
                        return new Manager();
                    default:
                        throw new IllegalArgumentException("Incorrect type code value");
                }
            }

            protected Employee(int type) {
                mType = type;
            }

            public int getType() {
                return mType;
            }

            public String who() {
                throw new UnsupportedOperationException();
            }
        }

        static class Engineer extends Employee {
            protected Engineer() {
                super(Employee.ENGINEER);
            }

            @Override
            public String who() {
                return "Engineer";
            }
        }

        static class Salesman extends Employee {
            protected Salesman() {
                super(Employee.SALESMAN);
            }

            @Override
            public String who() {
                return "Salesman";
            }
        }

        static class Manager extends Employee {
            protected Manager() {
                super(Employee.MANAGER);
            }

            @Override
            public String who() {
                return "Manager";
            }
        }
    }
}
