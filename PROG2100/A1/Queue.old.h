//
// Created by Mason Fraser on 9/17/2019.
//

#ifndef A1_QUEUE_H
#define A1_QUEUE_H

#include <iostream>
#include "Plane.h"

class Queue {

    public:
        Queue();

    /* Any additional constructors needed */
        virtual ~Queue();
        bool enqueue( Plane * );
        bool isFull();
        bool isEmpty();
        Plane * dequeue();
        Plane * inspect(int a) const;



    private:
        static const int MAXSIZE{20};
    /* or more "classic":
    enum { MAXSIZE = 20 };  */
        Plane * q_[MAXSIZE];
    // Or, better, an array to be allocated dynamically: Plane * * q_
    // - although, if I were you, I would try the fixed-sized array first
        int tail_;
        int head_;
        int cnt_;   // ? do we need this ?

};
#endif //A1_QUEUE_H
