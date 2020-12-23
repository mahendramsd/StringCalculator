package com.example.calculator;

public class StringCalculator {

    /**
     * Add numbers
     * @param number
     * @return
     */
    public static int add(String number) {
        if (number.equals("")) {
            return 0;
        } else {
            String delimiter = ",";
            if (number.matches("//(.*)\n(.*)")) {
                delimiter = Character.toString(number.charAt(2));
                number = number.substring(4);
            }

            String nums[] = numberSplit(number, delimiter + "|\n");
            return sum(nums);
        }
    }

    /**
     * Number split
     *
     * @param nums
     * @param delimiter
     * @return
     */
    private static String[] numberSplit(String nums, String delimiter) {
        return nums.split(delimiter);
    }

    /**
     * @param numbers
     * @return
     */
    private static int sum(String[] numbers) {
        int sum = 0;
        String negativeNum = "";
        for (String num : numbers) {
            if (parseInt(num) < 0) {
                if (negativeNum.equals("")) {
                    negativeNum = num;
                } else {
                    negativeNum += ("," + num);
                }
            }
            if (parseInt(num) < 1000) {
                sum += parseInt(num);
            }

            if (!negativeNum.equals("")) {
                throw new IllegalArgumentException("negatives not allowed");
            }

        }
        return sum;
    }

    /**
     * String parse to int
     *
     * @param number
     * @return
     */
    private static int parseInt(String number) {
        return Integer.parseInt(number);
    }
}
