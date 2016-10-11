package com.blogspot.cmf.android.dagger.commands;

/**
 * Implement this class to enqueue a task, decoupling the invoker from the receiver of the action.
 * Created by moracl6 on 10/6/2016.
 */

public interface Command<Arguments> {
    /**
     * Arguments to pass to the command. This will let us separate the command (behaviour) from the data to use in the command.
     * @param arguments Data to use in the command execution.
     */
    void execute(Arguments arguments);
}
