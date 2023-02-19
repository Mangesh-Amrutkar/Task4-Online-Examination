import java.util.*;
class OnlineExam
{
	Scanner sc = new Scanner(System.in);
	HashMap<String,Integer> info = new HashMap<String,Integer>();
	
	//Login of the user
	public void login()
	{
		info.put("XYZ1",101);
		info.put("XYZ2",102);
		info.put("XYZ3",103);
		info.put("XYZ4",104);
		info.put("XYZ5",105);
		String id;
		int password;
		System.out.println("---------------------LOGIN---------------------");
		System.out.println("Enter Username : ");
		id = sc.next();
		System.out.println("Enter Password : ");
		password = sc.nextInt();
		if(info.containsKey(id) && info.get(id)==password)
		{
			System.out.println("\nValid User.....");
			menu();
		}
		else
		{
			System.out.println("\nOops..You Entered wrong username or password.........");
			login();
		}
	}
	
	//Choice list 
	public void menu()
	{
		int choice;
		System.out.println("\nEnter Choice : ");
		System.out.println("1.Update your profile \n2.Start Exam \n3.Logout");
		choice = sc.nextInt();
		switch(choice)
		{
			case 1:
				info = update();
				menu();
				break;
			case 2:
				startExam();
				menu();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
		}
	}
	
	
	//Update user profile
	public HashMap<String,Integer> update()
	{
		String updt_id;
		int updt_pwd;
		System.out.println("Enter Username: ");
		updt_id = sc.next();
		System.out.println("Enter Old Password: ");
		updt_pwd = sc.nextInt();
		if(info.containsKey(updt_id) && info.get(updt_id)==updt_pwd)
		{
			System.out.println("Enter New Password : ");
			updt_pwd = sc.nextInt();
			info.replace(updt_id,updt_pwd);
			System.out.println("Your Profle is Updated");
		}
		else
		{
			System.out.println("Invalid User\n");
		}
		return info;
	}
	
	
	//Exam with timer and MCQ
	public void startExam()
	{
		long start = System.currentTimeMillis();
		long end = start + 30;
		int score = 0;
		int ans;

		while(System.currentTimeMillis()<end)
		{
			System.out.println("-------------------------------------------------------------");
			System.out.println("Q1.Which one of the following river flows between Vindhyan and Satpura ranges?");
			System.out.println("1.Narmada \t2.Mahanadi \t3.Son \t4.Netravati");
			System.out.print("Answer : ");
			ans = sc.nextInt();
			if(ans == 1)
				score+=5;
			else
				score--;

			System.out.println("-------------------------------------------------------------");
			System.out.println("Q2.The Central Rice Research Station is situated in? ");
			System.out.println("1. Chennai\t2. Cuttak\t3. Banglore \t4. None");
			System.out.print("Answer : ");
			ans = sc.nextInt();
			if(ans == 2)
				score+=5;
			else
				score--;

			System.out.println("-------------------------------------------------------------");
			System.out.println("Q3.Who among the following wrote Sanskrit grammar?");
			System.out.println("1. Kalidasa\t2. Charak\t3. Panini\t4. Aryabhatt");
			System.out.print("Answer : ");
			ans = sc.nextInt();
			if(ans == 3)
				score+=5;
			else
				score--;

			System.out.println("-------------------------------------------------------------");
			System.out.println("Q4.Which among the following headstreams meets the Ganges in last?");
			System.out.println("1. Alaknanda\t2. Pindar\t3. Mandakini\t4.Bhagirathi");
			System.out.print("Answer : ");
			ans = sc.nextInt();
			if(ans == 4)
				score+=5;
			else
				score--;

			System.out.println("-------------------------------------------------------------");
			System.out.println("Q5.The metal whose salts are sensitive to light is");
			System.out.println("1. Zinc\t2.Silver\t3. Copper\t4.Aluminium");
			System.out.print("Answer : ");
			ans = sc.nextInt();
			if(ans == 2)
				score+=5;
			else
				score--;
			System.out.println("-------------------------------------------------------------");
			break;
		}
		System.out.println("Time is Over");
		System.out.println();
		System.out.println("Your totdal score is: "+score);
		if(score>10)
			System.out.println("Yeah!!!You are pass..");
		else
			System.out.println("Sorry You are fail..");
	}
	
	//main method
	public static void main(String args[])
	{
		OnlineExam obj  = new OnlineExam();
		obj.login();
	}
}