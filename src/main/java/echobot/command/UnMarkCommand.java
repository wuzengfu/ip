package echobot.command;

import echobot.exception.EchoBotException;
import echobot.task.Task;

public class UnMarkCommand extends Command {
    public final static String COMMAND = "unmark";
    private final int index;
    private final CommandType commandType = CommandType.MARK;

    public UnMarkCommand(int index) {
        this.index = index - 1;
    }

    @Override
    public CommandResponse execute() throws EchoBotException {
        Task task = taskList.unmarkTaskByIndex(this.index);
        String response = "Nice! I've marked this task as not done yet:\n\t\t\t\t" + task;
        fileManagement.save();
        return new CommandResponse(this.commandType, response);
    }
}
