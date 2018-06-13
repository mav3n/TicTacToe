/*	Tic Tac Toe Game - GUI Code Class */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class T3Game extends JFrame
{
	JLabel info,title1,title2,lin;
	JButton[] b = new JButton[9];
	JButton again,tTit,tVal;
	JPanel pa,pc,pb,pax,pa1,pa2;
	JComboBox lcb;
	DefaultComboBoxModel model;
	ImageIcon iO,iX,t1,t2,ico;
	Timer tr;
	int r,c;
	int x,y;
	int btnPos;
	long h,m,s,l=0;
	int level = 1;
	String time;
	T3Logic t3l;
	MiniMusicCmd mmc;
	static int first;
	String lev[] = {"Easy","Medium","Hard"};

	T3Game()
	{
		super("Tic Tac Toe");
		Font f = new Font("Comic-sans",Font.BOLD,16);
		t3l = new T3Logic();
		mmc = new MiniMusicCmd();

		iO = new ImageIcon(getClass().getResource("./img/o.png"));
		iX = new ImageIcon(getClass().getResource("./img/x.png"));
		t1 = new ImageIcon(getClass().getResource("./img/t3.png"));
		t2 = new ImageIcon(getClass().getResource("./img/t3.gif"));

		ico = new ImageIcon(getClass().getResource("./img/t3.png"));
		setIconImage(ico.getImage());

		title1 = new JLabel();	title1.setIcon(t1);
		title2 = new JLabel();	title2.setIcon(t2);
		info = new JLabel("\'O\' represents You and \'X\' represents Computer.");	info.setFont(f);
		lin = new JLabel("Easy"); lin.setVisible(false);

		tTit = new JButton("Time");	tTit.setEnabled(false);	tTit.setFont(f);	tTit.setBackground(Color.BLACK);
		tVal = new JButton("00:00:00");	tVal.setEnabled(false);	tVal.setFont(f);	tVal.setBackground(Color.BLACK);

		pa = new JPanel();
		pc = new JPanel();
		pb = new JPanel();
		pax = new JPanel();
		pa1 = new JPanel();
		pa2 = new JPanel();
		pa.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		pc.setLayout(new GridLayout(3,3,5,5));
		pb.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
		pax.setLayout(new GridLayout(2,1,5,0));
		pa1.setLayout(new GridLayout(2,1,5,0));
		pa1.setBackground(Color.BLACK);
		pa2.setLayout(new FlowLayout());
		pa2.setBorder(BorderFactory.createTitledBorder("Level"));

		lcb = new JComboBox();
		model = (DefaultComboBoxModel)lcb.getModel();
		for(String s : lev)
		{
			model.addElement(s);
		}
		lcb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				if(evt.getSource()==lcb)
				{
					level = lcb.getSelectedIndex() + 1;
				}
			}
		});

		first = 0;
