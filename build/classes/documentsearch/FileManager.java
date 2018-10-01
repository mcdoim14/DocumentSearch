
package documentsearch;

import java.io.File;

/**
 *
 * @author ian
 */
public class FileManager {
    private File directory;
    private File[] listOfFiles;
    
    public void setDirectory(String path){
        if(path != null){
            directory = new File(path);
            setFilesList();
        }
    }
    
    private void setFilesList(){
            listOfFiles = directory.listFiles();
    }
    
    public File[] getFileList() {
        return listOfFiles;
    }
    
    public void printFileList(){        
        for(File file : listOfFiles){
            if(file.isFile()){
            System.out.println(file.getName());
        }
}
        
    }
            
}
