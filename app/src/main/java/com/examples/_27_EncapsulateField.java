package com.examples;

import static com.examples.util.Print.print;

public class _27_EncapsulateField {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
            Example obj = new Example();
            obj.mName = "Hello";
            print(obj.mName);
        }

        class Example {
            public String mName;
        }
    }

    static class After {
        public void show() {
            Example obj = new Example();
            obj.setName("Hello");
            print(obj.getName());
        }

        class Example {
            private String mName;

            public String getName() {
                return mName;
            }

            public void setName(String name) {
                mName = name;
            }
        }
    }
}
