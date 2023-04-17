package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewDAO extends MyDAO {

    public List<New> getAllNew() {
        List<New> list = new ArrayList<>();
        xSql = "select * from new";
        try {
            String xName, xImage, xContent;
            String xTitle;
            Date xDate;
            int xId;
            New x;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xTitle = rs.getString("title");
                xContent = rs.getString("content");
                xDate = rs.getDate("date");
                x = new New(xId, xName, xImage, xTitle, xContent, xDate);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<New> getNewByCID(int cid) {
        List<New> list = new ArrayList<>();
        xSql = "select * from new where cateID = ?";
        try {
            String xName, xImage, xContent;
            String xTitle;
            int xId;
            Date xDate;

            New x;
            ps = con.prepareStatement(xSql);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xTitle = rs.getString("title");
                xContent = rs.getString("content");
                xDate = rs.getDate("date");
                x = new New(xId, xName, xImage, xTitle, xContent, xDate);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public New getNewByID(String id) {
        xSql = "select * from new where id = ?";
        String xName, xImage, xContent;
        int xId;
        Date xDate;
        String xTitle;
        New x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                xId = Integer.parseInt(id);
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xTitle = rs.getString("title");
                xContent = rs.getString("content");
                xDate = rs.getDate("date");
                x = new New(xId, xName, xImage, xTitle, xContent, xDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    public List<New> getNewByWriterID(int id) {
        List<New> list = new ArrayList<>();
        xSql = "select * from new where writerID = ?";
        try {
            String xName, xImage, xContent;
            String xTitle;
            int xId;
            Date xDate;
            New x;
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xTitle = rs.getString("title");
                xContent = rs.getString("content");
                xDate = rs.getDate("date");
                x = new New(xId, xName, xImage, xTitle, xContent, xDate);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<New> searchByName(String txtSearch) {
        List<New> list = new ArrayList<>();
        xSql = "select * from new where [name] like '%" + txtSearch + "%'";
        String xName, xImage, xContent;
        String xTitle;
        Date xDate;
        int xId;
        New x;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xTitle = rs.getString("title");
                xContent = rs.getString("content");
                xDate = rs.getDate("date");
                x = new New(xId, xName, xImage, xTitle, xContent, xDate);
                list.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }

    public void add(String name, String image, String title, String content, int cateID, int writerID) {
        xSql = "insert into New (name,image,title, content,[date], cateID, writerID) values (?,?,?,?,'2022-04-17',?,?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, title);
            ps.setString(4, content);
            ps.setInt(5, cateID);
            ps.setInt(6, writerID);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit(String name, String image, String title, String content, int id) {
        xSql = "update New set name=?, image=?, title=?, content=? where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, title);
            ps.setString(4, content);
            ps.setInt(5, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
