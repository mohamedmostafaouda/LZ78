package com.company;

import java.util.Vector;

public class Decompression {

    private Vector table = new Vector();

    private String inputString;

    public void set(String stringInput) {

        inputString = stringInput;
    }

    private boolean charFound(String x) {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).equals(x)) return true;
        }
        return false;
    }

    public String deCompress() {

        table = new Vector();

        int index = 0;

        String outPut = "";

        String subs = inputString;

        int size = inputString.length();

        table.add("NULL");

        while (index < size) {

            subs = subs.substring(index, size);

            index = 0;

            size = subs.length();

            int commaIndex = subs.indexOf(',');

            int closingTag = subs.indexOf('>');

            int tableIndex = Integer.parseInt(subs.substring(index + 1, commaIndex));

            String nextChar = subs.substring(commaIndex + 1, closingTag);

            String tableData = (String) table.get(tableIndex);

            if (tableIndex == 0) {

                if (!charFound(nextChar)) {

                    table.add(nextChar);

                    outPut += nextChar;
                } else {
                    outPut += nextChar;
                }

            } else {

                if (nextChar.equals("NULL")) {

                    outPut += tableData;

                } else {

                    outPut += tableData;

                    outPut += nextChar;

                    table.add(tableData + nextChar);
                }


            }

            index = (closingTag + 1);
        }

        return outPut;
    }

    public Vector tableOut() {

        deCompress();

        return table;
    }

    public int size() {

        return deCompress().length() * 8;
    }



}
