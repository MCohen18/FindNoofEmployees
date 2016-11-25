/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Michelle
 */
public class FindNoofEmployees {

  /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    List<Employee> employeeList = new ArrayList();
     List<Employee> empList = new ArrayList();
     
    private int counter = 0;
    
    //logic is to count the number of lines in the file
    //you will tell it the number of lines
    private int count(int numLines, String managerName) throws FileNotFoundException, IOException{
   
        
     //what's the exit condition
     if(numLines==0){
         System.out.println("This person manages " + counter + " people in one branch \n");
         return 0;
     }
     
     // int counter = 0;
    
            for (Employee e : empList) {
            if(e.getManager()==null){
                      //counter=counter+0;
        }    
           else if(e.getManager().contains(managerName)){
               managerName = e.getName();
                counter++;
            }            
            }
                  
     return count((numLines-1), managerName);
    }
    
    private List<Employee> array() throws FileNotFoundException, IOException{
        FileReader fileInst = new FileReader("C:\\Users\\Michelle\\Documents\\NetBeansProjects\\Project1\\src\\project1\\EmployeeManager");
        BufferedReader br = new BufferedReader(fileInst);

        String line = br.readLine();
        //System.out.println(line);
        Employee empObj = new Employee();
       

        while ((line = br.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(line, "\t");

            empObj.setName(st.nextToken());

            if (st.hasMoreTokens()) {
                empObj.setManager(st.nextToken());

            } else if (!st.hasMoreTokens()) {
                //    if(!st.hasMoreElements()){

                empObj.setName(line);
                empObj.setManager(null);

            }

            empList.add(empObj);
            empObj = new Employee();
            

        }//end while
    
        return empList;
}
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
      FileReader fileInst = new FileReader("C:\\Users\\Michelle\\Documents\\NetBeansProjects\\Project1\\src\\project1\\EmployeeManager");
        BufferedReader br = new BufferedReader(fileInst);
        br.readLine();
        
        int lineCount = 0;
        
        while(br.readLine()!=null){
            lineCount++;
        }
        
        
    JDialog.setDefaultLookAndFeelDecorated(false);
    Object[] selectionValues = { "Bob", "Joseph", "Nathan", "Sally", "Sam", "Veronica" };
    String initialSelection = "Bob";
    Object selection = JOptionPane.showInputDialog(null, "Which manager would you like to count for?",
        "Select...", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
    
    String managerName = selection.toString();
    
    //    System.out.println(lineCount);
        
    FindNoofEmployees proj1 = new FindNoofEmployees();
    proj1.array();
     proj1.count(lineCount, managerName);
     
        
        
    }//end main
}//end class

