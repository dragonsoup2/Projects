#include "Order.h"

class SpecialOrder:public Order
{
	char* desc;

	public:
		SpecialOrder();
		SpecialOrder(const EAN&, const char*);
		bool add(istream&);
		void display(ostream&) const;
		SpecialOrder(const SpecialOrder&);
		SpecialOrder& operator=(const SpecialOrder&);
		~SpecialOrder();
};
