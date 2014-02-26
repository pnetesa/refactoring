package com.examples;

import static com.examples.util.Print.print;

public class _43_SeparateQueryFromModifier {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
            print("First check...");
            checkSecurity(new String[]{"Abraham", "Jako", "Adolf", "Don", "Polina", "John"});

            print();
            print("Another check...");
            checkSecurity(new String[] { "Abraham", "Jako", "Adolf", "Polina" });
        }

        private void checkSecurity(String[] people) {
            String miscreant = foundMiscreant(people);
            showMiscreant(miscreant);
        }

        private void showMiscreant(String miscreant) {
            if (miscreant.length() > 0) {
                print("Miscreant: " + miscreant);
            } else {
                print("All good.");
            }
        }

        public String foundMiscreant(String[] people) {
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

        private void sendAlert() {
            print("Alert!! Miscreant found!!! Miscreant found!!!...");
        }
    }

    static class After {
        public void show() {
            print("First check...");
            checkSecurity(new String[]{"Abraham", "Jako", "Adolf", "Don", "Polina", "John"});

            print();
            print("Another check...");
            checkSecurity(new String[] { "Abraham", "Jako", "Adolf", "Polina" });
        }

        private void checkSecurity(String[] people) {
            sendAlert(people);
            String miscreant = foundPerson(people);
            showMiscreant(miscreant);
        }

        private void showMiscreant(String miscreant) {
            if (miscreant.length() > 0) {
                print("Miscreant: " + miscreant);
            } else {
                print("All good.");
            }
        }

        public void sendAlert(String[] people) {
            if (!foundPerson(people).equals("")) {
                sendAlert();
            }
        }

        public String foundPerson(String[] people) {
            for (int i = 0; i < people.length; i++) {
                if ("Don".equals(people[i])) {
                    return "Don";
                }
                if ("John".equals(people[i])) {
                    return "John";
                }
            }
            return "";
        }

        private void sendAlert() {
            print("Alert!! Miscreant found!!! Miscreant found!!!...");
        }
    }
}
