package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.application.Application;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Application> PREDICATE_SHOW_ALL_APPLICATIONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' InternApply's memory file path.
     */
    Path getInternApplyMemoryFilePath();

    /**
     * Sets the user prefs' InternApply's memory file path.
     */
    void setInternApplyMemoryFilePath(Path internApplyMemoryFilePath);

    /**
     * Replaces InternApply's memory data with the data in {@code internApplyMemory}.
     */
    void setInternApplyMemory(ReadOnlyInternApplyMemory internApplyMemory);

    /** Returns the InternApplyMemory */
    ReadOnlyInternApplyMemory getInternApplyMemory();

    /**
     * Returns true if an application with the same identity as {@code application} exists in InternApply's memory.
     */
    boolean hasApplication(Application application);

    /**
     * Deletes the given application.
     * The application must exist in InternApply's memory.
     */
    void deleteApplication(Application target);

    /**
     * Adds the given application.
     * {@code application} must not already exist in InternApply's memory.
     */
    void addApplication(Application application);

    /**
     * Replaces the given application {@code target} with {@code editedApplication}.
     * {@code target} must exist in InternApply's memory.
     * The application identity of {@code editedApplication} must not be the same as another existing application in
     * the address book.
     */
    void setApplication(Application target, Application editedApplication);

    /** Returns an unmodifiable view of the filtered application list */
    ObservableList<Application> getFilteredApplicationList();

    /**
     * Updates the filter of the filtered application list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredApplicationList(Predicate<Application> predicate);

    void setFilteredApplicationList(FilteredList<Application> filteredApplications);
}
