package africa.semicolon.mogbo.exceptions;

public class UserDoesNotExistException extends MogboException{
    public UserDoesNotExistException(String message){
        super(message);
    }
}
