package com.examples;

import java.util.HashMap;
import java.util.Map;

import static com.examples.util.Print.print;

public class _21_ChangeReferenceToValue {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {
        public void show() {
            Currency usd = Currency.get("USD");
            print(usd.equals(Currency.get("USD")));
        }

        static class Currency {

            private static Map<String, Currency> mInstances = new HashMap<String, Currency>();
            private String mCode;
            
            public static Currency get(String code) {

                if (!mInstances.containsKey(code)) {
                    mInstances.put(code, new Currency(code));
                }

                return mInstances.get(code);
            }

            private Currency(String code) {
                mCode = code;
            }

            public String getCode() {
                return mCode;
            }
        }
    }

    static class After {
        public void show() {
            print(new Currency("USD").equals(new Currency("USD")));
        }

        static class Currency {

            private static Map<String, Currency> mInstances = new HashMap<String, Currency>();
            private String mCode;

            public Currency(String code) {
                mCode = code;
            }

            public String getCode() {
                return mCode;
            }

            @Override
            public boolean equals(Object o) {
                if (!(o instanceof Currency)) {
                    return false;
                }

                Currency other = (Currency) o;
                return mCode.equals(other.mCode);

            }

            @Override
            public int hashCode() {
                return mCode.hashCode();
            }
        }
    }
}
