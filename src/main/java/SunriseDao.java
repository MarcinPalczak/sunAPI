import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class SunriseDao {


    public String givenLocationSunrise ( String lat , String lng ) throws CustomException {
        String uri = "https://api.sunrise-sunset.org/json?lat="+lat+"&lng="+lng ;
        return  get(uri) ;
    }


    private String get(String uri) throws CustomException {

        try {
            URL url = new URL(uri);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = in.readLine()) != null) {
                stringBuilder.append(line);
            }
            in.close();

            if (stringBuilder.toString() == "") {
                throw new CustomException("Jakiś inny komunikat obłędzie");
            }

            return stringBuilder.toString();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  null ;
    }

}


