package echobot.command;

import echobot.exception.EchoBotException;
import echobot.task.Task;

public class MarkCommand extends Command {
    public final static String COMMAND = "mark";
    private final CommandType commandType = CommandType.MARK;

    private final int index;

    public MarkCommand(int index) {
        this.index = index - 1;
    }

    @Override
    public CommandResponse execute() throws EchoBotException {
        Task task = taskList.markTaskByIndex(this.index);
        String response = "Nice! I've marked this task as done:\n\t\t\t\t" + task;
        fileManagement.save();
        return new CommandResponse(this.commandType, response);
    }
}
