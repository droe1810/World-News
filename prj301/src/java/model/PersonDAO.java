package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonDAO extends MyDAO {

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

    public Person getPersonByNewID(int id) {
        xSql = "select pa.id,pa.name,pa.dob,pa.address from (select * from person p inner join Account a on p.id = a.person_id) pa "
                + "inner join new n on pa.person_id = n.writerID where n.id = ?";
        int xId;
        String xName;
        Date xDob;
        String xAddress;
        Person x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xDob = rs.getDate("dob");
                xAddress = rs.getString("address");
                x = new Person(id, xName, xDob, xAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }
    
        public Person getPersonByID(int id) {
        xSql = "select * from person where id = ?";
        int xId;
        String xName;
        Date xDob;
        String xAddress;
        Person x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                xId = id;
                xName = rs.getString("name");
                xDob = rs.getDate("dob");
                xAddress = rs.getString("address");
                x = new Person(id, xName, xDob, xAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return x;

    }
}
