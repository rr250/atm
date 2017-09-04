import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class ATM
{
static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException
    {
        int note2k=0, note500=0, note100=0, amt=0,l=1;
        while(l==1)
        {
            System.out.println("Welcome to the ATM \n Press \n 1 for manager \n 2 for customer \n 3 to view Possible denominations \n Any other no. to exit");
            int m = s.nextInt();
            switch (m)
            {
                case 1:
                    System.out.println("Enter Password");
                    if (s.nextInt()==1234)
                    {
                        System.out.println("No. of 2000 notes="+note2k+"\nNo. of 500 notes="+note500+"\nNo. of 100 notes="+note100+"\nAMOUNT"+amt);
                        System.out.println("Do you want to add cash? \n 1 for yes \n 2 for no");
                        if (s.nextInt()==1)
                        {
                            int namt=0;
                            System.out.println("Enter the amount:");
                            namt = s.nextInt();
                            if(namt%100==0)
                            {
                                amt = amt + namt;
                                System.out.println("Amount="+amt);
                                note2k= (int)(note2k+(0.25*namt)/2000);
                                note500= (int)(note500+(0.5*namt)/500);
                                note100= (int)(note100+(0.25*namt)/100)+(int)(((int)((0.25*namt)%2000)+(int)((0.5*namt)%500)+(int)((0.25*namt)%100))/100);
                                System.out.println("No. of 2000 notes="+note2k+"\nNo. of 500 notes="+note500+"\nNo. of 100 notes="+note100);
                            }
                            else
                                System.out.println("Enter cash in multiple of 100");
                        }

                    }
                    else
                        System.out.println("Invalid");
                    break;
                case 2:

                        System.out.println("Insert the card");
                        System.out.println("Processing...");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("Enter PIN");
                        if(s.nextInt()==1234)
                        {
                            int wdraw=0;
                            System.out.println("Enter the amt you want to withdraw:");
                            wdraw=s.nextInt();
                            if(wdraw>25000||wdraw>amt||wdraw%100!=0||note2k<0||note500<0||note100<=0||amt<100)
                                System.out.println("Amount more than 25000 or insufficient amount in atm or Invalid(not a multiple of 100)");
                            else
                            {
                                int nnote2k=0,nnote500=0,nnote100=0;
                                if(note2k>0)
                                {
                                    note2k= (int)(note2k-(0.25*wdraw)/2000);
                                    nnote2k= (int)((0.25*wdraw)/2000);
                                }
                                if(note500>0)
                                {
                                    note500= (int)(note500-(0.5*wdraw)/500);
                                    nnote500= (int)((0.5*wdraw)/500);
                                }
                                if(note100>0&&note2k>0&&note500>0)
                                {
                                    note100= (int)(note100-(0.25*wdraw)/100)-((int)(((int)(note2k+(0.25*wdraw)%2000)+(int)(note500+(0.5*wdraw)%500)+(int)(note100+(0.25*wdraw)%100))/100));
                                    nnote100= (int)((0.25*wdraw)/100)+(int)(((int)((0.25*wdraw)%2000)+(int)((0.5*wdraw)%500)+(int)((0.25*wdraw)%100))/100);
                                }
                                while(wdraw!=(nnote2k*2000+nnote500*500+nnote100*100))
                                {
                                    note100--;
                                    nnote100++;
                                }
                                amt=amt-wdraw;
                                System.out.println("No. of 2000 notes="+nnote2k+"\nNo. of 500 notes="+nnote500+"\nNo. of 100 notes="+nnote100);
                            }
                        }
                        else
                            System.out.println("Invalid");
                    break;
                case 3 :
                    int damt=0,e=0,f=0,g=0;
                    System.out.println("Enter the amount:");
                            damt = s.nextInt();
                            for(e=0;2000*e+500*f+100*g<=damt;e++)
                            {
                                for(f=0;2000*e+500*f+100*g<=damt;f++)
                                {
                                    for(g=0;2000*e+500*f+100*g<=damt;g++)
                                    {
                                        if(2000*e+500*f+100*g==damt)
                                            System.out.println("No. of 2000 notes="+e+"\nNo. of 500 notes="+f+"\nNo. of 100 notes="+g+"\n  \n  \n" );
                                    }
                                    g=0;
                                }
                                f=0;
                            }
                    break;        
                               
                default:
                    System.out.println("Invalid \nExiting");
                    l=0;
                    break;
            }
        }
    }
}
