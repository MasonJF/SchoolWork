/*
 * Step.cpp
 *
 *  Created on: Oct. 25, 2019
 *      Author: piotr
 */

#include "Step.h"

Step::Step(Autonomous& r, D x, D y)
: s_{r}, shift_x_{x}, shift_y_{y}
{
}

Step::~Step() {
	// TODO Auto-generated destructor stub
}
bool Step::doit() {
	s_.move(shift_x_, shift_y_);

	return true;
}
