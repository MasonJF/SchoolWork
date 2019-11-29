/*
 * Entity.cpp
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#include "Entity.h"

Entity::Entity(Environment& e, std::string n)
:e_(e), name_(n), x_{-1}, y_{-1}, R_{name_.c_str()[0]}
{
}

Entity::~Entity() {
	e_.remove(x_,y_);
}

std::string Entity::get_name(){
	return name_;
}

bool Entity::initPlace(int i, int j)
{
	if (x_== -1 and y_== -1 and e_.place(this, i,j)) {
		return true;
	}

	return false;
}

void Entity::reset() {
	int i{x_};
	int j{y_};
	x_= y_=-1;
	e_.remove(i,j);
}
