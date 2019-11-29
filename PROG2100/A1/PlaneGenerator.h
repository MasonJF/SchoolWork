//
// Created by Mason Fraser on 07-Oct-19.
//

#ifndef A1_PLANEGENERATOR_H
#define A1_PLANEGENERATOR_H

#include "Queue.h"
#include "Timer.h"
#include "Plane.h"
#include "Delay.h"

class PlaneGenerator {

public:
    PlaneGenerator(Queue *, Timer *, int);
    virtual ~PlaneGenerator();
    void tickUpdate();



private:
    Delay* delay;
    Queue* tempQueue;
    Timer* timer;
    int time;
};




#endif //A1_PLANEGENERATOR_H
