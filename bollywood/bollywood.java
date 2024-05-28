import java.util.*;
import java.io.File;

public class bollywood
{
    static String[] movies=new String[1284];
    static int c;
    public static void setup() throws java.io.FileNotFoundException
    {
        Scanner sc=new Scanner(new File("")); //path to bwDS.txt
        for(int i=0;i<1284;i++)
        movies[i]=sc.nextLine();
    }
    public static void main(String[] args) throws java.io.FileNotFoundException
    {
        setup();
        c=1;
        while(c!=0)
        startgame();
    }
    public static void startgame()
    {
        Scanner sc=new Scanner(System.in);
        String m;
            System.out.println("Enter your own movie? 0/1");
            int ch=sc.nextInt();
            if(ch==1)
            {
                System.out.println("Enter movie: ");
                m=sc.next();
            }
            else
            {
        int r=(int)(Math.random()*1285);
        m=movies[r];
    }
        m=m.toLowerCase();
        String b="Bollywood";
        String g="";
        int k=0;
        String disp="";
        for(k=0;k<m.length();k++)
        {
            if(m.charAt(k)=='a'||m.charAt(k)=='e'||m.charAt(k)=='i'||m.charAt(k)=='o'||m.charAt(k)=='u')
            disp+=m.charAt(k);
            else if(m.charAt(k)==' '||m.charAt(k)=='.'||m.charAt(k)==','||m.charAt(k)=='-')
            disp+=m.charAt(k);
            else
            disp+="_";
        }
        for(k=0;k<9;k++)
        {
            boolean w=false;
            System.out.println("\n\n"+b);
            System.out.println("\n"+disp);
            String ans=sc.next();
            ans=String.valueOf(ans.charAt(0));
            ans=ans.toLowerCase();
            if(ans.equals("a")||ans.equals("e")||ans.equals("i")||ans.equals("o")||ans.equals("u")||g.contains(ans))
            {
                System.out.println("Already found!");
                k--;
                continue;
            }
            else if(m.contains(String.valueOf(ans)))
            {
                g+=ans;
                for(int i=0;i<m.length();i++)
                {
                    if(m.substring(i,i+1).equals(ans))
                    {
                        if(i!=m.length()-1)
                        disp=disp.substring(0,i)+ans+disp.substring(i+1);
                        else
                        disp=disp.substring(0,i)+ans;
                    }
                }
                if(disp.equals(m))
                {
                    System.out.println("\nThe movie was: "+m);
                    System.out.println("You Won!");
                    w=true;
                    break;
                }
                k--;
                continue;
            }
            else
            {
                if(k!=8)
                b=b.substring(0,k)+"*"+b.substring(k+1);
                else
                {
                    System.out.println("\nThe movie was: "+m);
                    System.out.println("You Lose!");
                    w=false;
                    break;
                }
            }
        }
        System.out.println("\nPlay again?");
        c=sc.nextInt();
    }
}