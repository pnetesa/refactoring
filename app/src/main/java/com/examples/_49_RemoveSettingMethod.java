package com.examples;

import static com.examples.util.Print.print;

public class _49_RemoveSettingMethod {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        public void show() {
            Account account = new Account("48021");
            print("Id = " + account.getId());
        }

        class Account {
            private String mId;

            public Account(String id) {
                setId("acc" + id);
            }

            private void setId(String id) {
                mId = id;
            }

            public String getId() {
                return mId;
            }
        }
    }

    static class After {

        public void show() {
            Account account = new Account("48021");
            print("Id = " + account.id);
        }

        class Account {

            public final String id;

            public Account(String id) {
                this.id = initializeId(id);
            }

            private String initializeId(String id) {
                return "acc" + id;
            }
        }
    }
}
