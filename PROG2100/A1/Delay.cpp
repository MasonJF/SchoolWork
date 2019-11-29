/*
 * Delay.cpp
 *
 *  Created on: Aug 19, 2017
 *      Author: piotr
 */

#include "Delay.h"

#include <iostream>

Delay::Delay(int m)
: generator_{rdevice_()}, mean_{m>0?m:1}, expDist_{double(1.0/mean_)}
{}

Delay::~Delay() {
}

int Delay::getDelay()
{
	double x{expDist_(generator_)};
//	 std::cout << x << std::endl;
	return static_cast<int>(round(x));
}
