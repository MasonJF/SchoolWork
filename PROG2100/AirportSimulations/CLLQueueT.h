/*
 * Queue.h
 *
 *  Created on: 2012-09-25
 *      Author: piotr
 *
 *  Modified on: 2018-09-20
 *      Author: piotr
 *
 *
 */


/* Queue template based on a circular linked list */

/* 
 * To create a Queue QP of pointers to Planes,
 * one would type: 
 * Queue<Plane *>  QP;
 *
 * Note that we may have Q of any type objects, e.g. a qd defined as follows: 
 * Queue<double> qd; 
 * is a queue of doubles.
 * Thus, inspecting or dequeueing from an empty queue is a headache:
 * as nothing sensible can be return, we throw... 
 * 
 * Also: when we use linked list the "isFull()" method makes little
 * sense, as no buffer is pre-allocated - i.e., the queue will get
 * full, when we run out of memory...  So, our isFull() always returns
 * "false" (maybe too optimistically:)
 *
 */ 


#ifndef QUEUE_H_
#define QUEUE_H_

#include <stdexcept>
using namespace std;


template <typename T>
class Queue {
public:
	Queue();
	Queue(const Queue&) = delete;
	Queue& operator=(const Queue&) = delete;
	virtual ~Queue();

	bool enqueue(T);
	T dequeue();
	T inspect() const ;
	bool isFull() const;
	bool isEmpty() const;

	// These would nicely work as enqueue() and dequeue() replacements:
	Queue& operator<<(const T& x) { enqueue(x); return *this; }
	Queue& operator>>(T& x) { x=dequeue(); return *this; }

	operator bool() const {return !isEmpty(); }
	// This type type conversion operator allows dequeuing while queue is "good", i.e. non-empty
	// I got rid of overloaded negation, as this queue is (almost;) never full...


private:
	struct Node {
		Node (T x) 
		: value_(x), next_(0) { }
		Node (T x, Node * p)
		: value_(x), next_(p) { }

		// Data members also public this time...
		T value_;
		Node * next_;
	};

	Node * tail_;

};

template <typename T>
Queue<T>::Queue()
: tail_{nullptr}
{}

template <typename T>
Queue<T>::~Queue() {
	while ( *this )   // i.e. while ( ! isEmpty())
		dequeue();
}
template <typename T>
bool Queue<T>::enqueue(T x)
{
	if (isEmpty()) {
		tail_=new Node(x);
		tail_->next_=tail_;
	}
	else  {
		Node * p(tail_);
		tail_=new Node(x,tail_->next_);
		p->next_=tail_;
	}

	return true;
}
template <typename T>
T Queue<T>::dequeue()
{
	if(isEmpty()) 
		throw runtime_error("Dequeuing from empty queue!");

	T val(tail_->next_->value_);
	Node * pp(tail_->next_->next_);
	Node *  p(tail_->next_);

	delete tail_->next_;
	if (tail_==p)
		tail_=nullptr;
	else
		tail_->next_=pp;

	return val;
}

template <typename T>
T Queue<T>::inspect() const
{
	if(isEmpty()) 
		throw runtime_error("Queue is empty");

	return tail_->next_->value_;
}

template <typename T>
inline bool Queue<T>::isFull() const
{
	// Well... any better ideas?
	return false;
}

template <typename T>
inline bool Queue<T>::isEmpty() const
{
	return tail_ == nullptr;
}



#endif /* QUEUE_H_ */
