package chapter_1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext())
		{
			boolean flag=true;
			int x=sc.nextInt();
			String arr[]=new String[x];
			for(int i=0;i<x;i++)
				arr[i]=sc.next();
			for(int i=0;i<x-1;i++)
			{
				if(arr[i].charAt(arr[i].length()-1)!=arr[i+1].charAt(0))
				{
					flag=false;
					break;
				}
			}
			if(flag==true)
				System.out.println("Yes");
			else
				System.out.println("No");
			
		}
		sc.close();
	}
}
