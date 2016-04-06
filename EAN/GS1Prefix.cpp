//GS1Prefix.cpp
#include "GS1Prefix.h"
using namespace std;
//save all area codes and these ranges of publisher code
//into member variables of Prefix class.
Prefix::Prefix(const char* filename)
{
     bool rc = false;
     if (filename != '\0')
     {
         std::ifstream file(filename);
         if (file.is_open())
         {
             int no = 0;
             while (file.good())
             {
                 file >> area[no] >> pubLow[no] >> pubHgh[no];
                 if (file.good())
                 {
                     pubLen[no] = std::strlen(pubLow[no]);
                     no++;
                 }
             }
             if (no > 0)
             {
                 rc = true;
                 num = no;
             }
         }
     }
 }

//checks if area number is a registered area
bool Prefix::isRegistered(int ar) const
{
    bool areafound = false, keepchecking = true;
    int range = 0;
    while(range < MAX && keepchecking)
	{
        if(area[range] == ar)
		{	
			//cout << "area 1 " << area << endl;
			//cout << "area 2 " << fp->area[range] << endl;
            areafound = true;
            keepchecking = false;
        }
		range++;
    }
    return areafound;
}

//finds the minimum number of digits for a given area
int Prefix::minNoDigits(int ar) const
{
    int range = 0;
	bool check = true;
    int mindigits = 0;

    //rewind(fp);
	if(ar >= 0)
	{
		while(range < MAX && check)
		{
			if(area[range] == ar)
			{			
				mindigits = pubLen[range];
				check = false;
			}
				range++;
		}
	}
	
    return mindigits;

}
//check if publisher code is in the range.
bool Prefix::isRegistered(int ar, const char* publisher) const
{
    int range = 0;
    int mindigits, publisherdigits;
    bool isregist = false;

    mindigits = minNoDigits(ar);

    //rewind(fp);

    while(range < MAX && isregist == false)
	{
        if(area[range] == ar)
		{
            publisherdigits = strlen(publisher);
            if(atoi(pubLow[range]) <= atoi(publisher) && atoi(publisher) <= atoi(pubHgh[range]) && publisherdigits >= mindigits)
			{

                isregist = true;
            }
				//cout << "low " <<atoi(fp->pubLow[range])<<endl;
				//cout << "pub " << atoi(publisher) << endl;
				//cout << "high " << atoi(fp->pubHgh[range]) << endl;
        }
		range++;
    }
    return isregist;
}
