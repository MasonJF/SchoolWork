/*
 * Environment.cpp
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#include "Environment.h"

#include <iostream>
#include "Entity.h"

Environment::Environment(int d)
: envArr_(d, std::vector<Entity *>(d, nullptr))
{
}

Environment::~Environment() {
	// TODO Auto-generated destructor stub
}

Entity * Environment::enquire(unsigned i, unsigned j) {
	return envArr_[i][j];
}

bool Environment::place(Entity * p, unsigned i, unsigned j) {
	std::lock_guard<std::mutex> grab(theStick_);

	if (i<0 or i > envArr_.size()-1 or j < 0 or j > envArr_.size()-1)
		return false;

	if (envArr_[i][j] )
		return false;

	envArr_[i][j]=p;
	if (p->x_ >= 0 and p->y_ >= 0)
		envArr_[p->x_][p->y_]=nullptr;

	p->x_=i, p->y_=j;

	print();

	return true;

}
bool Environment::remove(unsigned i, unsigned j) {
	std::lock_guard<std::mutex> hold(theStick_);
	envArr_[i][j]=nullptr;
	print();
	return true;
}

void Environment::print() {

	for(auto& row: envArr_) {
		for (auto& val: row)
			if (val)
				std::cout << val->getR() << '|';
			else
				std::cout << '_' << '|';
		std::cout << std::endl;
	}
	std::cout << std::endl;
}

