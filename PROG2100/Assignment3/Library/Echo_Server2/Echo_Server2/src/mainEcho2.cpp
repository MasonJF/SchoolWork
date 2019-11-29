/*
 * mainEcho2.cpp
 *
 *  Created on: Oct 9, 2019
 *      Author: piotr
 */

#include <iostream>
#include <string>
#include <cstdlib>
#include <thread>
#include <SimpleSockets/ServerSocket.h>

using namespace std;

/* This is a procedure responsible for talking to clients */

// Note that unlike in the function object case, changing argument's type from pointer to reference
// will not work unless you use std::ref() when setting up the thread...
void handleClient(ServerSocket  * newsock ) {
	string heSaid;
	try {
		while( true ) {
			*newsock >> heSaid;
			cout << "Server heard:" << heSaid << endl;
			*newsock << "I hear you! You have said: " << heSaid << "******\n" ;
		}
	}
	catch (SocketException & e) { /* cout << e.what() << endl; */  }

	// The conversation is done; in fork-based Echo, the child process exits and all its resources
	// are released...
	// And here? Well, how about this:
	delete newsock;
}


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

	// Using a function (as opposed to using a functor - see the next version):

		std::thread (handleClient, newsock).detach();

	// ! Note that detach() is called, hence threads become "un-joinable",
	// ! and we can afford creating them nameless...

	}
}

