/*
 * GoTo.cpp
 *
 *  Created on: Oct. 23, 2019
 *      Author: piotr
 */

#include "GoTo.h"


GoTo::GoTo(Autonomous& r, int x, int y)
: s_{r}, target_x_{x}, target_y_{y}
{}

GoTo::~GoTo() {
	// TODO Auto-generated destructor stub
}

void GoTo::searchStep() {

	RelPos nb;   // Will store neighbours' relative positions...
	bool push;

	// Could not come up with a better way to iterate through enum...
	std::vector<D> row{D::N, D::X, D::S};
	std::vector<D> col{D::E, D::X, D::W};

	pos_.x=s_.getX();
	pos_.y=s_.getY();

	visited_.push_back(pos_);

	for (auto i: row)
		for (auto j: col) {
			nb.x = i, nb.y = j;
			push=true;
			for (auto v: visited_)
				if ( v.x == pos_.x+int(i) and v.y == pos_.y+int(j)){
					push=false;
					break;
				}
			// Store relative position of neighbours not visited...
			if (push and (nb.x != D::X or nb.y != D::X))
				toTry_.push(nb);

		}

}

bool GoTo::doit() {
	RelPos nb;
	searchStep();
	while (target_x_ != pos_.x or target_y_ != pos_.y) {
		if (toTry_.empty()) return false;
		nb=toTry_.top();
		toTry_.pop();
		while (! s_.move(nb.x, nb.y)) {
			if (toTry_.empty()) return false;
			nb=toTry_.top();
			toTry_.pop();
		}
		searchStep();
		std::this_thread::sleep_for(std::chrono::milliseconds(200));
		//::sleep(1);
	}


		return true;


}
