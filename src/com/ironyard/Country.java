package com.ironyard;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by dlocke on 11/28/16.
 */
public class Country {

    //variables
    public String name;
    public String abb;

    //constructor holds country name and abbreviation
    public Country(String name, String abb) {
        this.name = name;
        this.abb = abb;
    }

    public Country() {

    }

    @Override
    public String toString(){
        return this.getName();
    }

    public static void saveCountry(String letter) throws Exception {
        JsonSerializer s = new JsonSerializer();
        String json = s.include("*").serialize(Main.countryHashMap.get(letter));

        File f = new File("country.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbb() {
        return abb;
    }

    public void setAbb(String abb) {
        this.abb = abb;
    }
}
