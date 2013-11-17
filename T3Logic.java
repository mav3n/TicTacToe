/*	Tic Tac Toe Logic	*/

import static java.lang.System.*;

class T3Logic
{
	 int p,q;
	 int level = 1;
	 String res="none";
	 
	 char ar[][] = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
	 
	 int getP()
	 {
		 return p;
	 }
	 int getQ()
	 {
		 return q;
	 }

	 String userEntry(int r, int c ,int lev)
	 {
		 level = lev;
		 if(ar[r][c]==' ')
		 {
			 ar[r][c]='O';
			 try{
				Thread.sleep(500);
			 }catch(Exception ee){}
			 if(checkWin())
				return res;
			 else
			 {
				 if(!deFault(1))
				 {	if(!comp(r,c,'O','X'))
						if(!deFault(2))
						 lastChoice();
				 }
				 if(checkWin())
					return res;
			}
		}
		else
			out.println("\nPosition Already Filled!!");
		return res;
	 }

	 boolean deFault(int a)
	 {
		boolean flag = false;

		full:    for(int i=0;i<3;i++)
				 {
					 for(int j=0;j<3;j++)
					 {
						 if(ar[i][j]=='X')
						 {
							 if(a==1)
								flag = comp(i,j,'X','X');
							 else if(a==2)
								flag = comp(i,j,' ','X');
							 if(flag)
								break full;
						 }
					 }
				 }
		return flag;
	}

	void lastChoice()
	{
		if(level==1)
		{
			boolean flag = true;
			do
			{
				p = (int)(Math.random()*3);
				q = (int)(Math.random()*3);
				if(ar[p][q]==' ')
				{
					ar[p][q] = 'X';
					flag = false;
				}
			}while(flag);		
		}
		else if(level==2)
		{
			if(ar[1][1]==' ' || ar[0][0]==' ' || ar[0][2]==' ' || ar[2][0]==' ' || ar[2][2]==' ')
			{
				boolean flag = true;
				do
				{
					p = (int)(Math.random()*3);
					q = (int)(Math.random()*3);
					if((((p==0 || p==2) && (q==0 || q==2)) || (p==1 && q==1)) && ar[p][q]==' ')
					{
						ar[p][q] = 'X';
						flag = false;
					}
				}while(flag);	
			}
			else
			{
				boolean flag = true;
				do
				{
					p = (int)(Math.random()*3);
					q = (int)(Math.random()*3);
					if(ar[p][q]==' ')
					{
						ar[p][q] = 'X';
						flag = false;
					}
				}while(flag);
			}
		}
		else if(level==3)
		{
			if(ar[1][1]==' ')
			{
				ar[1][1]='X';
				p=1;q=1;
			}
			else if(ar[0][0]==' ' || ar[0][2]==' ' || ar[2][0]==' ' || ar[2][2]==' ')
			{
				boolean flag = true;
				do
				{
					p = (int)(Math.random()*3);
					q = (int)(Math.random()*3);
					if((p==0 || p==2) && (q==0 || q==2) && ar[p][q]==' ')
					{
						ar[p][q] = 'X';
						flag = false;
					}
				}while(flag);
			}
			else
			{
				boolean flag = true;
				do
				{
					p = (int)(Math.random()*3);
					q = (int)(Math.random()*3);
					if(ar[p][q]==' ')
					{
						ar[p][q] = 'X';
						flag = false;
					}
				}while(flag);
			}
		}
		//System.out.println("Level :: "+level);
    }

