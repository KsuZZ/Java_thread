import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//������ �������, ����������� ���������� ������ ������������� �������
public class lab3 extends Applet  implements ActionListener, ItemListener
{ 
int flag1 = 0;
Panel p1, p2, p3, p4, p5, p6, p7, p8, p0;
Canvas Can;
Button b1, b2, b3, b4;
CardLayout cardLayout;
List ls;
CheckboxGroup cb;
Checkbox cb1, cb2, cb3, cb4;
Label l1;
 SecondPotok secondPotok;
 FirstPotok firstPotok;
 ThirdPotok thirdPotok;
 FourthPotok fourthPotok;
Color col1, col2, col3, col4, col5, col6;
boolean flag = false; 
 int rw1=1, rw2=1, rw3=1, rw4h=1, rw4w=1;
  final static int MAX_RW1 = 100;
  final static int MAX_RW2 = 100;
  final static int MAX_RW3 = 100;
  final static int MAX_RW4 = 100;
  final static int MAX_RW5 = 100;
 int figure;
 int w;
 boolean b01=true, b02=false, b03=false, b04=false;
 
 public void init()
 {
	 	setBackground(new Color(255,255,255)); //���� ����
	
	//�������� ������, � �������� �� ��������
	col1 = new Color(215,215,215);
	col2 = new Color(235,235,235);
	col3 = new Color(225,225,225);
	col4 = new Color(235,235,235);
	
	col5 = new Color(240, 5, 245);
	col6 = new Color(200, 200, 200);
	
	//������� ��������� ���������, ������� �� ����� �������� � ������
	rw1 = MAX_RW1;
	rw2 = MAX_RW2;
	rw3 = MAX_RW3;
	rw4w = MAX_RW4;
	rw4h = MAX_RW5;

	//������� ������������ ������� �������
	setLayout(new GridLayout(2,2));
	 
	 
	 //� ������ �0 ����������� ����� � ������� ������ �������
	 //� ������ ������ ������� ����������� ������ �1 � �����-��������
    p0 = new Panel();
	p1 = new Panel();
p0.setBackground(col1);
p1.setBackground(col1);

//�������� �����
l1 = new Label("�������� ������:",Label.CENTER);
p0.setLayout(new GridLayout(2,1));

//�������� �����-������, �������������� ������ �������
p1.setLayout(new GridLayout(2,2));
cb = new CheckboxGroup();
cb1 = new Checkbox("��� ������",cb,true);
cb1.addItemListener(this);
cb2 = new Checkbox("1-� ������",cb,false);
cb2.addItemListener(this);
cb3 = new Checkbox("2-� ������",cb,false);
cb3.addItemListener(this);
cb4 = new Checkbox("3-� ������",cb,false);
cb4.addItemListener(this);
//������� �����-������ � ������ �1
p1.add(cb1); 
p1.add(cb2);
p1.add(cb3);
p1.add(cb4);
//������� Label � ������ �0
p0.add(l1);
//������� ������ �1 � ������ �0
p0.add(p1);
add(p0);

//������ ��� ������
p2 = new Panel();
p2.setBackground(col2);
p2.setLayout(new GridLayout(1,1)); 
//�������� ������ ������, � ������� ������������ ������� ������
ls = new List(9);
ls.add("������");
ls.add("�����");
ls.add("�������");
ls.add("�������");
ls.add("������");
ls.add("���������");
ls.add("�������");
ls.add("����������");
ls.add("�����-�����");
//��������� �������� "������"
ls.select(0);
ls.setEnabled(true);
ls.addActionListener(this); //actionPerformed(ActionEvent e) [ActionListener]
p2.add(ls);
add(p2);

	 //������ � �������� �������� ������� �����
	 p3 = new Panel();
     p3.setLayout(new GridLayout(2,2) ); 
	 b1 = new Button ("�������");
	 p3.add(b1);	 
	 b2 = new Button ("����");
	 p3.add(b2);	 
	 b3 = new Button ("�����������");
	 p3.add(b3);	 
	 b4 = new Button ("������");
	 p3.add(b4);	 
	 
	 //������ ��� ���������
	 p4 = new Panel();
	 p4.setLayout(new BorderLayout());
	 
	 //��������� ��������
	 b1.addActionListener(new ActionListener() 
	 {
		 public void actionPerformed(ActionEvent e)
		 {  
			if("�������".equals(e.getActionCommand()))
	       { b01=true;
			b02=false;
			b03=false;
	        b04=false;}
		p4.repaint();
   		 }
	 });
	 
	 //��������� �����
	 b2.addActionListener(new ActionListener()
	 {
		 public void actionPerformed(ActionEvent e)
		 {  
			if("����".equals(e.getActionCommand()))
			{b01=false;
			b02=true;
			b03=false;
			b04=false;}
          p4.repaint();			
		 }
	 });
	 
	 //��������� ������������
	 b3.addActionListener(new ActionListener()
	 {
		 public void actionPerformed(ActionEvent e)
		 {  
		    if("�����������".equals(e.getActionCommand()))
			{b01=false;
			b02=false;
			b03=true;
			b04=false;}
			 p4.repaint();
		 }
	 });
	 
	 //��������� ������
	 b4.addActionListener(new ActionListener()
	 {
		 public void actionPerformed(ActionEvent e)
		 {  
			if("������".equals(e.getActionCommand())) 
		   {b01=false;
			b02=false;
			b03=false;
			b04=true;}
			p4.repaint();
       }
	 });
	 add(p3);

	 	 //������ � ������� ���������� ���������
Can = new Canvas(){
			 public void paint(Graphics g)
  {	  
	  //������ � ������ ���������� ��������
	  if(b01==true)
	  {
	  g.drawRect(rw1, 0, 100, 100);
	  }
	 
	 //������ � ������ ���������� �����
	 if(b02==true)
	 {
	  g.fillOval(10, 10, rw2/2, rw2/2);
	 }
	 
	 //������ � ������ ���������� ������������
	 if(b03==true)
	 {
		((Graphics2D)(g)).rotate(-(360/180+rw3/4), 90, 65); //����� �������� ������
      int[] xPoints = {65,115,90};
      int[] yPoints = {90,90,40};	  
		g.fillPolygon(xPoints, yPoints, 3);
	 }

	 //������� ������ ���������� ������
	 if(b04==true)
	 {
	  g.setFont(new Font("Courier", Font.BOLD, 15)); //��������� ������
	  g.drawString("J a v a", rw4w, rw4h);
	 }
         }
     };
  p4.add(Can, BorderLayout.CENTER);
  add(p4);
 }	 
  

	
 //��������� ����� ���� ����� �� �������� �������������
 public void actionPerformed(ActionEvent e)
{	 
        String acm = e.getActionCommand();
        if("������".equals(acm)) {Can.setForeground(Color.black);}//p02.setForeground(Color.black);p03.setForeground(Color.black);p04.setForeground(Color.black);}
        else if("�����".equals(acm)) {Can.setForeground(Color.blue);}//p02.setForeground(Color.blue);p03.setForeground(Color.blue);p04.setForeground(Color.blue);}
        else if("�������".equals(acm)) {Can.setForeground(Color.red);}//p02.setForeground(Color.red);p03.setForeground(Color.red);p04.setForeground(Color.red);}
        else if("�������".equals(acm)) {Can.setForeground(Color.green);}//p02.setForeground(Color.green);p03.setForeground(Color.green);p04.setForeground(Color.green);}
        else if("������".equals(acm)) {Can.setForeground(Color.yellow);}//p02.setForeground(Color.yellow);p03.setForeground(Color.yellow);p04.setForeground(Color.yellow);}
        else if("���������".equals(acm)) {Can.setForeground(Color.orange);}// p02.setForeground(Color.orange); p03.setForeground(Color.orange); p04.setForeground(Color.orange);} 
		else if("�������".equals(acm)) {Can.setForeground(Color.pink);}//p02.setForeground(Color.pink);p03.setForeground(Color.pink);p04.setForeground(Color.pink);}
        else if("����������".equals(acm)) {Can.setForeground(col5);}//p02.setForeground(col5);p03.setForeground(col5);p04.setForeground(col5);}
        else if("�����-�����".equals(acm)) {Can.setForeground(col6);}//p02.setForeground(col6);p03.setForeground(col6);p04.setForeground(col6);}
        Can.repaint();
		
		if (b1.equals(acm)) {b01=true;}
		else if (b2.equals(acm)) {b02=true;}
		else if (b3.equals(acm)) {b03=true;}
		else if (b4.equals(acm)) {b04=true;}
}
public void itemStateChanged(ItemEvent ie)
{
	 //��������� ��� ������������ ��������, � ����������� �� �������� ������������
     if(cb1.getState())//"��� ������" �������
       {
        ls.setEnabled(true);
        b1.setEnabled(true);
		b2.setEnabled(true); 
		b3.setEnabled(true);
		b4.setEnabled(true);
		p1.repaint(); p2.repaint(); p3.repaint(); p4.repaint();
       }
      if(cb2.getState())//"1-� ������" �������
       {
		ls.setEnabled(true);
        b1.setEnabled(false);
		b2.setEnabled(false); 
		b3.setEnabled(false);
		b4.setEnabled(false);
		p1.repaint(); p2.repaint(); p3.repaint(); p4.repaint();
       }
	   if(cb3.getState())//"2-� ������"  �������
       {
		ls.setEnabled(false);
        b1.setEnabled(true);
		b2.setEnabled(true); 
		b3.setEnabled(true);
		b4.setEnabled(true);		
		p1.repaint(); p2.repaint(); p3.repaint(); p4.repaint();
       }
	  if(cb4.getState())//"3-� ������" �������
       {
		ls.setEnabled(false);
        b1.setEnabled(false);
		b2.setEnabled(false); 
		b3.setEnabled(false);
		b4.setEnabled(false);
		p1.repaint(); p2.repaint(); p3.repaint(); p4.repaint();
       }
}

//���������� ������� ������, ����������� �� ���������� ��������
class SecondPotok extends Thread{
    synchronized public void run() {
		Thread me = Thread.currentThread();
	while(secondPotok == me) {
	  int s = (getSize().width)/4;
    try {
		wait(10);
	 for (int i=0; i<s; i++) {
		 rw1 = i;
	     Can.repaint();    
         Thread.currentThread().sleep(15); // ������������� �����
	  }	
	  for (int i=s; i>0; i--) {
		  rw1 = i;
	      Can.repaint();    
          Thread.currentThread().sleep(15); // ������������� �����
	  }
		notify(); //��������
		} catch (InterruptedException e) {
			return;
		}
	   }
	  }
	}
//���������� ������� ������, ����������� �� ���������� �����
class FirstPotok extends Thread{
	synchronized public void run(){
		Thread me = Thread.currentThread();
		while(firstPotok == me){		
					int s = (getSize().width)/4;
    try {
		wait(10);
	 for (int i=0; i<s; i++) {
		 rw2 = i;
	     Can.repaint();    
         Thread.currentThread().sleep(15); // ������������� �����
	  }	
	  for (int i=s; i>0; i--) {
		  rw2 = i;
	      Can.repaint();    
          Thread.currentThread().sleep(15); // ������������� �����
	  }
		notify(); //��������
		} catch (InterruptedException e) {
			return;
		}
		}
	}
	}
//���������� �������� ������, ����������� �� ���������� ������������
class ThirdPotok extends Thread{
	synchronized public void run(){
		Thread me = Thread.currentThread();
		while(thirdPotok == me){		
					int s = (getSize().width)/4;
    try {
		wait(10);
	 for (int i=0; i<s; i++) {
		 rw3 = i;
	     Can.repaint();    
         Thread.currentThread().sleep(15); // ������������� �����
	  }	
	  for (int i=s; i>0; i--) {
		  rw3 = i;
	      Can.repaint();    
          Thread.currentThread().sleep(15); // ������������� �����
	  }
		notify(); //��������
		} catch (InterruptedException e) {
			return;
		}
		}
	}
	}
//���������� ���������� ������, ����������� �� ���������� ������
class FourthPotok extends Thread{
	synchronized public void run(){
		Thread me = Thread.currentThread();
		while(fourthPotok == me){		
		int s = (getSize().width)/4 + 50;
		int g = (getSize().width)/4 - 50;
    try {
		wait(10);
	for (int i=s; i>10; i--) {
		  rw4w = i;
	      Can.repaint();    
          Thread.currentThread().sleep(10); // ������������� �����
	  }
	  for (int i=g; i>10; i--) {
		 rw4h = i;
	     Can.repaint();    
         Thread.currentThread().sleep(10); // ������������� �����
	  }	
	 for (int i=10; i<s; i++) {
		 rw4w = i;
	     Can.repaint();    
         Thread.currentThread().sleep(10); // ������������� �����
	  }	
	  for (int i=10; i<g; i++) {
		 rw4h = i;
	     Can.repaint();    
         Thread.currentThread().sleep(10); // ������������� �����
	  }	
		notify(); //��������
		} catch (InterruptedException e) {
			return;
		}
		}
	}
	}
	 	public void start(){
			secondPotok = new SecondPotok();
			secondPotok.start();
			firstPotok = new FirstPotok();
			firstPotok.start();
			thirdPotok = new ThirdPotok();
			thirdPotok.start();
            fourthPotok = new FourthPotok();
			fourthPotok.start();
	}
	
	public void stop() {
	secondPotok = null;
	firstPotok = null;
	thirdPotok = null;
    fourthPotok = null;
	}
}