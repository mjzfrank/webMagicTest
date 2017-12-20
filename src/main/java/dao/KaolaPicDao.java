package dao;

import model.CsdnBlog;
import model.KaolaPic;

import java.sql.*;
/**
 * Created by wulvge on 2017/9/13.
 */
public class KaolaPicDao {


    private Connection conn = null;
    private Statement stmt = null;

    public KaolaPicDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://192.168.1.63:3306/webmagic?"
                    + "user=root&password=19930107&useUnicode=true&characterEncoding=UTF8";
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int add(KaolaPic kaolaPic) {
        try {
            String sql = "INSERT INTO `webmagic`.`kaolapic` (`url`, `name`,`downloadResult`) VALUES (?, ?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, kaolaPic.getId());
            ps.setString(1, kaolaPic.getUrl());
            ps.setString(2, kaolaPic.getName());
            ps.setInt(3, kaolaPic.getDownloadresult());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}