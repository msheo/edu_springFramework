package kr.co.infopub.chapter.s195;
import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kr.co.infopub.chapter.s195.dto.DepCount;
import kr.co.infopub.chapter.s195.model.EmployeeService;
import kr.co.infopub.chapter.s195.util.EmpUtil;
import kr.co.infopub.chapter.s195.util.PTS;
import javafx.scene.chart.PieChart;
// s188
public class DepChartFx extends Application {
 int total=0;   // 전체 사원 수
 private ObservableList<Data> getChartData(List<DepCount> dlists) {
    ObservableList<Data> answer = FXCollections.observableArrayList();
    for (DepCount dc: dlists) {
    	// 부서이름(부서아이디), 부서원 수
    	 answer.add(new PieChart.Data( dc.getDepartment_name()
    			   +"("+dc.getDepartment_id()+")", dc.getCount()  ));
	}
    return answer;
 }
 @Override
 public void start(Stage stage) {
  try {
	// DAO, Convert를 감싸서 편기하게 사용
	EmployeeService service=EmployeeService.getInstance();
    List<DepCount> dlists =service.findAllDepCounts();;
    // 부서별 인원을 더해서 전체 사원수를 구한다.
    for(DepCount dc: dlists){
	    total+=dc.getCount();
    }
    Scene scene = new Scene(new Group());
    stage.setTitle("부서별 인원수 " +PTS.toDay());
    stage.setWidth(750);
    stage.setHeight(800);
	
	PieChart pieChart = new PieChart();
	pieChart.setTitle("부서별 인원수 총"+total+"명");
	// 파이차트에  ObservableList를 대입한다
	// 부서별 부서원 수로 파이 넓이를 차지한다.
    pieChart.setData(getChartData(dlists));
    pieChart.setClockwise(true); 
    pieChart.setStartAngle(180);  
    pieChart.setLabelsVisible(true); 
    //레전드
    //pieChart.setLabelLineLength(20);
    //pieChart.setLegendSide(Side.LEFT);
    pieChart.setPrefWidth(750);
    pieChart.setPrefHeight(700); 
    final Label caption = new Label("");
    String value=
	    	   "-fx-font-size: 25px;           "
	    	  +"-fx-font-family: 'Arial Black';    ";
    caption.setStyle(value);
    for (final PieChart.Data data : pieChart.getData()) {
        data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
            e-> {
                caption.setTranslateX(e.getSceneX());  // 마우스로 누른 X위치에
                caption.setTranslateY(e.getSceneY());  // 마우스로 누른 Y위치에
                String sft=String.format("%s %.2f%%(%.0f명)", 
                		EmpUtil.dep(data.getName()),   // 부서이름
                		100*data.getPieValue()/total,  // 부서인원 %비율
                		data.getPieValue());           // 부서인원
                caption.setText(sft);
            });
    }
    // 파이차트와 이벤트 발생시 보일 내용(라벨)
    ((Group) scene.getRoot()).getChildren().addAll(pieChart,caption);
    stage.setScene(scene);
    stage.show();
  } catch (SQLException e) {
	System.out.println(e);
  }
 }
 public static void main(String[] args) {
  launch(args);
 }
}