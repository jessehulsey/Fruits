/*
 * This application uses the fruits.txt file
 * It reads the information from the fruits.txt file
 * The fruits.txt file has the following format: personname, fruitname,fruitcount
 * The application uses a Map collection to store information
 * The application prints out a report on the total count for each fruit.
* This is my test. there are many like it, but this one is mine
 */
package fruits;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


/**
 *
 * @author Pubali Banerjee 10/15/2012
 */
public class Fruits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       
         //Declare variables for creaeting a Map Collections object
        //the key is the fruitname; the value is the count

       //let's use TreeMap so that key values are sorted
        
        Map<String, Integer> FruitList = new TreeMap<String, Integer>();

        //Prompt user for the input file : use fruits.txt
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the full path to your file: ");
        
        //add try catch block if file is not found
        try {
            String inputFileName = console.next();

            //Construct Scanner objects and variables used
            File inputFile = new File(inputFileName);
            Scanner in = new Scanner(inputFile);

            //Loop through file item by item
            
            //the file foramt is personname, fruitname, fruitcount
            while (in.hasNext()) 
            {
                String name = in.next();
                String fruitname = in.next();
                Integer fcount = Integer.parseInt(in.next());
               
            

                //add if record does not exist, else append to existing record
                if (FruitList.containsKey(fruitname)) {
                    FruitList.put(fruitname, FruitList.get(fruitname) + fcount);
                } 
                else 
                {
                    FruitList.put(fruitname, fcount);
                }

            }
            //Close the input file
            in.close();
           
        //catch block for bad file input
        } catch (FileNotFoundException exception) {
            System.out.println("File not found!");
            System.exit(1);
        }

        
        //now print everything in Map
        //we need to use a set to use an iterator
        Set s=FruitList.entrySet();

        //Move next key and value of Map by iterator
        Iterator it=s.iterator();

        while(it.hasNext())
        {
            // key=value separator this by Map.Entry to get key and value
            Map.Entry m =(Map.Entry)it.next();

            // getKey is used to get key of Map
            String key=(String)m.getKey();

            // getValue is used to get value of key in Map
            Integer value=(Integer)m.getValue();

            System.out.println("Fruit :"+key+"\tCount :"+value);
        }
    }
}