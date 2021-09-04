/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optional_BS;

/**
 *
 * @author nthah
 */
public class NullException extends Exception {
    private String messageError;
    
    public NullException(String s) {
        messageError = s;
    }
    
    public String getMessage(){
        return messageError;
    }
}
