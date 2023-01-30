package utilities;
import java.io.IOException;

public  class ConfigManage {

	// private empty constructor
			private ConfigManage() {
				
			}
			
			
			
			// public static method
			public static ConfigManage  getInstance() {
				ConfigManage frm = new ConfigManage();
				return frm;
			}
				
			
			
			//public non static method
			public Configreader getCrInstance() throws IOException {
				Configreader cr = new Configreader();
				return cr;
			
			}
}	
	

