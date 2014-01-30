package com.examples;

import static com.examples.util.Print.print;

public class _14_HideDelegate {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        public void show() {

            Person person = new Person("Employee");
            person.setDepartment(new Department(new Person("Manager")));

            print(person);
            Person manager = person.getDepartment().getManager();
            print("Manager: " + manager);
        }

        class Person {

            private String mName;
            private Department mDepartment;

            public Person(String name) {
                mName = name;
            }

            public Department getDepartment() {
                return mDepartment;
            }

            public void setDepartment(Department value) {
                mDepartment = value;
            }

            @Override
            public String toString() {
                return mName;
            }
        }

        class Department {

            private String mChargeCode;
            private Person mManager;

            public Department(Person manager) {
                mManager = manager;
            }

            public Person getManager() {
                return mManager;
            }

            @Override
            public String toString() {
                return "Department haded by " + mManager;
            }
        }
    }

    static class After {

        public void show() {

            Person person = new Person("Employee");
            person.setDepartment(new Department(new Person("Manager")));

            print(person);
            print("Manager: " + person.getManager());
        }

        class Person {

            private String mName;
            private Department mDepartment;

            public Person(String name) {
                mName = name;
            }

            public Person getManager() {
                return mDepartment.getManager();
            }

            public void setDepartment(Department value) {
                mDepartment = value;
            }

            @Override
            public String toString() {
                return mName;
            }
        }

        class Department {

            private String mChargeCode;
            private Person mManager;

            public Department(Person manager) {
                mManager = manager;
            }

            public Person getManager() {
                return mManager;
            }

            @Override
            public String toString() {
                return "Department haded by " + mManager;
            }
        }
    }
}
