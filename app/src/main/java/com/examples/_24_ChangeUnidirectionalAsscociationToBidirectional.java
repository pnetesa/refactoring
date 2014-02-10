package com.examples;

import java.util.HashSet;
import java.util.Set;

import static com.examples.util.Print.print;

public class _24_ChangeUnidirectionalAsscociationToBidirectional {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        class Order {

            private Customer mCustomer;
            private String mName;

            public Order(String name) {
                mName = name;
            }

            public Customer getCustomer() {
                return mCustomer;
            }

            public void setCustomer(Customer customer) {
                mCustomer = customer;
            }

            @Override
            public String toString() {
                return mName;
            }
        }

        class Customer {

            private String mName;

            public Customer(String name) {
                mName = name;
            }

            @Override
            public String toString() {
                return mName;
            }
        }

        public void show() {
            Order order = new Order("Pizza");
            order.setCustomer(new Customer("John Smith"));
            order.setCustomer(new Customer("Mary Jones"));

            print(order);
            print(order.getCustomer());
        }
    }

    static class After {

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
}
