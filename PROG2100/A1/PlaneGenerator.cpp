//
// Created by Mason Fraser on 07-Oct-19.
//

#include "PlaneGenerator.h"


PlaneGenerator::~PlaneGenerator() {

}

PlaneGenerator::PlaneGenerator(Queue * theQue, Timer * theTimer) {
    this->tempQueue = theQue;
    this->timer = theTimer;
}

void PlaneGenerator::tickUpdate() {
    Plane * plane = new Plane(timer->time());
    if (tempQueue->enqueue(plane)) {
        std::cout << plane->id_ << std::endl;
    }else{
        std::cout << "Fail" << std::endl;
    }

}



