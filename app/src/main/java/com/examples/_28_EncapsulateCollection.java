package com.examples;

import junit.framework.Assert;

import java.util.HashSet;
import java.util.Set;

import static com.examples.util.Print.print;

public class _28_EncapsulateCollection {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        public void show() {
            Person kent = new Person();

            Set<Course> courses = new HashSet<Course>();
            courses.add(new Course("Smalltalk Programming", false));
            courses.add(new Course("Appreciating Single Malts", true));
            kent.setCourses(courses);

            Assert.assertEquals(2, kent.getCourses().size());

            Course refactoring = new Course("Refactoring", true);
            kent.getCourses().add(refactoring);
            kent.getCourses().add(new Course("Brutal Sarcasm", false));

            Assert.assertEquals(4, kent.getCourses().size());

            kent.getCourses().remove(refactoring);
            Assert.assertEquals(3, kent.getCourses().size());

            int count = 0;
            for (Course course : courses) {
                print("\"" + course + "\" ");
                if (course.isAdvanced()) {
                    count++;
                }
            }

            print("Advanced: " + count);
        }

        class Course {
            private String mName;
            private boolean mIsAdvanced;

            public Course(String name, boolean isAdvanced) {
                mName = name;
                mIsAdvanced = isAdvanced;
            }

            public boolean isAdvanced() {
                return mIsAdvanced;
            }

            @Override
            public String toString() {
                return mName;
            }
        }

        class Person {
            private Set<Course> mCourses;

            public Set<Course> getCourses() {
                return mCourses;
            }

            public void setCourses(Set<Course> courses) {
                mCourses = courses;
            }
        }
    }

    static class After {

        public void show() {
            Person kent = new Person();

            kent.addCourse(new Course("Smalltalk Programming", false));
            kent.addCourse(new Course("Appreciating Single Malts", true));

            Assert.assertEquals(2, kent.size());

            Course refactoring = new Course("Refactoring", true);
            kent.addCourse(refactoring);
            kent.addCourse(new Course("Brutal Sarcasm", false));

            Assert.assertEquals(4, kent.size());

            kent.removeCourse(refactoring);
            Assert.assertEquals(3, kent.size());

            print("Advanced: " + kent.numberOfAdvancedCourses());
        }

        class Course {

            private String mName;
            private boolean mIsAdvanced;

            public Course(String name, boolean isAdvanced) {
                mName = name;
                mIsAdvanced = isAdvanced;
            }

            public boolean isAdvanced() {
                return mIsAdvanced;
            }

            @Override
            public String toString() {
                return mName;
            }
        }

        class Person {
            private Set<Course> mCourses = new HashSet<Course>();

//            public Set<Course> getCourses() {
//                return Collections.unmodifiableSet(mCourses);
//            }

//            public void initializeCourses(Set<Course> courses) {
//                Assert.assertTrue(mCourses.isEmpty());
//                mCourses.addAll(courses);
//            }

            public void addCourse(Course value) {
                mCourses.add(value);
            }

            public void removeCourse(Course value) {
                mCourses.remove(value);
            }

            private int numberOfAdvancedCourses() {
                int count = 0;
                for (Course course : mCourses) {
                    print("\"" + course + "\" ");
                    if (course.isAdvanced()) {
                        count++;
                    }
                }
                return count;
            }

            private int size() {
                return mCourses.size();
            }
        }
    }
}
