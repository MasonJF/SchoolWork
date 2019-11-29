/*
 * Salon.h
 *
 *  Created on: 2012-10-07
 *      Author: piotr
 */

#ifndef SALON_H_
#define SALON_H_

#include "Bed.h"
class Cust;

class Salon  /* a Tanning Salon */
{
public:
	Salon(int = 3);
	Salon(const Salon&);
	bool enter(Cust * );

	Salon operator()() {
        for (int i = 0; i < noOfBeds_; ++i) {
            if(equip_[i]->isIt(equip_[i]->enough())) { // Last ditch effort to figure this out, failed.
                std::cout << equip_[i]->howLong() << endl;
            }
        }
        return Salon();
    }

private:
	int noOfBeds_;
	Bed **equip_;
};

#endif /* SALON_H_ */
