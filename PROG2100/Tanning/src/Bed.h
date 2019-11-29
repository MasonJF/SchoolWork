/*
 * Bed.h
 *
 *  Created on: 2012-10-07
 *      Author: piotr
 */

#ifndef BED_H_
#define BED_H_

#include <iostream>
using namespace std;

class Cust {};		// Customer details not relevant & not provided

class Bed   /* a Tanning Bed */
{
public:
	Bed();
	bool layDown(Cust * );
	int howLong(){ if (time_ > 0) return time_--;
				   enough(); return 0; }
	Cust * enough();
	bool isIt(Cust * customer) {
	    return occupant_==customer;
	}
private:
	Cust * occupant_;
	int time_;
};


#endif /* BED_H_ */
