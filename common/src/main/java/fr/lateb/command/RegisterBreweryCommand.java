package fr.lateb.command;

import lombok.NonNull;
import lombok.Value;
import org.eclipse.sisu.Nullable;

@Value
public class RegisterBreweryCommand {
    @NonNull
    public String name;

    @NonNull
    public String country;

    @Nullable
    public String description;
}
