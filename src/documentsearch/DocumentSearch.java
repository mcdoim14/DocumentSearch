package documentsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ian
 */
public class DocumentSearch {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int searchType;
        String term;
        
        TermSearch myTermSearcher = new TermSearch();
        
        try (Scanner reader = new Scanner(System.in)) {
            FileManager myFileManager = new FileManager();
            myFileManager.setDirectory("TestFiles");
            File[] fileList = myFileManager.getFileList();
            
            //Prompt for the term to be searched
            System.out.println("Enter the search term:");
            term = reader.nextLine();
            
            //While no term is entered, prompt again for a term
            while(term.isEmpty()) {
                System.out.println("Invalid input.\n");
                System.out.println("Enter the search term:");
                term = reader.nextLine();
            }

            //Prompt for the search type
            System.out.println("Enter the search type:\n"
                    + "1. Simple String Search\n"
                    + "2. Regular Expression Search\n"
                    + "3. Preprocessing with Indexing");
            searchType = reader.nextInt();
            
            //While an invalid search type is entered, prompt again for search type
            while(searchType < 1 || searchType > 3 ) {
                System.out.println("Invalid input.\n");
                System.out.println("Enter the search type:\n"
                        + "1. Simple Match\n"
                        + "2. Regular Expression\n"
                        + "3. Indexed");
                searchType = reader.nextInt();
            }
            myTermSearcher.setSearchType(searchType);
            myTermSearcher.setSearchTerm(term);
            System.out.println("You chose the term: " + term + ", and the search type " + searchType + ".");
            myTermSearcher.performSearch(fileList);
        }
        catch(Exception e){
        System.out.println (e.toString());
        System.out.println("Could not find the test files.");
    }
        
    }    
}
