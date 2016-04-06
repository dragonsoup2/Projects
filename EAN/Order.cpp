#include <iostream>
#include <cstring>
#include "Order.h"

using namespace std;

Order::Order()
{
	e = EAN();
	quantity = 0;
	delivered = 0;
}

Order::Order(const EAN& ea)
{
	e = ea;
	quantity = 0;
	delivered = 0;
}

EAN& Order::getEAN()
{
	return e;
}

int Order::outstanding() const
{
	int remain;
	remain = quantity - delivered;

	return remain;
}

bool Order::add(istream& is)
{
	int addup;
	bool check;

	cout << "Quantity (0 to quit) : ";
	is >> addup;

	if(addup > 0)
	{
		quantity = quantity + addup;
		check = true;
	}
	else
	{
		check = false;
	}

	return check;
}

bool Order::add(int n)
{
	bool check;

	if(e.empty() != true && n > 0)
	{
		quantity = quantity + n;
		check = true;
	}
	else
	{
		check = false;
	}

	return check;
}

bool Order::receive(istream& is)
{
	int sent, total = 0;
	bool check;

    do
    {
        cout << "Quantity (0 to quit) : ";
        is >> sent;

        total = sent + delivered;
        if(sent < 0)
        {
            cout << "Enter a positive number.  Try again." << endl;
            check = false;
        }
        else if(sent == 0)
        {
            cout << "**No delivery recorded!" <<endl;
            check = false;
        }
        else if(total > quantity)
        {
            cout << total << " not on order.  Only " << quantity << " are on order.  Try again." << endl;
            check = false;
        }
        else if(total <= quantity)
        {
            delivered = total;
            check = true;
        }
    }while(sent != 0 && check == false);

	return check;
}

void Order::display(ostream& os) const
{
	os << setw(17) << right << e << setw(9) << quantity << setw(11) << delivered << " ";
}

ostream& operator<<(ostream& os, const iOrder& od)
{
	od.display(os);
	return os;
}
Order::~Order()
{

}
