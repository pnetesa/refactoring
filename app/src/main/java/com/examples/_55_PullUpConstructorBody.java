package com.examples;

import static com.examples.util.Print.print;

public class _55_PullUpConstructorBody {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
            Employee m = new Manager("John Doe", "JD", 9);
            print(m);
        }

        static class Employee {
            protected String mName;
            protected String mId;
        }

        static class Manager extends Employee {
            protected int mGrade;
            public Manager(String name, String id, int grade) {
                mName = name;
                mId = id;
                mGrade = grade;
            }

            @Override
            public String toString() {
                return String.format("Name: %s, Id: %s, Grade: %d", mName, mId, mGrade);
            }
        }
    }

    static class After {
        public void show() {
            Employee m = new Manager("John Doe", "JD", 9);
            print(m);
        }

        static class Employee {
            protected String mName;
            protected String mId;
            protected String mCar = "None";

            public Employee(String name, String id) {
                mName = name;
                mId = id;
            }
            
            public void initialize() {
                if (isPriviliged()) {
                    assignCar();
                }
            }

            protected boolean isPriviliged(){
                return false;
            }

            protected void assignCar() {}
        }

        static class Manager extends Employee {
            protected int mGrade;
            public Manager(String name, String id, int grade) {
                super(name, id);
                mGrade = grade;
                initialize();
            }

            @Override
            protected boolean isPriviliged() {
                return true;
            }

            @Override
            protected void assignCar() {
                mCar = "Ford Mustang";
            }

            @Override
            public String toString() {
                return String.format("Name: %s, Id: %s, Grade: %d, Car: %s", mName, mId, mGrade, mCar);
            }
        }
    }
}
