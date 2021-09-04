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
public class User {
    private Address address;
    private String name;
  
    public Address getAddress(){
        return this.address;
    }
    
//    public Optional<Address> getAddress(){
//        return Optional.empty();
//    }

    public User(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    public User() {
    }

    

    
}
