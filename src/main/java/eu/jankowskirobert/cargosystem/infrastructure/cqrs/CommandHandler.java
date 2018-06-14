package eu.jankowskirobert.cargosystem.infrastructure.cqrs;

public interface CommandHandler <Command, Return> {
    Return handle(Command command);
}
