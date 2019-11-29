#include <stdio.h>
#include <stdlib.h>
#include <math.h>


int main() {
    int Height = 0; // declares the height variable
    double Radius = 0.0; // declares the Radius variable
    int noc = 0; // Number of Cannonballs to be used further in program
    printf("What's the height: "); // Prints input statement
    scanf("%d", &Height); //scans for input
    printf("What's the Radius: ");
    scanf("%lf", &Radius);
    for ( int i = 1; i <= Height; i++ ) {
        noc += i*i;  //for loop used for calculating amount of cannon balls in stack
    }
    double volume = (4.0/3.0)*M_PI*(Radius*Radius*Radius); //formula for calculating the volume of 1 cannon ball
    double mass = volume * 0.284; //formula for calculating the mass of a cannonball
    printf("The Mass of the pyramid is: %lf lbs", mass * noc);
    return EXIT_SUCCESS;
}