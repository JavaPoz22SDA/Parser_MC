import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        List<RealEstate> listRealEstate = new ArrayList<>(parser.readFile());
        Map <String ,Integer> map = new HashMap<>(parser.countByCity(listRealEstate));
        System.out.println(map);
        Map<String,List<RealEstate>> map1 = new HashMap<>(parser.groupByCity(listRealEstate));
        System.out.println(map1);
    }
}
