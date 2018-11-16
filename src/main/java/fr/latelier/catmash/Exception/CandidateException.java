package fr.latelier.catmash.Exception;

public class CandidateException extends RuntimeException{

    public CandidateException() {
    }

    public CandidateException(String message) {
        super(message);
    }

    public CandidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public CandidateException(Throwable cause) {
        super(cause);
    }

    public CandidateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
