package com.examples;

import static com.examples.util.Print.print;

public class _05_IntroduceExplainingVariable {

	public static void main(String[] args) {

        Before before = new Before();
        before.show();

        print();

        After after = new After();
        after.show();
	}

    static class Before {

        public void show() {
            String platform = "Mac OS X Mavericks 10.9";
            String browser = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.3; Trident/7.0)";
            int resize = 1234;

            if (platform.toUpperCase().indexOf("MAC") > -1 &&
                    browser.toUpperCase().indexOf("IE") > -1 &&
                    wasInitialized() && resize > 0) {
                print("Yes!");
            }
        }

        private boolean wasInitialized() {
            return true;
        }
    }

    static class After {

        public void show() {
            String platform = "Mac OS X Mavericks 10.9";
            String browser = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.3; Trident/7.0)";
            int resize = 1234;

            final boolean isMacOs = platform.toUpperCase().indexOf("MAC") > -1;
            final boolean isIeBrowser = browser.toUpperCase().indexOf("IE") > -1;
            final boolean wasResized = resize > 0;
            if (isMacOs && isIeBrowser && wasInitialized() && wasResized) {
                print("Yes!");
            }
        }

        private boolean wasInitialized() {
            return true;
        }
    }
}
