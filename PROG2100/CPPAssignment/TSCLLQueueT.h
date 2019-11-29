/*
 * Queue.h
 *
 *  Created on:  2012-09-25
 *  Modified on: 2019-09-21
 *      Author: piotr
 *
 */


/* Thread-Safe Queue template based on a circular linked list */



#ifndef QUEUE_H_
#define QUEUE_H_

#include <thread>
#include <mutex>
#include <condition_variable>

template <typename T>
class Queue {
public:
	Queue();
	virtual ~Queue();

	Queue(const Queue&) = delete;
	Queue& operator=(const Queue&) = delete;

	bool enqueue(T);
	T dequeue();


	// These could work nicely as enqueue() and dequeue() replacements:
	Queue& operator<<(const T& x) { enqueue(x); return *this; }
	Queue& operator>>(T& x) { x=dequeue(); return *this; }

	// This type type conversion operator allows dequeuing only when 
	// the queue is "good", i.e. non-empty - and it blocks, until this
	// is the case
	operator bool() {
		std::lock_guard<std::mutex> lck(mx_); 
		return !isEmpty(); 
	}

private:
	class Node {
	public:
		Node (T x) 
		: value_(x), next_(0) { }
		Node (T x, Node * p)
		: value_(x), next_(p) { }

		T value_;
		Node * next_;
	};

	Node * tail_;

	std::mutex mx_;
	std::condition_variable notEmptyNow_;

	bool isEmpty() const;

};

template <typename T>
Queue<T>::Queue()
: tail_(0)
{}

template <typename T>
Queue<T>::~Queue() {
	std::lock_guard<std::mutex> lo(mx_);
	while (! isEmpty() )
		dequeue();
}

template <typename T>
bool Queue<T>::enqueue(T x)
{
	std::lock_guard<std::mutex>  lg(mx_);
	if (isEmpty()) {
		tail_=new Node(x);
		tail_->next_=tail_;
		notEmptyNow_.notify_one();
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
	std::unique_lock<std::mutex> ul(mx_);

	while(isEmpty()) {
		notEmptyNow_.wait(ul);
	}

	T val(tail_->next_->value_);
	Node * pp(tail_->next_->next_);
	Node *  p(tail_->next_);

	delete tail_->next_;
	if (tail_==p)
		tail_=0;
	else
		tail_->next_=pp;

	return val;
}

template <typename T>
inline bool Queue<T>::isEmpty() const
{
/*
 * This is now a private function, called only by methods holding the mutex
 * when an attempt to lock/guard it will cause deadlock 
 */

	return tail_ == 0;
}

#endif /* QUEUE_H_ */
