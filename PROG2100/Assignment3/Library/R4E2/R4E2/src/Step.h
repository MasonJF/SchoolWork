/*
 * Step.h
 *
 *  Created on: Oct. 25, 2019
 *      Author: piotr
 */

#ifndef STEP_H_
#define STEP_H_

#include "Autonomous.h"
#include "Mission.h"

class Step: public Mission {
public:
	Step(Autonomous&, D, D);
	virtual ~Step();
	bool doit();
private:
	Autonomous& s_;
	D shift_x_;
	D shift_y_;
};

#endif /* STEP_H_ */
