import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private Path file = Paths.get("Estate.csv");

    public List<RealEstate> readFile() throws IOException {
        byte[] data = Files.readAllBytes(file);
        String convertData = new String(data);
        String[] dataArray = convertData.split("\\r");
        List<String> dataList =  new ArrayList<>(Arrays.asList(dataArray));
        dataList.remove(0);
        List<RealEstate> listEstate = new ArrayList<>();
        for (String line: dataList){
            String[] array = line.split(",");
            String street = array[0];
            String city = array[1];
            Integer zip = Integer.parseInt(array[2]);
            String state = array[3];
            Integer beds = Integer.parseInt(array[4]);
            Integer baths = Integer.parseInt(array[5]);
            Integer sq__ft = Integer.parseInt(array[6]);
            String type = array[7];
            String sale_date = array[8];
            Integer price = Integer.parseInt(array[9]);
            Float latitude = Float.parseFloat(array[10]);
            Float longitude = Float.parseFloat(array[11]);
            listEstate.add(new RealEstate(street,city,zip,state,beds,baths,sq__ft,type,sale_date,price,latitude,longitude));
        }
        return listEstate;
    }
}
