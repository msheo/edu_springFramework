package kr.co.infopub.chapter.s197;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import javafx.scene.control.TreeView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import kr.co.infopub.chapter.s197.dto.Employee;
import kr.co.infopub.chapter.s197.model.EmployeeService;
import kr.co.infopub.chapter.s197.util.EmpUtil;


public class ManagerFxController extends BorderPane{

    @FXML
    private Button searchEmpsBtn;
    @FXML
    private Label lbhello;
    
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
    @FXML
    private TreeView tvEmp;
    
    @FXML
    private Button latesEmpsBtn;
    
    private final Node rootIcon2 = new ImageView(
            new Image(getClass().getResourceAsStream("image/book2.png"))
        );
    private final Node rootIcon3 = new ImageView(
            new Image(getClass().getResourceAsStream("image/book3.png"))
        );
    //private Executor exec;
    
    //EmployeeDAO employeeDAO=new EmployeeDAO();
    EmployeeService service;
    
   	public ManagerFxController(EmployeeService service) {
   		this.service=service;
   		
   		FXMLLoader loader4 = new FXMLLoader();
           loader4.setLocation(Main.class.getResource("view/ManagerFx.fxml"));
           loader4.setRoot(this);
           loader4.setController(this);
           try {
           	loader4.load();
           } catch (Exception exception) {
        	   System.out.println("ManagerFxController 로드 실패");
               //throw new RuntimeException(exception);
           }
   	}
    
    
    @FXML
    private void initialize () {
    	loadTreeItems();
    	
//        exec = Executors.newCachedThreadPool((runnable) -> {
//            Thread t = new Thread (runnable);
//            t.setDaemon(true);
//            return t;
//        });
        
        empIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
        empNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        empLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        empEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        empPhoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());

        empHireDateColumn.setCellValueFactory(new Callback<CellDataFeatures<Employee, Date>, ObservableValue<Date>>() {
            public ObservableValue<Date> call(CellDataFeatures<Employee, Date> cellData) {
                return cellData.getValue().hireDateProperty();
            }
         });
        

