import java.util.Arrays;
import java.util.Random;

public class EstimatePI{
    
    
    public static double[][] createCoordinates(int numPoints){
        // This method returns a double array with the first array being the X-coordinates and the second array being the Y-coordinates
        // It uses the Random to Generate a Pseudorandom number between -1 and 1;
        double max = 1;
        double min = -1;
        Random random = new Random();
        double[][] coordinates = new double[2][numPoints];
        for (int i = 0; i < 2; i++){
            for(int j = 0; j < numPoints; j++){
                coordinates[i][j] = min + ((max-min) * random.nextDouble());
            }
        }
        return coordinates;
    }

    
    public static double DistanceFromCentre(double xvalue, double yvalue){
        // This method calculates the distance from the centre of the circle which is positioned at the coordinate (0,0)
        double distance = Math.sqrt(Math.pow(xvalue, 2) + Math.pow(yvalue, 2));
        return distance;
    }

    
    public static double calculatePI(int numPoints){
        // This method gives an estimate of PI by using createCoordinates and DistanceFromCentre
        // It first creates "numPoints" many coordinates and then checks if the point is in or out of the circle, if it is inside its iterates "counter"
        // The higher "numPoints" is the more accurate the estimation of PI will be
        double[][] points = createCoordinates(numPoints);
        int counter = 0;
        for(int j = 0; j < numPoints; j++){
            if (DistanceFromCentre(points[0][j], points[1][j]) <= 1){
                counter++;
            } 
        }
        double PercentInCircle = (double)counter / (double)numPoints;
        return PercentInCircle * 4;
    }

    public static void main(String [] args){
        System.out.println(calculatePI(10000000));
    }
}