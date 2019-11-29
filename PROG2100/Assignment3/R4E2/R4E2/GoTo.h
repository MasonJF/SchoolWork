/*
 * GoTo.h
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#ifndef GOTO_H_
#define GOTO_H_

#include <stack>
#include <vector>
#include "Autonomous.h"
#include "Mission.h"

class GoTo: public Mission {
public:
	GoTo(Autonomous&, int, int);
	virtual ~GoTo();
	bool doit();
private:
	Autonomous& s_;
	int target_x_;
	int target_y_;

	struct Pos {
		int x;
		int y;
		// Probably not needed...
		bool operator== (Pos p) {
			return p.x == x and p.y == y;
		}
	};

	struct RelPos {
		D x;
		D y;
	};

	Pos pos_;
	std::vector<Pos> visited_;
	std::stack<RelPos> toTry_;

	void searchStep();
};

#endif /* GOTO_H_ */
