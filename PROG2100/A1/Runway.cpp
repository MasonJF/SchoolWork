//
// Created by Mason Fraser on 07-Oct-19.
//

#include "Runway.h"


Runway::Runway(Timer* timer) : mclear{5} {
    busy = false;
    rip = timer;
    time = rip->getTime();
}

Runway::~Runway() {

}

bool Runway::isBusy() {
    return busy;
}

Plane * Runway::getPlane() {
    return plane;
}

void Runway::nineEleven() {
    if(busy) {
        delete plane;
        busy = false;
        time = rip->getTime() + mclear.getDelay();
    }else{
        ;
    }
}
void Runway::addPlane(Plane * thePlane) {
    busy = true;
    plane = thePlane;
}

void Runway::update() {
    if(rip->getTime() >= time and busy) {
        nineEleven();
    }
}
