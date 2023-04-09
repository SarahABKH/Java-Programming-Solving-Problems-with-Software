import edu.duke.*;
import java.io.File;
public class PerimeterAssignmentRunner {
public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int num=0;
        for(Point currPt:s.getPoints()){
        num++;
        }
        
    
        return num;
    }
   
    
   public double getAverageLength(Shape s) {
        double length = getPerimeter(s);
        int num= getNumPoints(s);
        double avg=length/num;
        return avg;
    }

    public double getLargestSide(Shape s) {
        Point prevPt = s.getLastPoint();
        double LargestDistance=0;
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if( currDist>LargestDistance){
                LargestDistance =currDist;
          
            }
            prevPt = currPt;
        }
        return LargestDistance;
    }

    public double getLargestX(Shape s) {
        double largestX=0.0;
        for (Point currPt : s.getPoints()) {
            if(currPt.getX()>largestX)
            {
               largestX=currPt.getX();
            
            }
        }
        return largestX;
    }

    
   public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr=new DirectoryResource();
        double largestPerimeter=0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length =getPerimeter(s);
            if(length>largestPerimeter)
            {
                largestPerimeter=length;
            }
        }
          
        return largestPerimeter;
    }

   public String getFileWithLargestPerimeter() {
        // Put code 
        File temp = null;    // replace this code
        DirectoryResource dr=new DirectoryResource();
        double largestPerimeter=0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length =getPerimeter(s);
            if(length>largestPerimeter)
            {
                temp=f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length =getPerimeter (s);
        System.out.println("Perimeter = " + length);
        int num= getNumPoints(s);
        System.out.println("Num of Points = " + num);
        double avg=getAverageLength(s);
        System.out.println("Average Length= "+ avg);
        double largest=getLargestSide(s);
        System.out.println("Largest Side= "+ largest);
        double largestx=getLargestX(s);
        System.out.println("Largest X= "+ largestx);
    }
    
    public void testPerimeterMultipleFiles() {
        double largest = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter of these files= "+largest);
        
    }

   public void testFileWithLargestPerimeter() {
        String filename=getFileWithLargestPerimeter();
        System.out.println("File with largest Perimeter "+filename);
        
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}

    

