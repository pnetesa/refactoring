package com.examples;

import java.util.Calendar;
import java.util.Date;

import static com.examples.util.Print.print;

public class _17_IntroduceLocalExtension {

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

        class DateExtension {

            private Calendar mCalendar;

            public DateExtension(Calendar calendar) {
                mCalendar = calendar;
            }

            public Date getTomorrow() {
                mCalendar.add(Calendar.DATE, 1);
                return mCalendar.getTime();
            }
        }

        public void show() {

            Calendar calendar = Calendar.getInstance();
            print(calendar.getTime());

            print(new DateExtension(calendar).getTomorrow());
        }
    }
}
