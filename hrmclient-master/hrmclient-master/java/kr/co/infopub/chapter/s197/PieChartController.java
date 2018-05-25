package kr.co.infopub.chapter.s197;

import java.sql.Date;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import kr.co.infopub.chapter.s197.dto.DepCount;
import kr.co.infopub.chapter.s197.dto.Employee;
import kr.co.infopub.chapter.s197.model.EmployeeService;
import kr.co.infopub.chapter.s197.util.EmpUtil;
import kr.co.infopub.chapter.s197.util.PTS;

public class PieChartController extends BorderPane{

    @FXML
    private AnchorPane pieAnchor;
    
    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, Integer>  empIdColumn;
    @FXML
    private TableColumn<Employee, String>  empNameColumn;
    @FXML
    private TableColumn<Employee, String> empLastNameColumn;
    @FXML
    private TableColumn<Employee, String> empEmailColumn;
    @FXML
    private TableColumn<Employee, String> empPhoneNumberColumn;
    @FXML
    private TableColumn<Employee, Date> empHireDateColumn;
     
    EmployeeService service;
    
	public PieChartController(EmployeeService service) {
		this.service=service;
		FXMLLoader loader4 = new FXMLLoader();
        loader4.setLocation(Main.class.getResource("view/DepChartView.fxml"));
        loader4.setRoot(this);
        loader4.setController(this);
        try {
        	loader4.load();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
	}
   
    public void refresh(){
    	pieAnchor.getChildren().clear();
    	initialize();
    }
    @FXML
    void initialize() {

    	empIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
        empNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        empLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        empEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        empPhoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        empHireDateColumn.setCellValueFactory(cellData -> cellData.getValue().hireDateProperty());
    	
    	try {
    	   ObservableList<DepCount> dlists =service.findAllDepCounts();
 		   int total=service.getEmployeesTotal();
 		   System.out.println("test chart ====================="+dlists.size() +"   "+total);

 		   //final int  ftotal=total;   
 			
 			PieChart pieChart = new PieChart();
 			pieChart.setTitle("부서별 인원수 총"+total+"명 " +PTS.toDay());
 	        pieChart.setData(getChartData(dlists));
 	        pieChart.setClockwise(true); 
 	        pieChart.setStartAngle(180);  
 	        pieChart.setLabelsVisible(true); 
 	        pieChart.setPrefWidth(800);
 	        pieChart.setPrefHeight(600); 
 	        final Label caption = new Label("");
 	        String value=
 	    	    	   "-fx-font-size: 25px;           "
 	    	    	  +"-fx-font-family: 'Arial Black';    ";

 	        caption.setStyle(value);
 	        
 	        for (final PieChart.Data data : pieChart.getData()) {
 	            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
 	                    e-> {
 	                    	    ObservableList<Employee> populateEmploye=null;
								try {
									populateEmploye = service.findEmployeesByDepartName( EmpUtil.dep(data.getName() ));
									showEmployeeTable(populateEmploye);
								} catch (SQLException e1) {
									
								}
 	                    	   
 	                            caption.setTranslateX(e.getSceneX());
 	                            caption.setTranslateY(e.getSceneY());
 	                            String sft=String.format("%s %.2f%%(%.0f명)", 
 	                            		EmpUtil.dep(data.getName()),
 	                            		100*data.getPieValue()/total,
 	                            		data.getPieValue());
 	                            caption.setText(sft);
 	                           
 	                        }
 	                    );
 	        }
 	       pieAnchor.getChildren().addAll(pieChart,caption);
 	       
 		} catch (SQLException e) {
 			System.out.println(e);
 		}

    }
    
    @FXML
    private void showEmployeeTable (ObservableList<Employee> empData)  {
        employeeTable.setItems(empData);
    }
    private ObservableList<Data> getChartData(ObservableList<DepCount> dlists) {
        ObservableList<Data> answer = FXCollections.observableArrayList();
        for (DepCount dc: dlists) {
        	 answer.add(new PieChart.Data( dc.getDepartment_name()+"("+dc.getDepartment_id()+")", dc.getCount()  ));
    	}
        return answer;
    }
}
