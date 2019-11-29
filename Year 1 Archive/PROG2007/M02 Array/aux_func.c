//
// Created by mason on 22/01/19.
//
#include <stdio.h>
#include <math.h>
void stupidfuckingprintfunction(int number[], int n);

//Sorts array inputs on the fly in ascending order.
void sortFunctionASN (int number[], int n) {

    int i, j, k;
    for (i = 0; i < n; i++) {
        for( j = i + 1; j < n; ++j) {
            if (number[i] > number[j]) {
                k = number[i];
                number[i] = number[j];
                number[j] = k;
            }
        }
//        printf("%d ", number[i]);
    }
    stupidfuckingprintfunction(number, n);
}

//Sorts array inputs on the fly in descending order.
void sortFunctionDSN (int number[], int n) {

    int i, j, k;
    for (i = 0; i < n; i++) {
        for( j = i + 1; j < n; ++j) {
            if (number[i] < number[j]) {
                k = number[i];
                number[i] = number[j];
                number[j] = k;
            }
        }
//        printf("%d ", number[i]);
    }
    stupidfuckingprintfunction(number, n);
}


//Calculates the average of all values in a given array, and returns (and prints!) the result
double avgArray(int number[], int n) {
    int i;
    double sum = 0;
    double avg;
    for(i = 0; i < n; i++) {
        sum = sum + number[i];
    }
    avg = sum / n;
    puts("\nAverage of array");
    printf("%lf ", avg);
    return avg;
}

//Calculates the Norm of all the values in a given array, and returns (and prints!) the result
double normArray(int number[], int n) {
    double squareValues = 0;
    double result = 0;
    for(int i = 0; i < n; i++) {
        squareValues += number[i] * number[i];
    }
    result = sqrt(squareValues);
    puts("\nNorm of array: ");
    printf("%lf", result);
    return result;
}

//Self explanatory
void stupidfuckingprintfunction(int number[], int n) {
    for (int i = 0; i < n; ++i) {
        printf("%d ", number[i]);
    }
}

