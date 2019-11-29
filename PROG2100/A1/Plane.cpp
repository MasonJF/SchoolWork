//
// Created by Mason Fraser on 9/17/2019.
//

#include "Plane.h"
int Plane::planeId{0};

std::ostream& operator<<(std::ostream& os, const Plane& plane){
    os << plane.id_ << std::endl;
    return os;
}

Plane::Plane(int currentTime){
    id_ = planeId;
    currentTime_ = currentTime;
    planeId++;
    isLanding_ = false;
}

int Plane::getTimeout() {
    return timeout_;
}

void Plane::setTimeout(int timeout) {
    timeout_ = timeout;
}

bool Plane::isLanding() {
    return isLanding_;
}

void Plane::setIsLanding(bool isLanding) {
    Plane::isLanding_ = isLanding;
}

Plane::~Plane() {

}



//bool Plane::isReady(Plane *) {
//    return false;
//}
