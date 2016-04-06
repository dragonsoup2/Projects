#include <iostream>
#include "EAN.h"

class iOrder
{
	public:
		virtual EAN& getEAN() = 0;
		virtual bool add(int) = 0;
		virtual bool add(std::istream&) = 0;
		virtual bool receive(std::istream&) = 0;
		virtual int outstanding() const = 0;
		virtual void display(std::ostream&) const = 0;
};
