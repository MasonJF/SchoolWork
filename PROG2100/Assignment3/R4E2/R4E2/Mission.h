/*
 * Action.h
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#ifndef MISSION_H_
#define MISSION_H_

class Mission {
public:
	Mission(){};
	virtual ~Mission(){} ;
	virtual bool doit() = 0;
};

#endif /* MISSION_H_ */
