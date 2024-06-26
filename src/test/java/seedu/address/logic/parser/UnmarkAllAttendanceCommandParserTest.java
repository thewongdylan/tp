package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.UnmarkAllAttendanceCommand;

public class UnmarkAllAttendanceCommandParserTest {

    private UnmarkAllAttendanceCommandParser parser = new UnmarkAllAttendanceCommandParser();

    @Test
    public void parse_validArgs_returnsMarkAllCommand() {
        assertParseSuccess(parser, "3", new UnmarkAllAttendanceCommand(Index.fromZeroBased(3)));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                UnmarkAllAttendanceCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "-1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                UnmarkAllAttendanceCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                UnmarkAllAttendanceCommand.MESSAGE_USAGE));

        // Test data: More than one argument, separated by space
        assertParseFailure(parser, "1 2", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                UnmarkAllAttendanceCommand.MESSAGE_USAGE));

        // Test data: Zero as input (assuming week numbers start from 1)
        assertParseFailure(parser, "0", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                UnmarkAllAttendanceCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_emptyArgs_throwsParseException() {
        assertParseFailure(parser, "", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                UnmarkAllAttendanceCommand.MESSAGE_USAGE));
    }
}