// Annony Inner Class for Listener

		ActionListener al = new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				JButton cb=null;
				if(evt.getSource() instanceof JButton)
					cb = (JButton)evt.getSource();

				if(cb==again)
				{
					mmc.play(14,100);
					main("");
					dispose();
				}
				else if(evt.getSource() != tr)
				{
					if(first++ == 0)
					{
						tr = new Timer(1000,this);
						tr.start();

						lin.setText(lcb.getSelectedItem().toString());
						lcb.setVisible(false);
						lin.setVisible(true);
					}
					//mmc.play(14,100);
					mmc.play(116,81);
					//mmc.play(26,111);
					//mmc.play(120,68);

					cb.setIcon(iO);
					cb.setEnabled(false);
					cb.setBackground(new Color(50,255,30));

					if(cb==b[0]){	r=0;c=0;	}
					else if(cb==b[1]){	r=0;c=1;	}
					else if(cb==b[2]){	r=0;c=2;	}
					else if(cb==b[3]){	r=1;c=0;	}
					else if(cb==b[4]){	r=1;c=1;	}
					else if(cb==b[5]){	r=1;c=2;	}
					else if(cb==b[6]){	r=2;c=0;	}
					else if(cb==b[7]){	r=2;c=1;	}
					else if(cb==b[8]){	r=2;c=2;	}

					String res = t3l.userEntry(r,c,level);

					int x = t3l.getP();
					int y = t3l.getQ();

					if(x==0 & y==0)	btnPos=0;
					else if(x==0 & y==1)	btnPos=1;
					else if(x==0 & y==2)	btnPos=2;
					else if(x==1 & y==0)	btnPos=3;
					else if(x==1 & y==1)	btnPos=4;
					else if(x==1 & y==2)	btnPos=5;
					else if(x==2 & y==0)	btnPos=6;
					else if(x==2 & y==1)	btnPos=7;
					else if(x==2 & y==2)	btnPos=8;

					b[btnPos].setIcon(iX);
					b[btnPos].setEnabled(false);
					b[btnPos].setBackground(Color.RED);

					assert(res.equals("none") || res.equals("user") || res.equals("computer") || res.equals("tie")) : "res = "+res;

					if(!res.equals("none"))
					{
						for(int i=0;i<9;i++)
							b[i].setEnabled(false);

						tr.stop();
						again.setText("Play Again");
						mmc.play(126,93);
						//mmc.play(125,95);
					}
					if(res.equals("user"))
					{
						JOptionPane.showMessageDialog(T3Game.this,"Congratulations! You WON :) \nTime Elapsed "+time,"Result",JOptionPane.PLAIN_MESSAGE);
						info.setText("RESULT : You WON. Time("+time+")");
					}
					else if(res.equals("computer"))
					{
						JOptionPane.showMessageDialog(T3Game.this,"Sorry! Computer WINS :( \nTime Elapsed "+time,"Result",JOptionPane.PLAIN_MESSAGE);
						info.setText("RESULT : You LOST. Time("+time+")");
					}
					else if(res.equals("tie"))
					{
						JOptionPane.showMessageDialog(T3Game.this,"Match DRAW. Try a bit harder next time :)","Result",JOptionPane.INFORMATION_MESSAGE);
						info.setText("RESULT : Match DRAW :P");
					}
				}

				if(evt.getSource() == tr)
				{
					timer();
				}
			}
		};

		for(int i=0;i<9;i++)
		{
			b[i] = new JButton("");
			b[i].addActionListener(al);
			pc.add(b[i]);
		}
		again = new JButton("Restart");
		again.setBackground(Color.BLACK);again.setForeground(Color.WHITE);
		again.addActionListener(al);

		pa1.add(tTit);pa1.add(tVal);
		pa2.add(lcb);pa2.add(lin);
		pax.add(pa1);pax.add(pa2);
		pa.add(title1);pa.add(title2);pa.add(pax);
		pb.add(again);pb.add(info);

		add(pa,"North");	add(pc);	add(pb,"South");

// Annnoy Class object for Window Listener

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt)
			{
				int i = JOptionPane.showConfirmDialog(T3Game.this,"You are about to close The TicTacToe Game. \nAre you sure you want to continue?","Close TicTacToe",JOptionPane.YES_NO_OPTION);
				if(i == JOptionPane.YES_OPTION)
				{
					if(first>0)
						tr.stop();
					dispose();
				}
			}
			public void windowIconified(WindowEvent evt)
			{
				if(first>0)
					tr.stop();
			}
			public void windowDeiconified(WindowEvent evt)
			{
				if(first>0)
					tr.start();
			}
		});


		setSize(550,550);
		setResizable(false);
		//pack();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	}

	public void timer()
	{
		l++;
		s=l%60l;
		m=(l/60l)%60l;
		h=(l/(60l*60l))%60l;
		time = String.format("%02d:%02d:%02d",h,m,s);
		tVal.setText(time);
	}

	public static void main(String... s)
	{
		try{
			for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				//System.out.println(info.getName());
				if(info.getName().equals("Metal"))
				{
					UIManager.setLookAndFeel(info.getClassName());
				}
				//break;
			}
		}catch(Exception ex){}

		T3Game t3 = new T3Game();
		t3.setLocationRelativeTo(null);
		t3.setVisible(true);
	}
}

