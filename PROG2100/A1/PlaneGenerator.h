//
// Created by Mason Fraser on 07-Oct-19.
//

#ifndef A1_PLANEGENERATOR_H
#define A1_PLANEGENERATOR_H

#include "Queue.h"
#include "Timer.h"
#include "Plane.h"

class PlaneGenerator {

public:
    PlaneGenerator(Queue *, Timer *);
    virtual ~PlaneGenerator();
    void tickUpdate();

private:
    Queue* tempQueue;
    Timer* timer;
    int nextId;
};




#endif //A1_PLANEGENERATOR_H
