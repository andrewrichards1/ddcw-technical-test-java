package forms;

import play.data.validation.Constraints;

/**
 * A form processing DTO that maps to the widget form.
 *
 * Using a class specifically for form binding reduces the chances
 * of a parameter tampering attack and makes code clearer, because
 * you can define constraints against the class.
 */
public class MessageInputForm {

    @Constraints.Required
    private String message;

    public MessageInputForm() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
