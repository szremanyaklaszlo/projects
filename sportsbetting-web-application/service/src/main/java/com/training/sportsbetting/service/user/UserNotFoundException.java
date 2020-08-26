package com.training.sportsbetting.service.user;

public class UserNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -669979687973776469L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String string) {
        super(string);
    }

}
