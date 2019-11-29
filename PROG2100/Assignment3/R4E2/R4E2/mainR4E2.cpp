/*
 * mainR4E2.cpp
 *
 *  Created on: Oct. 09, 2019
 *      Author: piotr
 */

#include <iostream>
#include <string>
#include <cstdlib>
#include <thread>
#include <ServerSocket.h>
#include <ClientSocket.h>
#include "ClientHandler.h"

#include "Environment.h"
#include "Immovable.h"
#include "Movable.h"

using namespace std;



int main()
{

	Environment grid;

	Immovable P(grid);
	Immovable Q(grid);
	P.initPlace(4,4);
	Q.initPlace(6,6);

	// Let's build a(n indestructible ;) wall!
	for (int i=0; i < 10; i++) {
		(new Immovable {grid}) -> initPlace(7,i);
		// Uncomment this to create a box:
//		 (new Immovable {grid}) -> initPlace(i,9);
	}
	cout << "Environment created & set up. " << endl;

	grid.print();

	int port{30001};
	ServerSocket sock(port);
	ServerSocket * newsock;

	chdir("/");


	cout << "Server running at port " << port << endl;

	while ( true ) {
		newsock=new ServerSocket;
		sock.accept ( *newsock );
		std::thread(ClientHandler(grid, newsock)).detach();
	}
}

