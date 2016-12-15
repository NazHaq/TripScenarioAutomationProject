package parameters;

import org.testng.annotations.DataProvider;

public class UserDataProvider {
	
	  @DataProvider(name="UserProvider")

      public static Object[][] getDataFromDataprovider(){

          return new Object[][] {

                  { "SecondTest1", "Perth" },

                  { "SecondTest2", "Melbourne" },

                  { "SecondTest3", "Sydney" }

              };
      	}
      

}
