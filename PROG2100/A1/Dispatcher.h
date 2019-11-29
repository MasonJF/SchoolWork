//
// Created by Mason Fraser on 08-Oct-19.
//

#ifndef A1_DISPATCHER_H
#define A1_DISPATCHER_H

#include "Runway.h"
#include "Queue.h"

class Dispatcher {
public:
    Dispatcher(Queue *, Queue *, Runway *, Timer *);
    void checkFree();
    int math(Plane *);
    Plane * queuedPlane();
    void counters();
    double meanMath(int planeCount, int time);
    double getAverageIn();
    double getAverageOut();

private:
    Runway * runway;
    Timer * FUCK;
    Queue * queueIn;
    Queue * queueOut;
    int totalInPlanes_;
    int totalOutPlanes_;
    int inTime_;
    int outTime_;

};


#endif //A1_DISPATCHER_H
