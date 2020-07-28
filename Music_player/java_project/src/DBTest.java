import java.sql.*;
import java.util.Scanner;
import java.io.IOException;

public class DBTest {
	public static void main(String[] args) {

			Scanner Sinput= new Scanner(System.in);
			String url="jdbc:mariadb://localhost:3306/music_player";
			String user="root";
			String psw="rlawogud12@";
			String Mg_ID=null;
			boolean idcheck=false;
			int error=0;
			
			boolean check=true;
			int Input=0;
			try {
			Connection con = DriverManager.getConnection(url, user, psw);
			Statement stmt = con.createStatement();
	        //stmt.executeUpdate("INSERT INTO manager(Mgr_ID,Mgr_Name) VALUES('aza1200','Jae-Hyeong' )");
			
			while(true) {
				if(check==true) {
				System.out.println("\n----------Music Player----------\n");
				System.out.println("Welcome to music_player what do you want to do? :)\n" );
				System.out.println("0. Exit");
				System.out.println("1. Manager_menu");
				System.out.println("2. User_menu");
				System.out.print("Input : ");
				Input=Sinput.nextInt();
				String trash0=Sinput.nextLine();
				}
				if(Input==0)  System.exit(0);
				else if(Input==1) {
					
					if(idcheck==false) {
						System.out.print("What is your Mg_ID? : ");
						Mg_ID=Sinput.nextLine();
						StringBuilder hey=new StringBuilder();
						String sb111=hey.append("SELECT * FROM manager WHERE Mgr_ID=")
							 .append("'"+Mg_ID+"'")
							 .toString();
						if(Mg_ID.equals("0") && error>0 ) {
							check=true;
							continue;
						}
						ResultSet rs11=stmt.executeQuery(sb111);
						if(!rs11.next()) {
							if(error==5) {
								System.out.println("\n It is your last time be careful!!");
							}
							if(error>5) {
								System.out.println("Access denied Please debug again");
								System.exit(0);
							}
							error++;
							System.out.println("Wrong Input "+error+" times Press 0 if you want to get back");
							check=false;
							Input=1;
							continue;
						}
							

					}
					String name="SELECT * FROM manager WHERE Mgr_ID='"+Mg_ID+"'";
					ResultSet rs12=stmt.executeQuery(name);
					rs12.next();
					System.out.println("Welcome "+rs12.getString("Mgr_Name")+" Nice to meet you!!" );
					idcheck=true;
					error=0;
					//1. Manager menu
					System.out.println("\n----------Manager menu----------\n");
					System.out.println("0. Return to previous menu");
					System.out.println("1. Go into register menu");
					System.out.println("2. Go into delete menu");
					System.out.println("3. View List");
					System.out.print("Input : ");
					int Input1=Sinput.nextInt();
					String trash1=Sinput.nextLine();
					if(Input1==0) continue;
					else if(Input1==1) {
						//1 입력받는 거는 register menu 임
						System.out.println("\n----------Manager -> register----------\n");
						System.out.println("What do you want to register?");
						System.out.println("0.Return    1.music    2.user   3.artist    4.album");
						System.out.println("5.Coupn");
						System.out.print("Input : ");
						int Input1_1=Sinput.nextInt();
						String trash2=Sinput.nextLine();
						if(Input1_1==0) {
							check=false;
							Input=1;
							continue;
						}
						else if(Input1_1==1) {
							System.out.print("Music_Ssn : ");
							String Music_Ssn=Sinput.nextLine();
							System.out.print("Mg_ID : ");
							String Mg_IDs=Sinput.nextLine();
							System.out.print("Mu_Name : ");
							String Mu_Name=Sinput.nextLine();
							System.out.print("Genre : ");
							String Genre =Sinput.nextLine();
							StringBuilder sb1=new StringBuilder();
							String sql39 = sb1.append("Insert into "+ "music"+" VALUES(")
									.append("'"+Music_Ssn+"',")
									.append("'"+Mg_IDs+"',")
									.append("'"+Mu_Name+"',")
									.append("'"+Genre+"'")
									.append(");")
									.toString();
							try {
								stmt.executeUpdate(sql39);
							}catch (SQLException e) {
								e.printStackTrace();
							}
						}
						else if(Input1_1==2) {
							System.out.print("User_ID : ");
							String User_ID=Sinput.nextLine();
							System.out.print("Coupon_num : ");
							String Coupon_num=Sinput.nextLine();
							System.out.print("User_nickname : ");
							String User_nickname=Sinput.nextLine();
							StringBuilder sb1=new StringBuilder();
							String sql30 = sb1.append("Insert into "+ "User"+" VALUES(")
									.append("'"+User_ID+"',")
									.append("'"+Coupon_num+"',")
									.append("'"+User_nickname+"'")
									.append(");")
									.toString();
							try {
								stmt.executeUpdate(sql30);
							}catch (SQLException e) {
								e.printStackTrace();
							}
						}	
						else if(Input1_1==3) {
							System.out.print("Artist_name : ");
							String artist_num=Sinput.nextLine();
							System.out.print("Music num : ");
							int music_num=Sinput.nextInt();
							String trahs10=Sinput.nextLine();
							System.out.print("ALbum_num : ");
							int album_num=Sinput.nextInt();
							String trash40=Sinput.nextLine();
							System.out.print("IN_Group : ");
							String Group=Sinput.nextLine();
							StringBuilder sb1=new StringBuilder();
							String sql = sb1.append("Insert into "+ "artist"+" VALUES(")
									.append("'"+artist_num+"',")
									.append(music_num+",")
									.append(album_num+",")
									.append("'"+Group+"'")
									.append(");")
									.toString();
							try {
								stmt.executeUpdate(sql);
							}catch (SQLException e) {
								e.printStackTrace();
							}
						}
						else if(Input1_1==4) {
							System.out.print("Album_Ssn : ");
							String Album_Ssn=Sinput.nextLine();
							System.out.print("Artist_Name : ");
							String Artist_Name=Sinput.nextLine();
							System.out.print("Album_Birth : ");
							String Album_Birth=Sinput.nextLine();
							System.out.print("Songs_Num : ");
							int Songs_Num=Sinput.nextInt();
							String trash42=Sinput.nextLine();
				
							StringBuilder sb=new StringBuilder();
							String sql23 = sb.append("Insert into "+ "album"+" VALUES(")
									.append("'"+Album_Ssn+"',")
									.append("'"+Artist_Name+"',")
									.append("'"+Album_Birth+"',")
									.append(Songs_Num)
									.append(");")
									.toString();
							try {
								stmt.executeUpdate(sql23);
							}catch (SQLException e) {
								e.printStackTrace();
							}
						}
						else if(Input1_1==5) {
							System.out.print("Coupon_num : ");
							String coupon=Sinput.nextLine();
							System.out.print("Coupn name : ");
							String name1=Sinput.nextLine();
							System.out.print("Price : ");
							int price=Sinput.nextInt();
							String trash4=Sinput.nextLine();
							System.out.print("Validate : ");
							String date=Sinput.nextLine();
							/*
							stmt.executeUpdate("INSERT INTO Music_coupon(Service_num,Service_name,Price,Validity)"
									+ " VALUES('+coupon+','+name+',price,'+date+' )");
									*/
							StringBuilder sb=new StringBuilder();
							String sql = sb.append("Insert into "+ "Music_coupon"+" VALUES(")
									.append("'"+coupon+"',")
									.append("'"+name1+"',")
									.append(price+",")
									.append("'"+date+"'")
									.append(");")
									.toString();
							try {
								stmt.executeUpdate(sql);
							}catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
					else if(Input1==2) {
						System.out.println("\n----------Manager -> delete----------\n");
						System.out.println("What do you want to delete?");
						System.out.println("0.Return    1.music    2.user   3.artist    4.album");
						System.out.println("5.Music_Coupon ");
						System.out.print("Input : ");
						int Input1_2=Sinput.nextInt();
						String trash2=Sinput.nextLine();
						if(Input1_2==0) {
							check=false;
							Input=1;
							continue;
						}
						else if(Input1_2==1) {
							System.out.print("Enter the musci's Number -> (Primary key) : ");
							String Music_Ssn =Sinput.nextLine();
							StringBuilder sb=new StringBuilder();
							String sql=sb.append("Delete FROM music "
									+ "WHERE Music_Ssn=")
									.append("'"+Music_Ssn+"'")
									.toString();
							try {
								stmt.executeUpdate(sql);
							}
							catch(SQLException e){
								e.printStackTrace();
							}
						}
						else if(Input1_2==2) {
							System.out.print("Enter the User_ID -> (Primary key) : ");
							String User_ID =Sinput.nextLine();
							StringBuilder sb=new StringBuilder();
							String sql=sb.append("Delete FROM User "
									+ "WHERE User_ID=")
									.append("'"+User_ID+"'")
									.toString();
							try {
								stmt.executeUpdate(sql);
							}
							catch(SQLException e){
								e.printStackTrace();
							}
						}
						else if(Input1_2==3) {
							System.out.print("Enter the Art_Name -> (Primary key) : ");
							String Art_Name =Sinput.nextLine();
							StringBuilder sb=new StringBuilder();
							String sql=sb.append("Delete FROM artist "
									+ "WHERE Art_Name=")
									.append("'"+Art_Name+"'")
									.toString();
							try {
								stmt.executeUpdate(sql);
							}
							catch(SQLException e){
								e.printStackTrace();
							}
						}
						else if(Input1_2==4) {
							System.out.print("Enter the Album's Number -> (Primary key) : ");
							String Album_Ssn =Sinput.nextLine();
							StringBuilder sb=new StringBuilder();
							String sql=sb.append("Delete FROM album "
									+ "WHERE Album_Ssn=")
									.append("'"+Album_Ssn+"'")
									.toString();
							try {
								stmt.executeUpdate(sql);
							}
							catch(SQLException e){
								e.printStackTrace();
							}
						}
						else if(Input1_2==5) {
							System.out.print("Enter the music_coupon's Service_num -> (Primary key) : ");
							String Service_num=Sinput.nextLine();
							StringBuilder sb=new StringBuilder();
							String sql=sb.append("Delete FROM music_coupon "
									+ "WHERE Service_num=")
									.append("'"+Service_num+"'")
									.toString();
							try {
								stmt.executeUpdate(sql);
							}
							catch(SQLException e){
								e.printStackTrace();
							}
						}						
					}
					else if(Input1==3) {
						System.out.println("\n----------Manager -> view----------\n");
						System.out.println("0.Return    1.music    2.user   3.artist    4.album");
						System.out.println("5.playlist  6.payment  7.coupon");
						System.out.print("Input : ");
						int Input1_3=Sinput.nextInt();
						String trash3=Sinput.nextLine();
						if(Input1_3==0) {
							check=false;
							Input=1;
							continue;
						}
						else if(Input1_3==1) {
							ResultSet rs = stmt.executeQuery("SELECT * FROM music");
							System.out.println("\n------------------------------");
							int k=1;
							while(rs.next()) {
								System.out.print(k+" : ");
								String Music_Ssn=rs.getString("Music_Ssn");
								String Mg_IDs=rs.getString("Mg_ID");
								String Mu_Name=rs.getString("Mu_Name");
								String Genre=rs.getString("Genre");
								  System.out.println("(1)Music_Ssn : " + Music_Ssn + " (2)Mg_ID : " + Mg_IDs+" (3)Mu_Name "
								  		+ ": "+Mu_Name+" (4)Genre : "+Genre);
								  k++;
							}
							System.out.println("------------------------------");
						}
						else if(Input1_3==2) {
							ResultSet rs = stmt.executeQuery("SELECT * FROM User");
							System.out.println("\n------------------------------");
							int k=1;
							while(rs.next()) {
								System.out.print(k+" : ");
								String User_ID=rs.getString("User_ID");
								String Coupon_num=rs.getString("Coupon_num");
								String User_nickname=rs.getString("User_nickname");
								  System.out.println("(1)User_ID : " + User_ID + " (2)Coupon_num : " + Coupon_num+" (3)User_nickname "
								  		+ ": "+User_nickname);
								  k++;
							}
							System.out.println("------------------------------");
						}
						else if(Input1_3==3) {
							ResultSet rs = stmt.executeQuery("SELECT * FROM artist");
							System.out.println("\n------------------------------");
							int k1=1;
							while(rs.next()) {
								System.out.print(k1+" : ");
								String ArtistName=rs.getString("Art_Name");
								int Musicnum=rs.getInt("Music_Num");
								int Albumnum=rs.getInt("Album_Num");
								String Groupof=rs.getString("IN_group");
								  System.out.println("(1)Artist_Name : " + ArtistName + " (2)Music_Num : " + Musicnum+" (3)Albumnum "
								  		+ ": "+Albumnum+" (4)IN-gourp : "+Groupof);
								  k1++;
							}
							System.out.println("------------------------------");
						}
						else if(Input1_3==4) {
							ResultSet rs = stmt.executeQuery("SELECT * FROM album");
							System.out.println("\n------------------------------");
							int k1=1;
							while(rs.next()) {
								System.out.print(k1+" : ");
								String Album_Ssn=rs.getString("Album_Ssn");
								String Artist_Num=rs.getString("Artist_Name");
								String Album_Birth=rs.getString("Album_Birth");
								int Songs_Num=rs.getInt("Songs_Num");
								  System.out.println("(1)Album_Ssn : " + Album_Ssn + " (2)Artist_Name : " + Artist_Num+" (3)Album_Birth "
								  		+ ": "+Album_Birth+" (4)Songs_Num : "+Songs_Num);
								  k1++;
							}
							System.out.println("------------------------------");
						}
						else if(Input1_3==5) {
							ResultSet rs = stmt.executeQuery("SELECT * FROM playlist");
							System.out.println("\n------------------------------");
							int k1=1;
							while(rs.next()) {
								System.out.print(k1+" : ");
								String List_Ssn=rs.getString("List_Ssn");
								int Song_num=rs.getInt("song_num");
								String UserofID=rs.getString("Userof_ID");
								  System.out.println("(1)List_Ssn : " + List_Ssn + " (2)Songs_num : " +Song_num +" (3)UserofID "
								  		+ ": "+UserofID);
								  k1++;
							}
							System.out.println("------------------------------");
						}
						else if(Input1_3==6) {
							ResultSet rs = stmt.executeQuery("SELECT * FROM payment");
							System.out.println("\n------------------------------");
							int k1=1;
							while(rs.next()) {
								System.out.print(k1+" : ");
								String Account_num=rs.getString("Account_num");
								String Service_Num=rs.getString("Service_Num");
								String Pay_way=rs.getString("Pay_way");
								  System.out.println("(1)Account_num : " + Account_num + " (2)Service_Num : " +Service_Num +" (3)Pay_way "
								  		+ ": "+Pay_way);
								  k1++;
							}
							System.out.println("------------------------------");
						}
						else if(Input1_3==7) {
							ResultSet rs = stmt.executeQuery("SELECT * FROM Music_coupon");
							System.out.println("\n------------------------------");
							int k=1;
							while(rs.next()) {
								System.out.print(k+" : ");
								String Snum=rs.getString("Service_num");
								String Sname=rs.getString("Service_name");
								int Price=rs.getInt("Price");
								String validate=rs.getString("validity");
								  System.out.println("(1)Service_num : " + Snum + " (2)Service_Name : " + Sname+" (3)Price "
								  		+ ": "+Price+" (4)validate : "+validate);
								  k++;
							}
							System.out.println("------------------------------");
						}
					}
				}
				else if(Input==2) {
					System.out.println("\nWhat do you want? :) ");
					System.out.println("0. Return to previous menu");
					System.out.println("1. Make new Playlist Something ");
					System.out.println("2. Delete or add music to playlist");
					System.out.println("3. change Music_coupon");
					System.out.println("4. Regist/Delete payment");
					System.out.print("Input : ");
					int Input2_1=Sinput.nextInt();
					String trash=Sinput.nextLine();
					if(Input2_1==0) continue;
					else if(Input2_1==1) {
					System.out.print("Playlist_Ssn : ");
					String List_Ssn=Sinput.nextLine();
					System.out.print("song_num : ");
					int Song_num=Sinput.nextInt();
					trash = Sinput.nextLine();
					System.out.print("User ID : ");
					String Userof_ID=Sinput.nextLine();
					StringBuilder sb=new StringBuilder();
					String sql = sb.append("Insert into "+ "playlist"+" VALUES(")
							.append("'"+List_Ssn+"',")
							.append("'"+Song_num+"',")
							.append("'"+Userof_ID+"'")
							.append(");")
							.toString();
					try {
						stmt.executeUpdate(sql);
					}catch (SQLException e) {
						e.printStackTrace();
						}
					}
					else if(Input2_1==2) {
						System.out.println("What do you want to do?  1.Delete    2.Add");
						System.out.print("Input : ");
						int choose = Sinput.nextInt();
						trash=Sinput.nextLine();
						System.out.print("Enter the playlist's Ssn : ");
						String Ssn=Sinput.nextLine();
						if(choose==1) {
							StringBuilder sb=new StringBuilder();
							String sql = sb.append("UPDATE playlist SET Song_num=Song_num-1 "
									+ "WHERE List_Ssn=")
									.append("'"+Ssn+"'")
									.toString();
							try {
								stmt.executeUpdate(sql);
							}catch (SQLException e) {
								e.printStackTrace();
								}
							}
						else if(choose==2) {
							StringBuilder sb=new StringBuilder();
							String sql = sb.append("UPDATE playlist SET Song_num=Song_num+1 "
									+ "WHERE List_Ssn=")
									.append("'"+Ssn+"';")
									.toString();
							try {
								stmt.executeUpdate(sql);
							}catch (SQLException e) {
								e.printStackTrace();
								}
							}
						}
					else if(Input2_1==3) {
							System.out.print("What is your user_ID? : ");
							String ID=Sinput.nextLine();
							System.out.print("What coupon do you want to change? : ");
							String Coupon_num=Sinput.nextLine();
							StringBuilder sb=new StringBuilder();
							String sql = sb.append("UPDATE User SET Coupon_num=")
											.append("'"+Coupon_num+"'")
											.append(" WHERE User_ID=")
											.append("'"+ID+"'")
											.toString();
							try {
								stmt.executeUpdate(sql);
							}catch (SQLException e) {
								e.printStackTrace();
								}
						}
					else if(Input2_1==4) {
						System.out.println("What do you want to do?  1.Delete    2.Add");
						System.out.print("Input : ");
						int choose=Sinput.nextInt();
						trash=Sinput.nextLine();
						if(choose==1) {
							System.out.print("Account_num : ");
							String account_num=Sinput.nextLine();
							StringBuilder sb=new StringBuilder();
							String sql = sb.append("DELETE FROM payment WHERE Account_num=")
											.append("'"+account_num+"'")
											.toString();
							try {
								stmt.executeUpdate(sql);
							}catch (SQLException e) {
								e.printStackTrace();
								}
							}
						else if(choose==2) {
							System.out.print("Account_num : ");
							String account_num=Sinput.nextLine();
							System.out.print("Service_Num : ");
							String service_num=Sinput.nextLine();
							System.out.print("Pay_way : ");
							String payway=Sinput.nextLine();
							StringBuilder sb=new StringBuilder();
							String sql = sb.append("INSERT INTO payment VALUES(")
											.append("'"+account_num+"',")
											.append("'"+service_num+"',")
											.append("'"+payway+"')")
											.toString();
							try {
								stmt.executeUpdate(sql);
							}catch (SQLException e) {
								e.printStackTrace();
								}
							}
						}
					}
				
			     check=true;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 
	}
}
