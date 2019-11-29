/*
 * mainEcho.cpp
 *
 *  Created on: Oct 9, 2019
 *      Author: piotr
 */


#include <iostream>
#include <unistd.h>
#include <string>
#include <cstdlib>
#include <signal.h>
#include <SimpleSockets/ServerSocket.h>

using namespace std;

int main()
{
	ServerSocket sock(30000);
	ServerSocket newsock;
	string heSaid;

	::chdir("/");   // Not to block any umounts (unnecessarily)
	signal(SIGCHLD, SIG_IGN);  // Not to make zombies

	cout << "Echo server running at port 30000. " << endl;
	while ( true ) {
		// Only the parent will accept connections
		sock.accept ( newsock );
		if (fork() == 0) {
			// This is child's role;
			try {
				while( true ) {
					newsock >> heSaid;
					// I am commenting this server-side output:
					// cout << "Server heard:" << heSaid << endl;
					// (if at all generated, it should go to a log file...)
					newsock << "I hear you! You have said: " << heSaid << "******\n" ;
				}
			}
			catch (SocketException &) { }
			exit(0); // !!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// The child must exit when the session ends(!)
		}
	}
}

