import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui {
	public int rating[]=new int[10];
	public int movid[]=new int[10];
	ArrayList<Integer> ratinglist= new ArrayList<>();
	ArrayList<Integer> movidlist= new ArrayList<>();
	
	public void print()
	{	
		for(int i=0;i<ratinglist.size();i++)
		{System.out.println(movidlist.get(i)+",11,"+ratinglist.get(i));
		}
	}

	public void display()
	{
		final JFrame f1 = new JFrame("NETFLIX User Recommendation System");
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel l[]= new JLabel[11];
		final JLabel mid[]= new JLabel[11];
		final JTextField tf[]= new JTextField[11];
	
		JPanel p[]= new JPanel[11];
		JPanel pmain = new JPanel(new GridLayout(11,1));
		
		ImageIcon image = new ImageIcon("logo.jpg");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		JPanel imgpnl = new JPanel(new BorderLayout(10,40));
		imgpnl.add( label, BorderLayout.CENTER );
		try
		{
			BufferedReader file = new BufferedReader(new FileReader("1.txt"));
			String s;

			int i=0;
			while((s=file.readLine())!=null)
			{
				StringTokenizer st=new StringTokenizer(s,",");
				int k=0;
			
				
				while(st.hasMoreTokens()==true)
				{
				
				if(k==0)
				{mid[i]= new JLabel(st.nextToken());
				//System.out.println(mid[i].getText());
				}
				
				if(k==1)
				{l[i]= new JLabel(st.nextToken());
			//	System.out.println(l[i].getText());
				}
				
				
				tf[i] = new JTextField(2);
				k++;
				}
				i++;
			
				
			}

			file.close();
			
		}
		catch(Exception e)
		{	System.out.println("Input File not Found");
			e.printStackTrace();
		}
		
		int i;
			for(i=0;i<10;i++)
		{
			p[i]= new JPanel();
			p[i].setLayout(new GridLayout(1,3));
			JPanel t1 = new JPanel();
			JPanel t2 = new JPanel();
			JPanel t3 = new JPanel();
			t1.add(l[i]);
			t2.add(mid[i]);
			t3.add(tf[i]);
			
			p[i].add(t1);
			p[i].add(t2);
			p[i].add(t3);
			pmain.add(p[i]);
		}
		//	System.out.println("Fine til here");
		JButton sub = new JButton("Submit");
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{	
				for(int i=0;i<10;i++)
				{	if(!tf[i].getText().equals(""))
					{//System.out.println("Loop entered *"+tf[i].getText()+"*");
					rating[i] = Integer.parseInt(tf[i].getText());
					movid[i]= Integer.parseInt(mid[i].getText());
				//	System.out.println("Rating: "+rating[i]+"Movie ID: "+movid[i]);
					 ratinglist.add(Integer.parseInt(tf[i].getText()));
					 movidlist.add(Integer.parseInt(mid[i].getText()));
					}
				}
				print();
				f1.dispose();
			}
		}
				);
		JPanel pmain2= new JPanel();
		pmain2.add(sub);
		imgpnl.setSize(200, 100);
		pmain.setLayout(new GridLayout(10,1,0,0));
		//f1.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
		
		f1.setLayout(new GridLayout(3,1));
		f1.add(imgpnl,BorderLayout.NORTH);
		f1.add(pmain,BorderLayout.CENTER);
		f1.add(pmain2,BorderLayout.SOUTH);
		f1.setLocation(370, 20);
		f1.setVisible(true);
		f1.setSize(600,700);
	}

}
