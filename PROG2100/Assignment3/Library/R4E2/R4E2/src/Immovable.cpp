/*
 * Immovable.cpp
 *
 *  Created on: Oct. 11, 2019
 *      Author: piotr
 */

#include "Immovable.h"

Immovable::Immovable(Environment& e, std::string n)
:Entity(e, n)
{
}

Immovable::~Immovable() {
	// TODO Auto-generated destructor stub
}

std::string Immovable::get_name(){
	return name_;
}
