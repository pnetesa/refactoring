package com.examples;

import java.util.Calendar;
import java.util.Date;

import static com.examples.util.Print.print;

public class _16_IntroduceForeignMethod {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        public void show() {

            Calendar calendar = Calendar.getInstance();
            print(calendar.getTime());

            calendar.add(Calendar.DATE, 1);
            print(calendar.getTime());
        }
    }

    static class After {

        public void show() {
            Calendar calendar = Calendar.getInstance();
            print(calendar.getTime());
            print(nextDate(calendar));
        }

        private Date nextDate(Calendar calendar) {
            calendar.add(Calendar.DATE, 1);
            return calendar.getTime();
        }
    }
}
