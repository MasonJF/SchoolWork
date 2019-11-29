/*
 * ClientHandler.h
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#ifndef CLIENTHANDLER_H_
#define CLIENTHANDLER_H_

#include <ServerSocket.h>
#include <thread>
#include "Environment.h"

#include <TSCLLQueueT.h>

#include "Autonomous.h"
#include "GoTo.h"
#include "Nap.h"
#include "Terminate.h"
#include "Step.h"

/* This is a class, whose instances (functors) will allow us to talk to clients */
class ClientHandler {
public:
	ClientHandler(Environment& e, ServerSocket * s);
	virtual ~ClientHandler();

	void operator() ();

private:
	Environment& e_;
	ServerSocket * s_;
	Queue<Mission*>* q_;
	Autonomous* myR_;

};

#endif /* CLIENTHANDLER_H_ */
