package Models;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class DiscountMgt {

    public String LoadTitles(String Title) {
        TreeSet ts = new TreeSet();
        String value = "";
        Criteria cri = DB_Manager.DbManager.getInstance().getSession().createCriteria(DB.Productmain.class);
        cri.add(Restrictions.like("proName", Title, MatchMode.START));
        List<DB.Productmain> pm = cri.list();
        for (DB.Productmain p : pm) {
            ts.add(p.getProName());
        }
        Iterator it = ts.iterator();
        while (it.hasNext()) {
            value += "<option>" + it.next().toString() + "</option>";
        }
        return value;
    }

    public String SearchByPid(int Pid) {
        String value = "";
        DB.Productmain p1 = (DB.Productmain) DB_Manager.DbManager.getInstance().getSession().get(DB.Productmain.class, Pid);
        if (p1 != null) {
            value += "<tr>";
            value += "<td>" + p1.getProductMainId() + "</td>";
            value += "<td>" + p1.getProName() + "</td>";
            value += "<td>" + p1.getSubcategory().getMaincategory().getMainCategoryType() + "</td>";
            value += "<td>" + p1.getSubcategory().getSubCategoryType() + "</td>";
            value += "<td>" + p1.getBrand().getBrand() + "</td>";
            value += "<td>" + p1.getListPrice() + "</td>";
            value += "<td><input type='number' value='" + p1.getDiscount() + "' style='width: 65px;' id='discount-" + p1.getProductMainId() + "'/></td>";
            value += "<td id='Price-" + p1.getProductMainId() + "'>" + p1.getOriginalPrice() + "</td>";
            value += "<td><a onclick='UpdateDiscount(" + p1.getProductMainId() + ")'><img src='img/Icons/update.png' title='Update Discount'/></a></td>";
            value += "</tr>";
        } else {
            value = "Can't find a Product Record with this Product ID";
        }
        return value;
    }

    public String searchByProTitle(String Title) {
        String value = "";
        Criteria cri = DB_Manager.DbManager.getInstance().getSession().createCriteria(DB.Productmain.class);
        cri.add(Restrictions.eq("proName", Title));
        DB.Productmain p1 = (DB.Productmain) cri.uniqueResult();
        if (p1 != null) {
            value += "<tr>";
            value += "<td>" + p1.getProductMainId() + "</td>";
            value += "<td>" + p1.getProName() + "</td>";
            value += "<td>" + p1.getSubcategory().getMaincategory().getMainCategoryType() + "</td>";
            value += "<td>" + p1.getSubcategory().getSubCategoryType() + "</td>";
            value += "<td>" + p1.getBrand().getBrand() + "</td>";
            value += "<td>" + p1.getListPrice() + "</td>";
            value += "<td><input type='number' value='" + p1.getDiscount() + "' style='width: 65px;' id='discount-" + p1.getProductMainId() + "'/></td>";
            value += "<td id='Price-" + p1.getProductMainId() + "'>" + p1.getOriginalPrice() + "</td>";
            value += "<td><a onclick='UpdateDiscount(" + p1.getProductMainId() + ")'><img src='img/Icons/update.png' title='Update Discount'/></a></td>";
            value += "</tr>";
        } else {
            value = "Can't find a Product Record with this Product Name";
        }
        return value;
    }

}
