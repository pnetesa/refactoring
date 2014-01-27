package com.examples;

import static com.examples.util.Print.print;

public class _13_InlineClass {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        public void show() {

            TelephoneNumber officeTelephone = new TelephoneNumber();
            officeTelephone.setAreaCode("050");
            officeTelephone.setNumber("123-45-67");

            Person person = new Person("John Smith");
            person.setOfficeTelephone(officeTelephone);

            print(person.getName());
            print(person.getOfficeTelephone().getTelephoneNumber());
        }

        static class Person {

            private String mName;
            private TelephoneNumber mOfficeTelephone;

            public Person(String name) {
                mName = name;
            }

            public String getName() {
                return mName;
            }

            public TelephoneNumber getOfficeTelephone() {
                return mOfficeTelephone;
            }

            public void setOfficeTelephone(TelephoneNumber value) {
                mOfficeTelephone = value;
            }
        }

        class TelephoneNumber {

            private String mAreaCode;
            private String mNumber;

            public String getTelephoneNumber() {
                return "(" + mAreaCode + ") " + mNumber;
            }

            public void setAreaCode(String value) {
                mAreaCode = value;
            }

            public void setNumber(String value) {
                mNumber = value;
            }
        }
    }

    static class After {

        public void show() {

            Person person = new Person("John Smith");
            person.setAreaCode("050");
            person.setNumber("123-45-67");

            print(person.getName());
            print(person.getTelephoneNumber());
        }

        static class Person {

            private String mName;
            private String mAreaCode;
            private String mNumber;

            public Person(String name) {
                mName = name;
            }

            public String getName() {
                return mName;
            }

            public String getTelephoneNumber() {
                return "(" + mAreaCode + ") " + mNumber;
            }

            public void setAreaCode(String value) {
                mAreaCode = value;
            }

            public void setNumber(String value) {
                mNumber = value;
            }
        }
    }
}
