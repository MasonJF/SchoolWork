//
// Created by Mason Fraser on 07-Oct-19.
//

#include "PlaneGenerator.h"
#include <iostream>


PlaneGenerator::~PlaneGenerator() = default;

PlaneGenerator::PlaneGenerator(Queue * theQue, Timer * theTimer, int m) {
    this->tempQueue = theQue;
    this->timer = theTimer;
    this->delay = new Delay(m);
    time = timer->getTime() + delay->getDelay();
}

void PlaneGenerator::tickUpdate() {
    if(timer->getTime() >= time) {
        Plane * plane = new Plane(timer->getTime());
        tempQueue->enqueue(plane);
        time = timer->getTime() + delay->getDelay();
//        std::cout << time << std::endl;
    }
//    std::cout << timer->getTime() << std::endl;

}



