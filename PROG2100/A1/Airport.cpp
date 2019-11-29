//
// Created by Mason Fraser on 09-Oct-19.
//

#include "Airport.h"
#include <iostream>

void Airport::runSimulation() {
    int mland {8};
    int mtakeoff {7};

    Queue* testIn = new Queue();
    Queue* testOut = new Queue();
    Timer time = Timer();
    Runway* bigRuns = new Runway(&time);

    PlaneGenerator qLand = PlaneGenerator(testIn, &time, mland);
    PlaneGenerator qTakeoff = PlaneGenerator(testOut, &time, mtakeoff);
    Dispatcher bigDis = Dispatcher(testIn, testOut, bigRuns, &time);


    for (long long int i = 0; i < 10000000000; ++i) {
        if(i % 1000000 == 0) {
            std::cout << i << " worked " << std::endl;
        }
        time.tic();
        bigDis.checkFree();
        qLand.tickUpdate();
        qTakeoff.tickUpdate();
//        bigRuns->addPlane(testIn->inspect());
//        bigRuns->addPlane(new Plane(0));
        bigRuns->update();

//        _sleep(5);
    }
    std::cout << "The Average Landing time is: " << bigDis.getAverageIn() << std::endl;
    std::cout << "The Average Takeoff time is: " << bigDis.getAverageOut() << std::endl;

}
