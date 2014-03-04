package com.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.examples.util.Print.print;

public class _48_IntroduceParameterObject {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {

            Calendar calendar;
            calendar = Calendar.getInstance();

            calendar.set(2011, 6, 4);
            Date date0 = calendar.getTime();
            calendar.set(2012, 7, 15);
            Date date1 = calendar.getTime();
            calendar.set(2013, 9, 30);
            Date date2 = calendar.getTime();
            calendar.set(2013, 11, 31);
            Date date3 = calendar.getTime();
            calendar.set(2014, 3, 1);
            Date date4 = calendar.getTime();

            Account account = new Account(Arrays.asList(
                    new Entry(39.99, date0),
                    new Entry(49.99, date1),
                    new Entry(69.99, date2),
                    new Entry(75.99, date3),
                    new Entry(99.99, date4)));

            calendar.set(2011, 1, 1);
            Date startDate = calendar.getTime();

            calendar.set(2013, 1, 1);
            Date endDate = calendar.getTime();

            double flow = account.getFlowBetween(startDate, endDate);
            print("2011 - 2012: " + flow);

            calendar.set(2013, 1, 1);
            startDate = calendar.getTime();

            calendar.set(2015, 1, 1);
            endDate = calendar.getTime();

            flow = account.getFlowBetween(startDate, endDate);
            print("2013 - 2014: " + flow);
        }

        class Entry {
            private double mValue;
            private Date mChargeDate;

            public Entry(double value, Date chargeDate) {
                mValue = value;
                mChargeDate = chargeDate;
            }

            public Date getDate() {
                return mChargeDate;
            }

            public double getValue() {
                return mValue;
            }
        }

        class Account {

            private List<Entry> mEntries = new ArrayList<Entry>();

            public Account(List<Entry> entries) {
                mEntries.addAll(entries);
            }

            public double getFlowBetween(Date start, Date end) {
                double result = 0;
                for (Entry entry : mEntries) {
                    Date entryDate = entry.getDate();
                    if (entryDate.equals(start) || entryDate.equals(end) ||
                            (entryDate.after(start) && entryDate.before(end))) {
                        result += entry.getValue();
                    }
                }
                return result;
            }
        }
    }

    static class After {
        public void show() {

            Calendar calendar;
            calendar = Calendar.getInstance();

            calendar.set(2011, 6, 4);
            Date date0 = calendar.getTime();
            calendar.set(2012, 7, 15);
            Date date1 = calendar.getTime();
            calendar.set(2013, 9, 30);
            Date date2 = calendar.getTime();
            calendar.set(2013, 11, 31);
            Date date3 = calendar.getTime();
            calendar.set(2014, 3, 1);
            Date date4 = calendar.getTime();

            Account account = new Account(Arrays.asList(
                    new Entry(39.99, date0),
                    new Entry(49.99, date1),
                    new Entry(69.99, date2),
                    new Entry(75.99, date3),
                    new Entry(99.99, date4)));

            calendar.set(2011, 1, 1);
            Date startDate = calendar.getTime();
            calendar.set(2013, 1, 1);
            Date endDate = calendar.getTime();
            DateRange range = new DateRange(startDate, endDate);

            double flow = account.getFlowBetween(range);
            print("2011 - 2012: " + flow);

            calendar.set(2013, 1, 1);
            startDate = calendar.getTime();
            calendar.set(2015, 1, 1);
            endDate = calendar.getTime();
            range = new DateRange(startDate, endDate);

            flow = account.getFlowBetween(range);
            print("2013 - 2014: " + flow);
        }

        class DateRange {
            public final Date start;
            public final Date end;

            public DateRange(Date start, Date end) {
                this.start = start;
                this.end = end;
            }

            public boolean includes(Date date) {
                return date.equals(start) || date.equals(end) ||
                        (date.after(start) && date.before(end));
            }
        }

        class Entry {
            private double mValue;
            private Date mChargeDate;

            public Entry(double value, Date chargeDate) {
                mValue = value;
                mChargeDate = chargeDate;
            }

            public Date getDate() {
                return mChargeDate;
            }

            public double getValue() {
                return mValue;
            }
        }

        class Account {

            private List<Entry> mEntries = new ArrayList<Entry>();

            public Account(List<Entry> entries) {
                mEntries.addAll(entries);
            }

            public double getFlowBetween(DateRange range) {
                double result = 0;
                for (Entry entry : mEntries) {
                    if (range.includes(entry.getDate())) {
                        result += entry.getValue();
                    }
                }
                return result;
            }
        }
    }
}
