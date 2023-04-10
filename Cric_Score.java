import java.util.Scanner;
import java.io.*;
public class Cric_Score extends ti
{
    String twin;
    String tname1="";//team name1
    String tname2="";//team name2
    String tmem1[][]=new String[3][11];//team member
    String tmem2[][]=new String[3][11];
    String otmem1[]=new String[11];//out team member:checks whether team member is out or not
    String otmem2[]=new String[11];
    int rtmem1[][]=new int[3][11];//team member run
    int rtmem2[][]=new int[3][11];
    int btmem1[]=new int[11];//team member balls played
    int btmem2[]=new int[11];
    double strkbat1[]=new double[11];
    double strkbat2[]=new double[11];
    int orwtmem1[][]=new int[3][11];
    int orwtmem2[][]=new int[3][11];
    int tre1;
    int tre2;
    int run1;
    int run2;
    int outno1;
    int outno2;
    String battmem[][]=new String[3][11];/**NAME, WAY OF WICKET, WICKET TAKER*/ //batting team member
    String bowltmem[]=new String[11];//bowling team member
    String obattmem[]=new String[11];//out team member:checks whether team member is out or not
    int rbattmem[][]=new int[3][11];/** RUNS, FOUR, SIX*///runs of batting team member 
    int bbattmem[]=new int[11];//balls of batting team member
    double strkbat[]=new double[11];
    int orwbowltmem[][]=new int[3][11];//Over, Run, Wicket of bowling team member 
    //int rbowltmem[]=new int[11];//runs made in over
    String tosswin="";
    String tossloose="";
    String tosschoose="";
    String tbat="";//batting team
    String tbowl="";//bowling team
    int over=0;//current over
    int tover=0;
    int run=0;
    int ball=1;
    int rb=0;//run per ball
    int rbe=0;//checks which extra is it
    int re=0;//current extra runs
    int tre=0;//total extra runs
    int out_way;
    int outno;
    int bowlerno;
    int oldbowlno=-1;
    int oldbatno1=-1;
    int oldbatno2=-1;
    String bowler;//bowler of that over
    int batnostr;//striker batsman number
    String batstr;//batsman striker
    int batnonstr;//non-striker batsman number
    String batnstr;//non-batsman striker
    int outrun;//runs made during run out
    int outstr;//did the striker get out during run out
    int temp1;//temporary
    String temp2;//temporary string "for run out" and "graph entering"
    int a;//temporary
    char enter;//temporary "check for help in runs per ball"
    int newbatno;
    int weather;
    int lenmax1;
    int lenmax2;
    int target;
    int result;
    int o=-1;

    public static void main()throws InterruptedException, IOException
    {
        Cric_Score ob=new Cric_Score();
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        Scanner sc=new Scanner(System.in);
        ob.ti();
        Thread.sleep(1000);
        System.out.println("Press Enter to Start");
        char enter=(char)(in.read());  
        System.out.print("\f");
        ob.members();
        System.out.print("\f");

        ob.logic();

        String temp2="";
        System.out.println("\nDo you wish to see scorecard?");
        temp2=sc.next();
        if(temp2.compareToIgnoreCase("yes")==0)
        {
            System.out.print("\f");
            ob.Scorecard2();
        }
        System.out.println("\f");
        System.out.print("\n\n\n\n\n\n\t\t\t\t\t\t");
        ob.Innings();
        ob.Innings2();
        ob.Innings3();

        System.out.print("\f");
        ob.logic();
        System.out.println("Press Enter to exit");
        char temp3=(char)(in.read());
        ob.Innings2();
        ob.result();

        int scn=0;//Scorecard number
        int cscn=0;
        System.out.println("\nDo you wish to see scorecard?");
        temp2=sc.next();
        for(int i=0;i<5;i++)
        {
            if(i!=0)
            {
                System.out.println("\nDo you wish to see scorecard again?");
                temp2=sc.next();
            }
            if(temp2.compareToIgnoreCase("yes")==0)
            {
                cscn=ob.askscorecard1(scn);
                if(cscn==1)
                    ob.Scorecardt1();
                else
                    ob.Scorecardt2();
            }
            else
            {
                break;
            }
        }

        scn=0;
        cscn=0;
        System.out.println("Do you wish to see Team wise analysis?");
        temp2=sc.next();
        for(int i=0;i<5;i++)
        {
            if(i!=0)
            {
                System.out.println("\nDo you wish to see Team wise analysis again?");
                temp2=sc.next();
            }
            if(temp2.compareToIgnoreCase("yes")==0)
            {
                cscn=ob.askscorecard2(scn);
                if(cscn==1)
                    ob.ScorecardAnalysist1();
                else
                    ob.ScorecardAnalysist2();
            }
            else
            {
                break;
            }
        }
        ob.ty();
    }

    public int askscorecard1(int scn)throws IOException
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Select the team");
        System.out.println("1.Innings 1\n2.Innings 2");
        int temp1=sc.nextInt();
        if(temp1==1)
            scn=1;

        else if(temp1==2)
            scn=2;            

