package com.examples;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.examples.util.Print.print;

public class _34_DecomposeConditional {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {

            Calendar calendar = Calendar.getInstance(Locale.getDefault());

            Test obj = new Test(100, 50, 25);
            print("Now: " + obj.getCharge(5, calendar.getTime()));

            calendar.set(calendar.get(Calendar.YEAR), Calendar.JUNE, 10);
            print("Summertime: " + obj.getCharge(5, calendar.getTime()));
        }
        
        class Test {
            
            private final Date SUMMER_START;
            private final Date SUMMER_END;

            private int mSummerRate;
            private int mWinterRate;
            private int mWinterServiceCharge;

            public Test(int winterRate, int summerRate, int winterServiceCharge) {

                Calendar calendar = Calendar.getInstance(Locale.getDefault());

                calendar.set(calendar.get(Calendar.YEAR), Calendar.JUNE, 1);
                SUMMER_START = calendar.getTime();

                calendar.set(calendar.get(Calendar.YEAR), Calendar.AUGUST, 31);
                SUMMER_END = calendar.getTime();

                mWinterRate = winterRate;
                mSummerRate = summerRate;
                mWinterServiceCharge = winterServiceCharge;
            }

            public int getCharge(int quantity, Date date) {

                int charge = 0;

                if (date.before(SUMMER_START) || date.after(SUMMER_END)) {
                    charge = quantity * mWinterRate * mWinterServiceCharge;
                } else {
                    charge = quantity * mSummerRate;
                }

                return charge;
            }
        }
    }

    static class After {
        public void show() {

            Calendar calendar = Calendar.getInstance(Locale.getDefault());

            Test obj = new Test(100, 50, 25);
            print("Now: " + obj.getCharge(5, calendar.getTime()));

            calendar.set(calendar.get(Calendar.YEAR), Calendar.JUNE, 10);
            print("Summertime: " + obj.getCharge(5, calendar.getTime()));
        }

        class Test {

            private final Date SUMMER_START;
            private final Date SUMMER_END;

            private int mSummerRate;
            private int mWinterRate;
            private int mWinterServiceCharge;

            public Test(int winterRate, int summerRate, int winterServiceCharge) {

                Calendar calendar = Calendar.getInstance(Locale.getDefault());

                calendar.set(calendar.get(Calendar.YEAR), Calendar.JUNE, 1);
                SUMMER_START = calendar.getTime();

                calendar.set(calendar.get(Calendar.YEAR), Calendar.AUGUST, 31);
                SUMMER_END = calendar.getTime();

                mWinterRate = winterRate;
                mSummerRate = summerRate;
                mWinterServiceCharge = winterServiceCharge;
            }

            public int getCharge(int quantity, Date date) {

                int charge = 0;

                if (notSummer(date)) {
                    charge = winterCharge(quantity);
                } else {
                    charge = summerCharge(quantity);
                }

                return charge;
            }

            private boolean notSummer(Date date) {
                return date.before(SUMMER_START) || date.after(SUMMER_END);
            }

            private int winterCharge(int quantity) {
                return quantity * mWinterRate * mWinterServiceCharge;
            }

            private int summerCharge(int quantity) {
                return quantity * mSummerRate;
            }
        }
    }
}
