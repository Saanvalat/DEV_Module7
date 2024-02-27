package com.feature.prefs;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Prefs {
    public static final String DB_URL = "dbURL";
    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    private Map<String, Object> prefs = new HashMap<>();

    public Prefs(){
        this(DEFAULT_PREFS_FILENAME);
    }

    public Prefs(String fileName){
        try {
            String json = Files.readAllLines(Paths.get(fileName)).stream().collect(Collectors.joining("\n"));
        prefs = new Gson ().fromJson(json, Map.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getString(String key){
        return getPref(key).toString();
    }
    public Object getPref(String key){
        return prefs.get(key);
    }


}

