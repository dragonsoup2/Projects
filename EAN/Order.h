#include "iOrder.h"

class Order:public iOrder
{
	protected:
		EAN e;
		int quantity;
		int delivered;

	public:
		Order();
		Order(const EAN&);
		EAN& getEAN();
		int outstanding() const;
		bool add(istream&);
		bool add(int);//add qty as much as that int.
		bool receive(istream&);//display amount of qty that publisher delivered.
        virtual void display(ostream&) const;
		virtual ~Order();
};
ostream& operator<<(ostream&, const iOrder&);
