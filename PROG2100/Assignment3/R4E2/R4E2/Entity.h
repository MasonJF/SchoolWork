/*
 * Entity.h
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#ifndef ENTITY_H_
#define ENTITY_H_

#include <string>
#include <iostream>

#include "Environment.h"

enum class D {
	X=0,
	N=-1,
	S=+1,
	E=+1,
	W=-1
};

class Entity {
public:
	Entity(Environment& e, std::string=" ");
	virtual ~Entity();
	int getX () const { return x_; }
	int getY () const { return y_; }
	virtual std::string get_name();
	virtual char getR() { return R_; }
	virtual bool initPlace(int,int);
	virtual void reset();

protected:

	Environment & e_;

	std::string name_;
	int x_;
	int y_;

	char R_;

	virtual bool move(D, D) = 0;

	friend class Environment;
	// No way!
	//friend class GoTo;
};

#endif /* ENTITY_H_ */
