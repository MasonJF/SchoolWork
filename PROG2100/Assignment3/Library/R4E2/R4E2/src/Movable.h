/*
 * Movable.h
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#ifndef MOVABLE_H_
#define MOVABLE_H_

#include "Entity.h"

class Movable: public Entity {
public:
	Movable(Environment&, std::string="P");
	virtual ~Movable();
	std::string get_name();
};

#endif /* MOVABLE_H_ */
