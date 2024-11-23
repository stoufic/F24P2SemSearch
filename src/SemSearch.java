/**
 * The Class SemSearch.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class SemSearch {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        if (args == null || args.length < 2) {
            System.out.println(
                "Usage: java SemSearch <worldSize> <commandFile>");
            return;
        }

        try {
            int worldSize = Integer.parseInt(args[0]);
            if (worldSize <= 0 || (worldSize & (worldSize - 1)) != 0) {
                System.out.println(
                    "World size must be a positive power of two.");
                return;
            }

            Controller controller = new Controller(worldSize);
            CommandProcessor commandProcessor = new CommandProcessor(args[1],
                controller);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid number format for worldSize. "
                + "Please provide an integer.");
        }
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
