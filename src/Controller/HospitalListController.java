package Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import Model.Hospital;
import View.HospitalListJavaFXView;

/**
 * Created by Kripa
 */
public class HospitalListController {
    @FXML
    private TextField searchKey;
    @FXML
    private TableView<Hospital> hospitalTable;
    @FXML
    private TableColumn<Hospital, String> nameColumn;
    @FXML
    private TableColumn<Hospital, String> streetAddressColumn;
    @FXML
    private TableColumn<Hospital, String> cityColumn;
    @FXML
    private TableColumn<Hospital, String> stateColumn;
    @FXML
    private TableColumn<Hospital, String> zipColumn;
    @FXML
    private TableColumn<Hospital, String> latitudeColumn;
    @FXML
    private TableColumn<Hospital, String> longitudeColumn;
    @FXML
    private TableColumn<Hospital, String> phoneNoColumn;
    @FXML
    private TableColumn<Hospital, String> photoColumn;


    private HospitalListJavaFXView hospitalApp;


    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        streetAddressColumn.setCellValueFactory(cellData -> cellData.getValue().streetAddressProperty());
        cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        stateColumn.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
        zipColumn.setCellValueFactory(cellData -> cellData.getValue().zipProperty());
        latitudeColumn.setCellValueFactory(cellData -> cellData.getValue().latitudeProperty());
        longitudeColumn.setCellValueFactory(cellData -> cellData.getValue().longitudeProperty());
        phoneNoColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNoProperty());
        photoColumn.setCellValueFactory(cellData -> cellData.getValue().photoProperty());
    }

    public void setHospitalApp(HospitalListJavaFXView hospitalApp) {
        this.hospitalApp = hospitalApp;

        // Add observable list data to the table
        hospitalTable.setItems(hospitalApp.getHospitalData());
    }


    //method to count words in a string
    public static int wordcount(String s) {
        int i, c = 0, res;
        char ch[] = new char[s.length()];      //in string especially we have to mention the () after length
        for (i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);
            if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0)))
                c++;
        }
        return c;
    }

    //Haversine distance formula
    public double haversineCalculation(String lat1,String lon1,String lat2,String lon2){
        final int R = 6371;
        Double latitude1=Double.parseDouble(lat1);
        Double longitude1=Double.parseDouble(lon1);
        Double latitude2=Double.parseDouble(lat2);
        Double longitude2=Double.parseDouble(lon2);
        Double latDistance = toRad(latitude2-latitude1);
        Double lonDistance = toRad(longitude2-longitude1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(latitude1)) * Math.cos(toRad(latitude2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;

        System.out.println("The distance between two lat and long is::" + distance);
        return distance;

    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }







    //search logic and update table view for the result
    public void handleEnterPressed(KeyEvent event) {
        String latitude = "";
        String longitude = "";
        String key = "";
        boolean coordinate = true;
        Hospital hospitalKey;
        ObservableList<Hospital> searchHospitalResultTable = FXCollections.observableArrayList();

        if (event.getCode() == KeyCode.ENTER) {
            key = searchKey.getText();
            //first add logic to check if key is coordinate or others
            //if key is empty
            if (key.equals("")) {
                hospitalTable.setItems(hospitalApp.getHospitalData());
            }
            //if coordinate
            if (coordinate) {
                latitude = key.split(",")[0];
                longitude = key.split(",")[1];
                String lat=key.split(",")[0];
                String lon=key.split(",")[0];
                System.out.println(latitude + " " + longitude);
                hospitalKey = new Hospital(latitude, longitude);
                System.out.println(latitude + " " + longitude);
                System.out.println(hospitalKey.toString());
                System.out.println(latitude + " " + longitude);

                if (hospitalApp.getHospitalBSTree().contains(hospitalKey)) {

                    //create the new observable list and add the result to this list
                    searchHospitalResultTable.add(hospitalApp.getHospitalBSTree().get(hospitalKey));
                    //set new result of search to observrable list
                    // hospitalApp.setHospitalData(searchHospitalResultTable);
                    //update view
                    hospitalTable.setItems(searchHospitalResultTable);
                } else {
                    //reset the observable list
                    searchHospitalResultTable.clear();
                    //set new result of search to observrable list
                    //hospitalApp.setHospitalData(searchHospitalResultTable);
                    //update view
                    hospitalTable.setItems(searchHospitalResultTable);
                }
            }
            //if hospital name
            //if phone number
            //if address

        }
    }
}