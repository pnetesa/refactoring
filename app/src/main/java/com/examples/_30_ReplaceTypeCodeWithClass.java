package com.examples;

import static com.examples.util.Print.print;

public class _30_ReplaceTypeCodeWithClass {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
            Person harry = new Person(Person.A);
            Person sally = new Person(Person.AB);

            print("Harry: " + harry.getBloodGroup());
            print("Sally: " + sally.getBloodGroup());
        }

        class Person {
            public static final int O = 0;
            public static final int A = 1;
            public static final int B = 2;
            public static final int AB = 3;

            private int mBloodGroup;

            public Person(int bloodGroup) {
                mBloodGroup = bloodGroup;
            }

            public int getBloodGroup() {
                return mBloodGroup;
            }

            public void setBloodGroup(int bloodGroup) {
                mBloodGroup = bloodGroup;
            }
        }
    }

    static class After {
        public void show() {
            Person harry = new Person(BloodGroup.A);
            Person sally = new Person(BloodGroup.AB);

            print("Harry: " + harry.getBloodGroup().getCode());
            print("Sally: " + sally.getBloodGroup().getCode());
        }

        static class Person {
            public static final int O = BloodGroup.O.getCode();
            public static final int A = BloodGroup.A.getCode();
            public static final int B = BloodGroup.B.getCode();
            public static final int AB = BloodGroup.AB.getCode();

            private BloodGroup mBloodGroup;

            public Person(BloodGroup bloodGroup) {
                mBloodGroup = bloodGroup;
            }

            public BloodGroup getBloodGroup() {
                return mBloodGroup;
            }

            public void setBloodGroup(BloodGroup bloodGroup) {
                mBloodGroup = bloodGroup;
            }
        }

        static class BloodGroup {
            public static final BloodGroup O = new BloodGroup(0);
            public static final BloodGroup A = new BloodGroup(1);
            public static final BloodGroup B = new BloodGroup(2);
            public static final BloodGroup AB = new BloodGroup(3);
            private static final BloodGroup[] mValues = { O, A, B, AB };

            private final int mCode;

            public BloodGroup(int code) {
                mCode = code;
            }

            public int getCode() {
                return mCode;
            }

            public static BloodGroup code(int codeIndex) {
                return mValues[codeIndex];
            }
        }
    }
}
