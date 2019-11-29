//
// Created by Mason Fraser on 9/17/2019.
//

#ifndef A1_PLANE_H
#define A1_PLANE_H


#include <iostream>

class Plane {

public:
    explicit Plane(int currentTime);
    ~Plane();
    friend std::ostream& operator<<(std::ostream& os, const Plane& plane);
    int id_;
    int currentTime_;
    int getTimeout();
    bool isLanding();
    void setTimeout(int timeout);


private:
    static int planeId;
    int timeout_ {0};
    bool isLanding_ {false};
public:
    void setIsLanding(bool isLanding);

};


#endif