	boolean checkWin()
	{
		 boolean flag=true;

		 if((ar[0][0]=='O' && ar[0][1]=='O' && ar[0][2]=='O') || (ar[1][0]=='O' && ar[1][1]=='O' && ar[1][2]=='O') || (ar[2][0]=='O' && ar[2][1]=='O' && ar[2][2]=='O') || (ar[0][0]=='O' && ar[1][0]=='O' && ar[2][0]=='O') || (ar[0][1]=='O' && ar[1][1]=='O' && ar[2][1]=='O') || (ar[0][2]=='O' && ar[1][2]=='O' && ar[2][2]=='O') || (ar[0][0]=='O' && ar[1][1]=='O' && ar[2][2]=='O') || (ar[0][2]=='O' && ar[1][1]=='O' && ar[2][0]=='O'))
			res = "user";
		 else if((ar[0][0]=='X' && ar[0][1]=='X' && ar[0][2]=='X') || (ar[1][0]=='X' && ar[1][1]=='X' && ar[1][2]=='X') || (ar[2][0]=='X' && ar[2][1]=='X' && ar[2][2]=='X') || (ar[0][0]=='X' && ar[1][0]=='X' && ar[2][0]=='X') || (ar[0][1]=='X' && ar[1][1]=='X' && ar[2][1]=='X') || (ar[0][2]=='X' && ar[1][2]=='X' && ar[2][2]=='X') || (ar[0][0]=='X' && ar[1][1]=='X' && ar[2][2]=='X') || (ar[0][2]=='X' && ar[1][1]=='X' && ar[2][0]=='X'))
			res = "computer";
		 else if(ar[0][0]!=' ' && ar[0][1]!=' ' && ar[0][2]!=' ' && ar[1][0]!=' ' && ar[1][1]!=' ' && ar[1][2]!=' ' && ar[2][0]!=' ' && ar[2][1]!=' ' && ar[2][2]!=' ')
			res = "tie";
		 else
			flag=false;

		return flag;
	}

