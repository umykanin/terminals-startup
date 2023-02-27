package pl.br;

public enum Commands {
    FIREFOX("" +
            "xdotool set_desktop 2 && " +
            "firefox &"),
    MC("" +
            "xdotool set_desktop 4 && " +
            "gnome-terminal --geometry=118x58+960+0 -- bash -c mc &&  " +
            "sleep 2s"),
    FIRST_TERM("" +
            "xdotool set_desktop 0 && " +
            "hyper && " +
            "sleep 4s && " +
            "windowID=$(xdotool getactivewindow) && " +
            "xdotool windowsize $windowID 960 526 " +
            "&& xdotool windowmove ${windowID} 960 0"),
    SECOND_TERM("" +
            "hyper && " +
            "sleep 4s && " +
            "windowID=$(xdotool getactivewindow) && " +
            "xdotool windowsize $windowID 960 526 && " +
            "xdotool windowmove ${windowID} 960 525"),
    THIRD_TERM("" +
            "hyper && " +
            "sleep 4s && " +
            "windowID=$(xdotool getactivewindow) && " +
            "xdotool windowsize $windowID 960 1053 && " +
            "xdotool windowmove ${windowID} 0 0");

    private final String command;

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
