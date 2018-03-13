package ru.egor.sem.korus.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ResourceReader {

    public static List<String> readLines(String fileName) {
        List<String> lines = new ArrayList<>();
        File resFile = new File(ResourceReader.class.getClassLoader().getResource(fileName).getFile());
        try {
            lines = FileUtils.readLines(resFile, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