	 boolean comp(int r, int c, char o, char x)
	 {
		 boolean flag=true;
		 if(r==0 && c==0)
		 {
			 if(ar[1][0]==o && ar[2][0]==' ')
			 {	ar[2][0]=x;	p=2;q=0;	}
			 else if(ar[0][1]==o && ar[0][2]==' ')
			 {	ar[0][2]=x;	p=0;q=2;	}
			 else if(ar[1][1]==o && ar[2][2]==' ')
			 {  ar[2][2]=x;	p=2;q=2;	}
			 else if(ar[1][0]==' ' && ar[2][0]==o)
			 {	ar[1][0]=x;	p=1;q=0;	}
			 else if(ar[0][1]==' ' && ar[0][2]==o)
			 {	ar[0][1]=x;	p=0;q=1;	}
			 else if(ar[1][1]==' ' && ar[2][2]==o)
			 {  ar[1][1]=x;	p=1;q=1;	}
			 else
				flag = false;
		}
		else if(r==0 && c==1)
		{
			 if(ar[1][1]==o && ar[2][1]==' ')
			 {	ar[2][1]=x;	p=2;q=1;	}
			 else if(ar[1][1]==' ' && ar[2][1]==o)
			 {	ar[1][1]=x;	p=1;q=1;	}
			 else if(ar[0][2]==o && ar[0][0]==' ')
			 {	ar[0][0]=x;	p=0;q=0;	}
			 else if(ar[0][2]==' ' && ar[0][0]==o)
			 { 	ar[0][2]=x;	p=0;q=2;	}
			 else
			 	flag = false;
		}
		else if(r==0 && c==2)
		{
			 if(ar[1][1]==o && ar[2][0]==' ')
			 {	ar[2][0]=x;	p=2;q=0;	}
			 else if(ar[1][1]==' ' && ar[2][0]==o)
			 {	ar[1][1]=x;	p=1;q=1;	}
			 else if(ar[0][1]==o && ar[0][0]==' ')
			 {  ar[0][0]=x;	p=0;q=0;	}
			 else if(ar[0][1]==' ' && ar[0][0]==o)
			 {	ar[0][1]=x;	p=0;q=1;	}
			 else if(ar[1][2]==' ' && ar[2][2]==o)
			 {	ar[1][2]=x;	p=1;q=2;	}
			 else if(ar[2][2]==' ' && ar[1][2]==o)
			 {  ar[2][2]=x;	p=2;q=2;	}
			 else
				flag = false;
		}
		else if(r==1 && c==0)
		{
			if(ar[1][1]==o && ar[1][2]==' ')
			{	ar[1][2]=x;	p=1;q=2;	}
			else if(ar[1][1]==' ' && ar[1][2]==o)
			{	ar[1][1]=x;	p=1;q=1;	}
			else if(ar[0][0]==o && ar[2][0]==' ')
			{	ar[2][0]=x;	p=2;q=0;	}
			else if(ar[0][0]==' ' && ar[2][0]==o)
			{	ar[0][0]=x;	p=0;q=0;	}
			else
				flag = false;
		}
		else if(r==1 && c==1)
		{
			int ran = (int)(Math.random()*5)+1;
			System.out.println(ran);
			switch(ran)
			{
				case 1:
				{	
					 if(ar[0][1]==o && ar[2][1]==' ')
					 {  ar[2][1]=x; p=2;q=1;	}
					 else if(ar[0][1]==' ' && ar[2][1]==o)
					 {	ar[0][1]=x; p=0;q=1;	}
					 else if(ar[1][0]==' ' && ar[1][2]==o)
					 {	ar[1][0]=x; p=1;q=0;	}
					 else if(ar[1][0]==o && ar[1][2]==' ')
					 {  ar[1][2]=x; p=1;q=2;	}
					 else if(ar[0][2]==' ' && ar[2][0]==o)
					 {	ar[0][2]=x; p=0;q=2;	}
					 else if(ar[0][2]==o && ar[2][0]==' ')
					 {  ar[2][0]=x; p=2;q=0;	}
					 else if(ar[0][0]==o && ar[2][2]==' ')
					 {	ar[2][2]=x; p=2;q=2;	}
					 else if(ar[0][0]==' ' && ar[2][2]==o)
					 {	ar[0][0]=x; p=0;q=0;	}
					 else
						flag = false;
					 break;
				}
				case 2:
				{
					 if(ar[0][1]==' ' && ar[2][1]==o)
					 {	ar[0][1]=x; p=0;q=1;	}
					 else if(ar[0][1]==o && ar[2][1]==' ')
					 {  ar[2][1]=x; p=2;q=1;	}
					 else if(ar[1][0]==o && ar[1][2]==' ')
					 {  ar[1][2]=x; p=1;q=2;	}
					 else if(ar[1][0]==' ' && ar[1][2]==o)
					 {	ar[1][0]=x; p=1;q=0;	}
					 else if(ar[0][2]==o && ar[2][0]==' ')
					 {  ar[2][0]=x; p=2;q=0;	}
					 else if(ar[0][2]==' ' && ar[2][0]==o)
					 {	ar[0][2]=x; p=0;q=2;	}
					 else if(ar[0][0]==' ' && ar[2][2]==o)
					 {	ar[0][0]=x; p=0;q=0;	}
					 else if(ar[0][0]==o && ar[2][2]==' ')
					 {	ar[2][2]=x; p=2;q=2;	}
					 else
						flag = false;
					 break;
				}
				case 3:
				{	
					 if(ar[1][0]==' ' && ar[1][2]==o)
					 {	ar[1][0]=x; p=1;q=0;	}
					 else if(ar[1][0]==o && ar[1][2]==' ')
					 {  ar[1][2]=x; p=1;q=2;	}
					 else if(ar[0][1]==' ' && ar[2][1]==o)
					 {	ar[0][1]=x; p=0;q=1;	}
					 else if(ar[0][1]==o && ar[2][1]==' ')
					 {  ar[2][1]=x; p=2;q=1;	}
					 else if(ar[0][0]==o && ar[2][2]==' ')
					 {	ar[2][2]=x; p=2;q=2;	}
					 else if(ar[0][0]==' ' && ar[2][2]==o)
					 {	ar[0][0]=x; p=0;q=0;	}
					 else if(ar[0][2]==o && ar[2][0]==' ')
					 {  ar[2][0]=x; p=2;q=0;	}
					 else if(ar[0][2]==' ' && ar[2][0]==o)
					 {	ar[0][2]=x; p=0;q=2;	}
					 else
						flag = false;
					 break;
				}
				case 4:
				{					 
					 if(ar[0][0]==' ' && ar[2][2]==o)
					 {	ar[0][0]=x; p=0;q=0;	}
					 else if(ar[0][0]==o && ar[2][2]==' ')
					 {	ar[2][2]=x; p=2;q=2;	}
					 else if(ar[0][2]==' ' && ar[2][0]==o)
					 {	ar[0][2]=x; p=0;q=2;	}
					 else if(ar[0][2]==o && ar[2][0]==' ')
					 {  ar[2][0]=x; p=2;q=0;	}
					 else if(ar[1][0]==o && ar[1][2]==' ')
					 {  ar[1][2]=x; p=1;q=2;	}
					 else if(ar[1][0]==' ' && ar[1][2]==o)
					 {	ar[1][0]=x; p=1;q=0;	}
					 else if(ar[0][1]==o && ar[2][1]==' ')
					 {  ar[2][1]=x; p=2;q=1;	}
					 else if(ar[0][1]==' ' && ar[2][1]==o)
					 {	ar[0][1]=x; p=0;q=1;	}
					 else
						flag = false;
					 break;
				}
				case 5:
				{	
					 if(ar[0][2]==o && ar[2][0]==' ')
					 {  ar[2][0]=x; p=2;q=0;	}
					 else if(ar[0][0]==' ' && ar[2][2]==o)
					 {	ar[0][0]=x; p=0;q=0;	}
					 else if(ar[0][2]==' ' && ar[2][0]==o)
					 {	ar[0][2]=x; p=0;q=2;	}
					 else if(ar[1][0]==o && ar[1][2]==' ')
					 {  ar[1][2]=x; p=1;q=2;	}
					 else if(ar[0][1]==' ' && ar[2][1]==o)
					 {	ar[0][1]=x; p=0;q=1;	}
					 else if(ar[0][0]==o && ar[2][2]==' ')
					 {	ar[2][2]=x; p=2;q=2;	}
					 else if(ar[1][0]==' ' && ar[1][2]==o)
					 {	ar[1][0]=x; p=1;q=0;	}
					 else if(ar[0][1]==o && ar[2][1]==' ')
					 {  ar[2][1]=x; p=2;q=1;	}
					 else
						flag = false;
					 break;
				}
			}
		}
		else if(r==1 && c==2)
		{
			 if(ar[1][1]==o && ar[1][0]==' ')
			 {	ar[1][0]=x; p=1;q=0;	}
			 else if(ar[1][1]==' ' && ar[1][0]==o)
			 {	ar[1][1]=x; p=1;q=1;	}
			 else if(ar[2][2]==o && ar[0][2]==' ')
			 {	ar[0][2]=x; p=0;q=2;	}
			 else if(ar[2][2]==' ' && ar[0][2]==o)
			 {	ar[2][2]=x; p=2;q=2;	}
			 else
				flag = false;
		}
		else if(r==2 && c==0)
		{
			 if(ar[1][1]==o && ar[0][2]==' ')
			 {	ar[0][2]=x; p=0;q=2;	}
			 else if(ar[1][1]==' ' && ar[0][2]==o)
			 {	ar[1][1]=x; p=1;q=1;	}
			 else if(ar[1][0]==o && ar[0][0]==' ')
			 {  ar[0][0]=x; p=0;q=0;	}
			 else if(ar[1][0]==' ' && ar[0][0]==o)
			 {	ar[1][0]=x; p=1;q=0;	}
			 else if(ar[2][1]==' ' && ar[2][2]==o)
			 {	ar[2][1]=x; p=2;q=1;	}
			 else if(ar[2][2]==' ' && ar[2][1]==o)
			 {  ar[2][2]=x; p=2;q=2;	}
			 else
				flag = false;
		}
		else if(r==2 && c==1)
		{
			 if(ar[1][1]==o && ar[0][1]==' ')
			 {	ar[0][1]=x; p=0;q=1;	}
			 else if(ar[1][1]==' ' && ar[0][1]==o)
			 {	ar[1][1]=x; p=1;q=1;	}
			 else if(ar[2][2]==o && ar[2][0]==' ')
			 {	ar[2][0]=x; p=2;q=0;	}
			 else if(ar[2][2]==' ' && ar[2][0]==o)
			 {	ar[2][2]=x; p=2;q=2;	}
			 else
				flag = false;
		}
		else if(r==2 && c==2)
		{
			 if(ar[1][1]==o && ar[0][0]==' ')
			 {	ar[0][0]=x; p=0;q=0;	}
			 else if(ar[1][1]==' ' && ar[0][0]==o)
			 {	ar[1][1]=x; p=1;q=1;	}
			 else if(ar[1][2]==o && ar[0][2]==' ')
			 {  ar[0][2]=x; p=0;q=2;	}
			 else if(ar[1][2]==' ' && ar[0][2]==o)
			 {	ar[1][2]=x; p=1;q=2;	}
			 else if(ar[2][0]==' ' && ar[2][1]==o)
			 {	ar[2][0]=x; p=2;q=0;	}
			 else if(ar[2][1]==' ' && ar[2][0]==o)
			 {  ar[2][1]=x; p=2;q=1;	}
			 else
				flag = false;
		}
		 return flag;
	 }
}
