/*
 * mainEcho3.cpp
 *
 *  Created on: Oct 9, 2019
 *      Author: piotr
 */

#include <iostream>
#include <string>
#include <cstdlib>
#include <thread>
#include <SimpleSockets/ServerSocket.h>

#include "ClientHandler.h"

using namespace std;

/* This mainline is really very short...
 * ... but my comments make it look long (and bad;)
 */

int main()
{
	int port(30000);

	ServerSocket sock(port);

	ServerSocket * newsock;

	chdir("/");   // Not to block any unmounts (unnecessarily)

	cout << "Echo server running at port " << port << endl;

	while ( true ) {

		newsock=new ServerSocket;   // Yes, you need a new newsock object for a new session,
									// if you expect multiple sessions to run concurrently

	// The main thread will accept connections...

		sock.accept ( *newsock );

	// ... and will spawn threads that will handle sessions:

	// Using a function object (aka functor) (this approach should be preferred):

	std::thread  (ClientHandler(newsock)).detach();

		/* The above could be also rewritten as a two-liner::
		 * std::thread  xyz(ClientHandler(newsock));
		 * xyz.detach();
		 */

	// ! Note that detach() is called, hence threads become "un-joinable",
	// ! and we can afford creating them nameless...

	}
}

