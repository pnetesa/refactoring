package com.examples;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.examples.util.Print.print;

public class _25_ChangeBidirectionalAsscociationToUnidirectional {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        class Order {

            private String mName;

            public Order(String name) {
                mName = name;
            }

            private Customer mCustomer;

            public Customer getCustomer() {
                return mCustomer;
            }

            public void setCustomer(Customer value) {

                if (mCustomer != null) {
                    mCustomer.friendOrders().remove(this);
                }

                mCustomer = value;

                if (mCustomer != null) {
                    mCustomer.friendOrders().add(this);
                }
            }

            @Override
            public String toString() {
                return mName;
            }
        }

        class Customer {

            private String mName;
            private Set<Order> mOrders = new HashSet<Order>();

            public Customer(String name) {
                mName = name;
            }

            /* internal */
            Set<Order> friendOrders() {
                return mOrders;
            }

            /* internal */
            void addOrder(Order order) {
                order.setCustomer(this);
            }

            @Override
            public String toString() {
                return mName;
            }
        }

        public void show() {

            Customer customer = new Customer("John Smith");

            Order order = new Order("Pizza");
            order.setCustomer(new Customer("Mary Jones"));
            order.setCustomer(new Customer("Adam Smith"));

            order.setCustomer(customer);
            customer.addOrder(new Order("Crisps"));
            customer.addOrder(new Order("Coffee"));

            print(order);
            print(order.getCustomer());
            print(customer);
            print(customer.friendOrders());
        }
    }

    static class After {

        class Order {

            private String mName;
            private double mGrossPrice;

            public Order(String name) {
                mName = name;
            }

            public Customer getCustomer() {
                for (Customer customer : Customer.getInstances()) {
                    if (customer.containsOrder(this)) {
                        return customer;
                    }
                }

                return null;
            }

            public void setCustomer(Customer customer) {
                if (getCustomer() != null) {
                    getCustomer().friendOrders().remove(this);
                }

                if (customer != null) {
                    customer.friendOrders().add(this);
                }
            }

            @Override
            public String toString() {
                return mName;
            }

            public double getGrossPrice() {
                return mGrossPrice;
            }

            public void setGrossPrice(double value) {
                mGrossPrice = value;
            }

            public double getDiscountPrice(Customer customer) {
                return getGrossPrice() * (1 - customer.getDiscount());
            }
        }

        static class Customer {

            private static List<Customer> mInstances = new ArrayList<Customer>();

            private String mName;
            private double mDiscount;
            private Set<Order> mOrders = new HashSet<Order>();

            public Customer(String name) {
                mName = name;
                mInstances.add(this);
            }

            public static List<Customer> getInstances() {
                return mInstances;
            }

            /* internal */
            Set<Order> friendOrders() {
                return mOrders;
            }

            /* internal */
            void addOrder(Order order) {
                order.setCustomer(this);
            }

            public double getPriceFor(Order order) {
                Assert.assertTrue(mOrders.contains(order));
                return order.getDiscountPrice(this);
            }

            public double getDiscount() {
                return mDiscount;
            }

            public void setDiscount(double discount) {
                mDiscount = discount;
            }

            @Override
            public String toString() {
                return mName;
            }

            public boolean containsOrder(Order order) {
                return mOrders.contains(order);
            }
        }

        public void show() {
            Customer customer = new Customer("John Smith");
            customer.setDiscount(0.3);

            Order order = new Order("Pizza");
            order.setGrossPrice(65.0);
            order.setCustomer(new Customer("Mary Jones"));
            order.setCustomer(new Customer("Adam Smith"));

            order.setCustomer(customer);
            customer.addOrder(new Order("Crisps"));
            customer.addOrder(new Order("Coffee"));

            print(order);
            print("Gross price: " + order.getGrossPrice());
            print(order.getCustomer());

            print(customer);
            print("Discount: " + customer.getDiscount());
            print("Order price: " + customer.getPriceFor(order));
            print(customer.friendOrders());
        }
    }
}
