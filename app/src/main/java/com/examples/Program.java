package com.examples;

import static com.examples.util.Print.*;

public class Program {

	public static void main(String[] args) {

        Before before = new Before();

        print();

        After after = new After();
	}

    static class Before {
        public void show() {
        }
    }

    static class After {
        public void show() {
        }
    }
}
