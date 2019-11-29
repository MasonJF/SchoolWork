/*
 * Autonomous.h
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#ifndef AUTONOMOUS_H_
#define AUTONOMOUS_H_

#include <TSCLLQueueT.h>
#include <ServerSocket.h>
#include "Entity.h"
#include "Mission.h"

class Autonomous: public Entity {
public:
	Autonomous(Environment& e, Queue<Mission*>&, std::string=" ");
	Autonomous(Environment& e, Queue<Mission*>&, ServerSocket *, std::string=" ");
	virtual ~Autonomous();

	bool move(D, D);  // Must this be public?... Well...

	virtual void operator() ();

private:
	Queue<Mission*>& q_;
	ServerSocket * s_;
	Entity * load_;
};

#endif /* AUTONOMOUS_H_ */
