//
// Created by Mason Fraser on 08-Oct-19.
//

#include "Dispatcher.h"

Dispatcher::Dispatcher(Queue * queIn, Queue *queOut, Runway * runAway, Timer * timer) {
    FUCK = timer;
    runway = runAway;
    queueIn = queIn;
    queueOut = queOut;
    totalInPlanes_ = 0;
    totalOutPlanes_ = 0;
    inTime_ = 0;
    outTime_ = 0;
}

void Dispatcher::checkFree() {
    if(not runway->isBusy()){
        counters();
    }
}

void Dispatcher::counters(){
    Plane * tempPlane = queuedPlane();
    if(tempPlane == nullptr){
        return;
    }
    tempPlane->setTimeout(FUCK->getTime());
    runway->addPlane(tempPlane);
    if(tempPlane->isLanding()) {
        totalInPlanes_++;
        inTime_ = inTime_ + math(tempPlane);
    }else{
        totalOutPlanes_++;
        outTime_ = outTime_ + math(tempPlane);
    }
}

double Dispatcher::meanMath(int planeCount, int time) {
    return (double) time / (double) planeCount;
}

double Dispatcher::getAverageIn() {
    return meanMath(totalInPlanes_, inTime_);
}

double Dispatcher::getAverageOut() {
    return meanMath(totalOutPlanes_, outTime_);
}

int Dispatcher::math(Plane * plane) {
    return plane->getTimeout() - plane->currentTime_;
}

Plane *Dispatcher::queuedPlane() {
    Plane * tempPlane = nullptr;
    if(not queueIn->isEmpty() and not queueOut->isEmpty()) {
        if (queueIn->inspect()->currentTime_ <= queueOut->inspect()->currentTime_) {
            tempPlane = queueIn->dequeue();
            tempPlane->setIsLanding(true);
        }else{
            queueOut->inspect()->setTimeout(FUCK->getTime());
            tempPlane = queueOut->dequeue();
            tempPlane->setIsLanding(false);
        }
    }
    else if(not queueIn->isEmpty()){
        tempPlane = queueIn->dequeue();
        tempPlane->setIsLanding(true);
    }
    else if(not queueOut->isEmpty()) {
        tempPlane = queueOut->dequeue();
        tempPlane->setIsLanding(false);
    }

    return tempPlane;
}