        employeeTable.setOnMouseClicked(e ->{
        	if(employeeTable.getSelectionModel().getSelectedItem()!=null ){
        		Employee user = (Employee)employeeTable.getSelectionModel().getSelectedItem();
            	System.out.println(user.getEmployeeId()+"  "+user.getFirstName()+" "+user.getLastName());
            	lbhello.setText(user.getEmployeeId()+"  "+user.getFirstName()+" "+user.getLastName());
        	}
        	
            }
        );
    }

    @FXML
    private void onLatesEmpsBtn(ActionEvent actionEvent) throws SQLException {
    	loadTreeItems();
    }
    //TreeItem<String> one;
   	@SuppressWarnings("unchecked")
	public void loadTreeItems() {
   	 TreeItem<String> root = new TreeItem<String>("매니저와 직원",rootIcon2);
   	 root.setExpanded(true);
  		try {
  			 
  			 
  		    List<Employee> dlists=service.findTreeManagerInEmployee();
			  int max=0;
			  max=service.getTreeMaxLevel();
			  makeEmpTree(root,dlists,"",1,max);   

  	          tvEmp.setRoot(root);
 	          tvEmp.getSelectionModel().selectedItemProperty().addListener(
 	        		(observable, oldValue, newValue) -> {
 	              ObservableList<Employee> empData=null;
 	            // System.out.println("Selected Department_id : "+ ((TreeItem<String>)newValue).getValue()); 
 				try {
 					String val="";
  					if(newValue !=null && newValue instanceof TreeItem<?>){
  						 val=EmpUtil.bfstr(((TreeItem<String>)newValue).getValue());
  					}
 					System.out.println("Selected Manager_id : "+ val); 
 					empData=service.findEmployeesByEmpId(val);
 				    //----단순 인원을 구하기 위한것.
 					String stsf=val+"와(과) 직원: ";
 					showLabel(stsf+ empData.size()+" 명");
 					//----------------------------
 					showToTableEmployees(empData);
 					
 				} catch (SQLException e) {
 					
 				}
 	        });
 	        
  	        root.addEventHandler(TreeItem.branchExpandedEvent(),eh->{
  	        	System.out.println("expanded----------------------------------------->");
  	        	root.setGraphic(rootIcon2);
  	        	tvEmp.refresh();
  	        	
  	        	//loadTreeItems2(); //무한루프 
  	        });
  	        root.addEventHandler(TreeItem.childrenModificationEvent(), eh->{
  	        	System.out.println("-------------childrenModificationEvent-------------->");
  	        	
  	        });
  	        root.addEventHandler(TreeItem.branchCollapsedEvent(),eh->{
  	        	System.out.println("collapsed=========================================>");
  	        	root.setGraphic(rootIcon3);
  	        });
  		} catch (SQLException e) {
  			//System.out.println(" emp tv :"+e);
  			 System.out.println("loadTreeItems  실패");
  		}
  		
  		 empIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
         empNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
         empLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
         empEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
         empPhoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
         empHireDateColumn.setCellValueFactory(cellData -> cellData.getValue().hireDateProperty());

         employeeTable.setOnMouseClicked(e ->{
         	if(employeeTable.getSelectionModel().getSelectedItem()!=null ){
         		Employee user = (Employee)employeeTable.getSelectionModel().getSelectedItem();
             	System.out.println(user.getEmployeeId()+"  "+user.getFirstName()+" "+user.getLastName());
             	showLabel(user.getEmployeeId()+"  "+user.getFirstName()+" "+user.getLastName());
         	}
         	
             }
         );
    }
   	
   	public  void makeEmpTree(TreeItem<String> front,List<Employee> dlists, String key, int index,int max){
   		if(index>max){return ; }  //max를 넘으면 끝
   		for (Employee emp: dlists) {  //개수가 있으니 끝날 것이다.
   			if(EmpUtil.level(emp)!=index){   //원하는 레벨만 찾음
   				continue;
   			}else if(index>1 && EmpUtil.level(emp)==index){   //2부터는 1의 키값과 비교
   				if(EmpUtil.level(emp,index-1).equals(key)){
   					TreeItem<String> aa=new TreeItem<String>(EmpUtil.tname(emp, index));
   					front.getChildren().add(aa);
   					makeEmpTree(aa,dlists,EmpUtil.level(emp,index),index+1,max);
   				}else{
   					continue;
   				}
   			}else if(EmpUtil.level(emp)==1){  //1의 키값이 없기 때문
   				TreeItem<String> aa=new TreeItem<String>(EmpUtil.tname(emp, 1));
   				front.getChildren().add(aa);
   				makeEmpTree(aa,dlists,EmpUtil.level(emp,1),2,max);
   			}
   		}
   	}	
   	
   	void showLabel(String msg){
    	lbhello.setText(msg);
    	String value=
    	    	   "-fx-font-size: 12px;           "
    	    	   +"-fx-font-family: 'Arial Black';    "
    	    	   +"-fx-fill: #818181;                 "
    	    	   +"-fx-effect: innershadow( three-pass-box ,"
    	    	   +" rgba(0,50,255,0.7) , 6, 0.0 , 0 , 2 );";
    	lbhello.setStyle("\t"+value);
    }

   	@FXML
    private void showToTableEmployees (ObservableList<Employee> empData)  {
        employeeTable.setItems(empData);
    }
    @FXML
    private void searchEmployees(ActionEvent actionEvent) throws SQLException {
        try {
            ObservableList<Employee> empData =service.findAllEmployees();
            showToTableEmployees(empData);
            showLabel("인원 "+empData.size()+"명");
        } catch (SQLException e){
            System.out.println("Error occurred while searchEmployees" );
            //throw e;
        }
    }
}
