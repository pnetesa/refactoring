package com.examples;

import junit.framework.Assert;

import java.util.Arrays;
import java.util.List;

import static com.examples.util.Print.print;

public class _45_ReplaceParameterWithExplicitMethods {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        private int mWidth;
        private int mHeight;

        public void setValue(String name, int value) {
            if ("height".equals(name)) {
                mHeight = value;
                return;
            } else if ("width".equals(name)) {
                mWidth = value;
                return;
            }
            Assert.fail("Should never reach here, invalid key: " + name);
        }

        public int getWidth() {
            return mWidth;
        }

        public int getHeight() {
            return mHeight;
        }

        public void show() {

            // Simple
            setValue("width", 123);
            setValue("height", 321);

            print("w = " + getWidth());
            print("h = " + getHeight());

            List<? extends Employee> employees = Arrays.asList(
                    Employee.create(Employee.ENGINEER),
                    Employee.create(Employee.SALESMAN),
                    Employee.create(Employee.MANAGER));

            for (Employee employee : employees) {
                print(employee.who());
            }
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

    static class After {

        private int mWidth;
        private int mHeight;

        public void setWidth(int value) {
            mWidth = value;
        }

        public int getWidth() {
            return mWidth;
        }

        public void setHeight(int value) {
            mHeight = value;
        }

        public int getHeight() {
            return mHeight;
        }

        public void show() {

            // Simple
            setWidth(123);
            setHeight(321);

            print("w = " + getWidth());
            print("h = " + getHeight());

            List<? extends Employee> employees = Arrays.asList(
                    Employee.createEngineer(),
                    Employee.createSalesman(),
                    Employee.createManager());

            for (Employee employee : employees) {
                print(employee.who());
            }
        }

        static class Employee {

            private int mType;
            public static final int ENGINEER = 0;
            public static final int SALESMAN = 1;
            public static final int MANAGER = 2;

            public static Employee createEngineer() {
                return new Engineer();
            }

            public static Employee createSalesman() {
                return new Salesman();
            }

            public static Employee createManager() {
                return new Manager();
            }

            protected Employee(int type) {
                mType = type;
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
