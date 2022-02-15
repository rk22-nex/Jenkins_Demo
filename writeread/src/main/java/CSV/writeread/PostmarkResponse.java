package CSV.writeread;

import org.joda.time.DateTime;

import com.google.gson.annotations.SerializedName;


public class PostmarkResponse {
	 // The status outcome of the response.
    @SerializedName("Status")
    public PostmarkStatus status;

    // The message from the API.
    // In the event of an error, this message may contain helpful text.
    @SerializedName("Message")
    public String message;

    // The time the request was received by Postmark.
    @SerializedName("SubmittedAt")
    public DateTime submittedAt;

    // The recipient of the submitted request.
    @SerializedName("To")
    public String to;

    // The error code returned from Postmark.
    // This does not map to HTTP status codes.
    @SerializedName("ErrorCode")
    public int errorCode;

    public PostmarkStatus getStatus() {
        return status;
    }

    public void setStatus(PostmarkStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(DateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}
