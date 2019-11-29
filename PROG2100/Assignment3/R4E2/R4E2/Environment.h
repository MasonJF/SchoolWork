/*
 * Environment.h
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#ifndef ENVIRONMENT_H_
#define ENVIRONMENT_H_

#include <vector>
#include <chrono>
#include <thread>
#include <mutex>
#include <condition_variable>

class Entity;

class Environment {
public:
	Environment(int = 20);
	virtual ~Environment();
	Entity * enquire(unsigned, unsigned);
	bool place(Entity *, unsigned, unsigned);
	bool remove(unsigned, unsigned);
	void print();
	// friend class Entity;
	/* (commented out after reviewing humanity record with Env :( */
private:
	std::vector<std::vector<Entity *> >  envArr_ ;
	std::mutex theStick_;

};

#endif /* ENVIRONMENT_H_ */
