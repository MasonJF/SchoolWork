#include <iostream>
#include "Queue.h"
#include "Plane.h"


using namespace std;

int main() {

    Queue* test = new Queue();

    for (int i = 0; i < 8; ++i) {
        test->enqueue(new Plane(i));
    }


    test->inspect();
    return 0;
}