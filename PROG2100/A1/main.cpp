#include <iostream>
#include "Queue.h"
#include "Plane.h"
#include "PlaneGenerator.h"
#include "Timer.h"


using namespace std;

int main() {

    Queue* test = new Queue();
    Timer time = Timer();
    PlaneGenerator testPlane = PlaneGenerator(test, &time);

    for (int i = 0; i < 18; ++i) {
        testPlane.tickUpdate();
    }


    test->inspect();
    return 0;
}