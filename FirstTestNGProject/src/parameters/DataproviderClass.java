package parameters;

import org.testng.annotations.DataProvider;

public class DataproviderClass {

        @DataProvider(name="SearchProvider")

        public static Object[][] getDataFromDataprovider(){

            return new Object[][] {

                    { "Test1", "Perth" },

                    { "Test2", "Melbourne" },

                    { "Test3", "Sydney" }

                };
        	}
        
        }