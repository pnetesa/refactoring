package com.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.examples.util.Print.print;

public class _29_EncapsulateArray {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();

        print();

        After2 after2 = new After2();
        after2.show();
	}

    static class Before {

        private String[] mSkills;

        public void show() {
            String[] skills = { "Public speaking", "", "Typewriting", "Communications" };
            setSkills(skills);
            getSkills()[1] = "Refactoring";

            print(Arrays.toString(getSkills()));
        }

        public String[] getSkills() {
            return mSkills;
        }

        public void setSkills(String[] skills) {
            mSkills = skills;
        }
    }

    static class After {

        private String[] mSkills;

        public void show() {
            String[] skills = { "Public speaking", "", "Typewriting", "Communications" };
            setSkills(skills);
            setSkill(1, "Refactoring");

            print(Arrays.toString(getSkills()));
        }

        public void setSkill(int index, String newSkill) {
            mSkills[index] = newSkill;
        }

        public String[] getSkills() {
            String[] result = new String[mSkills.length];
            System.arraycopy(mSkills, 0, result, 0, mSkills.length);
            return result;
        }

        public void setSkills(String[] skills) {
            mSkills = new String[skills.length];

            for (int i = 0; i < skills.length; i++) {
                setSkill(i, skills[i]);
            }
        }
    }

    static class After2 {

        private List<String> mSkills = new ArrayList<String>();

        public void show() {
            String[] skills = { "Public speaking", "", "Typewriting", "Communications" };
            setSkills(skills);
            setSkill(1, "Refactoring");

            print(Arrays.toString(getSkills()));
        }

        public void setSkill(int index, String newSkill) {
            mSkills.set(index, newSkill);
        }

        public String[] getSkills() {
            return mSkills.toArray(new String[0]);
        }

        public void setSkills(String[] skills) {
            mSkills = new ArrayList<String>(Arrays.asList(skills));
        }
    }
}
