package com.examples;

import java.util.ArrayList;
import java.util.List;

import static com.examples.util.Print.print;

public class _51_EncapsulateDowncast {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {

            Site site = new Site();
            Reading lastReading = (Reading) site.lastReading();

            print(lastReading);
        }

        class Site {

            private Readings mReadings = new Readings();

            public Site() {
                mReadings.add("<html>");
                mReadings.add("<body>");
                mReadings.add("</body>");
                mReadings.add("</html>");
            }

            public Object lastReading() {
                return mReadings.lastElement();
            }
        }

        class Readings {

            private List<Reading> mReadings = new ArrayList<Reading>();

            public void add(String tag) {
                mReadings.add(new Reading(tag));
            }

            public Object lastElement() {
                return mReadings.size() > 0 ? mReadings.get(mReadings.size() - 1) : null;
            }
        }

        class Reading {

            private String mTag;

            public Reading(String tag) {
                mTag = tag;
            }

            @Override
            public String toString() {
                return mTag;
            }
        }
    }

    static class After {
        public void show() {

            Site site = new Site();
            Reading lastReading = site.lastReading();

            print(lastReading);
        }

        class Site {

            private Readings mReadings = new Readings();

            public Site() {
                mReadings.add("<html>");
                mReadings.add("<body>");
                mReadings.add("</body>");
                mReadings.add("</html>");
            }

            public Reading lastReading() {
                return (Reading) mReadings.lastElement();
            }
        }

        class Readings {

            private List<Reading> mReadings = new ArrayList<Reading>();

            public void add(String tag) {
                mReadings.add(new Reading(tag));
            }

            public Object lastElement() {
                return mReadings.size() > 0 ? mReadings.get(mReadings.size() - 1) : null;
            }
        }

        class Reading {

            private String mTag;

            public Reading(String tag) {
                mTag = tag;
            }

            @Override
            public String toString() {
                return mTag;
            }
        }
    }
}
