package io.models;

import io.interfaces.Writer;

public class OutputWriter implements Writer {

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}
