package com.examples;

import static com.examples.util.Print.print;

public class _37_RemoveControlFlag {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
            String[] people = { "John", "Mary", "Don" };
            checkSecurity(people);
            checkSecurity2(people);
        }

        /* Example 1 */
        public void checkSecurity(String[] people) {

            boolean found = false;
            for (int i = 0; i < people.length; i++) {

                if (!found) {

                    if ("Don".equals(people[i])) {
                        sendAlert();
                        found = true;
                    }

                    if ("John".equals(people[i])) {
                        sendAlert();
                        found = true;
                    }
                }
            }
        }

        /* Example 2 */
        public void checkSecurity2(String[] people) {

            String found = "";
            for (int i = 0; i < people.length; i++) {

                if ("".equals(found)) {

                    if ("Don".equals(people[i])) {
                        sendAlert();
                        found = "Don";
                    }

                    if ("John".equals(people[i])) {
                        sendAlert();
                        found = "John";
                    }
                }
            }
            someLaterCode(found);
        }

        private void someLaterCode(String found) {
            // Empty
        }

        private void sendAlert() {
            print("Sending alert... Alert! Alert!");
        }
    }

    static class After {
        public void show() {
            String[] people = { "John", "Mary", "Don" };
            checkSecurity(people);
            checkSecurity2(people);
        }

        /* Example 1 */
        public void checkSecurity(String[] people) {

            for (int i = 0; i < people.length; i++) {

                if ("Don".equals(people[i])) {
                    sendAlert();
                    break;
                }

                if ("John".equals(people[i])) {
                    sendAlert();
                    break;
                }
            }
        }

        /* Example 2 */
        public void checkSecurity2(String[] people) {
            String found = foundMiscreant(people);
            someLaterCode(found);
        }

        private String foundMiscreant(String[] people) {
            for (int i = 0; i < people.length; i++) {

                if ("Don".equals(people[i])) {
                    sendAlert();
                    return "Don";
                }

                if ("John".equals(people[i])) {
                    sendAlert();
                    return "John";
                }
            }
            return "";
        }

        private void someLaterCode(String found) {
            // Empty
        }

        private void sendAlert() {
            print("Sending alert... Alert! Alert!");
        }
    }
}
