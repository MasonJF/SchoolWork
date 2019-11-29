/*
 * ClientHandler.cpp
 *
 *  Created on: Jan 9, 2018
 *      Author: piotr
 */

#include "ClientHandler.h"

ClientHandler::ClientHandler(ServerSocket * s)
: s_(s)
{
}

ClientHandler::~ClientHandler() {
	// You may try uncommenting this... very enlightening!
	// cout << "Destructor called!" << endl;
}

