package com.company;

import java.util.Vector;
import java.util.Arrays;
import java.util.*;

@SuppressWarnings("unused")

class Compression{
    private String input;
    private Vector<String> table = new Vector<String>();
    private String output = "";
    private Vector<Integer> tagIndex = new Vector<Integer>();
    private Vector<String> tagSymbol = new Vector<String>();

    public void setInput(String input) {
        this.input = input;
        Compress();
    }

    public void Compress() {
        table.add("Null");

        String tmp = "";

        int tmpI = 0;
        boolean end = false;
        for(int i = 0 ; i < input.length() ; i++){

            tmp += input.charAt(i);

            while(table.contains(tmp)){

                tmpI = table.indexOf(tmp);
                i++;
                if(i == input.length())
                {
                    tagIndex.add(tmpI);
                    tagSymbol.add("NULL");
                    end = true;
                    break;
                }
                else {
                    tmp += input.charAt(i);
                }
            }
            if(!end) {
                tagIndex.add(tmpI);
                String symbol = "";
                symbol += input.charAt(i);
                tagSymbol.add(symbol);
                symbol = "";
                table.add(tmp);
            }
            tmp = "";
        }

    }

    public Integer getSize(){
        return tagSymbol.size() * 12;
    }

    public String getOutput()
    {
        for(int i = 0 ; i < tagSymbol.size() ; i++)
        {
            output += '<';
            output += tagIndex.get(i);
            output += ',';
            output += tagSymbol.get(i);
            output += '>';
        }
        return output;
    }

    public Vector<String> getTable()
    {
        return table;
    }



}
