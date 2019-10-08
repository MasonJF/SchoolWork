/*
 * Queue.h
 *
 *  Created on: 2012-09-25
 *      Author: piotr
 *
 *  Modified on 2018-09-20
 *      Author: piotr
 *
 */

#ifndef QUEUE_H_
#define QUEUE_H_

#include <stdexcept>
using namespace std;

template <typename T>
class Queue {
public:
	Queue(int = 3 );
	Queue(const Queue&) = delete;
	Queue& operator=(const Queue&) = delete;
	virtual ~Queue();

	bool enqueue(T);
	T dequeue();
	T inspect()const;
	bool isFull() const;
	bool isEmpty() const;

	// These would nicely work as enqueue() and dequeue() replacements:
	Queue& operator<<(const T& x) { enqueue(x); return *this; }
	Queue& operator>>(T& x) { x=dequeue(); return *this; }


	bool operator! () const { return !isFull(); } 
	operator bool() const {return !isEmpty(); }  
	// Note: these are not complementing each other! 

private:
	class IntMod { 
	public: 
		IntMod(int m, int x = 0)
		:mod_(m), value_(x%mod_)
		{}
		int operator++(int) {
			int temp=value_++;
			value_%=mod_;
			return temp;
		}
		operator int() const {
			return value_;
		}
	private:
		int mod_;
		int value_;
	};


	int MAXSIZE_;
	T * q_;
	IntMod head_;
	IntMod tail_;
	int cnt_;


};

template <typename T>
Queue<T>::Queue(int num)
: MAXSIZE_{num}, q_{new T[MAXSIZE_]}, head_{MAXSIZE_}, tail_{MAXSIZE_}, cnt_{0}
{}

template <typename T>
Queue<T>::~Queue() {
	delete[] q_;
}

template <typename T>
bool Queue<T>::enqueue(T p)
{
	if (isFull()) return false;

	q_[cnt_++, tail_++] = p;
	return true;
}

template <typename T>
T Queue<T>::dequeue()
{
	if(isEmpty()) throw runtime_error("Dequeuing from empty queue!");

	return q_[cnt_--, head_++];
}

template <typename T>
T Queue<T>::inspect() const
{
	if(isEmpty()) throw runtime_error("Queue is empty");

	return q_[head_];
}

template <typename T>
inline bool Queue<T>::isFull() const
{
	return cnt_ == MAXSIZE_;
}

template <typename T>
inline bool Queue<T>::isEmpty() const
{
	return cnt_ == 0;
}



#endif /* QUEUE_H_ */
