/*
 * Movable.cpp
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#include "Movable.h"

Movable::Movable(Environment& e, std::string n) : Entity(e, n){
	// TODO Auto-generated constructor stub

}

Movable::~Movable() {
	// TODO Auto-generated destructor stub
}

std::string Movable::get_name(){
	return name_;
}
