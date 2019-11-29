//
// Created by Mason Fraser on 07-Oct-19.
//

#ifndef A1_RUNWAY_H
#define A1_RUNWAY_H

#include "Plane.h"
#include "Timer.h"
#include "Delay.h"


class Runway {
public:
    Runway(Timer*);
    virtual ~Runway();
    bool isBusy();
    void addPlane(Plane *);
    Plane * getPlane();
    void nineEleven();
    void update();
private:
    bool busy;
    Plane * plane;
    Timer* rip;
    Delay mclear;
    int time;

};


#endif //A1_RUNWAY_H
