package com.examples;

import static com.examples.util.Print.print;

public class _42_RenameMethod {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        private String mOfficeAreaCode;
        private String mOfficeNumber;

        public void show() {
            mOfficeAreaCode = "957";
            mOfficeNumber = "423-08-08";

            print(getTelephoneNumber());
        }

        public String getTelephoneNumber() {
            return "(" + mOfficeAreaCode + ") " + mOfficeNumber;
        }
    }

    static class After {

        private String mOfficeAreaCode;
        private String mOfficeNumber;

        public void show() {
            mOfficeAreaCode = "957";
            mOfficeNumber = "423-08-08";

            print(getOfficeTelephoneNumber());
        }

        public String getOfficeTelephoneNumber() {
            return "(" + mOfficeAreaCode + ") " + mOfficeNumber;
        }
    }
}
