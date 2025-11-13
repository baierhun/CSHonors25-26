public class SocialNetwork {
    /*
         * You are building part of a backend for a social network.
         *
         * The Big Picture
         *
         * Each User should be able to:
         * Keep track of their friends (ArrayList or LinkedList)
         * Store their message history (LinkedList)
         * Have an inbox of new messages (Queue)
         * Be able to undo their last action (Stack)
         * The User class represents a single user in a simple messaging app.
         *
         * Each user has:
         * - A name (String)
         * - A list of friends (ArrayList or LinkedList)
         * - An inbox for unread messages (Queue)
         * - A message history of read messages (LinkedList)
         * - An undo stack to reverse recent actions (Stack)
         *
         * You will write methods to add friends, send/receive messages,
         * read messages, undo actions, and print user info.
         *
         * In main()
         * Create a HashMap<String, User> to store multiple users.
         * Add a few users, have them add friends and send messages to one another, then test reading and undoing actions.
     */

    class User {
        /**
         * Constructs a new User with the given name and
         * initializes all data structures.
         *
         * @param name the name of the user
         */
        public User(String name){}

        /**
         * Adds a friend to this user's friends list.
         * Should also push an "undo" action onto the stack.
         *
         * @param friendName the name of the friend to add
         */
        public void addFriend(String friendName){}

        /**
         * Receives a new message and adds it to the inbox queue.
         *
         * @param message the message to add
         */
        public void receiveMessage(String message){}

        /**
         * Reads the next message from the inbox queue.
         * Moves it to the message history list.
         * If there are no messages, print a message saying so.
         */
        public void readMessage(){}

        /**
         * Undoes the most recent action stored in the undo stack.
         * For example, if the last action was adding a friend,
         * remove that friend from the list.
         */
        public void undoLastAction(){}

        /**
         * Prints this user's name, their list of friends,
         * and all messages in their history.
         */
        public void printStatus(){}
    }
}
