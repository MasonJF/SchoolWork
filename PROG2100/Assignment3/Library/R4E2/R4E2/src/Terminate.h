/*
 * Terminate.h
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#ifndef TERMINATE_H_
#define TERMINATE_H_

#include "Mission.h"

class Terminate: public Mission {
public:
	Terminate();
	virtual ~Terminate();
	bool doit() {return false;}
};

#endif /* TERMINATE_H_ */
