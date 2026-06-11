package uy.edu.ort.obligatorioDA.presentadores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commands {
    private List<Command> commands = new ArrayList<>();

    private Commands() {
    }

    public static Commands create(Command... cmds) {
        Commands c = new Commands();
        c.commands.addAll(Arrays.asList(cmds));
        return c;
    }

    public Commands add(Command cmd) {
        commands.add(cmd);
        return this;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

}
