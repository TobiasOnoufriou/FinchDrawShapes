/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finch.draw.shapes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author space_000
 */
public class LogData {
    private PrintWriter out;
    private Scanner file;
    
    LogData(){
        
    }
    public void LogData(int x, int y) throws IOException{
        out = new PrintWriter(new BufferedWriter(new FileWriter("\\shapeLog.txt", true)));
        int overallShapeSize = x + y; 
        out.println("Rectangle " + x + " cm, " + y + " cm " + "Shape Size: " + overallShapeSize + " cm");
        out.flush();
        out.close();
    }
    public void LogData(int x, int y, int z, double[] angles) throws IOException{
        DecimalFormat  df = new DecimalFormat("#.00");
        int overallShapeSize = x + y + z; 
        out = new PrintWriter(new BufferedWriter(new FileWriter("\\shapeLog.txt", true)));
        out.println("Triangle " + x + " cm, " +  y + " cm, " + z + " cm " + "( " +"angle x: " + df.format(angles[0]) + " angle y: " + df.format(angles[1])+ " angle z: " + df.format(angles[2]) + " )" + " Shape Size: " + overallShapeSize + " cm");
        out.flush();
        out.close(); 
    }
    public String getMostDrawnShape() throws IOException{
        String mostCommon;
        
        int numOfTriangles = 0;
        int numOfRectangles = 0;
        
        File newFile = new File("\\shapeLog.txt");
        file = new Scanner(newFile);
        while(file.hasNextLine()){
            String currentLine = file.nextLine();
            if(currentLine.contains("Rectangle")){
                numOfRectangles++;
            }else if(currentLine.contains("Triangle")){
                numOfTriangles++;
            }else{
                //Nothing was drawn.
            }
        }
        
        if(numOfRectangles >= numOfTriangles){
            mostCommon = " Rectangle with " + numOfRectangles + " Rectangles Drawn";
        }else if(numOfTriangles >= numOfRectangles){
            mostCommon = " Traingle with " + numOfTriangles + " Triangles Drawn";
        }else{
            mostCommon = "No Shapes Drawn";
        }
        return mostCommon;
    }
    public String getLargestShape() throws IOException{
        int largestShapeSize = 0;
        int getIndex = 0;
        String largestShape = "";
        ArrayList<Integer> biggestShapeList = new ArrayList();
        
        file = new Scanner(new File("\\shapeLog.txt"));
        
        while(file.hasNextLine()){
            String line = file.nextLine();
            String[] lineArray = line.split("\\s+");
            biggestShapeList.add(Integer.parseInt(lineArray[lineArray.length - 2]));
        }
        
        //Really inefficient but oh well.
        for(int i = 0; i < biggestShapeList.size(); i++){
            if(biggestShapeList.get(i) > largestShapeSize){
                largestShapeSize = biggestShapeList.get(i);
                getIndex = i;
            }
        }
        try{
            largestShape = Files.readAllLines(Paths.get("\\shapeLog.txt")).get(getIndex);
        }catch(IndexOutOfBoundsException e){
            largestShape = "noData";
        }
        
        return largestShape;
    }
    public String getoutputAllDrawnShapes() throws IOException{
        String output = "";
        out = new PrintWriter(new BufferedWriter(new FileWriter("\\shapeLog.txt", true)));
        file = new Scanner("\\shapeLog.txt");
        output = new String(Files.readAllBytes(Paths.get("\\shapeLog.txt")));
        return output;
    }
}
