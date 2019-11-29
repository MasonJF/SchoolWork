/*
 * Autonomous.cpp
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#include "Autonomous.h"

#include <iostream>
#include <unistd.h>


Autonomous::Autonomous(Environment& e, Queue<Mission*>& q, std::string n)
: Entity(e, n), q_{q}, s_{nullptr}, load_{nullptr}
{
}

Autonomous::Autonomous(Environment& e, Queue<Mission*>& q, ServerSocket * s, std::string n)
: Entity(e, n), q_{q}, s_{s}, load_{nullptr}
{
}

Autonomous::~Autonomous() {
	// TODO Auto-generated destructor stub
}

bool Autonomous::move(D dx, D dy) {

    return e_.place(this, x_ + int(dx), y_ + int(dy)); //Simplified.

}

void Autonomous::operator() () {
	Mission * a{nullptr};
	while (true) {
		a=q_.dequeue();
		if (! a->doit()) {   // Not sure about that...
			delete a;
			if (s_)
				try {
					*s_ << "I've failed. Committing seppuku :(\n:" ;
				}
				catch (SocketException & e) {}
			else
				std::cout << std::this_thread::get_id() << " I've failed. Committing seppuku :(" << std::endl;
			break;
		}
		else {
		delete a;
		// Maybe each mission should have a mission code?
		if (s_)
			*s_ << " Mission completed.\n";
		else
			std::cout << std::this_thread::get_id() << " Mission completed.\n" << std::endl;
		}

		std::this_thread::sleep_for(std::chrono::milliseconds(2500));
	}
	std::cout << std::this_thread::get_id() << " is done." << std::endl;
}
