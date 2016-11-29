package com.ironyard;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//import static com.ironyard.Country.saveCountry;

public class Main {

    //<KEY: String (single letter), VALUE: (list of countries)>
    public static HashMap< String, ArrayList<Country> > countryHashMap = new HashMap<>();
    public static File f = new File("countries.txt"); //SCAN countries.txt for existing data

    public static void main(String[] args) throws Exception {
        scanFile();
        getLetter();


    }//end main()

    public static void scanFile() throws Exception{
        //SCAN TXT FILE TO CREATE HASHMAP
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();//read each line
            String[]columns = line.split("\\|");//split each line into array
            Country countries = new Country (columns[0], columns[1]); //use array to create a new Country

            String firstLetter = countries.name.substring(0,1);//create String firstLetter:  substring of String name (from Country class)

            //if hashmap contains the first letter as a key ...
            if(countryHashMap.containsKey(firstLetter)){

                //ArrayList<Country> temp = get arrayList out of hashmap using the first letter as a key
                ArrayList<Country> temp = countryHashMap.get(firstLetter);

                temp.add(countries);  //add our new Country to that arrayList
            }
            else {  //else hashmap does not contain the first letter as a key
                ArrayList<Country> newLetter = new ArrayList<>(); //create a new array list
                newLetter.add(countries);//add our new Country to that arrayList
                countryHashMap.put(firstLetter, newLetter);//put the arrayList into the hashmap using the first letter as a key
            }
        }//end while loop

    }//end scanFile()

    public static String getLetter() throws Exception {
        //TAKE IN USER INPUT
        String letter;
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter a letter to see the countries that start with that letter.");
        letter = scanner.nextLine();

        //IF THEY HAVEN'T ENTERED A SINGLE LETTER
        if (letter.isEmpty()) {
            throw new Exception("ERROR");
        }
        else{

            File X = new File(letter + "_countries.txt");
            FileWriter fw = new FileWriter(X);

            int i = 0;

            //get arrayList out of the hashmap using the "user entered letter" as the key
            for (Country newLetter : countryHashMap.get(letter)) {

                if (newLetter.name == letter){
                    System.out.printf("%s %s", letter, newLetter.abb);
                }
                i++;//iterate through arrayLIst

                //write out each country to a new line in our file
                Country.saveCountry("X");
                //fw.append(newLetter.name + "\n");
                System.out.println(newLetter.name + " | " + newLetter.abb); //verify country abbreviation and name
            } //end for loop
            fw.close();//close the file

        }//end if else statement
        return letter;
    }//end getLetter

}//end class Main
