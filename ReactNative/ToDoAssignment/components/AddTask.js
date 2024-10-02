import { TextInput, Button } from "react-native-paper";
import { View } from "react-native";
import React, { useState } from "react";
import Row from "./Row";
import styles from "../styles/Styles";

const AddTask = ({ onAddTask }) => {
    const [task, setTask] = useState("");

    const handleAddTask = () => {
        if (task) {
            onAddTask(task);
            setTask('');
        }
    };

    return (
        <Row style={styles.inputContainer}>
            <TextInput
                label="Add a task"
                value={task}
                onChangeText={setTask}
                style={styles.addTextInput}
            />
            <Button mode="contained" onPress={handleAddTask} style={styles.addButton}>
                Save
            </Button>
        </Row>
    );
};

export default AddTask;
