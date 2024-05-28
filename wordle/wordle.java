import java.io.FileInputStream;
import java.io.File;
import java.util.*;
public class wordle
{
    static String[] words=new String[5757];
	public static String choose(String s,int i)
	{
		if(s.charAt(4)!='s')
		{
			return s;
		}
		if(i==5756)
		return choose(words[0],0);
		return choose(words[i+1],i+1);
	}
    public static void setup() throws java.io.IOException,java.io.FileNotFoundException
    {
        File file=new File("C:\\Users\\charu\\wordle5.txt");
        FileInputStream fis=new FileInputStream(file);
        int i=0;
        int r=0;
	String m="";
        while(r!=-1)
        {
            r=fis.read();
            if(r>=97&&r<=122)
            {
		m+=(char)r;
                if(m.length()==5)
		{	
		words[i]=m;
		m="";
                i++;
		}
                if(i==5757)
                break;
            }
        }
    }
    public static int check(String s)
    {
            int i;
            for(i=0;i<5757;i++)
            {
                if(words[i].equals(s))
                break;
            }
            if(i==5757)
            return -1;

        return 0;
    }
    public static void main(String[] args) throws java.io.IOException
    {
        setup();
        Scanner sc=new Scanner(System.in);
        int c=1;
        while(c!=0)
        {
	    System.out.println("\n");
            String word="";
            String ans="";
            int r;
            int l=(int)(Math.random()*5756);
            word=words[l];
	    word=choose(word,l);
            l=6;
            for(l=0;l<6;l++)
            {
                ans=sc.next();
                if(ans.equals(word))
                {
                    System.out.println("Right!");
                    break;
                }
                int i=check(ans);
                if(i==-1||ans.length()!=5)
                {
                    System.out.println("INVALID!\n");
                    l--;
                    continue;
                }
                for(i=0;i<5;i++)
                {
                    if(ans.charAt(i)==word.charAt(i))
                    System.out.print("*");
                    else if(word.contains(ans.substring(i,i+1)))
                    System.out.print(".");
                    else
                    System.out.print("-");
                }
		System.out.println("\n");
            }
            if(l==6)
            System.out.println("\nYou lost! The word was: "+word);
            System.out.println("Play again?");
            c=sc.nextInt();
        }
    }
}