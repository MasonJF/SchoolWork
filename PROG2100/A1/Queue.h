/**
 * Queue.h
 *
 *  Created on: 2012-09-25
 *      Author: piotr
 *
 *  Modified on 2019-09-25
 *      Author: piotr
 *
 */

#ifndef QUEUE_H_
#define QUEUE_H_

#include <cassert>
#include <cstdio>

class Plane;

/// Dynamically allocatable queue of Plane pointers
/// implemented using a circular buffer
class Queue {
public:
	explicit Queue(int = 10 );
	Queue(const Queue&) = delete;
	Queue(Queue&&)= delete;
	Queue& operator=(const Queue&) = delete;
        Queue& operator=(Queue&&) = delete;
	virtual ~Queue();

	bool enqueue(Plane *);
	Plane * dequeue();
	Plane * inspect()const;
	bool isFull() const;
	bool isEmpty() const;

	// These would nicely work as enqueue() and dequeue() replacements:
	Queue& operator<<(Plane * x) { enqueue(x); return *this; }
	// Is the above better than what follows?
	// Queue& operator<<(const Plane *& x) { enqueue(const_cast<Plane *>(x)); return *this; }
	Queue& operator>>(Plane *& x) { x=dequeue(); return *this; }

	// ... more operators; quite handy :)
	bool operator! () const { return !isFull(); } 
	operator bool() const {return !isEmpty(); }  
	// Note: these are not complementing each other! 

private:
	/// Having "integer modulo M" makes life simpler!
	class IntMod { 
	public: 
		IntMod(int M, int x = 0)
		:mod_(M), value_(x%mod_)
		{ assert(M>1);}

		// Postfix increment
		int operator++(int) {
			int temp=value_++;
			value_%=mod_;
			return temp;
		}

		// Integer conversion
		operator int() const {
			return value_;
		}
	private:
		int mod_;
		int value_;
	};


	int MAXSIZE_;
	Plane * * q_;
	IntMod head_;
	IntMod tail_;
	int cnt_;

};


inline bool Queue::isFull() const
{
	return cnt_ == MAXSIZE_;
}

inline bool Queue::isEmpty() const
{
	return cnt_ == 0;
}


#endif /* QUEUE_H_ */
