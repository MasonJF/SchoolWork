/*
 * Bed.cpp
 *
 *  Created on: 2012-10-07
 *      Author: piotr
 */

#include "Bed.h"

Bed::Bed()
: occupant_(0), time_(0)
{}

bool Bed::layDown(Cust * x)
{
	if (occupant_) return false;  //The bed is alredy taken
	occupant_ = x; time_=10;
	return true;
}

Cust * Bed::enough()
{
	Cust * tmp(occupant_);
	occupant_ = 0;
	time_=0;
	return tmp;
}
