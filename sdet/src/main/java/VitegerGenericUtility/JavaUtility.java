package VitegerGenericUtility;



	import java.util.Date;
	import java.util.Random;

	public class JavaUtility {
		/**
		 * It is used to generate the random number within the boundary of 0 to 10000
		 * @return
		 */
		public int getRandomNum()
		{
			Random random = new Random();
			int randomNumber=random.nextInt(10000);
			return randomNumber;
		}
		/**
		 * It is used to get the currentDateAndTime
		 * @return
		 */
		public String getSystemDate()
		{
			Date date=new Date();
			String SystemDateAndTime =date.toString();
			return SystemDateAndTime;
			
		}
		public String getSystemDate_YYYY_MM_DD()
		{
			Date date=new Date();
			String SystemDateAndTime =date.toString();
			String[] arr = SystemDateAndTime.split(" ");
			String DD=arr[2];
			String YYYY=arr[5];
			int MM=date.getMonth()+1;
			String dateFormate=YYYY+"-"+MM+"-"+DD;
			return dateFormate;
		}
		

	}

