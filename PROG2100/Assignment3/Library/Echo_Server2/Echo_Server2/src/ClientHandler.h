/*
 * ClientHandler.h
 *
 *  Created on: Jan 9, 2018
 *      Author: piotr
 */

#ifndef CLIENTHANDLER_H_
#define CLIENTHANDLER_H_

#include "SimpleSockets/ServerSocket.h"
#include <thread>

/* This is a class, whose instances (functors) will allow us to talk to clients */
class ClientHandler {
public:
	ClientHandler(ServerSocket * s);   // This would work with a reference instead of a pointer...
									   // (of course, a number of other adjustments would be needed
									   //  to accommodate such a change)
	virtual ~ClientHandler();
	// Overloading function call operator makes ClientHandler objects "callable":
	void operator() () {
		string heSaid;
		try {
			while( true ) {
				*s_ >> heSaid;
				// cout << "Server heard:" << heSaid << endl;
				*s_ << "Functor: I hear you! You have said: " << heSaid << "******\n" ;
			}
		}
		catch (SocketException & e) { /*cout << e.what() << endl;*/  }
		delete s_;  // Yes, no one will use this socket now...
	}
private:
	ServerSocket * s_;
};

#endif /* CLIENTHANDLER_H_ */
