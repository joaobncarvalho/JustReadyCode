package pt.iade.JustReady.models.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String id, String emltype, String idname){
        super(emltype + "with" + idname + id + "already exist");
    }
    
}
