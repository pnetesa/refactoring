package com.examples;

import static com.examples.util.Print.print;

public class _33_ReplaceSubclassWithFields {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
            Person male = new Male();
            Person female = new Female();

            print("Male?: " + male.isMale() + "; code: " + male.getCode());
            print("Male?: " + female.isMale() + "; code: " + female.getCode());
        }

        static abstract class Person {
            abstract boolean isMale();
            abstract char getCode();
        }

        static class Male extends Person {

            @Override
            boolean isMale() {
                return true;
            }

            @Override
            char getCode() {
                return 'M';
            }
        }
        
        static class Female extends Person {

            @Override
            boolean isMale() {
                return false;
            }

            @Override
            char getCode() {
                return 'F';
            }
        }
    }

    static class After {
        public void show() {
            Person male = Person.createMale();
            Person female = Person.createFemale();

            print("Male?: " + male.isMale + "; code: " + male.code);
            print("Male?: " + female.isMale + "; code: " + female.code);
        }

        static class Person {

            public final boolean isMale;
            public final char code;

            protected Person(boolean isMale, char code) {
                this.isMale = isMale;
                this.code = code;
            }

            public static Person createMale() {
                return new Person(true, 'M');
            }

            public static Person createFemale() {
                return new Person(false, 'F');
            }
        }
    }
}
