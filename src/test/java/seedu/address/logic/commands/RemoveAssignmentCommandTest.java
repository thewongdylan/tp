package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Assignment;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class RemoveAssignmentCommandTest {
    private static final Assignment ASSIGNMENT_STUB1 = new Assignment("SomeAssignment");
    private static final Assignment ASSIGNMENT_STUB3 = new Assignment("AnotherAssignment444");

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_removeAssignment_success() {
        Set<Assignment> assignments = new HashSet<>();
        assignments.add(ASSIGNMENT_STUB1);
        Person firstPerson = model.getFilteredPersonList().get(0);
        Person originalPerson = new PersonBuilder(firstPerson).withAssignments(new HashSet<>(assignments)).build();
        model.setPerson(firstPerson, originalPerson);
        Set<Assignment> newAssignments = new HashSet<>();
        newAssignments.add(ASSIGNMENT_STUB1);
        newAssignments.add(ASSIGNMENT_STUB3);
        Person editedPerson = new PersonBuilder(firstPerson).withAssignments(new HashSet<>(newAssignments)).build();
        RemoveAssignmentCommand removeAssignmentCommand = new RemoveAssignmentCommand(assignments);

        String expectedMessage = String.format(RemoveAssignmentCommand.MESSAGE_SUCCESS, assignments);
        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.setPerson(firstPerson, editedPerson);
        assertCommandSuccess(removeAssignmentCommand, model, expectedMessage, expectedModel);
    }

}
