package com.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.examples.util.Print.print;

public class _01_ExtractMethod {

    public static void main(String[] args) {

        Before before = new Before();
        before.printOwing(1234.56);

        print();

        After after = new After();
        after.printOwing(1234.56);

        print();

        Before2 before2 = new Before2();
        before2.printOwing();

        print();

        After2 after2 = new After2();
        after2.printOwing();
        after2.printOwing(1234.56);
	}

    static class Before {

        private String mName = "Before";

        private void printBanner() {
        }

        public void printOwing(double amount) {
            printBanner();

            // Print details
            print("name: " + mName);
            print("amount: " + amount);
        }
    }

    static class After {

        private String mName = "After";

        private void printBanner() {
        }

        public void printOwing(double amount) {
            printBanner();
            printDetails(amount);
        }

        private void printDetails(double amount) {
            print("name: " + mName);
            print("amount: " + amount);
        }
    }

    static class Before2 {

        private String mName = "Before";
        private List<Order> mOrders = new ArrayList<Order>(
                Arrays.asList(new Order(1234.56), new Order(65.1234), new Order(987.654)));

        public void printOwing() {

            double outstanding = 0;

            // Print banner
            print ("**************************");
            print ("***** Customer Owes ******");
            print ("**************************");

            // Calculate outstanding
            for (Order order : mOrders) {
                outstanding += order.getAmount();
            }

            // Print details
            print("name: " + mName);
            print("amount: " + outstanding);
        }
    }

    static class After2 {

        private String mName = "After";
        private List<Order> mOrders = new ArrayList<Order>(
                Arrays.asList(new Order(1234.56), new Order(65.1234), new Order(987.654)));

        public void printOwing() {
            printBanner();
            double outstanding = getOutstanding(0);
            printDetails(outstanding);
        }

        public void printOwing(double previousAmount) {

            double outstanding = previousAmount * 1.2;
            printBanner();
            outstanding = getOutstanding(outstanding);
            printDetails(outstanding);
        }

        private double getOutstanding(double initialValue) {

            double result = initialValue;

            for (Order order : mOrders) {
                result += order.getAmount();
            }
            return result;
        }

        private void printDetails(double outstanding) {
            print("name: " + mName);
            print("amount: " + outstanding);
        }

        private void printBanner() {
            print ("**************************");
            print ("***** Customer Owes ******");
            print ("**************************");
        }
    }
}

