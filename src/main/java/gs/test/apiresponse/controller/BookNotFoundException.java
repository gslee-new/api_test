package gs.test.apiresponse.controller;

public class BookNotFoundException extends RuntimeException{
    private String id;

    public BookNotFoundException(String id) {
        this.id = id;
    }

}
