package com.examples;

import static com.examples.util.Print.print;

public class _46_PreserveWholeObject {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        public void show() {

            TempRange planRange = new TempRange(19, 24);
            HeatingPlan heatingPlan = new HeatingPlan();
            heatingPlan.setRange(planRange);

            Room room1 = new Room(new TempRange(0, 5));
            Room room2 = new Room(new TempRange(-5, 2));
            Room room3 = new Room(new TempRange(20, 24));

            print(room1.daysTempRange() + " in " + planRange + ": " +
                    room1.withinPlan(heatingPlan));
            print(room2.daysTempRange() + " in " + planRange + ": " +
                    room2.withinPlan(heatingPlan));
            print(room3.daysTempRange() + " in " + planRange + ": " +
                    room3.withinPlan(heatingPlan));
        }

        class Room {

            private TempRange mRange;

            public Room(TempRange range) {
                mRange = range;
            }

            public boolean withinPlan(HeatingPlan plan) {
                int low = daysTempRange().getLow();
                int high = daysTempRange().getHigh();
                return plan.withinRange(low, high);
            }

            private TempRange daysTempRange() {
                return mRange;
            }
        }

        class HeatingPlan {

            private TempRange mRange;

            public boolean withinRange(int low, int high) {
                return low >= mRange.getLow() && high <= mRange.getHigh();
            }

            public void setRange(TempRange range) {
                mRange = range;
            }
        }

        class TempRange {

            private int mLow;
            private int mHigh;

            public TempRange(int low, int high) {
                mLow = low;
                mHigh = high;
            }

            public int getLow() {
                return mLow;
            }

            public int getHigh() {
                return mHigh;
            }

            @Override
            public String toString() {
                return "(" + mLow + ", " + mHigh + ")";
            }
        }
    }

    static class After {

        public void show() {

            TempRange planRange = new TempRange(19, 24);
            HeatingPlan heatingPlan = new HeatingPlan();
            heatingPlan.setRange(planRange);

            Room room1 = new Room(new TempRange(0, 5));
            Room room2 = new Room(new TempRange(-5, 2));
            Room room3 = new Room(new TempRange(20, 24));

            print(room1.daysTempRange() + " in " + planRange + ": " +
                    room1.withinPlan(heatingPlan));
            print(room2.daysTempRange() + " in " + planRange + ": " +
                    room2.withinPlan(heatingPlan));
            print(room3.daysTempRange() + " in " + planRange + ": " +
                    room3.withinPlan(heatingPlan));
        }

        class Room {

            private TempRange mRange;

            public Room(TempRange range) {
                mRange = range;
            }

            public boolean withinPlan(HeatingPlan plan) {
                return plan.withinRange(daysTempRange());
            }

            private TempRange daysTempRange() {
                return mRange;
            }
        }

        class HeatingPlan {

            private TempRange mRange;

            public boolean withinRange(TempRange roomRange) {
                return mRange.includes(roomRange);
            }

            public void setRange(TempRange range) {
                mRange = range;
            }
        }

        class TempRange {

            private int mLow;
            private int mHigh;

            public TempRange(int low, int high) {
                mLow = low;
                mHigh = high;
            }

            public int getLow() {
                return mLow;
            }

            public int getHigh() {
                return mHigh;
            }

            private boolean includes(TempRange range) {
                return range.getLow() >= getLow() && range.getHigh() <= getHigh();
            }

            @Override
            public String toString() {
                return "(" + mLow + ", " + mHigh + ")";
            }
        }
    }
}
