package Project;

public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {		//used to get username
        return name;
    }

    public char getSymbol() {		//used to get symbol
        return symbol;
    }
}
