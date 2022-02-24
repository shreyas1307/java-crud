package com.shreyas.javacrud.user;

import java.util.function.Function;

import static com.shreyas.javacrud.user.UserValidator.*;
import static com.shreyas.javacrud.user.UserValidator.ValidationResult.*;

@FunctionalInterface
public interface UserValidator extends Function<User, ValidationResult> {

    static UserValidator isNameValid() {
        return user -> user.getName().length() > 0 ? SUCCESS : NAME_NOT_VALID;
    }

    static UserValidator isEmailValid() {
        return user -> user.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
    }

    static UserValidator isPhoneNumberValid() {
        return user -> user.getPhoneNumber().startsWith("+") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    default UserValidator and (UserValidator other) {
        return user -> {
            ValidationResult result = this.apply(user);
            return result.equals(SUCCESS) ? other.apply(user) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        NAME_NOT_VALID,
        EMAIL_NOT_VALID,
        PHONE_NUMBER_NOT_VALID,
    }
}
