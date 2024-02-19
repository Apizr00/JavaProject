package Lesson9.Assignment1.Question15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RecipeBookApp extends JFrame {

    private DefaultListModel<String> recipeListModel;
    private JList<String> recipeList;
    private JTextArea recipeTextArea;
    private JTextField nameTextField;
    private JTextField ingredientTextField;

    public RecipeBookApp() {
        // Initialize JFrame
        super("Recipe Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Initialize components
        recipeListModel = new DefaultListModel<>();
        recipeList = new JList<>(recipeListModel);
        recipeTextArea = new JTextArea();
        nameTextField = new JTextField();
        ingredientTextField = new JTextField();
        JButton addButton = new JButton("Add Recipe");
        JButton editButton = new JButton("Edit Recipe");
        JButton deleteButton = new JButton("Delete Recipe");
        JButton searchButton = new JButton("Search");

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to panels
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(new JScrollPane(recipeList), BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(new JScrollPane(recipeTextArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameTextField);
        inputPanel.add(new JLabel("Ingredient:"));
        inputPanel.add(ingredientTextField);
        inputPanel.add(addButton);
        inputPanel.add(searchButton);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        rightPanel.add(inputPanel, BorderLayout.NORTH);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add panels to the main frame
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                addRecipe();
            }
        });

        editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                editRecipe();
            }
        });

        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                deleteRecipe();
            }
        });

        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                searchRecipe();
            }
        });

        recipeList.addListSelectionListener(e -> displayRecipeDetails());

        // Load recipes from the database
        loadRecipes();
    }

    private void addRecipe() {

        String name = nameTextField.getText().trim();
        String ingredient = ingredientTextField.getText().trim();

        if (name.isEmpty() || ingredient.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Name and Ingredient cannot be empty.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:recipes.db");
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO recipes (name, ingredient) VALUES (?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, ingredient);
            statement.executeUpdate();

            loadRecipes();
            clearInputFields();

        } catch (SQLException ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding recipe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editRecipe() {

        int selectedIndex = recipeList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select a recipe to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String name = nameTextField.getText().trim();
        String ingredient = ingredientTextField.getText().trim();

        if (name.isEmpty() || ingredient.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Name and Ingredient cannot be empty.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:recipes.db");
                PreparedStatement statement = connection
                        .prepareStatement("UPDATE recipes SET name=?, ingredient=? WHERE id=?")) {
            statement.setString(1, name);
            statement.setString(2, ingredient);
            statement.setInt(3, selectedIndex + 1); // SQLite indices start from 1

            statement.executeUpdate();

            loadRecipes();
            clearInputFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error editing recipe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteRecipe() {
        int selectedIndex = recipeList.getSelectedIndex();

        if (selectedIndex == -1) {

            JOptionPane.showMessageDialog(this, "Select a recipe to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this recipe?",
                "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {

            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:recipes.db");
                PreparedStatement statement = connection.prepareStatement("DELETE FROM recipes WHERE id=?")) {
            statement.setInt(1, selectedIndex + 1); // SQLite indices start from 1

            statement.executeUpdate();

            loadRecipes();
            clearInputFields();

        } catch (SQLException ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting recipe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchRecipe() {

        String searchTerm = nameTextField.getText().trim();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:recipes.db");
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM recipes WHERE name LIKE ?")) {
            statement.setString(1, "%" + searchTerm + "%");

            ResultSet resultSet = statement.executeQuery();

            recipeListModel.clear();

            while (resultSet.next()) {

                String recipeName = resultSet.getString("name");
                recipeListModel.addElement(recipeName);
            }

            clearInputFields();

        } catch (SQLException ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching for recipes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayRecipeDetails() {

        int selectedIndex = recipeList.getSelectedIndex();

        if (selectedIndex != -1) {

            try (Connection connection = DriverManager.getConnection("jdbc:sqlite:recipes.db");
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM recipes WHERE id=?")) {
                statement.setInt(1, selectedIndex + 1); // SQLite indices start from 1

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {

                    String recipeName = resultSet.getString("name");
                    String recipeIngredient = resultSet.getString("ingredient");
                    recipeTextArea.setText("Name: " + recipeName + "\n\nIngredient: " + recipeIngredient);
                }
            } catch (SQLException ex) {

                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error retrieving recipe details.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadRecipes() {

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:recipes.db");
                Statement statement = connection.createStatement()) {
            statement
                    .execute("CREATE TABLE IF NOT EXISTS recipes (id INTEGER PRIMARY KEY, name TEXT, ingredient TEXT)");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM recipes");

            recipeListModel.clear();

            while (resultSet.next()) {

                String recipeName = resultSet.getString("name");
                recipeListModel.addElement(recipeName);
            }

            clearInputFields();

        } catch (SQLException ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading recipes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearInputFields() {

        nameTextField.setText("");
        ingredientTextField.setText("");
        recipeTextArea.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            try {
                // Set the Look and Feel to the system's default
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | UnsupportedLookAndFeelException e) {

                e.printStackTrace();
            }

            new RecipeBookApp().setVisible(true);
        });
    }
}
