package by.mrbregovich.builder;

public class BuilderFactory {
    private static final String USER = "user";
    private static final String PERSON = "person";

    public static Builder create(String builderName){

        switch (builderName) {
            case USER:
                return new UserBuilder();
            case PERSON:
                return new PersonBuilder();
            default:
                throw new IllegalArgumentException("Unknown builder name!");
        }
    }

}
