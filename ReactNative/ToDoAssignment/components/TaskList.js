import { FlatList, View } from "react-native";
import React from "react";
import TaskItem from "./TaskItem";
import styles from "../styles/Styles";

const TaskList = ({ tasks, onToggleCompletion }) => (
    <View style={styles.taskList}>
        <FlatList
            data={tasks}
            keyExtractor={(item) => item.id.toString()}
            renderItem={({ item }) => (
                <TaskItem task={item} onToggleCompletion={onToggleCompletion} />
            )}
        />
    </View>
);

export default TaskList;
