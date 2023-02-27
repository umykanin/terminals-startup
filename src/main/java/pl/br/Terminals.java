package pl.br;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Execute this app while system starts
 * It starts firefox, midnight commander
 * and three windows of hyper terminal with specific position and size
 */
public class Terminals {

    private static final Runtime runtime = Runtime.getRuntime();

    public static void main(String[] args) {

        Commands[] commands = Commands.values();
        List<String[]> commandsStr = Arrays.stream(commands)
                .map(Commands::getCommand)
                .map(command -> new String[]{"sh", "-c", command})
                .toList();

        executeCommand(commandsStr);
    }

    private static void executeCommand(List<String[]> commands) {
        commands.forEach(command -> {
            try {
                runtime.exec(command).waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
