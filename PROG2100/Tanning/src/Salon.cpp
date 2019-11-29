/*
 * Salon.cpp
 *
 *  Created on: 2012-10-07
 *      Author: piotr
 */

#include "Salon.h"


Salon::Salon(int n)
: noOfBeds_(n), equip_(new Bed * [n])
{
	for (int i=0; i < noOfBeds_; i++ )
		equip_[i] = new Bed;
}

Salon::Salon(const Salon& s)
: noOfBeds_(s.noOfBeds_), equip_(new Bed * [noOfBeds_])
{
	for (int i=0; i < noOfBeds_; i++ ) {
		equip_[i] = new Bed;
	}
}


bool Salon::enter(Cust * customer )
{
	for (int i=0; i < noOfBeds_; i++ ) {
        if (equip_[i]->layDown(customer))
            return true;
    }
	return false;
}

