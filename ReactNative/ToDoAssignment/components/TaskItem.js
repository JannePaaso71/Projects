import { Text, TouchableOpacity } from "react-native";
import React from "react";
import styles from "../styles/Styles";

const TaskItem = ({ task, onToggleCompletion }) => (
    <TouchableOpacity onPress={() => onToggleCompletion(task.id)}>
        <Text style={[styles.taskText, task.completed && styles.completedTask]}>
            {task.task}
        </Text>
    </TouchableOpacity>
);

export default TaskItem;
