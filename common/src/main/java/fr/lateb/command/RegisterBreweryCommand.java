package fr.lateb.command;

import lombok.NonNull;
import lombok.Value;

@Value
public class RegisterBreweryCommand {
    @NonNull
    public String name;

    @NonNull
    public String country;

    public String description;
}
