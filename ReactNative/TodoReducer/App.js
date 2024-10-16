import {SafeAreaView} from 'react-native';
import Header from "./components/Header";
import styles from "./styles/Styles";
import Search from "./components/Search";
import AddTodos from "./components/AddTodos";
import TodosFlatList from "./components/TodosFlatList";
import React, {useState, useReducer} from "react";
import { todoReducer } from "./hooks/useTodoReducer";
import useAddCallback from "./hooks/useAddCallback";
import useRemoveCallback from "./hooks/useRemoveCallback";
import useFilterMemo from "./hooks/useFilterMemo";
import useToggleCallback from "./hooks/useToggleCallback";

export default function App() {
    const [todos, dispatch] = useReducer(todoReducer, []);
    const [search, setSearch] = useState("");
    const add = useAddCallback(dispatch);
    const toggle = useToggleCallback(dispatch);
    const remove = useRemoveCallback(dispatch);
    const items = useFilterMemo(todos, search);

  return (
    <SafeAreaView style={styles.appContainer}>
        <Header />
        <Search search={search} setSearch={setSearch} />
        <AddTodos add={add} />
        <TodosFlatList todos={items} toggle={toggle} remove={remove}/>
    </SafeAreaView>
  );
}
