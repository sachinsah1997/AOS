import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class CompareTextFile
{   
    public static void main(String[] args) throws IOException{   

        // retrieve the both file and store in buffer for future operatiob
        BufferedReader reader1 = new BufferedReader(new FileReader("/home/sachinsah/check/text1.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("/home/sachinsah/check/text2.txt"));
         
        // Read the lines of file1 into line1 and lines of file2 into line2.
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
         
        boolean areEqual = true;
         
        int lineNum = 1;
        

         // Keep reading the lines of file1 into line1 and lines of file2 into line2 till the end of the files.  If it returns true then continue with the loop.  
        while (line1 != null || line2 != null){
          
            //If any one of line1 or line2 is null, then assign false to areEqual and break the loop. If both, line1 and line2, are not null then compare them using equalsIgnoreCase() method.
            //Otherwise break the loop and assign false to areEqual.
            if(line1 == null || line2 == null){
                areEqual = false;
                break;
            }
            else if(! line1.equalsIgnoreCase(line2)){
                areEqual = false;
                break;
            }
             
            line1 = reader1.readLine();
            line2 = reader2.readLine();
            
            lineNum++;
        }
         
        if(areEqual){
            System.out.println("Two files have same content.");
        }
        else{
            System.out.println("Two files have different content. They differ at line "+lineNum +"\n"); 
            System.out.println("File1 has "+line1+" and File2 has "+line2+" at line "+lineNum);
        }
         
        reader1.close();
        reader2.close();
    }
}