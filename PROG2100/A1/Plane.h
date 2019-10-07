//
// Created by Mason Fraser on 9/17/2019.
//

#ifndef A1_PLANE_H
#define A1_PLANE_H


#include <iostream>

class Plane {
public:
    explicit Plane(int id);

    friend std::ostream& operator<<(std::ostream& os, const Plane& plane);
    int id_;
};


#endif
