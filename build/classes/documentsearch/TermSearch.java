package documentsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ian
 */
public class TermSearch {
    private int searchType;
    private String term;
    
    public void performSearch(File[] fileList) throws FileNotFoundException, IOException{
        switch(searchType){
            case 1:
                stringMatch(term, fileList);
                break; 
            case 2:
                regexSearch(term, fileList);
                break;
            case 3:
                indexSearch();
                break;
        }
    }
    
    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }
    
    public void setSearchTerm(String term) {
        this.term = term;
    }
    
    private void stringMatch(String term, File[] fileList) throws FileNotFoundException{
        int count = 0;
        for(File file: fileList){
            Scanner scanner = new Scanner(file);
            
            while(scanner.hasNext()) {
                String temp = scanner.next();
                if(temp.equals(term)) {
                    count++;
                }
            }
            System.out.println(file.getName() + ": " + term + " showed up " + count + " times.");
            count = 0;
        }
    }
    
    private void regexSearch(String term, File[] fileList) throws FileNotFoundException, IOException {
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(term) + "\\b");
        int count = 0;
        
        for(File file: fileList){
            String str = FileUtils.readFileToString(file);
            Matcher matcher = pattern.matcher(str);

            while (matcher.find()) {
                count++;
            }
            
            System.out.println(file.getName() + ": " + term + " showed up " + count + " times.");
            count = 0;
        }
    }
    
    private void indexSearch() {
        System.out.println("Index Search.");
    }
    
}
