/*
 * ClientHandler.cpp
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#include "ClientHandler.h"
#include <sstream>

ClientHandler::ClientHandler(Environment& e, ServerSocket * s)
: e_{e}, s_{s}, q_{nullptr}, myR_{nullptr}
{
}

ClientHandler::~ClientHandler() {
	if (myR_) delete myR_;
	if (q_) delete q_;
}

void ClientHandler::operator() () {

		string line{};
		string cmd{};
		string name{};
		int x{0};
		int y{0};

		try {
			q_ = new Queue<Mission*>;
			*s_<< "Enter the name, ";
			*s_<<"and, optionally, the initial position.\n";
			*s_ >> line;
			istringstream in(line);
			in >> name >> x >> y;
			myR_= new Autonomous(e_, *q_, s_, name);
			//myR_= new Autonomous(e_, *q_, name);
			myR_->initPlace(x,y);

			//thread X(*myR_);  !!! Not good!
			thread X(ref(*myR_));
			X.detach();  // Try detaching to survive dying clients...


			*s_ << "Created and alive.\n";

			while( true ) {
				*s_ >> line;
				istringstream in(line);
				in >> cmd;

// Would a factory helped here?

				if (cmd=="go2") {
					in >> x >> y;
					q_->enqueue(new GoTo(*myR_, x, y));
				}
				else if	(cmd == "nap") {
					in >> x;
					q_->enqueue(new Nap(x));
				}
				else if (cmd == "term") {
					q_->enqueue(new Terminate());
					break;
				}
				else if (cmd == "N")
					q_->enqueue(new Step(*myR_, D::N, D::X));
				else if (cmd == "E")
					q_->enqueue(new Step(*myR_, D::X, D::E));
				else if (cmd == "S")
					q_->enqueue(new Step(*myR_, D::S, D::X));
				else if (cmd == "W")
					q_->enqueue(new Step(*myR_, D::X, D::W));
				else if (cmd == "NE")
					q_->enqueue(new Step(*myR_, D::N, D::E));
				else if (cmd == "NW")
					q_->enqueue(new Step(*myR_, D::N, D::W));
				else if (cmd == "SE")
					q_->enqueue(new Step(*myR_, D::S, D::E));
				else if (cmd == "SW")
					q_->enqueue(new Step(*myR_, D::S, D::W));

			}
//			X.join();
//			cout << "Joined." << endl;
			cout << "Terminated :(" << endl;
		}
		catch (SocketException & e) { cout << e.what() << endl;  }
		delete s_;  // Yes, no one will use this socket now...
}
