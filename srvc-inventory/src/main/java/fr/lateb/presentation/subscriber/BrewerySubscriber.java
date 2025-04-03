package fr.lateb.presentation.subscriber;

import fr.lateb.command.RegisterBreweryCommand;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class BrewerySubscriber {
    @Incoming("RegisterBreweryCommand")
    public void registerBreweryCommand(RegisterBreweryCommand command)
    {

    }

    @Incoming("UnregisterBreweryCommand")
    public void unregisterBreweryCommand(String name)
    {

    }
}
