//
// Created by Mason Fraser on 9/17/2019.
//

#ifndef A1_PLANE_H
#define A1_PLANE_H


#include <iostream>

class Plane {

public:
    explicit Plane(int currentTime);

    friend std::ostream& operator<<(std::ostream& os, const Plane& plane);
    int id_;
    int currentTime_;

private:
    static int planeId;
};


#endif
