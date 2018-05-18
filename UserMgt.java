package Models;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class UserMgt {

    public String SearchByUid(int Uid) {
        String value = "";
        DB.User u = (DB.User) DB_Manager.DbManager.getInstance().getSession().get(DB.User.class, Uid);
        if (u != null) {
            String mail = "";
            int active = 0, logID = 0;
            Criteria cr = DB_Manager.DbManager.getInstance().getSession().createCriteria(DB.Login.class);
            cr.add(Restrictions.eq("user", u));
            DB.Login lg = (DB.Login) cr.uniqueResult();
            mail = lg.getEmail();
            active = lg.getActive();
            logID = lg.getLoginId();
            if (!u.getUsertype().getTypeName().equals("Admin")) {
                value += "<tr>";
                value += "<td>" + u.getUserId() + "</td>";
                value += "<td>" + u.getFirstName() + " " + u.getLastName() + "</td>";
                value += "<td>" + u.getDob() + "</td>";
                value += "<td>" + u.getGender().getGenderType() + "</td>";
                value += "<td>" + mail + "</td>";
                value += "<td>" + u.getContactNo() + "</td>";
                value += "<td>" + u.getUsertype().getTypeName() + "</td>";
                if (active == 1) {
                    value += "<td id='" + logID + "'><span class='label new'>ACTIVE</span></td>";
                } else {
                    value += "<td id='" + logID + "'><span class='label' id='" + logID + "'>DEACTIVE</span></td>";
                }
                value += "<td><a onclick='ActiveDeactive(" + logID + ")'><img src='img/Icons/wishlist.png' title='Deactive/Active'/></a></td>";
                value += "</tr>";
            } else {
                value = "Admin record can't be displayed";
            }
        } else {
            value = "Can't find a User Record with this User ID";
        }
        return value;
    }

    public String SearchByUname(String fname, String lname) {
        String value = "";
        Criteria cri = DB_Manager.DbManager.getInstance().getSession().createCriteria(DB.User.class);
        cri.add(Restrictions.eq("firstName", fname));
        cri.add(Restrictions.eq("lastName", lname));
        cri.addOrder(Order.asc("userId"));
        List<DB.User> us = cri.list();
        if (!us.isEmpty()) {
            for (DB.User u : us) {
                String mail = "";
                int active = 0, logID = 0;
                Criteria cr = DB_Manager.DbManager.getInstance().getSession().createCriteria(DB.Login.class);
                cr.add(Restrictions.eq("user", u));
                DB.Login lg = (DB.Login) cr.uniqueResult();
                mail = lg.getEmail();
                active = lg.getActive();
                logID = lg.getLoginId();
                if (!u.getUsertype().getTypeName().equals("Admin")) {
                    value += "<tr>";
                    value += "<td>" + u.getUserId() + "</td>";
                    value += "<td>" + u.getFirstName() + " " + u.getLastName() + "</td>";
                    value += "<td>" + u.getDob() + "</td>";
                    value += "<td>" + u.getGender().getGenderType() + "</td>";
                    value += "<td>" + mail + "</td>";
                    value += "<td>" + u.getContactNo() + "</td>";
                    value += "<td>" + u.getUsertype().getTypeName() + "</td>";
                    if (active == 1) {
                        value += "<td id='" + logID + "'><span class='label new'>ACTIVE</span></td>";
                    } else {
                        value += "<td id='" + logID + "'><span class='label' id='" + logID + "'>DEACTIVE</span></td>";
                    }
                    value += "<td><a onclick='ActiveDeactive(" + logID + ")'><img src='img/Icons/wishlist.png' title='Deactive/Active'/></a></td>";
                    value += "</tr>";
                } else {
                    value = "Admin record can't be displayed";
                }
            }
        } else {
            value = "Can't find a User Record with this User Name";
        }
        return value;
    }

    public String SearchByMail(String email) {
        String value = "";
        Criteria cr = DB_Manager.DbManager.getInstance().getSession().createCriteria(DB.Login.class);
        cr.add(Restrictions.eq("email", email));
        DB.Login l = (DB.Login) cr.uniqueResult();
        if (l != null) {
            DB.User u = l.getUser();
            String mail = "";
            int active = 0, logID = 0;
            Criteria crc = DB_Manager.DbManager.getInstance().getSession().createCriteria(DB.Login.class);
            crc.add(Restrictions.eq("user", u));
            DB.Login lg = (DB.Login) crc.uniqueResult();
            mail = lg.getEmail();
            active = lg.getActive();
            logID = lg.getLoginId();
            if (!u.getUsertype().getTypeName().equals("Admin")) {
                value += "<tr>";
                value += "<td>" + u.getUserId() + "</td>";
                value += "<td>" + u.getFirstName() + " " + u.getLastName() + "</td>";
                value += "<td>" + u.getDob() + "</td>";
                value += "<td>" + u.getGender().getGenderType() + "</td>";
                value += "<td>" + mail + "</td>";
                value += "<td>" + u.getContactNo() + "</td>";
                value += "<td>" + u.getUsertype().getTypeName() + "</td>";
                if (active == 1) {
                    value += "<td id='" + logID + "'><span class='label new'>ACTIVE</span></td>";
                } else {
                    value += "<td id='" + logID + "'><span class='label' id='" + logID + "'>DEACTIVE</span></td>";
                }
                value += "<td><a onclick='ActiveDeactive(" + logID + ")'><img src='img/Icons/wishlist.png' title='Deactive/Active'/></a></td>";
                value += "</tr>";
            } else {
                value = "Admin record can't be displayed";
            }
        } else {
            value = "Can't find a User Record with this Email";
        }
        return value;
    }

    public String LoadUnames(String uname) {
        TreeSet ts = new TreeSet();
        String value = "";
        Criteria cri = DB_Manager.DbManager.getInstance().getSession().createCriteria(DB.User.class);
        cri.add(Restrictions.like("firstName", uname, MatchMode.START));
        List<DB.User> us = cri.list();
        for (DB.User u : us) {
            if (!u.getUsertype().getTypeName().equals("Admin")) {
                String name = u.getFirstName() + " " + u.getLastName();
                ts.add(name);
            }
        }
        Iterator it = ts.iterator();
        while (it.hasNext()) {
            value += "<option>" + it.next().toString() + "</option>";
        }
        return value;
    }

    public String loadEmails(String email) {
        String value = "";
        Criteria c6 = DB_Manager.DbManager.getInstance().getSession().createCriteria(DB.Login.class);
        c6.add(Restrictions.like("email", email, MatchMode.START));
        c6.addOrder(Order.asc("loginId"));
        List<DB.Login> lg = c6.list();
        for (DB.Login log : lg) {
            if (!log.getUser().getUsertype().getTypeName().equals("Admin")) {
                value += "<option>" + log.getEmail() + "</option>";
            }
        }
        return value;
    }
}
