#Mehrad Hajati, 2/12/2021
# This program is meant to take an input of an array and then performs a Discrete Fourier Transform on it and gives the output
import math
import cmath

# This method is just designed to take in an input array
def Input_array():
    answer = input("Enter the entries of your input array: ")
    answer = answer.split()
    length = len(answer)
    i = 0
    arr = []
    while (i < length):
        arr.append(int(answer[i]))
        i=i+1
    return arr

# This method takes in three integers k, n, N and gives back a complex number in the form of an exponent
# It is designed to help us calculate each complex number
def Calc_complex_part(k, n, N):
    exponent = -2j * math.pi * k * (n/N)
    return cmath.exp(exponent)
    
# This method takes in an array (arr) and an integer k and gives an output of a single entry of X[k]
# That entry will be placed in the position of k in X[k]
def Calc_each_entry(arr, k):
    N = len(arr)
    sum = 0
    index = 0
    while(index < N):
        # Use Calc_complex_part() method to calculate the complex part of that entry and then add them all up
        sum = sum + (arr[index] * Calc_complex_part(k, index, N))
        index += 1
    return sum/N

# This method is designed to round a complex number to 5 decimal places for readibility, it round both the real and imaginary part
def round_complex(x):
    return complex(round(x.real, 5), round(x.imag, 5))
        
        
        
# Here we use the Input_array() method to get an array from the user
original = Input_array()
output = []
index = 0
N = len(original)
# Now a while loop for each entry of X[k], we know that X[k] and x[n] will have the same size
while(index < N):
    # Use the append method to add to the end of X[k]
    # we also use the Calc_each_entry() method here to calculate each entry for the given x[n] (input array) and a given k (index)
    output.append(round_complex(Calc_each_entry(original, index)))
    index += 1
print(output)


