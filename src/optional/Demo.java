/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Quach Thao
 */
public class Demo {

    static List<Student> list = new ArrayList<>();

    public static Student findById(String id) {
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Student st = (Student) itr.next();
            if (st.getId().equals(id)) {
                return st;
            }
        }

        return null;

    }
    

    public static void main(String[] args) {

        Student st1 = new Student("001", "Lan");
        Student st2 = new Student("002", "Hoa");
        Student st3 = new Student("006", null);

        list.add(st1);
        list.add(st2);
        list.add(st3);
        Student st = findById("007");
        //Student st = findById("001");
        //System.out.println(st.getName());
        // cách xử lý thông thường
        //if (person != null) {
        //   System.out.println(person.getName());
        //}
        // cách xử lý với Optional Class
        // dùng ofNullable vì đối student có thể null
        Optional<Student> optionalUser = Optional.ofNullable(st);
        // ifPresent: kiểm tra đối tượng bên trong optional có khác null không

        System.out.println(optionalUser.isPresent());

        if (optionalUser.isPresent()) {
            System.out.println("value: " + st.getName());
        } else {
            System.out.println("empty");
        }
        System.out.println("su dung ifPresent");
        optionalUser.ifPresent(value -> {
            System.out.println("Value found - " + value.getName());
        });

        //orElse
        System.out.println("su dung orElse");
        Student sc = optionalUser.orElse(new Student("0", "Unknown"));
        System.out.println(sc);
        //orElseGet
        System.out.println("su dung orElseGet");
        Student finalUser = optionalUser.orElseGet(() -> {
            return new Student("0", "Unknown");
        });
        System.out.println(finalUser);
        //orElseThrow dua ra mot ngoai le khong co gia tri
        //loc cac gia tri bang phuong thuc filter
        //if(st != null && st.getId().equalsIgnoreCase("001")) {
        // call a function
        System.out.println("loc bang filter");
        optionalUser.filter(per -> per.getId().equalsIgnoreCase("006"));
        //trich xuat va chuyen doi gia tri bang map        
    
}

}
