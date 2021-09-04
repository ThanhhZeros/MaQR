/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optional_BS;

import java.util.Optional;

/**
 *
 * @author nthah
 */
public class JavaOptional_ThuyetTrinh {
    
    public static void main(String args[]) {
      try{
          Integer value1 = null;
          Integer value2 = new Integer(10);
          
          // Optional.ofNullable - cho phép truyền vào giá trị null.
          Optional<Integer> a = Optional.ofNullable(value1);
          
          // Optional.of - ném ra lỗi NullPointerException nếu giá trị truyền vào bằng null
          Optional<Integer> b = Optional.of(value2);
          //Optional<Integer> b = Optional.of(value1);
          
          //Phương thức get()
//          System.out.println("Phương thức get() - a = " + a.get());
          System.out.println("Phương thức get() - b = " + b.get());
          
          // Kiểm tra một đối tượng có rỗng hay không? Nếu không rỗng thì thực hiện thao tác với đối tượng, rỗng thì k làm gì 
          a.ifPresent(x->System.out.println(x));
          b.ifPresent(x->System.out.println(x));
          
        //Phương thức filter()
          b.filter(x -> x>5).ifPresent(t -> System.out.println("Phương thức filter() - b = " +t));
          a.filter(x -> x>5).ifPresent(t -> System.out.println("Phương thức filter() - a = " +t));
          
        // Phương thức ifPresent()
        // a rỗng -> không làm gì
        a.ifPresent(x -> System.out.println("Phương thức ifPresent() - b = " + x));
        // b không rỗng -> true
        b.ifPresent(x -> System.out.println("Phương thức ifPresent() - " + x));
        
        // Phương thức isPresent()
        // a rỗng -> false
        System.out.println("Phương thức ifPresent() - a = " + a.isPresent());
        // b không rỗng -> true
        System.out.println("Phương thức ifPresent() - b = " + b.isPresent());
        
        // Phương thức orElse()
        // Đặt 5 làm giá trị default => a rỗng nên nhận giá trị 5, b không rỗng nên giữ giá trị của mình
        System.out.println("Phương thức orElse() - a = " + a.orElse(5));
        System.out.println("Phương thức orElse() - b = " + b.orElse(5));
          
        
        
        //Phương thức orElseGet()
        //Giống như phương thức orElse() nhưng giá trị default trả về lấy từ Functional Interface Supplier
        System.out.println("Phương thức orElseGet() - a = "+(a.orElseGet(() -> 15)));//Đặt 15 làm giá trị default
        System.out.println("Phương thức orElseGet() - a = "+(b.orElseGet(() -> 15)));
          
        // Phương thức orElseThrow()
        // b có giá trị -> trả về đúng giá trị
        System.out.println("Phương thức orElseThrow() - b = "+b.orElseThrow(()-> new NullException("Rỗng")));
        // a rỗng => ném ra Exception
        //System.out.println("Phương thức orElseThrow() - a = "+a.orElseThrow(()-> new NullException("Rỗng")));
        
        System.out.println("Tổng a + b = " + sum(a, b));
        }catch(NullException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        };
    }
    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
      // Optional.orElse - trả về 1 giá trị khác, nếu giá trị trong optional class bằng null
      // Trả về 0 nếu giá trị trong option class a = null
      Integer value1 = a.orElse(new Integer(0));
      
      // Optional.get - trả về giá trị bên trong optional class
      Integer value2 = b.get();
      return value1 + value2;
    }
}
