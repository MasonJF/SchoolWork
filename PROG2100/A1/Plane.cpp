//
// Created by Mason Fraser on 9/17/2019.
//

#include "Plane.h"
int Plane::planeId{0};

std::ostream& operator<<(std::ostream& os, const Plane& plane){
    os << plane.id_ << std::endl;
    return os;
}

Plane::Plane(int currentTime) : id_{planeId} {
    currentTime_ = currentTime;
    planeId++;
}

//bool Plane::isReady(Plane *) {
//    return false;
//}
