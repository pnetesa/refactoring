package com.examples;

import java.util.Arrays;
import java.util.List;

import static com.examples.util.Print.print;

public class _09_SubstituteAlgorithm {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
            String[] people = { "Cathy", "Marry", "Stephan", "Tom", "John" };
            print(foundPerson(people));
        }

        public String foundPerson(String[] people) {
            for (int i = 0; i < people.length; i++) {

                String person = people[i];

                if ("Don".equals(person)) {
                    return person;
                }

                if ("John".equals(person)) {
                    return person;
                }

                if ("Kent".equals(person)) {
                    return person;
                }
            }

            return "";
        }
    }

    static class After {

        public void show() {
            String[] people = { "Cathy", "Marry", "Stephan", "Tom", "John" };
            print(foundPerson(people));
        }

        public String foundPerson(String[] people) {

            List<String> candidates = Arrays.asList(new String[] { "Don", "John", "Kent" });

            for (int i = 0; i < people.length; i++) {

                if (candidates.contains(people[i]))
                    return people[i];

            }

            return "";
        }
    }
}
