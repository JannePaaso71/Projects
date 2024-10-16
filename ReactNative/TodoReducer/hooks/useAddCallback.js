import {useCallback} from "react";


export default function useAddCallback(dispatch) {
    const add = useCallback((description) => {
        const newTodo = {id: Date.now().toString(), description, completed: false};
        dispatch({type: "ADD", payload: newTodo});
    }, [dispatch]);

    return add;
}