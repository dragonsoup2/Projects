//EAN.cpp
#include <iostream>
using namespace std;
#include <iomanip>
#include <cstring>
#include <stdio.h>
#include <stdlib.h>
#include "GS1Prefix.h"
#include "EAN.h"

//create an empty constructure of EAN
EAN::EAN()
{
	ean[0] = '\0';
	area[0] = '\0';
	publisher[0] = '\0';
	title[0] = '\0';
	stylee = '-';
	emptyy = true;
	isRegister = false;
}
//create an constructure with parameters of EAN
EAN::EAN(const char* str, const Prefix& list)
{
	bool check;

	strcpy(ean, str);

	check = isValid(str);
	if(check)
	{
		isRegister = isRegistered(list);
		emptyy = false;
	}
	else if(!check)
	{
		ean[0] = '\0';
		area[0] = '\0';
		publisher[0] = '\0';
		title[0] = '\0';
		stylee = '\0';
		emptyy = true;
		isRegister = false;
	}
}

//check if this EAN object has information of EAN
//if there is, return false. if not, return true
bool EAN::empty() const
{
	//cout << "here empty" << endl;
	//cout << "empty = " << emptyy << endl;
	return emptyy;
}
//decide what decoration will be used to print EAN
void EAN::style(char sty)
{
	if(sty == '\n')
	{
		stylee = '\0';
	}
	else
	{
		stylee = sty;
	}

}
//copy EAN into char pointer without decoration
void EAN::toStr(char* str) const
{
	//cout << "ean " << ean << endl;
	if(stylee != '-' || stylee != ' ' || stylee != '\0')
	{
		strcpy(str, ean);
		//cout << "str "<< str << endl;
		//cout << "tostr = " << str << endl;
	}
}
//if EAN object is not empty and is registered, modify EAN with decoration.
void EAN::toStrWithStyle(char* str) const
{
	//str = new char[18];
	char extra[4];
	char atTheEnd[2] = {checkdigit, '\0'};

	if(emptyy == false && isRegister == true )
	{
		strncpy(extra, ean, 3);
		extra[3] = '\0';
		strcpy(str, extra);
		strncat(str, &stylee, 1);
		if(area != '\0')
		{
			strcat(str, area);
			//cout << "area " << area << endl;
			strncat(str, &stylee, 1);
		}
		if(publisher != '\0')
		{
			strcat(str, publisher);
			//cout << "publisher " << publisher << endl;
			strncat(str, &stylee, 1);
		}
		if(title != '\0')
		{
			strcat(str, title);
			//cout << "title " << title << endl;
			strncat(str, &stylee, 1);
			strcat(str, atTheEnd);
			//cout << "atTheEnd " << atTheEnd << endl;
		}
	}
	else
	{
		strcpy(str, ean);
	}
}
//print EAN through toStrWithStyle or toStr
void EAN::display(ostream& os) const
{
    char str[18];
	//cout << "isRegister " << isRegister << endl;
    if(isRegister == true)
	{
	//os << "ean2 " << ean << endl;
        this->toStrWithStyle(str);
		//os << "empty " << emptyy << endl;
        os << setw(17) << right << str;
    }
	else
	{
        this->toStr(str);
		//os << "empty " << emptyy << endl;
        os << setw(17) << right << str;
    }
}
//take EAN from the user and check if EAN has 13 length long and valid checkdigit
bool EAN::read(istream& is, const Prefix& list)
{
	char str[14];
	bool check4 = true;
	bool stop = true;

	do
	{
		cout << "EAN (0 to quit) : ";
		is >> str;

		if(strcmp(str, "0") == 0)
		{
			check4 = false;
			stop = false;
		}
		else if(strlen(str) != 13)
		{
			cout << "Too few characters. Try again." << endl;
			this->emptyy = true;
			this->isRegister = false;
		}
		else if(isValid(str) == false)
		{

			this->emptyy = true;
			this->isRegister = false;
			//cout << "isRegister " << isRegistered() << endl;
			//cout << "empty " << empty() << endl;
			cout << "Invalid check digit. Try again." << endl;
		}
		else if(isValid(str) == true)
		{
			//cout<<"here"<<endl;
			strcpy(ean, str);
			isRegister = this->isRegistered(list);
			stop = false;
			check4 = true;
			//cout << "check4 = " << check4 << endl;
			//cout << "emtpy = " << emptyy << endl;
		}
	}while(stop);

	return check4;
}
//if EAN is registered, return true. if not, return false.
bool EAN::isRegistered() const
{
	//cout << "2. isRegistered()" << isRegister << endl;
	return isRegister;
}
//check EAN if it has a valid checkdigit.
bool isValid(const char* str)
{
    bool valid = false;
    int sum = 0;
    int i, j = 3;
    if(str != NULL)
    {
        for(i=0; i < 13; i++)
        {
			if((i % 2) == 1)
			{
				sum += (str[i]-'0')*j;
			}
			else if((i % 2) == 0)
			{
				sum += (str[i]-'0');
			}
        }
        if((sum % 10) == 0)
        {
            valid = true;
        }
    }
    return valid;
}

//checks if EAN is a registered number in the prefixtable.
bool EAN::isRegistered(const Prefix& fp)
{
    bool farea = false;
    bool fpub = false;

    char areatmp[5] = {0};
    char pubtmp[8] = {0};
    char titletmp[7] = {0};

    int len;
    int lenpub;
    int lentitle;
    int areano;
    int pospub, postitle;

		for(int i=3; i < 8 && farea == false; i++)
		{
			len = strlen(areatmp);
			areatmp[len] = ean[i];
			areatmp[len+1] = '\0';
			areano = atoi(areatmp);
			farea = fp.isRegistered(areano);
			//cout << "area 3 " << areatmp << endl;
			pospub = i + 1;
		}
		strcpy(area,areatmp);

	isRegister = farea;
    if(isRegister != false)
    {
        for(int i = pospub; i < 11 && fpub == false; i++)
        {
            lenpub = strlen(pubtmp);
            pubtmp[lenpub] = ean[i];
            pubtmp[lenpub+1] = '\0';
			//cout << "publisher 1" << pubtmp << endl;
            //cout << "---------------------------------------" << endl;
            //cout << "pubtmpdigit : " << pubtmp << endl;
            fpub = fp.isRegistered(atoi(area),pubtmp);
            postitle = i + 1;
        }

        isRegister = fpub;

        for(int i = postitle; i < 13; i++)
        {

			if(i == 12)
			{
				checkdigit = ean[i];
			}
			else
			{
				lentitle = strlen(titletmp);
				titletmp[lentitle] = ean[i];
				titletmp[lentitle+1] = '\0';
			}
        }
		strcpy(publisher, pubtmp);
		strcpy(title, titletmp);

    }
	if(isRegister == true)
	{

		stylee = '-';
	}
	emptyy = false;
    //cout << "title ---->" << titletmp << endl;
    return isRegister;
}

bool operator==(const EAN& left, const EAN& right)
{
    bool check = false;

    if(&left != &right)
    {
        if(strcmp(left.ean, right.ean) == 0)
        {
            check = true;
        }
    }

    return check;
}

ostream& operator<<(ostream& os, const EAN& ea)
{
    ea.display(os);

    return os;
}
