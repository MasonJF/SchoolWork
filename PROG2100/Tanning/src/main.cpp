//
// Created by Mason Fraser on 24-Oct-19.
//

#include <iostream>
#include "Bed.h"
#include "Salon.h"

int main() {
    int numberOfBeds = 10;
    Salon * tenBed = new Salon(numberOfBeds); // I've tried 1000 different things with how this should be created and haven't got the slightest idea what you actually want.
    for (int i = 0; i < numberOfBeds; ++i) {
        tenBed->enter(new Cust);
    }
    std::cout << &tenBed << endl;
    Salon copy = *tenBed; // This really seems to depend on how things are called. In this instance the copy is empty,
                        // however you can make it and exact copy with operator changes.
                        //The memory address of these are different, unless you change the way to reference things,
                        // in which case they will be exact copies of each other.
    Salon * copy2 = tenBed; //This makes copy2 point to tenBed
    * tenBed = *copy2; //This forces tenBed to make itself a copy of copy2 pointing to the same address in memory as copy2
    tenBed = copy2;//This does not appear to effect the result. Occupancy appears to be full.
    std::cout << &tenBed << endl;
    std::cout << &copy << endl;
    std::cout << &copy2 << endl;
    std::cout << &tenBed << endl;
}