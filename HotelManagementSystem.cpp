#include<iostream>
using namespace std;

int main()
{
    int quant;
    int choice;

    int Qrooms=0, Qtowels=0, Qsoapbars=0, Qtoiletpaperrolls=0, Qsheets=0;

    int Srooms=0, Stowels=0, Ssoapbars=0, Stoiletpaperrolls=0, Ssheets=0;

    int Total_rooms=0, Total_towels=0, Total_soapbars=0, Total_toiletpaperrolls=0, Total_sheets=0;

    cout<<"\n\t Quantity of items in stock";
    cout<<"\n Rooms available:";
    cin>>Qrooms;
    cout<<"\n\t Quantity of towels:";
    cin>>Qtowels;
    cout<<"\n\t Quantity of soapbars:";
    cin>>Qsoapbars;
    cout<<"\n\t Quantity of toiletpaperrolls:";
    cin>>Qtoiletpaperrolls;
    cout<<"\n\t Quantity of sheets:";
    cin>>Qsheets;

    m:
    cout<<"\n\t\t\t Please select from the menu options.";
    cout<<"\n\n1) Rooms";
    cout<<"\n2) Towels";
    cout<<"\n3) Soapbars";
    cout<<"\n4) Toilet Paper Rolls";
    cout<<"\n5) Sheets";
    cout<<"\n6) Details of sales and inventory";
    cout<<"\n7) Exit";

    cout<<"\n\n Please enter your choice:";
    cin>>choice;

    switch(choice)
    {
        case 1:
            cout<<"\n\n Enter the number of rooms you would like: ";

            cin>>quant;
            if(Qrooms-Srooms >=quant)
            {
                Srooms=Srooms+quant;
                (Total_rooms= Total_rooms+quant*120);
                cout<<"\n\n\t\t" <<quant<<" room/rooms has/have been alloted to you!";

            }
            else
            
                cout<<"\n\tOnly"<<Qrooms-Srooms<<"Rooms remaining in hotel";
                break;

                case 2:
            cout<<"\n\n Enter the number of towels you would like: ";

            cin>>quant;
            if(Qtowels-Stowels >=quant)
            {
                Stowels=Stowels+quant;
                (Total_towels= Total_towels+quant*3);
                cout<<"\n\n\t\t" <<quant<<" towel/towels has/have been alloted to you!";

            }
            else
            
                cout<<"\n\tOnly"<<Qtowels-Stowels<<"Towels remaining in the hotel";
                break;

                case 3:
            cout<<"\n\n Enter the number of soapbars you would like: ";

            cin>>quant;
            if(Qsoapbars-Ssoapbars>=quant)
            {
                Ssoapbars=Ssoapbars+quant;
                (Total_soapbars= Total_soapbars+quant*1);
                cout<<"\n\n\t\t" <<quant<<" soapbar/soapbars has/have been alloted to you!";

            }
            else
            
                cout<<"\n\tOnly"<<Qsoapbars-Ssoapbars<<"Soap bars remaining in the hotel";
                break;

                case 4:
            cout<<"\n\n Enter the number of toilet paper rolls you would like: ";

            cin>>quant;
            if(Qtoiletpaperrolls-Stoiletpaperrolls>=quant)
            {
                Stoiletpaperrolls=Stoiletpaperrolls+quant;
                (Total_toiletpaperrolls= Total_toiletpaperrolls+quant*1.25);
                cout<<"\n\n\t\t" <<quant<<" toilet paper roll/toilet paper rolls has/have been alloted to you!";

            }
            else
            
                cout<<"\n\tOnly"<<Qtoiletpaperrolls-Stoiletpaperrolls<<"Toilet paper rolls remaining in the hotel";
                break;

                case 5:
            cout<<"\n\n Enter the number of sheets you would like: ";

            cin>>quant;
            if(Qsheets-Ssheets>=quant)
            {
                Ssheets=Ssheets+quant;
                (Total_sheets= Total_sheets+quant*1.25);
                cout<<"\n\n\t\t" <<quant<<" sheet/sheets has/have been alloted to you!";

            }
            else
            
                cout<<"\n\tOnly"<<Qsheets-Ssheets<<"Sheets remaining in the hotel";
                break;

                case 6:

                cout<<"\n\t\tDetails of sales and inventory";
                cout<<"\n\n Number of rooms we had : "<<Qrooms;
                cout<<"\n\n Number of rooms rented : "<<Srooms;
                cout<<"\n\n Remaining Rooms : "<<Qrooms-Srooms;
                cout<<"\n\n Total collection of rooms for the day : "<<Total_rooms;

                cout<<"\n\n Number of towels we had : "<<Qtowels;
                cout<<"\n\n Number of towels given : "<<Stowels;
                cout<<"\n\n Remaining towels : "<<Qtowels-Stowels;
                cout<<"\n\n Total distribution of towels for the day : "<<Total_towels;
                
                cout<<"\n\n Number of soap bars we had : "<<Qsoapbars;
                cout<<"\n\n Number of soap bars given : "<<Ssoapbars;
                cout<<"\n\n Remaining soap bars : "<<Qsoapbars-Ssoapbars;
                cout<<"\n\n Total distribution of soap bars for the day : "<<Total_soapbars;

                cout<<"\n\n Number of toilet paper rolls we had : "<<Qtoiletpaperrolls;
                cout<<"\n\n Number of toilet paper rolls given : "<<Stoiletpaperrolls;
                cout<<"\n\n Remaining toilet paper rolls : "<<Qtoiletpaperrolls-Stoiletpaperrolls;
                cout<<"\n\n Total distribution of toilet paper rolls for the day : "<<Total_toiletpaperrolls;

                cout<<"\n\n Number of sheets we had : "<<Qsheets;
                cout<<"\n\n Number of sheets given : "<<Ssheets;
                cout<<"\n\n Remaining sheets : "<<Qsheets-Ssheets;
                cout<<"\n\n Total distribution of sheets for the day : "<<Total_sheets;

                case 7:
                    exit(0);
                    
                    default:
                        cout<<"\n Please select the numbers referenced above!";
    }
    goto m;
}