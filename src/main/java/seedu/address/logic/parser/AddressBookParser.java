package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.AddAssignmentCommand;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FilterCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.GradeAssignmentCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.MarkAllAttendanceCommand;
import seedu.address.logic.commands.MarkAllParticipationCommand;
import seedu.address.logic.commands.MarkAttendanceCommand;
import seedu.address.logic.commands.MarkParticipationCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.RemoveAssignmentCommand;
import seedu.address.logic.commands.RemoveTagCommand;
import seedu.address.logic.commands.RemoveTagFromAllCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.logic.commands.UnmarkAllAttendanceCommand;
import seedu.address.logic.commands.UnmarkAllParticipationCommand;
import seedu.address.logic.commands.UnmarkAttendanceCommand;
import seedu.address.logic.commands.UnmarkParticipationCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");
    private static final Logger logger = LogsCenter.getLogger(AddressBookParser.class);

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        // Note to developers: Change the log level in config.json to enable lower level (i.e., FINE, FINER and lower)
        // log messages such as the one below.
        // Lower level log messages are used sparingly to minimize noise in the code.
        logger.fine("Command word: " + commandWord + "; Arguments: " + arguments);

        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case UndoCommand.COMMAND_WORD:
            return new UndoCommand();

        case MarkAllAttendanceCommand.COMMAND_WORD:
            return new MarkAllAttendanceCommandParser().parse(arguments);

        case MarkAllParticipationCommand.COMMAND_WORD:
            return new MarkAllParticipationCommandParser().parse(arguments);

        case MarkParticipationCommand.COMMAND_WORD:
            return new MarkParticipationCommandParser().parse(arguments);

        case MarkAttendanceCommand.COMMAND_WORD:
            return new MarkAttendanceCommandParser().parse(arguments);

        case FilterCommand.COMMAND_WORD:
            return new FilterCommandParser().parse(arguments);

        case RemoveTagCommand.COMMAND_WORD:
            return new RemoveTagCommandParser().parse(arguments);

        case RedoCommand.COMMAND_WORD:
            return new RedoCommand();

        case RemoveTagFromAllCommand.COMMAND_WORD:
            return new RemoveTagFromAllCommandParser().parse(arguments);

        case UnmarkAttendanceCommand.COMMAND_WORD:
            return new UnmarkAttendanceCommandParser().parse(arguments);

        case UnmarkParticipationCommand.COMMAND_WORD:
            return new UnmarkParticipationCommandParser().parse(arguments);

        case AddAssignmentCommand.COMMAND_WORD:
            return new AddAssignmentCommandParser().parse(arguments);

        case RemoveAssignmentCommand.COMMAND_WORD:
            return new RemoveAssignmentCommandParser().parse(arguments);

        case GradeAssignmentCommand.COMMAND_WORD:
            return new GradeAssignmentCommandParser().parse(arguments);

        case UnmarkAllAttendanceCommand.COMMAND_WORD:
            return new UnmarkAllAttendanceCommandParser().parse(arguments);

        case UnmarkAllParticipationCommand.COMMAND_WORD:
            return new UnmarkAllParticipationCommandParser().parse(arguments);

        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
