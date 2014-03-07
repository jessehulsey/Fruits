package agentlisting;

         


	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
import java.lang.Integer;
import java.util.Iterator;
	import java.util.Scanner;
	import java.util.Set;
	import java.util.SortedMap;
	import java.util.TreeMap;
	import java.util.TreeSet;

	/**
	 *
	 * @author SuperMurray
	 */
	public class AgentListing {

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args)
	            throws FileNotFoundException
	    {

	    // Prompt for the input file name
	        Scanner console = new Scanner(System.in);
	        System.out.print("Input file: ");
	        String inputFileName = console.next();
	        BufferedWriter pwfo = null;
	  try {
	        pwfo = new BufferedWriter(new FileWriter("C:\\users\\superman\\desktop\\agentReport.txt", true));
	        } catch (IOException e) {
	        }
	        PrintWriter pwo = new PrintWriter(pwfo);

	    //Construct property type treeSet
	        Set<String> propertyTypes = pTypes(inputFileName);

	     // Print property types from treeSet
	      for (String type : propertyTypes)

	         {
	          System.out.println(type);
	          pwo.println(type);
	     }
	       //pwo.flush();
	       //pwo.close();

	     //Construct agent ids and values treeSet
               Set<String> agentRpt = agentValue(inputFileName);

	    // Print agent Ids and values from key set
	        for (String tail: agentRpt)
	        {

	           {
	           System.out.println(tail);
	           pwo.println(tail);
	           }
	        }
	         pwo.flush();
	         pwo.close();
	        }

	     /**
	        Reads the input file.
	        @param inputFileName
	        @return the alphabetized property types in uppercase.
	     */
	     public static Set<String> pTypes(String inputFileName)
	        throws FileNotFoundException

	        //Construct a tree set to return property types
	      {
	        Set<String> type = new TreeSet<String>();
	        Scanner in = new Scanner(new File(inputFileName));

	        // Use delimiters to select specific chars for set
	        in.useDelimiter("[1234567890. ]");

	        while (in.hasNext())
	        {
	          type.add(in.next().toUpperCase());
	        }
	        in.close();

	        return type;
	      }


	     /**
	        Reads the input file.
	        @param inputFileName
	        @returns the Agent id's and corresponding property values.
	     */
	     public static Set<String> agentValue(String inputFileName)
	        throws FileNotFoundException
	     {

	         TreeSet<String> tail = new TreeSet<String>();
	         SortedMap<String, Number> agentValues = new TreeMap<String, Number>();
	         Scanner in = new Scanner(new File(inputFileName));
                 String line = inputFileName;

	       while (in.hasNextLine())
	       {
               try {
	         line = in.nextLine();
	         String[] fields = line.split("[\\s}]");
	         String agentId = (fields [3]);
	         Double pValue = Double.parseDouble(fields [2]);
                          
                 if (agentValues.containsKey(agentId))
	            {
	         pValue += agentValues.get(agentId).doubleValue();
	            }
                 agentValues.put(agentId, pValue);

	                       
              }catch  (Exception e) {
                                  }

               
               
               
               
	     // Create keyMap with all keys and values
	            Set<String> keySet = agentValues.keySet();
	            for (String key : keySet)
                    {
	            Number value = agentValues.get(key);
                    //System.out.println(key + ":" + value);
                    tail.add(key + ":" + value);
                    }
               }
	       return tail;
	       }
	}





