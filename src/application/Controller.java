package application;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Controller {

    @FXML
    private Circle player;

    @FXML
    private GridPane mazeGrid;

    @FXML
    public void initialize() {
        mazeGrid.setFocusTraversable(true);
        mazeGrid.setOnKeyPressed(this::handleKeyPress);
        //mazeGrid.requestFocus();
    }

    private void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                movePlayer(0, -1); // Move up
                break;
            case S:
                movePlayer(0, 1); // Move down
                break;
            case A:
                movePlayer(-1, 0); // Move left
                break;
            case D:
                movePlayer(1, 0); // Move right
                break;
            default:
                break;
        }
        printPlayerGridIndex();
    }

    private void movePlayer(int newX, int newY) {
        int currentCol = GridPane.getColumnIndex(player);
        int currentRow = GridPane.getRowIndex(player);

        // Calculate new position
        int newCol = currentCol + newX;
        int newRow = currentRow + newY;

        // Check for boundaries (for example, check for valid grid bounds)
        if (newCol >= 0 && newRow >= 0) {
            // Check if the new position contains a wall (rectangle)
            if (!isWall(newCol, newRow)) {
                // Move the player
                GridPane.setColumnIndex(player, newCol);
                GridPane.setRowIndex(player, newRow);
            } else {
                System.out.println("Cannot move to cell: (" + newCol + ", " + newRow + ") - it's a wall!");
            }
        }
    }

 // Check if the specified tile contains a wall (rectangle)
    private boolean isWall(int columnIndex, int rowIndex) {
        for (javafx.scene.Node node : mazeGrid.getChildren()) {
            Integer colIndex = GridPane.getColumnIndex(node);
            Integer rowIndexNode = GridPane.getRowIndex(node);

            // Check if both indices are not null and match the target indices
            if (colIndex != null && rowIndexNode != null && colIndex == columnIndex && rowIndexNode == rowIndex) {
                if (node instanceof Rectangle) {
                    return true; // Tile is a wall
                }
            }
        }
        return false; // Tile is not a wall
    }


    private int[] getPlayerGridIndex() {
        int colIndex = GridPane.getColumnIndex(player);
        int rowIndex = GridPane.getRowIndex(player);

        return new int[]{colIndex, rowIndex};
    }

    private void printPlayerGridIndex() {
        int[] playerIndex = getPlayerGridIndex();
        System.out.println("Player is in cell: (" + playerIndex[0] + ", " + playerIndex[1] + ")");
    }
}
