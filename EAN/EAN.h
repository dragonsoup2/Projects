//EAN.h
#include <iostream>
#include <iomanip>
#include <cstring>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

using namespace std;

class Prefix;

class EAN
{
	char ean[14];
	char area[5];
	char publisher[8];
	char title[7];
	char stylee;
	char checkdigit;
	bool emptyy;
	bool isRegister;

	public:
		EAN();
		EAN(const char* str, const Prefix& list);
		bool isRegistered() const;
		bool empty() const;
		void style(char);
		void toStr(char* str) const;
		void toStrWithStyle(char* str) const;
		void display(ostream&) const;
		bool read(std::istream& is, const Prefix& list);
		friend bool operator==(const EAN&, const EAN&);
	private:
		bool isRegistered(const Prefix& list);
		//bool isRegistered(const Prefix* fp, const char* str, char area[], char publisher[], char title[]);
};
		bool isValid(const char* str);
		ostream& operator<<(ostream&, const EAN&);
