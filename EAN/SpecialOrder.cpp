#include "SpecialOrder.h"
#include <iostream>
#include <cstring>
using namespace std;

SpecialOrder::SpecialOrder():Order()
{
	e = EAN();
	quantity = 0;
	delivered = 0;
	desc = '\0';
}
SpecialOrder::SpecialOrder(const EAN& ea, const char* de):Order(ea)
{
	e = ea;
	quantity = 0;
	delivered = 0;
	if(strlen(de) <= 60)
	{
		desc = new char[strlen(de) + 1];
		strcpy(desc, de);
	}
	else
	{
		desc = '\0';
	}
}
bool SpecialOrder::add(istream& is)
{
	bool check = false;

	do
	{
		cout << "Quantity (0 to quit) : ";
		is >> quantity;

		if(quantity == 0)
		{
			cout << "No quantity is added" << endl;
		}
		else if(quantity < 0)
		{
			cout << "Quantity should be greater than 0" << endl;
		}
		else if(quantity > 0)
		{
			is.ignore();
			cout << "Instructions : ";
			is.getline(desc, 59);
			if(strlen(desc) > 60)
			{
				cout << "Description should be less than or equal to 60 characters long" << endl;
			}
			else
			{
				check = true;
			}
		}
	}while(quantity != 0 && check == false);
	return check;
}
void SpecialOrder::display(ostream& os) const
{
	Order::display(os);
	os << desc << endl;
}
SpecialOrder::SpecialOrder(const SpecialOrder& sp)
{
	e = sp.e;
	quantity = sp.quantity;
	delivered = sp.delivered;
	desc = new char[strlen(sp.desc) + 1];
	strcpy(desc, sp.desc);
}
SpecialOrder& SpecialOrder::operator=(const SpecialOrder& sp)
{
	delete[] desc;
	e = sp.e;
    quantity = sp.quantity;
	delivered = sp.delivered;
	desc = new char[strlen(sp.desc) + 1];
	strcpy(desc, sp.desc);
	return *this;
}
SpecialOrder::~SpecialOrder()
{
	delete[] desc;
}







