package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PersonDAO extends MyDAO{
       public List<Person> getAllPerson() {
        List<Person> list = new ArrayList<>();
        xSql = "select * from person";
        try {
            int xId;
            String xName;
            Date xDob;
            String xAddress;
            Person x;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xDob = rs.getDate("dob");
                xAddress = rs.getString("address");
                x = new Person(xId, xName, xDob, xName);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
