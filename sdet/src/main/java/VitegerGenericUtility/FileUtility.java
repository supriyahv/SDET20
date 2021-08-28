package VitegerGenericUtility;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.util.Properties;

	public class FileUtility {
		/**
		 * It is used to read the data from the common.Property file based on key which you pass as an argument
		 * @param key
		 * @return
		 * @throws Throwable
		 */
		public String getValuePropertykeyValue(String key) throws Throwable
		{
			FileInputStream fis = new FileInputStream("./data/common1.properties");
			Properties pobj = new Properties();
			pobj.load(fis);
			String value=pobj.getProperty(key);
			return value;
			
		}

	}

