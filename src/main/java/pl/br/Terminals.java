package pl.br;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Execute this app while system starts
 * It starts firefox, midnight commander
 * and three windows of hyper terminal with specific position and size
 */
public class Terminals {

    private static final Runtime runtime = Runtime.getRuntime();

    public static void main(String[] args) {

        List<String[]> commands = new ArrayList<>();

        commands.add(new String[]{"sh", "-c", Commands.FIREFOX.getCommand()});
        commands.add(new String[]{"sh", "-c", Commands.MC.getCommand()});
        commands.add(new String[]{"sh", "-c", Commands.FIRST_TERM.getCommand()});
        commands.add(new String[]{"sh", "-c", Commands.SECOND_TERM.getCommand()});
        commands.add(new String[]{"sh", "-c", Commands.THIRD_TERM.getCommand()});

        executeCommand(commands);
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
