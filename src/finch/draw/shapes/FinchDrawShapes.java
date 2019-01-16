/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finch.draw.shapes;
//import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.io.*;
import java.util.Timer;
import java.math.*;
import java.text.DecimalFormat;
/**
 *
 * @author space_000
 */


public class FinchDrawShapes extends LogData {
    //private static Finch myf = new Finch();
    
    private Timer timer = new Timer();
    private processingFrame pF = new processingFrame();
    private boolean sizesWork;
    private int xTriangle, yTriangle, zTriangle;
    private double[] triangleAngles = new double[3]; 
    private int xRectangle, yRectangle;
    
    private int centimeterestoTraveled;
    private int centimeterstTraveled;
    
    Timer time = new Timer();
    FinchDrawShapes(){
        
    }
    public static void main(String[] args) {
        new drawShapeWindow().setVisible(true);
    }
    //Function will draw a triangle sides between 20cm and 80cm
    public void drawTriangle(int x, int y, int z, TriangleWindow win) throws IOException{
        boolean drawing = false;
        this.sizesWork = checkTriangle(x, y, z);
        //System.out.println(sizesWork);
        if(this.sizesWork){
            anglesOfTriangle(x,y,z);
            LogData(x,y,z,triangleAngles);
            win.setVisible(false);
            pF.setVisible(true);
            drawing = true;
            pF.tillShapeDrawn(centimeterestoTraveled);
            /*while(drawing){
                
            }*/
            pF.setVisible(false);
            new drawShapeWindow().setVisible(true);
        }else{
            System.out.println("Cannot Create Triangle");
            win.setTitle("Cannot Create Triangle");
        }
    }
    //Function will draw a Rectangle sides between 20cm and 80cm
    public void drawRectangle(int x, int y, RectangleWindow win) throws IOException{
        boolean drawing = false;
        LogData(x,y);
        win.setVisible(false);
        pF.setVisible(true);
        pF.tillShapeDrawn(centimeterestoTraveled);
        /*while(drawing){
            
        }*/
        pF.setVisible(false);
        new drawShapeWindow().setVisible(true);
    }
    public boolean checkTriangle(int x, int y, int z){
        boolean sizesWork = true;
        if(x + y <= z){
            sizesWork = false;
        }
        if(x + z <= y){
            sizesWork = false;
        }
        if(y + z <= x){
            sizesWork = false;
        }
        return sizesWork;
    }
    public void anglesOfTriangle(int x, int y, int z){
        //double[] triangleAngles = new double[3];
        double tempValue;
        double p = (x + y + z) / 2; // Perimeter
        DecimalFormat  df = new DecimalFormat("#.00");
        
        //double area = Math.sqrt(p*(p - x)*(p - y)*(p - z));
        //Working out angle x.
        tempValue = (Math.pow(y, 2) + Math.pow(z, 2) - Math.pow(x, 2)) / (2 * y * z);
        tempValue = Math.toDegrees(Math.acos(tempValue));
        this.triangleAngles[0] = tempValue;
        
        //Working out angle y
        tempValue = (Math.pow(x, 2) + Math.pow(z, 2) - Math.pow(y, 2)) / (2 * x * z);
        tempValue = Math.toDegrees(Math.acos(tempValue));
        this.triangleAngles[1] = tempValue;
        
        //Working out angle z.
        tempValue = (Math.pow(y,2) + Math.pow(x, 2) - Math.pow(z, 2)) / (2 * x * y);
        tempValue = Math.toDegrees(Math.acos(tempValue));
        this.triangleAngles[2] = tempValue;
        
        //All Angles will be outputted to a 2 d.p
        //System.out.println("Angles: " + "X: "+  df.format(triangleAngles[0]) +" Y: "+ df.format(triangleAngles[1]) +" Z: " +df.format(triangleAngles[2]));
        
    }
    //For Rectangle

    public void programQuit(){
        
    }
    public double[] getTriangleAngles(){
        return this.triangleAngles;
    } 
    public void setSizesWork(boolean newsizesWork){
        this.sizesWork = newsizesWork;
    }
    public boolean getSizesWork(){
        return this.sizesWork;
    }
}
