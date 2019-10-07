//
// Created by Mason Fraser on 9/17/2019.
//

#include "Plane.h"
std::ostream& operator<<(std::ostream& os, const Plane& plane){
    os << plane.id_ << std::endl;
    return os;
}

Plane::Plane(int id) : id_(id) {
    id_ = id;
}
