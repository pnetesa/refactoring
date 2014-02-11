package com.examples;

import static com.examples.util.Print.print;

public class _26_ReplaceMagicNumberWithSymbolicConstant {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
            double mass = 64;
            double height = 5;
            print("Mass = " + mass + " Height = " + height);
            print("Energy = " + potentialEnergy(mass, height));
        }

        private double potentialEnergy(double mass, double height) {
            return mass * 9.81 * height;
        }
    }

    static class After {

        public static final double GRAVITATIONAL_CONSTANT = 9.81;

        public void show() {
            double mass = 64;
            double height = 5;
            print("Mass = " + mass + " Height = " + height);
            print("Energy = " + potentialEnergy(mass, height));
        }

        private double potentialEnergy(double mass, double height) {
            return mass * GRAVITATIONAL_CONSTANT * height;
        }
    }
}
