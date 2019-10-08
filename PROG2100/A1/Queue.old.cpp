//
// Created by Mason Fraser on 9/17/2019.
//

#include "Queue.h"

Queue::Queue():head_{0}, tail_{0}, cnt_{0}{

}

Queue::~Queue() = default;

bool Queue::enqueue(Plane * plane) {
    if (!isFull()){
        q_[tail_] = plane;
        tail_ = (tail_ + 1) % (MAXSIZE);
        cnt_++;
        return false;
    }else{
        printf("Q is FULL DAMMIT\n");
        return true;
    }
}

Plane *Queue::dequeue() {
    if(isEmpty()) return nullptr;
//    Plane *data = q_[head_];
    q_[head_] = nullptr;
    head_ = (head_ + 1) % (MAXSIZE + 1);
    cnt_--;
    return nullptr;
}

Plane *Queue::inspect(int a) const {
    if(q_[a] == nullptr){
        printf("Location %d is EMPTY\n", a);
    }
    return q_[a];
}

bool Queue::isFull() {
    return (head_ == 0 && tail_ == MAXSIZE + 1) || cnt_ == MAXSIZE;
}

bool Queue::isEmpty() {
    return (head_ == tail_);
}

