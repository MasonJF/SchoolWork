/*
 * A simulated time source. 
 * A monostate class.
 * Used in: PROG 2011 Assignment#2
 * by PWP 
 */

#include "Timer.h"

//int Timer::time_{0};

int Timer::getTime() {
    return time_;
}

Timer::Timer():time_{0}{}

Timer::~Timer()
{
}
int Timer::tic()
{
	return ++time_;
}
int Timer::time()
{
	return time_ ;
}
