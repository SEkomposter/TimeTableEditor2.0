package by.alt.timetableeditor2.DAO;

import by.alt.timetableeditor2.Object.Logger;
import com.mysql.jdbc.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;


public class DaoClass {
    private ArrayList<SurvObject> childList;
    private static DBReader dbReader = new DBReader();
    public static ArrayList<Node> endNodes = new ArrayList<>();
    public static TreeSet<Personal> allPersonal = new TreeSet<>();
    public RootNode getRootNode(){
        return new RootNode();
    }
    public ArrayList<SurvObject> fillChildList(Node node){
        childList = new ArrayList<>();
        Personal tempPers;
        try {
           ResultSet resultSet = dbReader.QueryToDB("SELECT `id`,`name`,`type`, `status`, `parent_id`  FROM `personal` WHERE parent_id = "+String.valueOf(node.getId())+" AND status = 1");
           while (resultSet.next()){
               if (resultSet.getString("TYPE").equals("DEP")){
                    childList.add( new Node(resultSet.getInt("ID"),resultSet.getString("NAME"),resultSet.getInt("PARENT_ID")));
                    node.setHasChildNode(true);}
               else{
                   tempPers = new Personal(resultSet.getInt("ID"),resultSet.getString("NAME"),resultSet.getInt("PARENT_ID"));
                   //childList.add(tempPers);
                   allPersonal.add(tempPers);
               }
           }
           node.setChildObjList(childList);
        }catch (SQLException exc){
            new Logger().pushToScreenNlog(exc,exc.getClass());
        }
        return childList;
    }
    public void buildObjTree(Node node){
        ArrayList<SurvObject> temp = fillChildList(node);
        SurvObject tempSO;
        if (node.isHasChildNode()){
            Iterator it = temp.iterator();
            while (it.hasNext()){
                tempSO = (SurvObject) it.next();
                if(tempSO instanceof Node) buildObjTree((Node) tempSO);
            }
        }
        else {
            endNodes.add(node);
        }
    }

    public TreeSet<Personal> getAllPersonal() {
       return allPersonal;
    }

    public ArrayList<Node> getEndNodes() {
        return endNodes;
    }
}
