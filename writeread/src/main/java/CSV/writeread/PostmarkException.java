package CSV.writeread;



public class PostmarkException extends Exception {

    private static final long serialVersionUID = 8742554283535762204L;

    private PostmarkResponse response;

    public PostmarkException(Throwable cause) {
        super(cause);
    }

    public PostmarkException(String message) {
        super(message);
    }

    public PostmarkException(String message, PostmarkResponse response) {
        super(message);

        this.response = response;
    }

    public PostmarkResponse getResponse()
    {
        return response;
    }
}



