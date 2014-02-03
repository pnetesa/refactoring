package com.examples;

import java.util.Arrays;

import static com.examples.util.Print.print;

public class _22_ReplaceArrayWithObject {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
            String[] row = new String[3];
            row[0] = "Liverpool";
            row[1] = "15";
            print(Arrays.toString(row));
        }
    }

    static class After {
        public void show() {
            Performance row = new Performance();
            row.setName("Liverpool");
            row.setWins("15");
            print(row.getName() + ", " + row.getWins());
        }

        class Performance {

            private String mName;
            private int mWins;

            public String getName() {
                return mName;
            }

            public void setName(String value) {
                mName = value;
            }

            public int getWins() {
                return mWins;
            }

            public void setWins(String value) {
                mWins = Integer.parseInt(value);
            }
        }
    }
}
