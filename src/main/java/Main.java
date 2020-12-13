import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        SunriseDao sunriseDao = new SunriseDao();
        try {


            System.out.println("Wybierz  opcje ");
            System.out.println("1) Sunrise dla danych współrzednych");

            Scanner  scan = new Scanner(System.in) ;
            int option = scan.nextInt();
            scan.nextLine();
            String result ;

            switch (option) {
                case 1:
                    System.out.println("Podaj długość geograficzna");
                    String lat = scan.nextLine() ;
                    scan.nextLine();
                    System.out.println("podaj szerokosc");
                    String lng = scan.nextLine() ;
                    result = sunriseDao.givenLocationSunrise(lat,lng) ;
                            break ;

                default:
                    result = "Nie rozpoznano wyboru";
            }

            System.out.println(result);


        } catch (CustomException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
