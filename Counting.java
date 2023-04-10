// Mehrad Hajati
// This class is meant to make calculating probability of a certain event happening a number of times easier
// It can also calculate the probability of a certain event happening atmost or atleast a number of times

public class Counting{

    public static int combinations(int n, int r){
        if ((0 >= n) || (0 >= r) || (r > n)){
            return -1;
        }
        else{
            int output = factorial(n)/ (factorial(r) * (factorial(n-r)));
            return output;
        }
    }

    public static int permutations(int n, int r){
        if ((0 >= n) || (0 >= r) || (r > n)){
            return -1;
        }
        else{
            int output = factorial(n) / (factorial(n-r));
            return output;
        }
    }

    public static double atmostK(int TotalEvents, int K, double probability){
        // This method uses the combinations method to calculate the probability of an event happening atmost K times
        // This IF_ELSE statment is designed to make it the method more efficient as it can sometimes be easier to calculate the probability of undesired events and do 1 - undesired
        if (TotalEvents/2 >= K){
            double output = 0;
            for(int i = 1; i <= K; i++){
                output += exactlyK(TotalEvents, i, probability);
            }
            return output;
        }
        else{
            double output = 1;
            for(int i = TotalEvents; i > K; i--){
                output -= exactlyK(TotalEvents, i, probability);
            }
            return output;
        }
    }

    public static double atleastK(int TotalEvents, int K, double probability){
        // This method uses the combinations method to calculate the probability of an event happening atleast K times
        // This IF_ELSE statment is designed to make it the method more efficient as it can sometimes be easier to calculate the probability of undesired events and do 1 - undesired
        if(TotalEvents/2 <= K){
            double output = 0;
            for (int i = TotalEvents; i >= K; i--){
                output += exactlyK(TotalEvents, i, probability);
            }
            return output;
        }
        else{
            double output = 1;
            for (int i = 1; i < K; i++){
                output -= exactlyK(TotalEvents, i, probability);
            }
            return output;
        }
    }

    public static double exactlyK(int TotalEvents, int K, double probability){
        // This method uses the combinations method to calculate the probability of an event happening exactly K times
        double output = combinations(TotalEvents, K) * Math.pow(probability, K) * Math.pow(1-probability, TotalEvents-K);
        return output;
    }

    public static int factorial(int n){
        int output = 1;
        if (0 > n){
            return -1;
        }
        else{
            if (n == 0){
                return output;
            }
            else{
                for (int i = 2; i <= n; i++){
                    output = output * i;
                }
                return output;
            }
        }
    }

    public static void main(String [] args){
        double num = (double) 1 / (double) 6;
        System.out.println(num);
        System.out.println(atleastK(6, 1, 0.16666666666666666666));
    }
}