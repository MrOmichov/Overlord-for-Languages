package org.mromichov.overlordforlanguages.odm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileWork {
    private final File settingsFile;
    private final File settingsFileDirectory;
    private final Gson gson;

    private final Map<String, String> settings;
    private final TypeToken<Map<String, String>> mapType;

    public FileWork() {
        settingsFileDirectory = new File(System.getProperty("user.home") + "\\Local Settings\\ApplicationData\\Overlord-for-Languages");
        settingsFile = new File(System.getProperty("user.home") + "\\Local Settings\\ApplicationData\\Overlord-for-Languages" + "/settings.json");
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

        settings = new HashMap<>();
        mapType = new TypeToken<>(){};
    }
    public boolean isSettingsFileExists() {
        return settingsFile.exists();
    }

    public void createSettingsFile() {
        try {
            if (settingsFile.exists()) return;
            if (settingsFileDirectory.mkdir()) System.out.println("settingsFileDirectory.mkdir() success");
            if (settingsFile.createNewFile()) System.out.println("settingsFile.createNewFile() success");
            FileWriter writer = new FileWriter(settingsFile);
            settings.put("openedFile", "");

            writer.write(gson.toJson(settings));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getOpenedFileSetting() {
        try {
            return gson.fromJson(Files.readString(settingsFile.toPath()), mapType).get("openedFile");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private void setOpenedFileSetting(String pathname) {
        try {
            Map<String, String> settings = gson.fromJson(Files.readString(settingsFile.toPath()), mapType);
            settings.put("openedFile", pathname);
            FileWriter writer = new FileWriter(settingsFile);

            writer.write(gson.toJson(settings));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Language getLanguage() {
        String pathname = getOpenedFileSetting();
        String text;
        try {
            if (pathname.isEmpty()) return null;
            Path path = Paths.get(pathname);
            text = Files.readString(path);
            Language language = gson.fromJson(text, Language.class);
            setOpenedFileSetting(pathname);
            return language;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Language getLanguage(File file) {
        String text;
        try {
            String pathname = file.getAbsolutePath();
            Path path = Paths.get(pathname);

            text = Files.readString(path);
            Language language = gson.fromJson(text, Language.class);

            setOpenedFileSetting(pathname);
            return language;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setLanguage(Language language) {
        try {
            FileWriter writer = new FileWriter(getOpenedFileSetting());
            writer.write(gson.toJson(language));
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createNewLanguageFile(File newFile) {
        try {
            if (newFile.createNewFile()) System.out.println("newFile.createNewFile()) success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}