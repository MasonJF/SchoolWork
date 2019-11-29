/*
 * Nap.h
 *
 *  Created on: Oct. 25, 2019
 *      Author: piotr
 */

#ifndef NAP_H_
#define NAP_H_

#include <thread>
#include <chrono>

#include "Mission.h"

class Nap: public Mission {
public:
	Nap(int =3);
	virtual ~Nap();
	bool doit() {
		std::this_thread::sleep_for(std::chrono::milliseconds(10000));
		return true;
	}
private:
	int howLong_;
};

#endif /* NAP_H_ */
