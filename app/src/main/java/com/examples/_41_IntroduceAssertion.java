package com.examples;

import junit.framework.Assert;

import static com.examples.util.Print.print;

public class _41_IntroduceAssertion {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {

            Employee individual = new Employee();
            individual.setExpenseLimit(500.5);

            print("Individual expense limit: " + individual.getExpenseLimit());
            print("Test 725: " + individual.withinLimit(725));

            Employee onProject = new Employee();
            onProject.setPrimaryProject(new Project(1099.99));

            print("Individual expense limit: " + onProject.getExpenseLimit());
            print("Test 725: " + onProject.withinLimit(725));
        }
        
        class Employee {

            public static final double NULL_EXPENSE = -1.0;
            private double mExpenseLimit = NULL_EXPENSE;
            private Project mPrimaryProject;

            public double getExpenseLimit() {
                return mExpenseLimit == NULL_EXPENSE ?
                        mPrimaryProject.getMemberExpenseLimit() : mExpenseLimit;
            }

            public void setExpenseLimit(double expenseLimit) {
                mExpenseLimit = expenseLimit;
            }

            public boolean withinLimit(double expenseAmount) {
                return expenseAmount <= getExpenseLimit();
            }

            public void setPrimaryProject(Project project) {
                mPrimaryProject = project;
            }
        }

        class Project {

            private double mMemberExpenseLimit;

            public Project(double memberExpenseLimit) {
                mMemberExpenseLimit = memberExpenseLimit;
            }

            public double getMemberExpenseLimit() {
                return mMemberExpenseLimit;
            }
        }
    }

    static class After {
        public void show() {

            Employee individual = new Employee();
            individual.setExpenseLimit(500.5);

            print("Individual expense limit: " + individual.getExpenseLimit());
            print("Test 725: " + individual.withinLimit(725));

            Employee onProject = new Employee();
            onProject.setPrimaryProject(new Project(1099.99));

            print("Individual expense limit: " + onProject.getExpenseLimit());
            print("Test 725: " + onProject.withinLimit(725));
        }

        class Employee {

            public static final double NULL_EXPENSE = -1.0;
            private double mExpenseLimit = NULL_EXPENSE;
            private Project mPrimaryProject;

            public double getExpenseLimit() {

                Assert.assertTrue(
                        mExpenseLimit != NULL_EXPENSE || mPrimaryProject != null);

                return mExpenseLimit == NULL_EXPENSE ?
                        mPrimaryProject.getMemberExpenseLimit() : mExpenseLimit;
            }

            public void setExpenseLimit(double expenseLimit) {
                mExpenseLimit = expenseLimit;
            }

            public boolean withinLimit(double expenseAmount) {
                return expenseAmount <= getExpenseLimit();
            }

            public void setPrimaryProject(Project project) {
                mPrimaryProject = project;
            }
        }

        class Project {

            private double mMemberExpenseLimit;

            public Project(double memberExpenseLimit) {
                mMemberExpenseLimit = memberExpenseLimit;
            }

            public double getMemberExpenseLimit() {
                return mMemberExpenseLimit;
            }
        }
    }
}
