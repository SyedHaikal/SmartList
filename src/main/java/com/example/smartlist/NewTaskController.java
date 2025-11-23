package com.example.smartlist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NewTaskController {
    @FXML
    private TextField fieldTitle;
    @FXML
    private TextField fieldDesc;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox<String> categoryBox;
    @FXML
    private ComboBox<String> priorityBox;
    @FXML
    private Button saveButton;

    private final String FILE_PATH = "tasks.json";

    @FXML
    public void initialize() {
        if(categoryBox != null) categoryBox.getItems().addAll("School", "Personal");
        if(priorityBox != null) priorityBox.getItems().addAll("High", "Medium", "Low");
    }

    @FXML
    public void buttonSave(){
        String title = fieldTitle.getText();
        String description = fieldDesc.getText();

        if(title.isEmpty()){
            return;
        }

        ToDo newTask = new ToDo(title, description, datePicker.getValue(), categoryBox.getValue(), priorityBox.getValue() );

        List<ToDo>allTasks = loadCurrentTasks();
        allTasks.add(newTask);
        saveAllTasks(allTasks);

        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();

    }

    private List<ToDo> loadCurrentTasks() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>(); // Return empty list if file doesn't exist
        try (Reader reader = new FileReader(file)) {
            // Read JSON file into a List of ToDo objects
            return new Gson().fromJson(reader, new TypeToken<List<ToDo>>(){}.getType());
        } catch (IOException e) { e.printStackTrace();
            return new ArrayList<>(); }
    }

    private void saveAllTasks(List<ToDo> tasks){
        try(Writer writer = new FileWriter(FILE_PATH)){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(tasks, writer);
        }catch(IOException e) { e.printStackTrace(); }
    }
}
