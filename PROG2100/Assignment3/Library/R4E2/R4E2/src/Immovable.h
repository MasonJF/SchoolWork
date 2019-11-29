/*
 * Immovable.h
 *
 *  Created on: Oct. 11, 2019
 *      Author: piotr
 */

#ifndef IMMOVABLE_H_
#define IMMOVABLE_H_

#include "Entity.h"

class Immovable: public Entity {
public:
	Immovable(Environment&, std::string="W");
	virtual ~Immovable();
	std::string get_name();
	void reset() {}

private:
	bool move(D, D){ return false;};
};

#endif /* IMMOVABLE_H_ */
