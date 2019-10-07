/*
 * CBQueue.cpp
 *
 *  Created on: Sep. 25, 2019
 *      Author: piotr
 */

#include "CBQueue.h"
// Definition of Plane class is needed if deleting Planes:
// #include "Plane.h"
class Plane{};

Queue::Queue(int num)
: MAXSIZE_{num}, q_{new Plane *[MAXSIZE_]}, head_{MAXSIZE_}, tail_{MAXSIZE_}, cnt_{0}
{}


Queue::~Queue() {
	// We may need to delete planes first:
	while (*this)
		delete this->dequeue();
	// ... approach this with caution!
	delete[] q_;
}

bool Queue::enqueue(Plane * p)
{
	if (isFull()) return false;

	q_[cnt_++, tail_++] = p;

	return true;
}

Plane * Queue::dequeue()
{
	if(isEmpty()) return nullptr;

	return q_[cnt_--, head_++];
}

Plane * Queue::inspect() const
{
	if(isEmpty()) return nullptr;

	return q_[head_];
}


