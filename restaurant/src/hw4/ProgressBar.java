package hw4;

/**
 * The ProgressBar class represents a progress bar that can be used to track the progress of a task.
 * It provides methods to update the progress and print the progress bar.
 */
public class ProgressBar {
    // The total number of steps in the task.
    private final int total;
    // The current step in the task.
    private int step;

    /**
     * Constructs a new ProgressBar object with the specified total number of steps.
     * @param total The total number of steps in the task.
     */
    public ProgressBar(int total) {
        this.total = total;
        this.step = 0;
    }

    /**
     * Updates the progress of the task by one step and prints the progress bar.
     */
    public void update() {
        this.step++;
        printProgressBar();
    }

    /**
     * Prints the progress bar.
     * The progress bar is a string of characters that represents the percentage of the task that has been completed.
     * Each "=" character represents 2% of the task, and each " " character represents 2% of the task that has not been completed.
     * The progress bar is enclosed in square brackets and followed by the percentage of the task that has been completed.
     */
    private void printProgressBar() {
        StringBuilder bar = new StringBuilder("[");

        int percentage = (step * 100) / total;
        for (int i = 0; i < 100; i += 2) {  // Each = represents 2%
            if (i < percentage) {
                bar.append("=");
            } else {
                bar.append(" ");
            }
        }
        bar.append("] ");
        bar.append(percentage).append("%");

        System.out.print("\r");  // Return to the start of the line
        System.out.print(bar);
    }
}