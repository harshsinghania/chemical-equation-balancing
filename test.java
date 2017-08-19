package test;


import java.util.Scanner;

public class test {

	public static void main(String []args)
	{	System.out.println("ENTER THE EQUATION:");
		Scanner sc=new Scanner(System.in);
		String data=sc.nextLine();
		//String data="6CO2+6H2O=C6H12O6+6O2";
		//String data="O34567890K4567890=34567890O+K4567890";
		String Data[]=data.split("=");
		String left=Data[0];
		String right=Data[1];
		int limitleft=0,limitright=0;
		for(int i=0;i<left.length();i++)
		{
			if(Character.isUpperCase(left.charAt(i)))
				limitleft++;
		}
		for(int i=0;i<right.length();i++)
		{
			if(Character.isUpperCase(right.charAt(i)))
				limitright++;
		}
		
		String plus="\\+";
		String Left[]=left.split(plus);
		String Right[]=right.split(plus);
		String lout[]=new String[limitleft];
		int lout1[]=new int[limitleft];

		String rout[]=new String[limitright];
		int rout1[]=new int[limitright];
		 int lind=0,rind=0;
		for(int i=0;i<Left.length;i++)
		{
			String l=Left[i];
			int multiplier=1;
			
			for(int j=0;j<l.length();j++)
			{ 	char s=l.charAt(j);
				if(Character.isDigit(s) && multiplier==1)
				{ 
					multiplier=Character.getNumericValue(s);
				if(Character.isDigit(l.charAt(j+1)))
				{	j++;
					while(true)
					{	
						if(j<l.length() && Character.isDigit(l.charAt(j)))
						{	
							multiplier=multiplier*10+Character.getNumericValue(l.charAt(j));
							j++;
							
						}
						else
						{j--;
							break;
						}
					}
			//		System.out.println(multiplier);
				}
				}
				if(Character.isUpperCase(s))
				{
					int k=j+1;
					String temp=s+"";
					while(true)
					{
						if(k<l.length())
						{
							if(Character.isLowerCase(l.charAt(k)))
							{
								temp=temp+l.charAt(k);
							}
							if(Character.isUpperCase(l.charAt(k)) || Character.isDigit(l.charAt(k)))
							{
								break;
							}
							k++;
						}
						else 
							break;
					}
					
					lout[lind]=temp;
					int coff=1;
					if(k<l.length())
					if(Character.isDigit(l.charAt(k)))
					{	coff=Character.getNumericValue(l.charAt(k));
						k++;
						while(true)
						{	
							if(k<l.length() && Character.isDigit(l.charAt(k)))
							{
								coff=coff*10+Character.getNumericValue(l.charAt(k));
								k++;
								
							}
							else
								break;
						}
					}
					lout1[lind]=coff*multiplier;
					j=k-1;
					lind++;
					
				}
			}
			
			
		}
		for(int i=0;i<Right.length;i++)
		{
			String l=Right[i];
			int multiplier=1;
			
			for(int j=0;j<l.length();j++)
			{ 	char s=l.charAt(j);
			if(Character.isDigit(s) && multiplier==1)
			{ 
				multiplier=Character.getNumericValue(s);
			if(Character.isDigit(l.charAt(j+1)))
			{j++;
			while(true)
				{	
					if(j<l.length() && Character.isDigit(l.charAt(j)))
					{	
						multiplier=multiplier*10+Character.getNumericValue(l.charAt(j));
						j++;
						
					}
					else 
					{j--;
						break;
					}
				}
		//		System.out.println(multiplier);
			}
			}
				if(Character.isUpperCase(s))
				{
					int k=j+1;
					String temp=s+"";
					while(true)
					{
						if(k<l.length())
						{
							if(Character.isLowerCase(l.charAt(k)))
							{
								temp=temp+l.charAt(k);
							}
							if(Character.isUpperCase(l.charAt(k)) || Character.isDigit(l.charAt(k)))
							{
								break;
							}
							k++;
						}
						else 
							break;
					}
					
					rout[rind]=temp;
					int coff=1;
					if(k<l.length())
					if(Character.isDigit(l.charAt(k)))
					{	coff=Character.getNumericValue(l.charAt(k));
						k++;
						while(true)
						{	
							if(k<l.length() && Character.isDigit(l.charAt(k)))
							{
								coff=coff*10+Character.getNumericValue(l.charAt(k));
								k++;
								
							}
							else
								break;
						}
					}
					rout1[rind]=coff*multiplier;
					j=k-1;
					rind++;
					
				}
			}
			
			
		}
		for(int i=0;i<limitleft;i++)
		{	for(int j=i+1;j<limitleft;j++)
			{  
				if(lout[i].equals(lout[j]))
				{
					lout1[i]=lout1[i]+lout1[j];
					lout1[j]=0;
					lout[j]="xyzz";
					limitleft--;
				}
			}
		}
		int r=limitright;
		for(int i=0;i<r;i++)
		{	for(int j=i+1;j<r;j++)
			{  
				if(rout[i].equals(rout[j]))
				{
					rout1[i]=rout1[i]+rout1[j];
					rout1[j]=0;
					rout[j]="xyzz";
					limitright--;
				}
			}
		}
		/*for(int i=0;i<rout.length;i++)
			System.out.println(rout[i]+" "+rout1[i]);*/
		System.out.println("****************");
		System.out.println("LEFT SIDE:");
		for(int i=0;i<limitleft;i++)
			System.out.println(lout[i]+" "+lout1[i]);
		System.out.println("RIGHT SIDE:");
		for(int i=0;i<limitright;i++)
			System.out.println(rout[i]+" "+rout1[i]);
		int res=0;
		for(int i=0;i<lout.length;i++)
		{
			for(int j=0;j<rout.length;j++)
			{
				if(lout[i].equals(rout[j]))
				{
					if(lout1[i]!=rout1[j])
						res++;
				}
			}
		}
		if(res==0)
			System.out.println("balanced");
		else
			System.out.println("unbalanced");
	}
}
