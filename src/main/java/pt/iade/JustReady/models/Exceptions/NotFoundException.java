package pt.iade.JustReady.models.Exceptions;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5405519104069955535L;
    
    
    public NotFoundException(String id, String elemType, String idName){
        super(elemType + "with" + idName + " " + id + "not found. ");
    }

    
}
