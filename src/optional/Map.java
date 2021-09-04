/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optional;


import java.util.Optional;


/**
 *
 * @author Quach Thao
 */
//Trích xuất và chuyển đổi các giá trị bằng map()
public class Map {

    public static void main(String[] args) {
        Address add = new Address("India");
        User user = new User(add, "Ha");
        Optional<User> optionalUser = Optional.of(user);
        Optional<Address> addressOptional = optionalUser.map(User::getAddress)
                .filter(address -> address.getStreet().equalsIgnoreCase("India"));
        if (addressOptional.isPresent()) {
            System.out.println("co thanh nien o An Do");
        } else {
            System.out.println("empty");
        }
    }
    
}
