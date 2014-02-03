package com.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.examples.util.Print.print;

public class _20_ChangeValueToReference {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        public void show() {
            List<Order> orders = new ArrayList<Order>(Arrays.asList(
                    new Order("John Smith"),
                    new Order("Mary Jones"),
                    new Order("John Smith"),
                    new Order("Adam Smith")));
            print("John Smith: " + numberOfOrdersFor(orders, "John Smith"));
            print("Mary Jones: " + numberOfOrdersFor(orders, "Mary Jones"));

            orders.add(new Order("Mary Jones"));
            print("Mary Jones: " + numberOfOrdersFor(orders, "Mary Jones"));
        }

        private static int numberOfOrdersFor(List<Order> orders, String customer) {

            int result = 0;
            for (Order order : orders) {
                if (order.getCustomerName().equals(customer)) {
                    result++;
                }
            }

            return result;
        }

        class Order {
            private Customer mCustomer;

            public Order(String customer) {
                mCustomer = new Customer(customer);
            }

            public String getCustomerName() {
                return mCustomer.getName();
            }

            public void setCustomer(String value) {
                mCustomer = new Customer(value);
            }
        }

        class Customer {
            private final String mName;

            public Customer(String name) {
                mName = name;
            }

            public String getName() {
                return mName;
            }
        }
    }

    static class After {

        public void show() {
            List<Order> orders = new ArrayList<Order>(Arrays.asList(
                    new Order("John Smith"),
                    new Order("Mary Jones"),
                    new Order("John Smith"),
                    new Order("Adam Smith")));
            print("John Smith: " + numberOfOrdersFor(orders, "John Smith"));
            print("Mary Jones: " + numberOfOrdersFor(orders, "Mary Jones"));

            orders.add(new Order("Mary Jones"));
            print("Mary Jones: " + numberOfOrdersFor(orders, "Mary Jones"));
        }

        private static int numberOfOrdersFor(List<Order> orders, String customer) {

            int result = 0;
            for (Order order : orders) {
                if (order.getCustomerName().equals(customer)) {
                    result++;
                }
            }

            return result;
        }

        class Order {
            private Customer mCustomer;

            public Order(String customer) {
                mCustomer = Customer.getNamed(customer);
            }

            public String getCustomerName() {
                return mCustomer.getName();
            }

            public void setCustomer(String value) {
                mCustomer = Customer.getNamed(value);
            }
        }

        static class Customer {

            private final String mName;
            
            private static Map<String, Customer> mInstances;

            static {
                mInstances = new HashMap<String, Customer>();
                loadCustomers();
            }

            public static Customer getNamed(String name) {
                return mInstances.get(name);
            }

            private Customer(String name) {
                mName = name;
            }
            
            private static void loadCustomers() {
                new Customer("John Smith").store();
                new Customer("Mary Jones").store();
                new Customer("Adam Smith").store();
            }

            private void store() {
                mInstances.put(getName(), this);
            }

            public String getName() {
                return mName;
            }
        }
    }
}
