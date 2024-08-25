package org.mromichov.overlordforlanguages.odm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWork {
    private String readJSON() {
        Gson gson = new Gson();
        return "";
    }


    public static void main(String[] args) throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String text;
        try {
            File file = new File("src/main/java/org/mromichov/overlordforlanguages", "test.json");
            String absPath = file.getAbsolutePath();
            Path path = Paths.get(absPath);
            text = Files.readString(path);
            Language language = gson.fromJson(text, Language.class);
            language.dictionary.values().forEach(word -> System.out.print(word.cases));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