        return scn;
    }

    public int askscorecard2(int scn)throws IOException
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Select the team");
        System.out.println("1."+tname1+"\n2."+tname2);
        int temp1=sc.nextInt();
        if(temp1==1)
            scn=1;

        else if(temp1==2)
            scn=2;            

        return scn;
    }

    public void Innings()throws InterruptedException, IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);

        String na="INNINGS BREAK";
        for(int i=0;i<na.length();i++)
        {
            char ch=na.charAt(i);
            System.out.print(ch);
            Thread.sleep(250);
        }

        System.out.println("\n\n\n\n\n\nPress Enter if Innings Break is over");
        enter=(char)(in.read());        
    }

    public void Innings2()
    {
        for(int i=1;i<3;i++)
        {
            for(int j=0;j<11;j++)
            {
                if(tbat.equalsIgnoreCase(tname1))
                    tmem1[i][j]=battmem[i][j];
                else
                    tmem2[i][j]=battmem[i][j];
            }
        }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<11;j++)
            {
                if(tbat.equalsIgnoreCase(tname1))
                    otmem1[j]=obattmem[j];
                else
                    otmem2[j]=obattmem[j];

                if(tbat.equalsIgnoreCase(tname1))
                    rtmem1[i][j]=rbattmem[i][j];
                else
                    rtmem2[i][j]=rbattmem[i][j];

                if(tbat.equalsIgnoreCase(tname1))
                    btmem1[j]=bbattmem[j];
                else
                    btmem2[j]=bbattmem[j];

                if(tbowl.equalsIgnoreCase(tname1))
                    orwtmem1[i][j]=orwbowltmem[i][j];
                else
                    orwtmem2[i][j]=orwbowltmem[i][j];

                if(tbat.equalsIgnoreCase(tname1))
                    strkbat1[j]=strkbat[j];
                else
                    strkbat2[j]=strkbat[j];

            }
        }
        if(tbat.equalsIgnoreCase(tname1))
            tre1=tre;
        else
            tre2=tre;

        if(tbat.equalsIgnoreCase(tname1))
            run1=run;
        else
            run2=run;
        target=run+1;

        if(tbat.equalsIgnoreCase(tname1))
            outno1=outno;
        else
            outno2=outno;

    }

    public void Innings3()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<11;j++)
            {
                battmem[i][j]="";
                rbattmem[i][j]=0;
                orwbowltmem[i][j]=0;
            }
        }
        for(int i=0;i<11;i++)
        {
            obattmem[i]="";
            bbattmem[i]=0;
            strkbat[i]=0;
        }
        run=0;
        ball=1;
        rb=0;
        rbe=0;
        re=0;
        tre=0;
        out_way=0;
        outno=0;
        bowlerno=-1;
        oldbowlno=-1;
        oldbatno1=-1;
        oldbatno2=-1;
        bowler="";
        batnostr=-1;
        batstr="";
        batnonstr=-1;
        batnstr="";
        outrun=0;
        outstr=0;
        temp1=0;
        temp2="";
        a=0;
        enter=' ';
        newbatno=-1;
        tosschoose=tosschoose.toLowerCase();
        if(tosschoose.compareTo("bat")==0)
        {
            tbat=tossloose;
            tbowl=tosswin;
        }
        else
        {
            tbat=tosswin;
            tbowl=tossloose;
        }
    }

    public void members()throws InterruptedException
    {
        //Cric_Score ob=new Cric_Score();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of the teams");
        System.out.print((char)(8921));
        tname1=sc.nextLine();
        System.out.print((char)(8921));
        tname2=sc.nextLine();

        System.out.println("Enter the name of the players from team "+tname1);
        for(int i=0;i<11;i++)
        {
            System.out.print((char)(9775));
            tmem1[0][i]=sc.nextLine();
        }
        System.out.print("\f");
        System.out.println("Enter the name of the players from team "+tname2);
        for(int i=0;i<11;i++)
        {
            System.out.print((char)(9775));
            tmem2[0][i]=sc.nextLine();
        }
        System.out.print("\f");

        System.out.println("Enter the team who won the toss");
        a=0;
        do
        {
            tosswin=sc.next();
            if(tosswin.equalsIgnoreCase(tname1) || tosswin.equalsIgnoreCase(tname2))
                a=1;
            else
            {
                System.out.println("Please check for the input");
                System.out.println("Team names: "+tname1+"    "+tname2);
            }
        }
        while(a==0);

        if(tosswin.compareToIgnoreCase(tname1)==0)
        {
            tossloose=tname2;
            tosswin=tname1;
            /*tmem1[11]=1;//tmem[12]==1;win  tmem[12]==0;loose
            tmem2[11]=0;*/
        }
        else
        {
            tossloose=tname1;
            tosswin=tname2;
            /*tmem1[0][11]=1;//tmem[12]==1;win  tmem[12]==0;loose
            tmem2[0][11]=0;*/
        }
        System.out.println("Is the weather:");
        System.out.println("1."+(char)(9728)+"Sunny"+(char)(9728));
        System.out.println("2."+(char)(9729)+"Overcast"+(char)(9729));
        System.out.println("Enter the number accordingly");
        weather=sc.nextInt();

        a=0;
        System.out.println("What did "+tosswin+" choose[Bat/Bowl]");
        do
        {
            tosschoose=sc.next();
            tosschoose=tosschoose.toLowerCase();
            if(tosschoose.equalsIgnoreCase("bat") || tosschoose.equalsIgnoreCase("bowl"))
                a=1;
            else
                System.out.println("Please check for the input");
        }
        while(a==0);

        tosschoose=tosschoose.toLowerCase();
        if(tosschoose.compareToIgnoreCase("bat")==0)
        {
            tbat=tosswin;
            tbowl=tossloose;
        }
        else
        {
            tbat=tossloose;
            tbowl=tosswin;
        }
        System.out.println("Enter the total no of overs to be played");
        a=0;
        do
        {
            tover=sc.nextInt();
            if(tover!=0)
                a=1;
            else
                System.out.println("Please check for the input");
        }
        while(a==0);
        System.out.println("Batting team "+tbat);
        System.out.println("Bowling team "+tbowl);
        System.out.println("The total no of overs to be played "+tover);

        lenmax1="Bowler".length();
        for(int i=0;i<11;i++)
        {
            if(lenmax1<tmem1[0][i].length())
                lenmax1=tmem1[0][i].length();
        }

        for(int i=0;i<11;i++)
        {
            for(int j=tmem1[0][i].length();j<lenmax1;j++)
                tmem1[0][i]=tmem1[0][i]+" ";
        }

        lenmax2="Bowler".length();
        for(int i=0;i<11;i++)
        {
            if(lenmax2<tmem2[0][i].length())
                lenmax2=tmem2[0][i].length();
        }

        for(int i=0;i<11;i++)
        {
            for(int j=tmem2[0][i].length();j<lenmax2;j++)
                tmem2[0][i]=tmem2[0][i]+" ";
        }
        Thread.sleep(1000);
    }

    public void logic()throws InterruptedException, IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        Cric_Score ob=new Cric_Score();

        int reo[]=new int[tover];//run in each over
        String ro="";//run per ball in an over
        if(tbat.compareTo(tname1)==0)
        {
            for(int i=0;i<11;i++)
            {
                battmem[0][i]=tmem1[0][i];
                bowltmem[i]=tmem2[0][i];
                obattmem[i]="Remaining";
                battmem[1][i]="Did not Bat";
                strkbat[i]=0.0;
            }
        }
        else
        {
            for(int i=0;i<11;i++)
            {
                battmem[0][i]=tmem2[0][i];
                bowltmem[i]=tmem1[0][i];
                obattmem[i]="Remaining";
                battmem[1][i]="Did not Bat";
                strkbat[i]=0.0;
            }
        }

        Scanner sc=new Scanner(System.in);
        System.out.println("Choose the batsman(striker) from the following list");
        if(tbat.compareTo(tname1)==0)
        {
            for(int i=0;i<11;i++)
                System.out.println(i+"."+tmem1[0][i]);
        }
        else
        {
            for(int i=0;i<11;i++)
                System.out.println(i+"."+tmem2[0][i]);
        }

        a=0;
        do
        {
            batnostr=sc.nextInt();
            if(batnostr<11)
                a=1;
            else
            {
                System.out.println("Please check the input");
                System.out.println("There are only 11 players in a cricket match");
            }
        }
        while(a==0);
        if(tbat.compareTo(tname1)==0)
            batstr=tmem1[0][batnostr];
        else
            batstr=tmem2[0][batnostr];
        oldbatno1=batnostr;
        obattmem[batnostr]="Playing";
        battmem[1][batnostr]="Not Out";

        System.out.println("Choose the batsman(non-striker) from the following list");
        if(tbat.compareTo(tname1)==0)
        {
            for(int i=0;i<11;i++)
                System.out.println(i+"."+tmem1[0][i]);
        }
        else
        {
            for(int i=0;i<11;i++)
                System.out.println(i+"."+tmem2[0][i]);
        }
        a=0;
        int b=0;
        do
        {
            a=0;
            b=0;
            batnonstr=sc.nextInt();
            if(batnonstr!=batnostr)
                a=1;
            else
            {
                System.out.println((char)(9587)+"WRONG INPUT"+(char)(9587));
                System.out.println("A player can not present at two places on the same time"+(char)(9785)+""+(char)(9785)+""+(char)(9785));
            }
            if(batnonstr<11)
                b=1;
            else
            {
                System.out.println("Please check the input");
                System.out.println("There are only 11 players in a cricket match");
            }
        }
        while(a==0 || b==0);
        if(tbat.compareTo(tname1)==0)
            batnstr=tmem1[0][batnonstr];
        else
            batnstr=tmem2[0][batnonstr];
        oldbatno2=batnonstr;
        obattmem[batnonstr]="Playing";
        battmem[1][batnonstr]="Not Out";

        /*bs=batstr;
        bns=batnstr;*/
        //bt[0]=batstr;
        //bt[1]=batnstr;
        int psr=0;//player striker run
        int pnsr=0;//player non-striker run
        int s=0;
        int ns=1;

        System.out.println("\fEnter the run scored on a ball according to this format:");
        System.out.println("0 run: 0 \tExtras: -1 \n1 run: 1 \tOut:    -2\n2 run: 2\n3 run: 3\nFour:  4\nSix:   6");
        System.out.println("Press Enter to go to the next page");
        enter=(char)(in.read());

        for(over=0;over<tover;over++)
        {
            System.out.println("\fChoose the bowler from the following list");
            if(tbowl.compareTo(tname1)==0)
            {
                for(int i=0;i<11;i++)
                    System.out.println(i+"."+tmem1[0][i]);
            }
            else
            {
                for(int i=0;i<11;i++)
                    System.out.println(i+"."+tmem2[0][i]);
            }

            a=0;
            do
            {
                a=0;
                b=0;
                bowlerno=sc.nextInt();
                if(bowlerno!=oldbowlno)
                    a=1;
                else
                {
                    System.out.println((char)(9587)+"WRONG INPUT"+(char)(9587));
                    System.out.println("A bowler cannot be continued for two overs"+(char)(9785)+""+(char)(9785)+""+(char)(9785));
                }
                if(bowlerno<11)
                    b=1;
                else
                {
                    System.out.println("Please check the input");
                    System.out.println("There are only 11 players in a cricket match");
                }
            }
            while(a==0 || b==0);
            for(int i=0;i<11;i++)
            {
                if(i==bowlerno)
                    orwbowltmem[0][i]++;
            }
            if(tbowl.compareTo(tname1)==0)
                bowler=tmem1[0][bowlerno];
            else
                bowler=tmem2[0][bowlerno];

            for(int ball=0;ball<6;)
            {
                System.out.print("\f");
                batstr=battmem[0][batnostr];
                batnstr=battmem[0][batnonstr];

                System.out.println("\n\n\n\n\t\t      ###SCORECARD###");
                System.out.print("\t\t");
                for(int i=0;i<30;i++)
                    System.out.print("-");
                System.out.println();
                if(target==0)
                    System.out.println("\t\t\tScore:"+run+"/"+outno+"\n\t\t\tOver:"+over+"."+ball);
                else
                    System.out.println("\t\t\tScore:"+run+"/"+outno+"\tTarget:"+target+"\n\t\t\tOver:"+over+"."+ball);
                System.out.println("\t\t\tExtra Runs:"+tre);
                System.out.println();
                System.out.println("\t\t\tBatting team: "+tbat);
                if(batnostr<=batnonstr)
                {
                    System.out.println("\t\t\t"+battmem[0][batnostr].trim()+"*:"+rbattmem[0][batnostr]+"("+bbattmem[batnostr]+")");
                    System.out.println("\t\t\t"+battmem[0][batnonstr].trim()+" :"+rbattmem[0][batnonstr]+"("+bbattmem[batnonstr]+")");
                }
                else
                {  
                    System.out.println("\t\t\t"+battmem[0][batnonstr].trim()+" :"+rbattmem[0][batnonstr]+"("+bbattmem[batnonstr]+")");
                    System.out.println("\t\t\t"+battmem[0][batnostr].trim()+"*:"+rbattmem[0][batnostr]+"("+bbattmem[batnostr]+")");
                }
                System.out.println();
                System.out.println("\t\t\tBowling team: "+tbowl);
                System.out.println("\t\t\tBowler: "+bowler);
                System.out.println();
                if((over+1)==tover)
                    System.out.println("\t\t\tIt is the last over");
                if(!(ball==0))
                    System.out.println("\t\t\tThis over:\n\t\t\t"+ro);
                System.out.print("\t\t");
                for(int i=0;i<30;i++)
                    System.out.print("-");
                System.out.println("\n\n\n");

                System.out.println("Enter the runs scored\t\t\t\t\t***Press 9 for help");

                switch(rb)
                {
                    case 9:
                    System.out.println("\fEnter the run scored on a ball according to this format:");
                    System.out.println("0 run: 0 \tExtras: -1 \n1 run: 1 \tOut:    -2\n2 run: 2\n3 run: 3\nFour:  4\nSix:   6");
                    System.out.println("Press Enter to Exit");
                    enter=(char)(in.read());

                    case 0:
                    ball=ball+1;
                    for(int i=0;i<11;i++)
                    {
                        if(batstr.compareTo(battmem[0][i])==0)
                        {
                            bbattmem[i]=bbattmem[i]+1;
                        }
                    }
                    ro=ro+" 0";
                    reo[over]=reo[over]+0;
                    break;

                    case 1:
                    run=run+1;
                    reo[over]=reo[over]+1;
                    ro=ro+" 1";
                    ball=ball+1;
                    orwbowltmem[1][bowlerno]++;
                    temp1=batnostr;
                    batnostr=batnonstr;
                    batnonstr=temp1;
                    for(int i=0;i<11;i++)
                    {
                        if(batstr.compareTo(battmem[0][i])==0)
                        {
                            rbattmem[0][i]=rbattmem[0][i]+1;
                            bbattmem[i]=bbattmem[i]+1;
                        }
                    }
                    break;

                    case 2:
                    run=run+2;
                    reo[over]=reo[over]+2;
                    ro=ro+" 2";
                    ball=ball+1;
                    orwbowltmem[1][bowlerno]+=2;
                    for(int i=0;i<11;i++)
                    {
                        if(batstr.compareTo(battmem[0][i])==0)
                        {
                            rbattmem[0][i]=rbattmem[0][i]+2;
                            bbattmem[i]=bbattmem[i]+1;
                        }
                    }
                    break;

                    case 3:
                    run=run+3;
                    reo[over]=reo[over]+3;
                    ro=ro+" 3";
                    ball=ball+1;
                    orwbowltmem[1][bowlerno]+=3;
                    temp1=batnostr;
                    batnostr=batnonstr;
                    batnonstr=temp1;
                    for(int i=0;i<11;i++)
                    {
                        if(batstr.compareTo(battmem[0][i])==0)
                        {
                            rbattmem[0][i]=rbattmem[0][i]+3;
                            bbattmem[i]=bbattmem[i]+1;
                        }
                    }
                    break;

                    case 4:
                    run=run+4;
                    reo[over]=reo[over]+4;
                    ro=ro+" 4";
                    ball=ball+1;
                    orwbowltmem[1][bowlerno]+=4;
                    for(int i=0;i<11;i++)
                    {
                        if(batstr.compareTo(battmem[0][i])==0)
                        {
                            rbattmem[0][i]=rbattmem[0][i]+4;
                            rbattmem[1][i]++;
                            bbattmem[i]=bbattmem[i]+1;
                        }
                    }
                    break;

                    case 6:
                    run=run+6;
                    reo[over]=reo[over]+6;
                    ro=ro+" 6";
                    ball=ball+1;
                    orwbowltmem[1][bowlerno]+=6;
                    for(int i=0;i<11;i++)
                    {
                        if(batstr.compareTo(battmem[0][i])==0)
                        {
                            rbattmem[0][i]=rbattmem[0][i]+6;
                            rbattmem[2][i]++;
                            bbattmem[i]=bbattmem[i]+1;
                        }
                    }
                    break;

                    case -1:  

                    System.out.println("For Wide: 1    \tFor No Ball: 2    \nFor Leg Byes: 3    For Byes: 4    For Exit: 0");
                    rbe=sc.nextInt();
                    switch(rbe)
                    {
                        case 1://wide
                        run=run+1;
                        reo[over]=reo[over]+1;
                        ro=ro+" WD";
                        tre=tre+1;
                        break;

                        case 2://no ball
                        run=run+1;
                        reo[over]=reo[over]+1;
                        tre=tre+1;
                        System.out.println("How much did they score on the no-ball");
                        a=0;
                        do
                        {
                            re=sc.nextInt();
                            if(re==0 || re==1 || re==2 || re==3 || re==4 || re==6)
                                a=1;
                            else
                            {
                                System.out.println((char)(9587)+"WRONG INPUT"+(char)(9587));
                                System.out.println("Please check for the input");
                            }
                        }
                        while(a==0);
                        ro=ro+" NB"+"("+re+")";
                        run=run+re;
                        reo[over]=reo[over]+re;
                        rbattmem[0][batnostr]=rbattmem[0][batnostr]+re;
                        if(re==4)
                            rbattmem[1][batnostr]++;
                        else if(re==6)
                            rbattmem[2][batnostr]++;
                        if(re==1 || re==3)
                        { 
                            temp1=batnostr;
                            batnostr=batnonstr;
                            batnonstr=temp1;
                        }

                        a=0;
                        int freehit;
                        System.out.println("How much did they score on free hit");
                        do
                        {
                            freehit=sc.nextInt();
                            if(freehit==-1)
                            {
                                System.out.println("For Wide: 1    \tFor No Ball: 2");
                                int r=sc.nextInt();
                                if(r==1)
                                {
                                    run=run+1;
                                    reo[over]=reo[over]+1;
                                    ro=ro+" WD";
                                    tre=tre+1;
                                }
                                else
                                {
                                    run=run+1;
                                    reo[over]=reo[over]+1;
                                    tre=tre+1;
                                    System.out.println("How much did they score on the no-ball");
                                    a=0;
                                    do
                                    {
                                        re=sc.nextInt();
                                        if(re==0 || re==1 || re==2 || re==3 || re==4 || re==6)
                                            a=1;
                                        else
                                        {
                                            System.out.println((char)(9587)+"WRONG INPUT"+(char)(9587));
                                            System.out.println("Please check for the input");
                                        }
                                    }
                                    while(a==0);
                                    a=0;
                                    ro=ro+"nb"+"("+re+")";
                                    run=run+re;
                                    reo[over]=reo[over]+re;
                                    rbattmem[0][batnostr]=rbattmem[0][batnostr]+re;
                                    if(re==4)
                                        rbattmem[1][batnostr]++;
                                    else if(re==6)
                                        rbattmem[2][batnostr]++;
                                    if(re==1 || re==3)
                                    { 
                                        temp1=batnostr;
                                        batnostr=batnonstr;
                                        batnonstr=temp1;
                                    }
                                    System.out.println("The free-hit continues..");
                                    System.out.println("How much did they score?");
                                }
                            }
                            else
                                a=1;
                        }
                        while(a==0);
                        ro=ro+" "+freehit;
                        rbattmem[0][batnostr]=rbattmem[0][batnostr]+freehit;
                        bbattmem[batnostr]=bbattmem[batnostr]+1;
                        if(freehit==4)
                            rbattmem[1][batnostr]++;
                        else if(freehit==6)
                            rbattmem[2][batnostr]++;
                        if(freehit==1 || freehit==3)
                        {
                            temp1=batnostr;
                            batnostr=batnonstr;
                            batnonstr=temp1;
                        }
                        run=run+freehit;
                        reo[over]=reo[over]+freehit;
                        ball=ball+1;
                        orwbowltmem[1][bowlerno]++;
                        break;

                        case 3://leg byes
                        System.out.println("How much did they score on leg-byes");
                        a=0;
                        do
                        {
                            re=sc.nextInt();
                            if(re==0 || re==1 || re==2 || re==3 || re==4 || re==6)
                                a=1;
                            else
                            {
                                System.out.println((char)(9587)+"WRONG INPUT"+(char)(9587));
                                System.out.println("Please check for the input");
                            }
                        }
                        while(a==0);
                        run=run+re;
                        reo[over]=reo[over]+re;
                        ro=ro+" LEGBYES("+re+")";
                        tre=tre+re;
                        ball=ball+1;
                        for(int i=0;i<6;i++)
                        {
                            if(batstr.compareTo(battmem[0][i])==0)
                                bbattmem[i]=bbattmem[i]+1;
                        }
                        if(re==1 || re==3)
                        {
                            temp1=batnostr;
                            batnostr=batnonstr;
                            batnonstr=temp1;
                        }
                        break;

                        case 4://byes
                        System.out.println("How much did they score on byes");
                        a=0;
                        do
                        {
                            re=sc.nextInt();
                            if(re==0 || re==1 || re==2 || re==3 || re==4 || re==6)
                                a=1;
                            else
                            {
                                System.out.println((char)(9587)+"WRONG INPUT"+(char)(9587));
                                System.out.println("Please check for the input");
                            }
                        }
                        while(a==0);
                        run=run+re;
                        reo[over]=reo[over]+re;
                        ro=ro+" BYES("+re+")";
                        tre=tre+re;
                        ball=ball+1;
                        for(int i=0;i<11;i++)
                        {
                            if(batstr.compareTo(battmem[0][i])==0)

                                bbattmem[i]=bbattmem[i]+1;
                        }
                        if(re==1 || re==3)
                        {
                            temp1=batnostr;
                            batnostr=batnonstr;
                            batnonstr=temp1;
                        }
                        break;
                    }
                    break;

                    case -2://out
                    System.out.println("How did he get out?\npress 1 for Caught\tpress 2 for Bowled\npress 3 for L.B.W\tpress 4 for Hit-Wicket\npress 5 for Stumped\tpress 6 for Run-out\tpress 0 for Exit");
                    out_way=sc.nextInt();
                    ball=ball+1;
                    ro=ro+" "+(char)(9420);
                    outno++;
                    if(out_way==1)//Caught
                    {
                        obattmem[batnostr]="Out";
                        battmem[1][batnostr]="Caught";
                        battmem[2][batnostr]=bowler;
                        orwbowltmem[2][bowlerno]++;
                        for(int i=0;i<11;i++)
                        {
                            if(batstr.compareTo(battmem[0][i])==0)
                                bbattmem[i]=bbattmem[i]+1;
                        }
                        temp1=batnostr;
                        batnostr=batnonstr;
                        batnonstr=temp1;
                    }
                    if(out_way==2)//Bowled
                    {
                        obattmem[batnostr]="Out";
                        battmem[1][batnostr]="Bowled";
                        battmem[2][batnostr]=bowler;
                        orwbowltmem[2][bowlerno]++;
                        for(int i=0;i<11;i++)
                        {
                            if(batstr.compareTo(battmem[0][i])==0)
                                bbattmem[i]=bbattmem[i]+1;
                        }
                    }
                    if(out_way==3)//LBW
                    {
                        obattmem[batnostr]="Out";
                        battmem[1][batnostr]="L.B.W";
                        battmem[2][batnostr]=bowler;
                        orwbowltmem[2][bowlerno]++;
                        for(int i=0;i<11;i++)
                        {
                            if(batstr.compareTo(battmem[0][i])==0)
                                bbattmem[i]=bbattmem[i]+1;
                        }
                    }
                    if(out_way==4)//Hit Wicket
                    {
                        obattmem[batnostr]="Out";
                        battmem[1][batnostr]="Hit-Wicket";
                        battmem[2][batnostr]=bowler;
                        orwbowltmem[2][bowlerno]++;
                        for(int i=0;i<11;i++)
                        {
                            if(batstr.compareTo(battmem[0][i])==0)
                                bbattmem[i]=bbattmem[i]+1;
                        }
                    }
                    if(out_way==5)//Stumped
                    {
                        obattmem[batnostr]="Out";
                        battmem[1][batnostr]="Stumped";
                        battmem[2][batnostr]=bowler;
                        orwbowltmem[2][bowlerno]++;
                        for(int i=0;i<11;i++)
                        {
                            if(batstr.compareTo(battmem[0][i])==0)

                                bbattmem[i]=bbattmem[i]+1;
                        }
                    }
                    if(out_way==6)//Run-Out
                    {
                        System.out.println("How much did the player score on this ball");
                        outrun=sc.nextInt();
                        run=run+outrun;
                        reo[over]=reo[over]+outrun;
                        orwbowltmem[1][bowlerno]+=outrun;
                        for(int i=0;i<11;i++)
                        {
                            if(batstr.compareTo(battmem[0][i])==0)
                            {
                                rbattmem[0][i]=rbattmem[0][i]+outrun;
                                bbattmem[i]=bbattmem[i]+1;
                            }
                        }
                        a=0;
                        do
                        {
                            System.out.println("If "+battmem[0][batnostr]+" got out then press 1");            
                            System.out.println("If "+battmem[0][batnonstr]+" got out then press 2");
                            outstr=sc.nextInt();
                            if(outstr==1 || outstr==2)
                                a=1;
                            else
                                System.out.println((char)(9587)+"WRONG INPUT"+(char)(9587));
                        }
                        while(a==0);
                        if(outstr==1)
                        {
                            obattmem[batnostr]="Out";
                            battmem[1][batnostr]="Run-out";
                            battmem[2][batnostr]=bowler;
                        }
                        else
                        {
                            obattmem[batnonstr]="Out";
                            battmem[1][batnonstr]="Run-Out";
                            battmem[2][batnonstr]=bowler;
                        }

                        a=0;                            
                        System.out.println("Will the strike rotate?[Yes/No]");
                        do
                        {
                            temp2=sc.next();
                            if(temp2.equalsIgnoreCase("yes") || temp2.equalsIgnoreCase("no"))
                                a=1;
                        }
                        while(a==0);
                        if(temp2.equalsIgnoreCase("yes"))
                        {
                            temp1=batnostr;
                            batnostr=batnonstr;
                            batnonstr=temp1;
                        }
                    }

                    o=0;
                    for(int i=0;i<11;i++)
                    {
                        if(obattmem[i].compareToIgnoreCase("Remaining")==0)
                            o=1;
                    }
                    if(o==0)
                        break;

                    System.out.println("Choose the next Batsman");
                    for(int i=0;i<11;i++)
                    {
                        System.out.println(i+"."+battmem[0][i]+"\t\t"+obattmem[i]);
                    }
                    a=0;
                    do
                    {
                        newbatno=sc.nextInt();
                        if((obattmem[newbatno].equalsIgnoreCase("Remaining")))
                            a=1;
                        else if((obattmem[newbatno].equalsIgnoreCase("Out")))
                        {
                            System.out.println((char)(9587)+"WRONG INPUT"+(char)(9587));
                            System.out.println("The player which you have chosen is out"+(char)(9785)+""+(char)(9785)+""+(char)(9785));
                        }
                        else if((obattmem[newbatno].equalsIgnoreCase("Playing")))
                        {
                            System.out.println((char)(9587)+"WRONG INPUT"+(char)(9587));
                            System.out.println("The player which you have chosen is already playing"+(char)(9785)+""+(char)(9785)+""+(char)(9785));
                        }
                    }
                    while(a==0);
                    if(obattmem[newbatno].equalsIgnoreCase("Remaining") && obattmem[batnostr].equalsIgnoreCase("Out"))
                    {
                        batnostr=newbatno;
                        obattmem[newbatno]="Playing"; 
                        battmem[1][batnostr]="";
                        battmem[2][batnostr]="";
                    }
                    else if(obattmem[newbatno].equalsIgnoreCase("Remaining") && obattmem[batnonstr].equalsIgnoreCase("Out"))
                    {
                        batnonstr=newbatno;
                        obattmem[newbatno]="Playing";
                        battmem[1][batnostr]="";
                        battmem[2][batnostr]="";
                    }

                    battmem[1][newbatno]="";
                    battmem[2][batnostr]="";
                    System.out.println("New Batsman:"+battmem[0][newbatno]);
                    Thread.sleep(1000);
                    break;
                }
                if(target!=0)
                {
                    if(target<=run)
                    {
                        result=1;
                        break;
                    }
                    else if((target-1)==run)
                        result=2;
                }

                if(o==0)
                    break;
            }
            if(target!=0)
            {
                if(target<=run)
                {
                    result=1;
                    break;
                }
            }
            if(o==0)
                break;

            ro="";
            oldbowlno=bowlerno;
            temp1=batnostr;
            batnostr=batnonstr;
            batnonstr=temp1;

        }

        for(int i=0;i<11;i++)
        {
            if(bbattmem[i]==0)
                strkbat[i]=0;
            else 
            {
                strkbat[i]=((100.0*rbattmem[0][i])/bbattmem[i]);   
                strkbat[i]=(int)(strkbat[i]);
            }
        }

        if(result==1)
            twin=tbat;
        else if(result==0)
            twin=tbowl;       
        else
            System.out.println("Match Tie");

        System.out.println("\f");
        System.out.println("Runs:"+run+"\nExtras:"+tre);
        System.out.print("Player");
        for(int i=6;i<lenmax1;i++) 
            System.out.print(" ");
        System.out.println("\t\tRun\t\tBall\t\tFour\t\tSix\t\tStrike Rate\t\tWicket\t\tBowler");
        for(int i=0;i<11;i++)
        {
            if(obattmem[i].equalsIgnoreCase("Playing"))
                System.out.println(battmem[0][i]+"\t\t"+rbattmem[0][i]+"*\t\t "+bbattmem[i]+"\t\t "+rbattmem[1][i]+"\t\t"+rbattmem[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+battmem[1][i]);

            else if(obattmem[i].equalsIgnoreCase("Out"))
            {   
                System.out.print(battmem[0][i]+"\t\t"+rbattmem[0][i]+" \t\t "+bbattmem[i]+"\t\t "+rbattmem[1][i]+"\t\t"+rbattmem[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+battmem[1][i]);      
                for(int j=(obattmem[i].length());j<13;j++)
                    System.out.print(" ");
                System.out.println(battmem[2][i]);
            }
            else
                System.out.println(battmem[0][i]+"\t\t"+rbattmem[0][i]+" \t\t "+bbattmem[i]+"\t\t "+rbattmem[1][i]+"\t\t"+rbattmem[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+battmem[1][i]);
        }

        System.out.print("\n\n\nBowler");
        for(int i=6;i<lenmax2;i++) 
            System.out.print(" ");
        System.out.println("\t\tOver\t\tRuns\t\tWicket");
        for(int i=0;i<11;i++)
        {
            System.out.println(bowltmem[i]+"\t\t  "+orwbowltmem[0][i]+"\t\t  "+orwbowltmem[1][i]+"\t\t  "+orwbowltmem[2][i]);
        }
        System.out.println("\n\n\nPress Enter to exit");
        enter=(char)(in.read());
        System.out.print("\f");

        int x=tover;
        temp2="";
        System.out.println("Do you wish to see the graph?[yes/no]");
        temp2=sc.next();
        /*if(temp2.compareToIgnoreCase("yes")==0)
        ob.Vertical_Graph(reo, x);*/
        if(temp2.compareToIgnoreCase("yes")==0)
        {
            int no=x;
            int runs[]=new int[no];
            int name[]=new int[no];
            /*for(int i=0;i<no;i++)//name of subjects
            {
            System.out.println("Enter the name of the subjects");
            name[i]=sc.next();
            }*/
            for(int i=0;i<no;i++)//for x axis
                name[i]=(i+1);                                                   

            for(int i=0;i<no;i++)
                runs[i]=reo[i];

            int max=0;
            for(int i=0;i<no;i++)//finding maximum
            {
                if(runs[i]>runs[max])
                    max=i;
            }
            System.out.print("\f");
            System.out.println("\t\t\t\t\t VERTICAL GRAPH\n\n");
            //int a=sc.nextInt();
            int temp1=runs[max]+2;
            for(int j=(runs[max]+2);j>=0;j--)//printing blocks
            {
                System.out.print(temp1+"\t"+(char)(9615)+"\t");
                for(int i=0;i<no;i++)
                { 
                    if(runs[i]>=temp1)
                        System.out.print((char)9608+"\t\t");
                    else
                        System.out.print(" \t\t");
                }
                temp1=temp1-1;
                System.out.println("\t  ");
            }  
            for(int i=0;i<no;i++)
                System.out.print("-----------------------");
            System.out.println();
            for(int i=0;i<no;i++)
            {
                System.out.print("\t\t"+name[i]+"    ");
            }
        }    
    }

    public void Scorecard()
    {
        System.out.println("\t\t\t Scorecard\t\t");
        System.out.print("\t\t");
        for(int i=0;i<18;i++)
            System.out.print((char)(9644));
        System.out.println();
        System.out.println("\t\t"+(char)(9646)+"\tScore:"+run+"/"+outno+"\t"+(char)(9646));
        System.out.println("\t\t"+(char)(9646)+"\tOver:"+over+"\t\t"+(char)(9646));
        System.out.println("\t\t"+(char)(9646)+"\tExtra Runs:"+tre+"\t"+(char)(9646));
        System.out.println("\t\t"+(char)(9646)+"\t\t\t"+(char)(9646));
        if(batnostr<=batnonstr)
        {
            System.out.println("\t\t"+(char)(9646)+"\t"+battmem[0][batnostr]+"*:"+rbattmem[0][batnostr]+"("+bbattmem[batnostr]+")"+"\t"+(char)(9646));
            System.out.println("\t\t"+(char)(9646)+"\t"+battmem[0][batnonstr]+" :"+rbattmem[0][batnonstr]+"("+bbattmem[batnonstr]+")"+"\t"+(char)(9646));
        }
        else
        {  
            System.out.println("\t\t"+(char)(9646)+"\t"+battmem[0][batnonstr]+" :"+rbattmem[0][batnonstr]+"("+bbattmem[batnonstr]+")"+"\t"+(char)(9646));
            System.out.println("\t\t"+(char)(9646)+"\t"+battmem[0][batnostr]+"*:"+rbattmem[0][batnostr]+"("+bbattmem[batnostr]+")"+"\t"+(char)(9646));
        }
        System.out.print("\t\t");
        for(int i=0;i<18;i++)
            System.out.print((char)(9644));
    }

    public void Scorecard2()throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.println("\f");
        System.out.println("Runs:"+run+"\nExtras:"+tre);
        System.out.println("Player\t\tRun\t\tFour\t\tSix\t\tWicket\t\tBowler");
        for(int i=0;i<11;i++)
        {
            if(obattmem[i].equalsIgnoreCase("Playing"))
                System.out.println(battmem[0][i]+"\t\t"+rbattmem[0][i]+"*\t\t "+bbattmem[i]+"\t\t "+rbattmem[1][i]+"\t\t "+rbattmem[2][i]+"\t\t"+battmem[1][i]);

            else if(obattmem[i].equalsIgnoreCase("Out"))
            {   System.out.print(battmem[0][i]+"\t\t"+rbattmem[0][i]+" \t\t "+bbattmem[i]+"\t\t "+rbattmem[1][i]+"\t\t "+rbattmem[2][i]+"\t\t"+battmem[1][i]);      
                for(int j=(obattmem[i].length());j<13;j++)
                    System.out.print(" ");
                System.out.println(battmem[2][i]);
            }
            else
                System.out.println(battmem[0][i]+"\t\t"+rbattmem[0][i]+" \t\t "+rbattmem[1][i]+"\t\t "+rbattmem[2][i]+"\t\t"+battmem[1][i]);
        }
        System.out.println("\n\n\nBowler\t\tOver\t\tRuns\t\tWicket");
        for(int i=0;i<11;i++)
        {
            System.out.println(bowltmem[i]+"\t\t  "+orwbowltmem[0][i]+"\t\t  "+orwbowltmem[1][i]+"\t\t  "+orwbowltmem[2][i]);
        }
        System.out.println("\n\n\nPress Enter to exit");
        enter=(char)(in.read());
    }

    public void Scorecardt1()throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.println("\f");
        System.out.println("Runs:"+run+"\nExtras:"+tre);
        System.out.print("Player");
        for(int i=6;i<lenmax1;i++) 
            System.out.print(" ");
        System.out.println("\t\tRun\t\tBall\t\tFour\t\tSix\t\tStrike Rate\t\tWicket\t\tBowler");
        for(int i=0;i<11;i++)
        {
            if(otmem1[i].equalsIgnoreCase("Playing"))
                System.out.println(tmem1[0][i]+"\t\t"+rtmem1[0][i]+"*\t\t "+btmem1[i]+"\t\t "+rtmem1[1][i]+"\t\t "+rtmem1[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+tmem1[1][i]);

            else if(otmem1[i].equalsIgnoreCase("Out"))
            {   System.out.print(tmem1[0][i]+"\t\t"+rtmem1[0][i]+" \t\t "+btmem1[i]+"\t\t"+rtmem1[1][i]+"\t\t "+rtmem1[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+tmem1[1][i]);      
                for(int j=(otmem1[i].length());j<13;j++)
                    System.out.print(" ");
                System.out.println(tmem1[2][i]);
            }
            else
                System.out.println(tmem1[0][i]+"\t\t"+rtmem1[0][i]+" \t\t "+btmem1[i]+"\t\t"+rtmem1[1][i]+"\t\t "+rtmem1[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+tmem1[1][i]);
        }

        System.out.print("\n\n\nBowler");
        for(int i=6;i<lenmax2;i++) 
            System.out.print(" ");
        System.out.println("\t\tOver\t\tRuns\t\tWicket");
        for(int i=0;i<11;i++)
        {
            System.out.println(tmem2[0][i]+"\t\t  "+orwtmem2[0][i]+"\t\t  "+orwtmem2[1][i]+"\t\t  "+orwtmem2[2][i]);
        }
        System.out.println("\n\n\nPress Enter to exit");
        enter=(char)(in.read());
        System.out.print("\f");
    }

    public void Scorecardt2()throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.println("\f");
        System.out.println("Runs:"+run+"\nExtras:"+tre);
        System.out.print("Player");
        for(int i=6;i<lenmax2;i++) 
            System.out.print(" ");
        System.out.println("\t\tRun\t\tBall\t\tFour\t\tSix\t\tStrike Rate\t\tWicket\t\tBowler");
        for(int i=0;i<11;i++)
        {
            if(otmem2[i].equalsIgnoreCase("Playing"))
                System.out.println(tmem2[0][i]+"\t\t"+rtmem2[0][i]+"*\t\t "+btmem2[i]+"\t\t"+rtmem2[1][i]+"\t\t "+rtmem2[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+tmem2[1][i]);

            else if(otmem2[i].equalsIgnoreCase("Out"))
            {   System.out.print(tmem2[0][i]+"\t\t"+rtmem2[0][i]+" \t\t "+btmem2[i]+"\t\t"+rtmem2[1][i]+"\t\t "+rtmem2[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+tmem2[1][i]);      
                for(int j=(otmem2[i].length());j<13;j++)
                    System.out.print(" ");
                System.out.println(tmem2[2][i]);
            }
            else
                System.out.println(tmem2[0][i]+"\t\t"+rtmem2[0][i]+" \t\t "+btmem2[i]+"\t\t"+rtmem2[1][i]+"\t\t "+rtmem2[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+tmem2[1][i]);
        }

        System.out.print("\n\n\nBowler");
        for(int i=6;i<lenmax1;i++) 
            System.out.print(" ");
        System.out.println("\t\tOver\t\tRuns\t\tWicket");
        for(int i=0;i<11;i++)
        {
            System.out.println(tmem1[0][i]+"\t\t  "+orwtmem1[0][i]+"\t\t  "+orwtmem1[1][i]+"\t\t  "+orwtmem1[2][i]);
        }
        System.out.println("\n\n\nPress Enter to exit");
        enter=(char)(in.read());
        System.out.print("\f");
    }

    public void ScorecardAnalysist1()throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.println("\f");
        System.out.println("Runs:"+run+"\nExtras:"+tre);
        System.out.print("Player");
        for(int i=6;i<lenmax1;i++) 
            System.out.print(" ");
        System.out.println("\t\tRun\t\tBall\t\tFour\t\tSix\t\tStrike Rate\t\tWicket\t\tBowler");
        for(int i=0;i<11;i++)
        {
            if(otmem1[i].equalsIgnoreCase("Playing"))
                System.out.println(tmem1[0][i]+"\t\t"+rtmem1[0][i]+"*\t\t "+btmem1[i]+"\t\t"+rtmem1[1][i]+"\t\t "+rtmem1[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+tmem1[1][i]);

            else if(otmem1[i].equalsIgnoreCase("Out"))
            {   System.out.print(tmem1[0][i]+"\t\t"+rtmem1[0][i]+" \t\t "+btmem1[i]+"\t\t"+rtmem1[1][i]+"\t\t "+rtmem1[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+tmem1[1][i]);      
                for(int j=(otmem1[i].length());j<13;j++)
                    System.out.print(" ");
                System.out.println(tmem1[2][i]);
            }
            else
                System.out.println(tmem1[0][i]+"\t\t"+rtmem1[0][i]+" \t\t "+btmem1[i]+"\t\t"+rtmem1[1][i]+"\t\t "+rtmem1[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+tmem1[1][i]);
        }

        System.out.print("\n\n\nBowler");
        for(int i=6;i<lenmax1;i++) 
            System.out.print(" ");
        System.out.println("\t\tOver\t\tRuns\t\tWicket");
        for(int i=0;i<11;i++)
        {
            System.out.println(tmem1[0][i]+"\t\t  "+orwtmem1[0][i]+"\t\t  "+orwtmem1[1][i]+"\t\t  "+orwtmem1[2][i]);
        }
        System.out.println("\n\n\nPress Enter to exit");
        enter=(char)(in.read());
        System.out.print("\f");
    }

    public void ScorecardAnalysist2()throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        System.out.println("\f");
        System.out.println("Runs:"+run+"\nExtras:"+tre);
        System.out.print("Player");
        for(int i=6;i<lenmax2;i++) 
            System.out.print(" ");
        System.out.println("\t\tRun\t\tBall\t\tFour\t\tSix\t\tStrike Rate\t\tWicket\t\tBowler");
        for(int i=0;i<11;i++)
        {
            if(otmem2[i].equalsIgnoreCase("Playing"))
                System.out.println(tmem2[0][i]+"\t\t"+rtmem2[0][i]+"*\t\t "+btmem2[i]+"\t\t"+rtmem2[1][i]+"\t\t "+rtmem2[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+tmem2[1][i]);

            else if(otmem2[i].equalsIgnoreCase("Out"))
            {   System.out.print(tmem2[0][i]+"\t\t"+rtmem2[0][i]+" \t\t "+btmem2[i]+"\t\t"+rtmem2[1][i]+"\t\t "+rtmem2[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+tmem2[1][i]);      
                for(int j=(otmem2[i].length());j<13;j++)
                    System.out.print(" ");
                System.out.println(tmem2[2][i]);
            }
            else
                System.out.println(tmem2[0][i]+"\t\t"+rtmem2[0][i]+" \t\t "+btmem1[i]+"\t\t"+rtmem2[1][i]+"\t\t "+rtmem2[2][i]+"\t\t\t"+strkbat[i]+"\t\t"+tmem2[1][i]);
        }

        System.out.print("\n\n\nBowler");
        for(int i=6;i<lenmax2;i++) 
            System.out.print(" ");
        System.out.println("\t\tOver\t\tRuns\t\tWicket");
        for(int i=0;i<11;i++)
        {
            System.out.println(tmem2[0][i]+"\t\t  "+orwtmem2[0][i]+"\t\t  "+orwtmem2[1][i]+"\t\t  "+orwtmem2[2][i]);
        }
        System.out.println("\n\n\nPress Enter to exit");
        enter=(char)(in.read());
        System.out.print("\f");
    }

    public void result()
    {
        System.out.print("\f\n\n\n\n\t\t\t");
        if(result==0)
            System.out.println("Team "+twin+" has won the match by "+Math.abs(((target-1)-run1)));
        else if(result==1)
            System.out.println("Team "+twin+" has won the match");
        else
            System.out.println("Match Tie");

    }

    public void ty()throws InterruptedException
    {
        System.out.print("\f\n\n\n\n\n\t\t\t\t\t");
        String na="THANK YOU";
        for(int i=0;i<9;i++)
        {
            char ch=na.charAt(i);
            System.out.print(ch);
            Thread.sleep(250);
        }
        Thread.sleep(750);

        System.out.println("\f");
        System.out.println("                                              `-/+/:`                                               ");
        System.out.println("                                            `+/-``.:so`                                             ");
        System.out.println("                                           .s`       .s                                             ");
        System.out.println("                                           s+.```...:/h.                                            ");
        System.out.println("                                           /o````.`./sm`                                            ");
        System.out.println("            `.`                             ::`    `-++                             `               ");
        System.out.println("          -+/+yy`                            `:::/::-`                            .y+//-            ");
        System.out.println("         .o--+mMd-                      ``. .:.-``..`.-`.-                       /mMy--/:           ");
        System.out.println("         -somMNMMNs.                   :-/.--+-/.-o.::...:/+                   .yMMMMms/h`          ");
        System.out.println("          :ymMMMMMMmo.                 / :o...... -:.-.-.. y.                .omMMMMMMMmy           ");
        System.out.println("            ./ymMMMMMm+`               +`-s     /-y/    `--h`              `omMMMMMMms:.`           ");
        System.out.println("               .:sNMMMMd/`             o`:s     -.y/     ``d`            .+mMMMMMms/`               ");
        System.out.println("                  -smMMMMh:`           : -s    `. o/       d`          .+mMMMMmh/.                  ");
        System.out.println("                    `:yNMMNh/`        `/ :o    `` o/       d`        ./hMMNMh+.                     ");
        System.out.println("                       :ymmdys/`      `: //    `` o/    `  h`      `:+ohMNy/`                       ");
        System.out.println("                         ..`-oo+:.    `. :/    `` o-    -` y`   ``-/:+hds-                          ");
        System.out.println("                             .ds---.` `. /:    .` +     -- h` `..--ohh+.                            ");
        System.out.println("                              :yy:-.//-. s-    .` o     :. h-:-.:+hds.                              ");
        System.out.println("                               `omy/-:/+:y:``--:..s+-```+/:/--:/hNs`                                ");
        System.out.println("                                 -yms+. `-+-:--ss/``://--`.//shNh:                                  ");
        System.out.println("                                   /mho--./:``-``    .o+..+odNh:`                                   ");
        System.out.println("                                    .ms/o-`o/:     .:- `osyNMs                                      ");
        System.out.println("                                     ho `//.     `:-`.::` :Ns                                       ");
        System.out.println("                                   `sh:+:`     `:/---`    `y+                                       ");
        System.out.println("                                   `so:`      -s:.`     .oms:                                       ");
        System.out.println("                                 `/+-                 -ymNMm+`                                      ");
        System.out.println("                               `/:`                 /hMMNs:.-//.                                    ");
        System.out.println("                             `::`                `/mMMN+`     `++.                                  ");
        System.out.println("                           .--                 .omMMMs`         `:/:                                ");
        System.out.println("                         -.`                 ./hNMMN+             `:+/`                             ");
        System.out.println("                      `.-`                 -+-`oMMNh/`              `:/:`                           ");
        System.out.println("                    `..`                `-:-   /yhy`:o+.               .o+.                         ");
        System.out.println("                  .-`                 `+dh     - :h   -so.               ./:.                       ");
        System.out.println("               `-..                 ..hNMd     : /y    .Nds-               `-+-                     ");
        System.out.println("             .:..                `-/-`+-/h     - /y    .+.yso:               `:/:`                  ");
        System.out.println("          `-/:`                `:+-   : .h     . /y    -: s.`/+:`               -/:`                ");
        System.out.println("        .:/-`                -+/.     : .h     ` /o    -: o`  `:o/.               ./:.              ");
        System.out.println("      -o+.                `:o+.       o -d     . /o    -: o`    `:o+.               `-:.            ");
        System.out.println("   `:o/.                `:o+`         / :d     . /o    /: s`       :o+-               `./-          ");
        System.out.println("  .o/`                .:+:`           - /h     . /o    /: y`         -oo-                :+-`       ");
        System.out.println(" -o.                .//.              . :o     . /o    -` y.           .+o:`              `-+:`     ");
        System.out.println(" :`              `-/:`                - ++     . /+    /  h.             `/o:`              `:o/    ");
        System.out.println(" :             `:+:`                  : o+     . //    +  d.               `:o:`               o    ");
        System.out.println(" --          .//.                    `: +/    `. /:    /  y.                  -o/.            :h    ");
        System.out.println("  :/-``   `-+/`                      :. :/    .. //    :  s-                    -oo-`       `+m/    ");
        System.out.println("   ./+/+++s:`                        :  .y`   -` `o   `-  :/                      .sy/..--:-/y-     ");
        System.out.println("         ``                         :s/+oy.  `/:-:y   ::--/d-                       .o/.--          ");
        System.out.println("                                     +`.m/    +:.hs   `+.:m/`                                       ");
        System.out.println("                                     .`/-     `- :       +s                                         ");
        System.out.println("                                      :/       :`       .y.                                         ");
        System.out.println("                                      `.                 `                                          ");

    }
}
